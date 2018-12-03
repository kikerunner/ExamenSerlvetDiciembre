package es.salesianos.model;

import javax.servlet.http.HttpServletRequest;

public class PeliculaAssembler {

	public static Pelicula assembleUserFrom(HttpServletRequest req) {

		Pelicula pelicula = new Pelicula();
		String codPelicula = req.getParameter("cod");
		String title = req.getParameter("title");
		String codOwner = req.getParameter("codowner");
		
		if (codPelicula != null) {
			pelicula.setCod(Integer.parseInt(codPelicula));
		}
		pelicula.setTitle(title);
		
		if (codOwner != null) {
			Integer.parseInt(req.getParameter("codowner"));
		}

		return pelicula;

	}

}
