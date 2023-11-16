package LeetCode;
/**
 * 2366. Minimum Replacements to Sort the Array
 * Apparently this was a Google interview question, that's why it is purely mathematical I guess.
 *
 * We need to make the array non decreasing by splitting the numbers.
 *
 * If we split a number, it will get even smaller.
 *
 * We want to make subsequent numbers either equal or in increasing order.
 *
 * So, this implies that we don't need to do anything with the last element, if we split it, it'll further decrease the last element, which is supposed to be the greatest after the sorting is done, so we leave that element as it is.
 *
 * We iterate backwards from the second last element.
 *
 * If we get two number in order like this 13 7.
 *
 * The optimal way to split 13 here will be to take as minimum steps and split it such that it's parts are <= 7.
 *
 * Split it 6 , 7.
 *
 * How to get this?
 *
 * Use this formula
 *
 * Steps to split = (nums[i] - 1)/last
 *
 * New smallest element formed (last) = nums[i]/(steps+1).
 *
 * ans += steps.
 * */
public class MinimumReplacement {
    public static void main(String[] args) {
        System.out.println(minimumReplacement(new int[] {1,3,4,5,4}));
    }
    public static long minimumReplacement(int[] nums) {

        long ans=0;
        int n=nums.length;
        int prev=nums[n-1];

        for(int i=n-2;i>=0;i--){

            int noOfTime=nums[i]/prev;
            if((nums[i])%prev!=0){
                noOfTime++;
                prev=nums[i]/noOfTime;
            }
            ans+=noOfTime-1;
        }
        return ans;

    }
}
