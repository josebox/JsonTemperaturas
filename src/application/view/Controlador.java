package application.view;

import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.soap.SAAJResult;

import org.json.simple.parser.ParseException;

import Controlador.ControladorDatos;
import Modelo.Ciudades;
import Modelo.Modelo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Controlador implements Initializable {
	ControladorDatos cd = null;

	@FXML
	Label lbTemMax;
	@FXML
	Label lbTemMin;
	@FXML
	Label lbSunrise;
	@FXML
	Label lbSunset;
	@FXML
	private ComboBox<String> cbx_ciudades = new ComboBox<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Ciudades c = new Ciudades();
		cbx_ciudades.getItems().addAll(c.getCiudades());
		cbx_ciudades.valueProperty (). addListener (new ChangeListener<String>() {
			
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				System.err.println(newValue);
				try {
					Modelo.obtenerDatos(newValue);
					lbTemMax.setText(ControladorDatos.getTemMax().toString());
					lbTemMin.setText(ControladorDatos.getTemMin().toString());
					lbSunrise.setText(ControladorDatos.getSunrise().toString());
					lbSunset.setText(ControladorDatos.getSunset().toString());
					
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	
	}
	




}
