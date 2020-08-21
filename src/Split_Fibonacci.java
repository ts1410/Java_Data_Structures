import java.util.ArrayList;
import java.util.List;

public class Split_Fibonacci {
    static boolean flag = false;
    public static void main(String[] args) {
        String s = "11235813";
        List<Integer> ans = new ArrayList<>();
        split(s, ans, new ArrayList<>());
        System.out.println(ans);
    }
    public static boolean isInrange(String roq)
    {
        if(roq.length() >= 11)
            return false;
        long l = Long.parseLong(roq);
        return l <= (Math.pow(2, 31) - 1);
    }
    public static void split(String s, List<Integer> ans, ArrayList<Integer> temp) {
        if (s.length() == 0) {
            if(temp.size() > 2)
            {
                ans.addAll(temp);
                flag = true;
            }
            return;
        }
        for (int i = 1; i <= s.length() && i<=10; i++) {
            if (flag == true) {
                return;
            }
            String roq = s.substring(0, i);
            String ques = s.substring(i);
            if (isInrange(roq) && isFibo(temp, roq) && isLeading(roq)) {
                temp.add(Integer.parseInt(roq));
                split(ques, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static boolean isFibo(ArrayList<Integer> temp, String roq)
    {
        if(temp.size()<=1)
        {
            return true;
        }
        return temp.get(temp.size() - 1) + temp.get(temp.size() - 2) == Integer.parseInt(roq);
    }
    public static boolean isLeading(String roq)
    {
        if(roq.length()<=1)
        {
            return true;
        }
        return (int)roq.charAt(0) != 0;
    }
}
