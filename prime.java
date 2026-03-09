class prime{
    public static void main(String args[])
    {
        int count,n;
        for(int i=1;i<=100;i++)
        {
             count=0;
             n=i;
            for(int j=1;j<=n;j++)
            {
        if(n%j==0)
            count++;
            }
        if(count==2)
        System.out.print(n+" ");
       }
    }
}