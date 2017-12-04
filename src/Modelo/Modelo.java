package Modelo;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Controlador.ControladorDatos;

public class Modelo {

	public static ControladorDatos obtenerDatos(String ciudad) throws ParseException {
		ControladorDatos cd = null;
		try {
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + ciudad
					+ "&appid=57703a7a9ab7b873a99116a3ea379748");
			String json_obtenido = ControladorDatos.peticionWeb(url);
			JSONParser j = new JSONParser();
			JSONObject objeto1 = (JSONObject) j.parse(json_obtenido);
			
			JSONObject main = (JSONObject) objeto1.get("main");
			Double temMax = (Double) main.get("temp_max");
			Double temMin = (Double) main.get("temp_min");
			
			JSONObject sys = (JSONObject) objeto1.get("sys");
			Long sunrise = (Long) sys.get("sunrise");
			Date date = new Date(sunrise * 1000);
			Long sunset = (Long) sys.get("sunset");
			Date date2 = new Date(sunset * 1000);

			System.out.println(date);
			System.out.println(date2);
			System.out.println(temMax);
			System.out.println(temMin);

			cd = new ControladorDatos(temMax, temMin, date, date2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cd;
	}



}
