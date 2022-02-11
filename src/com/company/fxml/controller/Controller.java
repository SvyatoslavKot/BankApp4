
package com.company.fxml.controller;

        import com.company.bank.bankOffice.BankOffice;
        import com.company.bank.bankOffice.Ticket;
        import com.company.MainFxml;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.ListView;
        import javafx.stage.Stage;

        import java.io.IOException;
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

    @FXML
    private Button btnAtm;

    @FXML
    private Button btnTeller;

    @FXML
    private Button btnTerminal;
}
