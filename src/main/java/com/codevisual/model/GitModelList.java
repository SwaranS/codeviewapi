package com.codevisual.model;

import java.util.List;

/**
 * Created by Home on 16/07/2014.
 */
public class GitModelList {

    private List<HeaderInformation> gitModelList;

    public List<HeaderInformation> getGitModelList() {
        return gitModelList;
    }

    public void setGitModelList(List<HeaderInformation> gitModelList) {
        this.gitModelList = gitModelList;
    }

    public GitModelList(List<HeaderInformation> gitModelList) {
        this.gitModelList = gitModelList;
    }
}
