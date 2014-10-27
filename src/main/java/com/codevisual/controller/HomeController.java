package com.codevisual.controller;


import com.codevisual.Services.BarChartDataGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    @Autowired
    private BarChartDataGenerator barChartDataGenerator;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);




    @RequestMapping(value = "/generatedChart", method = RequestMethod.GET)

    public String sendJson(ModelMap model) {
        model.put("jsonData", barChartDataGenerator.barChartDataForUrl("https://github.com/xiansong/codemetric.git"));
        return "generatedChart";
    }


}
