package com.codevisual.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import com.codevisual.model.Graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Views {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/views", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "view";
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String display(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        return "display";
    }



    //Get parameter & reply json
    @RequestMapping("/receiveUrlList")
    public
    @ResponseBody
    Graph ReceiveInput(@RequestParam(value = "name") String name) {
        logger.info("Welcome home! The client locale is {}.");
        Graph jsonGraph = new Graph();
        jsonGraph.setFirstValue(name);
        jsonGraph.setSecondValue("Second");
        System.out.println(jsonGraph);
        return jsonGraph;

    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String posts(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "post";
    }


}
