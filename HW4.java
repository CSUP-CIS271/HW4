import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Vitor
 */
public class HW4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    System.out.println("This program will tell you all prime");
    System.out.println("numbers up to a given maximum.");
    System.out.println();

    Scanner console = new Scanner(System.in);
    System.out.print("maximum number? ");
    int max = console.nextInt();

    List <Integer> primes = sieve(max);
    System.out.println("prime numbers up to " + max + ":");
    System.out.println(primes);
   }

   
   public static List <Integer> sieve(int max) {
    List <Integer> primes = new LinkedList <Integer> ();

    
    List <Integer> numbers = new LinkedList<Integer> ();
  
    for (int i = 2; i <= max; i++) {
      if (i==2 || i % 2 == 1)
        numbers.add(i);
    }

    while (!numbers.isEmpty()) {
     
     int front = numbers.remove(0);
      primes.add(front);
 
      Iterator < Integer > itr = numbers.iterator();
      while (itr.hasNext()) {
       int current = itr.next();
       if (current % front == 0) {
        itr.remove();
       }
      }
      if (front >= Math.sqrt(max)) {
        primes.addAll(numbers);
        numbers.clear();
     }
    }
        return primes;
    }
    
}
