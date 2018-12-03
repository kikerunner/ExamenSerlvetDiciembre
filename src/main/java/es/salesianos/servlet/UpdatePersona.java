package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.ActorAssembler;
import service.Service;

public class UpdatePersona extends HttpServlet{
	
	private Service servicio = new Service();
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Actor persona = ActorAssembler.assembleUserFrom(req);
		//System.out.println(persona.getCodPersona());
		System.out.println(persona.getName());
		//System.out.println(persona.getApellido());
		servicio.updatePerson(persona);	
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updatePersona.jsp");
		dispatcher.forward(req, resp);
	}

}
