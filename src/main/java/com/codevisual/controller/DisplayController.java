package com.codevisual.controller;

import com.codevisual.model.Graph;
import com.codevisual.model.Person;
import com.codevisual.model.display.BarChartData;
import com.codevisual.model.display.DataSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Home on 02/08/2014.
 */
@Controller
public class DisplayController {

    @RequestMapping(value = "/barChartData", method = RequestMethod.GET)
    public
    @ResponseBody
    BarChartData barChartData(@RequestParam(value = "name", required = false) String name) {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("June");
        labels.add("July");
        ArrayList<String> data = new ArrayList<>();
        data.add("10");
        data.add("20");
        data.add("30");
        data.add("40");
        data.add("50");
        data.add("10");
        ArrayList<DataSet> dataSets = new ArrayList<>();
        dataSets.add(new DataSet("rgba(220,220,220,0.5)",
                "rgba(220,220,220,0.8)",
                "rgba(220,220,220,0.75)",
                "rgba(220,220,220,1)",
                data));
        return new BarChartData(labels,dataSets );

    }

    @RequestMapping(value = "/displayDynamic", method = RequestMethod.GET)
    public String displayDynamic() {

        return "displayDynamic";
    }
}
