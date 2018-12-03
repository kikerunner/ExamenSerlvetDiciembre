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
	
	public List<Director> listAllDirectores() {
		return repoDirector.searchAll();
	}
	
	public Actor searchOnePerson(int Cod) {
		return repository.selectOneActor(Cod);
	}
	
	public Actor findOwnerByPet(String nomMascota) {
		return repoPeli.selectOwnerByPet(nomMascota);
	}
	
	public void updatePerson(Actor persona) {
		repository.updatePerson(persona);
	}
	
	public void borrarActor(Actor actor) {
		repository.borrarActor(actor);
	}

}
