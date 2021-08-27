package EmergingWorld.Controller;
import java.net.URL;
import java.util.ResourceBundle;

import EmergingWorld.JavaClass.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class QuantityFXMLController implements Initializable{



Connection con;

     static int p;
     static String q;
     static String r;
     static String s;
    @FXML
    public AnchorPane AnchorPane;
    
    @FXML
    public ComboBox<Integer> Quantitycombo;

    @FXML
    public Label Quantitylabel;

    @FXML
    public Button removebutton;
    
    @FXML
    public Button backButton;

    @FXML
    public void removehandle(ActionEvent event) {
        int c=Quantitycombo.getSelectionModel().getSelectedItem();
        try{
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            String strr="Select * from "+q+" where Company = '"+r+"' and ProductName = '"+s+"'";
            PreparedStatement stmt1=con.prepareStatement(strr);
            ResultSet rs1=stmt1.executeQuery();
            rs1.next();
            int p=rs1.getInt(3);
            if(c==p){
                String str="delete from "+q+" where Company = '"+r+"' and ProductName = '"+s+"'";
                PreparedStatement stmt=con.prepareStatement(str);
                stmt.executeUpdate();
            }
            else{
                p=p-c;
                String str="update "+q+" set Quantity = "+p+" where Company = '"+r+"' and ProductName = '"+s+"' ";
                PreparedStatement stmt=con.prepareStatement(str);
                stmt.executeUpdate();
            }
            Stage stage=(Stage) removebutton.getScene().getWindow();
            stage.close();
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
    
        }
    }
    List<Integer> list = new ArrayList<Integer>();
   public void fill(){
        for(int i=0;i<=p;i++){
            list.add(i);
        }
        ObservableList obList = FXCollections.observableList(list);
            Quantitycombo.getItems().clear();
            Quantitycombo.setItems(obList);
        
    }
    @Override
    
    
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        fill();
      
    }

public void onBack(ActionEvent event) {
    StageManager.getInstance().adminStage.show();
    StageManager.getInstance().quantityStage.hide();
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
