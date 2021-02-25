package client_udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client_UDP {
    public static void main(String[] args) throws SocketException, IOException, UnknownHostException {
        DatagramSocket ds = new DatagramSocket();
        System.out.println("client is started and ready..");
        
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your msg:");
        String msg= sc.nextLine();
        byte b[]=msg.getBytes(); //convert msg into bytes
        
        InetAddress ia = InetAddress.getByName("localhost"); //get ip address
        
        DatagramPacket dp = new DatagramPacket(b,b.length,ia,1234); //send karnaa ho to ip address ki jarur padegi
        ds.send(dp); //send packet to server
        System.out.println("packets send successfully"+"\n");
        
        ////now this all portion for recieving msg 
        byte  b1[]=new byte[1000];
        
        DatagramPacket dp1 = new DatagramPacket(b1,b1.length);
        ds.receive(dp1);
        
        String str =new String(dp1.getData());
        
        System.out.println("responce from server:"+str);
        
        ds.close();
    }
    
}
