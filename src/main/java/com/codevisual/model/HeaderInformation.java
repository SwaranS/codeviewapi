package com.codevisual.model;

import org.eclipse.jgit.revwalk.RevCommit;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

/**
 * Created by Home on 12/07/2014.
 */
public class HeaderInformation {

    private String author;
    @Id
    private String url;
    private String firstCommitTime;
    private String lastCommitTime;
    private int numberOfCommits;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumberOfCommits() {
        return numberOfCommits;
    }

    public void setNumberOfCommits(int numberOfCommits) {
        this.numberOfCommits = numberOfCommits;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        author = author;
    }

    public HeaderInformation() {
    }

    public String getFirstCommitTime() {
        return firstCommitTime;
    }

    public void setFirstCommitTime(String firstCommitTime) {
        this.firstCommitTime = firstCommitTime;
    }

    public String getLastCommitTime() {
        return lastCommitTime;
    }

    public void setLastCommitTime(String lastCommitTime) {
        this.lastCommitTime = lastCommitTime;
    }

    public HeaderInformation(String author, String url, String firstCommitTime, String lastCommitTime, int numberOfCommits) {
        this.author = author;
        this.url = url;
        this.firstCommitTime = firstCommitTime;
        this.lastCommitTime = lastCommitTime;
        this.numberOfCommits = numberOfCommits;
    }
}
