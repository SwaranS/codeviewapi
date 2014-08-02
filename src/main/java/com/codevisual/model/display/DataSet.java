package com.codevisual.model.display;

import java.util.ArrayList;

/**
 * Created by Home on 02/08/2014.
 */
public class DataSet {
    private String fillColor;
    private String strokeColor;
    private String highlightFill;
    private String highlightStroke;
    private ArrayList<String> data;

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public String getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(String strokeColor) {
        this.strokeColor = strokeColor;
    }

    public String getHighlightFill() {
        return highlightFill;
    }

    public void setHighlightFill(String highlightFill) {
        this.highlightFill = highlightFill;
    }

    public String getHighlightStroke() {
        return highlightStroke;
    }

    public void setHighlightStroke(String highlightStroke) {
        this.highlightStroke = highlightStroke;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public DataSet(String fillColor, String strokeColor, String highlightFill, String highlightStroke, ArrayList<String> data) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.highlightFill = highlightFill;
        this.highlightStroke = highlightStroke;
        this.data = data;
    }
}
