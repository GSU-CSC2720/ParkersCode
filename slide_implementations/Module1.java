package slide_implementations;

import java.util.Arrays;

public class Module1 {
    public static void main(String[] args) {
        //factorial 
        int n = 5;
        int f1 = fact1(n);
        int f2 = fact2(n);
        System.out.printf("fact1(%d): %d \nfact2(%d): %d \n\n", n, f1, n, f2);
        
        //recursive max and kthsmallest element
        int[] nums = {2,7,15,45,8,11,3,1,76,4};
        System.out.println("nums (unsorted)");
        show(nums);
        int rmax  = recMax(nums, 0, nums.length-1);
        int small = kSmall(nums,5);
        System.out.printf("maximum: %d \n(5)th element: %d \n\n", rmax, small);
        
        
        //selection sort and bin search
        selectionSort(nums);
        System.out.println("nums (sorted)");
        show(nums);
        boolean found = binarySearch(nums, 11);
        System.out.printf("target found ? %b \n", found);
        
        /**
        
        Ouput: 
        
        fact1(5): 120 
        fact2(5): 120 
        
        nums (unsorted)
        2 7 15 45 8 11 3 1 76 4 
        maximum: 76 
        (5)th element: 7 
        
        nums (sorted)
        2 7 4 1 3 11 8 45 76 15 
        target found ? true  
       
       **/
    }
    
    private static int fact1(int n) {
        return n > 1 ? n * fact1(n-1) : 1;
    }
    
    private static int fact2(int n) {
        return n > 1 ? n * (n-1) * fact2(n-2) : 1;
    }
    
    private static int recMax(int[] nums, int a, int b) {
        if (a == b) return nums[a];
        
        int m = (a + b) / 2;
        return Math.max(recMax(nums, a, m), recMax(nums, m+1, b));
    }
    
    private static int kSmall(int[] nums, int n) {
        int p = nums[0];
        int s = 0, e = nums.length-1;
        
        int[] res = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= p) res[s++] = nums[i];
            if (nums[i] > p)  res[e--] = nums[i];
        }
        res[s] = p;
        
        if (s+1 == n) return p;
        if (s+1 < n)  return kSmall(Arrays.copyOfRange(res, s+1, nums.length), n-s-1);
        else          return kSmall(Arrays.copyOfRange(res, 0, s), n);
    }
    
    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                min = nums[j] < min ? j : min;
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    private static boolean binarySearch(int[] nums, int target) {
        int s = 0, e = nums.length;
        while (s < e) {
            int m = (s+e)/2;
            if (target == nums[m]) return true;
            if (target < nums[m]) e = m;
            if (target > nums[m]) s = m+1;
        }
        return false;
    }
    
    private static void show(int[] nums) {
        for (int i = 0; i < nums.length; i++) System.out.print(nums[i] + " ");
        System.out.println();
    }
}
