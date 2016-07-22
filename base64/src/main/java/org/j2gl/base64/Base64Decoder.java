package org.j2gl.base64;

import org.apache.commons.codec.binary.Base64InputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Base64Decoder {

    final private static int BUFFER_SIZE = 1024 * 1024;
    final private static org.apache.commons.codec.binary.Base64 commonsBase64 = new org.apache.commons.codec.binary.Base64();


    public static void commonsDecode(final String inputFilePath, final String outputFilePath) throws IOException {
        try (InputStream in = new Base64InputStream(new FileInputStream(inputFilePath));
             OutputStream out = new FileOutputStream(outputFilePath)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        }
    }

    public static void main(String... args) {
        try {
            final String inputFile = args[0];
            final String outputFile = args[1];;
            commonsDecode(inputFile, outputFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
