package com.codevisual.Services;

import com.codevisual.model.CommitInformation;
import com.codevisual.model.display.BarChartData;
import com.codevisual.model.display.DataSet;
import com.codevisual.model.rest.MetricInformation;
import com.codevisual.model.rest.MetricInformationList;
import com.codevisual.persistence.MetricInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 05/08/2014.
 */
@Service
public class BarChartDataGenerator {

    @Autowired
    private DateConvertServices dateConvertServices;

    @Autowired
    private MetricInformationRepository metricInformationRepository;

    public BarChartData barChartDataForUrl(String url){
        try {
            return barChartDataFromMetricInformationList(metricInformationRepository.returnMetricInformation(url).getCommitInformationList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private BarChartData barChartDataFromMetricInformationList(List<CommitInformation> commitInformationList){
        ArrayList<String> labels = new ArrayList<>();
        for(CommitInformation commitInformation:commitInformationList){
            labels.add(dateConvertServices.longToDate(commitInformation.getCommitTime()));
        }
        ArrayList<String> data = new ArrayList<>();
        for(CommitInformation commitInformation:commitInformationList){
            data.add(String.valueOf(commitInformation.getLinesOfCode()));
        }
        ArrayList<DataSet> dataSets = new ArrayList<>();
        dataSets.add(new DataSet("rgba(220,220,220,0.5)",
                "rgba(220,220,220,0.8)",
                "rgba(220,220,220,0.75)",
                "rgba(220,220,220,1)",
                data));
        return new BarChartData(labels,dataSets);
    }
}
