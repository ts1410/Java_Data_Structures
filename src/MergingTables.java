import java.util.*;

public class MergingTables {
    static void makeSet(int i, int[] parent, int[] rank)
    {
        parent[i] = i;
        rank[i] = 0;
    }
    static int find(int i, int[] parent)
    {
        while (i != parent[i])
            i = parent[i];
        return i;
    }
    static int union(int destination, int source, int[] parent, int[] rank, int[] rows, int max) {
        int i_id = find(destination, parent);
        int j_id = find(source, parent);
        if (i_id == j_id)
            return max;
        else if (rank[i_id] > rank[j_id])
            parent[j_id] = i_id;
        else if (rank[j_id] > rank[i_id])
            parent[i_id] = j_id;
        else
        {
            parent[i_id] = j_id;
            rank[j_id] += 1;
        }
        rows[i_id] += rows[j_id];
        rows[j_id] = rows[i_id];
        return Math.max(max, rows[i_id]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_tables = sc.nextInt();
        int num_queries = sc.nextInt();
        int max = 0;
        int[] rows = new int[num_tables];
        int[] rank = new int[num_tables];
        int[] parent = new int[num_tables];
        for (int i = 0; i<num_tables; i++)
        {
            rows[i] = sc.nextInt();
            makeSet(i, parent, rank);
            if (max<rows[i])
                max = rows[i];
        }
        int destination;
        int source;
        for (int i = 0; i<num_queries; i++)
        {
            destination = sc.nextInt();
            destination = destination - 1;
            source = sc.nextInt();
            source = source - 1;
            max = union(destination, source, parent, rank, rows, max);
            System.out.println(max);
        }
    }
}
