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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import EmergingWorld.JavaClass.Product1;
import EmergingWorld.JavaClass.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

/**
 *
 * @author Prashant
 */
public class ProductFXMLDocumentController implements Initializable {

public Button homeButton;
public Button backButton;
Connection con;

    @FXML
    public TableColumn<Product1, Integer> TableQuantity;

    @FXML
    public TableColumn<Product1, String> TablePname;

    @FXML
    public ComboBox<String> productChoice;

    @FXML
    public TableView<Product1> productTable;

    @FXML
    public TableColumn<Product1, Integer> TablePrice;

    @FXML
    public TableColumn<Product1, String> TableDId;

    @FXML
    public Button search;

    @FXML
    public TableColumn<Product1, String> TableCname;

    @FXML
    public Pane Pane1;

    @FXML
    public AnchorPane AnchorPane;

    @FXML
    public TableColumn<Product1, Integer> TableSno;

    @FXML
    public ImageView Pane1Image;

    @FXML
    public Pane Pane2;

    @FXML
    public void searchHandle(ActionEvent event) {
        String str1=productChoice.getSelectionModel().getSelectedItem();
        ObservableList<Product1> data = FXCollections.observableArrayList();

        TableSno.setCellValueFactory(new PropertyValueFactory<>("rcoun"));
        TableCname.setCellValueFactory(new PropertyValueFactory<>("rcname"));
        TablePname.setCellValueFactory(new PropertyValueFactory<>("rname"));
        TableQuantity.setCellValueFactory(new PropertyValueFactory<>("rquantity"));
        TablePrice.setCellValueFactory(new PropertyValueFactory<>("rpricepp"));
        TableDId.setCellValueFactory(new PropertyValueFactory<>("rdealerid"));
        //productTable.setItems(data);
        try {
            int c = 0;
    
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            String str = "select * from "+str1+"";
            PreparedStatement stmt = con.prepareStatement(str);
            ResultSet rs = stmt.executeQuery();
        
            while (rs.next()) {
                data.add(new Product1(++c, rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
               
            }

            productTable.setItems(data);
            //tableCategory.getColumns().addAll(col1,col2,col3);
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    
    }

    @FXML
    public void productTableHandle(SortEvent<TableView<Product1>> event) {

    }
    List<String> list = new ArrayList<String>();
    
        
    

    void fill1() {

        

        try {
    
    
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            String str = "select * from category";
            PreparedStatement stmt = con.prepareStatement(str);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                list.add(rs.getString(1));
                
            }
            ObservableList obList = FXCollections.observableList(list);
            productChoice.getItems().clear();
            productChoice.setItems(obList);    
            
           
            //tableCategory.getColumns().addAll(col1,col2,col3);
            stmt.close();
            rs.close();
            
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        fill1();
    }


public void onBack(ActionEvent event) {
    StageManager.getInstance().adminStage.show();
    StageManager.getInstance().productStage.hide();
    
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
