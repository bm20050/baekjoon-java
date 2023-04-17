package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
    public static int canInstall(int[] arr, int distance) {
        // 첫 번째 집은 무조건 설치
        int count = 1;
        int lastlocate = arr[0];

        for (int i = 1; i < arr.length - 1; i++) {
            int locate = arr[i];

            // 현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
            // 최소거리(distance)보다 크거나 같을 때 공유기 설치 개수를 늘려주고
            // 마지막 설치 위치를 갱신해준다.
            if (locate - lastlocate >= distance) {
                count++;
                lastlocate = locate;
            }
        }

        return count;
    }

    public static int search(int[] arr, int c, int start, int end) {

        // Upper Bound는 탐색 값을 초과하는 첫 번째 값을 가리키므로,
        // 1을 빼준 값이 조건식을 만족하는 최댓값이 된다.
        if (start >= end)
            return start - 1;

        int mid = (start + end) / 2;
        // mid 거리에 대해 설치 가능한 공유기 개수가 c에 미치지 못하면 거리를
        // 좁혀야하기 때문에 end를 줄인다.
        if (canInstall(arr, mid) < c)
            return search(arr, c, start, mid);
        // 설치 가능한 공유기 개수가 c보다 크거나 같으면 거리를 벌리면서
        // 최소거리가 가질 수 있는 최대 거리를 찾아낸다.
        else
            return search(arr, c, mid + 1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 이분탐색을 하기 위해서 정렬

        // start: 최소 거리가 가질 수 있는 최솟값
        // end: 최소 거리가 가질 수 있는 최댓값
        System.out.println(search(arr, c, 1, arr[n - 1] - arr[0] + 1));
    }
}
