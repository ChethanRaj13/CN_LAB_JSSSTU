import java.util.*;

public class Lab9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter the Queue Size: ");
        int cap = sc.nextInt();

        System.out.println("Enter the max Threshole: ");
        int maxth = sc.nextInt();
        System.out.println("Enter the min Threshole: ");
        int minth = sc.nextInt();

        System.out.println("Enter the number of packets: ");
        int n = sc.nextInt();

        int que_size = 0;

        for(int i = 0; i < n; i++){
            System.out.println("Enter the packects arrived: ");
            int pkt = sc.nextInt();

            for(int j = 0; j < pkt; j++){
                if(que_size <= minth){
                   que_size++; 
                   System.out.println("packet accepted and queue size: " + que_size);
                }
                else if(que_size > minth && que_size <= maxth){
                    double prob = (que_size - minth) / (maxth - minth);
                    double drop = rand.nextDouble();
                    if(prob > drop){
                        System.out.println("packet has been dropped");
                        que_size--;
                    }
                    else{
                        que_size++;
                        System.out.println("packet accepted and queue size: " + que_size);
                    }
                }
                else{
                    System.out.println("packet has been dropped");
                }

                if(que_size > cap){
                    que_size = cap;
                }
            }
        }
        
    }
}
