import java.util.*;

public class Lab7 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two large prime numbers(p,q): ");
        int p = sc.nextInt();
        int q = sc.nextInt();
        int n = p*q;

        int phi = (p-1)*(q-1);

        int e = 7;
        while(gcd(e,phi) != 1) e++;

        int d = 0;
        for(int i = 0; i < phi; i++){
            if((i * e) % phi == 1){
                d = i;
                break; 
            }
        }

        System.out.println("public key("+e+","+n+")");
        System.out.println("public key("+d+","+n+")");


        System.out.println("Enter the message: ");
        int msg = sc.nextInt();

        int encrypt = modpow(msg,e,n);
        int decrypt = modpow(encrypt,d,n);

        System.out.println("Encrypted message: " + encrypt);
        System.out.println("Decrypted message: " + decrypt);
    }    
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static int modpow(int base, int expo, int mod){
        int result = 1;
        base = base % mod;
        while(expo > 0){
            if((expo & 1) == 1){
                result = (result * base) % mod;
            }
            expo = expo >> 1;
            base = (base * base) % mod;
        }
        return result;
    }
}
