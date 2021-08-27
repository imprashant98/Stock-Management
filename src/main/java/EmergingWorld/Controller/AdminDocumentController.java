package EmergingWorld.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import EmergingWorld.JavaClass.StageManager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Prashant
 */
public class AdminDocumentController implements Initializable {

@FXML
public Button product;
@FXML
public Button category;
@FXML
public Button item;
@FXML
public Button employee;
@FXML
public Button bills1;
@FXML
public Button purchases;
@FXML
public Button warranty;
@FXML
public Button payment;
@FXML
public Button logout;
@FXML
public Button bills;
@FXML
public Label l1;



    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

public void entered(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1.1);
    ((Button) e.getSource()).setScaleY(1.1);
}

public void exited(MouseEvent e) {
    ((Button) e.getSource()).setScaleX(1);
    ((Button) e.getSource()).setScaleY(1);
}

public void productButton(ActionEvent event) {
    StageManager.getInstance().adminStage.hide();
    StageManager.getInstance().productStage.show();
    
}

public void categoryButton(ActionEvent event) {
    StageManager.getInstance().adminStage.hide();
    StageManager.getInstance().categoryStage.show();
}

public void itemButton(ActionEvent event) {
    StageManager.getInstance().adminStage.hide();
    StageManager.getInstance().itemStage.show();
}

public void employeeButton(ActionEvent event) {
    StageManager.getInstance().adminStage.hide();
    StageManager.getInstance().employeeStage.show();
}

public void bills1Button(ActionEvent event) {
    StageManager.getInstance().adminStage.hide();
    StageManager.getInstance().bill1Stage.show();
    
}

public void purchasesButton(ActionEvent event) {
    StageManager.getInstance().adminStage.hide();
    StageManager.getInstance().purchaseStage.show();
}

public void billsButton(ActionEvent event) {
    StageManager.getInstance().adminStage.hide();
    StageManager.getInstance().billStage.show();
}

public void warrantyButton(ActionEvent event) {
    StageManager.getInstance().adminStage.hide();
    StageManager.getInstance().warrantyStage.show();
}

public void paymentButton(ActionEvent event) {
    StageManager.getInstance().adminStage.hide();
    StageManager.getInstance().paymentStage.show();
}

public void logoutButton(ActionEvent event) {
    StageManager.getInstance().adminStage.hide();
    StageManager.getInstance().mainLoginStage.show();
}

public void onDealer(ActionEvent event) {
    StageManager.getInstance().adminStage.hide();
    StageManager.getInstance().dealerStage.show();
}
}
