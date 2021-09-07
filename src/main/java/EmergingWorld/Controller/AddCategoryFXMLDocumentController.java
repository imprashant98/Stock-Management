/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.Controller;

import EmergingWorld.JavaClass.StageManager;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */
public class AddCategoryFXMLDocumentController implements Initializable {
@FXML
public javafx.scene.layout.AnchorPane AnchorPane;
@FXML
public Pane Pane1;
@FXML
public ImageView Pane1Image;
@FXML
public Pane Pane2;
@FXML
public Label CategoryLabel;
@FXML
public Button CategoryButton;
@FXML
public TextField CategoryText;
@FXML
public Button backButton;


Connection con;

public void entered(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1.1);
    ((Button) e.getSource()).setScaleY(1.1);
}

public void exited(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1);
    ((Button) e.getSource()).setScaleY(1);
}




@Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
public void categoryButton(ActionEvent event) {
            if (CategoryText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Field Cannot be Empty");
            } else {
                try {
                
                    String str1;
                    Class.forName("java.sql.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
                    str1 = "insert into category values(?)";
                    PreparedStatement stmt = con.prepareStatement(str1);
                    stmt.setString(1, CategoryText.getText());
                    stmt.executeUpdate();
                   String str2="create table "+CategoryText.getText()+"" +
                           "(Company varchar(40) NOT NULL,ProductName varchar(100) NOT NULL,Quantity int(3) NOT NULL,Pricepp int(7) NOT NULL," +
                           "dealerid varchar(5),PRIMARY KEY(Company,ProductName),FOREIGN KEY (dealerid) REFERENCES dealer(Dealer_ID) ) ";
                   PreparedStatement stmt1=con.prepareStatement(str2);
                    stmt1.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Category Added");
                    con.close();
                
                    StageManager.getInstance().addCategoryStage.hide();
                    
                
                } catch (Exception e) {
                    
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }

public void onBack(ActionEvent event) {
    StageManager.getInstance().addCategoryStage.hide();
    
}
}

