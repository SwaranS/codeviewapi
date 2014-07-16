package com.codevisual.parser.Repository;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathSuffixFilter;

import com.google.common.collect.Lists;

/**
 * Created by Home on 12/07/2014.
 */
public class HeadParser {

    static Repository repository ;

    public static List<RevCommit> getCommits(Repository repository) {
        RevWalk walk = new RevWalk(repository);
        walk.setRetainBody(false);
        try {
            walk.markStart(walk.parseCommit(repository.resolve(Constants.HEAD)));
        } catch (Exception e) {
            return Collections.emptyList();
        }
        List<RevCommit> revCommits = Lists.newArrayList();
        for (Iterator<RevCommit> itr = walk.iterator(); itr.hasNext();) {
            revCommits.add(itr.next());
        }
        return revCommits;
    }
    public static void parseCompilationUnit(final File sourceFile)
            throws ParseException, IOException {
        final CompilationUnit cu = JavaParser.parse(sourceFile);
        cu.accept(new VoidVisitorAdapter<Void>(){

            @Override
            public void visit(final MethodCallExpr n, final Void arg){
                System.out.println(n);
                super.visit(n, arg);
            }
        }, null);
    }

    /**
     * Gets the list of java files for a revision as a compilation unit.
     */
    public  List<CompilationUnit> getJavaCompilationUnit(final RevCommit c)
            throws MissingObjectException, IncorrectObjectTypeException,
            CorruptObjectException, IOException {
        List<CompilationUnit> filesList = Lists.newArrayList();
        RevTree tree = c.getTree();
        TreeWalk treeWalk = new TreeWalk(repository);
        treeWalk.addTree(tree);
        treeWalk.setRecursive(true);
        treeWalk.setFilter(PathSuffixFilter.create(".java"));

        while (treeWalk.next()) {
            ObjectLoader loader = repository.open(treeWalk.getObjectId(0));
            try (InputStream in = loader.openStream()) {
                CompilationUnit cu = JavaParser.parse(in, "UTF8");
                filesList.add(cu);
            } catch (Exception e) {
                // ignore individual file with error
            }
        }

        return filesList;
    }

    public  long firstCommitTime(Repository repository) {
        RevWalk walk = new RevWalk(repository);
        try {
            RevCommit root = walk.parseCommit(repository
                    .resolve(Constants.HEAD));
            walk.sort(RevSort.REVERSE);
            walk.markStart(root);
            RevCommit c = walk.next();
            if (c == null)
                return 0L;
            return c.getCommitterIdent().getWhen().getTime();
        } catch (Exception e) {
            return 0L;
        } finally {
            walk.dispose();
        }
    }


    public  String getAuthor(Repository repository) {
        RevWalk walk = new RevWalk(repository);
        try {
            RevCommit c = walk.parseCommit(repository.resolve(Constants.HEAD));
            if (c == null)
                return "";
            return c.getAuthorIdent().getName();
        } catch (Exception e) {
            return "";
        } finally {
            walk.dispose();
        }
    }

    public  long lastCommitTime(Repository repository) {
        RevWalk walk = new RevWalk(repository);
        try {
            RevCommit c = walk.parseCommit(repository.resolve(Constants.HEAD));
            if (c == null)
                return 0L;
            return c.getCommitterIdent().getWhen().getTime();
        } catch (Exception e) {
            return 0L;
        } finally {
            walk.dispose();
        }
    }
}
