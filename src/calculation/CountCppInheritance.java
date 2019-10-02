/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author RASINDU
 */
public class CountCppInheritance {

    public void calInheritance(FileReader fileReader) throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(fileReader);
        List<String> filteredWordList = new ArrayList<String>();
        String actualRowValue = "";
        String actualCodeLine = "";
        int complexity = 0;
        int lineNo = 0;
        boolean isInsideTheInheritanceClass = false;
        List<String> keyWordsToRemoveList = Arrays.asList("{", "}", "else", "try", ";");
        int curlyBracesCount = 0;
        boolean complexityPrint = false;

        while ((actualRowValue = reader.readLine()) != null) {
            lineNo++;
            complexityPrint = false;
            actualCodeLine = actualRowValue.trim().split("//")[0];

            if (actualCodeLine.contains("class") && (actualCodeLine.contains(":"))) {
                isInsideTheInheritanceClass = true;
                int ancestersCount = actualCodeLine.split(":")[1].split(",").length;

                if (actualCodeLine.contains("{")) {
                    curlyBracesCount = curlyBracesCount + countChar(actualCodeLine, '{');
                }
                complexity = ancestersCount + 1;
                PrintData(lineNo, actualRowValue, 0);
                continue;
            }

            if (isInsideTheInheritanceClass) {

                if (actualCodeLine.contains("{")) {
                    curlyBracesCount = curlyBracesCount + countChar(actualCodeLine, '{');
                }

                if (actualCodeLine.contains("}")) {
                    curlyBracesCount = curlyBracesCount - countChar(actualCodeLine, '}');
                }

                if (curlyBracesCount > 0) {
                    filteredWordList = Arrays.asList(actualCodeLine.split(" "));
                    if (filteredWordList.size() > 0) {
                        filteredWordList = filteredWordList.stream()
                                .filter(word -> !keyWordsToRemoveList.contains(word))
                                .collect(Collectors.toList());

                        if (filteredWordList.size() > 0) {
                            complexityPrint = true;
                            PrintData(lineNo, actualRowValue, complexity);
                        }
                    }
                } else {
                    isInsideTheInheritanceClass = false;
                }
            }

            if (!complexityPrint) {
                PrintData(lineNo, actualRowValue, 0);
            }
        }
    }

    private void PrintData(int lineNo, String value, int complexity) {
        System.out.println("Line \t\t: " + lineNo);
        System.out.println("Value \t\t: " + value);
        System.out.println("Complexity \t: " + complexity);
        System.out.println("-------------------------------------------------------------------");
        System.out.println();
    }

    private int countChar(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

}
