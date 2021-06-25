package lt.lb.fakedatasource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Copy of {@link java.sql.Types} with some extension methods;
 *
 * @author laim0nas100
 */
public class SqlTypes {

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>BIT</code>.
     */
    public final static int BIT = -7;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>TINYINT</code>.
     */
    public final static int TINYINT = -6;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>SMALLINT</code>.
     */
    public final static int SMALLINT = 5;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>INTEGER</code>.
     */
    public final static int INTEGER = 4;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>BIGINT</code>.
     */
    public final static int BIGINT = -5;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>FLOAT</code>.
     */
    public final static int FLOAT = 6;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>REAL</code>.
     */
    public final static int REAL = 7;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>DOUBLE</code>.
     */
    public final static int DOUBLE = 8;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>NUMERIC</code>.
     */
    public final static int NUMERIC = 2;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>DECIMAL</code>.
     */
    public final static int DECIMAL = 3;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>CHAR</code>.
     */
    public final static int CHAR = 1;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>VARCHAR</code>.
     */
    public final static int VARCHAR = 12;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>LONGVARCHAR</code>.
     */
    public final static int LONGVARCHAR = -1;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>DATE</code>.
     */
    public final static int DATE = 91;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>TIME</code>.
     */
    public final static int TIME = 92;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>TIMESTAMP</code>.
     */
    public final static int TIMESTAMP = 93;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>BINARY</code>.
     */
    public final static int BINARY = -2;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>VARBINARY</code>.
     */
    public final static int VARBINARY = -3;

    /**
     * <P>
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type
     * <code>LONGVARBINARY</code>.
     */
    public final static int LONGVARBINARY = -4;

    /**
     * <P>
     * The constant in the Java programming language that identifies the generic
     * SQL value <code>NULL</code>.
     */
    public final static int NULL = 0;

    /**
     * The constant in the Java programming language that indicates that the SQL
     * type is database-specific and gets mapped to a Java object that can be
     * accessed via the methods <code>getObject</code> and
     * <code>setObject</code>.
     */
    public final static int OTHER = 1111;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>JAVA_OBJECT</code>.
     *
     * @since 1.2
     */
    public final static int JAVA_OBJECT = 2000;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>DISTINCT</code>.
     *
     * @since 1.2
     */
    public final static int DISTINCT = 2001;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>STRUCT</code>.
     *
     * @since 1.2
     */
    public final static int STRUCT = 2002;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>ARRAY</code>.
     *
     * @since 1.2
     */
    public final static int ARRAY = 2003;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>BLOB</code>.
     *
     * @since 1.2
     */
    public final static int BLOB = 2004;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>CLOB</code>.
     *
     * @since 1.2
     */
    public final static int CLOB = 2005;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>REF</code>.
     *
     * @since 1.2
     */
    public final static int REF = 2006;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>DATALINK</code>.
     *
     * @since 1.4
     */
    public final static int DATALINK = 70;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>BOOLEAN</code>.
     *
     * @since 1.4
     */
    public final static int BOOLEAN = 16;

    //------------------------- JDBC 4.0 -----------------------------------
    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>ROWID</code>
     *
     * @since 1.6
     *
     */
    public final static int ROWID = -8;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>NCHAR</code>
     *
     * @since 1.6
     */
    public static final int NCHAR = -15;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>NVARCHAR</code>.
     *
     * @since 1.6
     */
    public static final int NVARCHAR = -9;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type
     * <code>LONGNVARCHAR</code>.
     *
     * @since 1.6
     */
    public static final int LONGNVARCHAR = -16;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>NCLOB</code>.
     *
     * @since 1.6
     */
    public static final int NCLOB = 2011;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type <code>XML</code>.
     *
     * @since 1.6
     */
    public static final int SQLXML = 2009;

    //--------------------------JDBC 4.2 -----------------------------
    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type {@code REF CURSOR}.
     *
     * @since 1.8
     */
    public static final int REF_CURSOR = 2012;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type
     * {@code TIME WITH TIMEZONE}.
     *
     * @since 1.8
     */
    public static final int TIME_WITH_TIMEZONE = 2013;

    /**
     * The constant in the Java programming language, sometimes referred to as a
     * type code, that identifies the generic SQL type
     * {@code TIMESTAMP WITH TIMEZONE}.
     *
     * @since 1.8
     */
    public static final int TIMESTAMP_WITH_TIMEZONE = 2014;

    public static final List<Integer> types = Arrays.asList(
            SqlTypes.ARRAY, SqlTypes.BIGINT, SqlTypes.BINARY, SqlTypes.BIT, SqlTypes.BLOB,
            SqlTypes.BOOLEAN, SqlTypes.CHAR, SqlTypes.CLOB, SqlTypes.DATE, SqlTypes.DECIMAL, SqlTypes.DOUBLE, SqlTypes.FLOAT,
            SqlTypes.INTEGER, SqlTypes.LONGNVARCHAR, SqlTypes.LONGVARBINARY, SqlTypes.LONGVARCHAR, SqlTypes.NCHAR,
            SqlTypes.NCLOB, SqlTypes.NULL, SqlTypes.NUMERIC, SqlTypes.NVARCHAR, SqlTypes.REAL, SqlTypes.SMALLINT,
            SqlTypes.TIME, SqlTypes.TIMESTAMP, SqlTypes.TIMESTAMP_WITH_TIMEZONE, SqlTypes.TIME_WITH_TIMEZONE,
            SqlTypes.TINYINT, SqlTypes.VARBINARY, SqlTypes.VARCHAR
    );

    public static final Map<String, Integer> typeNameMap = types.stream().collect(Collectors.toMap(i -> resolverSqlTypeName(i), i -> i));

    public static String resolverSqlTypeName(int type) {
        switch (type) {
            case SqlTypes.ARRAY:
                return "ARRAY";
            case SqlTypes.BIGINT:
                return "BIGINT";
            case SqlTypes.BINARY:
                return "BINARY";
            case SqlTypes.BIT:
                return "BIT";
            case SqlTypes.BLOB:
                return "BLOB";
            case SqlTypes.BOOLEAN:
                return "BOOLEAN";
            case SqlTypes.CHAR:
                return "CHAR";
            case SqlTypes.CLOB:
                return "CLOB";
            case SqlTypes.DATALINK:
                return "DATALINK";
            case SqlTypes.DATE:
                return "DATE";
            case SqlTypes.DECIMAL:
                return "DECIMAL";
            case SqlTypes.DOUBLE:
                return "DOUBLE";
            case SqlTypes.DISTINCT:
                return "DISTINCT";
            case SqlTypes.FLOAT:
                return "FLOAT";
            case SqlTypes.INTEGER:
                return "INTEGER";
            case SqlTypes.JAVA_OBJECT:
                return "JAVA_OBJECT";
            case SqlTypes.LONGNVARCHAR:
                return "LONGNVARCHAR";
            case SqlTypes.LONGVARBINARY:
                return "LONGVARBINARY";
            case SqlTypes.LONGVARCHAR:
                return "LONGVARCHAR";
            case SqlTypes.NCHAR:
                return "NCHAR";
            case SqlTypes.NCLOB:
                return "NCLOB";
            case SqlTypes.NULL:
                return "NULL";
            case SqlTypes.NUMERIC:
                return "NUMERIC";
            case SqlTypes.NVARCHAR:
                return "NVARCHAR";
            case SqlTypes.OTHER:
                return "OTHER";
            case SqlTypes.REAL:
                return "REAL";
            case SqlTypes.REF:
                return "REF";
            case SqlTypes.ROWID:
                return "ROWID";
            case SqlTypes.SMALLINT:
                return "SMALLINT";
            case SqlTypes.SQLXML:
                return "SQLXML";
            case SqlTypes.STRUCT:
                return "STRUCT";
            case SqlTypes.TIME:
                return "TIME";
            case SqlTypes.TIMESTAMP:
                return "TIMESTAMP";
            case SqlTypes.TIMESTAMP_WITH_TIMEZONE:
                return "TIMESTAMP_WITH_TIMEZONE";
            case SqlTypes.TIME_WITH_TIMEZONE:
                return "TIME_WITH_TIMEZONE";
            case SqlTypes.TINYINT:
                return "TINYINT";
            default:
                return "Unknown";
        }
    }

    public static int resolveSqlTypeFromName(String name) {
        return typeNameMap.getOrDefault(name, -1);
    }
}
