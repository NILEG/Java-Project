/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Umair
 */
public class D3 extends Disease{
    private ArrayList<String> anisicoria = new ArrayList<String>();
    Panel2 panel;
    Panel3 panel3;
    JPanel Interface;
    public D3(Panel2 panel, JPanel Interface, Panel3 panel3)
    {
        System.out.println("D3 activated");
        panel.setQuestionOption("Is it recent or longstanding?", "Recent", "Longstanding");
        this.panel=panel;
        this.Interface=Interface;
        this.panel3=panel3;
    }

    public void calculation(String question, String option)
    {
    if(question.equals("Is it recent or longstanding?"))
    {
        if(option.equals("Recent"))
        {
            Collections.addAll(anisicoria, "horner SAME", "3rd Nerve Palsy", "Uveitis", "Closed AGA");
            panel.setQuestionOption("Is there any vision loss?", "Yes", "No");
        }
        else
        {
            Collections.addAll(anisicoria, "physiological", "Adies", "Horner Routine");
            panel.setQuestionOption("Is there any vision loss?", "Yes", "No");
        }
    }
        else if(question.equals("Is there any vision loss?"))
    {
        if(option.equals("Yes"))
        {
            Collections.addAll(anisicoria, "Adies", "Uveitis", "Closed AGA");
            panel.setQuestionOption("Is there any double vision?", "Yes", "No");
        }
        else
        {
            Collections.addAll(anisicoria, "physiological", "3rd Nerve Palsy", "Horner Routine", "horner SAME");
            panel.setQuestionOption("Is there any double vision?", "Yes", "No");
        }
    }
        else if(question.equals("Is there any double vision?"))
    {
        if(option.equals("Yes"))
        {
            Collections.addAll(anisicoria, "3rd Nerve Palsy");
            panel.setQuestionOption("Is there any pain?", "Yes", "No");
        }
        else
        {
            Collections.addAll(anisicoria, "physiological", "Adies", "Uveitis", "Closed AGA", "Horner Routine", "horner SAME");
            panel.setQuestionOption("Is there any pain?", "Yes", "No");
        }
    }
        else if(question.equals("Is there any pain?"))
    {
        if(option.equals("Yes"))
        {
            Collections.addAll(anisicoria, "Uveitis", "Closed AGA");
            panel.setQuestionOption("Is there any light sensitivity?", "Yes", "No");
        }
        else
        {
            Collections.addAll(anisicoria, "physiological", "Adies", "3rd Nerve Palsy", "Horner Routine", "horner SAME");
            panel.setQuestionOption("Is there any light sensitivity?", "Yes", "No");
        }
    }
        else if(question.equals("Is there any light sensitivity?"))
    {
        if(option.equals("Yes"))
        {
            Collections.addAll(anisicoria, "Uveitis");
            panel.setQuestionOption("Is there any haloes around lights?", "Yes", "No");
        }
        else
        {
            Collections.addAll(anisicoria, "physiological", "Adies", "3rd Nerve Palsy", "Horner Routine", "horner SAME", "Closed AGA");
            panel.setQuestionOption("Is there any haloes around lights?", "Yes", "No");
        }
    }
        else if(question.equals("Is there any haloes around lights?"))
    {
        if(option.equals("Yes"))
        {
            Collections.addAll(anisicoria, "Closed AGA");
            panel.setQuestionOption("Have you had previous uveitis?", "Yes", "No");
        }
        else
        {
            Collections.addAll(anisicoria, "physiological", "Adies", "3rd Nerve Palsy", "Horner Routine", "horner SAME", "Uveitis");
            panel.setQuestionOption("Have you had previous uveitis?", "Yes", "No");
        }
    }
        else if(question.equals("Have you had previous uveitis?"))
    {
        if(option.equals("Yes"))
        {
            Collections.addAll(anisicoria, "Uveitis");
            panel.setQuestionOption("Do you have diabetes or high blood pressure?", "Yes", "No");
        }
        else
        {
            Collections.addAll(anisicoria, "physiological", "Adies", "3rd Nerve Palsy", "Horner Routine", "horner SAME", "Closed AGA");
            panel.setQuestionOption("Do you have diabetes or high blood pressure?", "Yes", "No");
        }
    }
        else if(question.equals("Do you have diabetes or high blood pressure?"))
    {
        if(option.equals("Yes"))
        {
            Collections.addAll(anisicoria, "3rd Nerve Palsy");
        }
        this.analyze();
    }
}

    private void analyze()
    {
        //Writing Date to File
        FileHandling.writeFile(this.getDate());
        //Writing Disease Name to File
        FileHandling.writeFile("Disease: Anisicoria");
        Set<String> st = new HashSet<String>(anisicoria);
        //Creating 2-D String array for holding Data
        String[][] data=new String[st.size()][2];

        //Creating Columns Heading Array of type String
        String[] columnNames={"Name", "Percentage"};

        int counter=0;
        for (String s : st)
        {
            //Writing Data to data array
            double frequency=Collections.frequency(anisicoria, s);
            data[counter][0]=s;
            data[counter][1]=String.format("%.2f",((frequency/anisicoria.size())*100))+"%";

            //Writing to File
            FileHandling.writeFile(s + ": " + String.format("%.2f",((frequency/anisicoria.size())*100))+"%");
            counter++;

        }
        //Putting Blank Line in File
        FileHandling.writeFile("\n\n");

        //Creating JTabel and JScrollPane
        JTable table=new JTable(data, columnNames);
        //------Modifying table-----
        table.setFont(new Font("Roboto", Font.PLAIN, 16));
        table.setRowHeight(28);
        JTableHeader header=table.getTableHeader();
        header.setPreferredSize(new Dimension(100,40));
        header.setFont(new Font("Roboto", Font.BOLD, 16));
        header.setBackground(Styles.secondaryBg);
        header.setForeground(Color.white);
        //-------------------------
        JScrollPane pane=new JScrollPane(table);
        this.panel3.tablePlaceHolder.add(pane);
        this.panel3.tablePlaceHolder.revalidate();
        ((CardLayout) this.Interface.getLayout()).show(this.Interface, "Panel3");


    }

    private String getDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}

