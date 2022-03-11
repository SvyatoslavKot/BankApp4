
package com.company.fxml.controller;

        import com.company.data.*;
        import com.company.bank.bankOffice.BankOffice;
        import com.company.bank.bankOffice.Ticket;
        import com.company.MainFxml;
        import com.company.data.currencyReader.Currence;
        import com.company.data.currencyReader.CurrenceReader;
        import com.company.fxml.controller.rate.CurrenceSettigController;
        import com.company.fxml.controller.rate.CurrenceSetting;
        import com.company.service.Parser.ParserCurrency;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.ListView;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;

        import java.io.*;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.ResourceBundle;

public class MainScene implements Initializable {
    public Text textRateUs;
    public Text textRateEu;
    public Text textRateCny;
    public Text textRateCnySell;
    public Text textNameCNY;
    public Text textNameEU;
    public Text textNameUS;
    public Text textRateEuSell;
    public Text textRateUsSell;
    BankOffice bankOffice = MainFxml.getBankOffice();

    ParserCurrency parserCurrency = new ParserCurrency(bankOffice);
    CurrenceReader currenceReader = new CurrenceReader();
    CurrenceSetting currenceSetting = CurrenceSetting.getInstance();
    DBReader bdReader = new DBReader();
    DBWriter bdWriter = new DBWriter();

    final private String NAME_BD_DIR = "BankApp";
    @FXML
    ListView<String> listViewStage;
    ArrayList<String> listAdd = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (bankOffice.getBankCollections().getClientHashMap().isEmpty()){

            parserCurrency.start();
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
        currenceReader.start();
        currenceSetting.setVisbleRate(textRateUs,textNameUS,textRateUsSell,"us");
        currenceSetting.setVisbleRate(textRateEu,textNameEU,textRateEuSell,"eu");
        currenceSetting.setVisbleRate(textRateCny,textNameCNY,textRateCnySell,"cny");
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
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
        CurrenceSettigController rsc = new CurrenceSettigController();

    public void settingRate(ActionEvent actionEvent){
                rsc.openView(actionEvent);
    }
    private void setVisbleRate (boolean a, Text b ,Text n, Text s, String currenceName) {
        if (a) {
            b.setVisible(true);
            n.setVisible(true);
            s.setVisible(true);
            if (currenceName.equals("us")) {
                b.setText(currenceReader.getCurrence().getUs() );
            } else if (currenceName.equals("eu")) {
                b.setText(currenceReader.getCurrence().getEu());
            } else if (currenceName.equals("cny")) {
                b.setText(currenceReader.getCurrence().getCny());
            }
            }else {
                b.setVisible(false);
            n.setVisible(false);
            s.setVisible(false);
        }
    }
}
