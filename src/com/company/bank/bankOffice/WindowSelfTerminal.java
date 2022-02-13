package com.company.bank.bankOffice;

import com.company.Client;

import com.company.bank.mobilBank.chatBot.SimpleBot;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Pattern;

public class WindowSelfTerminal extends JFrame implements ActionListener {

    final String TITLE_OF_PROGRAM = "Кредитный отдел";
    final int START_LOCAL = 100;
    final int WINDOW_WIDTH = 320;
    final int WINDOW_HEIGHT = 320;
    final String BTH_ENTER = "Enter";

    JPanel panel;
    JPanel panel2;
    JTextField message;
    JLabel id;
    JLabel dep;
    SimpleBot simpleBot;
    SimpleAttributeSet botStyle;
    Pattern pattern;
    Date date;

    Client client;
    Checkbox checkbox;

    BankOffice bankOffice;
    String workText = "";



    public String getWorkText() {
        return workText;
    }

    public void setWorkText(String workText) {
        this.workText = workText;
    }

    public WindowSelfTerminal(BankOffice bankOffice) {

        this.bankOffice = bankOffice;
        JPanel all = new JPanel();
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCAL, START_LOCAL, WINDOW_WIDTH, WINDOW_HEIGHT);

        JPanel botPanel = new JPanel();
        panel = new JPanel();
        panel2 = new JPanel();
        checkbox = new Checkbox();

        botStyle = new SimpleAttributeSet();

        id = new JLabel("ID client:");
        dep = new JLabel("Department");
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        message = new JTextField();
        message.addActionListener(WindowSelfTerminal.this);


        JButton enter = new JButton(BTH_ENTER);
        JButton close = new JButton("Exit");

        enter.addActionListener(WindowSelfTerminal.this);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
        panel2.add(dep);
        panel2.add(checkbox);
        panel.add(id);
        panel.add(message);
        botPanel.add(enter);
        botPanel.add(close);
        all.add(panel);
        all.add(panel2);
        all.add(botPanel);
        all.setLayout(new ViewportLayout());


        setVisible(true);
        simpleBot = new SimpleBot();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
