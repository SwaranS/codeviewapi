package com.codevisual.chartServices;

import com.codevisual.model.CommitInformation;
import com.codevisual.persistence.CommitInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 10/08/2014.
 */


@Service
public class ChartDataSetGenerator {


    @Autowired
    private CommitInformationRepository commitInformationRepository;


    public List<ArrayList<String>> barChartLinesOfCodeGenerator(List<String> urlList) {
        List<ArrayList<String>> listOfLinesOfCode = new ArrayList<>();

        for (String url : urlList) {
            listOfLinesOfCode.add(linesOfCodeFromUrl(url));
        }
        return listOfLinesOfCode;
    }

    public List<ArrayList<String>> barChartLinesOfCommentGenerator(List<String> urlList) {
        List<ArrayList<String>> listOfLinesOfComment = new ArrayList<>();

        for (String url : urlList) {
            listOfLinesOfComment.add(linesOfCommentFromUrl(url));
        }
        return listOfLinesOfComment;
    }
    public ArrayList<String> linesOfCommentFromUrl(String url) {
        ArrayList<String> listOfLinesOfCode = new ArrayList<>();
        List<CommitInformation> commitInformationList = commitInformationRepository.getObjectDateSortedAsc(url);
        for (CommitInformation commitInformation : commitInformationList) {
            listOfLinesOfCode.add(String.valueOf(commitInformation.getLinesOfComments()));
        }
        return listOfLinesOfCode;
    }

    public ArrayList<String> linesOfCodeFromUrl(String url) {
        ArrayList<String> listOfLinesOfCode = new ArrayList<>();
        List<CommitInformation> commitInformationList = commitInformationRepository.getObjectDateSortedAsc(url);
        for (CommitInformation commitInformation : commitInformationList) {
            listOfLinesOfCode.add(String.valueOf(commitInformation.getLinesOfCode()));
        }
        return listOfLinesOfCode;
    }
}
