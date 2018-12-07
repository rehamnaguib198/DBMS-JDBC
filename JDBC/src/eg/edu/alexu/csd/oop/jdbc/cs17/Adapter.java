package eg.edu.alexu.csd.oop.jdbc.cs17;

import java.sql.SQLException;
import java.util.Properties;

import eg.edu.alexu.csd.oop.jdbc.Connection;
import eg.edu.alexu.csd.oop.jdbc.Driver;

public class Adapter implements JdbcAPI {
	Driver driver;
	public Adapter(String type) {
		if(type.equalsIgnoreCase("sql")) {
			driver=new SQLDriver();
		}
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO Auto-generated method stub
		return driver.acceptsURL(url);
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return driver.connect(url, info);
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return driver.getPropertyInfo(url, info);
	}

}
