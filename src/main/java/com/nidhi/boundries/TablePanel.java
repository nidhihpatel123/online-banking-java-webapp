package com.nidhi.boundries;

import com.nidhi.controllers.TablePanelControl;
import com.nidhi.entities.SavingsAccount;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class TablePanel extends JPanel implements ActionListener {

    private JButton Refreshbtn;
    private JButton interestbtn;
    public JTable table;
    public String UName;

    public TablePanel(String uName){
         UName = uName;
        TablePanelControl tpControl = new TablePanelControl(uName);
        ArrayList<Vector> userInfo = tpControl.getInformation();
        Iterator<Vector> it = userInfo.iterator();
        int arraySize = userInfo.size();
        Object[] columnNames = {"AccountType","AccountNumber", "Balance"};
        Object[][] ComponentNames = new Object[arraySize][3];

        int rowNumber = 0;
        while(it.hasNext()){
            Vector info = it.next();
            Object actType = info.get(0);
            Object actNumber = (String)info.get(1);
            Object accBala = info.get(2);
            ComponentNames[rowNumber][0] = actType;
            ComponentNames[rowNumber][1] = "****" + ((String) actNumber).substring(4,8) ;
            ComponentNames[rowNumber][2]  = accBala;
            rowNumber = rowNumber + 1;
        }

//        for (int i=0; i< ComponentNames.length; i++){
//            System.out.println(ComponentNames[i]);
//        }

        table = new JTable(ComponentNames, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(300,300));
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        Refreshbtn = new JButton("Refresh");
        interestbtn= new JButton("Show Interest");
        add(Refreshbtn);
        add(interestbtn);
        Refreshbtn.addActionListener(this);
        interestbtn.addActionListener(this);

    }

    public void refreshView(String uName){
        TablePanelControl tpControl = new TablePanelControl(uName);
        ArrayList<Vector> userInfo = tpControl.getInformation();
        Iterator<Vector> it = userInfo.iterator();
        TableModel model = table.getModel();
        int rowNumber = 0;

        while(it.hasNext()){
            Vector info = it.next();
            Object actType = info.get(0);
            Object actNumber = info.get(1);
            Object accBala = info.get(2);

            model.setValueAt(actType,rowNumber,0);
            model.setValueAt("****" + ((String) actNumber).substring(4,8),rowNumber,1);
            model.setValueAt(accBala,rowNumber,2);

            rowNumber = rowNumber + 1;
        }

    }


    public void actionPerformed(ActionEvent evt){

        String arg = evt.getActionCommand();
        if(arg.equals("Refresh")){

            refreshView(UName);

        }
        if(arg.equals("Show Interest")){

            TablePanelControl myinterest = new TablePanelControl(UName);
            String[] savingsNu = myinterest.getSavingaccountNu(UName);

            for(int i=0;i<savingsNu.length;i++){
                SavingsAccount sav= new SavingsAccount(savingsNu[i]);
                sav.calculateInterest(savingsNu[i]);
            }
            }



    }


}


