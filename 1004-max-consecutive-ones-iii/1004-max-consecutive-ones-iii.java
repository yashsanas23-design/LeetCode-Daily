class Solution 
{
    public int longestOnes(int[] nums, int k) 
    {
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int zero = 0;

        while(r < nums.length)
        {
            if(nums[r] == 0)
            {
                zero++;
            }

            while(zero > k)
            {
                if(nums[l] == 0)
                {
                    zero--;
                }

                l++;
            }

            int len = r - l + 1;
            maxLength = Math.max(maxLength, len);

            r++;
        }

        return maxLength;
    }
}