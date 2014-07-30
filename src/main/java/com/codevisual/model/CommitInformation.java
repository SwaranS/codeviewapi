package com.codevisual.model;

import java.util.Date;

/**
 * Created by Home on 17/07/2014.
 */
public class CommitInformation {
    private String url;
    private int cyclomatic;
    private double ratio;
    private double interaction;
    private double volume;
    private String commitTime;
    private String shortMessage;
    private String committerName;
    private String committerEmail;

    public int getCyclomatic() {
        return cyclomatic;
    }

    public void setCyclomatic(int cyclomatic) {
        this.cyclomatic = cyclomatic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public double getInteraction() {
        return interaction;
    }

    public void setInteraction(double interaction) {
        this.interaction = interaction;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }


    public String getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public String getCommitterName() {
        return committerName;
    }

    public void setCommitterName(String committerName) {
        this.committerName = committerName;
    }

    public String getCommitterEmail() {
        return committerEmail;
    }

    public void setCommitterEmail(String committerEmail) {
        this.committerEmail = committerEmail;
    }

    public String getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(String commitTime) {
        this.commitTime = commitTime;    }

    public CommitInformation(String url, int cyclomatic, double ratio, double interaction, double volume, String commitTime, String shortMessage, String committerName, String committerEmail) {
        this.url = url;
        this.cyclomatic = cyclomatic;
        this.ratio = ratio;
        this.interaction = interaction;
        this.volume = volume;
        this.commitTime = commitTime;
        this.shortMessage = shortMessage;
        this.committerName = committerName;
        this.committerEmail = committerEmail;
    }
}
