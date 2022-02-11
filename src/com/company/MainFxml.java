package com.company;

import com.company.bank.bankOffice.BankOffice;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainFxml extends Application {
    public static BankOffice bankOffice = new BankOffice("Имя банка");

    public static BankOffice getBankOffice() {
        return bankOffice;
    }

    public static void main(String[] args) {
        System.out.println(MainFxml.bankOffice.getBankCollections().getClientHashMap().get("2"));
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Parent content = FXMLLoader.load(getClass().getResource("fxml/scence/Scence.fxml"));
        BorderPane root = new BorderPane();
        root.setCenter(content);
        group.getChildren().add(root);
        primaryStage.setScene(new Scene(group,550,518));
        primaryStage.show();
    }
}
