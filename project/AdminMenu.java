/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 20101
 */
public class AdminMenu extends JFrame implements ActionListener {

    public AdminMenu() throws HeadlessException {
        
         
        Container c = getContentPane();
        c.setLayout(null);

        setSize(700, 480);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Menu - Admin");
//        setLayout(new FlowLayout(FlowLayout.CENTER , 100 , 250));
      
        setVisible(true);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
