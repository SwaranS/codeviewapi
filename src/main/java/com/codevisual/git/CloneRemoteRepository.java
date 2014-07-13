package com.codevisual.git;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
/**
 * Simple snippet which shows how to clone a repository from a remote source
 * 
 * @author dominik.stadler at gmx.at
 */
public class CloneRemoteRepository {

    private static final String REMOTE_URL = "https://github.com/xiansong/codemetric.git";

    public static void main(String[] args) throws IOException, InvalidRemoteException, TransportException, GitAPIException {
        // prepare a new folder for the cloned repository
    	//c:/dissertation14/xiansong/codemetric
    	File localPath = File.createTempFile("c:/dissertation14/xiansong/codemetric", "");
        localPath.delete();
        
        

        // then clone
        System.out.println("Cloning from " + REMOTE_URL + " to " + localPath);
        Git.cloneRepository()
                .setURI(REMOTE_URL)
                .setDirectory(localPath)
                .call();

        // now open the created repository
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.setGitDir(localPath)
                .readEnvironment() // scan environment GIT_* variables
                .findGitDir(localPath) // scan up the file system tree
                .build();
        Config config = repository.getConfig();
        String name = config.getString("user", null, "name");
        String email = config.getString("user", null, "email");
        if (name == null || email == null) {
            System.out.println("User identity is unknown!");
        } else {
            System.out.println("User identity is " + name + " <" + email + ">");
        }
       System.out.println(repository.getDirectory());
       
        repository.close();
    }
    
    /*private String getRepName(String gitUrl){
    	
    	
    	
    }*/
    
    
}