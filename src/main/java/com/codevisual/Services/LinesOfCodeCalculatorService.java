package com.codevisual.Services;

import japa.parser.ast.CompilationUnit;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Home on 04/08/2014.
 */
@Service
public class LinesOfCodeCalculatorService {

    public int linesOfCodeFromCompilationUnit(List<CompilationUnit> compilationUnitList) throws IOException {
        int lineOfCode = 0;
        for(CompilationUnit compilationUnit:compilationUnitList) {
            lineOfCode = lineOfCode + linesOfCode(listOfCodeLines(compilationUnit));
        }
        return lineOfCode;
    }
    public int linesOfCodeFromCompilationUnit(CompilationUnit compilationUnit) throws IOException {
        return linesOfCode(listOfCodeLines(compilationUnit));
    }
    public int linesOfCommentsFromCompilationUnit(List<CompilationUnit> compilationUnitList) throws IOException {
        int lineOfCode = 0;
        for(CompilationUnit compilationUnit:compilationUnitList) {
            lineOfCode = lineOfCode + linesOfComments(listOfCodeLines(compilationUnit));
        }
        return lineOfCode;
    }

    public int linesOfCommentsFromCompilationUnit(CompilationUnit compilationUnit) throws IOException {
        return linesOfComments(listOfCodeLines(compilationUnit));
    }

    private List<String> listOfCodeLines(CompilationUnit compilationUnit) throws IOException {
        String javaCode = compilationUnit.toString();
        InputStream is = new ByteArrayInputStream(javaCode.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }


    private int linesOfCode(List<String> lines)
    {
        int linesOfCode = 0;
        String line;
        Iterator itr = lines.iterator();
        while(itr.hasNext())
        {
            line = ((String)itr.next());
            if (line.matches(".*[;){}]$")) {
                linesOfCode++;
                continue;
            }
        }
        return linesOfCode;
    }


    private int emptyLines(List<String> lines)
    {
        int emptyLines = 0;
        String line;
        Iterator itr = lines.iterator();
        while(itr.hasNext())
        {
            line = ((String)itr.next());
            if (line.matches("\\s*")) {
                emptyLines++;
            }
        }
        return emptyLines;
    }
    private int linesOfComments(List<String> lines)
    {
        int commentLines = 0;
        String line;
        boolean MULTILINE = false;
        Iterator itr = lines.iterator();
        while(itr.hasNext())
        {
            line = ((String)itr.next());
            line.replaceAll("\\."," ");
            line.replaceAll("\\\"[^\\\"]*\\\""," ");
            if (line.matches(".*[/][*].*") || MULTILINE) {
                MULTILINE = true;
                commentLines++;
                if (line.matches(".*[*][/].*")) {
                    MULTILINE = false;
                }
                continue;
            }
            if (line.matches(".*//.*") || line.matches(".*[/][*].*[*][/].*")) {
                commentLines++;
                continue;
            }
        }
        return commentLines;
    }
}
