/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author sbaba2220
 */
public class MysqlCon {
    
public static void main(String args[]){  

}


public static boolean LibrarianLogin(String email,String password) {
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=(Connection) DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/LibraryManagement","root","baba2220");  
//here LibraryManagement is database name, root is username and password
      //  System.out.println(dateStr);
        Statement stmt=(Statement) con.createStatement();
        ResultSet rs=stmt.executeQuery("select email,password from librarians where email='"+email+"' && password='"+password+"';");
        if(rs.first()) {
            return true;
        }
        else {
            return false;
        }
    }
    catch(Exception e) {
        System.out.println(e);
    }
    return false;
}


public static boolean LibrarianReturnBook(String bookId,String studentId) {
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=(Connection) DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/LibraryManagement","root","baba2220");  
//here LibraryManagement is database name, root is username and password
      //  System.out.println(dateStr);
        Statement stmt=(Statement) con.createStatement();
        ResultSet rs=stmt.executeQuery("select bookid,studentid from issuedbooks where bookid='"+bookId+"' && studentid='"+studentId+"';");
        Statement stmt2=(Statement) con.createStatement();
        if(rs.first()) {
            JOptionPane.showMessageDialog(null, rs.first());
        
            ResultSet rs2=stmt2.executeQuery("select * from bookslist where bookid='"+bookId+"';");
        //JOptionPane.showMessageDialog(null, rs.first());
        rs2.next();
            int quan = rs2.getInt("quantity");
            int issued = rs2.getInt("issued");
            quan+=1;
            issued-=1;
          //  JOptionPane.showMessageDialog(null, rs.first());
        
            stmt2.executeUpdate("Update bookslist set quantity='"+quan+"' where bookid='"+bookId+"';");
        //JOptionPane.showMessageDialog(null, rs.first());
        
            stmt2.executeUpdate("Update bookslist set issued='"+issued+"' where bookid='"+bookId+"';");
          //  JOptionPane.showMessageDialog(null, rs.first());
        stmt2.executeUpdate("Delete from issuedbooks where bookid='"+bookId+"' && studentid='"+studentId+"';");
            //JOptionPane.showMessageDialog(null, rs.first());
        con.close();
            return true;
        }
        else {
            return false;
        }
    }
    catch(Exception e) {
    System.out.println(e);
    }
    return false;
}


public static boolean LibrarianIssueBook(String bookId,String studentId,String studentName,String studentCont) {
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=(Connection) DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/LibraryManagement","root","baba2220");  
//here LibraryManagement is database name, root is username and password
      //  System.out.println(dateStr);
        Statement stmt=(Statement) con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from bookslist where bookid='"+bookId+"';");
        if(rs.first()) {
            int quan = rs.getInt("quantity");
            int issued = rs.getInt("issued");
            quan-=1;
            issued+=1;
            stmt.executeUpdate("Update bookslist set quantity='"+quan+"' where bookid='"+bookId+"';");
            stmt.executeUpdate("Update bookslist set issued='"+issued+"' where bookid='"+bookId+"';");
            stmt.executeUpdate("Insert into issuedbooks(bookid,studentid,studentname,studentcontact)"
                    + " values('"+bookId+"','"+studentId+"','"+studentName+"','"+studentCont+"');");
            con.close();
            return true;
        }
        else {
            return false;
        }
    }
    catch(Exception e) {}
    return false;
}

public static boolean LibrarianAddPresentedBook(String bookId,String bookQuantity) {
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=(Connection) DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/LibraryManagement","root","baba2220");  
//here LibraryManagement is database name, root is username and password
      //  System.out.println(dateStr);
        Statement stmt=(Statement) con.createStatement();
        ResultSet rs=stmt.executeQuery("select quantity from bookslist where bookid='"+bookId+"';");
        if(rs.first()) {
            int quan = rs.getInt("quantity");
            int bookQuant=Integer.parseInt(bookQuantity)+quan;
            stmt.executeUpdate("Update bookslist set quantity='"+bookQuant+"' where bookid='"+bookId+"';");
            con.close();
            return true;
        }
        else {
            return false;
        }
    }
    catch(Exception e) {}
    return true;
}
public static boolean LibrarianAddBook(String bookId,String bookName,String bookAuthor,String bookPublisher,String bookQuantity) throws SQLException, ClassNotFoundException {
    
//String dateStr=String.valueOf(cal);
           boolean isthere=false;
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=(Connection) DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/LibraryManagement","root","baba2220");  
//here LibraryManagement is database name, root is username and password
      //  System.out.println(dateStr);
        Statement stmt=(Statement) con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from bookslist where bookid='"+bookId+"';");
        isthere = rs.first() && rs.next();
        if(isthere) {
            return !isthere;
        }
        else {
            stmt.executeUpdate("insert into bookslist(bookid,name,author,publisher,quantity,issued) "
                    + "values('"+bookId+"','"+bookName+"','"+bookAuthor+"','"+bookPublisher+"',"
                            + "'"+bookQuantity+"',0);");  
            con.close();
            return !isthere;
        }
    }
        catch(Exception e){ System.out.println(e);}  
    return isthere;
    }

public static boolean deleteLibrarian(int id) {
    boolean isEmpty=false;
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=(Connection) DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/LibraryManagement","root","baba2220");  
        Statement stmt=(Statement) con.createStatement();  
        ResultSet rs=stmt.executeQuery("Select * from librarians where id='"+id+"';");
        isEmpty = rs.first();
        stmt.executeUpdate("Delete from librarians where id='"+id+"';");  
        con.close();
        }catch(Exception e){ System.out.println(e);}  
    return isEmpty;
}
public static void addLibrarian(String name,String password,String email,String address,String city,String phone) {
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=(Connection) DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/LibraryManagement","root","baba2220");  
        Statement stmt=(Statement) con.createStatement();  
        stmt.executeUpdate("insert into librarians(name,password,email,address,city,phone) "
                + "values('"+name+"','"+password+"','"+email+"','"+address+"','"+city+"','"+phone+"');");  
        con.close();  
        }catch(Exception e){ System.out.println(e);}  
    }  
}
