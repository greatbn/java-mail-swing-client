/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controls;


import Models.userModel;
import Views.configServerMailForm;
import Views.inboxForm;
import Views.loginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author SaPhi
 */
public class mainControl {
    private userModel model;
    
    // connect toi database neu table chua duoc tao thi khoi tao table de luu user la cac email va password
    public static Connection ConnectDatabase(){
         Connection c = null;
         Statement stmt = null;
          try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:user.db");
            stmt = c.createStatement();
            String sql = "create table if not exists user(ID INT PRIMARY KEY NOT NULL, EMAIL CHAR(100) NOT NULL, PASSWORD CHAR(100) NOT NULL)";
            stmt.executeUpdate(sql);
          return c;
        }catch(ClassNotFoundException e){
             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
            
        } catch (SQLException ex) {
            Logger.getLogger(mainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    // kiem tra xem co ban ghi nao trong database ko?
    public static boolean checkDataBase(){
       Connection conn;
        conn = ConnectDatabase();
       String sql = "select * from user";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            boolean empty = true;
            while(rs.next()){
             empty = false;
            }            
            return empty;
        } catch (SQLException ex) {
            Logger.getLogger(mainControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       
        
    }
    public void run(){
        if(checkDataBase()){
            inboxForm inbox = new inboxForm();
            inbox.setVisible(true);
        }
        else{
            final loginForm  login = new loginForm();
            login.setVisible(true);
            JButton btNext = login.getBtNext();
            JButton btConfig = login.getBtConfig();
            JButton btBack = login.getBtBack();
            btNext.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(login.getTfUsername().getText().equals("")){
                        login.setMessage("Error", "Please input email");
                    }
                    else{
                        if(login.getTfPassword().getText().equals("")){
                        login.setMessage("Error", "Please input your password");
                    }
                        else{
                            model = login.getUser();
                        }
                    }
                         
                }
            });
            
            btConfig.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    configServerMailForm config = new configServerMailForm();
                    config.setVisible(true);
                }
            });
        }
    }
}
