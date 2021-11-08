/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmergingWorld.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import EmergingWorld.JavaClass.StageManager;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.sql.ResultSet;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;

import javax.swing.JOptionPane;

/**
 * FXML EmergingWorld.Controller class
 *
 * @author Prashant
 */
public class Bills1Controller implements Initializable {
@FXML
public TextField phone_no;
@FXML
public TextField address;
@FXML
public Button generate_bill;
@FXML
public TextField customerName;
@FXML
public TextField product_id;
@FXML
public DatePicker date;
@FXML
public Label billField;
@FXML
public Label itemField;
@FXML
public Label addressField;
@FXML
public Label dateField;
@FXML
public Label contactField;
@FXML
public Label nameField;
@FXML
public ComboBox categoryComboBox;
@FXML
public ComboBox productComboBox;
@FXML
public ComboBox unitComboBox;
@FXML
public Label totalField;
@FXML
public TextField total;
@FXML
public Label dateField1;
@FXML
public ComboBox employeeIdComboBox;
@FXML
public Label totalField1;
@FXML
public TextField payment;
public Button backButton;


ArrayList<String> list = new ArrayList<String>();
Connection con;

    

    /**
     *
     * @param *
     * @author Prashant
     */
    public int check(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' || s.charAt(i) == '1' ||
                        s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '4' ||
                        s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8' ||
                        s.charAt(i) == '9') {
                c = 1;
            } else {
                c = 0;
                break;
            }
        }
        return c;
    }
    
    static int price;

    void fill1() {

        try {
    
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            String str = "select * from category";
            PreparedStatement stmt = con.prepareStatement(str);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(rs.getString(1));

            }
            ObservableList obList = FXCollections.observableList(list);
            categoryComboBox.getItems().clear();
            categoryComboBox.setItems(obList);

            //tableCategory.getColumns().addAll(col1,col2,col3);
            stmt.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    
    void fill2() {
        ArrayList<String> list = new ArrayList<String>();
        try {
    
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            String str = "select EMP_ID from Employee";
            PreparedStatement stmt = con.prepareStatement(str);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(rs.getString(1));

            }
            ObservableList obList = FXCollections.observableList(list);
            employeeIdComboBox.getItems().clear();
            employeeIdComboBox.setItems(obList);

            //tableCategory.getColumns().addAll(col1,col2,col3);
            stmt.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    void billid() {
        try {
    
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            String str = "select * from sold_item";
            PreparedStatement stmt = con.prepareStatement(str);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String str2 = "SELECT billid FROM sold_item ORDER BY billid DESC LIMIT 1";
                PreparedStatement stmt1 = con.prepareStatement(str2);
                ResultSet rs1 = stmt1.executeQuery();
                rs1.next();
                String p = rs1.getString(1);
                String s = "";
                for (int i = 1; i < p.length(); i++) {
                    s = s + "" + p.charAt(i);
                }
                int b = Integer.parseInt(s);
                b++;
                s = 'B' + "" + b;
                product_id.setText(s);
            } else {
                product_id.setText("B100");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fill1();
        fill2();
        billid();
    }

public void categoryComboBox(ActionEvent event) {
    String str = String.valueOf(categoryComboBox.getSelectionModel().getSelectedItem());
    ArrayList<String> list1 = new ArrayList<String>();
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
        String str1 = "select ProductName,Company from " + str + "";
        PreparedStatement stmt = con.prepareStatement(str1);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            list1.add(rs.getString(2) + "-" + rs.getString(1));
        }
        ObservableList oblist = FXCollections.observableList(list1);
        productComboBox.getItems().clear();
        productComboBox.setItems(oblist);
    } catch (Exception e) {
    }
    
}

public void productComboBox(ActionEvent event) {
    String str1 = String.valueOf(categoryComboBox.getSelectionModel().getSelectedItem());
    String str = String.valueOf(productComboBox.getSelectionModel().getSelectedItem());
    String str3[] = str.split("-");
    ArrayList<Integer> list2 = new ArrayList<Integer>();
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
        String str2 = "select Quantity from " + str1 + " where ProductName = '" + str3[1] + "' and Company = '" + str3[0] + "'";
        PreparedStatement stmt = con.prepareStatement(str2);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int p = rs.getInt(1);
        for (int i = 1; i <= p; i++) {
            list2.add(i);
        }
      
        ObservableList oblist = FXCollections.observableList(list2);
        unitComboBox.getItems().clear();
        unitComboBox.setItems(oblist);
        
    } catch (Exception e) {
    }
}

public void unitComboBox(ActionEvent event) {
    String str1 = String.valueOf(categoryComboBox.getSelectionModel().getSelectedItem());
    String str = String.valueOf(productComboBox.getSelectionModel().getSelectedItem());
    String str3[] = str.split("-");
    
    try {
        Class.forName("java.sql.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
        String str4 = "select Pricepp from " + str1 + " where ProductName = '" + str3[1] + "' and Company= '" + str3[0] + "'";
        PreparedStatement stmt1 = con.prepareStatement(str4);
        ResultSet rs1 = stmt1.executeQuery();
        rs1.next();
        price = rs1.getInt(1) * Integer.parseInt(String.valueOf(unitComboBox.getSelectionModel().getSelectedItem()));
        total.setText("" + price);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}

public void generateBill(ActionEvent event) {
    int c = check(phone_no.getText());
    int c1 = phone_no.getText().length();
    String s1 = product_id.getText();
    String s3 = String.valueOf(categoryComboBox.getSelectionModel().getSelectedItem());
    String s7 = String.valueOf(productComboBox.getSelectionModel().getSelectedItem());
    int s8 = (int) unitComboBox.getSelectionModel().getSelectedItem();
    String s2 = customerName.getText();
    String s4 = address.getText();
    String s6 = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    String s5 = phone_no.getText();
    String s10 = total.getText();
    String s11 = (String) employeeIdComboBox.getSelectionModel().getSelectedItem();
    String s12 = payment.getText();
    int to = Integer.parseInt(s10);
    
    if (c == 0 || c1 != 10 || total.getText().equals("") || customerName.getText().equals("")||address.getText().equals("")||payment.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Place the proper data for the required field");
    } else {
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storemanagement?&serverTimezone=UTC&autoReconnect=true&failOverReadOnly=false&maxReconnects=10", "root", "");
            String str1 = "insert into sold_item values(?,?,?,?,?,?,?,?,?,?)";
            
            
            PreparedStatement stmt1 = con.prepareStatement(str1);
            
            stmt1.setString(1, s1);
            stmt1.setString(2, s3);
            stmt1.setString(3, s7);
            stmt1.setInt(4, s8);
            stmt1.setString(5, s2);
            stmt1.setString(6, s4);
            stmt1.setString(7, s5);
            stmt1.setString(8, s6);
            stmt1.setInt(9, to);
            stmt1.setString(10, s11);
            //   ResultSet rs1 = stmt1.executeQuery();
            stmt1.executeUpdate();
            //   con.close();
            JOptionPane.showMessageDialog(null, "Bill Generated");
            
            String str6 = "select * from sold_item where billid= '" + s1 + "'";
            PreparedStatement stmt2 = con.prepareStatement(str6);
            ResultSet rs = stmt2.executeQuery(str6);
            Document my_bill = new Document();
            PdfWriter.getInstance(my_bill, new FileOutputStream(s1 + ".pdf"));
            my_bill.open();
            Font f1=new Font(FontFamily.TIMES_ROMAN,20.0f,Font.BOLD,BaseColor.BLACK);
            Paragraph p2=new Paragraph("Emerging World",f1);
            p2.setAlignment(Paragraph.ALIGN_CENTER);
            my_bill.add(p2);
            //my_bill.add(Chunk.NEWLINE);
            Paragraph p3=new Paragraph("BILL",f1);
            p3.setAlignment(Paragraph.ALIGN_CENTER);
            my_bill.add(p3);
            my_bill.add(Chunk.NEWLINE);
            PdfPTable bill_table = new PdfPTable(2);
            PdfPCell table_cell;
            while (rs.next()) {
                bill_table.addCell("Bill ID");
                String dept_id = rs.getString(1);
                table_cell = new PdfPCell(new Phrase(dept_id));
                bill_table.addCell(table_cell);
                
                bill_table.addCell("Product Type");
                String dept_name = rs.getString(2);
                table_cell = new PdfPCell(new Phrase(dept_name));
                bill_table.addCell(table_cell);
                
                bill_table.addCell("Product name");
                String dept_pname = rs.getString(3);
                table_cell = new PdfPCell(new Phrase(dept_pname));
                bill_table.addCell(table_cell);
                
                bill_table.addCell("Quantity");
                int dept_quan = rs.getInt(4);
                table_cell = new PdfPCell(new Phrase("" + dept_quan));
                bill_table.addCell(table_cell);
                
                bill_table.addCell("Customer Name");
                String manager_id = rs.getString(5);
                table_cell = new PdfPCell(new Phrase(manager_id));
                bill_table.addCell(table_cell);
                
                bill_table.addCell("Address");
                String location_id = rs.getString(6);
                table_cell = new PdfPCell(new Phrase(location_id));
                bill_table.addCell(table_cell);
                
                bill_table.addCell("Phone Number");
                String s = rs.getString(7);
                table_cell = new PdfPCell(new Phrase(s));
                bill_table.addCell(table_cell);
                
                bill_table.addCell("DATE");
                String ss = rs.getString(8);
                table_cell = new PdfPCell(new Phrase(ss));
                bill_table.addCell(table_cell);
                
                bill_table.addCell("Total");
                int dept_total = rs.getInt(9);
                table_cell = new PdfPCell(new Phrase("Rs. " + dept_total));
                bill_table.addCell(table_cell);
                
            }
            my_bill.add(bill_table);
            my_bill.add(Chunk.NEWLINE);
            Font f2=new Font(FontFamily.TIMES_ROMAN,20.0f,Font.UNDERLINE,BaseColor.BLACK);
            Paragraph p4=new Paragraph("Manager Signature",f1);
            p4.setAlignment(Paragraph.ALIGN_RIGHT);
            my_bill.add(p4);
            
            my_bill.close();
            String spl[] = s7.split("-");
            String strr = "select Quantity from " + s3 + " where Company = '" + spl[0] + "' and ProductName = '" + spl[1] + "'";
             PreparedStatement stmt3 = con.prepareStatement(strr);
            ResultSet rs3 = stmt3.executeQuery();
            rs3.next();
            int f = rs3.getInt(1);
            f = f - s8;
            String strr1 = "Update " + s3 + " set Quantity = " + f + " where Company = '" + spl[0] + "' and ProductName = '" + spl[1] + "' ";
            PreparedStatement stmt4 = con.prepareStatement(strr1);
            stmt4.executeUpdate();
            
            String strr2 = "insert into payment values(?,?)";
            PreparedStatement stmt5 = con.prepareStatement(strr2);
            stmt5.setString(1, product_id.getText());
            stmt5.setString(2, payment.getText());
            stmt5.executeUpdate();
            rs.close();
            stmt2.close();
            con.close();
            
            product_id.setText("");
            // prdct_name.setText("");
            customerName.setText("");
            address.setText("");
            phone_no.setText("");
        } catch (DocumentException | HeadlessException | FileNotFoundException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}

public void onBack(ActionEvent event) {
    StageManager.getInstance().adminStage.show();
    StageManager.getInstance().bill1Stage.hide();
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
