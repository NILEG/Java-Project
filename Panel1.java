/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Umair
 */
public class Panel1 extends JPanel {
    
    private JPanel Interface;
    private Panel2 panel2;
    private Panel4 panel4;
    
    public Panel1(JPanel Interface, Panel2 panel2, Panel4 panel4)
    {
        this.Interface=Interface;
        this.panel2=panel2;
        this.panel4=panel4;
        
        //------------Main Panel-------------
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        //--------------------------------
        
        
        //------------Header---------
        JPanel header=new JPanel();
        header.setLayout(new GridLayout());
        header.setPreferredSize(new Dimension(1,130));
        
        JLabel title=new JLabel("Opto-Triage");
        title.setVerticalAlignment(JLabel.BOTTOM);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Roboto", Font.BOLD, 48));
        title.setForeground(Styles.secondaryBg);
        header.add(title);
        //------------------------------------
        
        
        //--------GridLayout Panel------------

        JPanel borderLayoutPanel=new JPanel(new BorderLayout());
        borderLayoutPanel.setBorder(BorderFactory.createEmptyBorder(110,0,0,0));
        JLabel label=new JLabel("<html>Select the <b><font color='#fe5371'>Problem</font></b> you\'re currently facing!</html>");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Roboto", Font.PLAIN, 20));
        GridLayout gridLayout= new GridLayout(2,2);
        gridLayout.setHgap(20);
        gridLayout.setVgap(20);
        
        JPanel gridLayoutPanel=new JPanel();
        gridLayoutPanel.setLayout(gridLayout);
        gridLayoutPanel.setBorder(BorderFactory.createEmptyBorder(20, 60, 150, 60));

        borderLayoutPanel.add(label, BorderLayout.NORTH);
        borderLayoutPanel.add(gridLayoutPanel, BorderLayout.CENTER);
        //-------------------------------------
        

        //-------------Creating Buttons-------
        Button_Style_1 b1=new Button_Style_1();
        b1.setText("Headache");
        b1.addActionListener(e -> b1_pressed());
        Button_Style_1 b2=new Button_Style_1();
        b2.setText("Flashes");
        b2.addActionListener(e -> b2_pressed());
        Button_Style_1 b3=new Button_Style_1();
        b3.setText("Anisocoria");
        b3.addActionListener(e -> b3_pressed());
        Button_Style_1 b4=new Button_Style_1();
        b4.setText("More...");
        b4.addActionListener(e -> b4_pressed());
        
        gridLayoutPanel.add(b1);
        gridLayoutPanel.add(b2);
        gridLayoutPanel.add(b3);
        gridLayoutPanel.add(b4);
        //-----------------------------------
        
        
        //------------Footer-------------
        JPanel footer=new JPanel();
        footer.setPreferredSize(new Dimension(1,50));
        footer.setLayout(new GridLayout());

        footer.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        JButton historyBtn=new JButton();
        historyBtn.setText("History");
        historyBtn.setForeground(Styles.secondaryFg);
        historyBtn.setBackground(Styles.secondaryBg);
        historyBtn.setOpaque(true);
        historyBtn.setFont(new Font("Roboto", Font.BOLD, 20));
        historyBtn.addActionListener(e -> showHistory());
        
        footer.add(historyBtn);
        //-------------------------------
        
        
        //---------Adding Components to Main Panel-------
        this.add(header, BorderLayout.NORTH);
        this.add(borderLayoutPanel, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        //-----------------------------------------------
    }
    
    private void b1_pressed()
    {
        System.out.println("B1");
        this.panel2.setDisease("Headache");
        ((CardLayout) this.Interface.getLayout()).show(this.Interface, "Panel2");
    }
    private void b2_pressed()
    {
        System.out.println("B2");
        this.panel2.setDisease("Flashes");
        ((CardLayout) this.Interface.getLayout()).show(this.Interface, "Panel2");
    }
    private void b3_pressed()
    {
        System.out.println("B3");
        this.panel2.setDisease("Anisocoria");
        ((CardLayout) this.Interface.getLayout()).show(this.Interface, "Panel2");
    }
    private void b4_pressed()
    {
        System.out.println("B4");
        this.panel2.setDisease("More...");
        ((CardLayout) this.Interface.getLayout()).show(this.Interface, "Panel2");
    }
    private void showHistory()
    {
        ((CardLayout) this.Interface.getLayout()).show(this.Interface, "Panel4");
        FileHandling.readFile(panel4);
    }
}
