import java.net.*;
import java.io.*;
import java.util.*;

public class Lab6server {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        DatagramSocket datagramSocket = new DatagramSocket();

        InetAddress clientAddress = InetAddress.getByName("127.0.0.1");

        String message;
        byte[] buffer;
        DatagramPacket datagramPacket;
        System.out.println("Enter the message to send: ");
        while(true){
            message = sc.nextLine();
            buffer = message.getBytes();
            datagramPacket = new DatagramPacket(buffer, buffer.length, clientAddress, 4000);
            datagramSocket.send(datagramPacket);

            if(message.equals("exit")){
                datagramSocket.close();
                break;
            }
        }
    }
}
