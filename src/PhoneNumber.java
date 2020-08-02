import java.util.ArrayList;
import java.util.HashMap;

public class PhoneNumber {
    public static void main(String[] args) {
        HashMap<Character, String> phoneNumber = new HashMap<>();
        phoneNumber.put('2', "abc");
        phoneNumber.put('3', "def");
        phoneNumber.put('4', "ghi");
        phoneNumber.put('5', "jkl");
        phoneNumber.put('6', "mno");
        phoneNumber.put('7',"pqrs");
        phoneNumber.put('8', "tuv");
        phoneNumber.put('9', "wxyz");
        String digits = "23567";
        int i = 0;
        ArrayList<String> myRes = compute(digits, phoneNumber, i);
        System.out.println(myRes);
    }
    public static ArrayList<String> compute(String digits, HashMap<Character, String> phoneNumber, int i)
    {
        if(i == digits.length() - 1)
        {
            ArrayList<String> temp = new ArrayList<>();
            for(int a = 0; a<phoneNumber.get(digits.charAt(digits.length() - 1)).length(); a++)
            {
                temp.add(Character.toString(phoneNumber.get(digits.charAt(i)).charAt(a)));
            }
            return temp;
        }
        ArrayList<String> myRes = new ArrayList<>();
        ArrayList<String> rss = compute(digits, phoneNumber, i+1);
        for(int j = 0; j<rss.size(); j++)
        {

            for(int k = 0; k<phoneNumber.get(digits.charAt(i)).length(); k++)
            {
                myRes.add(Character.toString(phoneNumber.get(digits.charAt(i)).charAt(k)) + rss.get(j));
            }
        }
        return myRes;
    }
}
