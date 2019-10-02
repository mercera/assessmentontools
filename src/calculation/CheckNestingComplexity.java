/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import spmprojectapp.FXMLDocumentController;
import spmprojectapp.ReportController;

/**
 *
 * @author smadurawala1
 */
public class CheckNestingComplexity {

    File file;
    int TotalCom = 0;
    int multiline = 0;

    public static ArrayList<Integer> com = new ArrayList<Integer>();

    public void setFile(File f) {
        this.file = f;
    }

    public int readFile() throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = reader.readLine();
        int nesting = 0;
        while (line != null) {
            int lineComplex = 0;
            System.out.println(line);
            
            if(!(line.trim().length() > 0)){
                lineComplex = 0;
                TotalCom += 0;
                 
            }
            
            if(line.contains("/*") || line.contains("*")){
                multiline = 1;
                if(line.contains("*/")){
                    multiline = 0;
                    lineComplex = 0;
                    TotalCom += 0;
                     
                }
                
                
            }
            
            if(line.contains("//") && (multiline == 0)){
                
            }

            String[] words = {"if", "for", "while", "else","switch"};
            

            if (line.contains("}") && nesting > 0) {
                nesting -= 1;
            }
            
            

            if (nesting > 0 && !(line.contains("//") && (multiline == 0))) {
                lineComplex += nesting;
                TotalCom += nesting;
            }

            for (String word : words) {
                if (line.contains(word)) {
                    if (line.contains("else")) {
                        nesting += 1;
                    } else {
                        lineComplex += 1;
                        TotalCom += 1;
                        nesting += 1;
                    }
                }
            }

            System.out.println("Line complexity:" + lineComplex);
            com.add(lineComplex);
            line = reader.readLine();
        }
        reader.close();
        return TotalCom;
    }

    public void getComplexityLineByLine() {
        System.out.println("##################################CNC COMPLEXITY########################################");
        for (int i = 0; i < com.size(); i++) {
            System.out.println("complexity of line :" + (i + 1) + " " + com.get(i));
        }
        System.out.println("#######################################################################################");
    }

}
