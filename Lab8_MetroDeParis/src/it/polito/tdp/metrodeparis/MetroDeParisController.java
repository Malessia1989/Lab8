
package it.polito.tdp.metrodeparis;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.metrodeparis.mpdel.Fermata;
import it.polito.tdp.metrodeparis.mpdel.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

	public class MetroDeParisController {

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ComboBox<Fermata> ComboBoxStazioneP;

	    @FXML
	    private Button btnCalcolaPercorso;

	    @FXML
	    private ComboBox<Fermata> ComboBoxStazA;

	    @FXML
	    private TextArea txtResult;

		private Model model;

	    @FXML
	    void doCalcolaPercorso(ActionEvent event) {
	    	Fermata partenza=ComboBoxStazioneP.getValue();
	    	Fermata arrivo= ComboBoxStazA.getValue();
	    	
	    	if(partenza != null && partenza != null) {
	    		if(!partenza.equals(arrivo) ) {
	    			
	    			
	    		}
	    		else { showAlert("la partenza e l'arrivo devono essere diversi!");
	    			
	    		}
	    	}else {
	    		showAlert("selezionare la partenza e la destinazione");
	    	}

	    }

	    private void showAlert(String message) {
	    	Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText(message);
			alert.show();
			
		}

		@FXML
	    void initialize() {
	        assert ComboBoxStazioneP != null : "fx:id=\"ComboBoxStazioneP\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
	        assert btnCalcolaPercorso != null : "fx:id=\"btnCalcolaPercorso\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
	        assert ComboBoxStazA != null : "fx:id=\"ComboBoxStazA\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
	        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'MetroDeParis.fxml'.";
	        
	        ComboBoxStazA.getItems().addAll(Model.getAllFermate());
	        ComboBoxStazioneP.getItems().addAll(Model.getallFermate());
	    }

		public void setModel(Model model) {
			this.model = model;
			
			model.creaGrafo();
		}
	
}
