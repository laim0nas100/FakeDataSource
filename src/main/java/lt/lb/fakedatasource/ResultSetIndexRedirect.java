package lt.lb.fakedatasource;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

/**
 *
 * @author laim0nas100
 */
public interface ResultSetIndexRedirect extends ResultSet {

    @Override
    public default String getString(String string) throws SQLException {
        return getString(findColumn(string));
    }

    @Override
    public default boolean getBoolean(String string) throws SQLException {
        return getBoolean(findColumn(string));
    }

    @Override
    public default byte getByte(String string) throws SQLException {
        return getByte(findColumn(string));
    }

    @Override
    public default short getShort(String string) throws SQLException {
        return getShort(findColumn(string));
    }

    @Override
    public default int getInt(String string) throws SQLException {
        return getInt(findColumn(string));
    }

    @Override
    public default long getLong(String string) throws SQLException {
        return getLong(findColumn(string));
    }

    @Override
    public default float getFloat(String string) throws SQLException {
        return getFloat(findColumn(string));
    }

    @Override
    public default double getDouble(String string) throws SQLException {
        return getDouble(findColumn(string));
    }

    @Override
    public default BigDecimal getBigDecimal(String string, int i) throws SQLException {
        return getBigDecimal(findColumn(string), i);
    }

    @Override
    public default byte[] getBytes(String string) throws SQLException {
        return getBytes(findColumn(string));
    }

    @Override
    public default Date getDate(String string) throws SQLException {
        return getDate(findColumn(string));
    }

    @Override
    public default Time getTime(String string) throws SQLException {
        return getTime(findColumn(string));
    }

    @Override
    public default Timestamp getTimestamp(String string) throws SQLException {
        return getTimestamp(findColumn(string));
    }

    @Override
    public default InputStream getAsciiStream(String string) throws SQLException {
        return getAsciiStream(findColumn(string));
    }

    @Override
    public default InputStream getUnicodeStream(String string) throws SQLException {
        return getUnicodeStream(findColumn(string));
    }

    @Override
    public default InputStream getBinaryStream(String string) throws SQLException {
        return getBinaryStream(findColumn(string));
    }

    @Override
    public default Object getObject(String string) throws SQLException {
        return getObject(findColumn(string));
    }

    @Override
    public default Reader getCharacterStream(String string) throws SQLException {
        return getCharacterStream(findColumn(string));
    }

    @Override
    public default BigDecimal getBigDecimal(String string) throws SQLException {
        return getBigDecimal(findColumn(string));
    }

    @Override
    public default void updateNull(String string) throws SQLException {
        updateNull(findColumn(string));
    }

    @Override
    public default void updateBoolean(String string, boolean bln) throws SQLException {
        updateBoolean(findColumn(string), bln);
    }

    @Override
    public default void updateByte(String string, byte b) throws SQLException {
        updateByte(findColumn(string), b);
    }

    @Override
    public default void updateShort(String string, short s) throws SQLException {
        updateShort(findColumn(string), s);
    }

    @Override
    public default void updateInt(String string, int i) throws SQLException {
        updateInt(findColumn(string), i);
    }

    @Override
    public default void updateLong(String string, long l) throws SQLException {
        updateLong(findColumn(string), l);
    }

    @Override
    public default void updateFloat(String string, float f) throws SQLException {
        updateFloat(findColumn(string), f);
    }

    @Override
    public default void updateDouble(String string, double d) throws SQLException {
        updateDouble(findColumn(string), d);
    }

    @Override
    public default void updateBigDecimal(String string, BigDecimal bd) throws SQLException {
        updateBigDecimal(findColumn(string), bd);
    }

    @Override
    public default void updateString(String string, String string1) throws SQLException {
        updateString(findColumn(string), string1);
    }

    @Override
    public default void updateBytes(String string, byte[] bytes) throws SQLException {
        updateBytes(findColumn(string), bytes);
    }

    @Override
    public default void updateDate(String string, Date date) throws SQLException {
        updateDate(findColumn(string), date);
    }

    @Override
    public default void updateTimestamp(String string, Timestamp tmstmp) throws SQLException {
        updateTimestamp(findColumn(string), tmstmp);
    }

    @Override
    public default void updateAsciiStream(String string, InputStream in, int i) throws SQLException {
        updateAsciiStream(findColumn(string), in, i);
    }

    @Override
    public default void updateBinaryStream(String string, InputStream in, int i) throws SQLException {
        updateBinaryStream(findColumn(string), in, i);
    }

    @Override
    public default void updateCharacterStream(String string, Reader reader, int i) throws SQLException {
        updateCharacterStream(findColumn(string), reader, i);
    }

    @Override
    public default void updateObject(String string, Object o, int i) throws SQLException {
        updateObject(findColumn(string), o, i);
    }

    @Override
    public default void updateObject(String string, Object o) throws SQLException {
        updateObject(findColumn(string), o);
    }

    @Override
    public default Object getObject(String string, Map<String, Class<?>> map) throws SQLException {
        return getObject(findColumn(string), map);
    }

    @Override
    public default Ref getRef(String string) throws SQLException {
        return getRef(findColumn(string));
    }

    @Override
    public default Blob getBlob(String string) throws SQLException {
        return getBlob(findColumn(string));
    }

    @Override
    public default Clob getClob(String string) throws SQLException {
        return getClob(findColumn(string));
    }

    @Override
    public default Array getArray(String string) throws SQLException {
        return getArray(findColumn(string));
    }

    @Override
    public default Date getDate(String string, Calendar clndr) throws SQLException {
        return getDate(findColumn(string), clndr);
    }

    @Override
    public default Time getTime(String string, Calendar clndr) throws SQLException {
        return getTime(findColumn(string), clndr);
    }

    @Override
    public default Timestamp getTimestamp(String string, Calendar clndr) throws SQLException {
        return getTimestamp(findColumn(string), clndr);
    }

    @Override
    public default URL getURL(String string) throws SQLException {
        return getURL(findColumn(string));
    }

    @Override
    public default void updateRef(String string, Ref ref) throws SQLException {
        updateRef(findColumn(string), ref);
    }

    @Override
    public default void updateBlob(String string, Blob blob) throws SQLException {
        updateBlob(findColumn(string), blob);
    }

    @Override
    public default void updateClob(String string, Clob clob) throws SQLException {
        updateClob(findColumn(string), clob);
    }

    @Override
    public default void updateArray(String string, Array array) throws SQLException {
        updateArray(findColumn(string), array);
    }

    @Override
    public default RowId getRowId(String string) throws SQLException {
        return getRowId(findColumn(string));
    }

    @Override
    public default void updateRowId(String string, RowId rowid) throws SQLException {
        updateRowId(findColumn(string), rowid);
    }

    @Override
    public default void updateNString(String string, String string1) throws SQLException {
        updateNString(findColumn(string), string1);
    }

    @Override
    public default void updateNClob(String string, NClob nclob) throws SQLException {
        updateNClob(findColumn(string), nclob);
    }

    @Override
    public default NClob getNClob(String string) throws SQLException {
        return getNClob(findColumn(string));
    }

    @Override
    public default SQLXML getSQLXML(String string) throws SQLException {
        return getSQLXML(findColumn(string));
    }

    @Override
    public default void updateSQLXML(String string, SQLXML sqlxml) throws SQLException {
        updateSQLXML(findColumn(string), sqlxml);
    }

    @Override
    public default String getNString(String string) throws SQLException {
        return getNString(findColumn(string));
    }

    @Override
    public default Reader getNCharacterStream(String string) throws SQLException {
        return getNCharacterStream(findColumn(string));
    }

    @Override
    public default void updateNCharacterStream(String string, Reader reader, long l) throws SQLException {
        updateNCharacterStream(findColumn(string), reader, l);
    }

    @Override
    public default void updateAsciiStream(String string, InputStream in, long l) throws SQLException {
        updateAsciiStream(findColumn(string), in, l);
    }

    @Override
    public default void updateBinaryStream(String string, InputStream in, long l) throws SQLException {
        updateBinaryStream(findColumn(string), in, l);
    }

    @Override
    public default void updateCharacterStream(String string, Reader reader, long l) throws SQLException {
        updateCharacterStream(findColumn(string), reader, l);
    }

    @Override
    public default void updateBlob(String string, InputStream in, long l) throws SQLException {
        updateBlob(findColumn(string), in, l);
    }

    @Override
    public default void updateClob(String string, Reader reader, long l) throws SQLException {
        updateClob(findColumn(string), reader, l);
    }

    @Override
    public default void updateNClob(String string, Reader reader, long l) throws SQLException {
        updateNClob(findColumn(string), reader, l);
    }

    @Override
    public default void updateNCharacterStream(String string, Reader reader) throws SQLException {
        updateNCharacterStream(findColumn(string), reader);
    }

    @Override
    public default void updateAsciiStream(String string, InputStream in) throws SQLException {
        updateAsciiStream(findColumn(string), in);
    }

    @Override
    public default void updateBinaryStream(String string, InputStream in) throws SQLException {
        updateBinaryStream(findColumn(string), in);
    }

    @Override
    public default void updateCharacterStream(String string, Reader reader) throws SQLException {
        updateCharacterStream(findColumn(string), reader);
    }

    @Override
    public default void updateBlob(String string, InputStream in) throws SQLException {
        updateBlob(findColumn(string), in);
    }

    @Override
    public default void updateClob(String string, Reader reader) throws SQLException {
        updateClob(findColumn(string), reader);
    }

    @Override
    public default void updateNClob(String string, Reader reader) throws SQLException {
        updateNClob(findColumn(string), reader);
    }

    @Override
    public default <T> T getObject(String string, Class<T> type) throws SQLException {
        return getObject(findColumn(string), type);
    }

    @Override
    public default void updateObject(String columnLabel, Object x, SQLType targetSqlType, int scaleOrLength) throws SQLException {
        updateObject(findColumn(columnLabel), x, targetSqlType, scaleOrLength);
    }

    @Override
    public default void updateObject(String columnLabel, Object x, SQLType targetSqlType) throws SQLException {
        updateObject(findColumn(columnLabel), x, targetSqlType);
    }

    @Override
    public default void updateTime(String string, Time time) throws SQLException {
        updateTime(findColumn(string), time);
    }
}
