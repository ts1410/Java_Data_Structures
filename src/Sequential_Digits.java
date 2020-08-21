import java.util.ArrayList;

public class Sequential_Digits {
    public static void main(String[] args) {
        int low = 100;
        int high = 300;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i<10; i++)
            sequential(i, low, high, ans);
        System.out.println(ans);
    }
    public static void sequential(int num, int low, int high, ArrayList<Integer> ans)
    {
        if(num>high)
            return;
        else if(num>=low) {
            ans.add(num);
        }
        int curr = num%10;
        if(curr==9)
            return;
        sequential(num*10 + (curr + 1), low, high, ans);
    }
}
