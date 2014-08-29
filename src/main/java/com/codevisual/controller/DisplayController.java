package com.codevisual.controller;

import com.codevisual.Services.BarChartDataGenerator;
import com.codevisual.Services.StringProcessing;
import com.codevisual.chartServices.ChartDataAccepter;
import com.codevisual.model.display.BarChartData;
import com.codevisual.model.rest.MetricInformation;
import com.codevisual.model.rest.MetricInformationList;
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
 * Created by Home on 02/08/2014.
 */
@Controller
public class DisplayController {
    @Autowired
    private BarChartDataGenerator barChartDataGenerator;

    @Autowired
    private StringProcessing stringProcessing;

    @Autowired
    private ChartDataAccepter chartDataAccepter;
    @RequestMapping(value = "/barChartData", method = RequestMethod.GET)
    public
    @ResponseBody
    BarChartData barChartData(@RequestParam(value = "url", required = false) String url) {
        List<String> uniqueUrlList = stringProcessing.commaSeparateUrl(url);
        return barChartDataGenerator.barChartDataForUrl(url);
    }

    @RequestMapping(value = "/displayDynamic", method = RequestMethod.GET)
    public String displayDynamic() {

        return "displayDynamic";
    }


}
