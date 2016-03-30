/*
 * @author Randall Sirota 03/20/2016
 * CIS271
 * Sieve.java Uses a Linked List to implement the Sieve of Eratosthenes algorithm for finding prime numbers.
 * Question: Why is this a valid operation? 
 * If we set the max at 47, the last if statement adds all to prime because the test (front >= Math.sqrt(max) ) passes.
 * When front will be 11 will be greater than Math.sqrt(47) 7.416198487095663.  After dividing the numbers list 
 * and removing any number divisible by 2, 3, 5, 7, 11 there won’t be any non-prime numbers left.
*/
import java.lang.*;
import java.util.*;

public class Sieve {
	public static void main(String[] args) {
		System.out.println("This program will tell you all prime");
		System.out.println("numbers up to a given maximum");
		System.out.println("");
		
		Scanner console = new Scanner(System.in);
		System.out.println("Maximum number? ");
		int max = console.nextInt();
		
		List<Integer> primes = sieve(max);
		System.out.println("Prime numbers up to " + max + ":");
		System.out.println(primes);
	}  //end main
	
		//returns a list of prime numbers up to a given max
		//using the sieve of Eratosthenes algorithm
	public static List<Integer> sieve(int max) {
		List<Integer> primes = new LinkedList<Integer>();
			
			/*add all numbers from 2 to max to a list 
			Update:store only 2 and all odd numbers from 3 upward*/
		List<Integer> numbers = new LinkedList<Integer>();
		numbers.add(2);
		for (int i = 3; i <= max; i+=2) {
			numbers.add(i);
		}
		
		while (!numbers.isEmpty()) {
				//remove prime number from the front of the numbers list
			int front = numbers.remove(0);
			primes.add(front); //add to the front of primes list
			// test System.out.println(numbers + "\n" + primes);
				//remove all multiples of this prime number
		    Iterator<Integer> itr = numbers.iterator();
			while (itr.hasNext()) {
				int current = itr.next();
				if (current % front == 0) {
				  itr.remove();
				}
			}
				/*	Update: if the first number in the numbers list ever ...
				*	reaches the square root of the maximum, all remaining 
				*	values from the numbers list are moved into the primes list.
				*/
			//test System.out.println("Front" + front + "\n" + "sqrt" + Math.sqrt(max));	
			if (front >= Math.sqrt(max)){
				primes.addAll(numbers);
				numbers.clear();
			}
		}
		return primes;
	}
}//end class