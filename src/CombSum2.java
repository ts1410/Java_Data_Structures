import java.util.ArrayList;
import java.util.List;

public class CombSum2 {
    public static void main(String[] args) {
        int k = 3; int n = 7;
        List<List<Integer>> ans = new ArrayList<>();
        combSum2(k, n, 0, ans, new ArrayList<Integer>());
        System.out.println(ans);
    }
    public static void combSum2(int k, int n, int lastUsed, List<List<Integer>> ans, ArrayList<Integer> temp)
    {
        if(n == 0 && temp.size() == k)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(temp.size() == k || n == 0)
            return;
        for(int i = lastUsed + 1; i<10; i++)
        {
            if(i<=n)
            {
                temp.add(i);
                combSum2(k, n-i, i, ans, temp);
                if(temp.size()!=0)
                    temp.remove(temp.size() - 1);
            }
        }
    }
}
