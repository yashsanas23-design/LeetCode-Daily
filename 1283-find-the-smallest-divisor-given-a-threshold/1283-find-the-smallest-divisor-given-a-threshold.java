class Solution 
{
    int sumByDivisor(int arr[],int div)
    {
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            sum+=Math.ceil((double)(arr[i])/(double)(div));
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) 
    {
        if(nums.length>threshold)
        {
             return -1;
        }
        int low=1;
        int high = nums[0];
        for(int num : nums)
        {
            high = Math.max(high, num);
        }
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(sumByDivisor(nums,mid)<=threshold)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;   
    }
}