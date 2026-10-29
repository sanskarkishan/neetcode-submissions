class Solution {
    public String minWindow(String s, String t) {
     // Intuition:
        // We need the smallest substring of s that contains all characters of t
        // with their required frequencies.
        //
        // Use a sliding window:
        // 1. Store the required frequency of each character from t in a map.
        // 2. Expand the window by moving the right pointer and keep track of
        //    character frequencies inside the current window.
        // 3. When the current window contains all required characters,
        //    try to shrink it from the left to get the minimum valid window.
        // 4. Whenever a smaller valid window is found, update the answer.
        // 5. Continue until the right pointer reaches the end of the string.
        //
        // formed == required:
        // formed   -> number of characters whose required frequency is satisfied.
        // required -> total distinct characters in t.
        //
        // Time Complexity: O(n)
        // Space Complexity: O(k), where k is the number of distinct characters.

        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();

        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int required = need.size();
        int formed = 0;

        HashMap<Character, Integer> window = new HashMap<>();

        int l = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {

            char ch = s.charAt(r);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch) &&
                    window.get(ch).intValue() == need.get(ch).intValue()) {
                formed++;
            }

            while (formed == required) {

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) &&
                        window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                l++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);   
    }
}
