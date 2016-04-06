/* Jared Horvat
  4/5/16
  CIS 271
  HW 4 */

  import java.util.*;

public class Sieve{
 public static void main(String[] args) {
    System.out.println("This program will tell you all prime");
    System.out.println("numbers up to a given maximum");
    System.out.println();

    Scanner s = new Scanner(System.in);
    System.out.print("maximum number? ");
    int max = s.nextInt();

    List <Integer> primes = sieve(max);
    System.out.println("prime numbers up to " + max + ":");
    System.out.println(primes);
 }

 public static List <Integer> sieve(int max) {
 List <Integer> primes = new LinkedList <Integer> ();

 List <Integer> list = new LinkedList <Integer> ();

 for (int i = 2; i <= max; i++) {
  if (i == 2 || i %2 == 1)
   list.add(i);
  }
  while(!list.isEmpty()) {
   int front = list.remove(0);
   primes.add(front);

   Iterator <Integer> move = list.iterator();
   while(move.hasNext()) {
    int current = move.next();
    if(current % front == 0) {
    move.remove();
     }
    }
    if(front >= Math.sqrt(max)) {
     primes.addAll(list);
     list.clear();
    }
  }
   return primes;
 }
}
