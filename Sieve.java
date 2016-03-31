/* 
 * Joshua Greer
 * 3/31/2016
 * HW4
 * Sieve.java
 */
//got help from Randy
import java.util.*;
import java.io.*;

public class Sieve{
  public static void main(String[] args) {
    System.out.println("This program will tell you all prime");
    
    System.out.println("numbers up to a given maximum.");
    System.out.println();
    
    Scanner console = new Scanner(System.in);
    System.out.print("Maximum number?");
    int max = console.nextInt();
    
    List<Integer> primes = sieve(max);
    System.out.print("Prime numbers up to " + max + ":" + " ");
    System.out.println(primes);
   
  }
  // Returns a list of all prime numbers up to given max
  // using the sieve of Eratosthenes algorithm
  public static List<Integer> sieve(int max){
    List<Integer> primes = new LinkedList<Integer>();
    // Adds 2 and all odd numbers up to max into a list
    List<Integer> numbers = new LinkedList<Integer>();
    for (int i = 2; i <= max; i++) {
      if(i == 2 || i % 2 == 1) 
      numbers.add(i);
    }
    
    while(!numbers.isEmpty()) {
      // Remove a prime number from the front of the list
      int front = numbers.remove(0);
      primes.add(front);
      
      // Remove all multiples of this prime number
      Iterator<Integer> itr = numbers.iterator();
      while (itr.hasNext()) {
        int current = itr.next();
        if (current % front == 0) {
          itr.remove();
        }
      }
      if(front >= Math.sqrt(max)) {  
        primes.addAll(numbers);
        numbers.clear();
        /*
         *  This works because once the front number is
         *  greater than or equal to the square root of the max
         *  there will never be any other numbers in the list
         *  that will be divisible by greater front numbers
         */
      }
    }
    return primes;
  }
}
  
