package com.codevisual.controller;

import com.codevisual.Services.GitModelGenerator;
import com.codevisual.git.Services.GitHelper;
import com.codevisual.model.GitModel;
import com.codevisual.model.GitModelList;
import com.codevisual.model.rest.UrlList;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Home on 14/07/2014.
 */
@Controller
public class ApiController {

    @Autowired
    GitModelGenerator gitModelGenerator;

    @Autowired
    GitHelper gitHelper;
    @RequestMapping(value = "/urlList", method = RequestMethod.GET)
    public @ResponseBody
    GitModelList receiveUrlList(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {
        List<String> listUrls = Arrays.asList(urlList.split(","));
        List<GitModel> gitModelList = new ArrayList<GitModel>();
       //TODO Call git API to check latest commit
        for (int i = 0; i < listUrls.size(); i++) {
            //If Directory doesn't exist locally
            if(!(gitHelper.checkLocalDirectory(listUrls.get(i)))){
                gitHelper.gitClone(listUrls.get(i));
                gitModelList.add(gitModelGenerator.generateModel(listUrls.get(i)));

            }
            else{
                //If exists locally
                gitModelList.add(gitModelGenerator.generateModel(listUrls.get(i)));

            }
            //If exits locally and outdated
        }

        return new GitModelList(gitModelList);
    }
}
