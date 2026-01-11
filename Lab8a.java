import java.util.*;

public class Lab8a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the capacity of the bucket: ");
        int cap = sc.nextInt();

        System.out.println("Enter the rate: ");
        int rate = sc.nextInt();

        System.out.println("total number of packets going to arrive: ");
        int n = sc.nextInt();

        int bucket = 0;

        for(int i = 0; i < n; i++){
            System.out.println("Enter the packets: ");
            int pkt = sc.nextInt();

            bucket += pkt;

            if(bucket > cap){
                int drop = bucket - cap;
                System.out.println("dropped packets - " + drop);
                bucket = cap;
            }
            bucket -= rate;
            if(bucket < 0 ){
                bucket = 0;
            }
            System.out.println("Bucket after leaked " + bucket);
        }
    }
}
