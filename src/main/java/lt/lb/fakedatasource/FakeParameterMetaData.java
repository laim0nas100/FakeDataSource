package lt.lb.fakedatasource;

import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author laim0nas100
 */
public class FakeParameterMetaData extends FakeWrapper implements ParameterMetaData {
    
    public static class FakeParam{
        public int nullable;
        public boolean signed;
        public int precision;
        public int scale;
        public int type;
        public String typeName;
        public String className;
        public int mode;
        public String name;
    }
    
    public Map<Integer,FakeParam> params = new HashMap<>();

    @Override
    public int getParameterCount() throws SQLException {
        return params.size();
    }

    @Override
    public int isNullable(int param) throws SQLException {
        return params.get(param).nullable;
    }

    @Override
    public boolean isSigned(int param) throws SQLException {
         return params.get(param).signed;
    }

    @Override
    public int getPrecision(int param) throws SQLException {
         return params.get(param).precision;
    }

    @Override
    public int getScale(int param) throws SQLException {
         return params.get(param).scale;
    }

    @Override
    public int getParameterType(int param) throws SQLException {
         return params.get(param).type;
    }

    @Override
    public String getParameterTypeName(int param) throws SQLException {
         return params.get(param).typeName;
    }

    @Override
    public String getParameterClassName(int param) throws SQLException {
         return params.get(param).className;
    }

    @Override
    public int getParameterMode(int param) throws SQLException {
         return params.get(param).mode;
    }
    
    public int findParam(String name) throws SQLException{
        for(Map.Entry<Integer, FakeParam> entry:params.entrySet()){
            FakeParam p = entry.getValue();
            if(Objects.equals(name, p.name)){
                return entry.getKey();
            }
        }
        return Integer.MIN_VALUE;
    }
    
}
