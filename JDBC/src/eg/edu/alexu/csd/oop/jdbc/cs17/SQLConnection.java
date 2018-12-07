package eg.edu.alexu.csd.oop.jdbc.cs17;

import java.sql.SQLException;

import eg.edu.alexu.csd.oop.jdbc.Connection;
import eg.edu.alexu.csd.oop.jdbc.Statement;

public class SQLConnection implements Connection {
	String path;

	public SQLConnection(String path) {
		this.path = path;
	}

	@Override
	public Statement createStatement() throws SQLException {
		// TODO Auto-generated method stub
		Statement statement=new SQLStatement(this);
		return statement;
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub

	}

}
