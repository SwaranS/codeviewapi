package com.codevisual.model.rest;

import java.util.List;

/**
 * Created by Home on 13/07/2014.
 */
public class UrlList {

    private List<String> urlList;

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public UrlList() {
    }

    public UrlList(List<String> urlList) {
        this.urlList = urlList;
    }
}
