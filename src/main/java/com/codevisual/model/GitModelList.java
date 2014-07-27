package com.codevisual.model;

import java.util.List;

/**
 * Created by Home on 16/07/2014.
 */
public class GitModelList {

    private List<GitModel> gitModelList;

    public List<GitModel> getGitModelList() {
        return gitModelList;
    }

    public void setGitModelList(List<GitModel> gitModelList) {
        this.gitModelList = gitModelList;
    }

    public GitModelList(List<GitModel> gitModelList) {
        this.gitModelList = gitModelList;
    }
}
