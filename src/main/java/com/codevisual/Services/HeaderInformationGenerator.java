package com.codevisual.Services;

import com.codevisual.git.Services.GitHelper;
import com.codevisual.model.HeaderInformation;
import com.codevisual.parser.Repository.HeadParserService;
import com.codevisual.parser.RepositoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Home on 30/07/2014.
 */
@Service
public class HeaderInformationGenerator {

    @Autowired
    DateConvertServices utilServices;
    @Autowired
    HeadParserService headParser;
    @Autowired
    RepositoryHelper repositoryHelper;
    @Autowired
    GitHelper gitHelper;

    public HeaderInformation generateCommitInformationFromUrl(String url) throws Exception {
        repositoryHelper.getGit(gitHelper.getFileFromURL(url));
        return generateHeaderInformation(repositoryHelper.getGit(gitHelper.getFileFromURL(url)), url);
    }


    public HeaderInformation generateHeaderInformation(org.eclipse.jgit.lib.Repository repository,String Url) {

        try {
            HeaderInformation gitModel = new HeaderInformation(
                    headParser.getAuthor(repository),
                    Url,
                    utilServices.longToDate(headParser.firstCommitTime(repository)),
                    utilServices.longToDate(headParser.lastCommitTime(repository)),
                    headParser.getCommits(repository).size()
            );
            return gitModel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
