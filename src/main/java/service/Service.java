package service;

import java.util.List;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.model.Pelicula;
import es.salesianos.repository.ActoresRepository;
import es.salesianos.repository.DirectoresRepository;
import es.salesianos.repository.PeliRepository;

public class Service {
	
	ActoresRepository repository = new ActoresRepository();
	PeliRepository repoPeli = new PeliRepository();
	DirectoresRepository repoDirector = new DirectoresRepository();
	
	public List<Actor> listAllUsers() {
		return repository.searchAll();
	}
	
	public List<Pelicula> listAllPeliculas() {
		return repoPeli.searchAll();
	}
	
	public Pelicula listOnePelicula(Pelicula pelicula) {
		return repoPeli.searchOne(pelicula);
	}
	
	public List<Director> listAllDirectores() {
		return repoDirector.searchAll();
	}
	
	public Actor searchOnePerson(int Cod) {
		return repository.selectOneActor(Cod);
	}
	
	public Pelicula searchOnePelicula(int Cod) {
		return repoPeli.selectOnePlicula(Cod);
	}
	
	public Director searchOneDirector(int Cod) {
		return repoDirector.selectOneDirector(Cod);
	}
	
	public List<Actor> findActoresBetweenYear(int ano1, int ano2) {
		return repository.selectActoresBetweenYear(ano1, ano2);
	}
	
	public void updatePerson(Actor persona) {
		repository.updatePerson(persona);
	}
	
	public void borrarActor(Actor actor) {
		repository.borrarActor(actor);
	}
	
	public void borrarPelicula(Pelicula pelicula) {
		repoPeli.borrarPelicula(pelicula);
	}
	
	public void borrarDirector(Director director) {
		repoDirector.borrarDirector(director);
	}

}
