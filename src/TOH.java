import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

//arr1 = sortArray(arr1);
//arr2 = sortArray(arr2);
//if(arr1[0]<arr2[0])
//    return arr1[0];
//return arr2[0];