import java.util.Scanner;

public class TOH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        toh(n, "A", "B", "C");
    }
    public static void toh(int n, String src, String dest, String helper)
    {
        if(n == 0)
        {
            return;
        }
        toh(n - 1, src, helper, dest);
        System.out.println("Moving ring " + n + " from " + src + " to " + dest);
        toh(n - 1, helper, dest, src);
    }
}
