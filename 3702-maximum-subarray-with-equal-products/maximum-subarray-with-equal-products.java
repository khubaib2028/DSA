class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        int maxVal = 0;
        long totalLcm = 1;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
            totalLcm = lcm(totalLcm, num);
        }
        long maxProd = totalLcm * maxVal;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            long curLcm = 1;
            long curGcd = 0;

            for (int j = i; j < n; j++) {
                long val = nums[j];
                prod *= val;
                curGcd = gcd(curGcd, val);
                curLcm = lcm(curLcm, val);

                if (prod == curLcm * curGcd) {
                    ans = Math.max(ans, j - i + 1);
                }

                if (prod > maxProd) {
                    break;
                }
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}