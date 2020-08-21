import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> res = new ArrayList<>();
        subset(nums, new ArrayList<Integer>(), res, 0);
        System.out.println(res);
    }
    public static void subset(int[] nums, ArrayList<Integer> curr, List<List<Integer>> res, int index)
    {
        if(!res.contains(curr))
            res.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++)
        {
            curr.add(nums[i]);
            subset(nums, curr, res, i+1);
            curr.remove(curr.size() - 1);
        }
    }
}
