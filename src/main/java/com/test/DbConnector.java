package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.test.util.*;

public class DbConnector {

	public static void main(String args[]) throws ClassNotFoundException,
			SQLException {
		Connection con = null;

		Class.forName(DatabasePropertyReader.getDriverName());

		// Create the connection using the static getConnection method
		con = DriverManager.getConnection(DatabasePropertyReader
				.getDatabasUrl());
		System.out.println("create connection successfully");
		
		Statement stmt = con.createStatement();
		stmt.executeQuery(DatabasePropertyReader.getTrySql());
		System.out.println("execute query successfully");

	}
}
