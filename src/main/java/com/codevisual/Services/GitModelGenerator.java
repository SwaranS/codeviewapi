package com.codevisual.Services;

import com.codevisual.git.Services.GitHelper;
import com.codevisual.model.CommitInformation;
import com.codevisual.model.CommitVisitor;
import com.codevisual.model.GitModel;
import com.codevisual.parser.Repository.HeadParserService;
import com.codevisual.parser.RepositoryHelper;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 16/07/2014.
 */
@Service
public class GitModelGenerator {


    @Autowired
    HeadParserService headParser;
    @Autowired
    RepositoryHelper repositoryHelper;
    @Autowired
    GitHelper gitHelper;

    public GitModel generateModel(String URL) throws IOException {
        repositoryHelper.getGit(gitHelper.getFileFromURL(URL));
        return generateGitModel(repositoryHelper.getGit(gitHelper.getFileFromURL(URL)));
    }

    public GitModel generateGitModel( Repository repository) {

        try {
            GitModel gitModel = new GitModel(headParser.getAuthor(repository),
                    headParser.firstCommitTime(repository),
                    headParser.lastCommitTime(repository),
                    headParser.getCommits(repository).size(),
                    generateCommitInformationList(headParser.getCommits(repository))
            );
            return gitModel;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    private List<CommitInformation> generateCommitInformationList(Iterable<RevCommit> revCommits) throws Exception {
        List<CommitInformation> commitInformationList = new ArrayList<>();
        List<RevCommit> commitList = new ArrayList<>();
        for(RevCommit revCommit:revCommits){
            commitList.add(revCommit);
        }
        for(int i=1;i<commitList.size();i++) {
            CommitVisitor commitVisitor = new CommitVisitor(headParser.getJavaCompilationUnit(commitList.get(i)));


            commitInformationList.add(new CommitInformation(commitVisitor.call().getCyclomatics(),
                    commitVisitor.call().getRatio(),
                    commitVisitor.call().getInteraction(),
                    commitVisitor.call().getVolumes(),
                    commitList.get(i).getCommitTime(),
                    commitList.get(i).getShortMessage(),
                    commitList.get(i).getAuthorIdent().getName(),
                    commitList.get(i).getAuthorIdent().getEmailAddress()));

        }
        return  commitInformationList;

    }


}
