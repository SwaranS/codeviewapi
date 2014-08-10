package com.codevisual.Services;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Home on 04/08/2014.
 */
@Service
public class StringProcessing {

    public HashSet<String> uniqueSetFromArray(List<String> stringArrayList) {

        return new HashSet<String>(stringArrayList);
    }

    public List<String> commaSeparateUrl(String urlInput) {
        return  Arrays.asList(urlInput.split(","));
    }

    public List<String> commaSeparateName(String names) {
        return  Arrays.asList(names.split(","));
    }
    public String generateRandomColour(){

        List<String> colourList = new ArrayList<String>();
        colourList.add("rgba(204, 97, 107, 0.3)");
        colourList.add("rgba(102, 226, 218, 0.5)");
        colourList.add("rgba(215, 40, 40, 0.9)");
        colourList.add("rgba(133, 72, 121, 0.7)");
        int rnd = new Random().nextInt(colourList.size());
        return colourList.get(rnd);

    }

}
