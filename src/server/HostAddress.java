package server;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

public class HostAddress {
    public static void main(String[] args){
        String[] adrss = getHostAddresses();
        for(String s: adrss)
            System.out.println(s);
    }
    public static void printIPAddresses(){
        String[] adrss = getHostAddresses();
        for(String s: adrss)
            System.out.println(s);
    }

    public static String[] getHostAddresses() {
        Set<String> HostAddresses = new HashSet<>();
        try {

            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            List<NetworkInterface> list = Collections.list(en);

            for (NetworkInterface ni : list) {
                if (!ni.isLoopback() && ni.isUp() && ni.getHardwareAddress() != null) {
                    for (InterfaceAddress ia : ni.getInterfaceAddresses()) {
                        if (ia.getBroadcast() != null) {  //If limited to IPV4
                            HostAddresses.add(ia.getAddress().getHostAddress());
                        }
                    }
                }
            }
        } catch (SocketException e) { }

        return HostAddresses.toArray(new String[0]);
    }
}
