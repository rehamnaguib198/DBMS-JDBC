package eg.edu.alexu.csd.oop.jdbc.cs17;

import java.sql.SQLException;
import java.util.ArrayList;

import eg.edu.alexu.csd.oop.jdbc.Connection;
import eg.edu.alexu.csd.oop.jdbc.Resultset;
import eg.edu.alexu.csd.oop.jdbc.Statement;

public class SQLStatement implements Statement{
	ArrayList<String> commands=new ArrayList<>();
	Connection connection;
	public SQLStatement(Connection con) {
		this.connection=con;
	}

	@Override
	public void addBatch(String sql) throws SQLException {
		commands.add(sql);
	}

	@Override
	public void clearBatch() throws SQLException {
		commands.clear();
		
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] executeBatch() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultset executeQuery(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executeUpdate(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getQueryTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setQueryTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
