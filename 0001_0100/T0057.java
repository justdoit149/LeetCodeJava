import java.util.*;

public class T0057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> temp = new ArrayList<>();
        int i;
        for(i = 0; i < intervals.length; i++){
            if(intervals[i][1] < newInterval[0]){
                temp.add(Arrays.asList(intervals[i][0],intervals[i][1]));
            }else{
                break;
            }
        }
        while(true){
            if(i < intervals.length && intervals[i][0] <= newInterval[1] ){
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }else{
                break;
            }
        }
        temp.add(Arrays.asList(newInterval[0],newInterval[1]));
        for(; i < intervals.length; i++){
            temp.add(Arrays.asList(intervals[i][0],intervals[i][1]));
        }
        int[][] ans = new int[temp.size()][2];
        for(i = 0; i < temp.size(); i++){
            ans[i][0] = temp.get(i).get(0);
            ans[i][1] = temp.get(i).get(1);
        }
        return ans;
    }


    public static void main(String[] args) {
        
    }
}
