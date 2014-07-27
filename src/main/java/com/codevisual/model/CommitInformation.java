package com.codevisual.model;

/**
 * Created by Home on 17/07/2014.
 */
public class CommitInformation {
    private int cyclomatic;
    private double ratio;
    private double interaction;
    private double volume;
    private int commitTime;
    private String shortMessage;
    private String committerName;
    private String committerEmail;

    public int getCyclomatic() {
        return cyclomatic;
    }

    public void setCyclomatic(int cyclomatic) {
        this.cyclomatic = cyclomatic;
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

    public int getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(int commitTime) {
        this.commitTime = commitTime;
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

    public CommitInformation(int cyclomatic, double ratio, double interaction, double volume, int commitTime, String shortMessage, String committerName, String committerEmail) {
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
