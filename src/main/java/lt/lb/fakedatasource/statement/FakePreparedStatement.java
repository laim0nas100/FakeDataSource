package lt.lb.fakedatasource.statement;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import lt.lb.fakedatasource.FakeParameterMetaData;

/**
 *
 * @author laim0nas100
 */
public class FakePreparedStatement extends FakeStatement implements PreparedStatement {

    public FakeParameterMetaData paramMeta = new FakeParameterMetaData();

    public FakePreparedStatement(Connection con) throws SQLException {
        super(con);
    }


    @Override
    public ResultSet executeQuery() throws SQLException {
        return set;
    }

    @Override
    public int executeUpdate() throws SQLException {
        return 0;
    }

    @Override
    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        set.updateNull(parameterIndex);
    }

    @Override
    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        set.updateBoolean(parameterIndex, x);
    }

    @Override
    public void setByte(int parameterIndex, byte x) throws SQLException {
        set.updateByte(parameterIndex, x);
    }

    @Override
    public void setShort(int parameterIndex, short x) throws SQLException {
        set.updateShort(parameterIndex, x);
    }

    @Override
    public void setInt(int parameterIndex, int x) throws SQLException {
        set.updateInt(parameterIndex, x);
    }

    @Override
    public void setLong(int parameterIndex, long x) throws SQLException {
        set.updateLong(parameterIndex, x);
    }

    @Override
    public void setFloat(int parameterIndex, float x) throws SQLException {
        set.updateFloat(parameterIndex, x);
    }

    @Override
    public void setDouble(int parameterIndex, double x) throws SQLException {
        set.updateDouble(parameterIndex, x);
    }

    @Override
    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        set.updateBigDecimal(parameterIndex, x);
    }

    @Override
    public void setString(int parameterIndex, String x) throws SQLException {
        set.updateString(parameterIndex, x);
    }

    @Override
    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        set.updateBytes(parameterIndex, x);
    }

    @Override
    public void setDate(int parameterIndex, Date x) throws SQLException {
        set.updateDate(parameterIndex, x);
    }

    @Override
    public void setTime(int parameterIndex, Time x) throws SQLException {
        set.updateTime(parameterIndex, x);
    }

    @Override
    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        set.updateTimestamp(parameterIndex, x);
    }

    @Override
    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        set.updateAsciiStream(parameterIndex, x, length);
    }

    @Override
    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
        set.updateBinaryStream(parameterIndex, x, length);
    }

    @Override
    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        set.updateBinaryStream(parameterIndex, x, length);
    }

    @Override
    public void clearParameters() throws SQLException {
        paramMeta.params.clear();
    }

    @Override
    public void setObject(int parameterIndex, Object o, int parameterIndex1) throws SQLException {
        set.updateObject(parameterIndex, o, parameterIndex1);
    }

    @Override
    public void setObject(int parameterIndex, Object o) throws SQLException {
        set.updateObject(parameterIndex, o);
    }

    @Override
    public boolean execute() throws SQLException {
        return true;
    }

    @Override
    public void addBatch() throws SQLException {

    }

    @Override
    public void setCharacterStream(int parameterIndex, Reader x, int length) throws SQLException {
        set.updateCharacterStream(parameterIndex, x, length);
    }

    @Override
    public void setRef(int parameterIndex, Ref x) throws SQLException {
        set.updateRef(parameterIndex, x);
    }

    @Override
    public void setBlob(int parameterIndex, Blob x) throws SQLException {
        set.updateBlob(parameterIndex, x);
    }

    @Override
    public void setClob(int parameterIndex, Clob x) throws SQLException {
        set.updateClob(parameterIndex, x);
    }

    @Override
    public void setArray(int parameterIndex, Array x) throws SQLException {
        set.updateArray(parameterIndex, x);
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        return set.getMetaData();
    }

    @Override
    public void setDate(int parameterIndex, Date date, Calendar clndr) throws SQLException {
        set.updateDate(parameterIndex, date);
    }

    @Override
    public void setTime(int parameterIndex, Time time, Calendar clndr) throws SQLException {
        set.updateTime(parameterIndex, time);
    }

    @Override
    public void setTimestamp(int parameterIndex, Timestamp tmstmp, Calendar clndr) throws SQLException {
        set.updateTimestamp(parameterIndex, tmstmp);
    }

    @Override
    public void setNull(int parameterIndex, int sqlType, String string) throws SQLException {
        set.updateNull(parameterIndex);
    }

    @Override
    public void setURL(int parameterIndex, URL x) throws SQLException {
        set.updateString(parameterIndex, String.valueOf(x));
    }

    @Override
    public ParameterMetaData getParameterMetaData() throws SQLException {
        return paramMeta;
    }

    @Override
    public void setRowId(int parameterIndex, RowId x) throws SQLException {
        set.updateRowId(parameterIndex, x);
    }

    @Override
    public void setNString(int parameterIndex, String x) throws SQLException {
        set.updateNString(parameterIndex, x);
    }

    @Override
    public void setNCharacterStream(int parameterIndex, Reader x, long length) throws SQLException {
        set.updateNCharacterStream(parameterIndex, x, length);
    }

    @Override
    public void setNClob(int parameterIndex, NClob x) throws SQLException {
        set.updateNClob(parameterIndex, x);
    }

    @Override
    public void setClob(int parameterIndex, Reader x, long length) throws SQLException {
        set.updateClob(parameterIndex, x, length);
    }

    @Override
    public void setBlob(int parameterIndex, InputStream x, long length) throws SQLException {
        set.updateBlob(parameterIndex, x, length);
    }

    @Override
    public void setNClob(int parameterIndex, Reader x, long length) throws SQLException {
        set.updateNClob(parameterIndex, x, length);
    }

    @Override
    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
        set.updateSQLXML(parameterIndex, xmlObject);
    }

    @Override
    public void setObject(int parameterIndex, Object o, int targetSqlType, int scaleOrLength) throws SQLException {
        set.updateObject(parameterIndex, o, scaleOrLength);
    }

    @Override
    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
        set.updateAsciiStream(parameterIndex, x, length);
    }

    @Override
    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
        set.updateBinaryStream(parameterIndex, x, length);
    }

    @Override
    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
        set.updateCharacterStream(parameterIndex, reader, length);
    }

    @Override
    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
        set.updateAsciiStream(parameterIndex, x);
    }

    @Override
    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
        set.updateBinaryStream(parameterIndex, x);
    }

    @Override
    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
        set.updateCharacterStream(parameterIndex, reader);
    }

    @Override
    public void setNCharacterStream(int parameterIndex, Reader reader) throws SQLException {
        set.updateNCharacterStream(parameterIndex, reader);
    }

    @Override
    public void setClob(int parameterIndex, Reader reader) throws SQLException {
        set.updateClob(parameterIndex, reader);
    }

    @Override
    public void setBlob(int parameterIndex, InputStream in) throws SQLException {
        set.updateBlob(parameterIndex, in);
    }

    @Override
    public void setNClob(int parameterIndex, Reader reader) throws SQLException {
        set.updateNClob(parameterIndex, reader);
    }

}
