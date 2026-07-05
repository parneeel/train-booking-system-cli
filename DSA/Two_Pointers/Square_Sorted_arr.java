public class Square_Sorted_arr {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int[] newarr = new int [nums.length];
        int k = j;

        while(i<=j){
            int isquare = nums[i] * nums[i];
            int jsquare = nums[j] * nums[j];

            if(isquare>jsquare){
                newarr[k--] = isquare;
                i++;
            }
            else{
                newarr[k--] = jsquare;
                j--;
            }
        }
        return newarr;
    }
} 
