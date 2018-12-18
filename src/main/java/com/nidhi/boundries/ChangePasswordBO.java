package com.nidhi.boundries;

import com.nidhi.entities.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChangePasswordBO extends JFrame implements ActionListener {

    private JButton ChangePasswordButton;
    private JTextField usernamefield;
    private JTextField passwordfield;
    private JTextField newPasswordfield;
    private JTextField reenterNewPswd;


    public ChangePasswordBO() {

        setTitle("Login");
        setSize(600, 500);

        //get screen size and set the location of the frame
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        setLocation(screenWidth / 2, screenHeight / 4);

        addWindowListener(new WindowAdapter()  //handle window event
        {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        ChangePasswordButton = new JButton("ChangePassword");

        JLabel usernamelabel = new JLabel("Username");
        JLabel passwordlabel = new JLabel("Password");
        JLabel newPasswordlabel = new JLabel("NewPassword");
        JLabel rePasswordlabel = new JLabel("re-EnterNewPassword");

        usernamefield = new JTextField(15);
        passwordfield = new JTextField(15);
        newPasswordfield = new JTextField(15);
        reenterNewPswd = new JTextField(15);

        JPanel usernamepanel = new JPanel();
        JPanel passwordpanel = new JPanel();

        usernamepanel.add(usernamelabel);
        usernamepanel.add(usernamefield);

        passwordpanel.add(passwordlabel);
        passwordpanel.add(passwordfield);
        passwordpanel.add(newPasswordlabel);
        passwordpanel.add(newPasswordfield);
        passwordpanel.add(rePasswordlabel);
        passwordpanel.add(reenterNewPswd);

        JPanel ChanagePasswordPanel = new JPanel();

        ChanagePasswordPanel.add(usernamepanel);
        ChanagePasswordPanel.add(passwordpanel);
        ChanagePasswordPanel.add(ChangePasswordButton);

        ChangePasswordButton.addActionListener(this);

        Container contentPane = getContentPane();
        contentPane.add(ChanagePasswordPanel);
    }

    public void actionPerformed(ActionEvent e) {

        String arg = e.getActionCommand();
        System.out.println(arg);
        if(arg.equals("ChangePassword")){

           String username = usernamefield.getText();
           String password = passwordfield.getText();
           String newPassword = newPasswordfield.getText();
           String reNewPassword = reenterNewPswd.getText();

         if(newPassword.equals(reNewPassword)){

            Account Acc = new Account(username, password, newPassword);
            if(Acc.changepswd()) {
                JOptionPane.showMessageDialog(null, "Password Changed", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
            else{JOptionPane.showMessageDialog(null, "Something Wrong!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);}

         }
         else{
             JOptionPane.showMessageDialog(null, " newpassword and reNewPassword should be same", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
         }

        }

    }
}