package es.salesianos.model;

import javax.servlet.http.HttpServletRequest;

public class PersonaAssembler {

	public static Actor assembleUserFrom(HttpServletRequest req) {

		Actor persona = new Actor();
		String codPersona = req.getParameter("codPersona");
		String name = req.getParameter("name");
		String apellido = req.getParameter("apellido");
		
		if (codPersona != null) {
			persona.setCod(Integer.parseInt(codPersona));
		}
		persona.setName(name);
	//	persona.setApellido(apellido);

		return persona;

	}

}
