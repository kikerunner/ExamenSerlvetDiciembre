package es.salesianos.model;

import javax.servlet.http.HttpServletRequest;

public class ActorAssembler {

	public static Actor assembleUserFrom(HttpServletRequest req) {

		Actor actor = new Actor();
		String codActor = req.getParameter("cod");
		String name = req.getParameter("name");
		int yearofbirthdate = Integer.parseInt(req.getParameter("yearofbirthdate"));
		
		if (codActor != null) {
			actor.setCod(Integer.parseInt(codActor));
		}
		actor.setName(name);
		actor.setYearofbirthdate(yearofbirthdate);

		return actor;

	}

}
