package EmergingWorld.Controller;

import EmergingWorld.JavaClass.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */

public class RegisterController implements Initializable {
@FXML
public Button registerButton;
@FXML
public Button clearButton;
@FXML
public Button backButton;
@FXML
public ComboBox<String> SelectQuestion;
@FXML
public TextField Answer;

@FXML
Pane registerLayout;
@FXML
TextField txtName;
@FXML
TextField txtAddress;
@FXML
TextField txtContact;
@FXML
TextField txtEmail;
@FXML
TextField txtUsername;
@FXML
PasswordField txtPassword;
@FXML
PasswordField txtConfirmPassword;
@FXML
Label lblName;

@FXML
Label lblAddress;
@FXML
Label lblContact;
@FXML
Label lblEmail;
@FXML
Label lblUsername;
@FXML
Label lblPassword;
@FXML
Label lblConfirmPassword;


String[] Q = new String[3];

public static Connection getConnection() {
    Connection con = null;
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
        
        
    } catch (ClassNotFoundException | SQLException ex) {
        
        new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
    }
    return con;
}




public void entered(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1.1);
    ((Button) e.getSource()).setScaleY(1.1);
}

public void exited(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1);
    ((Button) e.getSource()).setScaleY(1);
}

public boolean Register(String name, String address, String contact, String email, String username, String password,String question,String answer) throws SQLException {
    Connection con = getConnection();
    
    
    
    String sqlSelect = "INSERT INTO userbase( name, address, contact, email, username, password,Question,Answer) VALUES ('" + name + "','" + address + "','" + contact + "','" + email + "','" + username + "','" + password + "','" + question + "','" + answer + "');";
    
   // String sqlSelect = "INSERT INTO userbase( name, address, contact, email, username, password, Question, Answer) VALUES ('" + name + "','" + address + "','" + contact + "','" + email + "','" + username + "','" + password + "','" + question + "','" + answer + "');";
    
    Statement s = con.createStatement();
    s.executeUpdate(sqlSelect);
    
    return true;
}

public void setAllFieldsToDefault() {
    txtConfirmPassword.clear();
    txtPassword.clear();
    txtUsername.clear();
    txtEmail.clear();
    txtContact.clear();
    txtAddress.clear();
    txtName.clear();
    Answer.clear();
    SelectQuestion.getSelectionModel().clearSelection();
}

public void onRegister(ActionEvent e) {
    
    String name, address, email, contact, username, password, password2,question,answer;
    
    name = txtName.getText();
    address = txtAddress.getText();
    contact = txtContact.getText();
    email = txtEmail.getText();
    username = txtUsername.getText();
    password = txtPassword.getText();
    password2 = txtConfirmPassword.getText();
    question = SelectQuestion.getValue();
    answer = Answer.getText();
    
    if (password.equals(password2)) {
        try {
           // int id = count("SN", "userbase");
            Register(name, address, contact, email, username, password, question, answer);
            new Alert(Alert.AlertType.CONFIRMATION, "Registered Successfully", ButtonType.FINISH).showAndWait();
            setAllFieldsToDefault();
            StageManager.getInstance().registerStage.hide();
            StageManager.getInstance().mainLoginStage.show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    } else {
        new Alert(Alert.AlertType.ERROR, "Password not Matched", ButtonType.OK).showAndWait();
        
    }
    
    
}

public void onClear(ActionEvent e) {
    new Alert(Alert.AlertType.WARNING, "Are you sure you want to clear entered Data?", ButtonType.APPLY).showAndWait();
   setAllFieldsToDefault();
}

public void onBack(ActionEvent e) {
    new Alert(Alert.AlertType.WARNING, "Are You Sure?\nYou want to go Back?", ButtonType.YES).showAndWait();
    StageManager.getInstance().registerStage.hide();
    StageManager.getInstance().mainLoginStage.show();
}


@Override
public void initialize(URL location, ResourceBundle resources) {
    
    lblName.setLabelFor(txtName);
    lblAddress.setLabelFor(txtAddress);
    lblContact.setLabelFor(txtContact);
    lblEmail.setLabelFor(txtEmail);
    lblUsername.setLabelFor(txtUsername);
    lblPassword.setLabelFor(txtPassword);
    lblConfirmPassword.setLabelFor(txtConfirmPassword);
   
    
    
    int i = 0;
    try{
        Connection con;
        int c=0;
        String str1;
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
        String str="select * from Security";
        PreparedStatement stmt=con.prepareStatement(str);
        ResultSet rs=stmt.executeQuery(str);
        while(rs.next()){
            Q[i] = rs.getString(1);
            i++;
        }
        stmt.close();
        rs.close();
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    
    }
    ObservableList<String> options = FXCollections.observableArrayList(Q[0],Q[1],Q[2]);
    SelectQuestion.setItems(options);

    
}
}
