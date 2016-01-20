/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controls;

import Views.loginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author SaPhi
 */
public class newLogin {
    private loginForm login = new loginForm();
    private JButton btNext = login.getBtNext();
    private JButton btBack = login.getBtBack();
    private JButton btConfig = login.getBtConfig();
    public void run(){
        login.setVisible(true);
        nextAction();
    }
    public void nextAction(){
        btNext.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = login.getTfUsername().getText();
                String password = login.getTfPassword().getText();
                if(username.equals("")){
                    login.setMessage("Error", "Please input your username!");
                    login.getTfUsername().requestFocus();
                }
                else{
                    if (password.equals("")){
                        login.setMessage("Error", "Please input your password!");
                        login.getTfPassword().requestFocus();
                    }
                    else{
                        
                    }
                    
                }
            }
        });
    }
}
