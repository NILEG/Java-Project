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
public class Button_Style_1 extends JButton{
    
    public Button_Style_1()
    {
        this.setBackground(Styles.primaryBg);
        this.setForeground(Styles.primaryFg);
        this.setOpaque(true);
        this.setFont(new Font("Roboto", Font.PLAIN, 25));
    }
}
