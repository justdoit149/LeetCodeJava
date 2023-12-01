public class T0149 {
    //数据规模较小，直接O(n^3)枚举
    public int maxPoints(int[][] points) {
        if(points.length <= 2){
            return points.length;
        }
        int temp, ans = 2;
        for(int i = 0; i < points.length-1; i++){
            for(int j = i + 1; j < points.length; j++){
                temp = 2;
                for(int k = 0; k < points.length; k++){
                    if(k == i || k == j){
                        continue;
                    }
                    if((points[i][0] - points[j][0]) * (points[k][1] - points[j][1])
                    == (points[i][1] - points[j][1]) * (points[k][0] - points[j][0])){
                        temp++;
                    }
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}
