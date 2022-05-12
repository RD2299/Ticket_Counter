package DSA1;

import java.util.Scanner;

public class ticket2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("There are 5 counters with capacity of 5 in each. Total 25 people can be handled at a go");
        int arr[][]=new int[5][5];
        System.out.println("0 to terminate\n" +
                "1 to queue entry\n" +
                "2 to engage and dequeue\n" +
                "3 to print");
        ticket1 h=new ticket1();
        Scanner st=new Scanner(System.in);
        int ch=st.nextInt();
        while(ch!=0)
        {
            switch (ch)
            {
                case 1:
                    System.out.println("Enter no. of people will enter ticket queue");
                    int n=st.nextInt();
                    System.out.println("Start enter "+n+" people in queue");
                    for(int i=0;i<n;i++)
                    {
                        h.enqueue1();    //h.enqueue1(st.nextInt());
                    }
                    System.out.println("People are lined up in front of counters");
                    break;
                case 2:
                    System.out.println("Ticket distribution process starts");
                    h.unqueue1();
                    break;
                case 3:
                    System.out.println("Displaying current line up of people in queue");
                    h.printticketline();
            }
            System.out.println("Enter choice again");
            ch=st.nextInt();
        }
    }
}
