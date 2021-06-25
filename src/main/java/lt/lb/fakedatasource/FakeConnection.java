package lt.lb.fakedatasource;

import lt.lb.fakedatasource.statement.FakePreparedStatement;
import lt.lb.fakedatasource.statement.FakeStatement;
import lt.lb.fakedatasource.statement.FakeCallableStatement;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import lt.lb.fakedatasource.structure.FakeArray;
import lt.lb.fakedatasource.structure.FakeBlob;
import lt.lb.fakedatasource.structure.FakeClob;
import lt.lb.fakedatasource.structure.FakeNClob;
import lt.lb.fakedatasource.structure.FakeSQLXML;
import lt.lb.fakedatasource.structure.FakeStruct;

/**
 *
 * @author laim0nas100
 */
public class FakeConnection extends FakeWrapper implements Connection {

    protected List<Statement> statements = new ArrayList<>();
    public boolean autoCommit = false;
    public boolean closed = false;
    public DatabaseMetaData databaseMeta;
    public boolean readOnly = false;
    public String catalog;
    public int transactionIsolation;

    public Map<String, Class<?>> typeMap = new HashMap<>();

    public int holdability;

    public Savepoint savepoint;

    public Properties clientInfo = new Properties();
    

    public String schema;
    public int networkTimeout = 1000;
    
    public Properties passedProperties = new Properties();
    public String passedURL = "";

    public FakeConnection(DatabaseMetaData databaseMeta) {
        this.databaseMeta = databaseMeta;
    }
    
    

    public static class FakeSavepoint implements Savepoint {

        public static AtomicInteger staticID = new AtomicInteger(0);
        public int id = staticID.getAndIncrement();
        public String name = "FakeSavePoint" + id;

        public FakeSavepoint(String name) {
            this.name = name;
        }

        public FakeSavepoint() {
        }

        @Override
        public int getSavepointId() throws SQLException {
            return id;
        }

        @Override
        public String getSavepointName() throws SQLException {
            return name;
        }

    }

    protected <T extends FakeStatement> T dec(T stmt) {
        statements.add(stmt);
        return stmt;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return dec(new FakeStatement(this));
    }

    @Override
    public PreparedStatement prepareStatement(String string) throws SQLException {
        return dec(new FakePreparedStatement(this));
    }

    @Override
    public CallableStatement prepareCall(String string) throws SQLException {
        return dec(new FakeCallableStatement(this));
    }

    @Override
    public String nativeSQL(String string) throws SQLException {
        return string;
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        this.autoCommit = autoCommit;
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return autoCommit;
    }

    @Override
    public void commit() throws SQLException {
        for (Statement st : statements) {
            st.close();
        }
        statements.clear();

    }

    @Override
    public void rollback() throws SQLException {
        for (Statement st : statements) {
            st.cancel();
        }
        statements.clear();
    }

    @Override
    public void close() throws SQLException {
        for (Statement st : statements) {
            st.close();
        }

        closed = true;

    }

    @Override
    public boolean isClosed() throws SQLException {
        return closed;
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return databaseMeta;
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        this.readOnly = readOnly;
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return this.readOnly;
    }

    @Override
    public void setCatalog(String string) throws SQLException {
        this.catalog = string;
    }

    @Override
    public String getCatalog() throws SQLException {
        return catalog;
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        this.transactionIsolation = level;
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return this.transactionIsolation;
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        for (Statement st : statements) {
            if (st.getWarnings() != null) {
                return st.getWarnings();
            }
        }
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {
        for (Statement st : statements) {
            st.clearWarnings();
        }
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        FakeStatement dec = dec(new FakeStatement(this));
        dec.set.concurrency = resultSetConcurrency;
        dec.set.type = resultSetType;
        return dec;
    }

    @Override
    public PreparedStatement prepareStatement(String string, int resultSetType, int resultSetConcurrency) throws SQLException {
        FakePreparedStatement dec = dec(new FakePreparedStatement(this));
        dec.set.concurrency = resultSetConcurrency;
        dec.set.type = resultSetType;
        return dec;
    }

    @Override
    public CallableStatement prepareCall(String string, int resultSetType, int resultSetConcurrency) throws SQLException {
        FakeCallableStatement dec = dec(new FakeCallableStatement(this));
        dec.set.concurrency = resultSetConcurrency;
        dec.set.type = resultSetType;
        return dec;
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return typeMap;
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        typeMap = map;
    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        this.holdability = holdability;
    }

    @Override
    public int getHoldability() throws SQLException {
        return this.holdability;
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        FakeSavepoint fakeSavepoint = new FakeSavepoint();
        this.savepoint = fakeSavepoint;
        return fakeSavepoint;
    }

    @Override
    public Savepoint setSavepoint(String string) throws SQLException {
        FakeSavepoint fakeSavepoint = new FakeSavepoint(string);
        this.savepoint = fakeSavepoint;
        return fakeSavepoint;
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {

    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        FakeStatement dec = dec(new FakeStatement(this));
        dec.set.concurrency = resultSetConcurrency;
        dec.set.type = resultSetType;
        dec.set.holdability = resultSetType;
        return dec;
    }

    @Override
    public PreparedStatement prepareStatement(String string, int resultSetType,
            int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        FakePreparedStatement dec = dec(new FakePreparedStatement(this));
        dec.set.concurrency = resultSetConcurrency;
        dec.set.type = resultSetType;
        dec.set.holdability = resultSetType;
        return dec;

    }

    @Override
    public CallableStatement prepareCall(String string, int resultSetType,
            int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        FakeCallableStatement dec = dec(new FakeCallableStatement(this));
        dec.set.concurrency = resultSetConcurrency;
        dec.set.type = resultSetType;
        dec.set.holdability = resultSetType;
        return dec;
    }

    @Override
    public PreparedStatement prepareStatement(String string, int autoGeneratedKeys) throws SQLException {
        FakePreparedStatement dec = dec(new FakePreparedStatement(this));
        return dec;
    }

    @Override
    public PreparedStatement prepareStatement(String string, int[] columnIndexes) throws SQLException {
        FakePreparedStatement dec = dec(new FakePreparedStatement(this));
        return dec;
    }

    @Override
    public PreparedStatement prepareStatement(String string, String[] columnNames) throws SQLException {
        FakePreparedStatement dec = dec(new FakePreparedStatement(this));
        return dec;
    }

    @Override
    public Clob createClob() throws SQLException {
        return new FakeClob();
    }

    @Override
    public Blob createBlob() throws SQLException {
        return new FakeBlob();
    }

    @Override
    public NClob createNClob() throws SQLException {
        return new FakeNClob();
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return new FakeSQLXML();
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        return true; // always valid
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        clientInfo.setProperty(name, value);
    }

    @Override
    public void setClientInfo(Properties prprts) throws SQLClientInfoException {
        clientInfo = prprts;
    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        return clientInfo.getProperty(name);
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return clientInfo;
    }

    @Override
    public Array createArrayOf(String string, Object[] os) throws SQLException {
        FakeArray fakeArray = new FakeArray();
        fakeArray._fakeCon = this;
        fakeArray.baseType = SqlTypes.resolveSqlTypeFromName(string);
        fakeArray.list.addAll(Arrays.asList(os));
        return fakeArray;
    }

    @Override
    public Struct createStruct(String string, Object[] os) throws SQLException {
        FakeStruct struct = new FakeStruct();
        struct.sqlTypeName = string;
        struct.attributes = os;
        return struct;
    }

    @Override
    public void setSchema(String string) throws SQLException {
        this.schema = string;
    }

    @Override
    public String getSchema() throws SQLException {
        return this.schema;
    }

    @Override
    public void abort(Executor exctr) throws SQLException {

    }

    @Override
    public void setNetworkTimeout(Executor exctr, int networkTimeout) throws SQLException {
        this.networkTimeout = networkTimeout;
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return networkTimeout;
    }

}
