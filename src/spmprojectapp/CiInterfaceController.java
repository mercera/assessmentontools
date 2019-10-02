/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmprojectapp;

import calculation.CountInheritance;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
public class CiInterfaceController implements Initializable {

    @FXML
    private JFXButton backBTN;
    @FXML
    private JFXButton calBtn;

    @FXML
    private Label ciLbl;

    String path = FXMLDocumentController.filepath.replace("\\", "/");
    File file = new File(path);

    int initializeCount = 0;
    CountInheritance ci = new CountInheritance();

    public void initialize() throws IOException {
        ci.calInheritance(file);
        ci.getTotalCivalue();
        ciLbl.setText(Integer.toString(CountInheritance.totalCiValue));
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
//        ciLbl.setText(String.valueOf(ci.getTotal()));

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
