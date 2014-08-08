package com.codevisual.model;

/**
 * Created by Home on 08/08/2014.
 */
public class CommitInformationDifference  {
    private String url;
    private int linesOfCodeDifference;
    private int javaFilesCountDifference;
    private int linesOfCommentsDifference;
    private int cyclomaticDifference;
    private double ratioDifference;
    private double interactionDifference;
    private double volumeDifference;
    private long commitTime;
    private String shortMessage;
    private String committerName;
    private String committerEmail;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLinesOfCodeDifference() {
        return linesOfCodeDifference;
    }

    public void setLinesOfCodeDifference(int linesOfCodeDifference) {
        this.linesOfCodeDifference = linesOfCodeDifference;
    }

    public int getJavaFilesCountDifference() {
        return javaFilesCountDifference;
    }

    public void setJavaFilesCountDifference(int javaFilesCountDifference) {
        this.javaFilesCountDifference = javaFilesCountDifference;
    }

    public int getLinesOfCommentsDifference() {
        return linesOfCommentsDifference;
    }

    public void setLinesOfCommentsDifference(int linesOfCommentsDifference) {
        this.linesOfCommentsDifference = linesOfCommentsDifference;
    }

    public int getCyclomaticDifference() {
        return cyclomaticDifference;
    }

    public void setCyclomaticDifference(int cyclomaticDifference) {
        this.cyclomaticDifference = cyclomaticDifference;
    }

    public double getRatioDifference() {
        return ratioDifference;
    }

    public void setRatioDifference(double ratioDifference) {
        this.ratioDifference = ratioDifference;
    }

    public double getInteractionDifference() {
        return interactionDifference;
    }

    public void setInteractionDifference(double interactionDifference) {
        this.interactionDifference = interactionDifference;
    }

    public double getVolumeDifference() {
        return volumeDifference;
    }

    public void setVolumeDifference(double volumeDifference) {
        this.volumeDifference = volumeDifference;
    }

    public long getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(long commitTime) {
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

    public CommitInformationDifference(String url, int linesOfCodeDifference, int javaFilesCountDifference, int linesOfCommentsDifference, int cyclomaticDifference, double ratioDifference, double interactionDifference, double volumeDifference, long commitTime, String shortMessage, String committerName, String committerEmail) {
        this.url = url;
        this.linesOfCodeDifference = linesOfCodeDifference;
        this.javaFilesCountDifference = javaFilesCountDifference;
        this.linesOfCommentsDifference = linesOfCommentsDifference;
        this.cyclomaticDifference = cyclomaticDifference;
        this.ratioDifference = ratioDifference;
        this.interactionDifference = interactionDifference;
        this.volumeDifference = volumeDifference;
        this.commitTime = commitTime;
        this.shortMessage = shortMessage;
        this.committerName = committerName;
        this.committerEmail = committerEmail;
    }
}
