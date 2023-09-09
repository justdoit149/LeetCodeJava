class T0066 {
    public int[] plusOne(int[] digits) {
        boolean is_Max = true;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 9){
                is_Max = false;
            }
        }
        if(is_Max == true){//处理全是9的情况，需要位数+1
            int[] digits2 = new int[digits.length+1];
            digits2[0] = 1;
            for(int i = 1; i < digits2.length; i++){//这一步没必要
                digits2[i] = 0;
            }
            return digits2;
        }
        digits[digits.length-1] += 1;
        for(int i = digits.length-1; i >= 1; i--){
            if(digits[i] == 10){//考虑进位
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
//         //跳出for循环，说明数字全部是9
// 		int[] temp = new int[digits.length + 1];//数组默认全0
// 		temp[0] = 1;
// 		return temp;
//     }
// }