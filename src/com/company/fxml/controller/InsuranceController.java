package com.company.fxml.controller;

import com.company.Client;
import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.creditDepartment.Credit;
import com.company.bank.bankOffice.creditDepartment.CreditController;
import com.company.bank.bankOffice.insuranceDepartment.Insurance;
import com.company.bank.bankOffice.insuranceDepartment.InsuranceOpen;
import com.company.service.ClientService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InsuranceController implements Initializable {
    BankOffice bankOffice = MainFxml.bankOffice;
    Client client;
    InsuranceOpen insuranceOpen = new InsuranceOpen();
    String combo;
    Insurance insurance;
    ClientService clientService= new ClientService();

    @FXML
    ComboBox comboBoxType;

    @FXML
    TextArea textAreaStart;

    @FXML
    TextArea areaResult;

    @FXML
    TextField textFieldTerm;

    @FXML
    TextField textFieldSum;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setClient(bankOffice.getInsuranceDepartment().startWork());
        if (client!= null){
            textAreaStart.setText("Здравствуйет " + client.getName() + " заполните форму.");
        }else {
            textAreaStart.setText("Клиентов на оформление нет.");
        }

        comboBoxType.getItems().setAll(
                "Жизнь", "Имущество"
        );
        comboBoxType.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
        });
    }

    public void btnCalck(ActionEvent actionEvent) {
        if (combo!= null && textFieldSum!=null && textFieldTerm != null){
            int val = Integer.valueOf(textFieldSum.getText());
            int term = Integer.valueOf(textFieldTerm.getText());
            setInsurance(insuranceOpen.openInsurance(client,bankOffice,combo,val,term));
            if (insurance!= null){
                areaResult.setText(textResul(client,insurance));
            }else  {textAreaStart.setText(client.getName()+"для вас нет подходящих предложений");}
        }else {areaResult.setText("Заполните форму");}
    }

    public void btnSend(ActionEvent actionEvent) throws IOException {
        if (insurance!=null){
            bankOffice.getBankCollections().getInsurensList().add(insurance);
            clientService.giveCash((int)insurance.getPrice(), client);

            setClient(bankOffice.getInsuranceDepartment().startWork());
            if (client!=null){
                textFieldSum.setText("");
                textFieldTerm.setText("");
                areaResult.setText("");
                textAreaStart.setText("Здравствуйет " + client.getName() + " заполните форму.");
            }else {
                Stage stage = new Stage();
                Parent root = null;
                root = FXMLLoader.load(getClass().getResource("../scence/Scence.fxml"));
                stage.setTitle("Main");
                stage =(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                stage.setMinHeight(550);
                stage.setMinWidth(518);
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.show();
            }

        }else {

        }
    }

    public void btnCancel(ActionEvent actionEvent) throws IOException {
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

    @FXML
    void comboBoxChange(ActionEvent actionEvent) {
        String selectedValue = (String) comboBoxType.getSelectionModel().getSelectedItem();
        String a = selectedValue;
        System.out.println(a);
        setCombo(a);
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void setCombo(String combo) {
        this.combo = combo;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    private String textResul(Client client, Insurance insurance){
        return
                client.getName() + " вам подобрана страхование " + insurance.getInsuranceNumber() +
                        "\nсрок страхования: " + insurance.getTerm() + " мес." +
                        "\nдата открытия: " + insurance.getOpenDate() +
                        "\nстоимость стрхования: " + insurance.getPrice() +
                        "\nстраховая сумма: " + insurance.getInsuranceValue();
    }

}
