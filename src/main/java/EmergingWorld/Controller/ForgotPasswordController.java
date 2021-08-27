/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.Controller;

import EmergingWorld.JavaClass.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */
public class ForgotPasswordController implements Initializable {


@FXML
public Button backButton;
@FXML
public Label labelUsername;
@FXML
public TextField txtUsername;
@FXML
public Pane pane1;
@FXML
public TextField Answer;
@FXML
public ComboBox<String> SelectQuestion;
@FXML
public AnchorPane mainPane;
@FXML
public Button SubmitB;
@FXML
public PasswordField NewPass;
@FXML
public Button SetPass;
@FXML
public PasswordField NewPass1;
Connection con;
String[] Q = new String[3];

@FXML
public void SetPassAction(ActionEvent event) {
    String a = NewPass.getText();
    String b = NewPass1.getText();
    if (a.length() < 6) {
        JOptionPane.showMessageDialog(null, "Password must contain at least 6 characters");
    } else if (a.equals(b) == false) {
        JOptionPane.showMessageDialog(null, "Passwords do not match");
    } else {
        try {
            int c = 0;
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            String str = "update user set Password  = '" + a + "'";
            PreparedStatement stmt = con.prepareStatement(str);
            stmt.executeUpdate(str);
            stmt.close();
            JOptionPane.showMessageDialog(null, "Password Changed");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        SetPass.setDisable(true);
        Stage stage = (Stage) SetPass.getScene().getWindow();
        stage.close();
    }
}

@FXML
public void SubmitAction(ActionEvent event) {
    try {
        int c = 0;
        String str1;
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
        String str = "select * from userbase";
        PreparedStatement stmt = con.prepareStatement(str);
        ResultSet rs = stmt.executeQuery(str);
        while (rs.next()) {
            if (txtUsername.getText().equals(rs.getString("username")) &&
                        String.valueOf(SelectQuestion.getValue()).equalsIgnoreCase(rs.getString("Question"))
                        && Answer.getText().equalsIgnoreCase(rs.getString("Answer"))) {
                SetPass.setDisable(false);
            }
            else{SetPass.setDisable(true);}
        }
        stmt.close();
        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        
    }
}

/**
 * Initializes the controller class.
 */
@Override
public void initialize(URL url, ResourceBundle rb) {
    int i = 0;
    try {
        int c = 0;
        String str1;
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
        String str = "select * from Security";
        PreparedStatement stmt = con.prepareStatement(str);
        ResultSet rs = stmt.executeQuery(str);
        while (rs.next()) {
            Q[i] = rs.getString(1);
            i++;
        }
        stmt.close();
        rs.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        
    }
    ObservableList<String> options = FXCollections.observableArrayList(Q[0], Q[1], Q[2]);
    SelectQuestion.setItems(options);
}

public void onBack(ActionEvent event) {
    StageManager.getInstance().forgetPasswordStage.hide();
    StageManager.getInstance().mainLoginStage.show();
}

public void entered(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1.1);
    ((Button) e.getSource()).setScaleY(1.1);
}

public void exited(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1);
    ((Button) e.getSource()).setScaleY(1);
}
}
