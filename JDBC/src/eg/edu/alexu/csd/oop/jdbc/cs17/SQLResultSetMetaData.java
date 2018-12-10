package eg.edu.alexu.csd.oop.jdbc.cs17;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import eg.edu.alexu.csd.oop.db.cs11.DBMS;

public class SQLResultSetMetaData implements ResultSetMetaData {
	private String tableName;
	private Log log=new Log();
	public SQLResultSetMetaData(String tableName) {
		this.tableName=tableName;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCatalogName(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnClassName(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnCount() throws SQLException {
		DBMS db=new DBMS();
		ArrayList<String> columns=db.selectedColumns();
		log.getLogger().info("number of columns returned successfully!");
		return columns.size();
	}

	@Override
	public int getColumnDisplaySize(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnLabel(int arg0) throws SQLException {
		DBMS db=new DBMS();
		ArrayList<String> columns=db.selectedColumns();
		String columnName=columns.get(arg0);
		log.getLogger().info("column label returned successfully!");
		return columnName;
	}

	@Override
	public String getColumnName(int arg0) throws SQLException {
		DBMS db=new DBMS();
		ArrayList<String> columns=db.selectedColumns();
		String columnName=columns.get(arg0);
		log.getLogger().info("column name returned successfully!");
		return columnName;
	}

	@Override
	public int getColumnType(int arg0) throws SQLException {
		DBMS db=new DBMS();
		ArrayList<String> columns=db.selectedColumns();
		String columnName=columns.get(arg0);
		HashMap<String,String> xsdMap=new HashMap<>();
		xsdMap=db.getXSDMap(tableName);
		String xsdType = null;
		for(Entry<String,String> entry:xsdMap.entrySet()) {
			if(entry.getKey().equalsIgnoreCase(columnName)) {
				xsdType=entry.getValue();
			}
		}
		String[] arr=xsdType.split(":");
		String type=arr[1];
		if(type.equals("varchar")){
			log.getLogger().info("column type returned successfully!");
		return 12;
		}
		else{
			log.getLogger().info("column type returned successfully!");
		return 4;
		}
	}

	@Override
	public String getColumnTypeName(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPrecision(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScale(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSchemaName(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableName(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		log.getLogger().info("table name returned successfully!");
		return tableName;
	}

	@Override
	public boolean isAutoIncrement(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCaseSensitive(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCurrency(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDefinitelyWritable(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int isNullable(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isReadOnly(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSearchable(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSigned(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWritable(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}