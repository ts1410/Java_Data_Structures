import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AdditiveNumbers {
    static boolean flag = false;
    public static void main(String[] args) {
        String s = "1023";
        solve(s, new ArrayList<>());
        System.out.println(flag);
    }
    public static void solve(String s, List<BigInteger> temp)
    {
        if(s.length() == 0)
        {
            if(temp.size()>2)
                flag = true;
            return;
        }
        for(int i = 1; i<=s.length(); i++)
        {
            String part = s.substring(0, i);
            String ques = s.substring(i);
            BigInteger num = new BigInteger(part);
            if(isAdditive(temp, num) && isLeading(part))
            {
                temp.add(num);
                solve(ques, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static boolean isLeading(String roq)
    {
        if(roq.length()<=1)
        {
            return true;
        }
        return (int)roq.charAt(0) != 0;
    }
    public static boolean isAdditive(List<BigInteger> temp, BigInteger num)
    {
        if(temp.size()<=1)
        {
            return true;
        }
        BigInteger last = temp.get(temp.size() - 1);
        BigInteger secondLast = temp.get(temp.size() - 2);
        BigInteger res = last.add(secondLast);

        return res.compareTo(num) == 0;
    }
}
