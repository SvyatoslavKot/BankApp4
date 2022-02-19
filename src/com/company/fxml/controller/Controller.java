
package com.company.fxml.controller;

        import com.company.BD_Bank.BDReadAccountMoney;
        import com.company.BD_Bank.BDWriteAccountMoney;
        import com.company.BD_Bank.BdReadClient;
        import com.company.BD_Bank.BdWriteClient;
        import com.company.Client;
        import com.company.bank.bankOffice.BankOffice;
        import com.company.bank.bankOffice.BankService.BankCollections;
        import com.company.bank.bankOffice.Ticket;
        import com.company.MainFxml;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.ListView;
        import javafx.stage.Stage;

        import java.io.*;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.ResourceBundle;

public class Controller implements Initializable {
    BankOffice bankOffice = MainFxml.getBankOffice();
    BdWriteClient bdWriteClient  = new BdWriteClient();
    BdReadClient bdReadClient = new BdReadClient();
    BDReadAccountMoney bdReadAccountMoney = new BDReadAccountMoney();
    BDWriteAccountMoney bdWriteAccountMoney = new BDWriteAccountMoney();

    final private String  ClientBD = "clients.txt";
    final private String  ACC_BD = "accounts.txt";


    @FXML
    ListView<String> listViewStage;
    ArrayList<String> listAdd = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // try {
            //deserialization();
           // bdReadClient.readBD(bankOffice, ClientBD);
        //} catch (IOException e) {
           // e.printStackTrace();
        //} catch (ClassNotFoundException e) {
          //  e.printStackTrace();
        //}

        listViewStage.getItems().addAll(listAdd);

        LinkedList<Ticket> tic = new LinkedList<>();
        tic.addAll(bankOffice.getCreditDepartment().getTickets2());
        tic.addAll(bankOffice.getAccountManagerDepartment().getTickets2());
        tic.addAll(bankOffice.getInsuranceDepartment().getTickets2());
        for (Ticket ticket:tic){
            String t = ticket.getNumberOfTicket();
            listAdd.add(t);

        }
        listViewStage.getItems().removeAll();
    listViewStage.getItems().addAll(listAdd);
    }
    public void showTerminal(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scence/terminal.fxml"));
            stage.setTitle("Terminal");
            stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setMinHeight(300);
            stage.setMinWidth(400);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void btnCredit(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scence/creditForm.fxml"));
            stage.setTitle("Credit Department");
            stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setMinHeight(297);
            stage.setMinWidth(404);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void btnInsurence(){

    }

    @FXML private void btnAccount(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scence/accountForm.fxml"));
            stage.setTitle("Account Department");
            stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setMinHeight(297);
            stage.setMinWidth(404);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML private void saveFile (ActionEvent actionEvent) throws IOException {
        bdWriteClient.writeClient(bankOffice,ClientBD);
        bdWriteAccountMoney.writeAcc(bankOffice,ACC_BD);
    }
    @FXML private void openFile (ActionEvent actionEvent) throws IOException, ClassNotFoundException {
       bdReadClient.readBD(bankOffice,ClientBD);
       bdReadAccountMoney.readBD(bankOffice,ACC_BD);
    }
    private  void deserialization () throws IOException, ClassNotFoundException {
        BankCollections bankCollections = new BankCollections();
        FileInputStream fileInputStream = new FileInputStream("Save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object temp = objectInputStream.readObject();
        bankCollections = (BankCollections) temp;
        bankOffice.setBankCollections(bankCollections);
        objectInputStream.close();
    }
    @FXML
    private void btnAddStaff(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scence/addStafForm.fxml"));
            stage.setTitle("Terminal");
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
    private Button btnAtm;

    @FXML
    private Button btnTeller;

    @FXML
    private Button btnTerminal;
}
