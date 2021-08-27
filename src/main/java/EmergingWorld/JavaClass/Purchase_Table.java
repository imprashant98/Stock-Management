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
public class Purchase_Table {
    SimpleStringProperty Bid;
    SimpleStringProperty Company;
    SimpleStringProperty Pname;
    SimpleStringProperty Quantity;
    SimpleStringProperty PricePerPiece;
    SimpleStringProperty Did;
    SimpleStringProperty date;

    public Purchase_Table(String Bid, String Company, String Pname, String Quantity, String PricePerPiece, String Did, String date) {
        this.Bid = new SimpleStringProperty(Bid);
        this.Company = new SimpleStringProperty(Company);
        this.Pname = new SimpleStringProperty(Pname);
        this.Quantity = new SimpleStringProperty(Quantity);
        this.PricePerPiece = new SimpleStringProperty(PricePerPiece);
        this.Did = new SimpleStringProperty(Did);
        this.date = new SimpleStringProperty(date);
    }
    public String getBid(){
        return Bid.get();
    }
    public String getPname(){
        return Pname.get();
    }
    public String getQuantity(){
        return Quantity.get();
    }
    public String getPricePerPiece(){
        return PricePerPiece.get();
    }
    public String getDid(){
        return Did.get();
    }
    public String getDate(){
        return date.get();
    }
    public String getCompany(){
        return Company.get();
    }
    
    public void setCompany(String s){
        this.Company.set(s);
    }
    public void setBid(String s){
        this.Bid.set(s);
    }
    public void setPname(String n){
        this.Pname.set(n);
    }
    
    public void setQuantity(String p){
        this.Quantity.set(p);
    }
    public void setPricePerPiece(String p){
        this.PricePerPiece.set(p);
    }
    public void setDid(String p){
        this.Did.set(p);
    }
    public void setDate(String P){
        this.date.set(P);
    }
}
