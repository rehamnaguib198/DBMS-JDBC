package eg.edu.alexu.csd.oop.jdbc.cs17;

import java.sql.SQLException;

import eg.edu.alexu.csd.oop.jdbc.Connection;
import eg.edu.alexu.csd.oop.jdbc.Statement;

public class SQLConnection implements Connection {
	String userName;
	String path;
	String password;

	public SQLConnection(String path, String user, String pass) {
		this.path = path;
		this.userName = user;
		this.password = pass;
	}

	@Override
	public Statement createStatement() throws SQLException {
		// TODO Auto-generated method stub
		Statement statement=new SQLStatement();
		return statement;
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub

	}

}
