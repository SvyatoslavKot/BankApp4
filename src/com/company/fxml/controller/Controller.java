
package com.company.fxml.controller;

        import com.company.data.*;
        import com.company.bank.bankOffice.BankOffice;
        import com.company.bank.bankOffice.Ticket;
        import com.company.MainFxml;
        import com.company.fxml.controller.rate.RateSetting;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.ListView;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import javafx.stage.Window;

        import java.io.*;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Text textRateUs;
    public Text textRateEu;
    public Text textRateCny;
    BankOffice bankOffice = MainFxml.getBankOffice();

    DBReader bdReader = new DBReader();
    DBWriter bdWriter = new DBWriter();
    final private String NAME_BD_DIR = "BankApp";


    @FXML
    ListView<String> listViewStage;
    ArrayList<String> listAdd = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (bankOffice.getBankCollections().getClientHashMap().isEmpty()){

            bdReader.bdRead(bankOffice,NAME_BD_DIR);
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
        RateSetting rateSetting = RateSetting.getInstance();
        setVisbleRate(rateSetting.isUs(),textRateUs);
        setVisbleRate(rateSetting.isUe(),textRateEu);
        setVisbleRate(rateSetting.isCny(),textRateCny);


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
    private void btnInsurence(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scence/insuranceForm.fxml"));
            stage.setTitle("Insurance Department");
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
        bdWriter.write(bankOffice,NAME_BD_DIR);
    }
    @FXML private void openFile (ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        bdReader.bdRead(bankOffice,NAME_BD_DIR);
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
    private void btnTeller(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scence/TellerStart.fxml"));
            stage.setTitle("Teller");
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
    private  Button btnAtm;
    @FXML
    private Button btnTerminal;

    public void btnATM(ActionEvent actionEvent) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scence/atmStar.fxml"));
            stage.setTitle("Teller");
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

    public void settingRate(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../scence/rateSettingForm.fxml"));
            stage.setTitle("RateSetting");
            stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setMinHeight(449);
            stage.setMinWidth(244);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
            //Parent root = FXMLLoader.load(getClass().getResource

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void setVisbleRate (boolean a, Text t ){
        if (!a){
            t.setVisible(false);
        }else t.setVisible(true);
    }
}
