class Solution {
    public boolean isAnagram(String s, String t) {
int n = s.length();
        int m = t.length();

        if (n != m) {
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }

        for(Map.Entry<Character, Integer> e : sMap.entrySet()){
            char key = e.getKey();
            int val = e.getValue();
            if (!tMap.containsKey(key)) {
                return false;
            }
            if (val != tMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}
