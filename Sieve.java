/*
 * Matt S. Ham
 * 4/1/2016
 * HomeWork 4
 * Sieve.java
 */

import java.util.*;
import java.io.*;

public class Sieve{
  public static void main(String[] args) {
    System.out.println("Prime Numbers!");

    Scanner console = new Scanner(System.in);
    System.out.print("Enter Maximum Number: ");
    int max = console.nextInt();

    List<Integer> primes = sieve(max);
    System.out.print("Prime numbers up to " + max + ":" + " ");
    System.out.println(primes);
  }

  public static List<Integer> sieve(int max){
    List<Integer> primes = new LinkedList<Integer>();
    List<Integer> numbers = new LinkedList<Integer>();
    for (int i = 2; i <= max; i++) {
      if(i == 2 || i % 2 == 1)
      numbers.add(i);
  }
    while(!numbers.isEmpty()) {
      int front = numbers.remove(0);
      primes.add(front);

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
      }
    }
    return primes;
  }
}