package edu.escuelaing.arep;

import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import spark.Request;
import spark.Response;

/**
 * Esta aplicacion permite calcular la media y desviacion estandar de los datos ingresados en un archivo de texto
 *
 */
public class App {
	public static void main(String[] args) throws NumberFormatException, IOException
    {
		setPort(4567);
        port(getPort());
        get("/entradas", (req, res) -> lectura(req, res));
        get("/salidas", (req, res) -> impresion(req, res));
	}
	
	private static String lectura(Request req, Response res) {
        String pagina = "<!DOCTYPE html><html><body><h1>Media y Desviacion estandar de una lista de reales</h1><h2>introduzca cada valor separado por un espacio</h2><form action='results'><input type='text' name='datos' value='' required><input type='submit' value='Submit'></form></body></html>";
        return pagina;
    }
	
	private static String impresion(Request req, Response res) {
        String[] datos = req.queryParams("datos").split(" ");
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();
        for(int i = 0; i < datos.length; i++) {
        	a.addAtHead(Double.parseDouble(datos[i]));
        	b.addAtHead(Double.parseDouble(datos[i]));
        }
        double media = calcMedia(a);
        double desviacion = calcDesv(b, media);
        String pagina = "<!DOCTYPE html><html><body><h1>La media es: "+ media +"</h2><br></br><body><h1>La desviacioin estandar es: " + desviacion + "</h2></html></body>";
        return pagina;
    }
	
	/**
	 * este metodo calcula la media de una lista de numeros
	 * @param lis es una LinkedList de valores
	 * @return un real con la media de la lista de valores
	 */
	public static double calcMedia(LinkedList lis){
		double suma = 0;
		double lon = lis.getLength();
		for(int i = 0; i < lon; i++){
			suma += lis.pop().getValor();
		}
		double media = suma / lon;
		return media;
	}

	/**
	 * calcula la desviacion estandar de una lista de numeros dada su media
	 * @param lis es una LinkedList de valores
	 * @param med es la media del arreglo de valores
	 * @return un real con la desviacion estandar de la lista de valores
	 */
	public static double calcDesv(LinkedList lis, double med){
		int suma = 0;
		int lon = lis.getLength();
		for(int i = 0; i < lon; i++){
			double valor = lis.pop().getValor();
			suma += Math.pow((valor - med), 2);
		}
		double desvia = Math.pow((suma / (double)(lon - 1)), 0.5);
		return desvia;
	}
	
	static int getPort() {        
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)    }
	}
}

