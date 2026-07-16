class Solution 
{
    public int countSubarrays(int nums[], int maxSum)
     {
        int subarray = 1;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++)
         {
            if (currentSum + nums[i] <= maxSum) 
            {
                currentSum += nums[i];
            } 
            else 
            {
                subarray++;
                currentSum = nums[i];
            }
        }
        return subarray;
    }
    public int splitArray(int[] nums, int k) 
    {
        int low = 0;
        int high = 0;
        for (int num : nums) 
        {
            low = Math.max(low, num);
            high += num;
        }
        while (low <= high) 
        {
            int mid = low + (high - low) / 2;
            int subarray = countSubarrays(nums, mid);
            if (subarray > k)
            {
                low = mid + 1;
            }
             else
            {
                high = mid - 1;
            }
        }
        return low;
    }
}