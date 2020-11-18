package fr.seedle.pandora.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Datas {

	public Connection getConnection() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			// Fonctionnement avec écriture sur disque dur
			// DriverManager.getConnection("jdbc:hsqldb:file:database", "sa", "");

			// Fonctionnement exclusivement en mémoire
			Connection connexion = DriverManager.getConnection("jdbc:hsqldb:mem:database", "sa", "");
			return connexion;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createSequence() throws SQLException {
		Connection connexion = getConnection();
		Statement statement = connexion.createStatement();
		statement.executeUpdate("CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1");
		statement.close();
		closeConnection(connexion);
	}

	public void createTableMembre() throws SQLException {
		Connection connexion = getConnection();
		Statement statement = connexion.createStatement();
		statement.executeUpdate(
				"CREATE TABLE membre(id bigint, role_id bigint, nom varchar(100),avatar varchar(100),prenom varchar(100), pseudo varchar(100), login varchar(100), email varchar(100),\n"
						+ " mobile varchar(100), dateNaissance timestamp, isLeader boolean)");
		statement.close();
		closeConnection(connexion);
	}

	public void createTableRoleMembre() throws SQLException {
		Connection connexion = getConnection();
		Statement statement = connexion.createStatement();
		statement.executeUpdate("CREATE TABLE ROLE_MEMBRE(RoleDto_id bigint, listMembres_id bigint)");
		statement.close();
		closeConnection(connexion);
	}

	public void createTableRole() throws SQLException {
		Connection connexion = getConnection();
		Statement statement = connexion.createStatement();
		statement.executeUpdate("CREATE TABLE role(id bigint,nom varchar(100))");
		statement.close();
		closeConnection(connexion);
	}
}