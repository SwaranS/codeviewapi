package com.codevisual.Services;

import com.codevisual.model.CommitInformation;
import com.codevisual.model.CommitInformationDifference;
import com.codevisual.persistence.CommitInformationRepository;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Home on 08/08/2014.
 */
@Service
public class ApiDataGeneratorService {

    @Autowired
    private StringProcessing stringProcessing;

    @Autowired
    private CommitInformationRepository commitInformationRepository;


    public List<CommitInformation> searchUserContributionInRepositories(String urlList, String name) throws IOException, GitAPIException {
        Set<String> uniqueUrlList = stringProcessing.uniqueSetFromArray(stringProcessing.commaSeparateUrl(urlList));
        List<CommitInformation> commitInformationList = new ArrayList<>();
        for (String uniqueUrl : uniqueUrlList) {
            List<CommitInformation> commitInformationListTemp = commitInformationRepository.getContributionByUser(uniqueUrl, name);
            for (CommitInformation commitInformationTemp : commitInformationListTemp) {
                commitInformationList.add(commitInformationTemp);
            }
        }
        return commitInformationList;
    }


    public List<CommitInformationDifference> changesByUserInRepositories(String url, String name) throws IOException, GitAPIException {
        List<CommitInformationDifference> commitInformationDifferenceList = new ArrayList<>();
        //Get Commit Data
        //Starts From second commit as no differences for first commit
        List<CommitInformation> commitInformationList = commitInformationRepository.getObjectDateSorted(url);
        for (int i = 1; i <commitInformationList.size(); i++) {
            if (commitInformationList.get(i).getCommitterName().equals(name)) {
                commitInformationDifferenceList.add(new CommitInformationDifference(commitInformationList.get(i).getUrl(),
                        commitInformationList.get(i - 1).getLinesOfCode()-commitInformationList.get(i).getLinesOfCode() ,
                        commitInformationList.get(i - 1).getJavaFilesCount()-commitInformationList.get(i).getJavaFilesCount(),
                        commitInformationList.get(i - 1).getLinesOfComments()-commitInformationList.get(i).getLinesOfComments(),
                        commitInformationList.get(i - 1).getCyclomatic()-commitInformationList.get(i).getCyclomatic(),
                        commitInformationList.get(i - 1).getRatio()-commitInformationList.get(i).getRatio(),
                        commitInformationList.get(i - 1).getInteraction()-commitInformationList.get(i).getInteraction(),
                        commitInformationList.get(i - 1).getVolume()-commitInformationList.get(i).getVolume()   ,
                        commitInformationList.get(i).getCommitTime(),
                        commitInformationList.get(i).getShortMessage(),
                        commitInformationList.get(i).getCommitterName(),
                        commitInformationList.get(i).getCommitterEmail()
                ));

            }
        }

        return commitInformationDifferenceList;
    }

}
