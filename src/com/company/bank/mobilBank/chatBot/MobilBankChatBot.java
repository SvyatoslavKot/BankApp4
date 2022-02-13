package com.company.bank.mobilBank.chatBot;

import com.company.bank.bankOffice.creditDepartment.chatBotService.CreditAccountBot;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

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
    Pattern pattern;
    Date date;

    String workText = "";
    CreditAccountBot creditAccountBot = new CreditAccountBot();


    public String getWorkText() {
        return workText;
    }

    public void setWorkText(String workText) {
        this.workText = workText;
    }

    public  MobilBankChatBot(){
                setTitle(TITLE_OF_PROGRAM);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setBounds(START_LOCAL,START_LOCAL,WINDOW_WIDTH,WINDOW_HEIGHT);

                JPanel botPanel = new JPanel();

                dialogue = new JTextPane();
                dialogue.setEditable(false);
                dialogue.setContentType("text/html");
                JScrollPane scrollBar =new JScrollPane(dialogue);
                botStyle = new SimpleAttributeSet();
                StyleConstants.setItalic(botStyle, true);
                StyleConstants.setForeground(botStyle, Color.blue);
                botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.X_AXIS));

                dialogue.setText("Здравсвуйте чем могу вам помочь?\n");

                message = new JTextField();
                message.addActionListener(MobilBankChatBot.this);
                JButton enter = new JButton(BTH_ENTER);

                enter.addActionListener(MobilBankChatBot.this);
                botPanel.add(message);
                botPanel.add(enter);
                add(BorderLayout.CENTER, scrollBar);
                add(BorderLayout.SOUTH, botPanel);

                setVisible(true);
                simpleBot = new SimpleBot();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (message.getText().trim().length()> 0 ){
            try{
                StyledDocument doc = dialogue.getStyledDocument();
                doc.insertString(doc.getLength(), "\n" +message.getText()+ "\n",
                        new SimpleAttributeSet());
                doc.insertString(doc.getLength(),
                        TITLE_OF_PROGRAM.substring(0,7)+
                                sayInReturn(message.getText()), botStyle);
            }catch (Exception event) {
                event.printStackTrace();
            }
        }
        message.setText("");
        message.requestFocusInWindow();
    }


    public  String sayInReturn(String messsage){
      String  message =
                String.join(" ", messsage.toLowerCase().split("[ {,|.}?]+"));
      message = message + workText;
        for (Map.Entry<String,String>o : simpleBot.getPATTERNS_FOR_ANALYSIS().entrySet()){
            pattern = Pattern.compile(o.getKey());
            if(pattern.matcher(message).find())
                if(o.getValue().equals("whattime"))return date.toString();

                else if (o.getValue().equals("credit")){
                    setWorkText("credittype");
                    return "Введите тип кредита \n"+
                            "Потребительский - 1\n"+
                            "Автокредит - 2\n"+
                            "Иппотека - 3\n"+
                            "Кредитная карта - 4";}
                else if  (o.getValue().equals("credittype")){
                    creditAccountBot.setCreditType(messsage);
                    setWorkText("creditsum");
                    return "Введите сумму";}
                else if (o.getValue().equals("creditsum")){
                    creditAccountBot.setSum(Integer.parseInt(messsage));
                    setWorkText("");
                    return creditAccountBot.openCredit()
                            + "\nЧто-нибудь еще?";}
                else  return simpleBot.getANSWERS_BY_PATTERNS().get(o.getValue());
        }return "Повторите ваш запрос";
    }
}