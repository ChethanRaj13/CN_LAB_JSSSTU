import java.util.*;

public class Lab9{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter the capacity of the Queue");
        int cap = sc.nextInt();

        System.out.println("Enter the min Threshold:");
        int minth = sc.nextInt();

        System.out.println("Enter the maximum threshold");
        int maxth = sc.nextInt();

        System.out.println("Enter the number of Packets: ");
        int n = sc.nextInt();
        
        int queuesize = 0;
        
        double avg = 0.0;
        double wq = 0.002;
        double maxp = 0.1;
        int count = -1;

        for(int i = 0; i < n; i++){
            avg = (1-wq) * avg + wq * queuesize;

            if(avg < minth){
                count = -1;

                if(queuesize <= cap){
                    queuesize++;
                    System.out.println("Packet accepted | queue size = " + queuesize);
                }else{
                 System.out.println("Packet is dropped because Queue is full");   
                }
            }
            else if(avg >= maxth){
                count = -1;
                System.out.println("Packet dropped because max threshold");
            }
            else{
                count++;
                double pb = maxp * (avg - minth) / (maxth - minth);
                double pa = pb / (1 - count * pb);
                
                if(rand.nextDouble() < pa){
                    count = 0;
                    System.out.println("Dropped due to random early detection");
                } else{
                    if(queuesize < cap){
                        queuesize++;
                        System.out.println("Packet accepted | Queue size = " + queuesize);
                    } else{
                        System.out.println("Packet is dropped because Queue is full");
                    }
                }
            }
        }
        sc.close
    }
}
