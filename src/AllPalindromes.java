import java.util.ArrayList;

public class AllPalindromes {
    public static void main(String[] args) {
        String s = "aab";
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        palindrome(s, ans, new ArrayList<String>());
        System.out.println(ans);
    }
    public static boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length() - 1;
        while(i<=j)
        {
            if(s.charAt(i) == s.charAt(j))
            {
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }
    public static void palindrome(String ques, ArrayList<ArrayList<String>> ans, ArrayList<String> temp)
    {
        if(ques.length() == 0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 1; i<=ques.length(); i++)
        {
            String part = ques.substring(0, i);
            String roq = ques.substring(i);
            if(isPalindrome(part))
            {
                temp.add(part);
                palindrome(roq, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
