import java.util.ArrayList;

public class Combinations_Leetcode {
    public static void main(String[] args) {
        int n = 4; int k = 2;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        comb(n, k, 0, new ArrayList<Integer>(), ans);
        System.out.println(ans);
    }
    public static void comb(int n, int k, int lastUsed, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans)
    {
        if(temp.size() == k)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = lastUsed + 1; i<=n; i++)
        {
            temp.add(i);
            comb(n, k, i, temp, ans);
            if(temp.size()!=0)
                temp.remove(temp.size() - 1);
        }
    }
}
