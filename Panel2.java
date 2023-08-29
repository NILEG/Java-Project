/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Umair
 */
public class Panel2 extends JPanel{
    
    
    private JPanel Interface;
    private JLabel title;
    private JLabel question;
    private JButton opt1, opt2;
    private Disease diseases;
    public Panel2(JPanel Interface, Disease diseases, Panel3 panel3)
    {
        
        this.Interface=Interface;
        this.diseases=diseases;
        this.diseases.setPanel(this, Interface, panel3);
        
        //--------Setup-----------
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        //------------------------
        
        
        //---------Header------------
        JPanel header=new JPanel();
        header.setLayout(new GridLayout());
        header.setPreferredSize(new Dimension(1,80));


        title=new JLabel("Disease Name");
        title.setHorizontalAlignment(JTextField.CENTER);
        title.setFont(new Font("Roboto", Font.BOLD, 30));
        title.setBackground(Styles.secondaryBg);
        title.setForeground(Styles.secondaryFg);
        title.setOpaque(true);

        header.add(title);
        
        //--------------------------
        
        
        //---------Main Body---------
        GridLayout layout1=new GridLayout();
        GridLayout layout2=new GridLayout();
        layout2.setVgap(20);
        
        JPanel mainGridLayoutPanel =new JPanel(layout1);
        JPanel optionGridLayoutPanel=new JPanel(layout2);
        
        mainGridLayoutPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
        optionGridLayoutPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 60, 0));
        
        layout1.setRows(2);
        layout1.setColumns(1);
        
        layout2.setRows(2);
        layout2.setColumns(1);
        
        mainGridLayoutPanel.setLayout(layout1);
        optionGridLayoutPanel.setLayout(layout2);
        
        
        question=new JLabel("<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad  minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex</html>");
        question.setHorizontalAlignment(JTextField.CENTER);
        
        opt1=new JButton("Choice 1");
        opt1.addActionListener(e -> evaluate(opt1.getText()));
        opt1.setBackground(Styles.primaryBg);
        opt1.setForeground(Styles.primaryFg);
        opt1.setOpaque(true);
        opt1.setFont(new Font("Roboto", Font.PLAIN, 25));
        
        opt2=new JButton("Choice 2");
        opt2.addActionListener(e -> evaluate(opt2.getText()));
        opt2.setBackground(Styles.primaryBg);
        opt2.setForeground(Styles.primaryFg);
        opt2.setOpaque(true);
        opt2.setFont(new Font("Roboto", Font.PLAIN, 25));

        mainGridLayoutPanel.add(question);
        mainGridLayoutPanel.add(optionGridLayoutPanel);
        
        optionGridLayoutPanel.add(opt1);
        optionGridLayoutPanel.add(opt2);
        //--------------------------
        
        
        //--------Footer-----------
        JPanel footer=new JPanel(new GridLayout());
        footer.setPreferredSize(new Dimension(1,50));
        //------------------------
        
        
        //------Adding Components to Main Layout---------
        this.add(header, BorderLayout.NORTH);
        this.add(mainGridLayoutPanel, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        //----------------------------------------
    }
    public void evaluate(String option)
    {
        String question=this.question.getText().split(">")[1].split("<")[0];
        this.diseases.setInfo(question, option);
    }
    public void setQuestionOption(String questionToDisplay, String option1, String option2)
    {
        this.question.setText("<html>"+questionToDisplay+"</html>");
        this.question.setFont(new Font("Roboto",  Font.PLAIN, 18));
        this.question.setForeground(Styles.secondaryBg);
        this.opt1.setText(option1);
        this.opt2.setText(option2);
    }
    public void setDisease(String name)
    {
        title.setText(name);
        this.diseases.setName(name);
    }
}
