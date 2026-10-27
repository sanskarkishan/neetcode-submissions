class Solution {
    public boolean isPalindrome(String s) {
        String[] str = s.split("");
        // System.out.println(Arrays.toString(str));
        String st = "";

        for (int i = 0; i < str.length; i++) {
            if ((str[i].charAt(0) >= 'a' && str[i].charAt(0) <= 'z') || (str[i].charAt(0) >= 'A' && str[i].charAt(0) <= 'Z') || (str[i].charAt(0) >= '0' && str[i].charAt(0) <= '9')){
                st += str[i].toLowerCase();
            }
        }
        // System.out.println(st);
        int i = 0;
        int j = st.length()-1;
        while (i < j){
            if (st.charAt(i) != st.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
