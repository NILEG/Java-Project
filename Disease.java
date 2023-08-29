/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project;

import javax.swing.JPanel;

/**
 *
 * @author Umair
 */
public class Disease {
    private String disease_name;
    private String question, option;
    private Panel2 panel;
    private Disease disease;
    private JPanel Interface;
    private Panel3 panel3;
    public void setName(String name)
    {
        disease_name=name;
        if(name=="Headache")
        {
            disease=(Disease)new D1(panel, this.Interface, this.panel3);
        }
        else if(name=="Flashes")
        {
            disease=(Disease) new D2(panel, this.Interface, this.panel3);
        }
        else if(name=="Anisocoria")
        {
            disease=(Disease) new D3(panel, this.Interface, this.panel3);
        }
        else if(name=="More...")
        {
            disease=(Disease) new D4(panel, this.Interface, this.panel3);
        }
    }
    public String getName()
    {
        return disease_name;
    }
    public void setInfo(String question, String option)
    {
        this.question=question;
        this.option=option;
        disease.calculation(question, option);
        System.out.println(question);
    }
    public void setPanel(Panel2 panel, JPanel Interface, Panel3 panel3)
    {
        this.panel=panel;
        this.Interface=Interface;    
        this.panel3=panel3;
    }
    public void calculation(String question, String option)
    {
        
    }
}
