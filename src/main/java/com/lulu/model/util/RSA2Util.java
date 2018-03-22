package com.lulu.model.util;

import org.phprpc.util.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

/**
 * @Description:
 * @Author: Milo.Ding
 * @Date: 2018/3/20 16:56
 */
public class RSA2Util {
    private static String rsaType = "RSA";
    private static String rsaPrivateString = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCKNghsprER3dWVl4KmZ5lL3HCUBIzCcWwy/MdKJsJZTZO7vRj0OuIjRuXYXyqwFhzf4lSOUdNsb/GgHBP1BK7k+tgNf+NjRc5DMk8bYN79vPLjMnNQScPfrKBJbJXUsdd1tGJFO66VzYXgseOkFM9NEaOgNkl69n3kuyQwtIvGnwW/hfhjbT+0REXiYRewviHTSqhTzXNwJkhS2pMIbW3BrZX6LofArZDDaSGp3XcSVNHd3RSTgKA17T8XuUTqkirg3krMmPg+mvzAEV63JjWvjharn3j0+24/XdAcXvd8xT8N6zVMeDQ6mVxwSe4ig67itSoZZaqZgz0UvD2PMRq1AgMBAAECggEABJl5vEvr1qFgS0MoiOsnsdubL4HbQVlO9X9uDmytyRUI1pWbb/1Jq0zft0yregKyYU0B7V6Rv6kWDHMCwwOt4lbqu8BGy/X1wEy7TzjxEtan6qGyLrjVuOrgxrDDZ7mnZvZi0tUCoV+elfS1k69Rmsn8fQdxeJMda3BC6xAHGswBG+3UVScyHjBnvAqxQG72eGKa00TKNLLGX5J+pxX80So38WGL+/iiz2pBUCvZ3BSz2OU5Wd4+NTPryRpKEE2RH7diwq8tszsM5AlWIAflAOJ73r8novBXP37vMseOLP39kzOgMjvGcOedv6v+6AMmmUr2jlx64dzwxZRhYP11fQKBgQDvzeKtfnftJzI1YWhweXVZ5LZd+t1/Ez1oUj6llWRqjL7iBARoTV+u+4Y4KyQK+ND9Qj7okytdwFv+G5nonm1Wq7/NmguLD4U6mAFjDZKKC/DGavuJt7Gv4XdRRe37K1hn9cjSK7n66wadtBGwPvnjUe8HjQtCEVv1LwdlF3NLYwKBgQCTi6Tntmoy0GI9/mXHmOrF5UwyLroFy3s8dHncmKNgCMtcF8tbQIY/rTvqgFkrULvT82hiVhDv5AEdpsfHCpLC63azauaWkfItyAVmbsS67JDmd+wTnYpHe5NPkXPO1Cn8ZdCHS/D4FitCSAvOJQczKFwLJu9U47qD0Omrlgs5BwKBgDpPlg8Z8Y95OHxCc2LmJeL1+mJf3fxIcWYsmY8qBIDkOIY889Vo+xtRjhGaa+k/F5J9yU5EewcQ/02K6KHn5C5vFPSpwKTP4VWeILg1VKy8uo+E9CVIxaw+5wScPIIWyCh/W5W/jDm3bKRsZOC2b40XH0h2w4YNMo8sIGA0k5SBAoGBAIChOqfjyRv5vdxMIBFtyCe06sPJJtYMeqjO5rqhu7Tqldf4yooIa8Gx1k1vjc2MeeOjDfrFC8kH3s0p7HsjRaV3QCnU5aiZHig5fDO8F/jaaszx+bd0HeyJ2HiC1xKWtu/bF3wMgczXDumfA+O5NlisM+ppDDfWvXFTvZOgoLIbAoGBAI6O9/ipd9408mFizzpJeChSUmTL/u+L42jWprdllv0KaoadbJc2IqhSmnA3PTjRAcw1LvUtqfbDYCaMRgPcitmy2uqkOUC38faFKPOIeGhoeBofIdN7hwARn2WHreVn7ROMsk3v58PEkerMqBiKpbXBl9b4sWQhp8HeN+HRY1Q8";
    private static String rsaPublicString = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAijYIbKaxEd3VlZeCpmeZS9xwlASMwnFsMvzHSibCWU2Tu70Y9DriI0bl2F8qsBYc3+JUjlHTbG/xoBwT9QSu5PrYDX/jY0XOQzJPG2De/bzy4zJzUEnD36ygSWyV1LHXdbRiRTuulc2F4LHjpBTPTRGjoDZJevZ95LskMLSLxp8Fv4X4Y20/tERF4mEXsL4h00qoU81zcCZIUtqTCG1twa2V+i6HwK2Qw2khqd13ElTR3d0Uk4CgNe0/F7lE6pIq4N5KzJj4Ppr8wBFetyY1r44Wq5949PtuP13QHF73fMU/Des1THg0OplccEnuIoOu4rUqGWWqmYM9FLw9jzEatQIDAQAB";

    /**
     * 私钥加密
     *
     * @param encryptData
     * @param encryptKeyString
     * @param charset
     * @return
     */
    public static byte[] encrypt(String encryptData, String encryptKeyString, String charset) throws Exception {
        //获取pkcs8EncodedKeySpec
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decode(encryptKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance(rsaType);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        //加签
        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initSign(privateKey);
        signature.update(encryptData.getBytes(charset));
        byte[] signed = signature.sign();
        return signed;
    }

    /**
     * 公钥解密
     *
     * @param decryptData
     * @param encryptKeyString
     * @return
     */
    public static boolean decrypt(String sign,String decryptData, String encryptKeyString,String charset) throws Exception {
        //获取pkcs8EncodedKeySpec
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(encryptKeyString));
        KeyFactory keyFactory = KeyFactory.getInstance(rsaType);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        //加签
        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initVerify(publicKey);
        signature.update(decryptData.getBytes(charset));

        return signature.verify(Base64.decode(sign));
    }

    public static void main(String[] args) throws Exception {
        String str = "222大家好";
        //加密
        byte[] encryptByte = encrypt(str, rsaPrivateString, "UTF-8");
        String encryptData = Base64.encode(encryptByte);
        System.out.println("encryptByte:"+ Arrays.toString(encryptByte));
        System.out.println("加密Base64Encode:" + encryptData);

        //解密
        boolean t  = decrypt(encryptData,str,rsaPublicString,"UTF-8");
//        String decryptData = new String(decryptByte);

        System.out.println("decryptByte:"+ Arrays.toString(encryptByte));
        System.out.println("验签:" + t);

    }



}
