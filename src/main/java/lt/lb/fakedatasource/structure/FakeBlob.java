package lt.lb.fakedatasource.structure;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.sql.SQLException;

/**
 *
 * @author laim0nas100
 */
public class FakeBlob implements Blob {

    public byte[] bytes = new byte[0];

    public void set(int i, byte c) {
        if (bytes.length <= i) {
            byte[] newBytes = new byte[i + 1];
            System.arraycopy(bytes, 0, newBytes, 0, i + 1);
            bytes = newBytes;
        }
        bytes[i] = c;
    }

    @Override
    public long length() throws SQLException {
        return bytes.length;
    }

    @Override
    public byte[] getBytes(long pos, int length) throws SQLException {
        return ByteBuffer.wrap(bytes, (int) pos - 1, length).array();
    }

    @Override
    public InputStream getBinaryStream() throws SQLException {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public long position(byte[] pattern, long start) throws SQLException {
        return -1L;
    }

    @Override
    public long position(Blob pattern, long start) throws SQLException {
        return -1;
    }

    @Override
    public int setBytes(long pos, byte[] bytes) throws SQLException {
        for (int i = 0; i < bytes.length; i++) {
            set(i + (int) pos - 1, bytes[i]);
        }
        return bytes.length;
    }

    @Override
    public int setBytes(long pos, byte[] bytes, int offset, int len) throws SQLException {
        byte[] array = ByteBuffer.wrap(bytes, offset, len).array();
        return setBytes(pos, array);
    }

    @Override
    public OutputStream setBinaryStream(long pos) throws SQLException {
        return new OutputStream() {
            int i = 0;

            @Override
            public void write(int b) throws IOException {
                set((int) pos - 1 + i, (byte) b);
                i++;
            }
        };
    }

    @Override
    public void truncate(long len) throws SQLException {
        if (bytes.length > len) {
            int l = (int) len;
            byte[] newChars = new byte[l];
            System.arraycopy(bytes, 0, newChars, 0, l);
        }
    }

    @Override
    public void free() throws SQLException {
    }

    @Override
    public InputStream getBinaryStream(long pos, long length) throws SQLException {
        byte[] bytes1 = getBytes(pos, (int) length);
        return new ByteArrayInputStream(bytes1);
    }

}
