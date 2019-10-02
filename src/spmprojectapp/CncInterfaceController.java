/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmprojectapp;

import calculation.CheckNestingComplexity;
import com.jfoenix.controls.JFXButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RASINDU
 */
public class CncInterfaceController implements Initializable {

    @FXML
    private JFXButton backBTN;

    @FXML
    private Label cncLbl;

    @FXML
    private JFXButton calBtn;

    public CncInterfaceController() {
        setFile();
    }

    String path = FXMLDocumentController.filepath.replace("\\", "/");
    File file = new File(path);
    BufferedReader reader;
    int initializeCount = 0;

    static int TotalCom = 0;

    int nesting = 0;

    CheckNestingComplexity nc = new CheckNestingComplexity();

    public void setFile() {
        nc.setFile(file);
    }

    @FXML
    void backAction(ActionEvent event) {
        Stage stage = (Stage) backBTN.getScene().getWindow();
        stage.close();
    }

    @FXML
    void calculateCtc(ActionEvent event) throws IOException {
        if (initializeCount == 0) {
            TotalCom = nc.readFile();
            initializeCount++;
        }

        cncLbl.setText(String.valueOf(TotalCom));

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
