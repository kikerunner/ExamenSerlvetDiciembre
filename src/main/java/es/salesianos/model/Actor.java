package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

public class Actor {
	
	private int Cod;
	private String Name;
	private int yearofbirthdate;
	private List<Mascota> mascotas = new ArrayList();
	
	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public int getCod() {
		return Cod;
	}

	public void setCod(int cod) {
		Cod = cod;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getYearofbirthdate() {
		return yearofbirthdate;
	}

	public void setYearofbirthdate(int yearofbirthdate) {
		this.yearofbirthdate = yearofbirthdate;
	}

	

	
}
