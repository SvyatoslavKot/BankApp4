package com.company.fxml.controller;

import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class atmMainMenu {
  BankOffice bankOffice = MainFxml.getBankOffice();

    public void btnTransit(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../scence/transitAtmForm.fxml"));
        stage.setTitle("Teller");
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setMinHeight(449);
        stage.setMinWidth(244);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void btnWithdrawMoney(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../scence/atmWithdrawMoney.fxml"));
        stage.setTitle("Teller");
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setMinHeight(449);
        stage.setMinWidth(244);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void btnPutMoney(ActionEvent actionEvent) throws IOException {

    }

    public void btnPayCredit(ActionEvent actionEvent) {
    }

    public void btnInfo(ActionEvent actionEvent) {
    }

    public void btnBalance(ActionEvent actionEvent) {
    }

    public void btnCancel (ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../scence/atmStar.fxml"));
        stage.setTitle("Main");
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setMinHeight(550);
        stage.setMinWidth(518);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }


}
