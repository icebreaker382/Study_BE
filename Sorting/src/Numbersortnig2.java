import java.util.Arrays;
        import java.util.Scanner;

public class Numbersortnig2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for(int print :arr){
            stringBuilder.append(print+"\n");
        }
        System.out.println(stringBuilder);
    }
}