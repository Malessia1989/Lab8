package it.polito.tdp.metrodeparis.mpdel;

import com.javadocmd.simplelatlng.LatLng;

public class Fermata {
	
	private int id;
	private String nome;
	private LatLng coords;

	

	public Fermata(int id, String nome, LatLng coords) {
		super();
		this.id = id;
		this.nome = nome;
		this.coords = coords;
	}
	
	public Fermata (int id) {
		this.id=id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fermata other = (Fermata) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public LatLng getCoords() {
		return coords;
	}



	public void setCoords(LatLng coords) {
		this.coords = coords;
	}



	
}
