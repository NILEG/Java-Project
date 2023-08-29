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
public class Frame extends JFrame{
    private CardLayout layout;
    private JPanel Interface;
    public Frame(Disease diseases)
    {
        //---------Creating Objects----------
        this.layout=new CardLayout();
        this.Interface=new JPanel();
        //-----------------------------------
        
        this.Interface.setLayout(this.layout);
        this.setSize(600, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //----------Adding Panels To Frame---------
        Panel4 panel4=new Panel4(this.Interface);
        Panel3 panel3=new Panel3(this.Interface);
        Panel2 panel2=new Panel2(this.Interface, diseases, panel3);
        Panel1 panel1=new Panel1(this.Interface, panel2, panel4);
        
        
        this.Interface.add(panel1, "Panel1");
        this.Interface.add(panel2, "Panel2");
        this.Interface.add(panel3, "Panel3");
        this.Interface.add(panel4, "Panel4");
        //------------------------------------------
        
        ((CardLayout) this.Interface.getLayout()).show(this.Interface, "Panel1");
        this.add(Interface);
        this.setVisible(true);
        
    }
}
