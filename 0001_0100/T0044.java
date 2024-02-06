public class T0044 {
    //双指针遍历。或者也可以dp
    public boolean isMatch(String s, String p) {
        int sn = s.length(), pn = p.length();
        int i = 0, j = 0;
        int start = -1, match = 0;
        while (i < sn) {
            if (j < pn && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < pn && p.charAt(j) == '*') {
                start = j;
                match = i;
                j++;
            } else if (start != -1) {
                j = start + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }
        while (j < pn) {
            if (p.charAt(j) != '*') return false;
            j++;
        }
        return true;
        
    }
    public static void main(String[] args) {
        T0044 test = new T0044();
        System.out.println(test.isMatch("aa", "a"));
    }
}
