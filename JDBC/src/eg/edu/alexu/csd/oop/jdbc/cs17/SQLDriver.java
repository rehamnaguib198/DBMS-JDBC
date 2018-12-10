package eg.edu.alexu.csd.oop.jdbc.cs17;

import java.io.File;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;


public class SQLDriver implements Driver {
	private Log log=new Log();


	@Override
	public boolean acceptsURL(String url) throws SQLException {
		 if(url.equals("jdbc:xmldb://localhost:")) { 
			 log.getLogger().info("Url accepted");
	    	   return true;
	       }
	       else {
	    	   log.getLogger().warning("Invalid url");
	    	   return false;
	       }
	}

	@Override
	public java.sql.Connection connect(String url, Properties info) throws SQLException {
		if(!acceptsURL(url)) {
			log.getLogger().warning("Invalid url");
			return null;
		} else {
			String path=info.getProperty("path");
			Connection con=new SQLConnection(path);
			log.getLogger().info("Connection returned successfully!");
			return con;
		}
	}

	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}
}
