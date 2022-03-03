package com.company.fxml.controller;

import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountMoney;
import com.company.exception.MoneyAccountException;
import com.company.fxml.NumberTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class AtmWithdrawMoneyController {
    public NumberTextField textFieldSum;
    BankOffice bankOffice = MainFxml.getBankOffice();
    AccountMoney accountMoneyUser = bankOffice.getAtm().getAccountMoneyUser();

    public void btnWithdrawMoney(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        if ( !textFieldSum.getText().isEmpty()){
            try {
                if (bankOffice.getAtm().withdrawMoneyOnAccount(bankOffice,accountMoneyUser, Integer.valueOf(textFieldSum.getText()))){
                    showAlert(alert, "Операция прошла успешно");

                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("../scence/AtmMain.fxml"));
                    stage.setTitle("Main");
                    stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setMinHeight(550);
                    stage.setMinWidth(518);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root));
                    stage.show();
                }else {
                    showAlert(alert, "Ошибка");
                }
            } catch (MoneyAccountException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void btnCancel(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../scence/AtmMain.fxml"));
        stage.setTitle("Main");
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setMinHeight(550);
        stage.setMinWidth(518);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
    private void showAlert(Alert alert, String msg) {
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Сообщение");
        alert.setHeaderText(msg);
        alert.show();
    }
}
