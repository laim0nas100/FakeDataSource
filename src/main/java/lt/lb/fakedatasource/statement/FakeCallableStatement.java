package lt.lb.fakedatasource.statement;

import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import lt.lb.fakedatasource.FakeParameterMetaData;

/**
 *
 * @author laim0nas100
 */
public class FakeCallableStatement extends FakePreparedStatement implements CallableStatementIndexRedirect {

    @Override
    public int findParameter(String string) throws SQLException {
        int indexOf = namedParams.indexOf(string);
        if(indexOf < 0){
            namedParams.add(string);
            return namedParams.size() + namedParamOffset;
        }else{
            return indexOf + namedParamOffset;
        }
    }
    
    public List<String> namedParams = new ArrayList<>();
    protected int namedParamOffset = 1000;

    public FakeCallableStatement(Connection con) throws SQLException {
        super(con);
    }


    @Override
    public void registerOutParameter(int parameterIndex, int sqlType) throws SQLException {
        registerOutParameter(parameterIndex, sqlType, 0);
    }

    @Override
    public void registerOutParameter(int parameterIndex, int sqlType, int scale) throws SQLException {
        
        FakeParameterMetaData.FakeParam p = paramMeta.params.computeIfAbsent(parameterIndex, i-> new FakeParameterMetaData.FakeParam());
        p.type = sqlType;
        p.scale = scale;
    }
    
    @Override
    public void registerOutParameter(int parameterIndex, int sqlType, String sqlTypeName) throws SQLException {
        FakeParameterMetaData.FakeParam p = paramMeta.params.computeIfAbsent(parameterIndex, i-> new FakeParameterMetaData.FakeParam());
        p.type = sqlType;
        p.typeName = sqlTypeName;
    }

    @Override
    public boolean wasNull() throws SQLException {
        return set.wasNull();
    }

    @Override
    public String getString(int i) throws SQLException {
        return set.getString(i);
    }

    @Override
    public boolean getBoolean(int parameterIndex) throws SQLException {
        return set.getBoolean(parameterIndex);
    }

    @Override
    public byte getByte(int parameterIndex) throws SQLException {
        return set.getByte(parameterIndex);
    }

    @Override
    public short getShort(int parameterIndex) throws SQLException {
        return set.getShort(parameterIndex);
    }

    @Override
    public int getInt(int parameterIndex) throws SQLException {
        return set.getInt(parameterIndex);
    }

    @Override
    public long getLong(int parameterIndex) throws SQLException {
        return set.getLong(parameterIndex);
    }

    @Override
    public float getFloat(int parameterIndex) throws SQLException {
        return set.getFloat(parameterIndex);
    }

    @Override
    public double getDouble(int parameterIndex) throws SQLException {
        return set.getDouble(parameterIndex);
    }

    @Override
    public BigDecimal getBigDecimal(int i, int i1) throws SQLException {
        return set.getBigDecimal(i, i1);
    }

    @Override
    public byte[] getBytes(int parameterIndex) throws SQLException {
        return set.getBytes(parameterIndex);
    }

    @Override
    public Date getDate(int parameterIndex) throws SQLException {
        return set.getDate(parameterIndex);
    }

    @Override
    public Time getTime(int parameterIndex) throws SQLException {
        return set.getTime(parameterIndex);
    }

    @Override
    public Timestamp getTimestamp(int parameterIndex) throws SQLException {
        return set.getTimestamp(parameterIndex);
    }

    @Override
    public Object getObject(int i) throws SQLException {
        return set.getObject(i);
    }

    @Override
    public BigDecimal getBigDecimal(int i) throws SQLException {
        return set.getBigDecimal(i);
    }

    @Override
    public Object getObject(int i, Map<String, Class<?>> map) throws SQLException {
        return set.getObject(i, map);
    }

    @Override
    public Ref getRef(int parameterIndex) throws SQLException {
        return set.getRef(parameterIndex);
    }

    @Override
    public Blob getBlob(int parameterIndex) throws SQLException {
        return set.getBlob(parameterIndex);
    }

    @Override
    public Clob getClob(int parameterIndex) throws SQLException {
        return set.getClob(parameterIndex);
    }

    @Override
    public Array getArray(int parameterIndex) throws SQLException {
        return set.getArray(parameterIndex);
    }

    @Override
    public Date getDate(int parameterIndex, Calendar clndr) throws SQLException {
        return set.getDate(parameterIndex, clndr);
    }

    @Override
    public Time getTime(int parameterIndex, Calendar clndr) throws SQLException {
        return set.getTime(parameterIndex, clndr);
        
    }

    @Override
    public Timestamp getTimestamp(int parameterIndex, Calendar clndr) throws SQLException {
        return set.getTimestamp(parameterIndex, clndr);
    }

    @Override
    public URL getURL(int parameterIndex) throws SQLException {
        return set.getURL(parameterIndex);
    }

    @Override
    public RowId getRowId(int parameterIndex) throws SQLException {
        return set.getRowId(parameterIndex);
    }

    @Override
    public NClob getNClob(int parameterIndex) throws SQLException {
        return set.getNClob(parameterIndex);
    }

    @Override
    public SQLXML getSQLXML(int parameterIndex) throws SQLException {
        return set.getSQLXML(parameterIndex);
    }

    @Override
    public String getNString(int i) throws SQLException {
        return set.getNString(rowsChanged);
    }

    @Override
    public Reader getNCharacterStream(int parameterIndex) throws SQLException {
        return set.getNCharacterStream(parameterIndex);
    }

    @Override
    public Reader getCharacterStream(int parameterIndex) throws SQLException {
        return set.getCharacterStream(parameterIndex);
    }

    @Override
    public <T> T getObject(int i, Class<T> type) throws SQLException {
        return set.getObject(rowsChanged, type);
    }

    
}
