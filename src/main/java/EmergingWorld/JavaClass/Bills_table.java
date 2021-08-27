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
public class Bills_table {
    
    SimpleStringProperty Pid;
    SimpleStringProperty Pname;
    SimpleStringProperty Cname;
    SimpleStringProperty Caddr;
    SimpleStringProperty Ccontact;
    SimpleStringProperty date;
    SimpleStringProperty Eid;
    

    public Bills_table(String Pid, String Pname, String Cname, String Caddr, String Ccontact, String date, String Eid) {
        this.Pid = new SimpleStringProperty(Pid);
        this.Pname = new SimpleStringProperty(Pname);
        this.Cname = new SimpleStringProperty(Cname);
        this.Caddr = new SimpleStringProperty(Caddr);
        this.Ccontact = new SimpleStringProperty(Ccontact);
        this.date = new SimpleStringProperty(date);
        this.Eid = new SimpleStringProperty(Eid);
    }
    public String getPid(){
        return Pid.get();
    }
    public String getPname(){
        return Pname.get();
    }
    public String getCname(){
        return Cname.get();
    }
    public String getCaddr(){
        return Caddr.get();
    }
    public String getCcontact(){
        return Ccontact.get();
    }
    public String getDate(){
        return date.get();
    }
    public String getEid(){
        return Eid.get();
    }
    
    public void setEid(String s){
        this.Eid.set(s);
    }
    public void setPid(String s){
        this.Pid.set(s);
    }
    public void setPname(String n){
        this.Pname.set(n);
    }
    
    public void setCname(String p){
        this.Cname.set(p);
    }
    public void setCaddr(String p){
        this.Caddr.set(p);
    }
    public void setCcontact(String p){
        this.Ccontact.set(p);
    }
    public void setDate(String P){
        this.date.set(P);
    }
}
