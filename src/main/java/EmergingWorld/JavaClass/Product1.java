/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.JavaClass;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Prashant
 */
public class Product1 {

    SimpleIntegerProperty rcoun;
    SimpleStringProperty rcname;
    SimpleStringProperty rname;
    SimpleIntegerProperty rquantity;
    SimpleIntegerProperty rpricepp;
    SimpleStringProperty rdealerid;

    public Product1(int rcoun, String rcname, String rname, int rquantity, int rpricepp, String rdealerid) {
        this.rcoun=new SimpleIntegerProperty(rcoun);
        this.rcname = new SimpleStringProperty(rcname);
        this.rname = new SimpleStringProperty(rname);
        this.rquantity = new SimpleIntegerProperty(rquantity);
        this.rpricepp = new SimpleIntegerProperty(rpricepp);
        this.rdealerid = new SimpleStringProperty(rdealerid);

    }

    public int getRcoun() {
        return rcoun.get();
    }

    public String getRname() {
        return rname.get();
    }

    public int getRquantity() {
        return rquantity.get();
    }

    public void setRcoun(int a) {
        this.rcoun.set(a);
    }

    public void setRname(String n) {
        this.rname.set(n);
    }

    public void setRquantity(int p) {
        this.rquantity.set(p);
    }
    public String getRcname() {
        return rcname.get();
    }

    public void setRcname(String s) {
        this.rcname.set(s);
    }
    public int getRpricepp() {
        return rpricepp.get();
    }

    public void setRpricepp(int b) {
        this.rpricepp.set(b);
    }
    public String getRdealerid() {
        return rdealerid.get();
    }

    public void setRdealerid(String c) {
        this.rdealerid.set(c);
    }

}
