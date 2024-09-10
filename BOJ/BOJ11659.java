package BOJ;

import java.util.Scanner;

public class BOJ11659 {
    private static int[] sum;

    public static void init(int size, int[] nums){
        sum = new int[size];

        sum[0] = nums[0];
        
        for(int i = 1;i<size;i++){
            sum[i] = sum[i-1] + nums[i];
        }
    }

    public static int get(int a, int b){
        if(a==1){
            return sum[b-1];
        }
        return sum[b-1] - sum[a-2];
    }

    public static void main(String[] args) {
        int a, b;
        int[] nums;
        int[][] outputs;
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();

        nums = new int[a];
        outputs = new int[b][2];

        for (int i = 0; i < a; i++) {
            nums[i] = scanner.nextInt();
        }

        for (int i = 0; i < b; i++) {
            outputs[i][0] = scanner.nextInt();
            outputs[i][1] = scanner.nextInt();
        }

        scanner.close();
        
        init(a, nums);

        for(int i = 0;i<b;i++){
            System.out.println(get(outputs[i][0], outputs[i][1]));
        }

    }
}
