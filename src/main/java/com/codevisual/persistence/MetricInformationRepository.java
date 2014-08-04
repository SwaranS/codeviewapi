package com.codevisual.persistence;

import com.codevisual.Services.CommitInformationGenerator;
import com.codevisual.Services.HeaderInformationGenerator;
import com.codevisual.model.CommitInformation;
import com.codevisual.model.HeaderInformation;
import com.codevisual.model.rest.MetricInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Home on 30/07/2014.
 */
@Service
public class MetricInformationRepository {

    @Autowired
    private HeaderInformationGenerator headerInformationGenerator;
    @Autowired
    private HeaderInformationRepository headerInformationRepository;
    @Autowired
    private CommitInformationGenerator commitInformationGenerator;
    @Autowired
    private CommitInformationRepository commitInformationRepository;

    public MetricInformation saveAndReturnMetricInformation(String url) throws Exception {
        HeaderInformation headerInformation = saveAndReturnHeaderInformation(url);
        List<CommitInformation> commitInformationList = saveAndReturnCommitInformation(url);
        return new MetricInformation(headerInformation.getAuthor(),
                headerInformation.getUrl(),
                headerInformation.getFirstCommitTime(),
                headerInformation.getLastCommitTime(),
                headerInformation.getNumberOfCommits(),
                commitInformationList);
    }

    public MetricInformation returnMetricInformation(String url) throws Exception {
        HeaderInformation headerInformation = returnHeaderInformation(url);
        List<CommitInformation> commitInformationList = returnCommitInformation(url);
        return new MetricInformation(headerInformation.getAuthor(),
                headerInformation.getUrl(),
                headerInformation.getFirstCommitTime(),
                headerInformation.getLastCommitTime(),
                headerInformation.getNumberOfCommits(),
                commitInformationList);
    }


    private HeaderInformation saveAndReturnHeaderInformation(String url) throws Exception {
        headerInformationRepository.saveObject(headerInformationGenerator.generateCommitInformationFromUrl(url));
        return headerInformationGenerator.generateCommitInformationFromUrl(url);
    }

    private List<CommitInformation> saveAndReturnCommitInformation(String url) throws Exception {
        List<CommitInformation> commitInformationList = commitInformationGenerator.generateCommitInformationList(url);
        for (CommitInformation commitInformation : commitInformationList) {
            commitInformationRepository.saveObject(commitInformation);
        }
        return commitInformationList;
    }


    private HeaderInformation returnHeaderInformation(String url) throws Exception {
        return headerInformationGenerator.generateCommitInformationFromUrl(url);
    }
    private List<CommitInformation> returnCommitInformation(String url) throws Exception {
        return  commitInformationRepository.getAllObjects();
    }
}
