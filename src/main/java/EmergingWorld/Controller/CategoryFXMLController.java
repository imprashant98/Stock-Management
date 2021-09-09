package EmergingWorld.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import EmergingWorld.JavaClass.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import EmergingWorld.JavaClass.Category1;
import javafx.scene.input.MouseEvent;

import javax.swing.JOptionPane;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */


public class CategoryFXMLController implements Initializable {

public Button backButton;
Connection con;

    @FXML
    public TableView<Category1> tableCategory;

    @FXML
    public  TableColumn<Category1, String> col2;

    @FXML
    public TableColumn<Category1, String> col3;

    @FXML
    public Button remove;

    @FXML
    public Button refresh;
    @FXML
    public Button addCategory;

    @FXML
    public TableColumn<Category1, String> col1;

    @FXML
    public void ButtonHandleAction(ActionEvent event) {
        if ((Button) event.getSource() == addCategory) {

            StageManager.getInstance().addCategoryStage.show();

        }
        else if ((Button) event.getSource() == remove) {
            int selectedIndex = tableCategory.getSelectionModel().getSelectedIndex();
            Category1 selected = tableCategory.getSelectionModel().getSelectedItem();
            if (selectedIndex < 0) {
                JOptionPane.showMessageDialog(null, "No row Selected");
            } else {
                try {
                    String str2;
                    Class.forName("java.sql.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
                    String str = "select * from " + selected.getRname() + " ";
                   
                    PreparedStatement stmt = con.prepareStatement(str);
                    ResultSet rs = stmt.executeQuery();
                  
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Selected Category is not empty");
                    } else {
                        if (selectedIndex >= 0) {
                        tableCategory.getItems().remove(selectedIndex);
                        String str1 = "delete from category where category = '" + selected.getRname() + "'";
                        str2 = "drop table " + selected.getRname() + " ";
                        PreparedStatement stmt1 = con.prepareStatement(str1);
                        PreparedStatement stmt2 = con.prepareStatement(str2);
                        stmt1.executeUpdate();
                        stmt2.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Category Removed");
                        
                        }
                    }
                    con.close();
                } catch (Exception e) {
                   
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

        } else if ((Button) event.getSource() == refresh) {
            fill();
        }

    }

    public void fill() {
        ObservableList<Category1> data = FXCollections.observableArrayList();

        col1.setCellValueFactory(new PropertyValueFactory<>("rcoun"));
        col2.setCellValueFactory(new PropertyValueFactory<>("rname"));
        col3.setCellValueFactory(new PropertyValueFactory<>("rquantity"));
      

        tableCategory.setItems(data);

        try {
            int c = 0,sum;
            String str1;
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            String str = "select * from category";
            PreparedStatement stmt = con.prepareStatement(str);
            ResultSet rs = stmt.executeQuery();
          
            while (rs.next()) {
                sum=0;
                str1="select SUM(Quantity) from "+rs.getString(1)+"";
                stmt=con.prepareStatement(str1);
                ResultSet rs1=stmt.executeQuery();
                if(rs1.next()){
                    sum=rs1.getInt(1);
                }
            
                data.add(new Category1(++c, rs.getString(1), sum));
               
            }

            tableCategory.setItems(data);
            //tableCategory.getColumns().addAll(col1,col2,col3);
            stmt.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fill();
    }

public void onBack(ActionEvent event) {
        StageManager.getInstance().adminStage.show();
        StageManager.getInstance().categoryStage.hide();
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
