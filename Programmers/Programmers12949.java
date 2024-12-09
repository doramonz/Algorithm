package Programmers;

public class Programmers12949 {
    static public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] result = solution(new int[][] { { 1, 4 }, { 3, 2 }, { 4, 1 } }, new int[][] { { 3, 3 }, { 3, 3 } });
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}
