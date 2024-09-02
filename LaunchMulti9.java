//Maan lo hamare paas ek hi thread hai aur usko ek se zyada methods execute karna hai.
// Aise mein, synchronized keyword ka use karte hain taaki methods sahi sequence mein
// execute ho sakein aur kisi tarah ka conflict na ho. Jaise is code mein, bas ek car hai
// aur usse SON-1, SON-2, SON-3 chalana chahte hain. Vo ek saath nahi kar sakte,
// lekin vo ek saath parking lot mein enter kar sakte hain. Isliye, jo task
// vo ek saath kar sakte hain, unhe synchronized keyword ka use karke nahi likhte,
// lekin jo task vo ek saath nahi kar sakte, unhe synchronized block mein likhte hain.

class Car implements Runnable
{
    public void run()
    {
        try
        {
            System.out.println(Thread.currentThread().getName() + " Has entered the parking lot");
            Thread.sleep(2000);

            synchronized(this)
            {
                System.out.println(Thread.currentThread().getName() + " Got into Car to drive");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " Started to drive the car");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " Came back and parked the car");
            }



        }
        catch (Exception e)
        {
            System.out.println("Some problem");
        }
    }

}

public class LaunchMulti9
{
    public static void main(String[] args)
    {
        Car c=new Car();

        Thread t1=new Thread(c);
        Thread t2=new Thread(c);
        Thread t3=new Thread(c);

        t1.setName("SON-1");
        t2.setName("SON-2");
        t3.setName("SON-3");

        t1.start();
        t2.start();
        t3.start();

    }

}