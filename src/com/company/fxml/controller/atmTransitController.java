package com.company.fxml.controller;

import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.BankService.BankCollectionManage;
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

public class atmTransitController {
    BankOffice bankOffice = MainFxml.getBankOffice();
    BankCollectionManage bankCollectionManage = new BankCollectionManage();
    AccountMoney accountMoneySender = bankOffice.getAtm().getAccountMoneyUser();
    public NumberTextField textFieldSum;
    public NumberTextField textFieldNum;

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

    public void btnSend(ActionEvent actionEvent) throws IOException{
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (!textFieldNum.getText().isEmpty() && !textFieldSum.getText().isEmpty()) {
            AccountMoney accountMoneyAdress = bankCollectionManage.searchAccountFromNumber(bankOffice, textFieldNum.getText());
            if (accountMoneyAdress != null) {
                bankOffice.getAtm().setAccountMoneyAdress(accountMoneyAdress);
                try {
                    try{
                        if (bankOffice.getAtm().moneyTransfer(accountMoneySender, accountMoneyAdress, Integer.valueOf(textFieldSum.getText()))){

                        bankOffice.getAtm().setAccountMoneyAdress(null);
                        showAlert(alert, "?????????????? ??????????????????????");
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
                            showAlert(alert, "???????????????????????? ?????????????? ???? ??????????");
                    }
                    }catch (MoneyAccountException e) {
                            e.printStackTrace();
                        }
                }catch (NumberFormatException e) {
                    showAlert(alert, "???????????????????????? ??????????");
                }
            }
            else{
                showAlert(alert, "?????????????? ?? ???????????? ?????????????? ???? ????????????????????.");
                }
            } else {
                showAlert(alert, "?????????????????? ?????????? ");
            }
        }



    private void showAlert(Alert alert, String msg) {
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("??????????????????");
        alert.setHeaderText(msg);
        alert.show();
    }
}
