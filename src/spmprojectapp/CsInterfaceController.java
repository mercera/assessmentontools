/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmprojectapp;

import calculation.CheckComplexity;
import static calculation.controlStructureComplexity.com;
import com.jfoenix.controls.JFXButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RASINDU
 */
public class CsInterfaceController implements Initializable {

    @FXML
    private JFXButton backBTN;

    @FXML
    private Label arithLbl;

    @FXML
    private Label relaLbl;

    @FXML
    private Label logiLbl;

    @FXML
    private Label bitLbl;

    @FXML
    private Label csLbl;

    @FXML
    private JFXButton reportBtn;

    @FXML
    private JFXButton calBtn;

    @FXML
    private Label misLbl;

    @FXML
    private Label manLbl;

    @FXML
    private Label assLbl;

    @FXML
    private Label numLbl;

    @FXML
    private Label dblLbl;

    @FXML
    private Label ndttLbl;

    @FXML
    private Label clsLbl;

    String path = FXMLDocumentController.filepath.replace("\\", "/");
    File file = new File(path);
    BufferedReader reader;
    int initializeCount = 0;

    public static ArrayList<Integer> com = new ArrayList<Integer>();

    static int TotalCom = 0;
    int arithmatic = 0, relational = 0, logical = 0, bitwise = 0, miscellanous = 0,
            keywords = 0, manipulators = 0, assignment = 0, numeric = 0, doubleqoutes = 0,
            ndtts = 0, classmethodetc = 0;

    CheckComplexity check = new CheckComplexity();

    public void readFile() {
        try {
            reader = new BufferedReader(new FileReader(file));

            String line = reader.readLine();
            while (line != null) {
                int lineComplexity = 0;
                System.out.println(line);

                int c = check.arithmatic(line);
                arithmatic += c;
                System.out.println("arithmatic complexity: " + c);
                int d = check.relational(line);
                relational += d;
                System.out.println("relational complexity: " + d);
                int e = check.logical(line);
                logical += e;
                System.out.println("logical complexity: " + e);
                int f = check.bitwise(line);
                bitwise += f;
                System.out.println("bitwise complexity: " + f);
                int g = check.miscellanous(line);
                miscellanous += g;
                System.out.println("miscellanous complexity: " + g);
                int h = check.keywords(line);
                keywords += h;
                System.out.println("keywords complexity: " + h);
                int i = check.manipulators(line);
                manipulators += i;
                System.out.println("Manipulators complexity: " + i);
                int j = check.assignment(line);
                assignment += j;
                System.out.println("Assignment complexity: " + j);
                int k = check.numeric(line);
                numeric += k;
                System.out.println("Numeric complexity: " + k);
                int l = check.doubleqoutes(line);
                doubleqoutes += l;
                System.out.println("Double Qoutes: " + l);
                int m = check.ndttskeywords(line);
                ndtts += m;
                System.out.println("ndtts keywords: " + m);
                int[] n = check.classMethodObject(line);
                classmethodetc += n[0] + n[2] + n[3];
                System.out.println("class,method,etc: " + n);
                TotalCom += c;
                TotalCom += d;
                TotalCom += e;
                TotalCom += f;
                TotalCom += g;
                TotalCom += h;
                TotalCom += i;
                TotalCom += j;
                TotalCom += k;
                TotalCom += l;
                TotalCom += m;
                TotalCom += n[0]+ n[2] + n[3];
                line = reader.readLine();

                lineComplexity = c + d + e + f + g + h + i + j + k + l + m + n[0]  + n[2] + n[3];
                com.add(lineComplexity);

            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        initializeCount++;
    }

    public void displayCsComplexity() {
        System.out.println("##################################CS COMPLEXITY########################################");

        for (int i = 0; i < com.size(); i++) {
            System.out.println("complexity of line :" + (i + 1) + " " + com.get(i));
        }
        System.out.println("############################################################################################");

    }

    @FXML
    void backAction(ActionEvent event) {
        Stage stage = (Stage) backBTN.getScene().getWindow();
        stage.close();
    }

    @FXML
    void calculateCtc(ActionEvent event) {
        if (initializeCount == 0) {
            readFile();

        }

        arithLbl.setText(String.valueOf(arithmatic));
        relaLbl.setText(String.valueOf(relational));
        logiLbl.setText(String.valueOf(logical));
        bitLbl.setText(String.valueOf(bitwise));
        misLbl.setText(String.valueOf(miscellanous));
        manLbl.setText(String.valueOf(manipulators));
        assLbl.setText(String.valueOf(assignment));
        numLbl.setText(String.valueOf(numeric));
        dblLbl.setText(String.valueOf(doubleqoutes));
        ndttLbl.setText(String.valueOf(ndtts));
        clsLbl.setText(String.valueOf(classmethodetc));
        csLbl.setText(String.valueOf(TotalCom));

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
