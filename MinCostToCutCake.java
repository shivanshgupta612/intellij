import java.util.Arrays;

//https://leetcode.com/problems/minimum-cost-for-cutting-cake-ii/
public class MinCostToCutCake {
    private void reverse(int[] arr) {
        for (int i = 0; i <arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        //greedy approach for maximum cut cost first
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        reverse(horizontalCut);
        reverse(verticalCut);
        int hpiece = 1, vpiece = 1;
        int i = 0, j = 0;
        long res = 0;
        while (i < m-1 && j < n-1) {
            if (horizontalCut[i] > verticalCut[j]) {
                res += horizontalCut[i] * vpiece;
                hpiece++;
                i++;
            } else {
                res += verticalCut[j] * hpiece;
                vpiece++;
                j++;
            }
        }
        while (i < m-1) {
            res += horizontalCut[i] * vpiece;
            hpiece++;
            i++;
        }
        while (j < n-1) {
            res += verticalCut[j] * hpiece;
            vpiece++;
            j++;
        }
        return res;
    }
}

