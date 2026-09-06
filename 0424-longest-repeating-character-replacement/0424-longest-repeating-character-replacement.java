class Solution
{
    public int characterReplacement(String s, int k)
    {
        int r = 0;
        int l = 0;
        int maxLength = 0;
        int maxFrequency = 0;
        int[] freq = new int[26];
        while (r < s.length())
        {
            // Increase frequency of current character
            freq[s.charAt(r) - 'A']++;
            // Update maximum frequency in current window
            maxFrequency = Math.max(maxFrequency,freq[s.charAt(r) - 'A']);
            // If replacements needed > k, shrink window
            if ((r - l + 1) - maxFrequency > k)
            {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            // Update maximum valid window length
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}