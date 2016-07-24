package org.j2gl.base64;

import java.io.IOException;

public interface Base64Util {

    void encodeFile(String inputFilePath, String outputFilePath) throws IOException;
    void encodeFile(String inputFilePath, String outputFilePath, int lineLength) throws IOException;
    void decodeFile(String inputFilePath, String outputFilePath) throws IOException;

}
