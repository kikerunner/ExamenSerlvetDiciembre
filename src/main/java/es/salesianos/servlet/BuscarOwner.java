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

public class BuscarOwner extends HttpServlet {
	
	private Service servicio = new Service();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ano1 = (String) req.getParameter("namePet");
		String ano2 = (String) req.getParameter("namePet");
		Actor listDuenos = servicio.findOwnerByPet(namePet);
		req.setAttribute("listDuenos", listDuenos);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FindOwnerByPet.jsp");
		dispatcher.forward(req, resp);
	}
}
