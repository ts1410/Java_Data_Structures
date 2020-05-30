import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] array = new int[l];
        for (int i = 0;i<l; i++)
        {   
            array[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i<k; i++)
        {
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i])
                deque.removeLast();
            deque.addLast(i);
        }
        for (int i = k; i<l; i++)
        {
            System.out.println(array[deque.peekFirst()] + " ");
            while(!deque.isEmpty() && deque.peekFirst()<= i - k)
            {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && array[deque.peekLast()]<=array[i])
                deque.removeLast();
            deque.addLast(i);
        }
        System.out.println(array[deque.peekFirst()]);
    }
}

//import java.util.*;
//        import java.io.*;
//
//public class Main {
//    public static void main(String args[]) throws IOException {
//
//        //write your code here
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for(int j = 0; j<t; j++)
//        {
//            Deque<Integer> rahul = new LinkedList<Integer>();
//            Deque<Integer> ritika = new LinkedList<Integer>();
//            int rahlen = sc.nextInt();
//            int ritlen = sc.nextInt();
//            int x = sc.nextInt();
//            for (int i = 0; i<rahlen; i++)
//                rahul.addLast(sc.nextInt());
//            for (int i = 0; i<ritlen; i++)
//                ritika.addLast(sc.nextInt());
//            int max = 0;
//            int flag = 0;
//            int count = 0;
//            while(max<=x && flag == 0)
//            {
//                if(rahul.peek() < ritika.peek())
//                {
//                    if(max + rahul.peekFirst() < x)
//                    {
//                        max = max + rahul.removeFirst();
//                        count++;
//                    }
//                    else
//                        flag = 1;
//                }
//                else
//                {
//                    if(max + ritika.peekFirst() < x)
//                    {
//                        max = max + ritika.removeFirst();
//                        count++;
//                    }
//                    else
//                        flag = 1;
//                }
//            }
//            System.out.println(count);
//        }
//    }
//}