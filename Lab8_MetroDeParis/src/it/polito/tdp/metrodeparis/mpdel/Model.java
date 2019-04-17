package it.polito.tdp.metrodeparis.mpdel;

import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.metrodeparis.DAO.MetroDAO;

public class Model {
	
	private SimpleWeightedGraph<Fermata, DefaultWeightedEdge> grafo=null;
	
	private List<Fermata> fermate;
	private List<Linea> linee;
	private List<Connessione> connessioni;
	MetroDAO dao=new MetroDAO();
	
	public static List<Fermata> getAllFermate() {
		MetroDAO dao=new MetroDAO();
		return dao.getFermate();
	}

	public static List<Fermata> getallFermate() {
		MetroDAO dao=new MetroDAO();
		return dao.getFermate();
	}

	public void creaGrafo() {
		
		fermate=dao.getFermate();
		linee=dao.getLinee();
		connessioni=dao.getConnessioni(fermate,linee);
		
		//creo grafo non orientato,pesato
		Graphs.addAllVertices(grafo, fermate);
		
		for (Connessione c : connessioni) {

			// IMPORTANTE:
			// Usando un grafo seplice non prendo in considerazione il caso
			// in cui due fermate siano collegate da più linee.

			double velocita = c.getLinea().getVelocita();
			double distanza = LatLngTool.distance(c.getIdP().getCoords(), c.getStazA().getCoords(), LengthUnit.KILOMETER);
			double tempo = (distanza / velocita) * 60 * 60;

			// Aggiungoun un arco pesato tra le due fermate
			Graphs.addEdge(grafo, c.getIdP(), c.getStazA(), tempo);
		}
		
		
	}

}
