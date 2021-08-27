/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.JavaClass;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Prashant
 */
public class Warranty {
    SimpleStringProperty rid;
    SimpleStringProperty rproduct;
    SimpleStringProperty rname;
    SimpleStringProperty rdate;
    SimpleStringProperty rwarranty;
    
    public Warranty(String rid, String rproduct, String rname, String rdate, String rwarranty){
        this.rid = new SimpleStringProperty(rid);
        this.rproduct = new SimpleStringProperty(rproduct);
        this.rname = new SimpleStringProperty(rname);
        this.rdate = new SimpleStringProperty(rdate);
        this.rwarranty = new SimpleStringProperty(rwarranty);    
    }
    public String getRid(){
        return rid.get();
    }
    public String getRproduct(){
        return rproduct.get();
    }
    public String getRname(){
        return rname.get();
    }
    public String getRdate(){
        return rdate.get();
    }
    public String getRwarranty(){
        return rwarranty.get();
    }
    public void setRid(String a){
        this.rid.set(a);
    }
    public void setRproduct(String b){
        this.rproduct.set(b);
    }
    public void setRname(String c){
        this.rname.set(c);
    }
    public void setRdate(String d){
        this.rdate.set(d);
    }
    public void setRwarranty(String e){
        this.rwarranty.set(e);
    }
}