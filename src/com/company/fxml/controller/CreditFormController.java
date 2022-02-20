package com.company.fxml.controller;

import com.company.Client;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.creditDepartment.Credit;
import com.company.bank.bankOffice.creditDepartment.CreditController;
import com.company.MainFxml;
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

public class CreditFormController implements Initializable {
    BankOffice bankOffice = MainFxml.bankOffice;
    Client client;
    CreditController creditController = new CreditController();
    String combo;
    Credit credit;
    ClientService clientService = new ClientService();

    @FXML
    private TextArea areaResult;

    @FXML
    private TextArea textAreaStart;

    @FXML
    private TextField textFieldSum;

    @FXML
    private TextField textFieldTerm;

    @FXML
    private ComboBox<String> comboBoxType;

    TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setClient(bankOffice.getCreditDepartment().startWork());
        if (client != null) {
            textAreaStart.setText("Здравствуйте, " + client.getName() + ". Заполните форму.");
        } else {
            textAreaStart.setText("Клиентов на оформление нет.");
        }

        comboBoxType.getItems().setAll(
                "Потребительский", "Автокредит", "Ипотека", "Кредитная карта"
        );
        comboBoxType.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
        });
    }

    @FXML
    void btnCalck(ActionEvent event) {
        if (client != null) {
            if (!textFieldSum.getText().isEmpty() && !textFieldTerm.getText().isEmpty()) {
                if (textFieldSum != null && textFieldTerm != null) {
                    int sum = Integer.parseInt(textFieldSum.getText());
                    int term = Integer.parseInt(textFieldTerm.getText());
                    if (combo == null) {
                        areaResult.setText("Выберите тип кредита");
                    } else if (sum != 0 && term != 0) {
                        setCredit(creditController.openCredit(client, bankOffice, sum, combo, term));
                        if (credit != null) {
                            areaResult.setText(creditResult(client, credit));
                        } else {
                            textAreaStart.setText(client.getName() + ", для вас нет подходящих предложений");
                            areaResult.setText("");
                        }

                    } else {
                        areaResult.setText("Для вас нет подходящих вариантов");
                    }
                }
            } else {
                areaResult.setText("Заполните форму");
            }
        }
    }

    @FXML
    void comboBoxChange(ActionEvent event) {
        String selectedValue = comboBoxType.getSelectionModel().getSelectedItem();
        String a = selectedValue;
        System.out.println(a);
        setCombo(a);
    }

    @FXML
    void btnCancel(ActionEvent event) throws IOException {
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

    @FXML
    void btnSend(ActionEvent event) throws IOException {
        if (credit != null) {
            clientService.takeCash(credit.getAmount(), client);
            System.out.println(client.getCash());
            bankOffice.getBankCollections().getCreditList().add(credit);
            setClient(bankOffice.getCreditDepartment().startWork());
            if (client != null) {
                textFieldSum.setText("");
                textFieldTerm.setText("");
                areaResult.setText("");
                textAreaStart.setText("Здравствуйте, " + client.getName() + ". Заполните форму.");
            } else {
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
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    private String creditResult(Client client, Credit credit) {
        return
                client.getName() + " вам одобрен " + credit.getCreditName() +
                        "\nномер счёта: " + credit.getAccountNumber() +
                        "\nсрок кредита: " + credit.getCreditTerm() + " мес." +
                        "\nпроцентная ставка: " + credit.getPtc() +
                        "\nсумма займа: " + credit.getAmount() +
                        "\nсумма ежемесячного платежа: " + String.format("%.2f", credit.getPaymentMonth()) + " руб." +
                        "\n";
    }
}