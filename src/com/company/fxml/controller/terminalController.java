package com.company.fxml.controller;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.MainFxml;
import com.company.fxml.NumberTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.company.fxml.NumberTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class terminalController implements Initializable , Runnable{
    public javafx.scene.control.Button btnTakeTicket;
    Client client;
    String id;
    String dep;
    BankOffice bankOffice = MainFxml.getBankOffice();
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private NumberTextField textField;
    @FXML
    private Text textWar;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().setAll(
                "Кредитный", "Страхование", "Управление счетами"
        );
        comboBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
        });
    }
    @FXML
    public void clickButton(ActionEvent actionEvent) {
        Thread thread = new Thread(this);
        id  = textField.getText();
        if (id != null) {
            client = bankOffice.getBankCollections().getClientHashMap().get(id);
            if (client!=null){
                if (dep!=null){
        thread.start();
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../scence/Scence.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Terminal");
        stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setMinHeight(300);
        stage.setMinWidth(400);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
                }else {
                    textWar.setText("Выберите услугу");
                }
            }else {
                textWar.setText("Клиента с Id <" + id + "> нет, вы можете создать клиента.");
            }
        }else {
            textWar.setText("Укажите верный Id");
        }
    }
    @Override
    public void run() {
        if (dep.equals("Кредитный")){
            bankOffice.getTerminal1().getTicketToCredit(id,bankOffice);
        }else if (dep.equals("Страхование")){
            bankOffice.getTerminal1().getTicketToInsurance(id,bankOffice);
        }else if (dep.equals("Управление счетами")){
            bankOffice.getTerminal1().getTicketToAccount(id,bankOffice);
        }
    }
        @FXML
        public void ComboBoxCganged(){
            String selectedValue = comboBox.getSelectionModel().getSelectedItem();
            String a = selectedValue;
            setDep(a);
            System.out.println(dep);
        }

        @FXML
        public void btnAddClient(ActionEvent actionEvent) throws IOException {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scence/addClientForm.fxml"));
            stage.setTitle("Terminal");
            stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setMinHeight(449);
            stage.setMinWidth(244);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        }
    public void btnCancel (ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../scence/Scence.fxml"));
        stage.setTitle("Main");
        stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setMinHeight(550);
        stage.setMinWidth(518);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void setDep(String dep) {
        this.dep = dep;
    }

}
