class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        List<int[]> res= new ArrayList<>();
        //Check for empty intervals
        if(intervals.length==0 || intervals==null)
        {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i[]:intervals)
        {
            //Logic for overlapping intervals
            if(i[0]<=end)
            {
                end=Math.max(end,i[1]);
            }
            else
            {
                res.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        //remaining non-overlapping intervals are added at this point
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
}