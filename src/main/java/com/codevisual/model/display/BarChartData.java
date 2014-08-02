package com.codevisual.model.display;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Home on 02/08/2014.
 */
public class BarChartData {

    private ArrayList<String> labels;
    private ArrayList<DataSet> datasets;

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<String> labels) {
        this.labels = labels;
    }

    public ArrayList<DataSet> getdatasets() {
        return datasets;
    }

    public void setdatasets(ArrayList<DataSet> datasets) {
        this.datasets = datasets;
    }

    public BarChartData(ArrayList<String> labels, ArrayList<DataSet> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }
}
