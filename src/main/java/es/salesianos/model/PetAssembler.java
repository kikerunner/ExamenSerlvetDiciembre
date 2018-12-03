package es.salesianos.model;

import javax.servlet.http.HttpServletRequest;

public class PetAssembler {
	public static Pelicula assemblerPetFrom(HttpServletRequest req) {

		Pelicula mascota = new Pelicula();

		String namePet = req.getParameter("namePet");
		String codPersona = req.getParameter("codPersona");

		
		if (codPersona != null) {
			mascota.setCod(Integer.parseInt(codPersona));
		}
		//mascota.setNomMascota(namePet);

		return mascota;

	}

}
