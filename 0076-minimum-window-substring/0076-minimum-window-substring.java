class Solution 
{
    public String minWindow(String s, String t) 
    {
        Map<Character, Integer> mpp = new HashMap<>();
        // Store frequency of characters required from t
        for (int i = 0; i < t.length(); i++)
        {
            mpp.put(t.charAt(i), mpp.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = 0;
        int cnt = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        while (r < s.length()) 
        {
            // Take current character
            char ch = s.charAt(r);
            // If this character is required
            if (mpp.getOrDefault(ch, 0) > 0)
            {
                cnt++;
            }
            // Decrease its required frequency
            mpp.put(ch, mpp.getOrDefault(ch, 0) - 1);
            // We have found a valid window
            while (cnt == t.length()) 
            {
                // Check if current window is smaller
                if (r - l + 1 < minLength)
                {
                    minLength = r - l + 1;
                    startIndex = l;
                }
                // Remove left character
                char leftChar = s.charAt(l);
                mpp.put(leftChar, mpp.getOrDefault(leftChar, 0) + 1);
                // If it was a required character, window is no longer valid
                if (mpp.get(leftChar) > 0)
                {
                    cnt--;
                }
                l++;
            }
            r++;
        }
        return startIndex==-1 ? "" : s.substring(startIndex,startIndex+minLength);
    }
}