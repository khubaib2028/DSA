class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        long minPrice = Long.MAX_VALUE;
        for (int[] item : items) {
            if (item[0] > maxFactor) {
                maxFactor = item[0];
            }
            if (item[1] < minPrice) {
                minPrice = item[1];
            }
        }
        int[] factorFreq = new int[maxFactor + 1];
        for (int[] item : items) {
            factorFreq[item[0]]++;
        }
        int[] multCount = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (factorFreq[f] == 0) continue;
            for (int mult = f; mult <= maxFactor; mult += f) {
                multCount[f] += factorFreq[mult];
            }
        }
        long[][] candidates = new long[n][2];
        int candCount = 0;
        long priceLimit = 2L * minPrice;
        for (int[] item : items) {
            int factor = item[0];
            long price = item[1];
            int bonusCap = multCount[factor] - 1; 
            if (bonusCap > 0 && price <= priceLimit) {
                candidates[candCount][0] = price;
                candidates[candCount][1] = bonusCap;
                candCount++;
            }
        }
        Arrays.sort(candidates, 0, candCount, (a, b) -> Long.compare(a[0], b[0]));
        long remainingBudget = budget;
        long totalItems = 0;
        for (int i = 0; i < candCount; i++) {
            long price = candidates[i][0];
            long cap = candidates[i][1];
            if (remainingBudget < price) break;
            long take = Math.min(cap, remainingBudget / price);
            totalItems += 2L * take;
            remainingBudget -= take * price;
        }
        totalItems += remainingBudget / minPrice;
        return (int) totalItems;
    }
}