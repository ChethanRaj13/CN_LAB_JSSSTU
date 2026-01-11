import java.util.*;
import java.net.*;
import java.io.*;

public class Lab5server {
    public static void main(String[] args) throws Exception{
        ServerSocket sersock = new ServerSocket(4000);
        Socket sock = sersock.accept();
        
        InputStream istream = sock.getInputStream();
        OutputStream ostream = sock.getOutputStream();

        BufferedReader namereader = new BufferedReader(new InputStreamReader(istream));
        PrintWriter pwrite = new PrintWriter(ostream,true);

        String fname = namereader.readLine();

        try{
            BufferedReader contextreader = new BufferedReader(new FileReader(fname));
            String str;
            while((str = contextreader.readLine()) != null){
                pwrite.println(str);
            }
            contextreader.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally{
            namereader.close();
            sock.close();
            sersock.close();
            pwrite.close();
        }
    }
}
