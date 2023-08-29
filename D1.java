/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project;

import java.awt.*;
import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Umair
 */
public class D1 extends Disease{
    
    private ArrayList<String> headache = new ArrayList<String>();
    Panel2 panel;
    Panel3 panel3;
    JPanel Interface;
    public D1(Panel2 panel, JPanel Interface, Panel3 panel3)
    {
        System.out.println("D1 activated");
        this.panel=panel;
        this.panel.setQuestionOption("Are the headaches unilateral or bilateral?", "Unilateral", "Bilateral");
        this.Interface=Interface;
        this.panel3=panel3;
    }
    public void calculation(String question, String option)
    {
        if(question.equals("Are the headaches unilateral or bilateral?"))
        {
            if(option.equals("Unilateral"))
            {
                Collections.addAll(headache, "Migraine(Routine)", "Migraine(Advise)", "ON(PSD)", "ON(PU1)", "ON(Acute)");
                panel.setQuestionOption("Did this headache come on suddenly or gradually?", "Suddenly", "Gradually");
            }
            else
            {
                Collections.addAll(headache, "Migraine(Routine)", "Migraine(Advise)", "ON(PSD)", "ON(PU1)", "ON(Acute)", "Brain Disease(SD)",
                 "HCD(Routine)", "ETTH(Advise)");
                panel.setQuestionOption("Did this headache come on suddenly or gradually?", "Suddenly", "Gradually");
            }
        }
        else if(question.equals("Did this headache come on suddenly or gradually?"))
        {
            if(option.equals("Suddenly"))
            {
                Collections.addAll(headache, "ON(Acute)");
                panel.setQuestionOption("Does this occur in transient episodes?", "Yes", "No");
            }
            else
            {
                Collections.addAll(headache, "ON(PSD)", "ON(PU1)");
                panel.setQuestionOption("Does this occur in transient episodes?", "Yes", "No");
            }
        }
        else if(question.equals("Does this occur in transient episodes?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(headache, "Migraine(Routine)", "Migraine(Advise)", "Brain Disease(SD)");
                panel.setQuestionOption("Are the headaches recurrent?", "Yes", "No");
            }
            else
            {
                Collections.addAll(headache, "Migraine(Routine)", "Migraine(Advise)", "ON(PSD)", "ON(PU1)", "ON(Acute)");
                panel.setQuestionOption("Are the headaches recurrent?", "Yes", "No");
            }
        }
        else if(question.equals("Are the headaches recurrent?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(headache, "Migraine(Routine)", "Migraine(Advise)", "Brain Disease(SD)", "HCD(Routine)", "ETTH(Advise)");
                panel.setQuestionOption("Is Vision Loss present?", "Yes", "No");
            }
            else
            {
                Collections.addAll(headache, "ON(PSD)", "ON(PU1)", "ON(Acute)");
                panel.setQuestionOption("Is Vision Loss present?", "Yes", "No");
            }
        }
        else if(question.equals("Is Vision Loss present?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(headache, "Brain Disease(SD)", "ON(PSD)", "ON(PU1)", "ON(Acute)", "Migraine(Routine)", "Migraine(Advise)");
                panel.setQuestionOption("Is Vision loss in central(peri) or shadow like?", "Central", "Shadow");
            }
            else
            {
                Collections.addAll(headache, "HCD(Routine)", "ETTH(Advise)");
                panel.setQuestionOption("Do you have any of the following: unusual headache, tender scalp, jaw ache when chewing, ear or neck pain, weight loss, fatigue, muscle aches", "Yes", "No");
            }
        }
        else if(question.equals("Is Vision loss in central(peri) or shadow like?"))
        {
            if(option.equals("Central"))
            {
                Collections.addAll(headache, "ON(PSD)", "ON(PU1)", "ON(Acute)", "Migraine(Routine)", "Migraine(Advise)");
                panel.setQuestionOption("Do you have any of the following: unusual headache, tender scalp, jaw ache when chewing, ear or neck pain, weight loss, fatigue, muscle aches", "Yes", "No");
            }
            else
            {
                panel.setQuestionOption("Do you have any of the following: unusual headache, tender scalp, jaw ache when chewing, ear or neck pain, weight loss, fatigue, muscle aches", "Yes", "No");
            }
        }
        else if(question.equals("Do you have any of the following: unusual headache, tender scalp, jaw ache when chewing, ear or neck pain, weight loss, fatigue, muscle aches"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(headache, "Temporal Arteritis");
                panel.setQuestionOption("Do you have Eye pain?", "Yes", "No");
            }
            else
            {
                Collections.addAll(headache, "ON(PSD)", "ON(PU1)", "ON(Acute)", "HCD(Routine)", "ETTH(Advise)", "Migraine(Routine)",
                 "Migraine(Advise)", "Brain Disease(SD)");
                panel.setQuestionOption("Do you have Eye pain?", "Yes", "No");
            }
        }
        else if(question.equals("Do you have Eye pain?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(headache, "Brain Disease(SD)", "ON(PSD)", "ON(PU1)", "ON(Acute)");
                panel.setQuestionOption("Is pain moderate or shooting?", "Moderate", "Shooting");
            }
            else
            {
                Collections.addAll(headache, "HCD(Routine)", "ETTH(Advise)", "Migraine(Routine)", "Migraine(Advise)");
                panel.setQuestionOption("Are the headaches worse when lying down?", "Yes", "No");
            }
        }
        else if(question.equals("Is pain moderate or shooting?"))
        {
            if(option.equals("Moderate"))
            {
                panel.setQuestionOption("Do you have any head/neck pain?", "Yes", "No");
            }
            else
            {
                panel.setQuestionOption("Do you have any head/neck pain?", "Yes", "No");
            }
        }
        else if(question.equals("Do you have any head/neck pain?"))
        {
            if(option.equals("Yes"))
            {
                panel.setQuestionOption("Is eye pain worse when moving your eye?", "Yes", "No");
            }
            else
            {
                Collections.addAll(headache,"Brain Disease(SD)", "ON(PSD)", "ON(PU1)", "ON(Acute)", "HCD(Routine)", "ETTH(Advise)",
                 "Migraine(Routine)", "Migraine(Advise)");
                panel.setQuestionOption("Is eye pain worse when moving your eye?", "Yes", "No");
            }
        }
        else if(question.equals("Is eye pain worse when moving your eye?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(headache, "ON(PSD)", "ON(PU1)", "ON(Acute)");
                panel.setQuestionOption("Are the headaches worse when lying down?", "Yes", "No");
            }
            else
            {
                Collections.addAll(headache, "Brain Disease(SD)", "HCD(Routine)", "ETTH(Advise)", "Migraine(Routine)", "Migraine(Advise)");
                panel.setQuestionOption("Are the headaches worse when lying down?", "Yes", "No");
            }
        }
        else if(question.equals("Are the headaches worse when lying down?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(headache, "Brain Disease(SD)");
                panel.setQuestionOption("Do the headaches come with aura?", "Yes", "No");
            }
            else
            {
                Collections.addAll(headache, "ON(PSD)", "ON(PU1)", "ON(Acute)", "HCD(Routine)", "ETTH(Advise)", "Migraine(Routine)",
                 "Migraine(Advise)");
                panel.setQuestionOption("Do the headaches come with aura?", "Yes", "No");
            }
        }
        else if(question.equals("Do the headaches come with aura?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(headache, "Migraine(Routine)", "Migraine(Advise)");
                panel.setQuestionOption("Do you have any of the following: vertigo, limb weakness or numbness?", "Yes", "No");
            }
            else
            {
                Collections.addAll(headache, "Brain Disease(SD)", "ON(PSD)", "ON(PU1)", "ON(Acute)", "HCD(Routine)", "ETTH(Advise)");
                panel.setQuestionOption("Do you have any of the following: vertigo, limb weakness or numbness?", "Yes", "No");
            }
        }
        else if(question.equals("Do you have any of the following: vertigo, limb weakness or numbness?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(headache, "Brain Disease(SD)");
            }
            else
            {
                Collections.addAll(headache, "ON(PSD)", "ON(PU1)", "ON(Acute)", "HCD(Routine)", "ETTH(Advise)", "Migraine(Routine)",
                 "Migraine(Advise)");
            }
            this.analyze();
        }
    }
    private void analyze()
    {
        //Writing Date to File
        FileHandling.writeFile(this.getDate());
        //Writing Disease Name to File
        FileHandling.writeFile("Disease: Headache");
        //Converting ArrayList to Set: All entries will be unique
        Set<String> st = new HashSet<String>(headache);
        //Creating 2-D String array for holding Data
        String[][] data=new String[st.size()][2];
        
        //Creating Columns Heading Array of type String
        String[] columnNames={"Name", "Percentage"};

        int counter=0;
        for (String s : st)
        {
            //Writing Data to data array
            double frequency=Collections.frequency(headache, s);
            data[counter][0]=s;
            data[counter][1]=String.format("%.2f",((frequency/headache.size())*100))+"%";
            
            //Writing to File
            FileHandling.writeFile(s + ": " + String.format("%.2f",((frequency/headache.size())*100))+"%");
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
