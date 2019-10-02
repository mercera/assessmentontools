/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmprojectapp;

import com.jfoenix.controls.JFXButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import calculation.*;

/**
 *
 * @author RASINDU
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button chooseBtn;
    
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private Label fileLBL;
    
    @FXML
    private JFXButton nextBTN;
    
    public static String filepath;
    public static String filename;
    
    @FXML
    void filePicker(ActionEvent event) throws FileNotFoundException, IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("java files", "*.java"));
        
        File f = fc.showOpenDialog(null);
        
        filepath = f.getAbsolutePath();
        filename = f.getName();
        
        if (f != null) {
            System.out.println(f.getAbsolutePath());
            fileLBL.setText(f.getName());
            nextBTN.setVisible(true);
            
        }
        CtcInterfaceController ctc = new CtcInterfaceController();
        ctc.getFile(f);
    }
    
    @FXML
    void loadSecond(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("second.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), rootPane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
    
}
