package EmergingWorld.JavaClass;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class StageManager {

//For authentication
public Stage mainLoginStage;
public Stage adminStage;


//For applications
public Stage addCategoryStage;
public Stage addDealerStage;
public Stage addEmployeeStage;
public Stage employeeStage;

public Stage billStage;
public Stage bill1Stage;
public Stage categoryStage;
public Stage dealerStage;

public Stage forgetPasswordStage;
public Stage registerStage;
public Stage addItemStage;
public Stage itemStage;

public Stage paymentStage;
public Stage productStage;
public Stage purchaseStage;
public Stage quantityStage;
//public Stage removeItemStage;
public Stage warrantyStage;


private StageManager() {
    
    createMainLoginStage();
    createRegisterStage();


    
    createAddCategoryStage();
    createAddDealerStage();
    createAddEmployeeStage();

    createAdminStage();
    createBillStage();
    createBill1Stage();

    createCategoryStage();
    createDealerStage();
    createEmployeeStage();
    createForgetPasswordStage();


    createAddItemStage();
    createItemStage();
    createPaymentStage();
    createProductStage();
    createPurchaseStage();

    createQuantityStage();
   // createRemoveItemStage();
    createWarrantyStage();
}

public static StageManager getInstance() {
    return Singleton.INSTANCE;
}



private void createMainLoginStage() {
    mainLoginStage = new Stage();
    try {

        Parent root = load(getClass().getResource("/MainLogin.fxml"));

        Scene scene = new Scene(root);
        mainLoginStage.setScene(scene);
        mainLoginStage.initStyle(StageStyle.UNDECORATED);
        mainLoginStage.setResizable(false);
        mainLoginStage.centerOnScreen();

        // mainLoginStage.setResizable(false);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createAddCategoryStage() {
    addCategoryStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/AddCategoryFXMLDocument.fxml"));
        Scene scene = new Scene(root);
        addCategoryStage.setScene(scene);
        addCategoryStage.initStyle(StageStyle.UNDECORATED);
        addCategoryStage.setResizable(false);
        addCategoryStage.centerOnScreen();
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createEmployeeStage() {
    employeeStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/Employee.fxml"));
        Scene scene = new Scene(root);
        employeeStage.setScene(scene);
        employeeStage.initStyle(StageStyle.UNDECORATED);
        employeeStage.setResizable(false);
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createAddDealerStage() {
    addDealerStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/AddDealer.fxml"));
        Scene scene = new Scene(root);
        addDealerStage.setScene(scene);
        addDealerStage.initStyle(StageStyle.UNDECORATED);
        addDealerStage.setResizable(false);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createRegisterStage() {
    registerStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/Register.fxml"));
        Scene scene = new Scene(root);
        registerStage.setScene(scene);
        registerStage.centerOnScreen();
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setResizable(false);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void createBillStage() {
    billStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/Bills.fxml"));
        Scene scene = new Scene(root);
        billStage.setScene(scene);
        billStage.centerOnScreen();
        billStage.initStyle(StageStyle.UNDECORATED);
        billStage.setResizable(false);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void createBill1Stage() {
    bill1Stage = new Stage();
    try {
        Parent root = load(getClass().getResource("/Bills1.fxml"));
        Scene scene = new Scene(root);
        bill1Stage.setScene(scene);
        bill1Stage.centerOnScreen();
        bill1Stage.initStyle(StageStyle.UNDECORATED);
        bill1Stage.setResizable(false);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void createCategoryStage() {
    categoryStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/CategoryFXML.fxml"));
        Scene scene = new Scene(root);
        categoryStage.setScene(scene);
        categoryStage.centerOnScreen();
        categoryStage.initStyle(StageStyle.UNDECORATED);
        categoryStage.setResizable(false);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createDealerStage() {
    dealerStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/Dealer.fxml"));
        Scene scene = new Scene(root);
        dealerStage.setScene(scene);
        dealerStage.initStyle(StageStyle.UNDECORATED);
        dealerStage.setResizable(false);
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createItemStage() {
    itemStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/Item.fxml"));
        Scene scene = new Scene(root);
        itemStage.setScene(scene);
        itemStage.initStyle(StageStyle.UNDECORATED);
        itemStage.setResizable(false);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createAddEmployeeStage() {
    addEmployeeStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/AddEmployee.fxml"));
        Scene scene = new Scene(root);
        addEmployeeStage.setScene(scene);
        addEmployeeStage.centerOnScreen();
        addEmployeeStage.initStyle(StageStyle.UNDECORATED);
        addEmployeeStage.setResizable(false);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void createQuantityStage() {
    quantityStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/QuantiyFXML.fxml"));
        Scene scene = new Scene(root);
        quantityStage.setScene(scene);
        quantityStage.centerOnScreen();
        quantityStage.initStyle(StageStyle.UNDECORATED);
        quantityStage.setResizable(false);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createAdminStage() {
    adminStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/AdminFXMLDocument.fxml"));
        Scene scene = new Scene(root);
        adminStage.setScene(scene);
        adminStage.initStyle(StageStyle.UNDECORATED);
        adminStage.setResizable(false);
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createForgetPasswordStage() {
    forgetPasswordStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/ForgotPassword.fxml"));
        Scene scene = new Scene(root);
        forgetPasswordStage.setScene(scene);
        forgetPasswordStage.initStyle(StageStyle.UNDECORATED);
        forgetPasswordStage.setResizable(false);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createAddItemStage() {
    addItemStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/AddItem.fxml"));
        Scene scene = new Scene(root);
        addItemStage.setScene(scene);
        addItemStage.centerOnScreen();
        addItemStage.initStyle(StageStyle.UNDECORATED);
        addItemStage.setResizable(false);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void createPaymentStage() {
    paymentStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/Payment.fxml"));
        Scene scene = new Scene(root);
        paymentStage.setScene(scene);
        paymentStage.centerOnScreen();
        paymentStage.initStyle(StageStyle.UNDECORATED);
        paymentStage.setResizable(false);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createProductStage() {
    productStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/ProductFXMLDocument.fxml"));
        Scene scene = new Scene(root);
        productStage.setScene(scene);
        productStage.initStyle(StageStyle.UNDECORATED);
        productStage.setResizable(false);
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void createPurchaseStage() {
    purchaseStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/Purchases.fxml"));
        Scene scene = new Scene(root);
        purchaseStage.setScene(scene);
        purchaseStage.initStyle(StageStyle.UNDECORATED);
        purchaseStage.setResizable(false);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}

//private void createRemoveItemStage() {
//    removeItemStage = new Stage();
//    try {
//        Parent root = load(getClass().getResource("/Item.fxml"));
//        Scene scene = new Scene(root);
//        removeItemStage.setScene(scene);
//        removeItemStage.centerOnScreen();
//        removeItemStage.initStyle(StageStyle.UNDECORATED);
//        removeItemStage.setResizable(false);
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}

public void createWarrantyStage() {
    warrantyStage = new Stage();
    try {
        Parent root = load(getClass().getResource("/Warranty.fxml"));
        Scene scene = new Scene(root);
        warrantyStage.setScene(scene);
        warrantyStage.centerOnScreen();
        warrantyStage.initStyle(StageStyle.UNDECORATED);
        warrantyStage.setResizable(false);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
}



private static class Singleton {
    private static final StageManager INSTANCE = new StageManager();
}
}




