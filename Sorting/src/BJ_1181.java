import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BJ_1181 {
    public static void solution(String[] arr){
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2){
                // 단어 길이가 같을 때
                if (s1.length() == s2.length()){
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        System.out.println(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            // 중복되지 않는 단어만 출력
            if (!arr[i].equals(arr[i-1])){
                System.out.println(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        sc.nextLine();

        String[] arr = new String[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextLine();
        }
        solution(arr);

        sc.close();
    }
}
