/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmprojectapp;

import calculation.CheckNestingComplexity;
import calculation.CheckRecursion;
import calculation.CountInheritance;
import calculation.controlStructureComplexity;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author RASINDU
 */
public class ReportController implements Initializable {
    
    public static int totalComplexity=0; 

    public ReportController() {

    }

    String path = FXMLDocumentController.filepath.replace("\\", "/");
    File file = new File(path);

    controlStructureComplexity ctc = new controlStructureComplexity();
    CheckNestingComplexity cnc = new CheckNestingComplexity();
    CsInterfaceController cs = new CsInterfaceController();
    CountInheritance ci = new CountInheritance();
    CheckRecursion re = new CheckRecursion();

    public void setFile() {
        ctc.setFile(file);
    }

    int lineComplexity;

    static ArrayList<Integer> totalWeight = new ArrayList<Integer>();
    static ArrayList<Integer> cps = new ArrayList<Integer>();
    static ArrayList<Integer> cr = new ArrayList<Integer>();

    int initializeCount = 0;
    static int TotalCom = 0;

    @FXML
    private TableView<?> tblReport;

    @FXML
    private TableColumn<?, ?> lineColumn;

    @FXML
    private TableColumn<?, ?> totalWeightColumn;

    @FXML
    private Button reportBtn;

    public void calTotalWeight() {
        int totalLines = CheckNestingComplexity.com.size();
        for (int i = 0; i < totalLines; i++) {
            int ctc_line_complexity = controlStructureComplexity.com.get(i);
            int cnc_line_complexity = CheckNestingComplexity.com.get(i);
            int ci_line_complexity = CountInheritance.com.get(i);
            int total = ctc_line_complexity + cnc_line_complexity + ci_line_complexity;

            totalWeight.add(total);

            System.out.println(" Total complexity of line " + (i + 1) + "is :" + (total));
        }

    }

    public void calCps() {
        int totalLines = CsInterfaceController.com.size();
        for (int i = 0; i < totalLines; i++) {
            int totalWeightLineComplexity = totalWeight.get(i);
            int csLineComplexity = CsInterfaceController.com.get(i);
            int ctcValueLineByLine = totalWeightLineComplexity * csLineComplexity;
            cps.add(ctcValueLineByLine);

            System.out.println("Cps value of line " + (i + 1) + "is :" + (ctcValueLineByLine));

        }
    }

    public Boolean calRecursive() {

        int[] recursiveLines = re.findRecursion(file);
        System.out.println(recursiveLines[0] + " " + recursiveLines[1]);
        if (recursiveLines.length > 0) {
            if (recursiveLines[2] == 0) {
                for (int i = recursiveLines[0]; i < recursiveLines[1]; i++) {
                    cr.add(cps.get(i - 1) * 2);
                    System.out.println("CR value of line " + i + "is : " + cps.get(i - 1) * 2);
                }

            } else {
                for (int i = recursiveLines[0]; i < recursiveLines[1]; i++) {
                    cr.add(cps.get(i - 1) * 2);
                    System.out.println("CR value of line " + i + "is : " + cps.get(i - 1) * 2);
                }

                for (int i = recursiveLines[2]; i < recursiveLines[3]; i++) {
                    cr.add(cps.get(i - 1) * 2);
                    System.out.println("CR value of line " + i + "is : " + cps.get(i - 1) * 2);
                }

            }
            return true;

        } else {
            return false;
        }

    }

    public void calTotalCom(Boolean state) {
        
        if (state == true) {
            for (int i = 0; i < cr.size(); i++) {
                totalComplexity += cr.get(i);
            }
            System.out.println(totalComplexity);

        } else {
            for (int i = 0; i < cps.size(); i++) {
                totalComplexity += cps.get(i);
            }
            System.out.println(totalComplexity);

        }
    }

    @FXML
    void genReport(ActionEvent event) throws IOException {
        if (initializeCount == 0) {
            setFile();
            TotalCom = ctc.calComplexity();
            cnc.setFile(file);
            cnc.readFile();
            cs.readFile();
            ci.calInheritance(file);

            ctc.getComplexityLineByLine();
            cnc.getComplexityLineByLine();
            ci.getComplexityLineByLine();

            cs.displayCsComplexity();
            calTotalWeight();
            calCps();
            Boolean state = calRecursive();
            calTotalCom(state);

            initializeCount++;
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
