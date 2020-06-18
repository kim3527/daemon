package com.limei.ioneuron.dmtest;

import java.beans.Encoder;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Sample {

    public static void main(String[] args) throws UnsupportedEncodingException {

        // -> 기압 정보를 고도로 변환 (단위 확인 pa /100 = hpa)
        System.out.println(44330 * (1 - (Math.pow(1005.21/1010.6, 1/5.255))));
        System.out.println("45.0893786730946");  //<---- 상기 공식으로 나오는 고도 (단위 : m)


        String edcodedString = "SGVsbG8=";

        Base64.Decoder decoder =Base64.getDecoder();

        byte[] decodedByte = decoder.decode(edcodedString);

        String decodedString = byteArrayToHexString(decodedByte);

        System.out.println(decodedString);
        String tempString ="000101f00144f101cd210840dd68452f9646462309010428fac147020100";
        Base64.Encoder encoder = Base64.getEncoder();


        byte[] bytes = hexStringToByteArray(tempString);

        byte[] encodedByte = encoder.encode(bytes);



        String encodedString = new String(encodedByte);
        System.out.println(encodedString);

//        String ddd="{\"confirmed\":false,\"data\":\"gwA=\",\"fport\":100}";
//        String dddd ="\"{\"applicationID\":\"2\",\"applicationName\":\"samilcts-tektelic800a\",\"deviceName\":\"samilcts-application\",\"deviceEUI\":\"f00000000a000001\",\"margin\":5,\"externalPowerSource\":false,\"batteryLevel\":39, \"batteryLevelUnavailable\":false}"


    }
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    public static String byteArrayToHexString(byte[] bytes){
        StringBuilder sb = new StringBuilder();

        for(byte b:bytes){
            sb.append(String.format("%02X", b&0xff));
        }
        return sb.toString();
    }
}
