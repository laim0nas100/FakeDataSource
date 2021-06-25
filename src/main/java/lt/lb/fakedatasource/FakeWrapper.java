package lt.lb.fakedatasource;

import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author laim0nas100
 */
public class FakeWrapper implements Wrapper {
    
    public Map<Class,Object> wrappedObjects = new HashMap<>();

    @Override
    public <T> T unwrap(Class<T> type) throws SQLException {
        if(wrappedObjects.containsKey(type)){
            return (T) wrappedObjects.get(type);
        }
        
        for(Map.Entry<Class,Object> entry:wrappedObjects.entrySet()){
            Class key = entry.getKey();
            if(key.isAssignableFrom(type)){
                return (T) entry.getValue();
            }
        }
        return null;
        
    }

    @Override
    public boolean isWrapperFor(Class<?> type) throws SQLException {
        if(wrappedObjects.containsKey(type)){
            return true;
        }
        
        for(Map.Entry<Class,Object> entry:wrappedObjects.entrySet()){
            Class key = entry.getKey();
            if(key.isAssignableFrom(type)){
                return true;
            }
        }
        return false;
    }
    
}
