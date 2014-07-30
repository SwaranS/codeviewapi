package com.codevisual.persistence;

import com.codevisual.Services.CommitInformationGenerator;
import com.codevisual.Services.DateConvertServices;
import com.codevisual.Services.HeaderInformationGenerator;
import com.codevisual.Services.MetricInformationGenerator;
import com.codevisual.git.Services.GitHelper;
import com.codevisual.model.CommitInformation;
import com.codevisual.model.HeaderInformation;
import com.codevisual.model.rest.MetricInformation;
import com.codevisual.parser.Repository.HeadParserService;
import com.codevisual.parser.RepositoryHelper;
import org.eclipse.jgit.lib.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Home on 30/07/2014.
 */
@Service
public class MetricInformationRepository {

    //Generate MetricInformation
    //Save header information
    //Save commit information
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

}
