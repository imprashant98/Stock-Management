/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.JavaClass;

import javafx.application.Application;

import javafx.stage.Stage;

/**
 *
 * @author Prashant
 */
public class Start extends Application {
    
    @Override
    public void start(Stage stage) {
      
        StageManager.getInstance().mainLoginStage.show();
     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}





