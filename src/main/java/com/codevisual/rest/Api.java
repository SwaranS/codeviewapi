package com.codevisual.rest;

import com.codevisual.model.rest.UrlList;
import org.springframework.stereotype.Service;

/**
 * Created by Home on 13/07/2014.
 */
@Service
public class Api {

    public int processUrlList(UrlList urlList){
            return urlList.getUrlList().size();
    }
}
