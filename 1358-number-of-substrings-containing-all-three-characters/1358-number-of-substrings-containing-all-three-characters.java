class Solution 
{
    public int numberOfSubstrings(String s) 
    {
        int[] lastSeen = {-1, -1, -1};
        int cnt = 0;

        for (int i = 0; i < s.length(); i++)
        {
            // Update the last seen position
            lastSeen[s.charAt(i) - 'a'] = i;

            // Check whether a, b and c have appeared
            if (lastSeen[0] != -1 && 
                lastSeen[1] != -1 && 
                lastSeen[2] != -1)
            {
                // Number of valid substrings ending at i
                cnt = cnt + Math.min(lastSeen[0], 
                            Math.min(lastSeen[1], lastSeen[2])) + 1;
            }
        }

        return cnt;
    }
}