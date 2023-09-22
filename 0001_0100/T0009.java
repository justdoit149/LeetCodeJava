public class T0009 {
    public boolean isPalindrome(int x) {
        Integer temp = x;
        char[] a,b;
        a = temp.toString().toCharArray();
        b = temp.toString().toCharArray();
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[a.length-1-i]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // int x = 124;
        // System.out.println(((Integer)x).toString());
    }
}
