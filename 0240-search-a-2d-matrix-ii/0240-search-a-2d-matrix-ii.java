class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int n=matrix.length;  //for length of rows
        int m=matrix[0].length; //for length of columns

        int row=0;
        int col=m-1;
        //we use row<n & col>=0 because row is increasing and col is decreasing
        //so to avoid overflow condition we used this
         while(row<n && col>=0)
        {
            if(matrix[row][col]==target)
            {
                return true;
            }
            else if(matrix[row][col]<target)
            {
                row++;
            }
            else
            {
                col--;
            }
        }
        return false;
    }
}