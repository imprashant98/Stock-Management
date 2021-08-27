package EmergingWorld.Controller;

import EmergingWorld.JavaClass.StageManager;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;

import javax.swing.JOptionPane;

public class MainLoginController implements Initializable {

public Button exitButton;
Connection con;

    @FXML
    public Button ForgotPassword;
    @FXML
    public TextField UserName;

    @FXML
    public Pane BottomPane;

    @FXML
    public Pane TopPane;

    @FXML
    public AnchorPane AnchorPane;

    @FXML
    public PasswordField Password;

    @FXML
    public Button LoginButton;

public static boolean Login(String username, String password) throws SQLException {
    Connection con = RegisterController.getConnection();
    Statement s = con.createStatement();
    String sqlSelect = "SELECT * FROM userbase WHERE username= '" + username + "' AND password= '" + password + "';";
    
    ResultSet rs = s.executeQuery(sqlSelect);
    return rs.next();
    
}
    
    
    @FXML
   public  void loginclicked(ActionEvent event) {
       
        String varUsername,varPassword;
        varUsername = UserName.getText();
        varPassword = Password.getText();
        if(varUsername.equals("") && varPassword.equals(""))
        {
            new Alert(Alert.AlertType.WARNING, "UserId and Password not Entered",ButtonType.OK).showAndWait();
        }
        else{
            try {
               if( Login(varUsername,varPassword))
               {
                   new Alert(Alert.AlertType.CONFIRMATION, "Login Successful!", ButtonType.OK).showAndWait();
                   UserName.clear();
                    Password.clear();
                     StageManager.getInstance().mainLoginStage.hide();
                      StageManager.getInstance().adminStage.show();

               }
               else
               {
                   new Alert(Alert.AlertType.ERROR, "Incorrect User id or Password!", ButtonType.OK).showAndWait();
               }



            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
       
    }

    @FXML
   public  void forgotPasswordAction(ActionEvent event) throws IOException {

        StageManager.getInstance().forgetPasswordStage.show();
        StageManager.getInstance().mainLoginStage.hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
public void entered(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1.1);
    ((Button) e.getSource()).setScaleY(1.1);
}

public void exited(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1);
    ((Button) e.getSource()).setScaleY(1);
}

public void onExit(ActionEvent event) {
        System.exit(0);
}

public void createAccount(MouseEvent mouseEvent) {
    StageManager.getInstance().registerStage.show();
    StageManager.getInstance().mainLoginStage.hide();
    
}
}
