/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmprojectapp;

import calculation.CheckComplexity;
import calculation.CountInheritance;
import calculation.CheckNestingComplexity;
import calculation.controlStructureComplexity;
import com.jfoenix.controls.JFXButton;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RASINDU
 */
public class TotalComplexityInterfaceController implements Initializable {

    @FXML
    private JFXButton backBTN;

    @FXML
    private Label tcLbl;

    public int totalWeight;
    public int ctcVal, csTot, cncVal, ciVal;
    int initializeCount;

    CheckComplexity cs = new CheckComplexity();
    CheckNestingComplexity nc = new CheckNestingComplexity();
    controlStructureComplexity ctc = new controlStructureComplexity();
    CountInheritance ci = new CountInheritance();
    String path = FXMLDocumentController.filepath.replace("\\", "/");
    File file = new File(path);

    public void initialize() throws FileNotFoundException, IOException {
//        is.calIf(file);
//        is.logicalCalculation(file);
//        is.bitwiseCalculation(file);
//
//        ic.calFor(file);
//        ic.calWhile(file);
//        ic.calDoWhile(file);
//
//        cc.calCatch(file);
//
//        sc.calSwitch(file);
//        sc.calCases(file);
      
//        ciVal = ci.getTotal();
       

        initializeCount++;
    }

    @FXML
    void backAction(ActionEvent event) {
        Stage stage = (Stage) backBTN.getScene().getWindow();
        stage.close();
    }

    @FXML
    void calculateCtc(ActionEvent event) throws IOException {
        if (initializeCount == 0) {
            initialize();

        }
        int totalWeight = ctcVal + cncVal + ciVal;
        int cpsVal = csTot * totalWeight;
        int cp = totalWeight * cpsVal;

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         tcLbl.setText(Integer.toString(ReportController.totalComplexity));
    }

}
