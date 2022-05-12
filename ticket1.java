package DSA1;

import java.util.Random;
import java.util.Scanner;

public class ticket1 {
    private int tick[][]=new int[5][5];
    private int count[]=new int[5];
    private int first[]=new int[5];
    private int last[]=new int[5];
    Random rd=new Random();
    ticket1()
    {
        for(int i=0;i<5;i++)
        {
            count[i]=0;
            first[i]=0;
            last[i]=-1;
        }
        System.out.println("Ticket counter is ready for operation today");
    }
    public boolean empt(int n)
    {
        return(count[n]==0);
    }
    public boolean ful(int N)
    {
        return(count[N]>=5);
    }
    public void enqueue1()
    {
        //int u=k-1;
        //System.out.println("Start to enter "+k+" people in queue");
        Scanner s=new Scanner(System.in);
        //while(u>=0) {
            int temp=s.nextInt();
            int K = rd.nextInt(5);
            System.out.println("Goes to counter " + K);
            if (!ful(K)) {
                last[K] = (last[K] + 1) % 5;
                System.out.print(" In position " + last[K]);
                count[K] += 1;
                System.out.println("No. of people in front of counter " + K + " is " + count[K]);
                tick[K][last[K]] = temp;
            } else if(count[0]!=5 || count[1]!=5 || count[2]!=5 || count[3]!=5 || count[4]!=5){
                enqueue1();
            }
            //u--;
        //}
    }
    public void unqueue1()
    {
        long start=System.currentTimeMillis();
        long end=start+(1*1000);
        while(System.currentTimeMillis()<end) {
            int p = rd.nextInt(5);
            if (!empt(p)) {
                tick[p][first[p]] = 0;
                count[p] += 1;
                first[p] = (first[p] + 1) % 5;
            }
            else //if (count[0] != 0 || count[1] != 0 || count[2] != 0 || count[3] != 0 || count[4] != 0)
                 {
                unqueue1();
            }
        }
        System.out.println("Ticket operation of some people is done");
    }
    public void printticketline() throws InterruptedException {
        System.out.println("C1\t"+"C2\t"+"C3\t"+"C4\t"+"C5");
        for(int i=0;i<5;i++)
        {
            //int u=rd.nextInt(5);
            for(int j=0;j<5;j++)
            {
                int ftemp=(first[j]+i)%5;
                System.out.print(tick[j][ftemp]+"\t");
                Thread.sleep(100);
            }
            System.out.println();
        }
    }
}
