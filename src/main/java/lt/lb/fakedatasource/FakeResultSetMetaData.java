package lt.lb.fakedatasource;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author laim0nas100
 */
public class FakeResultSetMetaData extends FakeWrapper implements ResultSetMetaData {

    public static class FakeMapping {

        public Set<Class> javaTypes = new HashSet<>();
        public Set<Integer> sqlTypes = new HashSet<>();

        public Class defaultJavaType = null;
        public Integer defaultSqlType = null;

        public FakeMapping() {
        }

        public FakeMapping add(Class... cls) {
            if (cls.length > 0 && defaultJavaType == null) {
                defaultJavaType = cls[0];
            }
            javaTypes.addAll(Arrays.asList(cls));
            return this;
        }

        public FakeMapping add(Integer... ints) {
            if (ints.length > 0 && defaultSqlType == null) {
                defaultSqlType = ints[0];
            }
            sqlTypes.addAll(Arrays.asList(ints));
            return this;
        }

    }

    public int resolveSqlType(Class cls) {
        for (FakeMapping m : sqlJavaMapping) {
            if (m.javaTypes.contains(cls)) {
                return m.defaultSqlType;
            }
        }
        throw new IllegalArgumentException("Failed to map to SQL type " + cls);
    }

    public List<FakeMapping> sqlJavaMapping = new ArrayList<>();

    public FakeResultSetMetaData() {
        sqlJavaMapping.add(new FakeMapping().add(byte[].class, Byte[].class).add(Types.BLOB, Types.BINARY, Types.VARBINARY, Types.LONGVARBINARY));
        sqlJavaMapping.add(new FakeMapping().add(String.class).add(Types.VARCHAR, Types.NVARCHAR, Types.LONGVARCHAR, Types.LONGNVARCHAR, Types.CHAR));
        sqlJavaMapping.add(new FakeMapping().add(Boolean.class).add(Types.BOOLEAN, Types.BIT));
        sqlJavaMapping.add(new FakeMapping().add(Byte.class).add(Types.TINYINT));
        sqlJavaMapping.add(new FakeMapping().add(Short.class).add(Types.SMALLINT));
        sqlJavaMapping.add(new FakeMapping().add(Integer.class).add(Types.INTEGER));
        sqlJavaMapping.add(new FakeMapping().add(Long.class).add(Types.BIGINT));
        sqlJavaMapping.add(new FakeMapping().add(Float.class).add(Types.FLOAT, Types.REAL));
        sqlJavaMapping.add(new FakeMapping().add(Double.class).add(Types.DOUBLE));
        sqlJavaMapping.add(new FakeMapping().add(java.sql.Date.class).add(Types.DATE));
        sqlJavaMapping.add(new FakeMapping().add(java.sql.Time.class).add(Types.TIME, Types.TIME_WITH_TIMEZONE));
        sqlJavaMapping.add(new FakeMapping().add(java.sql.Timestamp.class).add(Types.TIMESTAMP, Types.TIMESTAMP_WITH_TIMEZONE));
    }

    public static class FakeColumn {

        public boolean isAutoIncrement = false;
        public boolean isCaseSensitive = false;
        public boolean isSearchable = false;
        public boolean isCurrency = false;
        public int isNullable = 2; // nullable unknown
        public boolean isSigned = false;
        public int columnDisplaySize = 10;
        public String columnLabel = "FakeColumnLabel";
        public String columnName = "FakeColumnName";
        public String schemaName = "FakeSchemaName";
        public int precision = 0; // zero means not applicable
        public int scale = 0;  // zero means not applicable
        public String tableName = "FakeTableName";
        public String catalogName = "FakeCatalogName";
        public int columnType = -1; // look at java.sql.Types
        public String columnTypeName = "FakeColumnTypeName";
        public boolean isReadOnly = false;
        public boolean isWritable = false;
        public boolean isDefinitelyWritable = false;
        public String columnClassName = Object.class.getName();

        public FakeColumn() {
        }

        public FakeColumn(String label, Class type, int sqlType) {
            this.columnLabel = label;
            this.columnClassName = type.getName();
            this.columnType = sqlType;
        }

    }

    public List<FakeColumn> cols = new ArrayList<>();

    protected FakeColumn get(int column) {
        return cols.get(column - 1);
    }

    @Override
    public int getColumnCount() throws SQLException {
        return cols.size();
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException {
        return get(column).isAutoIncrement;
    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException {
        return get(column).isCaseSensitive;
    }

    @Override
    public boolean isSearchable(int column) throws SQLException {
        return get(column).isSearchable;
    }

    @Override
    public boolean isCurrency(int column) throws SQLException {
        return get(column).isCurrency;
    }

    @Override
    public int isNullable(int column) throws SQLException {
        return get(column).isNullable;
    }

    @Override
    public boolean isSigned(int column) throws SQLException {
        return get(column).isSigned;
    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException {
        return get(column).columnDisplaySize;
    }

    @Override
    public String getColumnLabel(int column) throws SQLException {
        return get(column).columnLabel;
    }

    @Override
    public String getColumnName(int column) throws SQLException {
        return get(column).columnName;
    }

    @Override
    public String getSchemaName(int column) throws SQLException {
        return get(column).schemaName;
    }

    @Override
    public int getPrecision(int column) throws SQLException {
        return get(column).precision;
    }

    @Override
    public int getScale(int column) throws SQLException {
        return get(column).scale;
    }

    @Override
    public String getTableName(int column) throws SQLException {
        return get(column).tableName;
    }

    @Override
    public String getCatalogName(int column) throws SQLException {
        return get(column).catalogName;
    }

    @Override
    public int getColumnType(int column) throws SQLException {
        return get(column).columnType;
    }

    @Override
    public String getColumnTypeName(int column) throws SQLException {
        return get(column).columnTypeName;
    }

    @Override
    public boolean isReadOnly(int column) throws SQLException {
        return get(column).isReadOnly;
    }

    @Override
    public boolean isWritable(int column) throws SQLException {
        return get(column).isWritable;
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        return get(column).isDefinitelyWritable;
    }

    @Override
    public String getColumnClassName(int column) throws SQLException {
        return get(column).columnClassName;
    }

}
