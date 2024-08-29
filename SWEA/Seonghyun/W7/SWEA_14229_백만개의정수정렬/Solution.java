package SWEA_14229_백만개의정수정렬;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[1000000];
        
        for (int n = 0; n < 1000000; n++) {
            arr[n] = sc.nextInt();
        }
        
        mergeSort(arr, 0, arr.length - 1);          // 병합정렬 고!

            System.out.print(arr[500000]);          // 정렬 결과 출력(50만1번째 인덱스 출력)
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);                  // 절반으로 나누고 각각 병합 정렬
            mergeSort(arr, mid + 1, right);             // 절반으로 나누고 각각 병합 정렬

            merge(arr, left, mid, right);               // 정렬된 두 파트 병합
        }
    }

    // 병합 함수
    public static void merge(int[] arr, int left, int mid, int right) {
        int l = mid - left + 1;
        int r = right - mid;

        int[] L = new int[l];                  // 좌측 배열
        int[] R = new int[r];                  // 우측 배열

        for (int i = 0; i < l; i++)
            L[i] = arr[left + i];               // 좌측 절반을 또 임시로 나눠버리기

        for (int j = 0; j < r; j++)
            R[j] = arr[mid + 1 + j];           // 우측 절반을 또 임시로 나눠버리기

        int i = 0, j = 0;
        int k = left;

        while (i < l && j < r) {                      // 두 배열을 병합하면서 정렬
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < l) {                                // 좌측 배열 정리
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < r) {                                // 우측 배열 정리
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}