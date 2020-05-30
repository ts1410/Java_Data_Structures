import java.util.LinkedList;
import java.util.Scanner;
import java.util.Deque;

public class BuildHeap {
    int swaps = 0;
    Deque<String> swapList = new LinkedList<>();
    public int[] shiftDown(int[] arr, int i, int n )
    {
        int minChildIndex = i;
        int leftChild, rightChild;
        while (i<=n)
        {
            leftChild = 2*i + 1;
            rightChild = 2*i + 2;
            if(leftChild<n && arr[leftChild]<arr[i])
                minChildIndex = leftChild;
            if(rightChild<n && arr[rightChild]<arr[minChildIndex])
                minChildIndex = rightChild;
            String s = new String();
            if(i != minChildIndex)
            {
                s = "";
                int temp = arr[i];
                arr[i] = arr[minChildIndex];
                arr[minChildIndex] = temp;
                swaps += 1;
                s = s.concat(Integer.toString(i) + " " + Integer.toString(minChildIndex));
                swapList.addLast(s);
                i = minChildIndex;
            }
            else
                break;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        BuildHeap ob = new BuildHeap();
        for (int i = n/2-1; i>=0; i--)
        {
            arr = ob.shiftDown(arr ,i, n);
        }
        System.out.println(ob.swaps);
        for (int i =0; i<ob.swaps; i++)
            System.out.println(ob.swapList.removeFirst());
    }
}
