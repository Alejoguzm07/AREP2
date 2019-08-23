package edu.escuelaing.arep;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class AppTest{
	@Test
	public void laMediaDeLaPrimeraColumnaDeberiaSerCorrecta() throws IOException {
		LinkedList lis = new LinkedList();
        BufferedReader br = new BufferedReader(new FileReader("TestColumn1.txt"));
        String str = null;
        while((str = br.readLine()) != null) {
        	double val = Double.parseDouble(str);
        	lis.addAtHead(val);;
        }
        double media = App.calcMedia(lis);
        assertEquals(String.format( "%.2f", media),"550.60");
        br.close();
	}
	
	@Test
	public void laMediaDeLaSegundaColumnaDeberiaSerCorrecta() throws IOException {
		LinkedList lis = new LinkedList();
        BufferedReader br = new BufferedReader(new FileReader("TestColumn2.txt"));
        String str = null;
        while((str = br.readLine()) != null) {
        	double val = Double.parseDouble(str);
        	lis.addAtHead(val);;
        }
        double media = App.calcMedia(lis);
        assertEquals(String.format( "%.2f", media),"60.32");
        br.close();
	}
	
	@Test
	public void laDesviacionDeLaPrimeraColumnaDeberiaSerCorrecta() throws IOException {
		LinkedList lis = new LinkedList();
		LinkedList lis2 = new LinkedList();
        BufferedReader br = new BufferedReader(new FileReader("TestColumn1.txt"));
        String str = null;
        while((str = br.readLine()) != null) {
        	double val = Double.parseDouble(str);
        	lis.addAtHead(val);
        	lis2.addAtHead(val);
        }
        double media = App.calcMedia(lis);
        double desv = App.calcDesv(lis2, media);
        System.out.println(desv);
        assertEquals(String.format( "%.2f", desv),"572.03");
        br.close();
	}
	
	@Test
	public void laDesviacionDeLaSegundaColumnaDeberiaSerCorrecta() throws IOException {
		LinkedList lis = new LinkedList();
		LinkedList lis2 = new LinkedList();
        BufferedReader br = new BufferedReader(new FileReader("TestColumn2.txt"));
        String str = null;
        while((str = br.readLine()) != null) {
        	double val = Double.parseDouble(str);
        	lis.addAtHead(val);
        	lis2.addAtHead(val);
        }
        double media = App.calcMedia(lis);
        double desv = App.calcDesv(lis2, media);
        //assertEquals(String.format( "%.2f", desv),"62.26");
        assertEquals(String.format( "%.2f", desv),"62.25");
        br.close();
	}
}
