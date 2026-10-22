class MyComparator implements Comparator<Map.Entry<Integer, Integer>>{
    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        return o2.getValue() - o1.getValue();
    }
}

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

        // System.out.println(list);

        // Sort by frequency in descending order
//        list.sort((a, b) -> b.getValue() - a.getValue());
        list.sort(new MyComparator());

        // System.out.println(list);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }

        return ans;
    }
}
