/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oop_project;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Umair
 */
public class FileHandling {
    
    public static void writeFile(String s)
    {
        //Creating File
        File file=new File("history.txt");
       
       try
       {
       //Creating File Writer
       FileWriter filewriter=new FileWriter(file, true);
       
       //Writing 
       filewriter.write(s+"\n");
       
       //Closing
       filewriter.close();
       }
       catch(IOException e)
       {
           System.out.println("Failed: Error while opening File");
       }
    }
    
    public static void readFile(Panel4 historyPanel)
    {
        historyPanel.historyPlaceholder.setText("<html>");
        try
        {
            File file=new File("history.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine())
            {
                String data = reader.nextLine();
                if(data.matches("^\\d\\d/\\d\\d/\\d\\d\\d\\d \\d\\d:\\d\\d:\\d\\d"))
                {
                    String[] dateTime=data.split(" ");
                    historyPanel.historyPlaceholder.setText(historyPanel.historyPlaceholder.getText()+"<font size='4' color='#fe5371'>Date: "+dateTime[0]+"<br>Time: "+dateTime[1]+"</font>"+"<br>");
                }
                else if(data.matches("Disease: (.*)"))
                {
                    historyPanel.historyPlaceholder.setText(historyPanel.historyPlaceholder.getText()+"<font size='4' color='#fe5371'>"+data+"</font>"+"<br>");
                }
                else
                    historyPanel.historyPlaceholder.setText(historyPanel.historyPlaceholder.getText()+data+"<br>");
            }
            reader.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "No history is available", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        historyPanel.historyPlaceholder.setText(historyPanel.historyPlaceholder.getText()+"</html>");
        
    }
}
