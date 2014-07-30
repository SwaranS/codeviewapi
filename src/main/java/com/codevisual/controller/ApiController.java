package com.codevisual.controller;

import com.codevisual.Services.GitModelGenerator;
import com.codevisual.git.Services.GitHelper;
import com.codevisual.model.HeaderInformation;
import com.codevisual.model.GitModelList;
import com.codevisual.model.rest.MetricInformation;
import com.codevisual.model.rest.MetricInformationList;
import com.codevisual.persistence.MetricInformationRepository;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Home on 14/07/2014.
 */
@Controller
public class ApiController {

    @Autowired
    GitModelGenerator gitModelGenerator;

    @Autowired
    private MetricInformationRepository metricInformationRepository;
    @Autowired
    GitHelper gitHelper;
    @RequestMapping(value = "/urlList", method = RequestMethod.GET)
    public @ResponseBody
    GitModelList receiveUrlList(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {
        List<String> listUrls = Arrays.asList(urlList.split(","));
        List<HeaderInformation> gitModelList = new ArrayList<HeaderInformation>();
       //TODO Call git API to check latest commit
        for (int i = 0; i < listUrls.size(); i++) {
            //If Directory doesn't exist locally
            if(!(gitHelper.checkLocalDirectory(listUrls.get(i)))){
                gitHelper.gitClone(listUrls.get(i));
                //Have copied directory locally
                //Add MetricInformation to list
                gitModelList.add(gitModelGenerator.generateModel(listUrls.get(i)));

            }
            else{
                //Have copied directory locally
                //Add MetricInformation to list
                gitModelList.add(gitModelGenerator.generateModel(listUrls.get(i)));

            }
            //If exits locally and outdated
        }

        return new GitModelList(gitModelList);
    }


    @RequestMapping(value = "/metricList", method = RequestMethod.GET)
    public @ResponseBody
    MetricInformationList generateMetricList(@RequestParam(value = "metricList") String urlList) throws Exception {
        List<String> listUrls = Arrays.asList(urlList.split(","));
        List<MetricInformation> metricInformationList = new ArrayList<>();
        //TODO Call git API to check latest commit
        for (int i = 0; i < listUrls.size(); i++) {
            //If Directory doesn't exist locally
            if(!(gitHelper.checkLocalDirectory(listUrls.get(i)))){
                gitHelper.gitClone(listUrls.get(i));
                //Have copied directory locally
                //Add MetricInformation to list
                metricInformationList.add(metricInformationRepository.saveAndReturnMetricInformation(listUrls.get(i)));

            }
            else{
                return null;
                //Have copied directory locally
                //Add MetricInformation to list
                //gitModelList.add(gitModelGenerator.generateModel(listUrls.get(i)));

            }
            //If exits locally and outdated
        }

        return new MetricInformationList(metricInformationList);
    }
}
