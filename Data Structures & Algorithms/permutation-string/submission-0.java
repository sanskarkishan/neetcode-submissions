class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int i = 0;
        int j = n - 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int k = 0; k < n; k++) {
            map.put(s1.charAt(k), map.getOrDefault(s1.charAt(k), 0) + 1);
        }

        while (j < m) {
            HashMap<Character, Integer> winMap = new HashMap<>();
            for (int k = i; k <= j; k++) {
                winMap.put(s2.charAt(k), winMap.getOrDefault(s2.charAt(k), 0) + 1);
            }
            System.out.println(winMap);

            boolean isTrue = true;
            for (Map.Entry<Character, Integer> set : winMap.entrySet()) {
                char key = set.getKey();
                int val = set.getValue();
                if (!map.containsKey(key)) {
                    isTrue = false;
                    break;
                }
                if (map.get(key) != val) {
                    isTrue = false;
                    break;
                }
            }

            if (isTrue) return true;
            i++;
            j++;
        }
        return false;
    }
}
