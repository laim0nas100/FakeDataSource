package lt.lb.fakedatasource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import lt.lb.fakedatasource.SqlTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.sql.DataSource;

/**
 *
 * @author laim0nas100
 */
public class FakeDatabaseMetaData extends FakeWrapper implements DatabaseMetaData {

    public static class FakeTypeInfo {

        public boolean ownUpdatesAreVisible;
        public boolean ownDeletesAreVisible;
        public boolean ownInsertsAreVisible;
        public boolean othersUpdatesAreVisible;
        public boolean othersDeletesAreVisible;
        public boolean othersInsertsAreVisible;
        public boolean updatesAreDetected;
        public boolean deletesAreDetected;
        public boolean insertsAreDetected;
        public Collection<Integer> supportedConcurrency = new ArrayList<>(Arrays.asList(ResultSet.CONCUR_READ_ONLY, ResultSet.CONCUR_UPDATABLE));
    }

    public Supplier<Connection> connection;

    public boolean allProceduresAreCallable = false;
    public boolean allTablesAreSelectable = false;
    public String URL = "fakeUrl";
    public String userName = "fakeUserName";
    public boolean readOnly = false;
    public boolean nullsAreSortedHigh = false;
    public boolean nullsAreSortedLow = false;
    public boolean nullsAreSortedAtStart = false;
    public boolean nullsAreSortedAtEnd = false;

    public String databaseProductName = "Fake Database INC.";
    public String databaseProductVersion = "1.0";
    public String driverName = "Fake Database Driver";
    public String driverVersion = "1.0";

    public int driverMajorVersion = 1;
    public int driverMinorVersion = 0;

    public boolean usesLocalFilesPerTable = false;
    public boolean usesLocalFiles = false;

    public boolean supportsMixedCaseIdentifiers = false;
    public boolean storesUpperCaseIdentifiers = false;
    public boolean storesLowerCaseIdentifiers = false;
    public boolean storesMixedCaseIdentifiers = false;
    public boolean supportsMixedCaseQuotedIdentifiers = false;
    public boolean storesUpperCaseQuotedIdentifiers = false;
    public boolean storesLowerCaseQuotedIdentifiers = false;
    public boolean storesMixedCaseQuotedIdentifiers = false;

    public String identifierQuoteString = " ";
    public String SQLKeywords = "fakeSQL,fakeSQLkeywords";
    public String numericFunctions = "fakeNumeric,fakeNumericFunctions";
    public String stringFunctions = "fakeString,fakeStringFunctions";
    public String systemFunctions = "fakeSystem,fakeSystemFunctions";
    public String timeDateFunctions = "fakeTimeDate,fakeTimeDateFunctions";
    public String searchStringEscape = "\\"; // regular escape
    public String extraNameCharacters = "";// no extra

    public boolean supportsAlterTableWithAddColumn = false;
    public boolean supportsAlterTableWithDropColumn = false;
    public boolean supportsColumnAliasing = false;
    public boolean nullPlusNonNullIsNull = false;
    public boolean supportsConvert = false;
    public BiFunction<Integer, Integer, Boolean> supportsConvertFunc = (a, b) -> false;
    public boolean supportsTableCorrelationNames = false;
    public boolean supportsDifferentTableCorrelationNames = false;
    public boolean supportsExpressionsInOrderBy = false;
    public boolean supportsOrderByUnrelated = false;
    public boolean supportsGroupBy = false;
    public boolean supportsGroupByUnrelated = false;
    public boolean supportsGroupByBeyondSelect = false;
    public boolean supportsLikeEscapeClause = false;
    public boolean supportsMultipleResultSets = false;
    public boolean supportsMultipleTransactions = false;
    public boolean supportsNonNullableColumns = false;
    public boolean supportsMinimumSQLGrammar = false;
    public boolean supportsCoreSQLGrammar = false;
    public boolean supportsExtendedSQLGrammar = false;
    public boolean supportsANSI92EntryLevelSQL = false;
    public boolean supportsANSI92IntermediateSQL = false;
    public boolean supportsANSI92FullSQL = false;
    public boolean supportsIntegrityEnhancementFacility = false;
    public boolean supportsOuterJoins = false;
    public boolean supportsFullOuterJoins = false;
    public boolean supportsLimitedOuterJoins = false;

    public String schemaTerm = "schema";
    public String procedureTerm = "procedure";
    public String catalogTerm = "catalog";
    public boolean catalogAtStart = false;
    public String catalogSeparator = ":";

    public boolean supportsSchemasInDataManipulation = false;
    public boolean supportsSchemasInProcedureCalls = false;
    public boolean supportsSchemasInTableDefinitions = false;
    public boolean supportsSchemasInIndexDefinitions = false;
    public boolean supportsSchemasInPrivilegeDefinitions = false;
    public boolean supportsCatalogsInDataManipulation = false;
    public boolean supportsCatalogsInProcedureCalls = false;
    public boolean supportsCatalogsInTableDefinitions = false;
    public boolean supportsCatalogsInIndexDefinitions = false;
    public boolean supportsCatalogsInPrivilegeDefinitions = false;
    public boolean supportsPositionedDelete = false;
    public boolean supportsPositionedUpdate = false;
    public boolean supportsSelectForUpdate = false;
    public boolean supportsStoredProcedures = false;
    public boolean supportsSubqueriesInComparisons = false;
    public boolean supportsSubqueriesInExists = false;
    public boolean supportsSubqueriesInIns = false;
    public boolean supportsSubqueriesInQuantifieds = false;
    public boolean supportsCorrelatedSubqueries = false;
    public boolean supportsUnion = false;
    public boolean supportsUnionAll = false;
    public boolean supportsOpenCursorsAcrossCommit = false;
    public boolean supportsOpenCursorsAcrossRollback = false;
    public boolean supportsOpenStatementsAcrossCommit = false;
    public boolean supportsOpenStatementsAcrossRollback = false;

    /**
     * Zero means no limit or limit unknown
     */
    public int maxBinaryLiteralLength = 0;
    public int maxCharLiteralLength = 0;
    public int maxColumnNameLength = 0;
    public int maxColumnsInGroupBy = 0;
    public int maxColumnsInIndex = 0;
    public int maxColumnsInOrderBy = 0;
    public int maxColumnsInSelect = 0;
    public int maxColumnsInTable = 0;
    public int maxConnections = 0;
    public int maxCursorNameLength = 0;
    public int maxIndexLength = 0;
    public int maxSchemaNameLength = 0;
    public int maxProcedureNameLength = 0;
    public int maxCatalogNameLength = 0;
    public int maxRowSize = 0;
    public boolean doesMaxRowSizeIncludeBlobs = false;
    public int maxStatements = 0;
    public int maxTableNameLength = 0;
    public int maxTablesInSelect = 0;
    public int maxUserNameLength = 0;
    public int defaultTransactionIsolation = 0;

    public boolean supportsTransactions = true;
    public Function<Integer, Boolean> supportsTransactionIsolationLevel = (a) -> true;
    public boolean supportsDataDefinitionAndDataManipulationTransactions = true;
    public boolean supportsDataManipulationTransactionsOnly = false;
    public boolean dataDefinitionCausesTransactionCommit = false;
    public boolean dataDefinitionIgnoredInTransactions = false;

    public boolean supportsBatchUpdates = false;
    public boolean supportsSavepoints = false;
    public boolean supportsNamedParameters = false;
    public boolean supportsMultipleOpenResults = false;
    public boolean supportsGetGeneratedKeys = false;

    public int defaultResultSetHoldability = ResultSet.CLOSE_CURSORS_AT_COMMIT;
    public int databaseMajorVersion = 1;
    public int databaseMinorVersion = 0;
    public int JDBCMajorVersion = 1;
    public int JDBCMinorVerion = 0;

    public boolean locatorsUpdateCopy = false;
    public boolean supportsStatementPooling = true;
    public boolean supportsStoredFunctionsUsingCallSyntax = false;
    public boolean autoCommitFailureClosesAllResultSets = false;
    public boolean generatedKeyAlwaysReturned = false;

    public int SQLStateType = DatabaseMetaData.sqlStateSQL;
    public RowIdLifetime rowIdLifetime = RowIdLifetime.ROWID_VALID_FOREVER;

    public Set<Integer> supportedSqlTypes = new HashSet<>();

    public Map<Integer, FakeTypeInfo> supportedSqlTypesMap = new HashMap<>();

    public FakeDatabaseMetaData(Supplier<Connection> ds) {
        supportedSqlTypes.addAll(
                Arrays.asList(
                        SqlTypes.ARRAY, SqlTypes.BIGINT, SqlTypes.BINARY, SqlTypes.BIT, SqlTypes.BLOB,
                        SqlTypes.BOOLEAN, SqlTypes.CHAR, SqlTypes.CLOB, SqlTypes.DATE, SqlTypes.DECIMAL, SqlTypes.DOUBLE, SqlTypes.FLOAT,
                        SqlTypes.INTEGER, SqlTypes.LONGNVARCHAR, SqlTypes.LONGVARBINARY, SqlTypes.LONGVARCHAR, SqlTypes.NCHAR,
                        SqlTypes.NCLOB, SqlTypes.NULL, SqlTypes.NUMERIC, SqlTypes.NVARCHAR, SqlTypes.REAL, SqlTypes.SMALLINT,
                        SqlTypes.TIME, SqlTypes.TIMESTAMP, SqlTypes.TIMESTAMP_WITH_TIMEZONE, SqlTypes.TIME_WITH_TIMEZONE,
                        SqlTypes.TINYINT, SqlTypes.VARBINARY, SqlTypes.VARCHAR
                )
        );
        for (Integer type : supportedSqlTypes) {
            supportedSqlTypesMap.put(type, new FakeTypeInfo());
        }
        this.connection = ds;
    }

    @Override
    public boolean allProceduresAreCallable() throws SQLException {
        return allProceduresAreCallable;
    }

    @Override
    public boolean allTablesAreSelectable() throws SQLException {
        return allTablesAreSelectable;
    }

    @Override
    public String getURL() throws SQLException {
        return URL;
    }

    @Override
    public String getUserName() throws SQLException {
        return userName;
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return readOnly;
    }

    @Override
    public boolean nullsAreSortedHigh() throws SQLException {
        return nullsAreSortedHigh;
    }

    @Override
    public boolean nullsAreSortedLow() throws SQLException {
        return nullsAreSortedLow;
    }

    @Override
    public boolean nullsAreSortedAtStart() throws SQLException {
        return nullsAreSortedAtStart;
    }

    @Override
    public boolean nullsAreSortedAtEnd() throws SQLException {
        return nullsAreSortedAtEnd;
    }

    @Override
    public String getDatabaseProductName() throws SQLException {
        return databaseProductName;
    }

    @Override
    public String getDatabaseProductVersion() throws SQLException {
        return databaseProductVersion;
    }

    @Override
    public String getDriverName() throws SQLException {
        return driverName;
    }

    @Override
    public String getDriverVersion() throws SQLException {
        return driverVersion;
    }

    @Override
    public int getDriverMajorVersion() {
        return driverMajorVersion;
    }

    @Override
    public int getDriverMinorVersion() {
        return driverMinorVersion;
    }

    @Override
    public boolean usesLocalFiles() throws SQLException {
        return usesLocalFiles;
    }

    @Override
    public boolean usesLocalFilePerTable() throws SQLException {
        return usesLocalFilesPerTable;
    }

    @Override
    public boolean supportsMixedCaseIdentifiers() throws SQLException {
        return supportsMixedCaseIdentifiers;
    }

    @Override
    public boolean storesUpperCaseIdentifiers() throws SQLException {
        return storesUpperCaseIdentifiers;
    }

    @Override
    public boolean storesLowerCaseIdentifiers() throws SQLException {
        return storesLowerCaseIdentifiers;
    }

    @Override
    public boolean storesMixedCaseIdentifiers() throws SQLException {
        return storesMixedCaseIdentifiers;
    }

    @Override
    public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
        return supportsMixedCaseQuotedIdentifiers;
    }

    @Override
    public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
        return storesUpperCaseQuotedIdentifiers;
    }

    @Override
    public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
        return storesLowerCaseQuotedIdentifiers;
    }

    @Override
    public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
        return storesMixedCaseQuotedIdentifiers;
    }

    @Override
    public String getIdentifierQuoteString() throws SQLException {
        return identifierQuoteString;
    }

    @Override
    public String getSQLKeywords() throws SQLException {
        return SQLKeywords;
    }

    @Override
    public String getNumericFunctions() throws SQLException {
        return numericFunctions;
    }

    @Override
    public String getStringFunctions() throws SQLException {
        return stringFunctions;
    }

    @Override
    public String getSystemFunctions() throws SQLException {
        return systemFunctions;
    }

    @Override
    public String getTimeDateFunctions() throws SQLException {
        return timeDateFunctions;
    }

    @Override
    public String getSearchStringEscape() throws SQLException {
        return searchStringEscape;
    }

    @Override
    public String getExtraNameCharacters() throws SQLException {
        return extraNameCharacters;
    }

    @Override
    public boolean supportsAlterTableWithAddColumn() throws SQLException {
        return supportsAlterTableWithAddColumn;
    }

    @Override
    public boolean supportsAlterTableWithDropColumn() throws SQLException {
        return supportsAlterTableWithDropColumn;
    }

    @Override
    public boolean supportsColumnAliasing() throws SQLException {
        return supportsColumnAliasing;
    }

    @Override
    public boolean nullPlusNonNullIsNull() throws SQLException {
        return nullPlusNonNullIsNull;
    }

    @Override
    public boolean supportsConvert() throws SQLException {
        return supportsConvert;
    }

    @Override
    public boolean supportsConvert(int fromType, int toType) throws SQLException {
        return supportsConvertFunc.apply(fromType, toType);
    }

    @Override
    public boolean supportsTableCorrelationNames() throws SQLException {
        return supportsTableCorrelationNames;
    }

    @Override
    public boolean supportsDifferentTableCorrelationNames() throws SQLException {
        return supportsDifferentTableCorrelationNames;
    }

    @Override
    public boolean supportsExpressionsInOrderBy() throws SQLException {
        return supportsExpressionsInOrderBy;
    }

    @Override
    public boolean supportsOrderByUnrelated() throws SQLException {
        return supportsOrderByUnrelated;
    }

    @Override
    public boolean supportsGroupBy() throws SQLException {
        return supportsGroupBy;
    }

    @Override
    public boolean supportsGroupByUnrelated() throws SQLException {
        return supportsGroupByUnrelated;
    }

    @Override
    public boolean supportsGroupByBeyondSelect() throws SQLException {
        return supportsGroupByBeyondSelect;
    }

    @Override
    public boolean supportsLikeEscapeClause() throws SQLException {
        return supportsLikeEscapeClause;
    }

    @Override
    public boolean supportsMultipleResultSets() throws SQLException {
        return supportsMultipleResultSets;
    }

    @Override
    public boolean supportsMultipleTransactions() throws SQLException {
        return supportsMultipleTransactions;
    }

    @Override
    public boolean supportsNonNullableColumns() throws SQLException {
        return supportsNonNullableColumns;
    }

    @Override
    public boolean supportsMinimumSQLGrammar() throws SQLException {
        return supportsMinimumSQLGrammar;
    }

    @Override
    public boolean supportsCoreSQLGrammar() throws SQLException {
        return supportsCoreSQLGrammar;
    }

    @Override
    public boolean supportsExtendedSQLGrammar() throws SQLException {
        return supportsExtendedSQLGrammar;
    }

    @Override
    public boolean supportsANSI92EntryLevelSQL() throws SQLException {
        return supportsANSI92EntryLevelSQL;
    }

    @Override
    public boolean supportsANSI92IntermediateSQL() throws SQLException {
        return supportsANSI92IntermediateSQL;
    }

    @Override
    public boolean supportsANSI92FullSQL() throws SQLException {
        return supportsANSI92FullSQL;
    }

    @Override
    public boolean supportsIntegrityEnhancementFacility() throws SQLException {
        return supportsIntegrityEnhancementFacility;
    }

    @Override
    public boolean supportsOuterJoins() throws SQLException {
        return supportsOuterJoins;
    }

    @Override
    public boolean supportsFullOuterJoins() throws SQLException {
        return supportsFullOuterJoins;
    }

    @Override
    public boolean supportsLimitedOuterJoins() throws SQLException {
        return supportsLimitedOuterJoins;
    }

    @Override
    public String getSchemaTerm() throws SQLException {
        return schemaTerm;
    }

    @Override
    public String getProcedureTerm() throws SQLException {
        return procedureTerm;
    }

    @Override
    public String getCatalogTerm() throws SQLException {
        return catalogTerm;
    }

    @Override
    public boolean isCatalogAtStart() throws SQLException {
        return catalogAtStart;
    }

    @Override
    public String getCatalogSeparator() throws SQLException {
        return catalogSeparator;
    }

    @Override
    public boolean supportsSchemasInDataManipulation() throws SQLException {
        return supportsSchemasInDataManipulation;
    }

    @Override
    public boolean supportsSchemasInProcedureCalls() throws SQLException {
        return supportsSchemasInProcedureCalls;
    }

    @Override
    public boolean supportsSchemasInTableDefinitions() throws SQLException {
        return supportsSchemasInTableDefinitions;
    }

    @Override
    public boolean supportsSchemasInIndexDefinitions() throws SQLException {
        return supportsSchemasInIndexDefinitions;
    }

    @Override
    public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
        return supportsSchemasInPrivilegeDefinitions;
    }

    @Override
    public boolean supportsCatalogsInDataManipulation() throws SQLException {
        return supportsCatalogsInDataManipulation;
    }

    @Override
    public boolean supportsCatalogsInProcedureCalls() throws SQLException {
        return supportsCatalogsInProcedureCalls;
    }

    @Override
    public boolean supportsCatalogsInTableDefinitions() throws SQLException {
        return supportsCatalogsInTableDefinitions;
    }

    @Override
    public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
        return supportsCatalogsInIndexDefinitions;
    }

    @Override
    public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
        return supportsCatalogsInPrivilegeDefinitions;
    }

    @Override
    public boolean supportsPositionedDelete() throws SQLException {
        return supportsPositionedDelete;
    }

    @Override
    public boolean supportsPositionedUpdate() throws SQLException {
        return supportsPositionedUpdate;
    }

    @Override
    public boolean supportsSelectForUpdate() throws SQLException {
        return supportsSelectForUpdate;
    }

    @Override
    public boolean supportsStoredProcedures() throws SQLException {
        return supportsStoredProcedures;
    }

    @Override
    public boolean supportsSubqueriesInComparisons() throws SQLException {
        return supportsSubqueriesInComparisons;
    }

    @Override
    public boolean supportsSubqueriesInExists() throws SQLException {
        return supportsSubqueriesInExists;
    }

    @Override
    public boolean supportsSubqueriesInIns() throws SQLException {
        return supportsSubqueriesInIns;
    }

    @Override
    public boolean supportsSubqueriesInQuantifieds() throws SQLException {
        return supportsSubqueriesInQuantifieds;
    }

    @Override
    public boolean supportsCorrelatedSubqueries() throws SQLException {
        return supportsCorrelatedSubqueries;
    }

    @Override
    public boolean supportsUnion() throws SQLException {
        return supportsUnion;
    }

    @Override
    public boolean supportsUnionAll() throws SQLException {
        return supportsUnionAll;
    }

    @Override
    public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
        return supportsOpenCursorsAcrossCommit;
    }

    @Override
    public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
        return supportsOpenCursorsAcrossRollback;
    }

    @Override
    public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
        return supportsOpenStatementsAcrossCommit;
    }

    @Override
    public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
        return supportsOpenStatementsAcrossRollback;
    }

    @Override
    public int getMaxBinaryLiteralLength() throws SQLException {
        return maxBinaryLiteralLength;
    }

    @Override
    public int getMaxCharLiteralLength() throws SQLException {
        return maxCharLiteralLength;
    }

    @Override
    public int getMaxColumnNameLength() throws SQLException {
        return maxColumnNameLength;
    }

    @Override
    public int getMaxColumnsInGroupBy() throws SQLException {
        return maxColumnsInGroupBy;
    }

    @Override
    public int getMaxColumnsInIndex() throws SQLException {
        return maxColumnsInIndex;
    }

    @Override
    public int getMaxColumnsInOrderBy() throws SQLException {
        return maxColumnsInOrderBy;
    }

    @Override
    public int getMaxColumnsInSelect() throws SQLException {
        return maxColumnsInSelect;
    }

    @Override
    public int getMaxColumnsInTable() throws SQLException {
        return maxColumnsInTable;
    }

    @Override
    public int getMaxConnections() throws SQLException {
        return maxConnections;
    }

    @Override
    public int getMaxCursorNameLength() throws SQLException {
        return maxCursorNameLength;
    }

    @Override
    public int getMaxIndexLength() throws SQLException {
        return maxIndexLength;
    }

    @Override
    public int getMaxSchemaNameLength() throws SQLException {
        return maxSchemaNameLength;
    }

    @Override
    public int getMaxProcedureNameLength() throws SQLException {
        return maxProcedureNameLength;
    }

    @Override
    public int getMaxCatalogNameLength() throws SQLException {
        return maxCatalogNameLength;
    }

    @Override
    public int getMaxRowSize() throws SQLException {
        return maxRowSize;
    }

    @Override
    public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
        return doesMaxRowSizeIncludeBlobs;
    }

    @Override
    public int getMaxStatementLength() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMaxStatements() throws SQLException {
        return maxStatements;
    }

    @Override
    public int getMaxTableNameLength() throws SQLException {
        return maxTableNameLength;
    }

    @Override
    public int getMaxTablesInSelect() throws SQLException {
        return maxTablesInSelect;
    }

    @Override
    public int getMaxUserNameLength() throws SQLException {
        return maxUserNameLength;
    }

    @Override
    public int getDefaultTransactionIsolation() throws SQLException {
        return defaultTransactionIsolation;
    }

    @Override
    public boolean supportsTransactions() throws SQLException {
        return supportsTransactions;
    }

    @Override
    public boolean supportsTransactionIsolationLevel(int level) throws SQLException {
        return supportsTransactionIsolationLevel.apply(level);
    }

    @Override
    public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
        return supportsDataDefinitionAndDataManipulationTransactions;
    }

    @Override
    public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
        return supportsDataManipulationTransactionsOnly;
    }

    @Override
    public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
        return dataDefinitionCausesTransactionCommit;
    }

    @Override
    public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
        return dataDefinitionIgnoredInTransactions;
    }

    public static class FakeName {

        public String catalog = "FakeCatalog";
        public String schema = "FakeSchema";
        public String name = "FakeName";

        public void append(Object ob) {
            this.name += ob;
        }

        public static FakeName proc(int i) {
            FakeName fn = new FakeName();
            fn.name = "FakeProcecure" + i;
            return fn;
        }

        public static FakeName function(int i) {
            FakeName fn = new FakeName();
            fn.name = "FakeProcecure" + i;
            return fn;
        }

        public String full() {
            return catalog + "." + schema + "." + name;
        }
    }

    @Override
    public ResultSet getProcedures(String catalog, String schemaPattern,
            String procedureNamePattern) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
        /*
        FakeName fn1 = FakeName.proc(1);
        FakeName fn2 = FakeName.proc(2);
        return new FakeResultSet.Builder()
                .addColumn("PROCEDURE_CAT", String.class)
                .addColumn("PROCEDURE_SCHEM", String.class)
                .addColumn("PROCEDURE_NAME", String.class)
                .addColumn("REMARKS", String.class)
                .addColumn("PROCEDURE_TYPE", Short.class)
                .addData(fn1.catalog, fn1.schema, fn1.name, "This is a fake procedure number 1", (short) DatabaseMetaData.procedureResultUnknown)
                .addData(fn2.catalog, fn2.schema, fn2.name, "This is a fake procedure number 2", (short) DatabaseMetaData.procedureResultUnknown)
                .build(new FakeStatement());
         */
    }

    @Override
    public ResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern, String columnNamePattern) throws SQLException {

        return FakeResultSet.empty(getConnection().createStatement());

        /*
        Integer prec = 1;
        Integer length = 1024;
        Integer scale = null;
        Short radix = null;

        Short colIn = DatabaseMetaData.procedureColumnIn;
        Short colOut = DatabaseMetaData.procedureColumnOut;
        Short nullable = DatabaseMetaData.columnNullableUnknown;
        String remarks = "Some fake remarks";

        String defaultVal = "NULL";
        String colNullable = "NO";
        FakeName fn1 = FakeName.proc(1);
        FakeName fn2 = FakeName.proc(2);

        FakeResultSet.Builder b = new FakeResultSet.Builder()
                .addColumn("PROCEDURE_CAT", String.class)
                .addColumn("PROCEDURE_SCHEM", String.class)
                .addColumn("PROCEDURE_NAME", String.class)
                .addColumn("COLUMN_NAME", String.class)
                .addColumn("COLUMN_TYPE", Short.class)
                .addColumn("DATA_TYPE", Integer.class)
                .addColumn("TYPE_NAME", String.class)
                .addColumn("PRECISION", Integer.class)
                .addColumn("LENGTH", Integer.class)
                .addColumn("SCALE", Short.class)
                .addColumn("RADIX", Short.class)
                .addColumn("NULLABLE", Short.class)
                .addColumn("REMARKS", String.class)
                .addColumn("COLUMN_DEF", String.class)
                .addColumn("SQL_DATA_TYPE", Integer.class)
                .addColumn("SQL_DATETIME_SUB", Integer.class)
                .addColumn("CHAR_OCTET_LENGTH", Integer.class)
                .addColumn("ORDINAL_POSITION", Integer.class)
                .addColumn("IS_NULLABLE", String.class)
                .addColumn("SPECIFIC_NAME", String.class);
        b
                .addData(fn1.catalog, fn1.schema, fn1.name, "FakeColIn1", colIn,
                        SqlTypes.VARCHAR, "VARCHAR", prec, length, scale, radix, nullable, remarks,
                        defaultVal, 0, 0, 0, 0, colNullable, fn1.full())
                .addData(fn2.catalog, fn2.schema, fn2.name, "FakeColIn2", colIn,
                        SqlTypes.VARCHAR, "VARCHAR", prec, length, scale, radix, nullable, remarks,
                        defaultVal, 0, 0, 0, 0, colNullable, fn2.full());
        return b.build(ds.getConnection().createStatement());
         */
    }

    @Override
    public ResultSet getTables(String string, String string1, String string2, String[] strings) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getSchemas() throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getCatalogs() throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getTableTypes() throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getColumns(String string, String string1, String string2, String string3) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getColumnPrivileges(String string, String string1, String string2, String string3) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getTablePrivileges(String string, String string1, String string2) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getBestRowIdentifier(String string, String string1, String string2, int i, boolean bln) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getVersionColumns(String string, String string1, String string2) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getPrimaryKeys(String string, String string1, String string2) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getImportedKeys(String string, String string1, String string2) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getExportedKeys(String string, String string1, String string2) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getCrossReference(String string, String string1, String string2, String string3, String string4, String string5) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getTypeInfo() throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getIndexInfo(String string, String string1, String string2, boolean bln, boolean bln1) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public boolean supportsResultSetType(int type) throws SQLException {
        return this.supportedSqlTypes.contains(type);
    }

    protected Optional<FakeTypeInfo> getSupportedType(int type) {
        return Optional.ofNullable(supportedSqlTypesMap.getOrDefault(type, null));
    }

    @Override
    public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException {
        return getSupportedType(type).filter(f -> f.supportedConcurrency.contains(concurrency)).isPresent();
    }

    @Override
    public boolean ownUpdatesAreVisible(int type) throws SQLException {
        return getSupportedType(type).filter(f -> f.ownUpdatesAreVisible).isPresent();
    }

    @Override
    public boolean ownDeletesAreVisible(int type) throws SQLException {
        return getSupportedType(type).filter(f -> f.ownDeletesAreVisible).isPresent();

    }

    @Override
    public boolean ownInsertsAreVisible(int type) throws SQLException {
        return getSupportedType(type).filter(f -> f.ownInsertsAreVisible).isPresent();
    }

    @Override
    public boolean othersUpdatesAreVisible(int type) throws SQLException {
        return getSupportedType(type).filter(f -> f.othersUpdatesAreVisible).isPresent();
    }

    @Override
    public boolean othersDeletesAreVisible(int type) throws SQLException {
        return getSupportedType(type).filter(f -> f.othersDeletesAreVisible).isPresent();
    }

    @Override
    public boolean othersInsertsAreVisible(int type) throws SQLException {
        return getSupportedType(type).filter(f -> f.othersInsertsAreVisible).isPresent();
    }

    @Override
    public boolean updatesAreDetected(int type) throws SQLException {
        return getSupportedType(type).filter(f -> f.updatesAreDetected).isPresent();
    }

    @Override
    public boolean deletesAreDetected(int type) throws SQLException {
        return getSupportedType(type).filter(f -> f.deletesAreDetected).isPresent();
    }

    @Override
    public boolean insertsAreDetected(int type) throws SQLException {
        return getSupportedType(type).filter(f -> f.insertsAreDetected).isPresent();
    }

    @Override
    public boolean supportsBatchUpdates() throws SQLException {
        return supportsBatchUpdates;
    }

    @Override
    public ResultSet getUDTs(String string, String string1, String string2, int[] ints) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public Connection getConnection() throws SQLException {
        return connection.get();
    }

    @Override
    public boolean supportsSavepoints() throws SQLException {
        return supportsSavepoints;
    }

    @Override
    public boolean supportsNamedParameters() throws SQLException {
        return supportsNamedParameters;
    }

    @Override
    public boolean supportsMultipleOpenResults() throws SQLException {
        return supportsMultipleOpenResults;
    }

    @Override
    public boolean supportsGetGeneratedKeys() throws SQLException {
        return supportsGetGeneratedKeys;
    }

    @Override
    public ResultSet getSuperTypes(String string, String string1, String string2) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getSuperTables(String string, String string1, String string2) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getAttributes(String string, String string1, String string2, String string3) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public boolean supportsResultSetHoldability(int holdability) throws SQLException {
        return true;//supports all
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return defaultResultSetHoldability;
    }

    @Override
    public int getDatabaseMajorVersion() throws SQLException {
        return databaseMajorVersion;
    }

    @Override
    public int getDatabaseMinorVersion() throws SQLException {
        return databaseMinorVersion;
    }

    @Override
    public int getJDBCMajorVersion() throws SQLException {
        return JDBCMajorVersion;
    }

    @Override
    public int getJDBCMinorVersion() throws SQLException {
        return JDBCMinorVerion;
    }

    @Override
    public int getSQLStateType() throws SQLException {
        return SQLStateType;
    }

    @Override
    public boolean locatorsUpdateCopy() throws SQLException {
        return locatorsUpdateCopy;
    }

    @Override
    public boolean supportsStatementPooling() throws SQLException {
        return supportsStatementPooling;
    }

    @Override
    public RowIdLifetime getRowIdLifetime() throws SQLException {
        return rowIdLifetime;
    }

    @Override
    public ResultSet getSchemas(String string, String string1) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
        return supportsStoredFunctionsUsingCallSyntax;
    }

    @Override
    public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
        return autoCommitFailureClosesAllResultSets;
    }

    @Override
    public ResultSet getClientInfoProperties() throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getFunctions(String string, String string1, String string2) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getFunctionColumns(String string, String string1, String string2, String string3) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public ResultSet getPseudoColumns(String string, String string1, String string2, String string3) throws SQLException {
        return FakeResultSet.empty(getConnection().createStatement());
    }

    @Override
    public boolean generatedKeyAlwaysReturned() throws SQLException {
        return generatedKeyAlwaysReturned;
    }

}
