import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point>{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x < o.x){
            return -1;
        } else if (this.x == o.x){
            if (this.y < o.y){
                return -1;
            } else if (this.y == o.y){
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
public class BJ_11650 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Point[] list = new Point[N];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[i] = new Point(a, b);
        }
        Arrays.sort(list);
        for (Point p : list){
            sb.append(p.x+ " "+ p.y+"\n");
        }

        System.out.println(sb);
        sc.close();
    }
}