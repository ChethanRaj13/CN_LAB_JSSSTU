import java.util.*;
import java.net.*;
import java.io.*;

public class Lab5client {
    public static void main(String[] args) throws Exception{
        Socket sock = new Socket("127.0.0.1",4000);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fname =  sc.nextLine();

        InputStream istream = sock.getInputStream();
        OutputStream ostream = sock.getOutputStream();

        PrintWriter pwrite = new PrintWriter(ostream,true);
        pwrite.println(fname);

        BufferedReader contentreader = new BufferedReader(new InputStreamReader(istream));
        String str;

        while((str = contentreader.readLine()) != null){
            System.out.println(str);
        }
        contentreader.close();
        sock.close();
        pwrite.close();
    }
}
