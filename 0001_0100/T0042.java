public class T0042 {
    // //����һ��ֱ�ӷ����������ҵ�һ����д�Ĵ��룩
    // //�������ǵ�˼·��˼��ʲô���������װˮ���������뵽��Ӧ���������ȽϸߵĶ���֮��
    // //���ǿ�����һ��l��rָ����װˮ�����䡣����˼�����Ƿ�������������˵�Ϊһ������ֵ
    // //Ȼ��r = l+1Ȼ�󲻶�r++ֱ���ҵ�ĳ��height[r] >= height[l]������������������֮��װˮ
    // //ˮ��ȡ���ڶ˵�϶̵ļ�ȥ��ǰλ�õģ�Ȼ����ӡ�֮����l = r������ֱ�������Ҷ�
    // //��������Ҳ������ڵ��ڵ�ǰ�߶ȵģ��Ǿ�ȡ��ߵ�Ȼ���������֮���װˮ����Ȼ����������l��
    // //���������Ƚ������뵽��������д������Է�����ϸ�ڽ϶࣬��Ҫ���۸��ֱ߽�����
    // public int trap(int[] height) {
    //     int ans = 0;
    //     int l = 0, r = 0, R = height.length-1, max_temp = 0, max_temp_index = 0;
    //     if(height.length < 3){
    //         return 0;
    //     }
    //     while(l<R){
    //         if(l > 0 && height[l] >= height[l-1] && height[l] >= height[l+1]){
    //             break;
    //         }else if(l == 0 && height[l] >= height[l+1]){
    //             break;
    //         }
    //         l++;
    //     }
    //     while(l<R){         
    //         r = l+1;
    //         max_temp = 0;
    //         while(r<=R){
    //             if(height[r] >= height[l]){
    //                 max_temp_index = r;
    //                 max_temp = height[r];
    //                 break;       
    //             }else if(height[r] >= max_temp){
    //                 max_temp_index = r;
    //                 max_temp = height[r];
    //             }
    //             r++;
    //         }
    //         for(int i = l+1; i <= max_temp_index-1; i++){
    //             if(Math.min(height[l], height[max_temp_index]) > height[i]){
    //                 ans += Math.min(height[l], height[max_temp_index]) - height[i];
    //             }
    //         }
    //         l = max_temp_index;
    //     }
    //     return ans;
    // }

    //����������̬�滮�������Ƽ��������������ύ�꿴���Լ�ʱ��̫�����Լ�˼�����뵽��������
    //��ֻ����ĳһ��λ��index��װˮ����ȡ������������ֵheight[i]���������ֵheight[j]
    //Ȼ��װˮ������min(height[i],height[j]) - height[index]����Ȼ�����С��0�Ǿ���0��
    //��������ֵ��ô����?����Ȼ��λ��i��������ֵleftMax[i] = max(leftMax[i-1],height[i-1])
    //�ұ߾���rightMax[i] = max(rightMax[i+1],height[i+1])��
    //�������ǾͿ��Զ�̬�滮�ˣ�ֻ��Ҫ��ǰ����ʹӺ���ǰ���Էֱ�������������飬Ȼ����;�������
    public int trap(int[] height){
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int ans = 0, temp = 0;
        for(int i = 1; i < leftMax.length; i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        for(int i = rightMax.length-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }
        for(int i = 1; i < height.length-1; i++){
            temp = Math.min(leftMax[i], rightMax[i]);
            if(temp > height[i]){
                ans += temp - height[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        T0042 test = new T0042();
        int[] nums = {8,2,8,9,0,1,7,7,9};
        int ans = test.trap(nums);
        System.out.println(ans);
    }
}
