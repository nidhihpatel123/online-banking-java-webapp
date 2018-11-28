package com.nidhi.boundries;



import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class TabPanel extends JPanel  {

    private JTabbedPane tabbedPane;
    private JPanel tabPanel_1;
    private JPanel tabPanel_2;
    private JPanel tabPanel_3;
    private JPanel tabPanel_4;


    public TabPanel(String UName, String CustomerName,String[] savingsAccount,String[] checkingAccounts){

        tabbedPane = new JTabbedPane();

        tabPanel_1 = new TablePanel(UName);
        tabPanel_2 =new OpenBankAccountPanel(UName,CustomerName);
        tabPanel_3 = new TransferBOPanel(UName,CustomerName,checkingAccounts,savingsAccount);
        tabPanel_4 = new Inquirypanel();
        tabbedPane.addTab("Account Overview", tabPanel_1);
        tabbedPane.addTab("Open Account",tabPanel_2);
        tabbedPane.setSelectedIndex(0);
        tabbedPane.addTab("Deposit/Withraw/Transfer",tabPanel_3);
        tabbedPane.add("Account Inquiry",tabPanel_4);
        add(tabbedPane);
        tabbedPane.setPreferredSize(new Dimension(700,600));

    }
}

public class BankingBO extends JFrame{

    public BankingBO(String UName, String CustomerName,String[] checkingAccounts, String[] savingsAccount){
        setTitle("Banking System");
        setSize(800, 700);

        //get screen size and set the location of the frame
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        setLocation(screenWidth / 3, screenHeight / 4);

        addWindowListener(new WindowAdapter()  //handle window event
        {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        Container container= getContentPane();
        TabPanel panel = new TabPanel(UName,CustomerName,savingsAccount,checkingAccounts);
        container.add(panel);
        show();


    }


}
