package com.example.tp2graphique;

import com.example.tp2graphique.Models.Pays;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import java.time.format.DateTimeFormatter;
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
    private TableView<Pays> tvExo8;
    @FXML
    private TableColumn<Pays, String> tcNomPays;
    @FXML
    private TableColumn<Pays, String> tcCapitale;
    @FXML
    private TableColumn<Pays, Integer> tcNbHabitants;
    @FXML
    private Spinner spExo5;



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

        sldExo5.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1)
            {
                txtExo5.setText(String.valueOf(t1.intValue()));
            }
        });

        spExo5.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,20,5,1));
    }

    @FXML
    public void btnCopierOnClicked(Event event)
    {
        if (txtExo1.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText(null);
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
        txtExo2.setText(cboExo2.getValue().toString());
    }

    @FXML
    public void rbSioOnClicked(Event event)
    {
        if (rbSio1.isSelected())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setContentText("Vous avez cliquer sur SIO1");
            alert.show();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setContentText("Vous avez cliquer sur SIO2");
            alert.show();
        }
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
            alert.setContentText("Veuillez choisir un style de musique");
            alert.show();
        } else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Résultat");
            alert.setContentText("Vos goûts musicaux sont : " + result);
            alert.show();
        }
    }

    @FXML
    public void dpExo5OnAction(ActionEvent actionEvent)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        txtExo5.setText(dtf.format(dpExo5.getValue()));
    }

    @FXML
    public void spExo5OnClicked(Event event)
    {
        txtExo5.setText(String.valueOf(sldExo5.getValue())); // Fonctionne pas
    }

    @FXML
    public void cpExo6OnAction(ActionEvent actionEvent)
    {
        rectangle.setFill(cpExo6.getValue());
    }

    @FXML
    public void lvExo7OnClicked(Event event)
    {
        txtExo7.setText(lvExo7.getSelectionModel().getSelectedItem().toString());
    }

    public void tvExo8OnClicked(Event event)
    {
        Pays selectedPays = tvExo8.getSelectionModel().getSelectedItem();

        if (selectedPays != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Pays");
            alert.setContentText(
                    selectedPays.getNomPays()
                            + " - " + selectedPays.getNbHabitants()
                            + " - " + selectedPays.getNomCapitale()
            );
            alert.show();
        } else {
            // Optionnel : afficher un message si aucune ligne n'est sélectionnée
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez cliquer sur une ligne du tableau");
            alert.show();
        }
    }
}
