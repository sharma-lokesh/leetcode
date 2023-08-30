package LeetCode;
/***Leetcode Problem number 2483*/
public class MinimumPenalty {
    public static void main(String[] args) {
        String input = "YYNY";
        System.out.println(bestClosingTineSecond(input));

    }

    public static int bestClosingTineSecond(String customers){
        int close = 0;

        for(char ch : customers.toCharArray()) {
            if(ch == 'Y') close++;
        }
        int open = 0;
        //int[] ans = {index, penalty}
        int[] ans = {0, close};
        for(int i=0; i<customers.length(); i++) {
            if(customers.charAt(i) == 'Y'){
                close--;
            } else {
                open++;
            }

            if(ans[1] > (open+close)) {
                ans[0] = i+1;
                ans[1] = open+close;
            }
        }
        return ans[0];
    }

    public static int bestClosingTime(String customers) {
        int result = 0;
        int size = customers.length();
        int[] prefix_sum_y = new int[size];
        int[] prefix_sum_n = new int[size];
        prefix_sum_y[0] = customers.charAt(0)=='Y'?1:0;
        prefix_sum_n[0] = customers.charAt(0)=='N'?1:0;

        for(int i=1; i<size; i++){
            if(customers.charAt(i)=='Y')prefix_sum_y[i]=prefix_sum_y[i-1]+1;
            else prefix_sum_y[i]=prefix_sum_y[i-1];
            if(customers.charAt(i)=='N')prefix_sum_n[i]=prefix_sum_n[i-1]+1;
            else prefix_sum_n[i]=prefix_sum_n[i-1];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<size;i++){
            //number of Y after the shop is closed
            int penalty_Y=(i==0)?prefix_sum_y[size-1]:prefix_sum_y[size-1]-prefix_sum_y[i-1];
            //number of N when he shop was open
            int penalty_N=(i==0)?0:prefix_sum_n[i-1];

            //finding the penalty
            int penatly=penalty_Y+penalty_N;
            //checking if it is the minimum one
            if(penatly<min){
                min=penatly;
                result=i;
            }
        }
        return result;
    }
}
