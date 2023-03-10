import java.util.*;

public class BJ_2587 {

    public static void main(String[] args){
        int[] arr = new int[5];
        int sum = 0;
        int avg = 0;
        int mid = 0;

        Scanner sc = new Scanner(System.in);
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        for(int i=0; i<arr.length;i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] > arr[j]){
                    int k = arr[i];
                    arr[i] = arr[j];
                    arr[j] = k;
                }
            }
        }

        avg = sum/5;
        mid = arr[2];

        System.out.println(avg);
        System.out.println(mid);

        sc.close();
    }
}
