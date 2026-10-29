class Solution {
    public int lengthOfLongestSubstring(String s) {
        // i = j = 0;
        // while(j < n)
        // if set not contain s[i]; then add s[i] to set, count++, j++;
        // else max = max(max, count), count  = 0, i = i+1, j = i set.clear;
        // return max(max, count);
        
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        if (n == 0) return 0;
        int max = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                count++;
                j++;
            } else {
                max = Math.max(max, count);
                count = 0;
                i++;
                j = i;
                set.clear();
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
