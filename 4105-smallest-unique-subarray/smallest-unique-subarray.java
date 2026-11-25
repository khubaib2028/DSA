class Solution {
    private static final long BASE1 = 131L;
    private static final long MOD1 = 1_000_000_007L;
    private static final long BASE2 = 100003L;
    private static final long MOD2 = 1_000_000_009L;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow1[i] = (pow1[i - 1] * BASE1) % MOD1;
            pow2[i] = (pow2[i - 1] * BASE2) % MOD2;
        }

        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (hasUniqueSubarrayOfLength(nums, mid, pow1, pow2)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean hasUniqueSubarrayOfLength(
        int[] nums, int len, long[] pow1, long[] pow2) {

        int n = nums.length;

        if (len > n) return false;

        long h1 = 0;
        long h2 = 0;

        for (int i = 0; i < len; i++) {
            long val = nums[i] + 1L;

            h1 = (h1 * BASE1 + val) % MOD1;
            h2 = (h2 * BASE2 + val) % MOD2;
        }

        Map<Long, Integer> freq = new HashMap<>();

        long key = pack(h1, h2);
        freq.put(key, 1);

        long rem1 = pow1[len - 1];
        long rem2 = pow2[len - 1];

        for (int i = len; i < n; i++) {

            long outVal = nums[i - len] + 1L;
            long inVal = nums[i] + 1L;

            h1 = (h1 - (outVal * rem1) % MOD1 + MOD1) % MOD1;
            h1 = (h1 * BASE1 + inVal) % MOD1;

            h2 = (h2 - (outVal * rem2) % MOD2 + MOD2) % MOD2;
            h2 = (h2 * BASE2 + inVal) % MOD2;

            long nextKey = pack(h1, h2);

            freq.put(nextKey, freq.getOrDefault(nextKey, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }

    private long pack(long h1, long h2) {
        return (h1 << 32) | (h2 & 0xffffffffL);
    }
}