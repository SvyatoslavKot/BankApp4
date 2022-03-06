package com.company.fxml.controller;

import com.company.Client;
import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.bankFactory.AbstractFactory;
import com.company.bank.bankOffice.bankFactory.BankProductFactory;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory.Insurance;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory.InsuranceFactory;
import com.company.fxml.NumberTextField;
import com.company.service.ClientService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InsuranceController implements Initializable {
    BankOffice bankOffice = MainFxml.bankOffice;
    Client client;

    BankProductFactory insuraceF = new AbstractFactory().createFactory("Insurence");

    String combo;
    Insurance insurance;
    ClientService clientService = new ClientService();

    @FXML
    ComboBox comboBoxType;

    @FXML
    TextArea textAreaStart;

    @FXML
    TextArea areaResult;

    @FXML
    NumberTextField textFieldTerm;

    @FXML
    NumberTextField textFieldSum;

    @FXML
    Button btn_Send;

    @FXML
    Button btn_Calc;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_Calc.setDisable(true);
        btn_Send.setDisable(true);
        setClient(bankOffice.getInsuranceDepartment().startWork());
        if (client != null) {
            btn_Calc.setDisable(false);
            textAreaStart.setText("Здравствуйте, " + client.getName() + ". Заполните форму.");
        } else {
            textAreaStart.setText("Клиентов на оформление нет.");
        }

        comboBoxType.getItems().setAll(
                "Жизнь", "Имущество"
        );
        comboBoxType.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
        });
    }

    public void btnCalck(ActionEvent actionEvent) {
        if (!textFieldSum.getText().isEmpty() && !textFieldTerm.getText().isEmpty()) {
            if (combo == null) {
                areaResult.setText("Выберите тип страховки");
            } else {
                setInsurance(insuraceF.create(client, bankOffice,
                        combo,Integer.valueOf(textFieldSum.getText()), Integer.valueOf(textFieldTerm.getText())));
                if (insurance != null) {
                    btn_Send.setDisable(false);
                    areaResult.setText(textResult(client, insurance));
                } else {
                    btn_Send.setDisable(true);
                    textAreaStart.setText(client.getName() + ", для вас нет подходящих предложений");
                }
            }
        } else {
            btn_Send.setDisable(true);
            areaResult.setText("Заполните форму");
        }
    }

    public void btnSend(ActionEvent actionEvent) throws IOException {
        bankOffice.getBankCollections().getInsurensList().add(insurance);
        clientService.giveCash((int) insurance.getPrice(), client);

        setClient(bankOffice.getInsuranceDepartment().startWork());
        if (client != null) {
            textFieldSum.setText("");
            textFieldTerm.setText("");
            areaResult.setText("");
            textAreaStart.setText("Здравствуйте, " + client.getName() + ". Заполните форму.");
        } else {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("../scence/Scence.fxml"));
            stage.setTitle("Main");
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setMinHeight(640);
            stage.setMinWidth(518);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
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
    private String textResult(Client client, Insurance insurance){
        return
                client.getName() + " вам подобрана страхование " + insurance.getNameInsurance() +
                        "\nсрок страхования: " + insurance.getTerm() + " мес." +
                        "\nдата открытия: " + insurance.getOpenDate() +
                        "\nстоимость стрхования: " + insurance.getPrice() +
                        "\nстраховая сумма: " + insurance.getInsuranceValue();
    }
}
