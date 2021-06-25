package lt.lb.fakedatasource.structure;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;

/**
 *
 * @author laim0nas100
 */
public class FakeClob implements Clob {

    public char[] chars = new char[0];
    
    public void set(int i, char c){
        if(chars.length <= i){
            char[] newChars = new char[i+1];
            System.arraycopy(chars, 0, newChars, 0, i+1);
            chars = newChars;
        }
        chars[i] = c;
    }

    @Override
    public long length() throws SQLException {
        return chars.length;
    }

    @Override
    public String getSubString(long pos, int length) throws SQLException {
        return String.valueOf(chars, (int) pos - 1, length);
    }

    @Override
    public Reader getCharacterStream() throws SQLException {
        return new StringReader(String.valueOf(chars, 0, chars.length));
    }

    @Override
    public InputStream getAsciiStream() throws SQLException {
        return new InputStream() {
            int i = -1;

            @Override
            public int read() throws IOException {
                if (i + 1 <= chars.length) {
                    return chars[++i];
                } else {
                    return -1;
                }
            }
        };
    }

    @Override
    public long position(String string, long l) throws SQLException {
        return toString().indexOf(string, (int) l - 1);
    }

    @Override
    public String toString() {
        return String.valueOf(chars, 0, chars.length);
    }

    @Override
    public long position(Clob searchstr, long start) throws SQLException {
        Reader characterStream = searchstr.getCharacterStream();
        StringBuilder builder = new StringBuilder();
        while (true) {
            int read = 1;
            try {
                read = characterStream.read();
            } catch (IOException ex) {
                throw new SQLException(ex);
            }
            builder.append((char) read);
            if (read == -1) {
                break;
            }
        }
        return toString().indexOf(builder.toString(), (int) start - 1);
    }

    @Override
    public int setString(long l, String string) throws SQLException {
        try {
            setCharacterStream(l).write(string);
            return string.length();
        } catch (IOException ex) {
            throw new SQLException(ex);
        }
    }

    @Override
    public int setString(long pos, String string, int offset, int len) throws SQLException {
        String valueOf = String.valueOf(string.toCharArray(), offset, len);
        setString(pos, valueOf);
        return valueOf.length();
    }

    @Override
    public OutputStream setAsciiStream(long pos) throws SQLException {
        return new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                char[] toChars = Character.toChars(b);
                for (int i = 0; i < toChars.length; i++) {
                    chars[(int) pos - 1 + i] = toChars[i];
                }

            }
        };
    }

    @Override
    public Writer setCharacterStream(long pos) throws SQLException {
        return new Writer() {

            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {
                for (int i = 0; i < len; i++) {
                    set(i + off + (int) pos - 1, cbuf[i]);
                }
            }

            @Override
            public void flush() throws IOException {
            }

            @Override
            public void close() throws IOException {
            }
        };
    }

    @Override
    public void truncate(long len) throws SQLException {
        if (chars.length > len) {
            int l = (int) len;
            char[] newChars = new char[l];
            System.arraycopy(chars, 0, newChars, 0, l);
        }
    }

    @Override
    public void free() throws SQLException {
    }

    @Override
    public Reader getCharacterStream(long pos, long length) throws SQLException {
        return new StringReader(String.valueOf(chars, (int) pos - 1, (int) length));
    }

}
