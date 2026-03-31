import java.util.Scanner;

public class pattern {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = makePattern(n);
        System.out.println(s);
    }
    public static String makePattern(int n) {
        String s = "";
        for (int i = 1; i <=n ; i++) {
            for (int j = (n)-i; j >0 ; j--) {
                s =s +" ";
            }
            for (int j = 1; j <=(2*i)-1; j++) {
                s += "*";
            }
            s = s+"\n";
        }
        return s;
    }
}
