import java.util.*;
//
//public class Palindromic_Partition {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        int count = s.length() - 1;
//        count = Math.min(count, palindromicPartitioning(s, "", count));
//        System.out.println(--count);
//    }
//    public static boolean isPalindrome(String str)
//    {
//        int i = 0; int j = str.length() - 1;
//        while(i<=j)
//        {
//            if(str.charAt(i) != str.charAt(j))
//                return false;
//            i++;
//            j--;
//        }
//        return true;
//    }
//    public static int palindromicPartitioning(String ques, String ans, int count)
//    {
//        if(ques.length() == 0)
//        {
////            System.out.println(ans);
//            int c = 0;
//            for(int a = 0; a<ans.length(); a++)
//                if(Character.isWhitespace(ans.charAt(a)))
//                    c++;
//            return c;
//        }
//        for (int i = 1; i<=ques.length(); i++)
//        {
//            String part = ques.substring(0, i);
//            String roq = ques.substring(i);
//            if(isPalindrome(part))
//            {
//                count = Math.min(count, palindromicPartitioning(roq, ans + part + " ", count));
//            }
//        }
//        return count;
//    }
//}
public class Palindromic_Partition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int i = 0; int j = s.length() - 1;
        int ans = j;
        ans = solve(s, i, j, ans);
        System.out.println(ans);
    }
    public static boolean isPalindrome(String str)
    {
        int i = 0; int j = str.length() - 1;
        while(i<=j)
        {
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static int solve(String s, int i, int j, int ans)
    {
        if(i>=j)
            return 0;
        if(isPalindrome(s.substring(i, j + 1)))
            return 0;
        for(int k = i; k<j; k++)
        {
            int temp = solve(s, i, k, ans) + solve(s, k+1, j, ans) + 1;
            ans = Math.min(ans, temp);
        }
        System.out.println(i + " " + j + " " + ans);
        return ans;
    }
}