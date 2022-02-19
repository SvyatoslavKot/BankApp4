package com.company.fxml.controller;

import com.company.Client;
import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddClientController {
    BankOffice bankOffice = MainFxml.getBankOffice();
    private String id;
    @FXML
    private Button btnCalkId;

    @FXML
    private TextField textFieldAge;

    @FXML
    private TextField textFieldCash;

    @FXML
    private TextField textFieldIncome;

    @FXML
    private TextField textFieldLastName;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldPassport;

    @FXML
    private TextField textFieldid;

    @FXML
    private TextArea texyAreaInfo;



    @FXML
    void btnCalkId(ActionEvent event) {
            int idC = bankOffice.getBankCollections().getClientHashMap().size() + 1;
            id = Integer.toString(idC);
            textFieldid.setText(id);
    }

    @FXML
    void btnCancel(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../scence/Scence.fxml"));
        stage.setTitle("Terminal");
        stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setMinHeight(300);
        stage.setMinWidth(400);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void btnSend(ActionEvent event) {
        if(textFieldAge!=null && textFieldCash!=null &&textFieldid !=null &&textFieldIncome!=null &&textFieldLastName!=null &&
                textFieldName!=null && textFieldPassport!=null){
            int income = Integer.parseInt(textFieldIncome.getText());
            int cash = Integer.parseInt(textFieldCash.getText());
            Client client= new Client(textFieldName.getText(), textFieldLastName.getText(), Integer.valueOf(textFieldAge.getText()), textFieldid.getText(),income, cash, textFieldPassport.getText());
            bankOffice.getBankCollections().getClientHashMap().put(textFieldid.getText(), client);
            texyAreaInfo.setText("Клиент" +
                    "\n" + textFieldLastName.getText() + " " + textFieldName.getText()+
                    "\nId - " + id);

            textFieldPassport.setText("");
            textFieldName.setText("");
            textFieldLastName.setText("");
            textFieldIncome.setText("");
            textFieldid.setText("");
            textFieldCash.setText("");
            textFieldAge.setText("");
        }
    }

}
