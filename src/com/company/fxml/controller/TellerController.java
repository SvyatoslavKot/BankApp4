package com.company.fxml.controller;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void btnPutMoney(ActionEvent event){
        try{
            windowStage(event, "putMoneyTeller.fxml", 449, 244);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void btnGetMoney(ActionEvent event){
        try{
            windowStage(event, "getMoneyTeller.fxml", 449, 244);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnCancel(ActionEvent event) throws IOException {
        windowStage(event, "Scence.fxml", 560, 570);
    }

    private void windowStage(ActionEvent event, String fxml, int height, int width) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../scence/" + fxml));
        stage.setTitle("Main");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setMinHeight(height);
        stage.setMinWidth(width);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
