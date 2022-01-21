package com.company.mobilBank.chatBot;

import com.company.Client;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MobilBankChatBot extends JFrame implements ActionListener {
    final String TITLE_OF_PROGRAM = "Борис: simple chatbot";
    final int START_LOCAL = 220;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;
    final String BTH_ENTER = "Enter";

    JTextPane dialogue;
    JTextField message;
    SimpleBot simpleBot;
    SimpleAttributeSet botStyle;


    public  MobilBankChatBot(Client client){
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCAL,START_LOCAL,WINDOW_WIDTH,WINDOW_HEIGHT);

        dialogue = new JTextPane();
        dialogue.setEditable(false);
        dialogue.setContentType("text/html");
        JScrollPane scrollBar =new JScrollPane(dialogue);

        botStyle = new SimpleAttributeSet();
        StyleConstants.setItalic(botStyle, true);
        StyleConstants.setForeground(botStyle, Color.blue);

        JPanel botPanel = new JPanel();
        botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.X_AXIS));
        message = new JTextField();
        message.addActionListener(this);
        JButton enter = new JButton(BTH_ENTER);
        enter.addActionListener(this);

        botPanel.add(message);
        botPanel.add(enter);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, botPanel);
        setVisible(true);

        simpleBot = new SimpleBot(client);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (message.getText().trim().length()> 0 ){
            try{
                StyledDocument doc = dialogue.getStyledDocument();
                doc.insertString(doc.getLength(), message.getText()+ "\n",
                        new SimpleAttributeSet());
                doc.insertString(doc.getLength(),
                        TITLE_OF_PROGRAM.substring(0,7)+
                                simpleBot.sayInReturn(message.getText()), botStyle);
            }catch (Exception event) {
                event.printStackTrace();
            }
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}