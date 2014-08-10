package com.codevisual.chartServices;

import com.codevisual.Services.StringProcessing;
import com.codevisual.model.CommitInformation;
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
public class CodeBarChartGenerator {

    @Autowired
    private CommitInformationRepository commitInformationRepository;

    @Autowired
    private ChartDataAccepter chartDataAccepter;
    @Autowired
    private StringProcessing stringProcessing;

    public BarChartData barChartLinesOfCode(List<String> urlList) {
        ArrayList<String> labels = new ArrayList<>();
        for (int i = 0; i < chartDataAccepter.generateLabelSize(urlList); i++) {
            labels.add("Commit :" + (i + 1));
        }
        ArrayList<DataSet> dataSets = new ArrayList<>();
        List<ArrayList<String>> lists = barChartLinesOfCodeGenerator(urlList);
        for (int i = 0; i < lists.size(); i++) {
            dataSets.add(new DataSet(
                    stringProcessing.generateRandomColour(),
                    stringProcessing.generateRandomColour(),
                    stringProcessing.generateRandomColour(),
                    stringProcessing.generateRandomColour(),
                    lists.get(i)));
        }
        return new BarChartData(labels, dataSets);

    }

    private List<ArrayList<String>> barChartLinesOfCodeGenerator(List<String> urlList) {
        List<ArrayList<String>> listOfLinesOfCode = new ArrayList<>();

        for (String url : urlList) {
            listOfLinesOfCode.add(linesOfCodeFromUrl(url));
        }
        return listOfLinesOfCode;
    }

    private ArrayList<String> linesOfCodeFromUrl(String url) {
        ArrayList<String> listOfLinesOfCode = new ArrayList<>();
        List<CommitInformation> commitInformationList = commitInformationRepository.getObjectDateSortedAsc(url);
        for (CommitInformation commitInformation : commitInformationList) {
            listOfLinesOfCode.add(String.valueOf(commitInformation.getLinesOfCode()));
        }
        return listOfLinesOfCode;
    }
}
