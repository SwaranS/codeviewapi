package com.codevisual.Services;

import com.codevisual.model.CommitInformation;
import com.codevisual.model.display.BarChartData;
import com.codevisual.model.display.DataSet;
import com.codevisual.persistence.CommitInformationRepository;
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

    @Autowired
    private CommitInformationRepository commitInformationRepository;



    public BarChartData barChartDataForUrl(String url){
        try {
            return barChartDataFromMetricInformationList(commitInformationRepository.getObjectDateSortedAsc(url)
            );

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

        ArrayList<String> dataShort = new ArrayList<>();
        for(CommitInformation commitInformation:commitInformationList){
            dataShort.add(String.valueOf(commitInformation.getLinesOfComments()));
        }
        ArrayList<String> dataComment = new ArrayList<>();
        for(CommitInformation commitInformation:commitInformationList){
            dataComment.add(String.valueOf(commitInformation.getCyclomatic()));
        }

        ArrayList<DataSet> dataSets = new ArrayList<>();
        dataSets.add(new DataSet(
                "rgba(215, 40, 40, 0.9)",
                "rgba(215, 40, 40, 0.9)",
                "rgba(215, 40, 40, 0.9)",
                "rgba(215, 40, 40, 0.9)",
                data));
        dataSets.add(new DataSet(
                "rgba(220,220,220,0.5)",
                "rgba(220,220,220,0.8)",
                "rgba(220,220,220,0.75)",
                "rgba(220,220,220,1)",
                dataShort));
        dataSets.add(new DataSet(
                "rgba(215,172,131,0.9)",
                "rgba(215,172,131,0.9)",
                "rgba(215,172,131,0.9)",
                "rgba(215,172,131,0.9)",
                dataComment));

        return new BarChartData(labels,dataSets);
    }
}
