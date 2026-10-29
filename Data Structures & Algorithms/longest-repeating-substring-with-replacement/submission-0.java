class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int maxLen = 0;
        while (i < n && j < n) {
            int winLen = j - i + 1;
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            int maxCount = 0;
            for (Map.Entry<Character, Integer> set : map.entrySet()) {
                maxCount = Math.max(maxCount, set.getValue());
            }

            if (winLen - maxCount <= k) {
                maxLen = Math.max(maxLen, winLen);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
            j++;
        }
        return maxLen;
    }
}
