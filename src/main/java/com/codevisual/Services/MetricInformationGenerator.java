package com.codevisual.Services;

import com.codevisual.model.CommitInformation;
import com.codevisual.model.HeaderInformation;
import com.codevisual.model.rest.MetricInformation;
import com.codevisual.persistence.CommitInformationRepository;
import com.codevisual.persistence.HeaderInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Home on 30/07/2014.
 */
@Service
public class MetricInformationGenerator {
    @Autowired
    private HeaderInformationRepository headerInformationRepository;
    @Autowired
    private CommitInformationRepository commitInformationRepository;

    public MetricInformation generateMetricInformation(String url){
        HeaderInformation headerInformation = generateHeaderInformation(url);
        List<CommitInformation> commitInformationList = generateCommitInformation(url);
        return new MetricInformation(headerInformation.getAuthor(),
                url,
                headerInformation.getFirstCommitTime(),
                headerInformation.getLastCommitTime(),
                headerInformation.getNumberOfCommits(),
                commitInformationList);

    }
    private HeaderInformation generateHeaderInformation(String Url) {

        return headerInformationRepository.getObject(Url);
    }

    private List<CommitInformation> generateCommitInformation(String url){
        return commitInformationRepository.getCommitInformationByUrl(url);
    }

}
