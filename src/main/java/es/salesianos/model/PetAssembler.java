package es.salesianos.model;

import javax.servlet.http.HttpServletRequest;

public class PetAssembler {
	public static Mascota assemblerPetFrom(HttpServletRequest req) {

		Mascota mascota = new Mascota();

		String namePet = req.getParameter("namePet");
		String codPersona = req.getParameter("codPersona");

		
		if (codPersona != null) {
			mascota.setCodPersona(Integer.parseInt(codPersona));
		}
		mascota.setNomMascota(namePet);

		return mascota;

	}

}
