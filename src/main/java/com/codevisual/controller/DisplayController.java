package com.codevisual.controller;

import com.codevisual.model.Graph;
import com.codevisual.model.display.BarChartData;
import com.codevisual.model.display.DataSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

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
        labels.add("January");labels.add("February");labels.add("March");labels.add("April");labels.add("June");labels.add("July");
        ArrayList<String> data = new ArrayList<>();
        data.add("50");data.add("50");data.add("50");data.add("50");data.add("50");data.add("50");

        return new BarChartData(labels,new DataSet("rgba(220,220,220,0.5)",
                "rgba(220,220,220,0.8)",
                "rgba(220,220,220,0.75)",
                "rgba(220,220,220,1)",
                data));

    }
}
