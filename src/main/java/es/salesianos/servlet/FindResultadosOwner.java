package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import service.Service;

public class FindResultadosOwner extends HttpServlet {
	
	private Service servicio = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ano1 = (String) req.getParameter("ano1");
		String ano2 = (String) req.getParameter("ano2");
		List<Actor> listActores = servicio.findActoresBetweenYear(Integer.parseInt(ano1), Integer.parseInt(ano2));
		req.setAttribute("listResultados", listActores);
		System.out.println(listActores);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FindActorBetweenYear.jsp");
		dispatcher.forward(req, resp);
	}
}
