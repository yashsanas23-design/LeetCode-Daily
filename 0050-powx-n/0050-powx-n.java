class Solution 
{
    public double myPow(double x, int n) 
    {
        double ans = 1.0;
        long nn = n;

        boolean negative = false;

        if(nn < 0)
        {
            negative = true;
            nn = -nn;
        }

        while(nn > 0)
        {
            // Odd power
            if(nn % 2 == 1)
            {
                ans = ans * x;
                nn = nn - 1;
            }
            // Even power
            else
            {
                x = x * x;
                nn = nn / 2;
            }
        }

        if(negative)
        {
            ans = 1.0 / ans;
        }

        return ans;
    }
}