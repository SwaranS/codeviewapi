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
    private long firstCommitTime;
    private long lastCommitTime;
    private int numberOfCommits;

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

    public HeaderInformation(String author, String url, long firstCommitTime, long lastCommitTime, int numberOfCommits) {
        this.author = author;
        this.url = url;
        this.firstCommitTime = firstCommitTime;
        this.lastCommitTime = lastCommitTime;
        this.numberOfCommits = numberOfCommits;
    }
}
