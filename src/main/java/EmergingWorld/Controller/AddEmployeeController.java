/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.Controller;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

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

import javax.swing.JOptionPane;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */
public class AddEmployeeController implements Initializable {
private static Connection con;
@FXML
public AnchorPane AddEmpMainPane;
@FXML
public Pane AddEmpTopPane;
@FXML
public Pane AddEmpBottomPane;
@FXML
public TextField EmpName;
@FXML
public Label EmpGender;
@FXML
public ComboBox<String> EmpGenderDrop;
@FXML
public TextField EmpMobNo;
@FXML
public Button SubmitButton;
@FXML
public TextField EmpCitizenshipNo;
@FXML
public TextField EmpAddr;
@FXML
public Label labelName;
@FXML
public Label labelAddress;
@FXML
public Label labelContact;
@FXML
public TextField employeeEmail;
@FXML
public Label labelPost;
public Button clearButton;
public Label labelEmail;
@FXML
ComboBox<String> enterPost;



public void entered(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1.1);
    ((Button) e.getSource()).setScaleY(1.1);
}

public void exited(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1);
    ((Button) e.getSource()).setScaleY(1);
}
    
    public int check(String s) {
        int c = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0' || s.charAt(i) == '1' || s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' || s.charAt(i) == '9') {
                c = 1;
            } else {
                c = 0;
                break;
            }
        }
        return c;
    }
    
    
    public static String getCount() throws SQLException {
    String count = "";
        String str1 = "Select * FROM employee";
        PreparedStatement stmt1 = con.prepareStatement(str1);
        ResultSet res = stmt1.executeQuery(str1);
        while (res.next()) {
            count = res.getString(1);
        }
        return count;
    }
    public static long getCitizen() throws SQLException {
        long citizen = 0;
        String str1 = "Select * FROM employee";
        PreparedStatement stmt1 = con.prepareStatement(str1);
        ResultSet res = stmt1.executeQuery(str1);
        while (res.next()) {
            citizen = res.getLong("Citizenship_No");
        }
        return citizen;
    }
    @FXML
    public void SubmitAction(ActionEvent event) {
        int c1 = check(EmpMobNo.getText());
        int c2 = check(EmpCitizenshipNo.getText());
        int length  = EmpMobNo.getText().length();
       
        if (c1 == 0 ||
                    length < 10  ||
                    c2 == 0 ||
                    EmpName.getText().equals("") ||
                    EmpAddr.getText().equals("") ||
                   
                    employeeEmail.equals("")||
                    String.valueOf(enterPost.getValue()).equals("")||
                    String.valueOf(EmpGenderDrop.getValue()).equals("")) {
            JOptionPane.showMessageDialog(null, "Check your Information Carefully");

        } 
        else {
            long p = Long.parseLong(EmpMobNo.getText());
            long q = Long.parseLong(EmpCitizenshipNo.getText());
            String name = EmpName.getText();
            String gender = String.valueOf(EmpGenderDrop.getValue());
            String address = EmpAddr.getText();
            String post = String.valueOf(enterPost.getValue());
            String email = employeeEmail.getText();
           
           
            try {
                String count;
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
               
                        count = getCount();
                        String c = count.charAt(1) + "" + count.charAt(2) + "" + count.charAt(3);
                        int o = Integer.parseInt(c);
                        String  k = "E" + (o + 1);
                        //id = k;
                        Statement s = con.createStatement();
                        String stmt = "INSERT INTO employee(Emp_ID,Name,Gender,Address,Contact_No,Citizenship_No,designation,email) " +
                                              "VALUES('" + k + "','" + name + "','" + gender + "','" + address + "','" + p + "','" + q + "','" + post + "','" + email + "');";
    
                        s.executeUpdate(stmt);
                        con.close();
    
    
                        JOptionPane.showMessageDialog(null, "Employee Added");

                    
                    EmpName.setText("");
                    EmpAddr.setText("");
                    EmpMobNo.setText("");
                    EmpCitizenshipNo.setText("");
                    employeeEmail.setText("");
                    EmpGenderDrop.getSelectionModel().clearSelection();
                    enterPost.getSelectionModel().clearSelection();
                    
                    
                   StageManager.getInstance().addEmployeeStage.hide();
                   StageManager.getInstance().employeeStage.show();
                   
                   
                } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
    
    
        }
    }

/**
 * Initializes the controller class.
 */
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> options = FXCollections.observableArrayList("Male","Female");
    
        enterPost.getItems().addAll("Owner", "Branch Manager","Associate Manager","Salesman","Accountant","Receptionist","Cleaner");
        
        EmpGenderDrop.setItems(options);
    }



public void onBack(ActionEvent event) {
    StageManager.getInstance().addEmployeeStage.hide();
    StageManager.getInstance().employeeStage.show();
    }

public void onClear(ActionEvent event) {
}
}
