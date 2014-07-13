package com.codevisual.git;

import com.codevisual.git.Services.GitHelper;
import com.codevisual.parser.Repository.HeadParser;
import com.codevisual.parser.RepositoryHelper;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Home on 12/07/2014.
 */
public class Tester {

    public static void main(String[] args) throws IOException, GitAPIException {

        GitHelper gitHelper = new GitHelper();
        HeadParser headParser = new HeadParser();
        RepositoryHelper repositoryHelper = new RepositoryHelper();
        String URL = "https://github.com/centic9/jgit-cookbook.git";
        //System.out.println(gitHelper.checkLocalDirectory(URL));
        //System.out.println(repositoryHelper.getGit(gitHelper.getFileFromURL(URL)));
        System.out.println(headParser.getCommits(repositoryHelper.getGit(gitHelper.getFileFromURL(URL))).get(0).getCommitTime());
        //gitHelper.getGit(gitHelper.getFileFromURL(URL));
    }

}
