package lt.lb.fakedatasource.structure;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lt.lb.fakedatasource.FakeConnection;
import lt.lb.fakedatasource.FakeResultSet;
import lt.lb.fakedatasource.SqlTypes;

/**
 *
 * @author laim0nas100
 */
public class FakeArray implements Array{
    public FakeConnection _fakeCon;
    
    public List list = new ArrayList<>();
    public int baseType = SqlTypes.INTEGER;

    @Override
    public String getBaseTypeName() throws SQLException {
        return SqlTypes.resolverSqlTypeName(baseType);
    }

    @Override
    public int getBaseType() throws SQLException {
        return baseType;
    }

    @Override
    public Object getArray() throws SQLException {
        return list.toArray();
    }

    @Override
    public Object getArray(Map<String, Class<?>> map) throws SQLException {
        return list.toArray();
    }

    @Override
    public Object getArray(long index, int count) throws SQLException {
        int i = (int)index-1;
        return list.subList(i, i+count).toArray();
    }

    @Override
    public Object getArray(long index, int count, Map<String, Class<?>> map) throws SQLException {
        int i = (int)index-1;
        return list.subList(i, i+count).toArray();
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return new FakeResultSet.Builder().addData(getArray()).build(_fakeCon.createStatement());
    }

    @Override
    public ResultSet getResultSet(Map<String, Class<?>> map) throws SQLException {
        return new FakeResultSet.Builder().addData(getArray(map)).build(_fakeCon.createStatement());
    }

    @Override
    public ResultSet getResultSet(long index, int count) throws SQLException {
        return new FakeResultSet.Builder().addData(getArray(index,count)).build(_fakeCon.createStatement());
    }

    @Override
    public ResultSet getResultSet(long index, int count, Map<String, Class<?>> map) throws SQLException {
        return new FakeResultSet.Builder().addData(getArray(index,count,map)).build(_fakeCon.createStatement());
    }

    @Override
    public void free() throws SQLException {
    }
    
}
