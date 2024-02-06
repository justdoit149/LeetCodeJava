import java.util.*;

public class T0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        //排序，先将字符串按字母重排后排序，这样异位词就放在一起了。
        //注意不等长的处理，如aa与aab，前面都相同可以让长的在后，这样避免顺序出问题。
        Arrays.sort(strs,new Comparator<String>() {
            public int compare(String a, String b){
                char[] temp_a = a.toCharArray();
                char[] temp_b = b.toCharArray();
                Arrays.sort(temp_a);
                Arrays.sort(temp_b);
                for(int i = 0; i < Math.min(a.length(), b.length()); i++){
                    if(temp_a[i] != temp_b[i]){
                        return temp_a[i] - temp_b[i];
                    }
                }
                return a.length() - b.length();
            }
        });
        List<String> temp = new ArrayList<>();
        String[] Sorted = new String[strs.length];
        char[] tempArray = null;
        for(int i = 0; i < strs.length; i++){
            tempArray = Arrays.copyOf(strs[i].toCharArray(),strs[i].length());
            Arrays.sort(tempArray);
            Sorted[i] = Arrays.toString(tempArray);
            //不能tempArray.toString()这样转换的是地址。
        }
        temp.add(strs[0]);
        for(int i = 1; i < strs.length; i++){
            // System.out.println(strs[i]);
            if(Sorted[i].equals(Sorted[i-1])){
                temp.add(strs[i]);
            }else{
                ans.add(new ArrayList<>(temp));
                // System.out.println(temp.toString());
                temp.clear();
                temp.add(strs[i]);
            }
        }
        ans.add(new ArrayList<>(temp));
        return ans;
    }

    public static void main(String[] args) {
        T0049 test = new T0049();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(test.groupAnagrams(strs).toString());
        // String a,b;
        // a = new String("ddd");
        // b = new String("ddd");
        // System.out.println(a + " " + b);
    }
}
