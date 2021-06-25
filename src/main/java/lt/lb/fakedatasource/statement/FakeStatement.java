package lt.lb.fakedatasource.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lt.lb.fakedatasource.FakeConnection;
import lt.lb.fakedatasource.FakeResultSet;
import lt.lb.fakedatasource.FakeWrapper;

/**
 *
 * @author laim0nas100
 */
public class FakeStatement extends FakeWrapper implements Statement{
    
    
    public int maxFieldSize = Integer.MAX_VALUE - 8;
    
    public boolean closed = false;
   
    public int rowsChanged = 0;
    public int maxRows = 1000;
    public boolean escapeProcessing = false;
    public int queryTimeout = 10000;
    public boolean cancelled = false;
    
    public SQLWarning warning = null;
    public String cursorName = "FakeCursorName";
    
    public int updateCount = 0;
    public boolean poolable = false;
    
    
    public FakeResultSet set;
    public Connection con;
    
    protected boolean closeOnCompletion = false;
    
    protected List<String> batch = new ArrayList<>();

    public FakeStatement(Connection con) throws SQLException {
        set = FakeResultSet.empty(this);
        this.con = con;
        
    }
    
    
    
    @Override
    public ResultSet executeQuery(String string) throws SQLException {
        return FakeResultSet.empty(this);
    }

    @Override
    public int executeUpdate(String string) throws SQLException {
        return rowsChanged;
    }

    @Override
    public void close() throws SQLException {
        closed = true;
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        return maxFieldSize;
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {
        maxFieldSize = max;
    }

    @Override
    public int getMaxRows() throws SQLException {
        return this.maxRows;
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        this.maxRows = max;
    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {
        this.escapeProcessing = enable;
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        return queryTimeout;
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        this.queryTimeout = seconds;
    }

    @Override
    public void cancel() throws SQLException {
        this.cancelled = true;
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return set.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        this.set.clearWarnings();
    }

    @Override
    public void setCursorName(String string) throws SQLException {
        cursorName = string;
    }

    @Override
    public boolean execute(String string) throws SQLException {
        return true;
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return set;
    }

    @Override
    public int getUpdateCount() throws SQLException {
        return updateCount;
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        return false;
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
       set.setFetchDirection(direction);
    }

    @Override
    public int getFetchDirection() throws SQLException {
        return set.getFetchDirection();
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
       set.setFetchSize(rows);
    }

    @Override
    public int getFetchSize() throws SQLException {
        return set.getFetchSize();
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        return set.getConcurrency();
    }

    @Override
    public int getResultSetType() throws SQLException {
        return set.getType();
        
    }

    @Override
    public void addBatch(String string) throws SQLException {
        batch.add(string);
    }

    @Override
    public void clearBatch() throws SQLException {
        batch.clear();
    }

    @Override
    public int[] executeBatch() throws SQLException {
        return batch.stream().mapToInt(s->0).toArray();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return con;
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        return false;
        
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        return FakeResultSet.empty(this);
    }

    @Override
    public int executeUpdate(String string, int i) throws SQLException {
        return 0;
        
    }

    @Override
    public int executeUpdate(String string, int[] ints) throws SQLException {
        return 0;
    }

    @Override
    public int executeUpdate(String string, String[] strings) throws SQLException {
        return 0;
    }

    @Override
    public boolean execute(String string, int i) throws SQLException {
        return true;
    }

    @Override
    public boolean execute(String string, int[] ints) throws SQLException {
        return true;
    }

    @Override
    public boolean execute(String string, String[] strings) throws SQLException {
        return true;
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return set.getHoldability();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return closed;
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {
        this.poolable = poolable;
    }

    @Override
    public boolean isPoolable() throws SQLException {
        return poolable;
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        closeOnCompletion = true;
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return closeOnCompletion;
    }

}
