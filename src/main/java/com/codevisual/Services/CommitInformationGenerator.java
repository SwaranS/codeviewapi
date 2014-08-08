package com.codevisual.Services;

import com.codevisual.model.CommitInformation;
import com.codevisual.model.CommitVisitor;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 30/07/2014.
 */
@Service
public class CommitInformationGenerator {

    @Autowired
    DateConvertServices utilServices;
    @Autowired
    HeadParserService headParser;
    @Autowired
    RepositoryHelper repositoryHelper;
    @Autowired
    GitHelper gitHelper;
    @Autowired
    LinesOfCodeCalculatorService linesOfCodeCalculatorService;

    public List<CommitInformation> generateCommitInformationList(String url) throws Exception {
        repositoryHelper.getGit(gitHelper.getFileFromURL(url));
        return generateCommitInformationList(repositoryHelper.getGit(gitHelper.getFileFromURL(url)), url);
    }

    private List<CommitInformation> generateCommitInformationList(Repository repository,String url) throws Exception {
        List<CommitInformation> commitInformationList = new ArrayList<>();
        Git git = new Git(repository);
        Iterable<RevCommit> log = git.log().call();
        List<RevCommit> commitList = new ArrayList<>();
        for(RevCommit revCommit:log){
            commitList.add(revCommit);
        }
        for(int i=0;i<commitList.size();i++){
            CommitVisitor commitVisitor = new CommitVisitor(headParser.getJavaCompilationUnit((commitList.get(i)),repository));
            commitInformationList.add(new CommitInformation(
                    url,
                    commitVisitor.call().getCyclomatics(),
                    commitVisitor.call().getRatio(),
                    commitVisitor.call().getInteraction(),
                    commitVisitor.call().getVolumes(),
                    utilServices.intToLong(commitList.get(i).getCommitTime()),
                    commitList.get(i).getShortMessage(),
                    commitList.get(i).getAuthorIdent().getName(),
                    commitList.get(i).getAuthorIdent().getEmailAddress(),
                    commitVisitor.call().getUcs().size(),
                    linesOfCodeCalculatorService.linesOfCodeFromCompilationUnit(headParser.getJavaCompilationUnit((commitList.get(i)),repository)),
                    linesOfCodeCalculatorService.linesOfCommentsFromCompilationUnit(headParser.getJavaCompilationUnit((commitList.get(i)),repository))

            ));
        }
        return commitInformationList;

    }

}
