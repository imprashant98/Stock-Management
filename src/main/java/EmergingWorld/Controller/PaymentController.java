/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.Controller;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import EmergingWorld.JavaClass.Payment;
import EmergingWorld.JavaClass.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.JOptionPane;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */
public class PaymentController implements Initializable {



    Connection con;

    @FXML
    public Button search;
    @FXML
    public Button backButton;

    @FXML
    public TextField text_payment;

    @FXML
    public Button viewButton;


    @FXML
    public TextField text_bill;

    @FXML
    public ComboBox<String> sort;
    
    @FXML
    public TableColumn<Payment,String> col_bill;

//    @FXML
//    public TableColumn<Payment,String> col_trid;

    @FXML
    public TableView<Payment> table;

    @FXML
    public TableColumn<Payment,String> col_payMode;
    
     @FXML
     public Button searchID;
     
     
    
     @FXML
   public void OnClick(ActionEvent event) throws ClassNotFoundException, SQLException{
         if ((Button) event.getSource() == search) {
            try {
                ObservableList<Payment> data = FXCollections.observableArrayList();
                 col_bill.setCellValueFactory(new PropertyValueFactory<>("rid"));
                 col_payMode.setCellValueFactory(new PropertyValueFactory<>("rpay"));
                 //col_trid.setCellValueFactory(new PropertyValueFactory<>("rtrx"));
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
                 String str = "select * from payment where payment_mode='" + text_payment.getText() + "'";
                 PreparedStatement stmt = con.prepareStatement(str);
                 ResultSet rs = stmt.executeQuery();
                 if(rs.next()){
                       data.add(new Payment(rs.getString(1),rs.getString(2)));
                 }
                  table.setItems(data);
            }
            catch (ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }

         }


    }
     @FXML
    void OnClickbill(ActionEvent event) {
        if ((Button) event.getSource() == searchID) {
            try {
                ObservableList<Payment> data = FXCollections.observableArrayList();
                 col_bill.setCellValueFactory(new PropertyValueFactory<>("rid"));
                 col_payMode.setCellValueFactory(new PropertyValueFactory<>("rpay"));
                 //col_trid.setCellValueFactory(new PropertyValueFactory<>("rtrx"));
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
                 String str = "select * from payment where bill_id='" + text_bill.getText() + "'";
                 PreparedStatement stmt = con.prepareStatement(str);
                 ResultSet rs = stmt.executeQuery();
                 if(rs.next()){
                       data.add(new Payment(rs.getString(1),rs.getString(2)));
                 }
                  table.setItems(data);
            }
            catch (ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }

         }

    }


public void  fill(){
        ObservableList<Payment> data = FXCollections.observableArrayList();
        col_bill.setCellValueFactory(new PropertyValueFactory<>("rid"));
        col_payMode.setCellValueFactory(new PropertyValueFactory<>("rpay"));
        //col_trid.setCellValueFactory(new PropertyValueFactory<>("rtrx"));
        
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            String str="select * from payment";
            PreparedStatement stmt =con.prepareStatement(str);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                data.add(new Payment(rs.getString(1),rs.getString(2)));
            }
            table.setItems(data);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        table.setItems(data);
        
    }
        
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fill();
    }
public void onView(ActionEvent event){
         fill();
}


public void onBack(ActionEvent event) {
    StageManager.getInstance().adminStage.show();
    StageManager.getInstance().paymentStage.hide();
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


