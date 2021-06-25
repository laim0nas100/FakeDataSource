package lt.lb.fakedatasource.structure;

import java.sql.SQLException;
import java.sql.Struct;
import java.util.Map;
import lt.lb.fakedatasource.SqlTypes;

/**
 *
 * @author laim0nas100
 */
public class FakeStruct implements Struct{
    
    public String sqlTypeName = SqlTypes.resolverSqlTypeName(SqlTypes.STRUCT);
    public Object[] attributes = new Object[0];

    @Override
    public String getSQLTypeName() throws SQLException {
        return sqlTypeName;
    }

    @Override
    public Object[] getAttributes() throws SQLException {
        return attributes;
    }

    @Override
    public Object[] getAttributes(Map<String, Class<?>> map) throws SQLException {
        return getAttributes();
    }
    
}
