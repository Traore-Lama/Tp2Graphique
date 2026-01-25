package com.example.tp2graphique;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TP2Controller implements Initializable {

    @FXML
    private Button btnCopier;
    @FXML
    private TextField txtExo1;
    @FXML
    private TextField txt2Exo1;
    @FXML
    private ComboBox cboExo2;
    @FXML
    private TextField txtExo2;
    @FXML
    private RadioButton rbSio1;
    @FXML
    private RadioButton rbSio2;
    @FXML
    private CheckBox chkRap;
    @FXML
    private CheckBox chkRock;
    @FXML
    private CheckBox chkRnb;
    @FXML
    private CheckBox chkClassique;
    @FXML
    private Button btnExo4;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        cboExo2.setItems(FXCollections.observableArrayList("Espagne","France","Allemagne","Cote d'Ivoire"));
        ToggleGroup toggleGroup = new ToggleGroup();
        rbSio1.setToggleGroup(toggleGroup);
        rbSio2.setToggleGroup(toggleGroup);
    }

    @FXML
    public void btnCopierOnClicked(Event event)
    {
        if (txtExo1.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setContentText("Veuillez saisir le contenu");
            alert.show();
        }
        else
        {
            txt2Exo1.setText(txtExo1.getText());
        }
    }

    @FXML
    public void cboExo2OnAction(ActionEvent actionEvent)
    {
        txtExo2.setText(cboExo2.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    public void rbSio1OnClicked(Event event)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de Saisie");
        alert.setContentText("Vous avez cliquer sur SIO1");
        alert.show();
    }

    @FXML
    public void rbSio2OnClicked(Event event)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de Saisie");
        alert.setContentText("Saisir du contenu sur SIO2");
        alert.show();
    }

    @FXML
    public void btnExo4OnClicked(Event event)
    {
        if (chkRap.isSelected() || chkRock.isSelected() || chkRnb.isSelected() || chkClassique.isSelected())
        {
            chkRap.setSelected(true);
            chkRock.setSelected(true);
            chkRnb.setSelected(true);
            chkClassique.setSelected(true);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Bonne Saisie");
            alert.setContentText("Vos Style de Musique sont : " + chkRnb.isSelected() +  " " + chkRap.isSelected() + " " + chkClassique.isSelected() + " " + chkRnb.isSelected());
            alert.show();
        }
        else
        {
            chkRap.setSelected(false);
            chkRock.setSelected(false);
            chkRnb.setSelected(false);
            chkClassique.setSelected(false);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setContentText("Veuillez choisir un Style de Musique");
            alert.show();
        }
    }
}
