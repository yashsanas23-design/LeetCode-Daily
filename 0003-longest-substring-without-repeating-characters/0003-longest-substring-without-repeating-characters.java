class Solution 
{
    public int lengthOfLongestSubstring(String s)
    {
       Map<Character,Integer> h1= new HashMap<>();
       int n=s.length();
       int l=0;
       int r=0;
       int maxLength=0;
       while(r<n)
       {
        if(h1.containsKey(s.charAt(r)))  //In the map
        {
           if(h1.get(s.charAt(r))>=l)
           {
               l = h1.get(s.charAt(r)) + 1;
           }
        }
        int len=r-l+1;
        maxLength=Math.max(maxLength,len);
        h1.put(s.charAt(r), r);
        r++;
       }
       return maxLength;
    }
}