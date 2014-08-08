package com.codevisual.controller;

import com.codevisual.Services.BarChartDataGenerator;
import com.codevisual.model.display.BarChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Home on 02/08/2014.
 */
@Controller
public class DisplayController {
    @Autowired
    private BarChartDataGenerator barChartDataGenerator;




    @RequestMapping(value = "/barChartData", method = RequestMethod.GET)
    public
    @ResponseBody
    BarChartData barChartData(@RequestParam(value = "url", required = false) String url) {
        return barChartDataGenerator.barChartDataForUrl(url);
    }

    @RequestMapping(value = "/displayDynamic", method = RequestMethod.GET)
    public String displayDynamic() {

        return "displayDynamic";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        return "index";
    }
}
