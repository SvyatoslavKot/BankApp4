package com.company.fxml.controller.atm;

import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.BankService.BankCollectionManage;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class atmTransitController {
    BankOffice bankOffice = MainFxml.getBankOffice();
    BankCollectionManage bankCollectionManage = new BankCollectionManage();
    AccountMoney accountMoneySender = bankOffice.getAtm().getAccountMoneyUser();

    public TextField textFieldSum;
    public TextField textFieldNum;

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

    public void btnSend(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (!textFieldNum.getText().isEmpty() && !textFieldSum.getText().isEmpty()){
           AccountMoney accountMoneyAdress  =  bankCollectionManage.searchAccountFromNumber(bankOffice, textFieldNum.getText());
           if (accountMoneyAdress != null){
               bankOffice.getAtm().setAccountMoneyAdress(accountMoneyAdress);
               try {
               bankOffice.getAtm().moneyTransfer(accountMoneySender, accountMoneyAdress, Integer.valueOf(textFieldSum.getText()));
               showAlert(alert , "Перевод осуществлен");
               Stage stage = new Stage();
               Parent root = FXMLLoader.load(getClass().getResource("../scence/AtmMain.fxml"));
               stage.setTitle("Main");
               stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
               stage.setMinHeight(550);
               stage.setMinWidth(518);
               stage.setResizable(false);
               stage.setScene(new Scene(root));
               stage.show();
               }catch (NumberFormatException e) {
                   showAlert(alert, "Некорректная сумма");
               }
           }else {
               showAlert(alert, "клиента с данным номером не существует.");
           }
        }else {
            showAlert(alert, "Заполните форму ");
        }

    }

    private void showAlert(Alert alert, String msg) {
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Сообщение");
        alert.setHeaderText(msg);
        alert.show();
    }
}
