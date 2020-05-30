import java.util.Scanner;

public class MoneyChange {
    private static int getChange(int n) {
        //write your code here
        int[] coins = new int[]{1, 3, 4};
        int minNum[] = new int[n+1];
        minNum[0] = 0;

        for (int i = 1; i <= n; i++)
        {
            minNum[i] = 9999;
            for (int j = 0; j < coins.length; j++)
            {
                if(coins[j] <= i)
                {
                    int num = minNum[i - coins[j]] + 1;
                    if (num < minNum[i])
                        minNum[i] = num;
                }
            }
        }
        return minNum[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}
