package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Mascota;
import es.salesianos.model.Actor;

public class ActoresRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();


	public void insert(Actor actor) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO ACTOR(NAME,YEAROFBIRTHDATE) VALUES (?, ?)");
			preparedStatement.setString(1, actor.getName());
			preparedStatement.setInt(2, actor.getYearofbirthdate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
	}
	
	public void insertPet(Mascota mascota) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO MASCOTAS(nomMascota,CodPersona) VALUES (?, ?)");
			preparedStatement.setString(1, mascota.getNomMascota());
			preparedStatement.setInt(2, mascota.getCodPersona());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
	}
	
	public List<Actor>searchAll() {
		List<Actor> actores = new ArrayList<Actor>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM Actor");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Actor actorInDatabase = new Actor();
				actorInDatabase.setCod(resultSet.getInt(1));
				actorInDatabase.setName(resultSet.getString(2));
				actorInDatabase.setYearofbirthdate((resultSet.getInt(3)));
				
				actores.add(actorInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
		return actores;
		
	}
	
	public Actor selectOnePerson(int CodPersona) {
		Actor personaInDatabase = null;
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM Personas WHERE CodPersona = ?");
			preparedStatement.setInt(1, CodPersona);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				personaInDatabase = new Actor();
			//	personaInDatabase.setCodPersona(resultSet.getInt(1));
				personaInDatabase.setName(resultSet.getString(2));
			//	personaInDatabase.setApellido(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
		return personaInDatabase;
	}
	
	public void updatePerson(Actor persona) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("UPDATE Personas SET nombre = ?, apellido = ? WHERE CodPersona = ?");
			preparedStatement.setString(1, persona.getName());
		//	preparedStatement.setString(2, persona.getApellido());
		//	preparedStatement.setInt(3, persona.getCodPersona());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		
	}
	
	public void borrarActor(Actor persona) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("DELETE FROM Actor WHERE CodPersona = ?");	
			preparedStatement.setInt(1, persona.getCod());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
}
