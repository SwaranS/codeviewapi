package com.codevisual.git;

import com.codevisual.git.Services.GitHelper;
import com.codevisual.parser.Repository.HeadParserService;
import com.codevisual.parser.RepositoryHelper;
import org.eclipse.jgit.lib.Repository;

/**
 * Created by Home on 12/07/2014.
 */
public class Tester {
    static Repository repository ;
    public static void main(String[] args) throws Exception {

        GitHelper gitHelper = new GitHelper();
        HeadParserService headParser = new HeadParserService();
        RepositoryHelper repositoryHelper = new RepositoryHelper();

        String URL = " https://github.com/SwaranS/codeviewapi.git";
        //String URL = "https://github.com/centic9/jgit-cookbook.git";
        //System.out.println(gitHelper.checkLocalDirectory(URL));
        //System.out.println(repositoryHelper.getGit(gitHelper.getFileFromURL(URL)));
        //gitHelper.gitClone(URL);
        // Date d = new Date((headParser.getCommits(repositoryHelper.getGit(gitHelper.getFileFromURL(URL))).get(0).getCommitTime()) * 1000);
        System.out.println(headParser.getAuthor(repositoryHelper.getGit(gitHelper.getFileFromURL(URL))));
        /*CommitVisitor commitVisitor =  new CommitVisitor(headParser.getJavaCompilationUnit(headParser.getCommits(repositoryHelper.getGit(gitHelper.getFileFromURL(URL))).get(1)));
        System.out.println(commitVisitor.call().getCyclomatics());*/
        //gitHelper.getGit(gitHelper.getFileFromURL(URL));
    }

}
