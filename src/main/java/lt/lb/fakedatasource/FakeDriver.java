package lt.lb.fakedatasource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 *
 * @author laim0nas100
 */
public class FakeDriver implements Driver {

    public static final Logger logger = Logger.getLogger("FakeDriverLogger");
    public int majorVersion = 1;
    public int minorVersion = 0;
    public boolean jdbcCompliant = true;
    public DatabaseMetaData databaseMeta;

    public Properties conProp = new Properties();

    public FakeDriver() {
        databaseMeta = new FakeDatabaseMetaData(() -> {
            try {
                return connect(databaseMeta.getURL(), conProp);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    @Override
    public Connection connect(String url, java.util.Properties info) throws SQLException {
        FakeConnection fakeConnection = new FakeConnection(databaseMeta);
        fakeConnection.passedProperties = info;
        fakeConnection.passedURL = url;
        return fakeConnection;
    }

    @Override
    public boolean acceptsURL(String string) throws SQLException {
        return true;
    }

    public DriverPropertyInfo[] drivePropertyInfo = new DriverPropertyInfo[0];

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String string, Properties prprts) throws SQLException {
        return drivePropertyInfo;
    }

    @Override
    public int getMajorVersion() {
        return majorVersion;
    }

    @Override
    public int getMinorVersion() {
        return minorVersion;
    }

    @Override
    public boolean jdbcCompliant() {
        return jdbcCompliant;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return logger;
    }

}
