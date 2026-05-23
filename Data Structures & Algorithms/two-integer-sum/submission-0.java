class Solution {
    public int[] twoSum(int[] nums, int target) {

        // contains (value, index) pairs.
        HashMap<Integer, Integer> visited = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (visited.containsKey(complement)) {
                int[] result = {visited.get(complement), i};
                return result;
            }
            visited.put(nums[i], i);
        }
        return new int[] {};
    }
}
