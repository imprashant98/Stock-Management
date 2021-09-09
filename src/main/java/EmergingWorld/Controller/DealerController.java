/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import EmergingWorld.JavaClass.Dealer_Table;
import EmergingWorld.JavaClass.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */
public class DealerController implements Initializable {

public Button backButton;
Connection con;
    
    @FXML
    public TableColumn<Dealer_Table, String> DealerGenderCol;

    @FXML
    public Pane RemDealerTopPane;
    
    @FXML
    public TableColumn<Dealer_Table, String> TinCol;

    @FXML
    public Button AddDealerButton;
    
    @FXML
    public TableView<Dealer_Table> DealerTable;

    @FXML
    public TableColumn<Dealer_Table, String> DealerNameCol;

    @FXML
    public Button RemoveDealerButton;
    
    @FXML
    public Button Refresh;

    @FXML
    public AnchorPane RemDealerMainPane;

    @FXML
    public TableColumn<Dealer_Table, String> DealerAddrCol;

    @FXML
    public TableColumn<Dealer_Table, String> DealerIdCol;

    @FXML
public TableColumn<Dealer_Table, String> DealerContact;

    @FXML
public Pane RemDealerBottomPane;
    
     @FXML
     public void AddDealerAction(ActionEvent event) {

            StageManager.getInstance().addDealerStage.show();
            StageManager.getInstance().dealerStage.hide();


    }

    @FXML
    void RemDealerAction(ActionEvent event) {
        int Index = DealerTable.getSelectionModel().getSelectedIndex();
        Dealer_Table selected = DealerTable.getSelectionModel().getSelectedItem();
        String  p = selected.getDid();
        if(Index<0){
            JOptionPane.showMessageDialog(null, "No Dealer Selected");
        }
        else{
            try{
            int c=0; 
            String str1;
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="Delete from Dealer where Dealer_ID = '"+p+"'";
             PreparedStatement stmt=con.prepareStatement(str);
             stmt.executeUpdate(str);
             stmt.close();
             DealerTable.getItems().remove(selected);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
        }
    }
    @FXML
    public void Refresh(ActionEvent event) {
         fill();
    }
    void fill(){
        ObservableList<Dealer_Table> data=FXCollections.observableArrayList();
        
        
        DealerIdCol.setCellValueFactory(new PropertyValueFactory<>("Did"));
        DealerNameCol.setCellValueFactory(new PropertyValueFactory<>("Dname"));
        DealerGenderCol.setCellValueFactory(new PropertyValueFactory<>("Dgender"));
        DealerAddrCol.setCellValueFactory(new PropertyValueFactory<>("Daddr"));
        DealerContact.setCellValueFactory(new PropertyValueFactory<>("Dcontact"));
        TinCol.setCellValueFactory(new PropertyValueFactory<>("Tin"));
        
        DealerTable.setItems(data);
        
        try{
            int c=0; 
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
             String str="select * from Dealer";
             PreparedStatement stmt=con.prepareStatement(str);
             ResultSet rs=stmt.executeQuery(str);
             while(rs.next()){
                data.add(new Dealer_Table(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),String.valueOf(rs.getLong(5)),String.valueOf(rs.getLong(6))));
             }
             DealerTable.setItems(data);
             stmt.close();
             rs.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        fill();
    }

public void onBack(ActionEvent event) {
    StageManager.getInstance().dealerStage.hide();
    StageManager.getInstance().adminStage.show();
    
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
