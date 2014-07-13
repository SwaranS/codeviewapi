package com.codevisual.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.codevisual.model.Person;
import com.codevisual.model.rest.UrlList;
import com.codevisual.persistence.NatureRepositoryImpl;
import com.sun.jmx.remote.internal.ArrayQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codevisual.model.Graph;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private NatureRepositoryImpl repository;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        repository.saveObject(new Person("1", "Apple Person"));
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }


    //Get parameter & reply json
    @RequestMapping(value = "/graph", method = RequestMethod.GET)
    public
    @ResponseBody
    Graph graph(@RequestParam(value = "name", required = false) String name) {
        logger.info("Welcome home! The client locale is {}.");
        Graph jsonGraph = new Graph();
        jsonGraph.setFirstValue(name);
        jsonGraph.setSecondValue("Second");
        return jsonGraph;
    }

    //Get parameter & reply json @PathVariable("id") String id, @RequestBody Graph inGraph)
    @RequestMapping(value = "/postgraph", method = RequestMethod.POST)
    public
    @ResponseBody
    Graph postGraph(@RequestBody Graph inGraph) {
        logger.info("Welcome home! The client locale is {}.");
        Graph jsonGraph = new Graph();
        jsonGraph.setFirstValue(inGraph.getFirstValue());
        jsonGraph.setSecondValue(inGraph.getSecondValue());
        return jsonGraph;
    }

}
