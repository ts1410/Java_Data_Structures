import java.util.ArrayList;

public class Letter_Tiles {
    public static void main(String[] args) {
        String tiles = "AAB";
        ArrayList<String> curr = new ArrayList<>();
        curr = letter_tile(tiles, curr);
        System.out.println(curr.size() - 1);
    }
    public static ArrayList<String> letter_tile(String tiles, ArrayList<String> curr)
    {
        if(tiles.length() == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            curr.add("");
            return base;
        }
        char ch = tiles.charAt(0);
        String ros = tiles.substring(1);
        ArrayList<String> temp = new ArrayList<String>(letter_tile(ros, curr));
//        ArrayList<String> curr = new ArrayList<>();
        for(String a:temp)
        {
            for(int j = 0; j<=a.length(); j++)
            {
                String var = a.substring(0, j) + ch + a.substring(j);
                if(!curr.contains(var))
                    curr.add(var);
            }
        }
        return curr;
    }
}
