package eg.edu.alexu.csd.oop.jdbc.cs17;

import java.sql.SQLException;
import java.util.Properties;

import eg.edu.alexu.csd.oop.jdbc.Connection;

public interface JdbcAPI {
	public boolean acceptsURL(String url) throws SQLException;
	public Connection connect(String url, Properties info) throws SQLException;
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException;
}
