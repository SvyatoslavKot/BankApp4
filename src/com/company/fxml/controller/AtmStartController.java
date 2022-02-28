package com.company.fxml.controller;

import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.BankService.BankCollectionManage;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class AtmStartController {

    public TextField textFieldPass;

    BankOffice bankOffice = MainFxml.getBankOffice();
    BankCollectionManage bankCollectionManage = new BankCollectionManage();
    AccountMoney accountMoneyUser;

    @FXML
    Text textStar;

    @FXML
    TextField textFieldCardNum;


    public void btnNext(ActionEvent actionEvent) throws IOException {
        if (!textFieldCardNum.getText().isEmpty()) {
            accountMoneyUser  = bankCollectionManage.searchAccountFromNumber(bankOffice, textFieldCardNum.getText());
            if (accountMoneyUser!= null){
                if (!textFieldPass.getText().isEmpty()) {
                    if (accountMoneyUser.getPin().equals(textFieldPass.getText())) {
                        bankOffice.getAtm().setAccountMoneyUser(accountMoneyUser);
                        Stage stage = new Stage();
                        Parent root = load(getClass().getResource("../scence/AtmMain.fxml"));
                        stage.setTitle("Teller");
                        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        stage.setMinHeight(449);
                        stage.setMinWidth(244);
                        stage.setResizable(false);
                        stage.setScene(new Scene(root));
                        stage.show();
                    }
                }
            }

            }

        }

        public void btnCancel (ActionEvent actionEvent) throws IOException {
            Stage stage = new Stage();
            Parent root = load(getClass().getResource("../scence/Scence.fxml"));
            stage.setTitle("Main");
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setMinHeight(550);
            stage.setMinWidth(518);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        }

}


