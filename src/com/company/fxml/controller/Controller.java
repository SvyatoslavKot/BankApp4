
package com.company.fxml.controller;

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


    @FXML
    ListView<String> listViewStage;
    ArrayList<String> listAdd = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            deserialization();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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

    @FXML private void btnAccount(){

    }
    @FXML private void saveFile (ActionEvent actionEvent) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("Save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(bankOffice.getBankCollections());
        objectOutputStream.close();


    }
    @FXML private void openFile (ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        deserialization();
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
    private Button btnAtm;

    @FXML
    private Button btnTeller;

    @FXML
    private Button btnTerminal;
}
