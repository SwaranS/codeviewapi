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
    private List<CommitInformation> commitInformationList;

    public List<CommitInformation> getCommitInformationList() {
        return commitInformationList;
    }

    public void setCommitInformationList(List<CommitInformation> commitInformationList) {
        this.commitInformationList = commitInformationList;
    }

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

    public GitModel() {
    }

    public GitModel(String author, long firstCommitTime, long lastCommitTime, int numberOfCommits, List<CommitInformation> commitInformationList) {
        Author = author;
        this.firstCommitTime = firstCommitTime;
        this.lastCommitTime = lastCommitTime;
        this.numberOfCommits = numberOfCommits;
        this.commitInformationList = commitInformationList;
    }
}
