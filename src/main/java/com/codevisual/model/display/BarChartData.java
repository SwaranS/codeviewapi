package com.codevisual.model.display;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Home on 02/08/2014.
 */
public class BarChartData {

    private ArrayList<String> labels;
    private DataSet dataSet;

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<String> labels) {
        this.labels = labels;
    }

    public DataSet getDataSet() {
        return dataSet;
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public BarChartData(ArrayList<String> labels, DataSet dataSet) {
        this.labels = labels;
        this.dataSet = dataSet;
    }
}
