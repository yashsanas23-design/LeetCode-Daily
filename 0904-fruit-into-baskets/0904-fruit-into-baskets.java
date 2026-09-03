class Solution 
{
    public int totalFruit(int[] fruits)
    {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        while (r < fruits.length)
        {
            // Add current fruit to the map
            mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);
            // If we have more than 2 types of fruits
            if (mpp.size() > 2)
            {
                mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
                // Remove fruit type if its frequency becomes 0
                if (mpp.get(fruits[l]) == 0)
                {
                    mpp.remove(fruits[l]);
                }
             l++;
            }
            // Calculate maximum valid window
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}