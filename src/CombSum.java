import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombSum
{
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = new ArrayList<>();
        combSum(candidates, target, ans, new ArrayList<Integer>(), -1, 0);
        System.out.println(ans);
    }
    public static void combSum(int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> temp, int lastIndex, int currSum)
    {
        if(currSum == target)
        {
//            System.out.println(temp);
            Collections.sort(temp);
            if(!ans.contains(temp))
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(currSum>target)
        {
            return;
        }
        for(int i = lastIndex + 1; i<candidates.length; i++)
        {
            if(currSum + candidates[i]<=target) {
                temp.add(candidates[i]);
                combSum(candidates, target, ans, temp, i, currSum + candidates[i]);
                temp.remove(Integer.valueOf(candidates[i]));
            }
        }
    }
}