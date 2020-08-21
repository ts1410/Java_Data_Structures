import java.util.ArrayList;

public class SubsetTargetSum {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1,2,3};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int target = 3;
        subsetsum(arr, target, -1, 0, ans, new ArrayList<Integer>());
        for(ArrayList<Integer> pr : ans)
        {
            for(int i : pr)
            {
                System.out.print(i + " ");
            }
            System.out.print(' ');
        }
        System.out.println("\n" + ans.size());
    }
    public static void subsetsum(int[] arr, int target, int lastIndex, int currSum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp)
    {
        if(currSum == target)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = lastIndex + 1; i<arr.length; i++)
        {
            if(currSum + arr[i]<=target){
                temp.add(arr[i]);
                subsetsum(arr, target, i, currSum + arr[i], ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
