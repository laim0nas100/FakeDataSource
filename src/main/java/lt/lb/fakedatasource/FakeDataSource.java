package lt.lb.fakedatasource;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author laim0nas100
 */
public class FakeDataSource extends FakeWrapper implements DataSource {

    public static class NoOpWriter extends Writer {

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
        }

        @Override
        public void flush() throws IOException {
        }

        @Override
        public void close() throws IOException {
        }
    }
    public FakeDatabaseMetaData metaData;

    public FakeDataSource() {
        metaData = new FakeDatabaseMetaData(() -> {
            try {
                return getConnection();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public static final Logger logger = Logger.getLogger("FakeDataSourceLogger");

    public int loginTimeout = 100;

    @Override
    public Connection getConnection() throws SQLException {
        return new FakeConnection(metaData);
    }

    @Override
    public Connection getConnection(String user, String password) throws SQLException {
        Connection con = new FakeConnection(metaData);
        Properties prp = new Properties();
        prp.setProperty("user", user);
        prp.setProperty("password", password);
        con.setClientInfo(prp);
        return con;
    }

    public PrintWriter logWriter = new PrintWriter(new NoOpWriter());

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return logWriter;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        logWriter = out;
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        this.loginTimeout = seconds;
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return loginTimeout;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return logger;
    }

}
