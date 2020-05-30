import java.util.Scanner;

public class Knapsack {
    public static int max(int a, int b)
    {
        if(a>b)
            return a;
        return b;
    }
    private static int getValue(int W, int n, int wt[]) {
        int i, j;
        int[][] ans = new int[n + 1][W + 1];
        for(i = 0; i <= n; i++)
            ans[i][0] = 0;
        for(i = 0; i<= W; i++)
            ans[0][i] = 0;

        for(i = 1; i<=n; i++)
            for(j = 1; j<= W; j++)
            {
                if(wt[i] <= j)
                    ans[i][j] = max(wt[i] + ans[i - 1][j - wt[i]], ans[i - 1][j]);
                else
                    ans[i][j] = ans[i - 1][j];
            }

        return ans[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int n = sc.nextInt();
        int[] wt = new int[n + 1];
        int i;
        wt[0] = 0;
        for(i = 1; i<=n; i++)
            wt[i] = sc.nextInt();
        System.out.println(getValue(W, n, wt));
    }
}
