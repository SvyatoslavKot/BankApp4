package com.company.fxml.controller;

import com.company.Client;
import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import com.company.fxml.NumberTextField;
import com.company.service.ClientService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PutMoneyTellerController implements Initializable {
    BankOffice bankOffice = MainFxml.getBankOffice();
    Client client;
    int sum;
    ClientService clientService = new ClientService();

    @FXML
    NumberTextField textFieldId;

    @FXML
    NumberTextField textFieldSum;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void btnCancel(ActionEvent event) throws IOException {
        rootStage(event);
    }

    @FXML
    public void btnOkPutMoney(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.NONE);
        if (!(textFieldSum.getText().isEmpty() || textFieldId.getText().isEmpty())) {
            client = bankOffice.getBankCollections().getClientHashMap().get(textFieldId.getText());
            if (client != null) {
                try {
                    sum = Integer.parseInt(textFieldSum.getText());
                    clientService.takeCash(sum, client);
                    showAlert(alert, "Операция успешно выполнена");
                    rootStage(event);
                } catch (NumberFormatException e) {
                    showAlert(alert, "Некорректная сумма");
                }
            } else {
                showAlert(alert, "Клиент не найден");
            }
        } else {
            showAlert(alert, "Заполните все поля");
        }
    }

    private void showAlert(Alert alert, String msg) {
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Сообщение");
        alert.setHeaderText(msg);
        alert.show();
    }

    private void rootStage(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../scence/TellerStart.fxml"));
        stage.setTitle("Main");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setMinHeight(449);
        stage.setMinWidth(244);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
