class Solution {
    public int longestConsecutive(int[] nums) {
        // Add all nums to set.
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        // Find the first num of Sequences, An array can have many sequences so we have to count the length one by one.
        for(int num : set){
            if (!set.contains(num - 1)){ // 
                int curr = num;
                int length = 1;
                // count the length of Sequence
                while (set.contains(curr+1)){
                    curr++;
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }
}
