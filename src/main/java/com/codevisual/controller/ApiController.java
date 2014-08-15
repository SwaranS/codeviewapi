package com.codevisual.controller;

import com.codevisual.Services.ApiDataGeneratorService;
import com.codevisual.Services.GitHelper;
import com.codevisual.Services.MetricInformationGenerator;
import com.codevisual.Services.StringProcessing;
import com.codevisual.model.CommitInformation;
import com.codevisual.model.CommitInformationDifference;
import com.codevisual.model.rest.MetricInformation;
import com.codevisual.model.rest.MetricInformationList;
import com.codevisual.persistence.CommitInformationRepository;
import com.codevisual.persistence.HeaderInformationRepository;
import com.codevisual.persistence.MetricInformationRepository;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private StringProcessing stringProcessing;
    @Autowired
    private CommitInformationRepository commitInformationRepository;
    @Autowired
    private ApiDataGeneratorService apiDataGeneratorService;


    @RequestMapping(value = "/urlList", method = RequestMethod.GET)
    public
    @ResponseBody
    MetricInformationList receiveUrlList(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {

        List<String> uniqueUrlList = stringProcessing.commaSeparateUrl(urlList);
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

    @RequestMapping(value = "/finalCommitData", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CommitInformation> finalCommitData(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {
        List<CommitInformation> commitInformationList = new ArrayList<>();
        List<String> uniqueUrlList = stringProcessing.commaSeparateUrl(urlList);
        for (String uniqueUrl : uniqueUrlList) {
            commitInformationList.add(commitInformationRepository.getFinalCommitData(uniqueUrl));
        }
        return commitInformationList;
    }

    @RequestMapping(value = "/contributionsByUsers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CommitInformation> contributionsByUsers(@RequestParam(value = "urlList") String urlList, @RequestParam(value = "committerName") String committerName) throws IOException, GitAPIException {
        return apiDataGeneratorService.searchUserContributionInRepositories(urlList, committerName);

    }

    @RequestMapping(value = "/changesByUsers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CommitInformationDifference> changesByUsers(@RequestParam(value = "urlList") String urlList, @RequestParam(value = "committerName") String committerName) throws IOException, GitAPIException {
        return apiDataGeneratorService.changesByUserInRepositories(urlList, committerName);

    }



}
