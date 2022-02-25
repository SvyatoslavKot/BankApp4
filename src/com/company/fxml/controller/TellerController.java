package com.company.fxml.controller;

import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TellerController implements Initializable {
    BankOffice bankOffice = MainFxml.getBankOffice();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void btnPutMoney(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scence/putMoneyTeller.fxml"));
            stage.setTitle("Teller");
            stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setMinHeight(449);
            stage.setMinWidth(244);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void btnGetMoney(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scence/getMoneyTeller.fxml"));
            stage.setTitle("Teller");
            stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setMinHeight(449);
            stage.setMinWidth(244);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnCancel(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../scence/Scence.fxml"));
        stage.setTitle("Main");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setMinHeight(550);
        stage.setMinWidth(518);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
