package org.j2gl.base64;

import org.j2gl.base64.apache.ApacheBase64Impl;

public class Base64Encoder {

    public static void main(String... args) {
        try {
            final String inputFile = args[0];
            final String outputFile = args[1];
            Base64Util base64Util = new ApacheBase64Impl();
            base64Util.encodeFile(inputFile, outputFile, 76);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
