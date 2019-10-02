/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculation;

import static calculation.CheckNestingComplexity.com;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.util.ArrayList;

/**
 *
 * @author RASINDU
 */
public class CountInheritance {

    public static int totalCiValue = 0;

    public static ArrayList<Integer> com = new ArrayList<Integer>();

    public void calInheritance(File file) throws FileNotFoundException, IOException {

        BufferedReader reader;
        reader = new BufferedReader(new FileReader(file));
        System.out.println(reader);
        String row;

        int count;
        String value = "";

        int complexity = 0;
        int lineNo = 0;
        int classComplexity = 2;
        boolean isLinePrint = false;
        //int complextityDueToInheritance = 0;

        while ((row = reader.readLine()) != null) {

            isLinePrint = false;
            lineNo++;
            value = row;
            row = row.replaceAll("\\s", "");
            row = row.split("//")[0];
            row = row.replace("{", "");
            row = row.replace("}", "");
            row = row.replace(":", "");
            row = row.replace("try", "");
            row = row.replace("else", "");

            //ignore the multi-line comments 
            if (row.startsWith("/*") || row.startsWith("*")) {
                PrintData(lineNo, value, 0);

                continue;
            }
            boolean classWithoutInheritance = row.contains("class") && !(row.contains("implements") || row.contains("extends"));

            if (row.contains("class") && !row.matches("") && !row.startsWith("//")) {
                classComplexity = 2;
            }

            //check implements key word
            if ((!classWithoutInheritance && !row.matches("")) && (!row.contains("//")) && (!row.contains("import")) && (!row.contains("interface")) && (!row.contains("package"))) {

                count = 0;

                if (row.contains("implements")) {
                    String statementSplit[] = row.split("implements");
                    String[] ancesters = statementSplit[1].split(",");

                    for (String a : ancesters) {
                        count++;
                    }
                    classComplexity = classComplexity + count;
                }

                //check extends key word
                if (row.contains("extends")) {
                    count++;
                    classComplexity = classComplexity + 1;
                }

                if (row.contains("class")) {
                    PrintData(lineNo, value, 0);

                    continue;
                }

                isLinePrint = true;
                PrintData(lineNo, value, classComplexity);
            }

            if (!isLinePrint) {
                PrintData(lineNo, value, 0);
            }

        }

        //out.print("Total complexity of the program is: " + totComplexity);
    }

    private void PrintData(int lineNo, String value, int complexity) {
        com.add(complexity);
        System.out.println("Line : " + lineNo);
        System.out.println("Value : " + value);
        System.out.println("Complexity : " + complexity);
        System.out.println("-------------------------------------------------------------------");
        System.out.println();
    }
//    public int getTotal() {
//        return totComplexity;
//    }
//
//    public int getAncestor() {
//        return count1;
//    }
//
//    public int comDueToInhe() {
//        return complexity;
//    }

    public void getComplexityLineByLine() {
        System.out.println("##################################CI COMPLEXITY########################################");
        for (int i = 0; i < com.size(); i++) {
            System.out.println("complexity of line :" + (i + 1) + " " + com.get(i));
        }
        System.out.println("#######################################################################################");
    }

    public void getTotalCivalue() {
        for (int i = 0; i < com.size(); i++) {
            totalCiValue += com.get(i);
        }
    }

}
