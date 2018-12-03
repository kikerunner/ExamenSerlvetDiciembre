package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.repository.ActoresRepository;

public class InsertarActor extends HttpServlet{
	
	ActoresRepository repository = new ActoresRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		Actor actor = new Actor();
		actor.setName(req.getParameter("name"));
		actor.setYearofbirthdate(Integer.parseInt((req.getParameter("yearofbirthdate"))));
		repository.insert(actor);
		redirect(req, resp, "/insertar.jsp");
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}

}
