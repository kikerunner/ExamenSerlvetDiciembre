package es.salesianos.model;

public class Pelicula {
	
	private int cod;
	private String title;
	private int codOwner;
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCodOwner() {
		return codOwner;
	}
	public void setCodOwner(int codOwner) {
		this.codOwner = codOwner;
	}	
}
