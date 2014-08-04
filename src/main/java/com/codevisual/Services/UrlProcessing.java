package com.codevisual.Services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Home on 04/08/2014.
 */
@Service
public class UrlProcessing {

    public HashSet<String> uniqueSetFromArray(ArrayList<String> stringArrayList){

        return new HashSet<String>(stringArrayList);
    }
    
    public List<String> commaSeparateUrl(String urlInput){
        return Arrays.asList(urlInput.split(","));
    }


}
