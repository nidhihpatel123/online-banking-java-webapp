package com.nidhi.boundries;//package com.nidhi.boundries;
//
//import com.nidhi.controllers.TablePanelControl;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Vector;
//
//public class practise {
//}
//    public TablePanel(String uName){
//
//        TablePanelControl tpControl = new TablePanelControl(uName);
//        ArrayList<Vector> userInfo = tpControl.getInformation();
//        Iterator<Vector> it = userInfo.iterator();
//        int arraySize = userInfo.size();
//        Object[] columnNames = {"AccountType","AccountNumber", "Balance"};
//        Object[][] ComponentNames = new Object[arraySize][3];
//
//        int rowNumber = 0;
//        while(it.hasNext()){
//            Vector info = it.next();
//            Object actType = info.get(0);
//            Object actNumber = (String)info.get(1);
//            Object accBala = info.get(2);
//            ComponentNames[rowNumber][0] = actType;
//            ComponentNames[rowNumber][1] = "****" + ((String) actNumber).substring(4,8) ;
//            ComponentNames[rowNumber][2]  = accBala;
//            rowNumber = rowNumber + 1;
//        }
//
////        for (int i=0; i< ComponentNames.length; i++){
////            System.out.println(ComponentNames[i]);
////        }
//
//        table = new JTable(ComponentNames, columnNames);
//        table.setPreferredScrollableViewportSize(new Dimension(300,300));
//        JScrollPane scroll = new JScrollPane(table);
//        add(scroll);
//        Refreshbtn = new JButton("Refresh");
//        interestbtn= new JButton("Show Interest");
//        add(Refreshbtn);
//        add(interestbtn);
//        Refreshbtn.addActionListener(this);
//        interestbtn.addActionListener(this);
//
//    }