import java.util.*;

public class Lab3 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String poly = "1000010001001010";

        System.out.println("Enter the message: ");
        String msg = sc.nextLine();

        String rem = CRC(msg,poly,false);

        String codeword = msg + rem;

        System.out.println("reminder: " + rem);
        System.out.println("Codeword: " + codeword);

        System.out.println("Enter the message recieved: ");
        String rcv = sc.nextLine();

        String remrcv = CRC(rcv,poly,true);
        
        if(Integer.parseInt(remrcv) == 0){
            System.out.println("No Error");
        }
        else{
            System.out.println("There is an error");
        }
    }
    
    public static String CRC(String msg, String poly, boolean errchk) {
        StringBuilder data = new StringBuilder(msg);
        if(!errchk){
            for(int i = 0; i < poly.length() -1; i++){
                data.append("0");
            }
        }

        for(int i = 0; i <= data.length() - poly.length(); i++){
            if(data.charAt(i) == '1'){
                for(int j = 0; j < poly.length(); j++){
                    int bit = data.charAt(i+j);
                    int p = poly.charAt(j);
                    data.setCharAt(i+j, bit == p ? '0' : '1');
                }
            }
        }
        return data.substring(data.length()-poly.length()+1);      
    }
}
