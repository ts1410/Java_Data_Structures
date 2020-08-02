import java.util.ArrayList;
import java.util.Scanner;

public class Permutations {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> ans = perm(s);
        System.out.println(ans);
    }
    public static ArrayList<String> perm(String s)
    {
        if(s.length() == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = s.charAt(0);
        String ros = s.substring(1);
        ArrayList<String> temp = new ArrayList<>();
        temp = perm(ros);
        ArrayList<String> ans = new ArrayList<>();
        for (String a:temp)
        {
            for(int i = 0; i<=a.length(); i++)
            {
                ans.add(a.substring(0, i) + ch + a.substring(i));
            }
        }
        return ans;
    }
}
