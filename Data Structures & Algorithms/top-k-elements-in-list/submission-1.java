class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

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

        List<List<Integer>> countToNum = new ArrayList<>();

        // initialize array for every possible count;
        for (int i = 0; i < n; i++) {
            countToNum.add(new ArrayList<>());
        }

        // place nums in the index corresponding to their count
        for (int num : numToCount.keySet()) {

            // get count from hashmap
            int count = numToCount.get(num);

            // add num to the array at index "count-1" OB1 
            countToNum.get(count-1).add(num);
        }

        int[] result = new int[k];

        // tracks how many numbers have already been added to result
        int resultIdx = 0;

        // count down from largest count
        for (int i = n-1; 0 <= i; i--) {
            List<Integer> currentNums = countToNum.get(i);

            // check if the list of numbers with count i
            // is not empty.
            if (currentNums.size() > 0) {

                // add as many numbers from that count
                // as result array can hold.
                for (int num : currentNums) {
                    result[resultIdx] = num;
                    resultIdx++;

                    // result already fully filled
                    if (resultIdx == k) {
                        return result;
                    }
                }
                // note that this loop only triggers
                // conditionally. It does NOT multiply the
                // runtime complexity by a factor of k. 
                // It only ADDS O(k) amount of runtime.
            }
        }
        return result;
    }
}
