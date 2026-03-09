import java.util.Scanner;
class prime
{
    public static void main(String args[])
    {
        int a=0,b=1,sum=0;
        int c;
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value:");
        n=sc.nextInt();
       // System.out.print(a+" ");
       // System.out.print(b+" ");
        for(int i=2;i<n;i++)
        {
            
          c=a+b;
          a=b;
          b=c;
          if(c%2==0){
            sum+=c;
            
            }
    }
    System.out.print(sum);}
}