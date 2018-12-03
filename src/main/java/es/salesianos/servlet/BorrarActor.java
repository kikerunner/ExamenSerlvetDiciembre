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

public class BorrarActor extends HttpServlet {
	
	Service servicio = new Service();
	Actor actorEnDatabase = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Actor actorFormulario = ActorAssembler.assembleUserFrom(req);
		System.out.println(actorFormulario.getCod());
		Actor actorEnDatabase = servicio.searchOnePerson(actorFormulario.getCod());
		req.setAttribute("personaBorrar", actorEnDatabase);
		servicio.borrarActor(actorEnDatabase);
		redirect(req, resp);
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListarActores.jsp");
		dispatcher.forward(req, resp);
	}
}
