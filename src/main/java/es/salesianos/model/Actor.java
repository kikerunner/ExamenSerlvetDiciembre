package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

public class Actor {
	
	private int cod;
	private String name;
	private int yearofbirthdate;
	private List<Pelicula> peliculas = new ArrayList();
	


	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearofbirthdate() {
		return yearofbirthdate;
	}

	public void setYearofbirthdate(int yearofbirthdate) {
		this.yearofbirthdate = yearofbirthdate;
	}

	

	
}
