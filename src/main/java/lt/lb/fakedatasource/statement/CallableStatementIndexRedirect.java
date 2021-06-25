package lt.lb.fakedatasource.statement;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

/**
 *
 * @author laim0nas100
 */
public interface CallableStatementIndexRedirect extends CallableStatement{
    
    public int findParameter(String string) throws SQLException;

    @Override
    public default void registerOutParameter(String string, int i) throws SQLException {
        registerOutParameter(findParameter(string), i);
    }

    @Override
    public default void registerOutParameter(String string, int i, int i1) throws SQLException {
        registerOutParameter(findParameter(string), i, i1);
    }

    @Override
    public default void registerOutParameter(String string, int i, String string1) throws SQLException {
        registerOutParameter(findParameter(string), i, string1);
    }

    
    

    @Override
    public default void setURL(String string, URL url) throws SQLException {
        setURL(findParameter(string), url);
    }

    @Override
    public default void setNull(String string, int i) throws SQLException {
        setNull(findParameter(string), i);
    }

    @Override
    public default void setBoolean(String string, boolean bln) throws SQLException {
        setBoolean(findParameter(string), bln);
    }

    @Override
    public default void setByte(String string, byte b) throws SQLException {
        setByte(findParameter(string), b);
    }

    @Override
    public default void setShort(String string, short s) throws SQLException {
        setShort(findParameter(string), s);
    }

    @Override
    public default void setInt(String string, int i) throws SQLException {
        setInt(findParameter(string), i);
    }

    @Override
    public default void setLong(String string, long l) throws SQLException {
        setLong(findParameter(string), l);
    }

    @Override
    public default void setFloat(String string, float f) throws SQLException {
        setFloat(findParameter(string), f);
    }

    @Override
    public default void setDouble(String string, double d) throws SQLException {
        setDouble(findParameter(string), d);
    }

    @Override
    public default void setBigDecimal(String string, BigDecimal bd) throws SQLException {
        setBigDecimal(findParameter(string), bd);
    }

    @Override
    public default void setString(String string, String string1) throws SQLException {
        setString(findParameter(string), string1);
    }

    @Override
    public default void setBytes(String string, byte[] bytes) throws SQLException {
        setBytes(findParameter(string), bytes);
    }

    @Override
    public default void setDate(String string, Date date) throws SQLException {
        setDate(findParameter(string), date);
    }

    @Override
    public default void setTime(String string, Time time) throws SQLException {
        setTime(findParameter(string), time);
    }

    @Override
    public default void setTimestamp(String string, Timestamp tmstmp) throws SQLException {
        setTimestamp(findParameter(string), tmstmp);
    }

    @Override
    public default void setAsciiStream(String string, InputStream in, int i) throws SQLException {
        setAsciiStream(findParameter(string), in, i);
    }

    @Override
    public default void setBinaryStream(String string, InputStream in, int i) throws SQLException {
        setBinaryStream(findParameter(string), in, i);
    }

    @Override
    public default void setObject(String string, Object o, int i, int i1) throws SQLException {
        setObject(findParameter(string), o, i, i1);
    }

    @Override
    public default void setObject(String string, Object o, int i) throws SQLException {
        setObject(findParameter(string), o, i);
    }

    @Override
    public default void setObject(String string, Object o) throws SQLException {
        setObject(findParameter(string), o);
    }

    @Override
    public default void setCharacterStream(String string, Reader reader, int i) throws SQLException {
        setCharacterStream(findParameter(string), reader, i);
    }

    @Override
    public default void setDate(String string, Date date, Calendar clndr) throws SQLException {
        setDate(findParameter(string), date, clndr);
    }

    @Override
    public default void setTime(String string, Time time, Calendar clndr) throws SQLException {
        setTime(findParameter(string), time, clndr);
    }

    @Override
    public default void setTimestamp(String string, Timestamp tmstmp, Calendar clndr) throws SQLException {
        setTimestamp(findParameter(string), tmstmp, clndr);
    }

    @Override
    public default void setNull(String string, int i, String string1) throws SQLException {
        setNull(findParameter(string), i,string1);
    }

    @Override
    public default String getString(String string) throws SQLException {
        return getString(findParameter(string));
    }

    @Override
    public default boolean getBoolean(String string) throws SQLException {
        return getBoolean(findParameter(string));
    }

    @Override
    public default byte getByte(String string) throws SQLException {
        return  getByte(findParameter(string)) ;
    }

    @Override
    public default short getShort(String string) throws SQLException {
        return  getShort(findParameter(string)) ;
    }

    @Override
    public default int getInt(String string) throws SQLException {
        return  getInt(findParameter(string)) ;
    }

    @Override
    public default long getLong(String string) throws SQLException {
        return  getLong(findParameter(string)) ;
    }

    @Override
    public default float getFloat(String string) throws SQLException {
        return  getFloat(findParameter(string)) ;
    }

    @Override
    public default double getDouble(String string) throws SQLException {
        return  getDouble(findParameter(string)) ;
    }

    @Override
    public default byte[] getBytes(String string) throws SQLException {
        return  getBytes(findParameter(string)) ;
    }

    @Override
    public default Date getDate(String string) throws SQLException {
        return  getDate(findParameter(string)) ;
    }

    @Override
    public default Time getTime(String string) throws SQLException {
        return  getTime(findParameter(string)) ;
    }

    @Override
    public default Timestamp getTimestamp(String string) throws SQLException {
        return  getTimestamp(findParameter(string)) ;
    }

    @Override
    public default Object getObject(String string) throws SQLException {
        return  getObject(findParameter(string)) ;
    }

    @Override
    public default BigDecimal getBigDecimal(String string) throws SQLException {
        return  getBigDecimal(findParameter(string)) ;
    }

    @Override
    public default Object getObject(String string, Map<String, Class<?>> map) throws SQLException {
        return  getObject(findParameter(string), map) ;
    }

    @Override
    public default Ref getRef(String string) throws SQLException {
        return  getRef(findParameter(string)) ;
    }

    @Override
    public default Blob getBlob(String string) throws SQLException {
        return  getBlob(findParameter(string)) ;
    }

    @Override
    public default Clob getClob(String string) throws SQLException {
        return  getClob(findParameter(string)) ;
    }

    @Override
    public default Array getArray(String string) throws SQLException {
        return  getArray(findParameter(string)) ;
    }

    @Override
    public default Date getDate(String string, Calendar clndr) throws SQLException {
        return  getDate(findParameter(string), clndr) ;
    }

    @Override
    public default Time getTime(String string, Calendar clndr) throws SQLException {
        return  getTime(findParameter(string), clndr) ;
    }

    @Override
    public default Timestamp getTimestamp(String string, Calendar clndr) throws SQLException {
        return  getTimestamp(findParameter(string), clndr) ;
    }

    @Override
    public default URL getURL(String string) throws SQLException {
        return  getURL(findParameter(string)) ;
    }

    @Override
    public default RowId getRowId(String string) throws SQLException {
        return  getRowId(findParameter(string)) ;
    }

    @Override
    public default void setRowId(String string, RowId rowid) throws SQLException {
        setRowId(findParameter(string), rowid);
    }

    @Override
    public default void setNString(String string, String string1) throws SQLException {
        setNString(findParameter(string), string1);
    }

    @Override
    public default void setNCharacterStream(String string, Reader reader, long l) throws SQLException {
        setNCharacterStream(findParameter(string), reader, l);
    }

    @Override
    public default void setNClob(String string, NClob nclob) throws SQLException {
        setNClob(findParameter(string), nclob);
    }

    @Override
    public default void setClob(String string, Reader reader, long l) throws SQLException {
        setClob(findParameter(string), reader, l);
    }

    @Override
    public default void setBlob(String string, InputStream in, long l) throws SQLException {
        setBlob(findParameter(string), in, l);
    }

    @Override
    public default void setNClob(String string, Reader reader, long l) throws SQLException {
        setNClob(findParameter(string), reader, l);
    }

    @Override
    public default NClob getNClob(String string) throws SQLException {
        return  getNClob(findParameter(string)) ;
    }

    @Override
    public default void setSQLXML(String string, SQLXML sqlxml) throws SQLException {
        setSQLXML(findParameter(string), sqlxml);
    }

    @Override
    public default SQLXML getSQLXML(String string) throws SQLException {
        return  getSQLXML(findParameter(string)) ;
    }

    @Override
    public default String getNString(String string) throws SQLException {
        return  getNString(findParameter(string)) ;
    }

    @Override
    public default Reader getNCharacterStream(String string) throws SQLException {
        return  getNCharacterStream(findParameter(string)) ;
    }

    @Override
    public default Reader getCharacterStream(String string) throws SQLException {
        return  getCharacterStream(findParameter(string)) ;
    }

    @Override
    public default void setBlob(String string, Blob blob) throws SQLException {
        setBlob(findParameter(string), blob);
    }

    @Override
    public default void setClob(String string, Clob clob) throws SQLException {
        setClob(findParameter(string), clob);
    }

    @Override
    public default void setAsciiStream(String string, InputStream in, long l) throws SQLException {
        setAsciiStream(findParameter(string), in, l);
    }

    @Override
    public default void setBinaryStream(String string, InputStream in, long l) throws SQLException {
        setAsciiStream(findParameter(string), in, l);
    }

    @Override
    public default void setCharacterStream(String string, Reader reader, long l) throws SQLException {
        setCharacterStream(findParameter(string), reader, l);
    }

    @Override
    public default void setAsciiStream(String string, InputStream in) throws SQLException {
        setAsciiStream(findParameter(string), in);
    }

    @Override
    public default void setBinaryStream(String string, InputStream in) throws SQLException {
        setBinaryStream(findParameter(string), in);
    }

    @Override
    public default void setCharacterStream(String string, Reader reader) throws SQLException {
        setCharacterStream(findParameter(string), reader);
    }

    @Override
    public default void setNCharacterStream(String string, Reader reader) throws SQLException {
        setNCharacterStream(findParameter(string), reader);
    }

    @Override
    public default void setClob(String string, Reader reader) throws SQLException {
        setClob(findParameter(string), reader);
    }

    @Override
    public default void setBlob(String string, InputStream in) throws SQLException {
        setBlob(findParameter(string), in);
    }

    @Override
    public default void setNClob(String string, Reader reader) throws SQLException {
        setNClob(findParameter(string), reader);
    }

    @Override
    public default <T> T getObject(String string, Class<T> type) throws SQLException {
        return  getObject(findParameter(string), type) ;
    }
    
    
    
}
