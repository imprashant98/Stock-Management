/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.JavaClass;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author  Prashant
 */
public class Payment {
    SimpleStringProperty rid;
    SimpleStringProperty rpay;
    //SimpleStringProperty rtrx;
    
    public Payment(String rid, String rpay){
        this.rid = new SimpleStringProperty(rid);
        this.rpay = new SimpleStringProperty(rpay);
        //this.rtrx = new SimpleStringProperty(rtrx);
    }
    public String getRid(){
        return rid.get();
    }
    public String getRpay(){
        return rpay.get();
    }
//    public String getRtrx(){
//        return rtrx.get();
//    }
   public void setRid(String a){
        this.rid.set(a);
    }
    public void setRpay(String b){
        this.rpay.set(b);
    }
//     public void setRtrx(String c){
//        this.rtrx.set(c);
//    }
}
