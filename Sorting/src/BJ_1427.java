import java.util.Scanner;

/*
배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
입력) 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
출력) 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */
public class BJ_1427 {
    public static int solution(String str){
        int ans = 0;
        int n = str.length();
        String[] arr = str.split("");

        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = Integer.parseInt(arr[i]);
            System.out.println("arr2[i] = " + arr2[i]);
        }

        quickSort(arr2, 0, arr.length-1);
        for (int i = arr.length-1; i >= 0; i--) {
            ans += arr2[i] * Math.pow(10, i);
        }

        return ans;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right){
            return;
        }

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (arr[j] > pivot && i < j){    // pivot보다 작은값 찾으면 stop
                j--;
            }

            while (arr[i] <= pivot && i < j){   // pivot보다 큰값 찾으면 stop
                i++;
            }

            swap(arr, i, j);
        }
        swap(arr, left, i); // left : pivot 자리, pivot <-> i,j (더이상 swap 할게 없음)
        return i;   // 중간 index return
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        int answer = solution(num);
        System.out.println("answer = " + answer);

        sc.close();
    }
}
