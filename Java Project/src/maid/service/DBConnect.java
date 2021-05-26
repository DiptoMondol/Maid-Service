package maid.service;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import maid.service.Maid.MaidFrame;
import maid.service.User.UserFrame;

public class DBConnect {

    private Connection con;

    private Statement st;
    private ResultSet rs;

    //constructors
    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Step-1: get a connection to the db
            con = DriverManager.getConnection("jdbc:mysql://localhost/maid service", "root", "");
            System.out.println("DB Connect Successful");
            //Step-2: create a statement
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

    public static Connection ConncerDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Step-1: get a connection to the db
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/maid service", "root", "");
            return conn;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return null;
    }

    //parameterized constructor
    public DBConnect(String url, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Step-1: get a connection to the db
            con = DriverManager.getConnection(url, user, password);
            //Step-2: create a statement
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

    public ResultSet getResultSet() {
        try {
            String query = "SELECT `Nid`, `Name`, `Work type`,`Salary`,`Working Hours` FROM `maid frame` ";
            //Step-3: Execute SQL query
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getResultSetcontact() {
        try {
            String query = "SELECT * FROM `contact form` ";
            //Step-3: Execute SQL query
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getResultSetpost() {
        try {
            String query = "SELECT * FROM `post` ";
            //Step-3: Execute SQL query
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return rs;
    }
//maid insert database

    public void insertIntoDBformaid(ArrayList row) {
        try {
            String query = "INSERT INTO `maid frame`(`Nid`, `Name`, `Password`, `Work type`, `Location`, `Holiday`, `Question`, `Answer`, `Gender`, `Salary`, `Working Hours`, `Phone`)"
                    + " values('" + row.get(0) + "','" + row.get(1) + "','" + row.get(2) + "','" + row.get(3) + "','" + row.get(4) + "','" + row.get(5) + "','" + row.get(6) + "','" + row.get(7) + "','" + row.get(8) + "','" + row.get(9) + "','" + row.get(10) + "','" + row.get(11) + "' )";
            System.out.println(query);
            //Step-3: Execute SQL query
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Maid Register Successfully.");
            LoginFrame lg = new LoginFrame();
            lg.setVisible(true);
            MaidFrame mg = new MaidFrame();
            mg.setVisible(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Insert into Database Exception: " + e);
            System.out.println(e);
        }

    }

    //user insert database
    public void insertIntoDBforuser(ArrayList row) {
        try {
            String query = "INSERT INTO `user frame`(`Nid`, `Name`, `Password`, `Email`, `Address`, `Company`, `Question`, `Answer`, `Gender`, `Phone`) values('" + row.get(0) + "','" + row.get(1) + "','" + row.get(2) + "','" + row.get(3) + "','" + row.get(4) + "','" + row.get(5) + "','" + row.get(6) + "','" + row.get(7) + "','" + row.get(8) + "','" + row.get(9) + "' )";
            System.out.println(query);
            //Step-3: Execute SQL query
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "User Register Successfully.");
            LoginFrame lg = new LoginFrame();
            lg.setVisible(true);
            UserFrame uf = new UserFrame();
            uf.setVisible(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Insert into Database Exception: " + e);
            System.out.println(e);
        }

    }

    public void insertIntoDBforcontactform(ArrayList row) {
        try {
            String query = "INSERT INTO `contact form`(`Reason for contacting`, `Name`, `Email`, `Mobile number`, `City`, `Comment`) values('"
                    + row.get(0) + "','" + row.get(1) + "','" + row.get(2) + "','" + row.get(3) + "','" + row.get(4) + "','" + row.get(5) + "' )";
            System.out.println(query);
            //Step-3: Execute SQL query
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Contact Form Sent Successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Insert into Database Exception: " + e);
            System.out.println(e);
        }

    }

    public void insertIntopost(ArrayList row) {
        try {
            String query = "INSERT INTO `post`(`Maid Name`, `Maid Nid`, `Work type`, `Your Name`, `Your Nid`) values('"
                    + row.get(0) + "','" + row.get(1) + "','" + row.get(2) + "','" + row.get(3) + "','" + row.get(4) + "' )";
            System.out.println(query);
            //Step-3: Execute SQL query
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Insert into Database Exception: " + e);
            System.out.println(e);
        }

    }

}
