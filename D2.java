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
public class D2 extends Disease{
    private ArrayList<String> flashes = new ArrayList<String>();
    Panel2 panel;
    Panel3 panel3;
    JPanel Interface;
    public D2(Panel2 panel, JPanel Interface, Panel3 panel3)
    {
        System.out.println("D2 activated");
        panel.setQuestionOption("Are the flashes unilateral or bilateral?", "Unilateral", "Bilateral");
        this.panel=panel;
        this.Interface=Interface;
        this.panel3=panel3;
    }
    public void calculation(String question, String option)
    {
        if(question.equals("Are the flashes unilateral or bilateral?"))
        {
            if(option.equals("Unilateral"))
            {
                Collections.addAll(flashes, "pvd", "tear", "detach", "migraine");
                panel.setQuestionOption("Did these flashes come on suddenly or gradually?", "Suddenly", "Gradually");
            }
            else
            {
                Collections.addAll(flashes, "pvd","tear", "detach");
                panel.setQuestionOption("Did these flashes come on suddenly or gradually?", "Suddenly", "Gradually");
            }
        }
        else if(question.equals("Did these flashes come on suddenly or gradually?"))
        {
            if(option.equals("Suddenly"))
            {
                Collections.addAll(flashes, "pvd", "tear", "detach");
                panel.setQuestionOption("Do the flashes occur in seconds,or up to an hour?", "Seconds", "Hour");
            }
            else
            {
                Collections.addAll(flashes, "pvd", "tear", "detach", "migraine", "tia", "braindis");
                panel.setQuestionOption("Do the flashes occur in seconds,or up to an hour?", "Seconds", "Hour");
            }
        }
        else if(question.equals("Do the flashes occur in seconds,or up to an hour?"))
        {
            if(option.equals("Seconds"))
            {
                Collections.addAll(flashes, "tia"," braindis ");
                panel.setQuestionOption("Are the flashes recurrent?", "Yes", "No");
            }
            else
            {
                Collections.addAll(flashes, "pvd", "tear", "detach", "tia");
                panel.setQuestionOption("Are the flashes recurrent?", "Yes", "No");
            }
        }
        else if(question.equals("Are the flashes recurrent?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(flashes, "migraine", "braindis");
                panel.setQuestionOption("Is floaters present?", "Yes", "No");
            }
            else
            {
                Collections.addAll(flashes, "pvd", "tear", "detach", "tia");
                panel.setQuestionOption("Is floaters present?", "Yes", "No");
            }
        }
        else if(question.equals("Is floaters present?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(flashes, "pvd", "tear", "detach");
                panel.setQuestionOption("Flashes/flickers lights?", "Yes", "No");
            }
            else
            {
                Collections.addAll(flashes, "migraine", "tia", "braindis");
                panel.setQuestionOption("Flashes/flickers lights?", "Yes", "No");
            }
        }
        else if(question.equals("Flashes/flickers lights?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(flashes, "pvd", "tear", "detach");
                panel.setQuestionOption("zig zag / sparkling lights?", "Yes", "No");
            }
            else
            {
                Collections.addAll(flashes, "migraine", "tia", "braindis");
                panel.setQuestionOption("zig zag / sparkling lights?", "Yes", "No");
            }
        }
        else if(question.equals("zig zag / sparkling lights?"))
        {
            if(option.equals("Yes"))
            {
                Collections.addAll(flashes, "migraine", "tia", "braindis");
                panel.setQuestionOption("Do you have vertigo, limb weakness?", "Yes", "No");
            }
            else
            {
                Collections.addAll(flashes, "pvd", "tear)", "detach)");
                panel.setQuestionOption("Do you have vertigo, limb weakness?", "Yes", "No");
            }
        }
        else if (question.equals("Do you have vertigo, limb weakness?")) 
        {
            if (option.equals("Yes"))
            {
                Collections.addAll(flashes, "tia", "braindis");
                panel.setQuestionOption("Are you high myope: greater than -3.00D?",  "Yes", "No");
            } else {
                Collections.addAll(flashes, "pvd", "tear", "detach");
                panel.setQuestionOption("Are you high myope: greater than -3.00D?",  "Yes", "No");
            }
        } 
        else if (question.equals("Are you high myope: greater than -3.00D?"))
        {
            if (option.equals("Yes"))
            {
                Collections.addAll(flashes, "tear", "detach");
                panel.setQuestionOption("any prev surgery?", "Yes", "No");
            } else {
                Collections.addAll(flashes, "pvd", "migraine", "tia", "braindis");
                panel.setQuestionOption("any prev surgery?", "Yes", "No");
            }
        } else if (question.equals("any prev surgery?"))
        {
            if (option.equals("Yes")) {
                Collections.addAll(flashes, "tear", "detach");
            } else {
                Collections.addAll(flashes, "pvd", "migraine", "tia", "braindis");
            }
        this.analyze();
        }
    }
    private void analyze()
    {
        //Writing Date to File
        FileHandling.writeFile(this.getDate());
        //Writing Disease Name to File
        FileHandling.writeFile("Disease: Flashes");
        Set<String> st = new HashSet<String>(flashes);
        //Creating 2-D String array for holding Data
        String[][] data=new String[st.size()][2];

        //Creating Columns Heading Array of type String
        String[] columnNames={"Name", "Percentage"};

        int counter=0;
        for (String s : st)
        {
            //Writing Data to data array
            double frequency=Collections.frequency(flashes, s);
            data[counter][0]=s;
            data[counter][1]=String.format("%.2f",((frequency/flashes.size())*100))+"%";

            //Writing to File
            FileHandling.writeFile(s + ": " + String.format("%.2f",((frequency/flashes.size())*100))+"%");
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
