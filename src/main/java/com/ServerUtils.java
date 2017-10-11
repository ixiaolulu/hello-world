package com;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 获取服务器信息工具类
 * author: alaskwang
 * date: 2017/7/24
 */
@Slf4j
public class ServerUtils {
    public static volatile String localIP = StringUtils.EMPTY;

    public static String getLocalMachineIP() {
        if (localIP.equals(StringUtils.EMPTY)) {
            synchronized (localIP) {
                if (localIP.equals(StringUtils.EMPTY)) {
                    localIP = getLocalInnerIP();
                }
            }
        }
        return localIP;
    }


    public static void main(String[] args) {


        String str = StringUtils.EMPTY;
        System.out.println(str == "");
        System.out.println(str.equals(""));

        String str1 = new String("");
        System.out.println(str1 == "");
        System.out.println(str1.equals(""));

//        new Thread(){
//            public void run(){
//                String localIp = ServerUtils.getLocalMachineIP();
//                System.out.println("1:"+localIp);
////                ServerUtils.localIP = localIp;
//
//            }
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                String localIp = ServerUtils.getLocalMachineIP();
//                System.out.println("2:"+localIp);
//            }
//        }.start();
    }

    /**
     * 获取服务器内网ip地址，方便问题查询
     *
     * @return 服务器内网ip
     */
    private static String getLocalInnerIP() {

        Enumeration allNetInterfaces = null;
        try {
            allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (java.net.SocketException e) {
            e.printStackTrace();
        }
        InetAddress ip = null;
        if (allNetInterfaces != null) {
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = (InetAddress) addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address) {
                        if (ip.getHostAddress().equals("127.0.0.1")) {
                            continue;
                        }
                        localIP = ip.getHostAddress();
                    }
                }
            }
        }
        if (StringUtils.isEmpty(localIP)) {
            log.error("网络无连接！");
        }
        return localIP;
    }

}
