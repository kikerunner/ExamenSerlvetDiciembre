package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.Pelicula;
import service.Service;

public class ListaPeliculas extends HttpServlet{
	
	private Service servicio = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Pelicula> listAllPeliculas = servicio.listAllPeliculas();
		req.setAttribute("listAllPeliculas", listAllPeliculas);
		redirect(req,resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListarPeliculas.jsp");
		dispatcher.forward(req, resp);
	}
	

}
