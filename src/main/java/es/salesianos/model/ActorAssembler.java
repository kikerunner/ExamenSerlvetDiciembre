package es.salesianos.model;

import javax.servlet.http.HttpServletRequest;

public class ActorAssembler {

	public static Actor assembleUserFrom(HttpServletRequest req) {

		System.out.println(req.getParameter("cod"));
		Actor actor = new Actor();
		String codActor = req.getParameter("cod");
		String name = req.getParameter("name");
		String yearofbirthdate = req.getParameter("yearofbirthdate");
		
		if (codActor != null) {
			actor.setCod(Integer.parseInt(codActor));
		}
		actor.setName(name);
		
		if (yearofbirthdate != null) {
			Integer.parseInt(req.getParameter("yearofbirthdate"));
		}

		return actor;

	}

}
