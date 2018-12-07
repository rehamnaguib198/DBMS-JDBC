package eg.edu.alexu.csd.oop.jdbc.cs17;

import java.sql.SQLException;

import eg.edu.alexu.csd.oop.jdbc.ResultSetMetaData;
import eg.edu.alexu.csd.oop.jdbc.Resultset;
import eg.edu.alexu.csd.oop.jdbc.Statement;

public class ResultSet implements Resultset {

	int currentRow;
	Object[][] t;
	int nuOfR;
	boolean closed;
	Statement statement = null;
	ResultSetMetaData metaData;

	ResultSet(Statement s, ResultSetMetaData m, Object[][] table) {
		t = table.clone();
		statement = s;
		metaData = m;
		nuOfR = t.length;
		currentRow = 0;
		closed = false;
	}

	@Override
	public boolean absolute(int row) throws SQLException {
		// TODO Auto-generated method stub
		if (closed) {
			throw new SQLException();
		}
		if (row > 0 && row <= nuOfR) {
			currentRow = row;
			return true;
		} else if (row == 0) {
			currentRow = 0;
			return false;
		} else if (row < 0 && Math.abs(row) <= nuOfR) {
			currentRow = nuOfR + row + 1;
			return true;
		} else {
			if (row < 0) {
				currentRow = 0;
			} else {
				currentRow = nuOfR + 1;
			}
			return false;
		}
	}

	@Override
	public void afterLast() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		currentRow = nuOfR + 1;
	}

	@Override
	public void beforeFirst() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		currentRow = 0;
	}

	@Override
	public void close() throws SQLException {
		closed = true;
	}

	@Override
	public int findColumn(String columnLabel) throws SQLException {
		// TODO Auto-generated method stub
		if (closed) {
			throw new SQLException();
		}
		for (int i = 0; i < t[0].length; i++) {
			// if columnLabel of i = columnLabel return i
		}
		return 0;
	}

	@Override
	public boolean first() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		return absolute(1);
	}

	@Override
	public int getInt(int columnIndex) throws SQLException {
		if (closed || currentRow == 0 || currentRow == nuOfR + 1) {
			throw new SQLException();
		}
		return (int) t[currentRow][columnIndex];
	}

	@Override
	public long getInt(String columnLabel) throws SQLException {
		if (closed || currentRow == 0 || currentRow == nuOfR + 1) {
			throw new SQLException();
		}
		return (long) t[currentRow][findColumn(columnLabel)];
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		return metaData;
	}

	@Override
	public Object getObject(int columnIndex) throws SQLException {
		if (closed || currentRow == 0 || currentRow == nuOfR + 1) {
			throw new SQLException();
		}
		return t[currentRow][columnIndex];
	}

	@Override
	public Statement getStatement() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		return statement;
	}

	@Override
	public String getString(int columnIndex) throws SQLException {
		if (closed || currentRow == 0 || currentRow == nuOfR + 1) {
			throw new SQLException();
		}
		return t[currentRow][columnIndex].toString();
	}

	@Override
	public String getString(String columnLabel) throws SQLException {
		if (closed || currentRow == 0 || currentRow == nuOfR + 1) {
			throw new SQLException();
		}
		return t[currentRow][findColumn(columnLabel)].toString();
	}

	@Override
	public boolean isAfterLast() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		return ((currentRow == nuOfR + 1) && (nuOfR != 0));
	}

	@Override
	public boolean isBeforeFirst() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		return ((currentRow == 0) && (nuOfR != 0));
	}

	@Override
	public boolean isClosed() throws SQLException {
		return closed;
	}

	@Override
	public boolean isFirst() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		return currentRow == 1;
	}

	@Override
	public boolean isLast() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		return currentRow == nuOfR;
	}

	@Override
	public boolean last() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		return absolute(-1);
	}

	@Override
	public boolean next() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		return absolute(currentRow + 1);
	}

	@Override
	public boolean previous() throws SQLException {
		if (closed) {
			throw new SQLException();
		}
		return absolute(currentRow - 1);
	}

}
