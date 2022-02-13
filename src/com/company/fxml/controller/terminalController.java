package com.company.fxml.controller;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.MainFxml;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class terminalController implements Initializable {

    public javafx.scene.control.Button btnTakeTicket;
    Client client;
    String id;
    String dep;
    BankOffice bankOffice = MainFxml.getBankOffice();

    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField textField;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().setAll(
                "Кредитный", "Страхование", "Управление счетами"
        );
        comboBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {

        });

    }


    @FXML
    public void clickButton(ActionEvent actionEvent)throws IOException {
            id  = textField.getText();
            if (id!=null){
                if (dep!=null){
                    if (dep.equals("Кредитный")){
                        bankOffice.getTerminal1().getTicketToCredit(id,bankOffice);
                    }else if (dep.equals("Страхование")){
                        bankOffice.getTerminal1().getTicketToInsurance(id,bankOffice);
                    }else if (dep.equals("Управление счетами")){
                        bankOffice.getTerminal1().getTicketToAccount(id,bankOffice);

                    }
                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("../scence/Scence.fxml"));
                    stage.setTitle("Terminal");
                    stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                    stage.setMinHeight(300);
                    stage.setMinWidth(400);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root));
                    stage.show();
                }else {
                    System.out.println("Выберите услугу");
                }
            }else {
                System.out.println("Укажите id");
            }

    }

        @FXML
        public void ComboBoxCganged(ActionEvent actionEvent){
            String selectedValue = comboBox.getSelectionModel().getSelectedItem();
            String a = selectedValue;
            setDep(a);
            System.out.println(dep);
        }

        @FXML
        public void btnAddClient(){

        }

    public void setDep(String dep) {
        this.dep = dep;
    }
}
