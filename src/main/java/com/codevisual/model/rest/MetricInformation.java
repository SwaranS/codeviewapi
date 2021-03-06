package com.codevisual.model.rest;

import com.codevisual.model.CommitInformation;

import java.util.List;

/**
 * Created by Home on 30/07/2014.
 */
public class MetricInformation {
    private String author;
    private String url;
    private long firstCommitTime;
    private long lastCommitTime;
    private int numberOfCommits;
    private List<CommitInformation> commitInformationList;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getFirstCommitTime() {
        return firstCommitTime;
    }

    public void setFirstCommitTime(long firstCommitTime) {
        this.firstCommitTime = firstCommitTime;
    }

    public long getLastCommitTime() {
        return lastCommitTime;
    }

    public void setLastCommitTime(long lastCommitTime) {
        this.lastCommitTime = lastCommitTime;
    }

    public int getNumberOfCommits() {
        return numberOfCommits;
    }

    public void setNumberOfCommits(int numberOfCommits) {
        this.numberOfCommits = numberOfCommits;
    }

    public List<CommitInformation> getCommitInformationList() {
        return commitInformationList;
    }

    public void setCommitInformationList(List<CommitInformation> commitInformationList) {
        this.commitInformationList = commitInformationList;
    }

    public MetricInformation(String author, String url, long firstCommitTime, long lastCommitTime, int numberOfCommits, List<CommitInformation> commitInformationList) {
        this.author = author;
        this.url = url;
        this.firstCommitTime = firstCommitTime;
        this.lastCommitTime = lastCommitTime;
        this.numberOfCommits = numberOfCommits;
        this.commitInformationList = commitInformationList;
    }
}
