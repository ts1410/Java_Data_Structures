import java.util.ArrayList;
import java.util.Scanner;

public class Virtusa {
    static int ans = 0;
    public static void main(String[] args) {
        int comicBooks = 4;
        int coins = 8;
        int coinsNeeded = 4;
        int coinsOffered = 3;
        int temp = 0;
        calc(comicBooks, coins, coinsNeeded, coinsOffered, temp);
        System.out.println(ans);

    }
    public static void calc(int comicBooks, int coins, int coinsNeeded, int coinsOffered, int temp)
    {
        if(comicBooks == 0) {
            if (temp > ans && coins>=coinsNeeded)
                ans = temp;
            return;
        }
        calc(comicBooks - 1, coins + coinsOffered, coinsNeeded, coinsOffered, temp);
        calc(comicBooks - 1, coins - coinsNeeded, coinsNeeded, coinsOffered, temp + 1);
    }
}
