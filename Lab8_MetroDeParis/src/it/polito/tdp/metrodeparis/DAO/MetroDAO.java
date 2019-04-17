package it.polito.tdp.metrodeparis.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.javadocmd.simplelatlng.LatLng;

import it.polito.tdp.metrodeparis.mpdel.Connessione;
import it.polito.tdp.metrodeparis.mpdel.Fermata;
import it.polito.tdp.metrodeparis.mpdel.Linea;

public class MetroDAO {

	public List<Fermata> getFermate() {
		
		String sql=" select * " + 
				"from fermata " + 
				"order by nome ASC ";
		
		List<Fermata> result= new LinkedList<>();
		
		

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id=rs.getInt("id_fermata");
				String nome=rs.getString("nome");
				double coX=rs.getDouble("coordX");
				double coY=rs.getDouble("coordY");
				
				Fermata f = new Fermata(rs.getInt("id_Fermata"), rs.getString("nome"),
						new LatLng(rs.getDouble("coordx"), rs.getDouble("coordy")));
				result.add(f);
			}
			
		//	conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}

	public List<Linea> getLinee() {
		String sql=" select id_linea, nome, velocita, intervallo,colore from linea order by nome ASC ";
		List<Linea> result=new LinkedList<>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id=rs.getInt("id_linea");
				String nome=rs.getString("nome");
				double vel =rs.getDouble("velocita");
				double intervallo =rs.getDouble("intervallo");
				String colore=rs.getString("colore");
				
				Linea linea=new Linea(id, nome, vel, intervallo, colore);
				result.add(linea);
				
		
			}
			
			//conn.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		}
	}

	public List<Connessione> getConnessioni(List<Fermata> fermate, List<Linea> linee) {
			String sql="select id_connessione, id_linea, id_stazP,id_stazA " + 
					"from connessione";
			List<Connessione> result=new LinkedList<>();
			
			try {
				Connection conn = DBConnect.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					int idLinea = rs.getInt("id_linea");
					int idStazP = rs.getInt("id_stazP");
					int idStazA = rs.getInt("id_stazA");

					Linea myLinea = linee.get(linee.indexOf(new Linea(idLinea)));
					Fermata myStazP = fermate.get(fermate.indexOf(new Fermata(idStazP)));
					Fermata myStazA = fermate.get(fermate.indexOf(new Fermata(idStazA)));

					Connessione cnx = new Connessione(rs.getInt("id_connessione"), myLinea, myStazP, myStazA);

					result.add(cnx);	
			
				}
				
				//conn.close();
				return result;

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Errore connessione al database");
				throw new RuntimeException("Error Connection Database");
			}

	}

}
