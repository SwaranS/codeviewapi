package com.codevisual.model;

import org.eclipse.jgit.revwalk.RevCommit;

import java.util.List;

/**
 * Created by Home on 12/07/2014.
 */
public class GitModel {

    private String Author;
    private long firstCommitTime;
    private long lastCommitTime;
    private int numberOfCommits;
    private List<RevCommit> getCommits;


    public int getNumberOfCommits() {
        return numberOfCommits;
    }

    public void setNumberOfCommits(int numberOfCommits) {
        this.numberOfCommits = numberOfCommits;
    }


    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
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

    /*public List<RevCommit> getGetCommits() {
        return getCommits;
    }

    public void setGetCommits(List<RevCommit> getCommits) {
        this.getCommits = getCommits;
    }
*/



    public GitModel() {
    }

    public GitModel(String author, long firstCommitTime, long lastCommitTime, int numberOfCommits) {
        Author = author;
        this.firstCommitTime = firstCommitTime;
        this.lastCommitTime = lastCommitTime;
        this.numberOfCommits = numberOfCommits;
    }
}
