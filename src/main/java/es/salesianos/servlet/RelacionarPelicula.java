package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Pelicula;
import es.salesianos.model.ActorAssembler;
import es.salesianos.model.Pelicula;
import es.salesianos.model.PeliculaAssembler;
import service.Service;

public class RelacionarPelicula extends HttpServlet {
	
	Service servicio = new Service();
	Pelicula peliculaEnDatabase = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pelicula peliculaFormulario = PeliculaAssembler.assembleUserFrom(req);
		Pelicula peliculaEnDatabase = servicio.searchOnePelicula(peliculaFormulario.getCod());
		req.setAttribute("peliculaAAsociar", peliculaEnDatabase);
		servicio.listOnePelicula(peliculaEnDatabase);
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AsociarActor.jsp");
		dispatcher.forward(req, resp);
	}
}
