class Solution {

    public String encode(List<String> strs) {
        String encode = "";
        int n = strs.size();
        for (int i = 0; i < n; i++) {
            int m = strs.get(i).length();
            encode += String.valueOf(m);
            encode += '#';
            for (int j = 0; j < m; j++) {
                char ch = strs.get(i).charAt(j);
                encode += ch;
            }
        }
        return encode;
    }

    public List<String> decode(String str) {
        List<String> decode = new ArrayList<>();
        int n = str.length();
        int i = 0;
        while (i < n) {
            int m = 0;
            for (int j = i; j < n; j++) {
                if (str.charAt(j) >= 48 && str.charAt(j) <= 57) {
                    m *= 10;
                    m += Integer.parseInt(String.valueOf(str.charAt(j)));
                    i++;
                } else {
                    break;
                }
            }
            i++;
            String s = "";

            for (int j = i; j < i + m; j++) {
                s += str.charAt(j);
            }

            decode.add(s);
            i = i + m;
        }
        return decode;
    }
}
