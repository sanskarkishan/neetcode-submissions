class Solution {
    public int characterReplacement(String s, int k) {

        /*
        Intuition:
        - Use a sliding window [i, j].
        - Keep the frequency of each character inside the current window using a HashMap.
        - maxCount stores the frequency of the most frequent character in the window.
        - If (window length - maxCount) <= k, we can replace at most k characters
          to make all characters in the window the same, so the window is valid.
        - Update the answer with the maximum valid window size.
        - If (window length - maxCount) > k, the window becomes invalid,
          so shrink it from the left by moving i forward.
        - Continue expanding with j and track the longest valid window.
        */

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
