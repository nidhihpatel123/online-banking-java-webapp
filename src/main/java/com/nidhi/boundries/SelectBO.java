package com.nidhi.boundries;//package com.nidhi.boundries;
//
//
//
//
////import com.nidhi.controllers.ManageAccountControl;
//import com.nidhi.boundries.TransferBO;
//import com.nidhi.controllers.ManageAccountControl;
//import com.sun.xml.internal.xsom.impl.UName;
//
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//
//
//public class SelectBO extends JFrame implements ActionListener {
//
//    private JButton Deposite, Withdraw, Transfer;
//
//
//    public SelectBO() {
//
//        setTitle("SelectType");
//        setSize(300,200);
//
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        Dimension d = tk.getScreenSize();
//        int screenHeight = d.height;
//        int screenWidth = d.width;
//        setLocation( screenWidth / 3, screenHeight / 4);
//
//        addWindowListener (new WindowAdapter()  //handle window event
//        {
//            public void windowClosing (WindowEvent e)
//            { System.exit(0);
//            }
//        });
//
//        Deposite = new JButton("Deposite");
//        Withdraw = new JButton("Withdraw");
//        Transfer= new JButton("Transfer");
//
//        JPanel selectpanel = new JPanel();
//
//        selectpanel.add(Deposite);
//        selectpanel.add(Withdraw);
//        selectpanel.add(Transfer);
//
//        Deposite.addActionListener(this);
//        Withdraw.addActionListener(this);
//        Transfer.addActionListener(this);
//
//        Container contain = getContentPane();
//        contain.add(selectpanel);
//        }
//
//        public void actionPerformed(ActionEvent evt){
//
//        String arg = evt.getActionCommand();
//
//        if(arg.equals("Deposit")){
//            ManageAccountControl mag = new ManageAccountControl();
//
//        }
//
//
//
//    }
//    public static void main( String [] args){
//        {
//            JFrame frame = new SelectBO(); //initialize a JFrame object
//            frame.show(); //display the frame
//        }
//
//    }
//}
//
