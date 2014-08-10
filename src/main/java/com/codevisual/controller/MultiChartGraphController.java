package com.codevisual.controller;

import com.codevisual.Services.BarChartDataGenerator;
import com.codevisual.Services.StringProcessing;
import com.codevisual.chartServices.*;
import com.codevisual.model.display.BarChartData;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created by Home on 10/08/2014.
 */
@Controller
public class MultiChartGraphController {

    @Autowired
    private BarChartDataGenerator barChartDataGenerator;
    @Autowired
    private StringProcessing stringProcessing;
    @Autowired
    private CodeBarChartGenerator codeBarChartGenerator;
    @Autowired
    private CommentBarChartGenerator commentBarChartGenerator;
    @Autowired
    private ClassesBarChartGenerator classesBarChartGenerator;
    @Autowired
    private CyclomaticBarChartGenerator cyclomaticBarChartGenerator;
    @Autowired
    private RatioBarChartGenerator ratioBarChartGenerator;
    @Autowired
    private InteractionBarChartGenerator interactionBarChartGenerator;
    @Autowired
    private VolumeBarChartGenerator volumeBarChartGenerator;


    @RequestMapping(value = "/compareLinesOfCode", method = RequestMethod.GET)
    public
    @ResponseBody
    BarChartData compareLinesOfCode(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {
        List<String> uniqueUrlList = stringProcessing.commaSeparateUrl(urlList);
        return codeBarChartGenerator.barChartLinesOfCode(uniqueUrlList);
    }

    @RequestMapping(value = "/compareLinesOfComments", method = RequestMethod.GET)
    public
    @ResponseBody
    BarChartData compareLinesOfComments(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {
        List<String> uniqueUrlList = stringProcessing.commaSeparateUrl(urlList);
        return commentBarChartGenerator.barChartLinesOfComments(uniqueUrlList);
    }
    @RequestMapping(value = "/compareNumberOfClasses", method = RequestMethod.GET)
    public
    @ResponseBody
    BarChartData compareNumberOfClasses(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {
        List<String> uniqueUrlList = stringProcessing.commaSeparateUrl(urlList);
        return classesBarChartGenerator.barChartCountOfClasses(uniqueUrlList);
    }
    @RequestMapping(value = "/compareCyclomatic", method = RequestMethod.GET)
    public
    @ResponseBody
    BarChartData compareCyclomatic(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {
        List<String> uniqueUrlList = stringProcessing.commaSeparateUrl(urlList);
        return cyclomaticBarChartGenerator.barChartLinesOfComments(uniqueUrlList);
    }
    @RequestMapping(value = "/compareRatio", method = RequestMethod.GET)
    public
    @ResponseBody
    BarChartData compareRatio(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {
        List<String> uniqueUrlList = stringProcessing.commaSeparateUrl(urlList);
        return ratioBarChartGenerator.barChartRatio(uniqueUrlList);
    }
    @RequestMapping(value = "/compareInteraction", method = RequestMethod.GET)
    public
    @ResponseBody
    BarChartData compareInteraction(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {
        List<String> uniqueUrlList = stringProcessing.commaSeparateUrl(urlList);
        return interactionBarChartGenerator.barChartInteraction(uniqueUrlList);
    }
    @RequestMapping(value = "/compareVolume", method = RequestMethod.GET)
    public
    @ResponseBody
    BarChartData compareVolume(@RequestParam(value = "urlList") String urlList) throws IOException, GitAPIException {
        List<String> uniqueUrlList = stringProcessing.commaSeparateUrl(urlList);
        return volumeBarChartGenerator.barChartVolume(uniqueUrlList);
    }

}
