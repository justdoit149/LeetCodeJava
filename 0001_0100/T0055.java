//�Ӻ���ǰ���ҵ���һ���ܵ��ﵱǰλ�õ�������r�±ꡣ��Ϊ����Զ�ġ����Ķ��ܵ�����Զ��һ��Ҳ�ܵ�����
//���Ǵ�ǰ�����ǲ�����ô�ҵģ�ǰ���ߵ�����Ĳ�һ�����ߵ�Զ�ġ�
//��ȻҲ����ÿ��ѡ���Ĳ���������Ǵ��������ҵĻ��Ǵ�������������һ���ܵ��ĵ������¡�
//��������ʱ�临�Ӷȸ��ߣ���O(n^2)����

public class T0055 {
    public boolean canJump(int[] nums) {
        int r = nums.length - 1, l;
        while(r > 0){
            for(l = r - 1; l >= 0; l--){
                if(nums[l] + l >= r){
                    r = l;
                    break;
                }
            }
            if(l == -1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
