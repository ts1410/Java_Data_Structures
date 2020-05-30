import java.util.Scanner;
import java.util.ArrayList;

public class ProcessPackages {
    public static class packages{
        long arr;
        long duration;
        long acess_time;

        public packages(long arr, long duration)
        {
            this.arr = arr;
            this.duration = duration;
        }
    }
    public static void process(int S, long n)
    {
        long[] buffer = new long[S + 1];
        for (int i = 0; i<S+1; i++)
            buffer[i] = -1;
        int front = 0;
        int rear = 0;
        Scanner sc = new Scanner(System.in);
        ArrayList<packages> packages = new ArrayList<packages>();

        for (int i = 0; i<n; i++)
        {
            packages.add(new packages(sc.nextLong(), sc.nextInt()));
        }
        long time = 0;
        for(int i = 0; i<n; i++)
        {
            if (front - rear == 2 && buffer[rear+1] == -1)               //Queue is full
            {
                packages.get(i).acess_time = -1;
            }
            else
            {
                buffer[rear] = i;
                rear = (rear + 1)%S;
                if(packages.get(i).arr > time)
                    packages.get(i).acess_time = packages.get(i).arr;
                else
                    packages.get(i).acess_time = time;
                time += packages.get(i).duration;
                buffer[i] = -1;
                front = (front + 1)%S;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        long n = sc.nextLong();
        process(S, n);
    }
}
