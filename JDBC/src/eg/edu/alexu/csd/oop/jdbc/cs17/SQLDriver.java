package eg.edu.alexu.csd.oop.jdbc.cs17;

import java.io.File;
import java.sql.SQLException;
import java.util.Properties;

import eg.edu.alexu.csd.oop.jdbc.Connection;
import eg.edu.alexu.csd.oop.jdbc.Driver;

public class SQLDriver implements Driver {

	@Override
	public boolean acceptsURL(String url) throws SQLException {
       if(url.contains("jdbc:mysql://localhost:")) { 
    	   return true;
       }
       else {
    	   return false;
       }
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		if(!acceptsURL(url)) {
			return null;
		} else {
			String userName=info.getProperty("userName");
			String password=info.getProperty("password");
			Connection con=new SQLConnection(url,userName,password);
			return con;
		}
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
