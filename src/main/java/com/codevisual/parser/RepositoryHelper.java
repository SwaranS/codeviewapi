package com.codevisual.parser;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by Home on 12/07/2014.
 */
@Service
public class RepositoryHelper {
    Repository repository;

    public Repository getGit(File gitDir) throws IOException {
        Git git = Git.open(gitDir);
        repository = git.getRepository();
        return repository;
    }
}
