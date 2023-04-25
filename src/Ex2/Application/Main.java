package Ex2.Application;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        Set<Integer> C = new HashSet<>();

        System.out.print("how many students for course A?" );
        int n = scan.nextInt();

        for(int i = 0; i < n; i ++){
           int cod = scan.nextInt();
           A.add(cod);
         }

        System.out.print("how many students for course B?");
        n = scan.nextInt();

        for(int i = 0; i < n; i ++){
            int cod = scan.nextInt();
            B.add(cod);
        }

        System.out.print("how many students for course C?");
        n = scan.nextInt();

        for(int i = 0; i < n; i ++){
            int cod = scan.nextInt();
            C.add(cod);
        }

        Set<Integer> total = new HashSet<>(A);
        total.addAll(B);
        total.addAll(C);

        System.out.println("Total students: " + total.size());
    }
}
