package Dynamic_Programming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        int[] dp1 = new int[nums.length+1];
        Arrays.fill(dp1, -1);

        int[] dp2 = new int[nums.length+1];
        Arrays.fill(dp2, -1);

        int left = helper(dp1, nums, nums.length-1, 1);
        int right = helper(dp2, nums, nums.length-2, 0);

        System.out.println(Math.max(left, right));
    }
    private static int helper(int[] dp, int[] nums, int idx, int n){
        if(idx == n) return nums[idx];
        if(idx < n) return 0;

        if(dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + helper(dp, nums, idx-2, n);
        int notPick = 0 + helper(dp, nums, idx-1, n);

        return dp[idx] = Math.max(pick, notPick);
    }
}
