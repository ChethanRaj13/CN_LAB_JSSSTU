import java.io.*;
import java.util.*;
import java.net.*;

public class Lab6client {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(4000);
        byte[] buffer;
        DatagramPacket datagramPacket;
        System.out.println("the messages from server");
        while(true){
            buffer = new byte[65555];
            datagramPacket = new DatagramPacket(buffer,buffer.length);
            datagramSocket.receive(datagramPacket);
            String received = new String(buffer).trim();
            System.out.println(received);
            if(received.equals("exit")){
                datagramSocket.close();
                break;
            }
        }
    }
}
