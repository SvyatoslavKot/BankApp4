package com.company.fxml.controller.rate;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class CurrenceSettigController implements Initializable {
    public CheckBox cbUS;
    public CheckBox cbEU;
    public CheckBox cbCNY;


    CurrenceSetting rateSetting = CurrenceSetting.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (rateSetting.isUs()){
            cbUS.setSelected(true);
        }else cbUS.setSelected(false);
        if (rateSetting.isUe()){
            cbEU.setSelected(true);
        }else cbEU.setSelected(false);
        if (rateSetting.isCny()){
            cbCNY.setSelected(true);
        }else cbCNY.setSelected(false);
    }
    public void changeUS(ActionEvent actionEvent) {
        if (cbUS.isSelected()){
            rateSetting.setUs(true);
        }else rateSetting.setUs(false);
        System.out.println(rateSetting.isUs());
    }

    public void changeEU(ActionEvent actionEvent) {
        if (cbEU.isSelected()){
            rateSetting.setUe(true);
        }else rateSetting.setUe(false);
        System.out.println(rateSetting.isUe());
    }


    public void changeCNY(ActionEvent actionEvent) {
        if (cbCNY.isSelected()){
            rateSetting.setCny(true);
        }else rateSetting.setCny(false);
        System.out.println(rateSetting.isCny());
    }

    public void btnSend(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = load(getClass().getResource("../../scence/Scence.fxml"));
            stage.setTitle("Main");
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setMinHeight(640);
            stage.setMinWidth(518);
            stage.setResizable(true);
            stage.setScene(new Scene(root));
            stage.show();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openView(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../../scence/currenceSettingForm.fxml"));
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


}
