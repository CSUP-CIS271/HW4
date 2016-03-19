 /*
  * Program: 		sieve.java
  * Author:			Dan Baliczek
  * Last modified: 	3/18/2016
  * Description:	modified version of the sieve program in ch11.1
  */
package HW4;

import java.util.*;

public class sieve {
	 public static void main(String[] args) {
		  System.out.println("This program will tell you all prime");
		  System.out.println("numbers up to a given maximum.");
		  System.out.println();

		  Scanner console = new Scanner(System.in);
		  System.out.print("Maximum number? ");
		  int max = console.nextInt();

		  List < Integer > primes = sieve(max);
		  System.out.println("Prime numbers up to " + max + ":");
		  System.out.println(primes);
		 }

		 // Returns a list of all prime numbers up to given max
		 // using the sieve of Eratosthenes algorithm.
		 public static List < Integer > sieve(int max) {
		  List < Integer > primes = new LinkedList < Integer > ();

		  // add all numbers from 2 to max to a list
		  List < Integer > numbers = new LinkedList < Integer > ();
		  numbers.add(2);
		  for (int i = 3; i <= max; i+=2) {
		   numbers.add(i);
		  }

		  while (!numbers.isEmpty()) {
		   // remove a prime number from the front of the list
		   int front = numbers.remove(0);
		   if(front!=Math.sqrt(max)){
			   primes.add(front);
	
			   // remove all multiples of this prime number
			   Iterator < Integer > itr = numbers.iterator();
			   while (itr.hasNext()) {
			    int current = itr.next();
			    if (current % front == 0) {
			     itr.remove();
			    }
			   }
			  }
		   else{
		    //if the front number is ever the square root of the max, the rest of the numbers in the list will be printed to primes
		    //the last number will be removed, as is is not, nor ever will be a prime number
		    //test this by entering a square of a prime as the max, i.e. 49, and uncomment the system.out.println to check if this works
			   primes.add(front);
			   while(!numbers.isEmpty()){
				   front = numbers.remove(0);
				   primes.add(front);
			   }
			   primes.remove(primes.size()-1);
			   //System.out.println("The while loop has run, and added all numbers to the prime list because the front number was the sq root of the max.");
			   //System.out.println("also, the last number isn't a prime so it was removed.");
		   }
		  }

		  return primes;
		 }
}
