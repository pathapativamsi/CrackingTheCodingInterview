package ArraysAndStrings;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft = height[0];
        int maxRight = height[n-1];
        int p1 = 0;
        int p2 = n-1;
        int sum = 0;
        while(p1<=p2){
            if(height[p1] <= height[p2]){
                sum += Math.max(maxLeft - height[p1],0);
                maxLeft = Math.max(maxLeft,height[p1]);
                p1++;
            }
            else {
                sum += Math.max(maxRight-height[p2],0);
                maxRight = Math.min(maxRight,height[p2]);
                p2--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int count = trw.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(count);
    }
}
