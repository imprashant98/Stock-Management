/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.JavaClass;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Prashant
 */
public class Emp_Table {

SimpleStringProperty Eid;
SimpleStringProperty Ename;
SimpleStringProperty Egender;
SimpleStringProperty Eaddr;
SimpleStringProperty Econtact;
SimpleStringProperty Ecitizenship;
SimpleStringProperty Edesignation;
SimpleStringProperty Eemail;

public Emp_Table(String Eid, String Ename, String Egender, String Eaddr, String Econtact, String Ecitizenship, String Edesignation, String Eemail) {
    this.Eid = new SimpleStringProperty(Eid);
    this.Ename = new SimpleStringProperty(Ename);
    this.Egender = new SimpleStringProperty(Egender);
    this.Eaddr = new SimpleStringProperty(Eaddr);
    this.Econtact = new SimpleStringProperty(Econtact);
    this.Ecitizenship = new SimpleStringProperty(Ecitizenship);
    this.Edesignation = new SimpleStringProperty(Edesignation);
    this.Eemail = new SimpleStringProperty(Eemail);
}

public String getEid() {
    return Eid.get();
}

public void setEid(String s) {
    this.Eid.set(s);
}

public String getEname() {
    return Ename.get();
}

public void setEname(String n) {
    this.Ename.set(n);
}

public String getEgender() {
    return Egender.get();
}

public void setEgender(String p) {
    this.Egender.set(p);
}

public String getEaddr() {
    return Eaddr.get();
}

public void setEaddr(String p) {
    this.Eaddr.set(p);
}

public String getEcontact() {
    return Econtact.get();
}

public void setEcontact(String p) {
    this.Econtact.set(p);
}

public String getEcitizenship() {
    return Ecitizenship.get();
}
public void setEcitizenship(String s) {
    this.Ecitizenship.set(s);
}



public String getEdesignation() {
    return Edesignation.get();
}

public void setEdesignation(String q) {
    this.Edesignation.set(q);
}

public String getEemail() {
    return Eemail.get();
}

public void setEemail(String m) {
    this.Eemail.set(m);
}


    
}
