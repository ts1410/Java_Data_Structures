import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParanthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = (int)n/2;
        ArrayList<String> ans = paran(n, "", 0, 0);
        System.out.println(ans);
    }
    public static ArrayList<String> paran(int n, String ans, int op, int cl)
    {
        if(op == n && cl == n)
        {
            ArrayList<String> valid = new ArrayList<>();
            valid.add(ans);
            return valid;
        }
        else if(cl>op || cl>n || op>n)
        {
            ArrayList<String> fail = new ArrayList<>();
            return fail;
        }
        ArrayList<String> cases = new ArrayList<>();
        cases.addAll(paran(n, ans + "(", op+1, cl));
        cases.addAll(paran(n, ans + ")", op, cl+1));
        return cases;
    }
}
//import java.util.*;
//
//class Main {
//    public static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    public static void swap2(int i, int j) {
//        int temp = i;
//        i = j;
//        temp = j;
//    }
//    public static void main (String[] args) {
//        int[] arr = {1, 2, 3};
//
//        System.out.println(arr[0] + " " + arr[2]);
//        swap2(arr[0], arr[2]);
//        System.out.println(arr[0] + " " + arr[2]);
//        swap(arr, 0, 2);
//        System.out.println(arr[0] + " " + arr[2]);
//    }
//}
