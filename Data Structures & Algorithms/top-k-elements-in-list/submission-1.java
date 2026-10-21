class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Convert map entries to list
        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(map.entrySet());

        // Sort by frequency in descending order
        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }

        return ans;
    }
}
