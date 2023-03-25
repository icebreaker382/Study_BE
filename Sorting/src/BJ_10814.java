import java.util.Arrays;
import java.util.Scanner;

class Age implements Comparable<Age>{
    int x,y;
    String n;

    public Age(int x, int y, String n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    @Override
    public int compareTo(Age o) {
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

public class BJ_10814 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Age[] list = new Age[N];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            String n = sc.nextLine();
            int b = i;
            if (a >= 1 && a <= 200 && n.length() <= 100){
                list[i] = new Age(a, b, n);
            }
        }
        Arrays.sort(list);
        for (Age p : list){
            sb.append(p.x+ " "+ p.n+"\n");
        }

        System.out.println(sb);
        sc.close();
    }
}