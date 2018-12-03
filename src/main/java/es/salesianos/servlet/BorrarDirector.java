package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Pelicula;
import es.salesianos.model.ActorAssembler;
import es.salesianos.model.Director;
import es.salesianos.model.DirectorAssembler;
import es.salesianos.model.Pelicula;
import es.salesianos.model.PeliculaAssembler;
import service.Service;

public class BorrarDirector extends HttpServlet {
	
	Service servicio = new Service();
	Director directorEnDatabase = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Director directorFormulario = DirectorAssembler.assembleUserFrom(req);
		Director directorEnDatabase = servicio.searchOneDirector(directorFormulario.getCod());
		req.setAttribute("directorBorrar", directorEnDatabase);
		servicio.borrarDirector(directorEnDatabase);
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListarDirectores.jsp");
		dispatcher.forward(req, resp);
	}
}
