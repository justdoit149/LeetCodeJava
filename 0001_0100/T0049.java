import java.util.*;

public class T0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        //�����Ƚ��ַ�������ĸ���ź�����������λ�ʾͷ���һ���ˡ�
        //ע�ⲻ�ȳ��Ĵ�����aa��aab��ǰ�涼��ͬ�����ó����ں���������˳������⡣
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
            //����tempArray.toString()����ת�����ǵ�ַ��
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
