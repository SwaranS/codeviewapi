package com.codevisual.model.rest;

import java.util.List;

/**
 * Created by Home on 30/07/2014.
 */
public class MetricInformationList {

    private List<MetricInformation> metricInformationList;

    public List<MetricInformation> getMetricInformationList() {
        return metricInformationList;
    }

    public void setMetricInformationList(List<MetricInformation> metricInformationList) {
        this.metricInformationList = metricInformationList;
    }

    public MetricInformationList(List<MetricInformation> metricInformationList) {
        this.metricInformationList = metricInformationList;
    }
}
