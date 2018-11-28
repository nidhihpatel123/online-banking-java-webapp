package com.nidhi.boundries;


import com.nidhi.controllers.InquiryControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;


class Inquirypanel extends JPanel implements ActionListener {

    private JButton Search;
    private JTextField startdateField, enddateField;
    InquiryResultPanel inquiryresult;

    public Inquirypanel(){


        Search = new JButton("Inquiry");

        JLabel start = new JLabel("Start Date:");
        startdateField = new JTextField("YYYY/MM/DD");
        JLabel end =new JLabel("End Date:");
        enddateField = new JTextField("YYYY/MM/DD");
        inquiryresult = new InquiryResultPanel();

        add(start);
        add(startdateField);
        add(end);
        add(enddateField);
        add(Search);
        add(inquiryresult);

        Search.addActionListener(this);

    }

    public void actionPerformed(ActionEvent evt)  //event handling
    {
        String arg = evt.getActionCommand();
        if(arg.equals("Inquiry")){

            String startDate = startdateField.getText();
            System.out.println(startDate);
            String endDate = enddateField.getText();
            System.out.println(endDate);

            inquiryresult.populateData(startDate,endDate);



        }

    }

    class InquiryResultPanel extends JPanel{

    private JTable InquiryTable;
    DefaultTableModel model;
    public InquiryResultPanel(){

            InquiryTable = new JTable();

        InquiryTable.setPreferredScrollableViewportSize(new Dimension(630,600));
        JScrollPane scroll = new JScrollPane(InquiryTable);
        add(scroll);

    }


    public void populateData(String startDate,String endDate){
        model = new DefaultTableModel(new String[] { "TransctionNumber","TransctionAmount","TransctionType","TransctionDate","FromAccount","ToAccount" },0);
        InquiryTable.setModel(model);
        InquiryControl inquiryCO = new InquiryControl(startDate,endDate);
        ArrayList<Vector> myarray = inquiryCO.searchTransction();
        Iterator<Vector> ite = myarray.iterator();

        while(ite.hasNext()){

            Vector result = ite.next();
            Object tnumber = result.get(0);
            Object tamount = result.get(1);
            Object ttype = result.get(2);
            Object tdate = result.get(3);
            Object faccount = result.get(4);
            Object taccount = result.get(5);
            model.addRow(new Object[]{tnumber,tamount,ttype,tdate,faccount,taccount});


        }
    }

    }

}

public class InquiryBO extends JFrame {

    public InquiryBO(){

        setTitle("Banking System");
        setSize(700, 500);

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
        Inquirypanel panel = new Inquirypanel();
        container.add(panel);
        show();

    }

    }


