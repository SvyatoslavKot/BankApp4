package com.company.fxml.controller;

import com.company.Client;
import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoney;
import com.company.bank.bankOffice.accountManagementDepartment.AccountMoneyController;
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
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {
    BankOffice bankOffice = MainFxml.bankOffice;
    Client client;
    String comboLevel;
    String comboType;
    AccountMoney accountMoney;
    AccountMoneyController accountController = new AccountMoneyController();
    ClientService clientService = new ClientService();
    @FXML
    TextArea areaResult;
    @FXML
    TextArea textAreaStart;
    @FXML
    private ComboBox<String> comboBoxLevel;
    @FXML
    private ComboBox<String> comboBoxType;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        setClient(bankOffice.getAccountManagerDepartment().startWork());
        if (client!= null){
            textAreaStart.setText("Здравствуйте " + client.getName() + " заполните форму.");
        }else {
            textAreaStart.setText("Клиентов на оформление нет.");
        }

        comboBoxType.getItems().setAll(
                "СберКарта", "Молодежный", "Travel"
        );
        comboBoxType.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
        });

        comboBoxLevel.getItems().setAll(
                "Light", "Standard", "Gold"
        );
        comboBoxLevel.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) ->{

        });
    }

    @FXML
    void btnCalck(ActionEvent actionEvent){
        System.out.println(client+comboLevel+comboType);
        if (comboType!=null && comboLevel!=null &&  client!= null){
            try {
                setAccountMoney(accountController.openDebit(client,bankOffice,comboType,comboLevel));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                //e.printStackTrace();
            }
            if (accountMoney!=null){
                areaResult.setText(resultCalk(client,accountMoney));
            }else {areaResult.setText("Счёт не создан");}
        }else {areaResult.setText("Заполните форму");}
    }
    @FXML
    void btnSend(ActionEvent actionEvent) throws IOException{
        if (accountMoney!=null){
            bankOffice.getBankCollections().getAccountList().add(accountMoney);
            setClient(bankOffice.getAccountManagerDepartment().startWork());
            if (client!=null){

                areaResult.setText("");
                textAreaStart.setText("Здравствуйте " + client.getName() + " заполните форму.");
            }else {
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

        }else {

        }
    }
    @FXML
    void comboBoxChangeType(){
        String selectedValue = comboBoxType.getSelectionModel().getSelectedItem();
        String a = selectedValue;
        System.out.println(a);
        setComboType(a);

    }
    @FXML
    void comboBoxChangeLevel(){
        String selectedValue = comboBoxLevel.getSelectionModel().getSelectedItem();
        String b = selectedValue;
        System.out.println(b);
        setComboLevel(b);
    }


    public void btnCancel(javafx.event.ActionEvent actionEvent) throws IOException {
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

    private String resultCalk (Client client, AccountMoney accountMoney){
        return
                client.getName() + " для вас подобран счёт '" + accountMoney.getNameAccount() +"'" +
                        "\nсроком: "+ accountMoney.getCreditTerm() +" мес."+
                        "\nежемесчная плата за обслуживание: "+ accountMoney.getPayment() +
                        "\ncashBack по карте: " + accountMoney.getCashBack();
    }

    private void setClient(Client client) {
        this.client = client;
    }

    public void setComboLevel(String comboLevel) {
        this.comboLevel = comboLevel;
    }

    public void setComboType(String comboType) {
        this.comboType = comboType;
    }

    public void setAccountMoney(AccountMoney accountMoney) {
        this.accountMoney = accountMoney;
    }
}
