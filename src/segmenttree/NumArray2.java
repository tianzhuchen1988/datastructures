package segmenttree;

public class NumArray2 {

    private int[] sumData;

    public NumArray2(int[] nums) {
        if(nums != null && nums.length > 0){
            sumData = new int[nums.length + 1];
            sumData[0] = 0;
            for(int i = 1; i < sumData.length; i++){
                sumData[i] = sumData[i - 1] + nums[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sumData[j + 1] - sumData[i];
    }
}
