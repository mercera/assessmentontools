/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author RASINDU
 */
public class CheckRecursion {

    public int[] findRecursion(File file) {
        int[] recursiveLines = new int[4];

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(
                    file));

            String line = reader.readLine();
            String[] mName = {"null", "null", "null", "null"};
            int j = 0;
            int method = 0;
            int lineNo = 0;
            int startLine = 0;
            int EndLine = 0;
            int recursion = 0;
            int methodNo = 0;
            int arrayNo = 0;

            while (line != null) {
                lineNo++;
                System.out.println(line);

                String[] words = {"void", "double", "int", "float", "long"};

                if (method > 0 && line.contains("{")) {
                    method += 1;
                } else if (method > 0 && line.contains("}")) {
                    method -= 1;
                    if (method == 0 && recursion > 0) {
                        EndLine = lineNo;
                        recursiveLines[arrayNo] = startLine;
                        recursiveLines[arrayNo + 1] = EndLine;
                        startLine = 0;
                        EndLine = 0;
                        recursion = 0;
                        mName[methodNo] = "read";
                        methodNo++;
                        arrayNo += 2;
                    } else if (method == 0) {
                        startLine = 0;
                        EndLine = 0;
                    }
                }

                if (mName != null) {
                    for (String name : mName) {
                        if (line.contains(name) && method > 0) {
                            recursion = 1;
                            //System.out.println(line);
                            // complexity+=line.split(name).length - 1;
                        }
                    }

                }

                if (line.contains("(") && line.contains(")") && (line.contains("public") || line.contains("private"))) {
                    for (String word : words) {
                        if (line.contains(word)) {
                            method = 1;
                            startLine = lineNo;
                            //complexity+=1;
                            String[] arrOfStr = line.split(" ");
                            for (int i = 0; i < arrOfStr.length; i++) {
                                if (arrOfStr[i].contains("(")) {
                                    String[] split = arrOfStr[i].split("\\(");
                                    mName[j] = split[0];
                                    j++;
                                    System.out.println(mName);
                                }
                            }
                        }
                    }
                }
                line = reader.readLine();

            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return recursiveLines;
    }

}
