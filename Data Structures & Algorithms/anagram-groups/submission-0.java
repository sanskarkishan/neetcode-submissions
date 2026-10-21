class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<String> str = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String temp = new String(s);
            str.add(temp);
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(str.get(i));
        }

        Iterator it  = set.iterator();
        List<List<String>> ans = new ArrayList<>();
        while (it.hasNext()){
            ArrayList<String> temp = new ArrayList<>();
            String ss = (String) it.next();
            for (int i = 0; i < n; i++) {
                if (str.get(i).equals(ss)){
                    temp.add(strs[i]);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
