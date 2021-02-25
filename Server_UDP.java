package server_udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Server_UDP {
    public static void main(String[] args)throws SocketException, IOException {
        DatagramSocket ds = new DatagramSocket(1234); //1234 is port number
        System.out.println("server is started and ready...");
        
        byte b[] = new byte[1000];
        DatagramPacket dp = new DatagramPacket(b,b.length);
        ds.receive(dp); //recieve the msg from client
        
        String str = new String(dp.getData());   // convert into string
        System.out.println("recieved:"+str);
        System.out.println("msg recieved successfully."+"\n");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("enter response msg:");
        String msg = sc.nextLine();
        byte b1[]= msg.getBytes();
        
        InetAddress ai = InetAddress.getByName("localhost");
        
        DatagramPacket dp1 = new DatagramPacket(b1,b1.length,ai,dp.getPort());
        
        ds.send(dp1);
        
        ds.close();
        
    }
    
}
