package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.ActorAssembler;
import es.salesianos.repository.ActoresRepository;
import service.Service;

public class EditarPersona extends HttpServlet{
	
	private Service servicio = new Service();
	private ActoresRepository repo = new ActoresRepository();
	private ActorAssembler personaAssembler = new ActorAssembler();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Actor personaFormulario = personaAssembler.assembleUserFrom(req);
		//Actor personaEnDatabase = servicio.searchOnePerson(personaFormulario.getCodPersona());
		//req.setAttribute("personaEditar", personaEnDatabase);
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editar.jsp");
		dispatcher.forward(req, resp);
	}
}
