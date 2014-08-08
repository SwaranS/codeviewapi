package com.codevisual.Services;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Home on 12/07/2014.
 */


@Service
public class GitHelper {


    //Local directory to save
    public final String LOCAL_PATH = "c:/dissertation14/git";
    Repository repository;

    public boolean checkLocalDirectory(String URL) throws IOException {
        File gitDir = new File(LOCAL_PATH + "/" + getNameFromUrl(URL));

        if ((gitDir.exists() && gitDir.isDirectory())) {
            return true;
        }
        return false;
    }

    public Repository getGit(File gitDir) throws IOException {
        Git git = Git.open(gitDir);
        repository = git.getRepository();
        return repository;
    }

    public  File getFileFromURL(String URL) throws UnsupportedEncodingException, MalformedURLException {
        return new File(LOCAL_PATH + "/" + getNameFromUrl(URL));
    }

    /**
     *
     * @param URL
     * @throws GitAPIException
     * @throws IOException
     * Only Clones if directory doesn't exist
     */
    public  File gitClone(String URL) throws GitAPIException, IOException {

        File gitDir = new File(LOCAL_PATH + "/" + getNameFromUrl(URL));
        try {
            Git.cloneRepository().setURI(URL)
                    .setDirectory(gitDir).call();
        } catch (InvalidRemoteException e) {
            FileUtils.delete(gitDir, FileUtils.RECURSIVE);
            throw e;
        }
        return gitDir;
    }

    public String getNameFromUrl(String URL) throws UnsupportedEncodingException, MalformedURLException {
        String decodedUrl = URLDecoder.decode(URL, "UTF-8");
        java.net.URL urlParse = new URL(decodedUrl);
        String name = urlParse.getPath();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9\\.\\-\\_]+(\\.git)$");
        Matcher matcher = pattern.matcher(URL);
        while (matcher.find()) {
            name = matcher.group(0);
        }
        return name.substring(0, name.length() - 4);
    }


}
