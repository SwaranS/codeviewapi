package com.codevisual.chartServices;

import com.codevisual.model.display.BarChartData;
import com.codevisual.model.display.DataSet;
import com.codevisual.persistence.CommitInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 10/08/2014.
 */
@Service
public class ChartDataAccepter {

    @Autowired
    private CommitInformationRepository commitInformationRepository;

    @Autowired
    private ChartDataSetGenerator chartDataSetGenerator;




    public BarChartData barChartLinesOfCode(List<String> urlList){
        ArrayList<String> labels = new ArrayList<>();
        for(int i=0;i<generateLabelSize(urlList);i++){
            labels.add("Commit :"+(i+1));
        }
        ArrayList<DataSet> dataSets = new ArrayList<>();
        List<ArrayList<String>> lists = chartDataSetGenerator.barChartLinesOfCodeGenerator(urlList);
        for(int i=0;i<lists.size();i++){
            dataSets.add(new DataSet(
                    "rgba(215, 40, 40, 0.9)",
                    "rgba(215, 40, 40, 0.9)",
                    "rgba(215, 40, 40, 0.9)",
                    "rgba(215, 40, 40, 0.9)",
                    lists.get(i)));
        }
        return new BarChartData(labels,dataSets);

    }
    public BarChartData barChartLinesOfComment(List<String> urlList){
        ArrayList<String> labels = new ArrayList<>();
        for(int i=0;i<generateLabelSize(urlList);i++){
            labels.add("Commit :"+(i+1));
        }
        ArrayList<DataSet> dataSets = new ArrayList<>();
        List<ArrayList<String>> lists = chartDataSetGenerator.barChartLinesOfCommentGenerator(urlList);
        for(int i=0;i<lists.size();i++){
            dataSets.add(new DataSet(
                    "rgba(215, 40, 40, 0.9)",
                    "rgba(215, 40, 40, 0.9)",
                    "rgba(215, 40, 40, 0.9)",
                    "rgba(215, 40, 40, 0.9)",
                    lists.get(i)));
        }
        return new BarChartData(labels,dataSets);

    }

    public int generateLabelSize(List<String> urlList) {

        int longestSize = 0;
        for (String url : urlList) {
            if (commitInformationRepository.getObjectDateSortedAsc(url).size() > longestSize) {
                longestSize = commitInformationRepository.getObjectDateSortedAsc(url).size();
            }
        }
        return longestSize;
    }
}
