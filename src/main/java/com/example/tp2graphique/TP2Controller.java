package com.example.tp2graphique;

import com.example.tp2graphique.Models.Pays;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;
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
    @FXML
    private DatePicker dpExo5;
    @FXML
    private TextField txtExo5;
    @FXML
    private Slider sldExo5;
    @FXML
    private Rectangle rectangle;
    @FXML
    private ColorPicker cpExo6;
    @FXML
    private ListView lvExo7;
    @FXML
    private TextField txtExo7;
    @FXML
    private TableView tvExo8;
    @FXML
    private TableColumn tcNomPays;
    @FXML
    private TableColumn tcCapitale;
    @FXML
    private TableColumn tcNbHabitants;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        cboExo2.setItems(FXCollections.observableArrayList("Espagne","France","Allemagne","Cote d'Ivoire"));
        ToggleGroup toggleGroup = new ToggleGroup();
        rbSio1.setToggleGroup(toggleGroup);
        rbSio2.setToggleGroup(toggleGroup);

        lvExo7.setItems(FXCollections.observableArrayList("Espagne","France","Allemagne","Cote d'Ivoire"));

        // Creation d'objet de class Pays avc les attributs
        Pays espagne = new Pays("Espagne",47059533,"Madrid");
        Pays france = new Pays("France",68606000,"Paris");
        Pays allemagne = new Pays("Allemagne",83360000,"Berlin");
        Pays civ = new Pays("Cote d'Ivoire",93608020,"Abidjan");

        // Les colones du TableView
        tcNomPays.setCellValueFactory(new PropertyValueFactory<>("nomPays"));
        tcNbHabitants.setCellValueFactory(new PropertyValueFactory<>("nbHabitants"));
        tcCapitale.setCellValueFactory(new PropertyValueFactory<>("nomCapitale"));

        // Ajout des objet a leur colones
        tvExo8.setItems(FXCollections.observableArrayList(espagne,france,allemagne,civ));

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
        String result = "";

        if (chkRap.isSelected())
        {
            result += ("Rap - ");
        }
        if (chkRock.isSelected())
        {
            result += ("Rock - ");
        }
        if (chkClassique.isSelected())
        {
            result += ("Classique - ");
        }
        if (chkRnb.isSelected())
        {
            result += ("RnB - ");
        }

        if (result.length() == 0)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez choisir un style de musique");
            alert.showAndWait();
        } else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Résultat");
            alert.setHeaderText(null);
            alert.setContentText("Vos goûts musicaux sont : " + result);
            alert.showAndWait();
        }
    }

    @FXML
    public void dpExo5OnAction(ActionEvent actionEvent)
    {
        txtExo5.setText(dpExo5.getValue().toString());
    }

    @FXML
    public void cpExo6OnAction(ActionEvent actionEvent)
    {

    }

    @FXML
    public void lvExo7OnClicked(Event event)
    {
        txtExo7.setText(lvExo7.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    public void tvExo8OnClicked(Event event)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur de saisie");
        alert.show();
    }
}
