package com.mysql.jdbc.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

	/**
	 * @author Florian
	 */
	
	
	
	/**
	 * @param Connection; Saves the MySQL Connection.
	 */
	private static Connection Connection;

	
	
	/**
	 * @param  Host, Port, Database, User, Password; Need to Connect to the MySQL Database.
	 * @throws SQLException
	 * @method Connect(); Connect to the MySQL Database with the params.
	 */
	public static void Connect(String Host, String Port, String Database, String User, String Password) throws SQLException {
		if (!isConnected()) {
			Connection = DriverManager.getConnection("jdbc:mysql://" + Host + ":" + Port + "/" + Database + "?autoReconnect=true", User, Password);
		}
	}
	
	
	
	/**
	 * @throws SQLException
	 * @method Close(); Close the Connection to the Database.
	 */
	public static void Close() throws SQLException {
		if (isConnected()) {
			Connection.close();
			Connection = null;
		}
	}

	
	
	/**
	 * @method isConnected(); Check if the MySQL.Connection Class is null or not.
	 * @return MySQL.Connection != null;
	 */
	public static boolean isConnected() {
		return Connection != null;
	}

	
	
	/**
	 * @param  Query; Is the Query Command that will executed.
	 * @throws SQLException
	 * @method executeCommand(); Query the Command.
	 */
	public static void executeCommand(String Query) throws SQLException {
		if (isConnected()) {
			Connection.createStatement().executeUpdate(Query);
		}
	}

	
	
	/**
	 * @param  Query; Is the Query Command that will executed.
	 * @throws SQLException
	 * @method toResult(); Return the Query-Result.
	 * @return MySQL.Connection.createStatement().executeQuery(Query);
	 */
	public static ResultSet toResult(String Query) throws SQLException {
		if (isConnected()) {
			return Connection.createStatement().executeQuery(Query);
		}
		return null;
	}

	
}