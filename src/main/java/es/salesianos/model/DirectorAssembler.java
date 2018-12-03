package es.salesianos.model;

import javax.servlet.http.HttpServletRequest;

public class DirectorAssembler {

	public static Director assembleUserFrom(HttpServletRequest req) {

		Director director = new Director();
		String codDirector = req.getParameter("cod");
		String name = req.getParameter("name");
		
		if (codDirector != null) {
			director.setCod(Integer.parseInt(codDirector));
		}
		director.setName(name);
		

		return director;

	}

}
