import java.util.Arrays;
import java.util.Scanner;

class Point2 implements Comparable<Point2>{
    int x,y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point2 o) {
        if (this.y < o.y){
            return -1;
        } else if (this.y == o.y){
            if (this.x < o.x){
                return -1;
            } else if (this.x == o.x){
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class BJ_11651 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Point2[] list = new Point2[N];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[i] = new Point2(a, b);
        }
        Arrays.sort(list);
        for (Point2 p : list){
            sb.append(p.x+ " "+ p.y+"\n");
        }

        System.out.println(sb);
        sc.close();
    }
}