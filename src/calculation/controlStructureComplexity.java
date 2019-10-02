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
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import spmprojectapp.ReportController;

/**
 *
 * @author RASINDU
 */
public class controlStructureComplexity {

    File file;
    int TotalCom = 0;
//    ReportController rtp = new ReportController();

    public static ArrayList<Integer> com = new ArrayList<Integer>();

    public void setFile(File f) {
        this.file = f;
    }

    public int calComplexity() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        int ifCount = 0;
        int logicalCount = 0;
        int iterative = 0;
        int switchCount = 0;
        int caseCount=0;
        int catchCount = 0;
        int lineNo = 0;
        int multiline = 0;

        while (line != null) {
            System.out.println(line);
            lineNo++;
            int lineComplex = 0;

            if (line.contains("/*") || line.contains("*")) {
                multiline = 1;
                if (line.contains("*/")) {
                    multiline = 0;
                }
            }

            if (line.contains("if") && !line.contains("//") && multiline == 0) {
                ifCount += 1;
                lineComplex += 1;

                if (line.contains("&&") || line.contains("||") || line.contains("&") || line.contains("|")) {
                    String character = "a";
                    line += character;
                    int j = line.length() + 1;
                    for (int i = 0; i < line.length() - 1; i++) {
                        if (i == j) {
                            continue;
                        }

                        char c = line.charAt(i);
                        char cn = line.charAt(i + 1);

                        if ((c == '&' && cn == '&')) {
                            logicalCount += 1;
                            lineComplex += 1;
                            j = i + 1;

                        } else if ((c == '|' && cn == '|')) {
                            logicalCount += 1;
                            lineComplex += 1;
                            j = i + 1;
                        } else if ((c == '&' || c == '|')) {
                            logicalCount += 1;
                            lineComplex += 1;
                        }

                    }

                }

            } else if (line.contains("for") && !line.contains("//") && multiline == 0) {
                iterative += 2;
                lineComplex += 2;
                if (line.contains("&&") || line.contains("||") || line.contains("&") || line.contains("|")) {
                    String character = "a";
                    line += character;
                    int j = line.length() + 1;
                    for (int i = 0; i < line.length() - 1; i++) {
                        if (i == j) {
                            continue;
                        }

                        char c = line.charAt(i);
                        char cn = line.charAt(i + 1);

                        if ((c == '&' && cn == '&')) {
                            logicalCount += 1;
                            lineComplex += 1;
                            j = i + 1;

                        } else if ((c == '|' && cn == '|')) {
                            logicalCount += 1;
                            lineComplex += 1;
                            j = i + 1;
                        } else if ((c == '&' || c == '|')) {
                            logicalCount += 1;
                            lineComplex += 1;
                        }

                    }

                }

            } else if (line.contains("while") && !line.contains("//") && multiline == 0) {
                iterative += 2;
                lineComplex += 2;
                if (line.contains("&&") || line.contains("||") || line.contains("&") || line.contains("|")) {
                    String character = "a";
                    line += character;
                    int j = line.length() + 1;
                    for (int i = 0; i < line.length() - 1; i++) {
                        if (i == j) {
                            continue;
                        }

                        char c = line.charAt(i);
                        char cn = line.charAt(i + 1);

                        if ((c == '&' && cn == '&')) {
                            logicalCount += 1;
                            lineComplex += 1;
                            j = i + 1;

                        } else if ((c == '|' && cn == '|')) {
                            logicalCount += 1;
                            lineComplex += 1;
                            j = i + 1;
                        } else if ((c == '&' || c == '|')) {
                            logicalCount += 1;
                            lineComplex += 1;
                        }

                    }

                }

            } else if (line.contains("do") && !line.contains("//") && multiline == 0) {
                iterative += 2;
                lineComplex += 2;
                if (line.contains("&&") || line.contains("||") || line.contains("&") || line.contains("|")) {
                    String character = "a";
                    line += character;
                    int j = line.length() + 1;
                    for (int i = 0; i < line.length() - 1; i++) {
                        if (i == j) {
                            continue;
                        }

                        char c = line.charAt(i);
                        char cn = line.charAt(i + 1);

                        if ((c == '&' && cn == '&')) {
                            logicalCount += 1;
                            lineComplex += 1;
                            j = i + 1;

                        } else if ((c == '|' && cn == '|')) {
                            logicalCount += 1;
                            lineComplex += 1;
                            j = i + 1;
                        } else if ((c == '&' || c == '|')) {
                            logicalCount += 1;
                            lineComplex += 1;
                        }

                    }

                }

            } else if (line.contains("switch") && !line.contains("//") && multiline == 0) {
                switchCount += 1;
                lineComplex += 1;

                //implement case count
            } 
            else if (line.contains("case") && !line.contains("//") && multiline == 0) {
                caseCount += 1;
                lineComplex += 1;

                //implement case count
            }
            else if (line.contains("catch") && !line.contains("//") && multiline == 0) {
                switchCount += 1;
                lineComplex += 1;

            } else {
                TotalCom = ifCount + iterative + switchCount +caseCount+ logicalCount + catchCount;
            }
            System.out.println("line complexity" + lineComplex);
            com.add(lineComplex);

            System.out.println(lineNo);
            line = reader.readLine();
        }

        reader.close();
        return TotalCom;
    }

    public void getComplexityLineByLine() {
        System.out.println("##################################CTC COMPLEXITY########################################");

        for (int i = 0; i < com.size(); i++) {
            System.out.println("complexity of line :" + (i + 1) + " " + com.get(i));
        }
        System.out.println("############################################################################################");
    }

}
