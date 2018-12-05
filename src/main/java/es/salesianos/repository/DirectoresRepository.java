package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Pelicula;
import es.salesianos.model.Actor;
import es.salesianos.model.Director;

public class DirectoresRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();


	public void insertDirector(Director director) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO DIRECTOR(NAME) VALUES ( ?)");
			preparedStatement.setString(1, director.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
	}
	
	public void insertPet(Pelicula mascota) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO MASCOTAS(nomMascota,CodPersona) VALUES (?, ?)");
		//	preparedStatement.setString(1, mascota.getNomMascota());
		//	preparedStatement.setInt(2, mascota.getCodPersona());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
	}
	
	public List<Director>searchAll() {
		List<Director> directores = new ArrayList<Director>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM director");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Director directorInDatabase = new Director();
				directorInDatabase.setCod(resultSet.getInt(1));
				directorInDatabase.setName(resultSet.getString(2));
				
				directores.add(directorInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
		return directores;
		
	}
	

	
	public Director selectOneDirector(int CodDirector) {
		Director directorInDatabase = null;
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM Director WHERE Cod = ?");
			preparedStatement.setInt(1, CodDirector);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				directorInDatabase = new Director();
				directorInDatabase.setCod(resultSet.getInt(1));
				directorInDatabase.setName(resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
		return directorInDatabase;
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
	
	public void borrarDirector(Director director) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("DELETE FROM Director WHERE COD = ?");	
			preparedStatement.setInt(1, director.getCod());
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
