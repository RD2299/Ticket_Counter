import java.util.Random;
import java.util.Scanner;
public class Ticket {
    static int counter[]=new int[5];
    static Queue queue ;
   static Random r= new Random();

    public Ticket() {
        for (int x=0;x<5;x++)
        {
            counter[x]=1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        queue = new Queue(1000);
        int ch=r.nextInt(5);
        Ticket t=new Ticket();
        boolean quit = false;
        int c=1;
        while(!quit) {
            System.out.println("\nEnter action: (5 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
                case 1:
                    t.checkCounter();
                    break;

                case 2:
                    queue.enqueue(c);
                    c++;
                    break;
                case 3:
                    System.out.println("Enter counter to dengaged");
                    int x=scanner.nextInt();
                    t.empty(x);
                    break;
                case 4:
                    int a=queue.size;
                    System.out.println("Total person left in Queue"+a);
                    break;
                case 5:
                    printActions();
                    break;
            }

        }


    }
    public void engaged(int x)
    {
        counter[x]=1;
        queue.dequeue();
    }
    public  void empty(int x)
    {
        counter[x]=-1;
    }
    public void checkCounter()
    {
        int flag=0;
        for (int x=0;x<5;x++)
        {
            if(counter[x]==-1)
            {
                System.out.println("Counter " +(x+1)+" Empty");
                flag++;
               engaged(x);
            }
            else
            {
                System.out.println("Counter " +(x+1)+" Engaged");
            }
        }
        if(flag==0)
        {
            System.out.println("No Counter is free");
        }
    }
    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to Quit\n" +
                "1  - to check Empty Counter\n" +
                "2  - to add a new person to queue\n"+
                "3  - to dengage a counter\n"+
                "4  - to Check the remaining people in queue");
       // System.out.println("Choose your action: ");
    }

}
