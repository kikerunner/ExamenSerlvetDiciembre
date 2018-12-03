package service;

import java.util.List;

import es.salesianos.model.Actor;
import es.salesianos.model.Mascota;
import es.salesianos.repository.ActoresRepository;
import es.salesianos.repository.PetRepository;

public class Service {
	
	ActoresRepository repository = new ActoresRepository();
	PetRepository repoPet = new PetRepository();
	
	public List<Actor> listAllUsers() {
		return repository.searchAll();
	}
	
	public Actor searchOnePerson(int CodPersona) {
		return repository.selectOnePerson(CodPersona);
	}
	
	public Actor findOwnerByPet(String nomMascota) {
		return repoPet.selectOwnerByPet(nomMascota);
	}
	
	public void updatePerson(Actor persona) {
		repository.updatePerson(persona);
	}
	
	public void borrarActor(Actor actor) {
		repository.borrarActor(actor);
	}

}
