package com.nidhi.boundries; /******************************************************************************
*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
*	Date: September, 2012													  *
*******************************************************************************/

import com.nidhi.controllers.ChangePasswordControl;
import com.nidhi.controllers.LoginControl;
import com.nidhi.controllers.SignUpControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginBO extends JFrame implements ActionListener // Implementing ActionListener is for event handling.
{
    private JButton SignUpButton, LoginButton, ChangePassword;  //Instance variables
    private JTextField UsernameField;
    private JPasswordField PasswordField;


    public LoginBO()
    {
        setTitle("Login");
        setSize(300, 200);

         //get screen size and set the location of the frame
         Toolkit tk = Toolkit.getDefaultToolkit();
         Dimension d = tk.getScreenSize();
         int screenHeight = d.height;
         int screenWidth = d.width;
         setLocation( screenWidth / 3, screenHeight / 4);

         addWindowListener (new WindowAdapter()  //handle window event
            {
		       public void windowClosing (WindowEvent e)
			                  { System.exit(0);
               }
            });

         SignUpButton = new JButton("Sign Up"); //initializing two button references
         LoginButton = new JButton("Login");
         ChangePassword = new JButton("ChangePSWD");

         UsernameField = new JTextField(15);
         PasswordField = new JPasswordField(15);

         JLabel FirstTimeUserLabel = new JLabel("First time user? Click Sign Up to register!");
         JLabel UsernameLabel = new JLabel("Username: ");
         JLabel PasswordLabel = new JLabel("Password: ");

         JPanel UsernamePanel = new JPanel();
         JPanel PasswordPanel = new JPanel();

         UsernamePanel.add(UsernameLabel);
         UsernamePanel.add(UsernameField);
         PasswordPanel.add(PasswordLabel);
         PasswordPanel.add(PasswordField);

         JPanel LoginPanel = new JPanel();
         LoginPanel.add(UsernamePanel);
         LoginPanel.add(PasswordPanel);

         LoginPanel.add(LoginButton);
         LoginPanel.add(ChangePassword);//add the two buttons on to this panel
         LoginPanel.add(FirstTimeUserLabel);
         LoginPanel.add(SignUpButton);

         SignUpButton.addActionListener(this);  //event listener registration
         LoginButton.addActionListener(this);
         ChangePassword.addActionListener(this);

         Container contentPane = getContentPane(); //add a panel to a frame
         contentPane.add(LoginPanel);

	}

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        //Object source = evt.getSource(); //get who generates this event
        String arg = evt.getActionCommand();

        if (arg.equals("Sign Up")) { //determine which button is clicked
            //System.out.println("Name: "+arg);
            SignUpControl SUC = new SignUpControl(); //take actions
		}

		if (arg.equals("Login")) {
			//System.out.println("Name: "+arg);
			String Username = UsernameField.getText();
			String Password = PasswordField.getText();
            LoginControl LoginC = new LoginControl(Username, Password);
		}
        System.out.println(arg);
		if (arg.equals("ChangePSWD")){

            ChangePasswordControl newpswd = new ChangePasswordControl();


        }
    }

    public static void main(String [] args)
    { JFrame frame = new LoginBO(); //initialize a JFrame object
      frame.show(); //display the frame
    }
}

