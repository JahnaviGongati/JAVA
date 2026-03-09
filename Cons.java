import java.util.*;
class Cons {
    Cons(int a, int b) {
        System.out.println(a + b);
    }
    Cons(double x, double y) {
        System.out.println(x + y);
    }
    Cons(int m, int n, int o) {
        System.out.println(m + n + o);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        new Cons(a, b);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        new Cons(x, y);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int o = sc.nextInt();
        new Cons(m, n, o);
    }
}
