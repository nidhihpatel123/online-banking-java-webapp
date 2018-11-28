package com.nidhi.boundries;

import com.nidhi.controllers.TransferControl;
import com.nidhi.entities.CheckingAccount;
import com.nidhi.entities.SavingsAccount;
import com.nidhi.entities.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class TransferBOPanel extends JPanel implements ActionListener

{

    private JButton Deposit, Withdraw, Transfer;
    private JTextField UsernameField, NameField,BalanceField;
    private JComboBox CheckingOrSavingsBox,ToAccountField,FromAccountField;
    private String UName, AccountNumber, Balance, Name, AccountType;

    TransferBOPanel(String UName, String CustomerName, String[] checkingAccounts, String[] SavingAccounts) {

//        CheckingOrSavingsBox = new JComboBox();
//        CheckingOrSavingsBox.addItem("Choose Account Type");
//        CheckingOrSavingsBox.addItem("Checking");
//        CheckingOrSavingsBox.addItem("Savings");

        UsernameField = new JTextField(15);
        UsernameField.setText(UName);
        NameField = new JTextField(CustomerName);
        ToAccountField = new JComboBox();
        ToAccountField.addItem("Select Account");
        for(int i = 0 ; i < checkingAccounts.length; i ++){
            if(checkingAccounts[i] != null){
                ToAccountField.addItem("Checking - " + checkingAccounts[i]);
            }
        }
        for(int i = 0 ; i < SavingAccounts.length; i ++){
            if(SavingAccounts[i] != null){
                ToAccountField.addItem("Savings - " + SavingAccounts[i]);
            }
        }
        FromAccountField = new JComboBox();
        FromAccountField.addItem("Select Account");
        for(int i = 0 ; i < checkingAccounts.length; i ++){
            if(checkingAccounts[i] != null){
                FromAccountField.addItem("Checking - " + checkingAccounts[i]);
            }
        }
        for(int i = 0 ; i < SavingAccounts.length; i ++){
            if(SavingAccounts[i] != null){
                FromAccountField.addItem("Savings - " + SavingAccounts[i]);
            }
        }
        BalanceField = new JTextField(15);
        BalanceField.setText("0.0");

        Deposit = new JButton("Deposit");
        Withdraw = new JButton("Withdraw");
        Transfer = new JButton("Transfer");

        //JLabel TypeLabel = new JLabel("Choose Account Type: ");
        JLabel NameLabel = new JLabel("Customer Name:");
        JLabel UsernameLabel = new JLabel("Username: ");
        JLabel NumberLabel1 = new JLabel(" FROM Account:");
        JLabel NumberLabel2 = new JLabel(" To Account:");
        JLabel BalanceLabel = new JLabel("Amount:");


        JPanel TypePanel = new JPanel();
        JPanel UsernamePanel = new JPanel();
        JPanel NamePanel = new JPanel();
        JPanel NumberPanel = new JPanel();
        JPanel BalancePanel = new JPanel();


//        TypePanel.add(CheckingOrSavingsBox);
        UsernamePanel.add(UsernameLabel);
        UsernamePanel.add(UsernameField);
        NamePanel.add(NameLabel);
        NamePanel.add(NameField);
        NumberPanel.add(NumberLabel1);
        NumberPanel.add(FromAccountField);
        NumberPanel.add(NumberLabel2);
        NumberPanel.add(ToAccountField);

        BalancePanel.add(BalanceLabel);
        BalancePanel.add(BalanceField);


        add(TypePanel);
        add(UsernamePanel);
        add(NamePanel);
        add(NumberPanel);
        add(BalancePanel);


        add(Deposit);
        add(Withdraw);//add the two buttons on to this panel
        add(Transfer);
        Deposit.addActionListener(this); //event listener registration
        Withdraw.addActionListener(this);
        Transfer.addActionListener(this);

    }

    public void actionPerformed(ActionEvent act) {

        String arg = act.getActionCommand();
        if (arg.equals("Deposit")) {
            UName = UsernameField.getText(); //take actions
            Name = NameField.getText();
            Balance = BalanceField.getText();
            AccountType = (String) ToAccountField.getSelectedItem();
            String selectedAccountType = AccountType.substring(0,8);
            System.out.println(selectedAccountType);


            if (AccountType.equals("Select Account")) {
                JOptionPane.showMessageDialog(null, "Please choose Account type!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (selectedAccountType.equals("Checking")) {
                String AccountNumber = AccountType.substring(11,19);
                CheckingAccount checkingAdd = new CheckingAccount(AccountNumber, Name, UName, Balance);
                Boolean resultdonecheck = checkingAdd.deposit();

                if (resultdonecheck) {

                    JOptionPane.showMessageDialog(null, "Successfully Deposit!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    Transaction transct = new Transaction(Balance,"deposit", null ,AccountNumber,UName);
                    transct.record();

                } else {
                    JOptionPane.showMessageDialog(null, "UnSuccessfully Deposit", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (selectedAccountType.equals("Savings ")) {
                String AccountNumber = AccountType.substring(10,18);
                SavingsAccount sav = new SavingsAccount(AccountNumber, Name, UName, "0.0", Balance);
                Boolean resultdoneSav = sav.deposit();
                System.out.println("I am here");

                if (resultdoneSav) {
                    JOptionPane.showMessageDialog(null, "Successfully Deposit!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    Transaction transct = new Transaction(Balance,"deposit", null ,AccountNumber,UName);
                    transct.record();
                } else {
                    JOptionPane.showMessageDialog(null, "UnSuccessfully Deposit!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
        if (arg.equals("Withdraw")) {
            UName = UsernameField.getText(); //take actions
            Name = NameField.getText();
            Balance = BalanceField.getText();
            AccountType = (String) FromAccountField.getSelectedItem();
            String selectedAccountType = AccountType.substring(0,8);
            System.out.println(selectedAccountType);
            if (AccountType.equals("Select Account")) {
                JOptionPane.showMessageDialog(null, "Please choose Account type!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
            } else if (selectedAccountType.equals("Checking")) {
                String AccountNumber = AccountType.substring(11,19);
                System.out.println(AccountNumber);
                CheckingAccount checkingAdd = new CheckingAccount(AccountNumber, Name, UName, Balance);
                Boolean resultdonecheck2 = checkingAdd.Withdraw();

                if (resultdonecheck2) {
                    JOptionPane.showMessageDialog(null, "Successfully Withdraw!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    Transaction transct = new Transaction(Balance,"withdraw",AccountNumber,null,UName);
                    transct.record();
                } else {
                    JOptionPane.showMessageDialog(null, "UnSuccessfully Withdraw! ", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                }
            } else if (selectedAccountType.equals("Savings ")) {
                String AccountNumber = AccountType.substring(10,18);
                System.out.println(AccountNumber);
                SavingsAccount sav = new SavingsAccount(AccountNumber, Name, UName, "0.0", Balance);
                Boolean resultdoneSav2 = sav.withdraw();
                if (resultdoneSav2) {
                    JOptionPane.showMessageDialog(null, "Successfully Withdraw!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    Transaction transct = new Transaction(Balance, "withdraw",AccountNumber,null,UName);
                    transct.record();
                } else {
                    JOptionPane.showMessageDialog(null, "UnSuccessfully Withraw!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                }


            }


        }
        if(arg.equals("Transfer")){
            UName = UsernameField.getText(); //take actions
            Name = NameField.getText();
            Balance = BalanceField.getText();
            String fromAccount = (String) FromAccountField.getSelectedItem();
            String toAccount = (String) ToAccountField.getSelectedItem();

            TransferControl tfc = new TransferControl(toAccount,fromAccount,UName,Name,Balance);
            tfc.transfer();
        }
    }
}

public class TransferBO extends JFrame
{

    private TransferBOPanel MBA_Panel;

    public TransferBO(String UName, String CustomerName, String[] checkingAccounts, String[] SavingAccounts) {

        setTitle("Mange a Bank Account");
        setSize(700, 400);

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

        Container contentPane = getContentPane(); //add a panel to a frame
        MBA_Panel = new TransferBOPanel(UName, CustomerName,checkingAccounts,SavingAccounts);
        contentPane.add(MBA_Panel);
        show();
    }
}



