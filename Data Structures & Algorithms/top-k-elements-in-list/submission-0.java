class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        HashMap<Integer,Integer> numToCount
                = new HashMap<>();
        
        for (int num : nums) {
            int count = 0;
            if (numToCount.containsKey(num)) {
                count = numToCount.get(num);
            }
            count++;
            numToCount.put(num, count);
        }

        // find first, second, ..., kth most frequent number
        for (int i = 0; i < k; i++) {
            int mostFreqNum = 0;
            int maxCount = 0;
            for (int num : numToCount.keySet()) {
                int numCount = numToCount.get(num);
                if (numCount > maxCount) {
                    maxCount = numCount;
                    mostFreqNum = num;
                }
            }
            result[i] = mostFreqNum;
            numToCount.remove(mostFreqNum);
        }
        return result;
    }
}
