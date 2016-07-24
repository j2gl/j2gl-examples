package org.j2gl.base64.apache;

import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.j2gl.base64.Base64Util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ApacheBase64Impl implements Base64Util {

    private final static int BUFFER_SIZE = 1024 * 1024;
    private final static byte[] NEW_LINE = {'\r', '\n'};

    @Override
    public void encodeFile(final String inputFilePath, final String outputFilePath) throws IOException {
        encodeFile(inputFilePath, outputFilePath, 0);
    }

    @Override
    public void encodeFile(final String inputFilePath, final String outputFilePath, final int lineLength) throws IOException {
        try (InputStream in = new FileInputStream(inputFilePath);
             OutputStream out = new Base64OutputStream(new FileOutputStream(outputFilePath), true, lineLength, NEW_LINE)) {
            final byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        }
    }

    @Override
    public void decodeFile(final String inputFilePath, final String outputFilePath) throws IOException {
        try (InputStream in = new Base64InputStream(new FileInputStream(inputFilePath));
             OutputStream out = new FileOutputStream(outputFilePath)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        }
    }

}
