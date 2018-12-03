package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.Director;
import es.salesianos.repository.ActoresRepository;
import es.salesianos.repository.DirectoresRepository;

public class InsertarDirector extends HttpServlet{
	
	DirectoresRepository repository = new DirectoresRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		Director director = new Director();
		director.setName((req.getParameter("name")));
		repository.insertDirector(director);
		redirect(req, resp, "/ListarDirectores.jsp");
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}

}
