package EmergingWorld.Controller;

import EmergingWorld.JavaClass.StageManager;
import EmergingWorld.JavaClass.Warranty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */

public class WarrantyController implements Initializable {


/**
 * Initializes the controller class.
 */
@FXML
public Button add;
@FXML
public TextField bill_id;
@FXML
public TableColumn<Warranty, String> col_date;
@FXML
public Button search;
@FXML
public TableColumn<Warranty, String> col_prdct;
@FXML
public TableColumn<Warranty, String> col_billid;
@FXML
public TableColumn<Warranty, String> col_warranty;
@FXML
public Label label_prdct;
@FXML
public Label label_name;
@FXML
public Label label_date;
@FXML
public TableColumn<Warranty, String> col_owner;
@FXML
public ComboBox<String> drop_down;
@FXML
public TableView<Warranty> table;
@FXML
public Button refresh;
public Button backButton;
Connection con;
List<String> str = new ArrayList<String>();

void fill() {
    str.add("Received");
    str.add("Sent");
    str.add("Return");
    ObservableList<String> oblist = FXCollections.observableList(str);
    drop_down.getItems().clear();
    drop_down.setItems(oblist);
}

@FXML
public void OnMouseClick(ActionEvent event) throws ClassNotFoundException, SQLException {
    if (event.getSource() == search) {
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            //String s1 = "select * from sold_item where bill_id " + "=" + "'" + bill_id.getText() + "'";
            String s1 = "select prdct_name,owner_name,date from warranty where bill_id = '" + bill_id.getText() + "'";
           
            java.sql.PreparedStatement stmt = con.prepareStatement(s1);
           ;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
              
                label_prdct.setText(rs.getString("prdct_name"));
                label_name.setText(rs.getString("owner_name"));
                label_date.setText(rs.getString("date"));
            } else {
             
                String s2 = "select * from sold_item where billid = '" + bill_id.getText() + "'";
             
                java.sql.PreparedStatement stmt1 = con.prepareStatement(s2);
                ResultSet rs1 = stmt1.executeQuery();
                if (rs1.next()) {
                   
                    label_prdct.setText(rs1.getString(3));
                    label_name.setText(rs1.getString(5));
                    label_date.setText(rs1.getString(8));
                   
                } else {
                   
                    JOptionPane.showMessageDialog(null, "Bill ID does not exist");
                    label_prdct.setText("");
                    label_name.setText("");
                    label_date.setText("");
                }
            }
            con.close();
            add.setDisable(false);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
}

@FXML
void OnMouseClickRefresh() {
    //fill1();
}

@FXML
public void OnMouseClickAdd(ActionEvent event) throws ClassNotFoundException, SQLException {
    if (event.getSource() == add) {
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            //String s1 = "select * from sold_item where bill_id " + "=" + "'" + bill_id.getText() + "'";
            String s1 = "select * from warranty where bill_id = '" + bill_id.getText() + "'";
 
            java.sql.PreparedStatement stmt = con.prepareStatement(s1);
            //stmt.setString(1,bill_id.getText());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String strr = "update warranty set warranty = '" + drop_down.getSelectionModel().getSelectedItem() + "' where bill_id = '" + bill_id.getText() + "'";
                PreparedStatement stmt1 = con.prepareStatement(strr);
                stmt1.executeUpdate();
            } else {
                String s2 = "insert into warranty values(?,?,?,?,?)";
               
                java.sql.PreparedStatement stmt1 = con.prepareStatement(s2);
                stmt1.setString(1, bill_id.getText());
                stmt1.setString(2, label_prdct.getText());
                stmt1.setString(3, label_name.getText());
                stmt1.setString(4, label_date.getText());
                stmt1.setString(5, drop_down.getSelectionModel().getSelectedItem());
                stmt1.executeUpdate();
            }
            con.close();
            add.setDisable(false);
            fill1();
            
        } catch (Exception e) {
        
        }
        
    }
}

void fill1() {
    ObservableList<Warranty> data = FXCollections.observableArrayList();
    col_billid.setCellValueFactory(new PropertyValueFactory<>("rid"));
    col_prdct.setCellValueFactory(new PropertyValueFactory<>("rproduct"));
    col_owner.setCellValueFactory(new PropertyValueFactory<>("rname"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("rdate"));
    col_warranty.setCellValueFactory(new PropertyValueFactory<>("rwarranty"));
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
        String str = "select * from warranty";
        PreparedStatement stmt = con.prepareStatement(str);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            data.add(new Warranty(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        table.setItems(data);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
   // table.setItems(data);
    
}

@Override
public void initialize(URL url, ResourceBundle rb) {
    // TODO
    fill();
    fill1();
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
    StageManager.getInstance().warrantyStage.hide();
}
}
