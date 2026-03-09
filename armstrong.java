import java.util.Scanner;
class armstrong
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value:");
        int n=sc.nextInt();
        int temp=n;
        int x,dig=0;
        while(temp>0)
        {
            x=temp%10;
            dig++;
            temp/=10;
        }
        int sum=0;
        int a=n;
        while(a!=0)
        {
            x=a%10;
            sum=sum+(int)(Math.pow(x,dig));
            a/=10;
        }if(sum==n)
        System.out.print(n+"  is an Armstrong number");
        else
        System.out.print(n+" is Not an armstrong number");
    }
}