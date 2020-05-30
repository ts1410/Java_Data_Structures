import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class StackWithMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> input = new ArrayList<String>();
        for(int i = 0; i<n+1; i++)
        {
            input.add(sc.nextLine());
        }
        Stack<Integer> inp_stack = new Stack<>();
        Stack<Integer> max_inp = new Stack<>();

        for (int i = 1; i<n+1; i++)
        {
            String s = input.get(i);
            if(s.equals("max"))
            {
                System.out.println(max_inp.peek());
            }
            else if(s.equals("pop"))
            {
                inp_stack.pop();
                max_inp.pop();
            }
            else
            {
                int a = Integer.parseInt(s.substring(5));
                inp_stack.push(a);
                if(max_inp.isEmpty())
                    max_inp.push(a);
                else if(a>max_inp.peek())
                    max_inp.push(a);
                else
                    max_inp.push(max_inp.peek());
            }
        }
    }
}
