/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project;

import javax.swing.JPanel;
import java.awt.*;

/**
 *
 * @author Umair
 */
public class D4 extends Disease{
    JPanel Interface;
    public D4(Panel2 panel, JPanel Interface, Panel3 panel3)
    {
        this.Interface=Interface;
        System.out.println("D4 activated");
        panel.setQuestionOption("Data Not Available Online For this Disease", "Not Availabel", "Back");
    }
    public void calculation(String question, String option)
    {
        if(question.equals("Data Not Available Online For this Disease") && option.equals("Back"))
        {
            ((CardLayout) this.Interface.getLayout()).show(this.Interface, "Panel1");
        }

    }
}
