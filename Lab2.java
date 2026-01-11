import java.util.*;

class Frames{
    int id;
    String msg;
    Frames(int id, String msg){
        this.id = id;
        this.msg = msg;
    }
}

public class Lab2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of frames");
        int n = sc.nextInt();
        Frames[] frames = new Frames[n];
        for(int i = 0; i < n; i++){
            System.out.println("Enter the frame id: ");
            int id = sc.nextInt();
            System.out.println("Enter the message: ");
            String msg = sc.next();
            frames[i] = new Frames(id, msg);
        }

        for(Frames f : frames){
            System.out.print(f.msg + " ");
        }

        System.out.println();

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(frames[j].id > frames[j+1].id){
                    Frames temp = frames[j];
                    frames[j] = frames[j+1];
                    frames[j+1] = temp;
                }
            }
        }
        for(Frames f : frames){
            System.out.print(f.msg + " ");
        }
    }   
}