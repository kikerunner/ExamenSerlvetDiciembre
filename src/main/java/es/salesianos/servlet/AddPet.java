package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Actor;
import es.salesianos.model.ActorAssembler;
import es.salesianos.model.Pelicula;
import es.salesianos.model.PetAssembler;
import es.salesianos.repository.ActoresRepository;
import es.salesianos.repository.PeliRepository;
import service.Service;

public class AddPet extends HttpServlet{
	
	PeliRepository repository = new PeliRepository();
	Service servicio = new Service();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Actor personaEnFormulario = ActorAssembler.assembleUserFrom(req);
		//Actor personaEnDatabase = servicio.searchOnePerson(personaEnFormulario.getCodPersona());
		//req.setAttribute("ownerPet", personaEnDatabase);
		redirect(req,resp, "/addPet.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
	//	Pelicula mascota = PetAssembler.assemblerPetFrom(req);
	//	repository.insertPet(mascota);
		redirect(req, resp, "/insertarPet.jsp");
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}
	
}
