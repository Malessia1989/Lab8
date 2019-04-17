package it.polito.tdp.metrodeparis.mpdel;

public class Connessione {
	private int idConnect;
	private Linea linea;
	private Fermata idP;
	private Fermata idA;
	
	public Connessione(int idConnect, Linea linea, Fermata idP, Fermata idA) {
		super();
		this.idConnect = idConnect;
		this.linea = linea;
		this.idP = idP;
		this.idA = idA;
	}
	public int getIdConnect() {
		return idConnect;
	}
	public void setIdConnect(int idConnect) {
		this.idConnect = idConnect;
	}
	public Linea getLinea() {
		return linea;
	}
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	public Fermata getIdP() {
		return idP;
	}
	public void setIdP(Fermata idP) {
		this.idP = idP;
	}
	public Fermata getIdA() {
		return idA;
	}
	public void setIdA(Fermata idA) {
		this.idA = idA;
	}
	public Fermata getStazA() {
		// TODO Auto-generated method stub
		return getStazA();
	}

	

	
}
