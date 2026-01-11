import java.util.*;

public class Lab8b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the capacity: ");
        int cap = sc.nextInt();

        System.out.println("Enter the rate of tokens generated: ");
        int gen = sc.nextInt();

        System.out.println("Enter the packets going to arrive: ");
        int n = sc.nextInt();

        int token = 0;

        for(int i = 0; i < n; i++){
            token += gen;
            if(token >= cap) token = cap;

            System.out.println("Enter the size of packets arrived: ");
            int pkt = sc.nextInt();

            if(token >= pkt){
                token -= pkt;
                System.out.println("The packet was accepted");
            }
            else{
                System.out.println("Packet was dropped");
            }
        }
    }
}
