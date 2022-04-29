package com.poindre.shua.util;

import java.security.MessageDigest;

public class CharacteristicValue {
    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    private static String eigenvalue;

    public CharacteristicValue(String url) {
        setEigenvalue(MD16(url, "UTF-8"));
    }

    protected String byteToString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    protected String byteArrayToString(byte[] b) {
        StringBuilder result = new StringBuilder();
        for (byte i:b
             ) {
            result.append(byteToString(i));
        }
        return result.toString();
    }

    protected String MD32(String origin, String charset) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(origin.getBytes(charset));
            byte[] bytesResult = md.digest();
            result = byteArrayToString(bytesResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String MD16(String origin, String charset) {
        return MD32(origin, charset).substring(8,24);
    }

    public String getEigenvalue() {
        return eigenvalue;
    }

    public void setEigenvalue(String eigenvalue) {
        CharacteristicValue.eigenvalue = eigenvalue;
    }
}
