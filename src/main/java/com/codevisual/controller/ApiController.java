package com.codevisual.controller;

import com.codevisual.Services.MetricInformationGenerator;
import com.codevisual.Services.UrlProcessing;
import com.codevisual.Services.GitHelper;
import com.codevisual.model.CommitInformation;
import com.codevisual.model.rest.MetricInformation;
import com.codevisual.model.rest.MetricInformationList;
import com.codevisual.persistence.CommitInformationRepository;
import com.codevisual.persistence.HeaderInformationRepository;
import com.codevisual.persistence.MetricInformationRepository;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 14/07/2014.
 */
@Controller
public class ApiController {


    @Autowired
    private MetricInformationGenerator metricInformationGenerator;
    @Autowired
    private MetricInformationRepository metricInformationRepository;
    @Autowired
    GitHelper gitHelper;
    @Autowired
    private HeaderInformationRepository headerInformationRepository;
    @Autowired
    private UrlProcessing urlProcessing;
    @Autowired
    private CommitInformationRepository commitInformationRepository;


    @RequestMapping(value = "/urlList", method = RequestMethod.GET)
    public
    @ResponseBody
    MetricInformationList receiveUrlList(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {

        List<String> uniqueUrlList = urlProcessing.commaSeparateUrl(urlList);
        List<MetricInformation> metricInformationList = new ArrayList<>();
        for (String uniqueUrl : uniqueUrlList) {
            if (!headerInformationRepository.recordExists(uniqueUrl)) {
                try {
                    gitHelper.gitClone(uniqueUrl);
                    metricInformationList.add(metricInformationRepository.saveAndReturnMetricInformation(uniqueUrl));
                } catch (Exception e) {
                    metricInformationList.add(null);
                    e.printStackTrace();
                }
            } else {
                try {
                    metricInformationList.add(metricInformationRepository.returnMetricInformation(uniqueUrl));
                } catch (Exception e) {
                    metricInformationList.add(null);
                    e.printStackTrace();
                }
            }

        }


        return new MetricInformationList(metricInformationList);
    }

    @RequestMapping(value = "/sortedCommitData", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CommitInformation> sortedCommitData(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {
       return commitInformationRepository.getObjectDateSorted(urlList);
    }

    }
