package Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class ControladorDatos {
	
	static Double temMax;
	static Double temMin;
	static Date sunrise;
	static Date sunset;

	public ControladorDatos(Double temMax, Double temMin, Date sunrise, Date sunset) {
		this.temMax = temMax;
		this.temMin = temMin;
		this.sunrise = sunrise;
		this.sunset = sunset;
	}
	

	public static Double getTemMax() {
		Double g = temMax - 273;
		double roundOff = (double) Math.round(g * 10) / 10;
		return roundOff;
	}


	public void setTemMax(Double temMax) {
		this.temMax = temMax;
	}


	public static Double getTemMin() {
		Double g = temMin - 273;
		double roundOff = (double) Math.round(g * 10) / 10;
		return roundOff;
	}


	public void setTemMin(Double temMin) {
		this.temMin = temMin;
	}


	public static Date getSunrise() {
		return sunrise;
	}


	public void setSunrise(Date sunrise) {
		this.sunrise = sunrise;
	}


	public static Date getSunset() {
		return sunset;
	}


	public void setSunset(Date sunset) {
		this.sunset = sunset;
	}

	public static String peticionWeb(URL url) throws IOException {
		String respuesta = "";
		// abrimos la conexión
		URLConnection conn = url.openConnection();
		// obtenemos el flujo de lectura
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String linea;
		// procesamos al salida
		while ((linea = rd.readLine()) != null) {
			respuesta += linea;
		}
		return respuesta;
	}

}
