package lt.lb.fakedatasource;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author laim0nas100
 */
public class FakeResultSet extends FakeWrapper implements ResultSet, ResultSetIndexRedirect {

    public static class Builder {

        protected boolean addInsertRow = false;

        protected FakeResultSetMetaData meta = new FakeResultSetMetaData();

        public Builder addColumn(String columnLabel, Class cls, int type) {
            FakeResultSetMetaData.FakeColumn fakeColumn = new FakeResultSetMetaData.FakeColumn(columnLabel, cls, type);
            meta.cols.add(fakeColumn);
            return this;
        }

        public Builder addColumnStrings(String... columnLabels) {
            for (String l : columnLabels) {
                addColumn(l, String.class);
            }
            return this;
        }

        public Builder addColumn(String columnLabel, Class cls) {
            int resolveSqlType = meta.resolveSqlType(cls);
            return addColumn(columnLabel, cls, resolveSqlType);
        }

        public Builder addColumns(Class cls, String... labels) {
            int sqlType = meta.resolveSqlType(cls);
            for (String label : labels) {
                addColumn(label, cls, sqlType);
            }
            return this;
        }

        protected Object[] padData(Object[] array) throws SQLException {
            int columnCount = meta.getColumnCount();
            if (array.length >= columnCount) {
                return array;
            } else {
                Object[] newArray = new Object[columnCount];
                System.arraycopy(array, 0, newArray, 0, array.length);
                return newArray;
            }
        }

        protected Builder withInsertRow() throws SQLException {
            this.addInsertRow = true;
            return this;
        }

        protected Builder withoutInsertRow() throws SQLException {
            this.addInsertRow = false;
            return this;
        }

        public Builder addData(Object... any) throws SQLException {
            rows.add(new FakeRow(padData(any)));
            return this;
        }

        protected List<FakeRow> rows = new ArrayList<>();

        public FakeResultSet build(Statement stmt) throws SQLException {
            FakeResultSet set = new FakeResultSet(stmt);
            set.metaData = meta;
            set._rows.addAll(rows);
            if (addInsertRow) {
                FakeRow insertRow = new FakeRow(padData(new Object[0]));
                insertRow.isInsert = true;
                set._rows.add(insertRow);
            }

            return set;
        }

    }

    public static class FakeRow {

        public Object[] objects;
        public boolean updated = false;
        public boolean deleted = false;
        public boolean inserted = false;
        public boolean isInsert = false;

        public FakeRow(Object[] objects) {
            this.objects = objects;
        }

        public <T> T get(int i) {
            if(i >= objects.length){
                return null;
            }
            return (T) objects[i];
        }

        public void set(int i, Object ob) {
            if(i >= objects.length){
                Object[] newArray = new Object[i+1];
                System.arraycopy(objects, 0, newArray, 0, objects.length);
                objects = newArray;
            }
            objects[i] = ob;
        }
    }
    
    public static FakeResultSet empty(Statement st,String...labels) throws SQLException{
        return new Builder().addColumnStrings(labels).build(st);
    }
    
    public List<FakeRow> _rows = new ArrayList<>();
    public FakeResultSetMetaData metaData = new FakeResultSetMetaData();

    protected int _cursor = -1;
    protected int _savedCursor = -1;
    protected boolean _lastColumnReadNull = false;

    protected List<Runnable> insertCommits = new ArrayList<>();
    protected List<Runnable> updateCommits = new ArrayList<>();
    protected List<Runnable> deleteCommits = new ArrayList<>();

    protected boolean closed = false;

    public SQLWarning warning = null;

    public String cursorName = "fakeCursorName";
    public int fetchDirection = ResultSet.FETCH_UNKNOWN;
    public int fetchSize = Integer.MAX_VALUE;
    public int type = ResultSet.TYPE_SCROLL_SENSITIVE;
    public int concurrency = ResultSet.CONCUR_UPDATABLE;
    public int holdability = ResultSet.HOLD_CURSORS_OVER_COMMIT;
    public Statement statement;

    public FakeResultSet(Statement stmt) throws SQLException {
        statement = stmt;
    }
    
    
    

    protected FakeRow row() {
        return _rows.get(_cursor);
    }

    /**
     * 1 - based
     *
     * @param <T>
     * @param columnIndex
     */
    protected <T> T readVal(int columnIndex) {
        fakeAssertClosed();
        FakeRow row = row();
        T val = row.get(columnIndex - 1);
        _lastColumnReadNull = val == null;
        return val;
    }

    protected int labelToIndex(String columnLabel) throws SQLException {
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            if (metaData.getColumnLabel(i).equalsIgnoreCase(columnLabel)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 1 - based
     *
     * @param <T>
     * @param columnLabel
     */
    protected <T> T readVal(String columnLabel) throws SQLException {
        return readVal(findColumn(columnLabel));
    }

    protected void fakeAssertClosed() {
        if (closed) {
            throw new IllegalStateException("Allready closed");
        }
    }

    @Override
    public boolean next() throws SQLException {
        if (_cursor + 1 < _rows.size()) {
            _cursor++;
            return true;
        }
        return false;
    }

    @Override
    public void close() throws SQLException {
        closed = true;
    }

    @Override
    public boolean wasNull() throws SQLException {
        return _lastColumnReadNull;
    }

    @Override
    public String getString(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public boolean getBoolean(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public byte getByte(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public short getShort(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public int getInt(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public long getLong(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public float getFloat(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public double getDouble(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public byte[] getBytes(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public Date getDate(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public Time getTime(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public InputStream getUnicodeStream(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return warning;
    }

    @Override
    public void clearWarnings() throws SQLException {
        warning = null;
    }

    @Override
    public String getCursorName() throws SQLException {
        return cursorName;
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        return metaData;
    }

    @Override
    public Object getObject(int column) throws SQLException {
        return readVal(column);
    }

    @Override
    public int findColumn(String string) throws SQLException {
        return labelToIndex(string);
    }

    @Override
    public Reader getCharacterStream(int columnIndex) throws SQLException {
        char[] val = readVal(columnIndex);
        return new StringReader(String.copyValueOf(val));

    }

    @Override
    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public boolean isBeforeFirst() throws SQLException {
        return this._cursor == -1;
    }

    @Override
    public boolean isAfterLast() throws SQLException {
        return this._cursor >= this._rows.size();
    }

    @Override
    public boolean isFirst() throws SQLException {
        return this._cursor == 0;
    }

    @Override
    public boolean isLast() throws SQLException {
        return this._cursor == _rows.size() - 1;
    }

    @Override
    public void beforeFirst() throws SQLException {
        this._cursor = -1;
    }

    @Override
    public void afterLast() throws SQLException {
        this._cursor = _rows.size();
    }

    protected boolean cursorValid() {
        return _cursor >= 0 && _cursor < _rows.size();
    }

    @Override
    public boolean first() throws SQLException {
        this._cursor = 0;
        return cursorValid();
    }

    @Override
    public boolean last() throws SQLException {
        this._cursor = _rows.size() - 1;
        return cursorValid();
    }

    @Override
    public int getRow() throws SQLException {
        return _cursor + 1;
    }

    @Override
    public boolean absolute(int row) throws SQLException {
        row = Math.max(row, _rows.size());
        row = Math.min(row, 0);
        _cursor = row - 1;
        return cursorValid();
    }

    @Override
    public boolean relative(int rows) throws SQLException {
        return absolute(getRow() + rows);
    }

    @Override
    public boolean previous() throws SQLException {
        return relative(-1);
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        fetchDirection = direction;
    }

    @Override
    public int getFetchDirection() throws SQLException {
        return fetchDirection;
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        fetchSize = rows;
    }

    @Override
    public int getFetchSize() throws SQLException {
        return fetchSize;
    }

    @Override
    public int getType() throws SQLException {
        return type;
    }

    @Override
    public int getConcurrency() throws SQLException {
        return concurrency;
    }

    @Override
    public boolean rowUpdated() throws SQLException {
        return row().updated;
    }

    @Override
    public boolean rowInserted() throws SQLException {
        return row().inserted;
    }

    @Override
    public boolean rowDeleted() throws SQLException {
        return row().deleted;
    }

    protected void updateVal(int columnIndex, Object value) {
        fakeAssertClosed();
        FakeRow row = row();
        if (row.isInsert) {
            insertCommits.add(() -> {
                row.set(columnIndex, value);
            });
        } else {
            updateCommits.add(() -> {
                row.set(columnIndex, value);
            });
        }

    }

    @Override
    public void updateNull(int columnIndex) throws SQLException {
        updateVal(columnIndex, null);
    }

    @Override
    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateByte(int columnIndex, byte x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateShort(int columnIndex, short x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateInt(int columnIndex, int x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateLong(int columnIndex, long x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateFloat(int columnIndex, float x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateDouble(int columnIndex, double x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateString(int columnIndex, String x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateDate(int columnIndex, Date x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateTime(int columnIndex, Time x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
        updateVal(columnIndex, x);
    }

    protected byte[] readStream(InputStream x) throws SQLException {
        ArrayList<Byte> bytes = new ArrayList<>();
        try {
            int read = x.read();
            while (read != -1) {
                bytes.add((byte) read);
                read = x.read();
            }
        } catch (IOException ex) {
            throw new SQLException(ex);
        }
        byte[] array = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            array[i] = bytes.get(i);
        }
        return array;
    }

    protected byte[] readStream(InputStream x, int length) throws SQLException {
        byte[] bytes = new byte[length];
        try {
            x.read(bytes, 0, length);
        } catch (IOException ex) {
            throw new SQLException(ex);
        }
        return bytes;
    }

    protected byte[] readStream(InputStream x, long length) throws SQLException {
        return readStream(x, (int) length);
    }

    protected char[] readChars(Reader x) throws SQLException {
        ArrayList<Integer> chars = new ArrayList<>();
        try {
            int read = x.read();
            while (read != -1) {
                chars.add(read);
                read = x.read();
            }
        } catch (IOException ex) {
            throw new SQLException(ex);
        }
        char[] array = new char[chars.size()];
        for (int i = 0; i < chars.size(); i++) {
            array[i] = (char) chars.get(i).intValue();
        }
        return array;
    }

    protected char[] readChars(Reader x, int length) throws SQLException {
        char[] chars = new char[length];
        try {
            x.read(chars, 0, length);
        } catch (IOException ex) {
            throw new SQLException(ex);
        }
        return chars;
    }

    protected char[] readChars(Reader x, long length) throws SQLException {
        return readChars(x, (int) length);
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
        updateVal(columnIndex, readStream(x, length));

    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
        updateVal(columnIndex, readStream(x, length));
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
        updateVal(columnIndex, readChars(x, length));
    }

    @Override
    public void updateObject(int columnIndex, Object o, int scaleOrLength) throws SQLException {
        updateVal(columnIndex, o);
    }

    @Override
    public void updateObject(int columnIndex, Object o) throws SQLException {
        updateVal(columnIndex, o);

    }

    @Override
    public void insertRow() throws SQLException {
        for (Runnable r : this.insertCommits) {
            r.run();
        }

    }

    @Override
    public void updateRow() throws SQLException {
        for (Runnable r : this.updateCommits) {
            r.run();
        }
    }

    @Override
    public void deleteRow() throws SQLException {
        for (Runnable r : this.deleteCommits) {
            r.run();
        }
    }

    @Override
    public void refreshRow() throws SQLException {
        // always local
    }

    @Override
    public void cancelRowUpdates() throws SQLException {
        this.updateCommits.clear();
    }

    @Override
    public void moveToInsertRow() throws SQLException {
        _savedCursor = _cursor;
        for (int i = 0; i < _rows.size(); i++) {
            FakeRow r = _rows.get(i);
            if (r.isInsert) {
                _cursor = i;
                return;
            }
        }
    }

    @Override
    public void moveToCurrentRow() throws SQLException {
        _cursor = _savedCursor;
    }

    @Override
    public Statement getStatement() throws SQLException {
        return statement;
    }

    @Override
    public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public Ref getRef(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public Blob getBlob(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public Clob getClob(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public Array getArray(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public Date getDate(int columnIndex, Calendar clndr) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public Time getTime(int columnIndex, Calendar clndr) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public Timestamp getTimestamp(int columnIndex, Calendar clndr) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public URL getURL(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public void updateRef(int columnIndex, Ref x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateBlob(int columnIndex, Blob x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateClob(int columnIndex, Clob x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public void updateArray(int columnIndex, Array x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public RowId getRowId(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public void updateRowId(int columnIndex, RowId x) throws SQLException {
        updateVal(columnIndex, x);
    }

    @Override
    public int getHoldability() throws SQLException {
        return holdability;
    }

    @Override
    public boolean isClosed() throws SQLException {
        return closed;
    }

    @Override
    public void updateNString(int columnIndex, String string) throws SQLException {
        updateVal(columnIndex, string);
    }

    @Override
    public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
        updateVal(columnIndex, nClob);
    }

    @Override
    public NClob getNClob(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public SQLXML getSQLXML(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
        updateVal(columnIndex, xmlObject);
    }

    @Override
    public String getNString(int columnIndex) throws SQLException {
        return readVal(columnIndex);
    }

    @Override
    public Reader getNCharacterStream(int columnIndex) throws SQLException {
        char[] chars = readVal(columnIndex);
        return new StringReader(String.copyValueOf(chars));
    }

    @Override
    public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        updateVal(columnIndex, readChars(x, length));
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
        updateVal(columnIndex, readStream(x, length));
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
        updateVal(columnIndex, readStream(x, length));
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        updateVal(columnIndex, readChars(x, length));
    }

    @Override
    public void updateBlob(int columnIndex, InputStream x, long length) throws SQLException {
        updateVal(columnIndex, readStream(x, length));
    }

    @Override
    public void updateClob(int columnIndex, Reader x, long length) throws SQLException {
        updateVal(columnIndex, readChars(x, length));
    }

    @Override
    public void updateNClob(int columnIndex, Reader x, long length) throws SQLException {
        updateVal(columnIndex, readChars(x, length));
    }

    @Override
    public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
        updateVal(columnIndex, readChars(x));
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
        updateVal(columnIndex, readStream(x));
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
        updateVal(columnIndex, readStream(x));
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
        updateVal(columnIndex, readChars(x));
    }

    @Override
    public void updateBlob(int columnIndex, InputStream x) throws SQLException {
        updateVal(columnIndex, readStream(x));
    }

    @Override
    public void updateClob(int columnIndex, Reader x) throws SQLException {
        updateVal(columnIndex, readChars(x));
    }

    @Override
    public void updateNClob(int columnIndex, Reader x) throws SQLException {
        updateVal(columnIndex, readChars(x));
    }

    @Override
    public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
        return readVal(columnIndex);
    }

}
