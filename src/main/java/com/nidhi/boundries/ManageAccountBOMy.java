package com.nidhi.boundries;//package com.nidhi.boundries;
//
//
//import com.nidhi.entities.CheckingAccount;
//import com.nidhi.entities.SavingsAccount;
//
//import java.awt.*;     //including Java packages used by this program
//import java.awt.event.*;
//import javax.swing.*;
//
//public class ManageAccountBOMy extends JFrame implements ActionListener
//    {
//
//        private JButton Deposit, Withdraw, Transfer;
//        private JTextField UsernameField, NameField, ToAccountField, FromAccountField, InterestRateField, BalanceField;
//        private JComboBox CheckingOrSavingsBox;
//        private String UName, AccountNumber, Balance, Name, AccountType;
//
//        public ManageAccountBOMy(String UName, String CustomerName)
//        {
//            setTitle("ManageAccount");
//            setSize(600, 500);
//
//
//            //get screen size and set the location of the frame
//            Toolkit tk = Toolkit.getDefaultToolkit();
//            Dimension d = tk.getScreenSize();
//            int screenHeight = d.height;
//            int screenWidth = d.width;
//            setLocation( screenWidth / 3, screenHeight / 4);
//
//            addWindowListener (new WindowAdapter()  //handle window event
//            {
//                public void windowClosing (WindowEvent e)
//                { System.exit(0);
//                }
//            });
//
//            CheckingOrSavingsBox = new JComboBox();
//            CheckingOrSavingsBox.addItem("Choose Account Type");
//            CheckingOrSavingsBox.addItem("Checking");
//            CheckingOrSavingsBox.addItem("Savings");
//
//            UsernameField = new JTextField(15);
//            UsernameField.setText(UName);
//            NameField = new JTextField(CustomerName);
//            ToAccountField = new JTextField(15);
//            FromAccountField = new JTextField(15);
//            BalanceField = new JTextField(15);
//            BalanceField.setText("0.0");
//
//            Deposit = new JButton("Deposit");
//            Withdraw= new JButton("Withdraw");
//            Transfer = new JButton("Transfer");
//
//            //JLabel TypeLabel = new JLabel("Choose Account Type: ");
//            JLabel NameLabel = new JLabel("Customer Name:");
//            JLabel UsernameLabel = new JLabel("Username: ");
//            JLabel NumberLabel1 = new JLabel(" FROM Account:");
//            JLabel NumberLabel2 = new JLabel(" To Account:");
//            JLabel BalanceLabel = new JLabel("Amount:");
//
//
//            JPanel TypePanel = new JPanel();
//            JPanel UsernamePanel = new JPanel();
//            JPanel NamePanel = new JPanel();
//            JPanel NumberPanel = new JPanel();
//            JPanel BalancePanel = new JPanel();
//
//
//            TypePanel.add(CheckingOrSavingsBox);
//            UsernamePanel.add(UsernameLabel);
//            UsernamePanel.add(UsernameField);
//            NamePanel.add(NameLabel);
//            NamePanel.add(NameField);
//            NumberPanel.add(NumberLabel1);
//            NumberPanel.add(FromAccountField);
//            NumberPanel.add(NumberLabel2);
//            NumberPanel.add(ToAccountField);
//
//            BalancePanel.add(BalanceLabel);
//            BalancePanel.add(BalanceField);
//
//            JPanel ManageAccountPanel = new JPanel();
//
//            ManageAccountPanel.add(TypePanel);
//            ManageAccountPanel.add(UsernamePanel);
//            ManageAccountPanel.add(NamePanel);
//            ManageAccountPanel.add(NumberPanel);
//            ManageAccountPanel.add(BalancePanel);
//
//
//            ManageAccountPanel.add(Deposit);
//            ManageAccountPanel.add(Withdraw);//add the two buttons on to this panel
//            ManageAccountPanel.add(Transfer);
//            Deposit.addActionListener(this); //event listener registration
//            Withdraw.addActionListener(this);
//            Transfer.addActionListener(this);
//
//            Container con= getContentPane();
//            con.add(ManageAccountPanel);
//
//        }
//
//        public void actionPerformed(ActionEvent evt) {
//            String arg = evt.getActionCommand();
//            System.out.println(arg);
//            if(arg.equals("Deposit")){
//                UName = UsernameField.getText(); //take actions
//                Name = NameField.getText();
//                AccountNumber = FromAccountField.getText();
//                Balance = BalanceField.getText();
//                AccountType = (String)CheckingOrSavingsBox.getSelectedItem();
//
//
//                if(AccountType.equals("Choose Account Type")){
//                    JOptionPane.showMessageDialog(null, "Please Choose an Account Type!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//                }
//                else if(AccountNumber.length() != 8){
//                    JOptionPane.showMessageDialog(null, "Please Enter an Account Number with Exactly 8 Characters!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//                }
//                else if(AccountType.equals("Checking")) {
//                    CheckingAccount checkingAdd = new CheckingAccount(AccountNumber,UName,Name,Balance);
//
//                    Boolean resultdone = checkingAdd.deposit();
//
//                    if(resultdone){
//                        JOptionPane.showMessageDialog(null, "Successfully Deposit!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                    else {
//                        JOptionPane.showMessageDialog(null, "UnSuccessfully", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//                    }
//
//                }
//                else if(AccountType.equals("Savings")){
//
//                    SavingsAccount sav = new SavingsAccount(AccountNumber,UName,Name,"0.0",Balance);
//
//                    if(sav.deposit()){
//                        JOptionPane.showMessageDialog(null, "Successfully Deposit!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//                    }
//                    else {
//                        JOptionPane.showMessageDialog(null, "UnSuccessfully", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//                    }
//
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Something Wrong!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//            else if(arg.equals("Withdraw")) {
//
//                UName = UsernameField.getText(); //take actions
//                Name = NameField.getText();
//                AccountNumber = ToAccountField.getText();
//                Balance = BalanceField.getText();
//                AccountType = (String)CheckingOrSavingsBox.getSelectedItem();
//
//                if(AccountType.equals("Choose Account Type")){
//                    JOptionPane.showMessageDialog(null,"Choose Account type","Confirmation", JOptionPane.INFORMATION_MESSAGE );
//                }
//                else if(AccountNumber.length() != 8){
//                    JOptionPane.showMessageDialog(null,"AccountNumber should have 8 digit number","Confirmation", JOptionPane.INFORMATION_MESSAGE );
//                }
//
//                if(AccountType.equals("Checking")){
//                    CheckingAccount chacc  = new CheckingAccount(AccountNumber,UName,Name,Balance);
//
//                    if(chacc.Withdraw()){
//                        JOptionPane.showMessageDialog(null,"Successfully Withraw ! ","Confirmation", JOptionPane.INFORMATION_MESSAGE );
//
//                    }
//                }
//
//
//            }
//
//        }
//public static void main( String [] args){
//    {
//        JFrame frame = new ManageAccountBOMy("nidhi2","nidhi2"); //initialize a JFrame object
//        frame.show(); //display the frame
//    }
//
//}
//    }
