package EmergingWorld.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import EmergingWorld.JavaClass.Product1;
import EmergingWorld.JavaClass.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */

public class ItemController implements Initializable {


    Connection con;

    @FXML
    public TableColumn<Product1, Integer> TableQuantity;

    @FXML
    public Button backButton;
    @FXML
    public Button addButton;

    @FXML
    public TableColumn<Product1, String> TablePname;

    @FXML
    public Label SelectCategoryField;

    @FXML
    public TableView<Product1> productTable;

    @FXML
    public TableColumn<Product1, Integer> TablePrice;

    @FXML
    public TableColumn<Product1, String> TableDId;

    @FXML
    public Button RemoveButton;

    @FXML
    public Button view;

    @FXML
    public Button refresh;
    
    @FXML
    public TableColumn<Product1, String> TableCname;

    @FXML
    public Pane Pane1;

    @FXML
    public AnchorPane AnchorPane;

    @FXML
    public ComboBox<String> SelectProductCombo;

    @FXML
    public TableColumn<Product1, Integer> TableSno;

    @FXML
    public ImageView Pane1Image;

    @FXML
    public Pane Pane2;

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
            SelectProductCombo.getItems().clear();
            SelectProductCombo.setItems(obList);

            //tableCategory.getColumns().addAll(col1,col2,col3);
            stmt.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }
    

    @FXML
    public void button1(ActionEvent event) {
        String str1 = SelectProductCombo.getSelectionModel().getSelectedItem();
        ObservableList<Product1> data = FXCollections.observableArrayList();
        TableSno.setCellValueFactory(new PropertyValueFactory<>("rcoun"));
            TableCname.setCellValueFactory(new PropertyValueFactory<>("rcname"));
            TablePname.setCellValueFactory(new PropertyValueFactory<>("rname"));
            TableQuantity.setCellValueFactory(new PropertyValueFactory<>("rquantity"));
            TablePrice.setCellValueFactory(new PropertyValueFactory<>("rpricepp"));
            TableDId.setCellValueFactory(new PropertyValueFactory<>("rdealerid"));

        if ((Button) event.getSource() == view) {

            if (str1 == null)
            {
                JOptionPane.showMessageDialog(null, "Select the Components first");
            }
            else {
                //productTable.setItems(data);
                try {
                    int c = 0;

                    Class.forName("java.sql.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
                    String str = "select * from " + str1 + "";
                    PreparedStatement stmt = con.prepareStatement(str);
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        data.add(new Product1(++c,
                                rs.getString(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getInt(4),
                                rs.getString(5)));

                    }

                    productTable.setItems(data);
                    //tableCategory.getColumns().addAll(col1,col2,col3);
                    stmt.close();
                    rs.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());

                }
            }

        }
        if (event.getSource() == RemoveButton) {
            int selectedIndex = productTable.getSelectionModel().getSelectedIndex();
            Product1 selected = productTable.getSelectionModel().getSelectedItem();
            QuantityFXMLController.p=selected.getRquantity();
            QuantityFXMLController.q=str1;
            QuantityFXMLController.r=selected.getRcname();
            QuantityFXMLController.s=selected.getRname();
            
            if (selectedIndex < 0) {
                JOptionPane.showMessageDialog(null, "No row Selected");
            } else {
                    try {

                        StageManager.getInstance().quantityStage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

            }
        }
        if(event.getSource() ==refresh){
            try {
                int c = 0;
    
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
                String str = "select * from " + str1 + "";
                PreparedStatement stmt = con.prepareStatement(str);
                ResultSet rs = stmt.executeQuery();
            
                while (rs.next()) {
                    data.add(new Product1(++c, rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getString(5)));
                  
                }

                productTable.setItems(data);
                //tableCategory.getColumns().addAll(col1,col2,col3);
                stmt.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

public void onHome(ActionEvent event) {
    StageManager.getInstance().adminStage.show();
    StageManager.getInstance().itemStage.hide();
}

public void onAdd(ActionEvent event) {
        StageManager.getInstance().addItemStage.show();
        StageManager.getInstance().itemStage.hide();
}
}
