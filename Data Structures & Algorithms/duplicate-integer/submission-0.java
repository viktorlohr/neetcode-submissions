class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> visitedElements = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visitedElements.contains(nums[i])) {
                return true;
            }
            visitedElements.add(nums[i]);  
        }
        return false;
    }
}