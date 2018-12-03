package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Pelicula;
import es.salesianos.repository.PeliRepository;

public class InsertarPelicula extends HttpServlet{
	
	PeliRepository repository = new PeliRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		Pelicula pelicula = new Pelicula();
		pelicula.setTitle((req.getParameter("title")));
		pelicula.setCodOwner(Integer.parseInt(req.getParameter("codowner")));
		repository.insertPelicula(pelicula);
		redirect(req, resp, "/ListarPeliculas.jsp");
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}

}
