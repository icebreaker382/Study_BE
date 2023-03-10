/*
수를 처리하는 것은 통계학에서 상당히 중요한 일이다.
통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
==============
산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
==============
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
 */

import java.util.*;

public class Statistics {
    public static void solution(int[] arr) {
        // 산술평균
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        double result1 = 0;

        if (total < 0){
            result1 = Math.round(Math.abs(total/(double)arr.length) * -1);
        } else {
            result1 = Math.round((total/(double)arr.length));
        };

        // 중앙값
        quickSort(arr, 0, arr.length-1);
        int result2 = arr[arr.length/2];

        // 최빈값
        int result3 = mode(arr);

        // 범위
        int result4 = Math.abs(arr[0] - arr[arr.length-1]);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
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

    public static int mode(int[] arr){
        Map<Integer, Integer> map = new HashMap();
        if (arr.length == 1){
            return arr[0];
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        // 최댓값 구하기
        int max = Collections.max(map.values());
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> num : map.entrySet()){
            if (num.getValue() == max){
                list.add(num.getKey());
            }
        }
        Collections.sort(list);
        if (list.size() > 1){
            return list.get(1);
        } else {
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        // Test code
        Scanner sc = new Scanner(System.in);
        int ntime = sc.nextInt();
        int[] arr = new int[ntime];
        for (int i = 0; i < ntime; i++) {
            arr[i] = sc.nextInt();
        }

        solution(arr);
        sc.close();
    }
}
