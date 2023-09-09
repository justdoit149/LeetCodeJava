class T0066 {
    public int[] plusOne(int[] digits) {
        boolean is_Max = true;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 9){
                is_Max = false;
            }
        }
        if(is_Max == true){//����ȫ��9���������Ҫλ��+1
            int[] digits2 = new int[digits.length+1];
            digits2[0] = 1;
            for(int i = 1; i < digits2.length; i++){//��һ��û��Ҫ
                digits2[i] = 0;
            }
            return digits2;
        }
        digits[digits.length-1] += 1;
        for(int i = digits.length-1; i >= 1; i--){
            if(digits[i] == 10){//���ǽ�λ
                digits[i] = 0;
                digits[i-1] += 1;
            }
        }
        return digits;
    }
    public static void main(String[] args) {
        T0066 t = new T0066();
        int[] nums = {1,1,3,3,4};
        int[] ans = t.plusOne(nums);
        for(int x: ans){
            System.out.print(x+" ");
        }
    }
}

// class Solution {
//     public int[] plusOne(int[] digits) {
//         for (int i = digits.length - 1; i >= 0; i--) {
// 		    if (digits[i] != 9) {
//                 digits[i]++;
// 				return digits;
// 			} 
// 		    digits[i] = 0;
// 		}
//         //����forѭ����˵������ȫ����9
// 		int[] temp = new int[digits.length + 1];//����Ĭ��ȫ0
// 		temp[0] = 1;
// 		return temp;
//     }
// }