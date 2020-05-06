package com.tabuyos.shiro.test;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author Tabuyos
 * @Time 2020/5/7 0:31
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
public class Tabuyos {
    public static void main(String[] args) {
        String hashAlgorithmName = "md5";
        String credentials = "123456";//密码
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes("root");//账号
        System.out.println(credentialsSalt);
        String  obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations).toHex();
        System.out.println(obj);
    }
}
