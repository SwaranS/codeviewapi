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
