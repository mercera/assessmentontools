/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmprojectapp;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import calculation.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author RASINDU
 */
public class CtcInterfaceController implements Initializable {

    @FXML
    private JFXButton backBTN;

     @FXML
    private Label ctcLbl;

    public CtcInterfaceController() {
        setFile();
    }

  

    String path = FXMLDocumentController.filepath.replace("\\", "/");
    File file = new File(path);
    int initializeCount = 0;
    static int TotalCom = 0;

    controlStructureComplexity ctc = new controlStructureComplexity();
    CheckNestingComplexity cnc=new CheckNestingComplexity();
//    CountInheritance ci=new CountInheritance();
    ReportController rp=new ReportController();

    public void setFile() {
        ctc.setFile(file);
    }

//
    @FXML
    void backAction(ActionEvent event) {
        Stage stage = (Stage) backBTN.getScene().getWindow();
        stage.close();
    }

    @FXML
    void calculateCtc(ActionEvent event) throws FileNotFoundException, IOException {
        try {
            if (initializeCount == 0) {
                TotalCom = ctc.calComplexity();
                cnc.setFile(file);
                cnc.readFile();
//                ci.calInheritance(file);
//                rp.calTotalWeight();

                initializeCount++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
//        ifLbl.setText(String.valueOf(is.getTotal()));
//        iteraLbl.setText(String.valueOf(ic.getTotal()));
//        catcLbl.setText(String.valueOf(cc.getTotal()));
//        switLbl.setText(String.valueOf(sc.getTotal()));
//        final int Ctc = is.getTotal() + ic.getTotal() + cc.getTotal() + sc.getTotal();
        ctcLbl.setText(String.valueOf(TotalCom));

    }
    
    @FXML
    void genRep(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("report.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("ABC");
        stage.setScene(new Scene(root1));
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getFile(File f) {
        this.file = f;
    }

}
