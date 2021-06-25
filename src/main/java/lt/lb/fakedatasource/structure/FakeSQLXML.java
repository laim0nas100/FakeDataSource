package lt.lb.fakedatasource.structure;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.SQLXML;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

/**
 *
 * @author laim0nas100
 */
public class FakeSQLXML extends FakeClob implements SQLXML {

    public Class source = Object.class;

    @Override
    public InputStream getBinaryStream() throws SQLException {
        return getAsciiStream();
    }

    @Override
    public OutputStream setBinaryStream() throws SQLException {
        return setAsciiStream(0L);
    }

    @Override
    public Writer setCharacterStream() throws SQLException {
        return this.setCharacterStream(0L);
    }

    @Override
    public String getString() throws SQLException {
        return toString();
    }

    @Override
    public void setString(String string) throws SQLException {
        this.setString(0L, string);
    }

    @Override
    public <T extends Source> T getSource(Class<T> type) throws SQLException {
        return null;
    }

    @Override
    public <T extends Result> T setResult(Class<T> type) throws SQLException {
        return null;
    }

}
