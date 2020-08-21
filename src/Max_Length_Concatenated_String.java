import java.util.ArrayList;

public class Max_Length_Concatenated_String {
    static int len = 0;
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("un");
        s.add("iq");
        s.add("ue");
        subs(s, "", -1);
        System.out.println(len);
    }
    public static void subs(ArrayList<String> s, String ans, int lastIndex)
    {
        if(!isUnique(ans))
        {
            return;
        }
        len = Math.max(len, ans.length());
        for(int i = lastIndex + 1; i<s.size(); i++)
        {
            subs(s, ans + s.get(i), i);
        }
    }
    public static boolean isUnique(String s)
    {
        int[] freq = new int[26];
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(freq[ch - 'a'] > 0)
            {
                return false;
            }
            else
            {
                freq[ch - 'a']++;
            }
        }
        return true;
    }
}
