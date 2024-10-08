public class solution {
    public static int Trappingwater(int[] height){
        int n= height.length;
        //first of all we have to created an two auxellary array which teels us the boundary
        //leftmax
        int leftmax[]=new int[n];
        leftmax[0]=height[0];
        //we start from 1 as we have already taken 0
        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(height[i],leftmax[i-1]);
        }
        //rightmax
        int rightmax[]=new int[n];
        //we start from the right side of an array
        rightmax[n-1]=height[n-1];
        //we start from n-2 as we have already taken the last n-1
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(height[i],rightmax[i+1]);
        }
        //we have to calculate the water level= min(leftmax,rightmax)
        //then we find out the trapped water
        //trapped water=waterlevel-height  then add all the individuals
        int trapedwater=0;
        for(int i=0;i<n;i++) {
            int waterlevel = Math.min(leftmax[i],rightmax[i]);
            trapedwater+=waterlevel-height[i];
        }

       return trapedwater;
    }
    public static void main(String[] args) {
        int height[]={4,2,0,6,3,2,5};
        System.out.println("the volume of traped water is "+Trappingwater(height));
    }
}
