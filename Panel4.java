/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Umair
 */
public class Panel4 extends JPanel{
     JPanel Interface;
    private JLabel title;
    public JLabel historyPlaceholder;
    public Panel4(JPanel Interface)
    {
        this.Interface=Interface;
        
        //--------Setup-----------
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        //------------------------
        
        //---------Header------------
        JPanel header=new JPanel();
        header.setLayout(new GridLayout());
        header.setPreferredSize(new Dimension(1,80));
        
        title=new JLabel("History");
        title.setHorizontalAlignment(JTextField.CENTER);
        title.setFont(new Font("Roboto", Font.BOLD, 30));
        title.setBackground(Styles.secondaryBg);
        title.setForeground(Color.white);
        title.setOpaque(true);

        header.add(title);
        
        //--------------------------
        
        //-----------Main Body------
        historyPlaceholder=new JLabel("Results");
        historyPlaceholder.setHorizontalAlignment(SwingConstants.CENTER);
        JScrollPane scroller = new JScrollPane(historyPlaceholder, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //---------------------------
        
        
        //--------Footer-----------
        JPanel footer=new JPanel(new GridLayout());
        JButton backBtn=new JButton("Back");
        backBtn.addActionListener(e -> backToMenu());
        backBtn.setForeground(Color.white);
        backBtn.setBackground(Styles.secondaryBg);
        backBtn.setOpaque(true);
        backBtn.setFont(new Font("Roboto", Font.BOLD, 20));

        footer.setPreferredSize(new Dimension(1,50));
        footer.add(backBtn);
        //------------------------
        
        
        //---------Adding Components to Main Panel----------
        this.add(header, BorderLayout.NORTH);
        this.add(scroller, BorderLayout.CENTER);
        this.add(footer, BorderLayout.SOUTH);
        //--------------------------------------------
        
        
    }
    
    private void backToMenu()
    {
        ((CardLayout) this.Interface.getLayout()).show(this.Interface, "Panel1");
    }
    
    
}
