/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import EmergingWorld.JavaClass.Purchase_Table;
import EmergingWorld.JavaClass.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */
public class PurchasesController implements Initializable {
public Button backButton;
Connection con;

    
    @FXML
    public TextField PurchaseProductIdTextField;

    @FXML
    public Pane purchasesBottomPane;

    @FXML
    public Button PurchaseDateButton;
    
    @FXML
    public TableColumn<Purchase_Table, String> CompanyCol;
    
    @FXML
    public TableColumn<Purchase_Table, String> QuantityCol;

    @FXML
    public TableColumn<Purchase_Table, String> PriceCol;

    @FXML
    public TableColumn<Purchase_Table, String> PurchaseProductNameCol;

    @FXML
    public Button DealersButton;

    @FXML
    public Pane purchasesTopPane;
    
    @FXML
    private Button RefreshButton;

    @FXML
    public TableColumn<Purchase_Table, String> PurchaseProductIdCol;

    @FXML
    public Button PurchaseProductIdButton;

    @FXML
    public TableColumn<Purchase_Table, String> PurchaseDealerNameCol;

    @FXML
    public DatePicker PurchaseDate;

    @FXML
    public TableColumn<Purchase_Table, String> PurchaseDateCol;

    @FXML
    public AnchorPane PurchasesMainPane;

    @FXML
    public TableView<Purchase_Table> PurchaseTable;
    
    @FXML
    void RefreshAction(ActionEvent event) {
        ObservableList<Purchase_Table> data=FXCollections.observableArrayList();
        
        
        PurchaseProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Bid"));
        CompanyCol.setCellValueFactory(new PropertyValueFactory<>("Company"));
        PurchaseProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        PurchaseDealerNameCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("PricePerPiece"));
        PurchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        PurchaseTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="select * from Purchased_Item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                 String k = rs.getString(6);
                 if(k==null)
                     k = "N.A.";
                data.add(new Purchase_Table(rs.getString(1),rs.getString(2),rs.getString(3),String.valueOf(rs.getString(4)),String.valueOf(rs.getLong(5)),k,rs.getString(7)));
             }
             PurchaseTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }

    @FXML
    public void SearchByDateAction(ActionEvent event) {
        String d = String.valueOf(PurchaseDate.getValue());
        ObservableList<Purchase_Table> data=FXCollections.observableArrayList();
        
        
        PurchaseProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Bid"));
        CompanyCol.setCellValueFactory(new PropertyValueFactory<>("Company"));
        PurchaseProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        PurchaseDealerNameCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("PricePerPiece"));
        PurchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        PurchaseTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="select * from Purchased_Item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                 if(rs.getString(7).equals(d)){
                     String k = rs.getString(6);
                 if(k==null)
                     k = "N.A.";
                data.add(new Purchase_Table(rs.getString(1),rs.getString(2),rs.getString(3),String.valueOf(rs.getString(4)),String.valueOf(rs.getLong(5)),k,rs.getString(7)));
             
                 }
            }
             
             PurchaseTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }

    @FXML
    public void SearchByPidAction(ActionEvent event) {
        String d = String.valueOf(PurchaseProductIdTextField.getText());
        ObservableList<Purchase_Table> data=FXCollections.observableArrayList();
        
        
        PurchaseProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Bid"));
        CompanyCol.setCellValueFactory(new PropertyValueFactory<>("Company"));
        PurchaseProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        PurchaseDealerNameCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("PricePerPiece"));
        PurchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        PurchaseTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="select * from Purchased_Item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                 if(rs.getString(1).equals(d)){
                     String k = rs.getString(6);
                 if(k==null)
                     k = "N.A.";
                data.add(new Purchase_Table(rs.getString(1),rs.getString(2),rs.getString(3),String.valueOf(rs.getString(4)),String.valueOf(rs.getLong(5)),k,rs.getString(7)));
             
                 }
             }
             
             PurchaseTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }

    @FXML
    public  void DealersAction(ActionEvent event) {

        StageManager.getInstance().dealerStage.show();
        StageManager.getInstance().purchaseStage.hide();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Purchase_Table> data=FXCollections.observableArrayList();
        
        
        PurchaseProductIdCol.setCellValueFactory(new PropertyValueFactory<>("Bid"));
        CompanyCol.setCellValueFactory(new PropertyValueFactory<>("Company"));
        PurchaseProductNameCol.setCellValueFactory(new PropertyValueFactory<>("Pname"));
        QuantityCol.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        PurchaseDealerNameCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("PricePerPiece"));
        PurchaseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
       
        PurchaseTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="select * from Purchased_Item";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){String k = rs.getString(6);
                 if(k==null)
                     k = "N.A.";
                data.add(new Purchase_Table(rs.getString(1),rs.getString(2),rs.getString(3),String.valueOf(rs.getString(4)),String.valueOf(rs.getLong(5)),k,rs.getString(7)));
             }
             PurchaseTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }

public void entered(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1.1);
    ((Button) e.getSource()).setScaleY(1.1);
}

public void exited(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1);
    ((Button) e.getSource()).setScaleY(1);
}

public void onBack(ActionEvent event) {
        StageManager.getInstance().adminStage.show();
        StageManager.getInstance().purchaseStage.hide();
}
}
