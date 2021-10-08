/* This program generates a random array of ten nonrepeating numbers and then returns 

  all the odd numbers in the array,
  all the even numbers in the array,
  all the prime numbers in the array, and
  all the Fibonacci numbers in the array.

This program was adapted from the "Prime Directive" exercise in Codecademy's "Learn Java" course.

Created by E. Farrell on September 14, 2021.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class PrimeDirective {

/* Method to generate array of 10 random, non-repeating numbers from 1 to 100 */
 public static ArrayList<Integer> generateArray() {
// Generate ArrayList containing 10 random numbers
   Random random = new Random();
   ArrayList<Integer> randomArray = new ArrayList<Integer>();

// Populate ArrayList with 10 random numbers
  for (int i = 0; i < 10; i++){
   // Pick a random number between 1 and 100 and add it to the array
    randomArray.add(random.nextInt(100) + 1);
   /* The nextInt(int n) is used to get a random number between 0(inclusive) and the number passed in this argument(n), exclusive; in this case, 99 is the highest number that would be returned. */
  }

  /* Check to see if there are any repeats. If there are any repeats, replace the repeated numbers and then check the array again */
  boolean repeatedNumbers = true;
  
   while (repeatedNumbers) {
     int match = 0;
    for (int j = 0; j < 10; j++) { //value to test
      for (int k = 0; k < 10; k++) { //values to test against 
        if ((randomArray.get(j) == randomArray.get(k)) && (j != k)) {
          randomArray.set(j, random.nextInt(100) + 1);
          match += 1; 
        } 
      } 
    }  
/* If there were no matches, stop checking */
        if (match < 1) {
          break;
        } 
      } 

// Sort the array in ascending order
      Collections.sort(randomArray);
      return randomArray;
    }   
  
// Method to check for primes
  public boolean isPrime(int number){
    if (number == 2) {
      return true;
    } else if (number < 2) {
      return false;
    }
   for (int i = 2; i < number; i++){
      if (number % i == 0){
      return false;
    } 
    }
    return true;
   } 
  
// Method to return ArrayList of only primes
  public ArrayList<Integer> onlyPrimes(ArrayList<Integer> numbers){
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int number : numbers){
     if (isPrime(number)) {
       primes.add(number);
     } 
    }
    return primes;
  }
  
/* Method to test if a number is odd or even, depending on the arguments passed in */
public boolean isOddOrEven(String oddOrEven, int number){
    if (oddOrEven.equals("odd")) {
      if (number % 2 != 0){
      return true;
      }
    } else {
      if (number % 2 == 0) {
      return true;
    }
    }
    return false;
   } 

// Method to return ArrayList of even/odd numbers
public ArrayList<Integer> onlyOddOrEven(String oddOrEven, ArrayList<Integer> numbers){
    ArrayList<Integer> allOddOrEven = new ArrayList<Integer>();
    for (int number : numbers){
     if (isOddOrEven(oddOrEven, number)) {
       allOddOrEven.add(number);
     } 
    }
    return allOddOrEven;
  }
  
// Method to test for Fibonacci numbers
public static boolean isFibonacci(int number){
  int fibonacciF1 = 0;
  int fibonacciF2 = 1;
  int fibonacci = 0;
  
    if (fibonacci == number){
    return true;
    }

  while (fibonacci <= number){ 
      fibonacci =  fibonacciF1 + fibonacciF2;
      fibonacciF1 = fibonacciF2;
      fibonacciF2 = fibonacci;
    
      if (fibonacci == number){
        return true;
      }
    }
    return false;
   } 

// Method to return an ArrayList of Fibonacci numbers
public ArrayList<Integer> onlyFibonacci(ArrayList<Integer> numbers){
    ArrayList<Integer> allFibonacci = new ArrayList<Integer>();
    for (int number : numbers){
     if (isFibonacci(number)) {
       allFibonacci.add(number);
     } 
    }
    return allFibonacci;
  }

// Method to print results
public static void printResults(String category, ArrayList<Integer> results){
  if (results.size() == 0){
    System.out.println("There are no " + category + " numbers in the array.");
  } else if (results.size() == 1){
    System.out.println("There is only one " + category + " number in the array: " + results.get(0) + ".");
  } else {
    int totalNumber = results.size();
    String numberToWord = "default";
    switch (totalNumber) {
      case 2:  numberToWord = "two";
               break;
      case 3:  numberToWord = "three";
               break;
      case 4:  numberToWord = "four";
               break;
      case 5:  numberToWord = "five";
               break;
      case 6:  numberToWord = "six";
               break;
      case 7:  numberToWord = "seven";
               break;
      case 8:  numberToWord = "eight";
               break;
      case 9:  numberToWord = "nine";
               break;
      case 10: numberToWord = "ten";
               break;
    }
    System.out.println("There are " + numberToWord + " " + category + " numbers in the array.");
    System.out.println("The set of " + category + " numbers is " + results + ".\n");
  }

}
  public static void main(String[] args) {

    PrimeDirective pd = new PrimeDirective();

/* Create an array of 10 random, non-repeating numbers from 1 to 100 */
    ArrayList<Integer> newArray = pd.generateArray();
    System.out.println("Here is an array of ten random numbers: " + newArray + ".\n");

// Print out all the odd numbers from the  array    
   ArrayList<Integer> oddsOnly = pd.onlyOddOrEven("odd", newArray);
   printResults("odd", oddsOnly); 

// Print out all the even numbers from the array
   ArrayList<Integer> evensOnly = pd.onlyOddOrEven("even", newArray);
   printResults("even", evensOnly);

// Print out all the primes from the array
    ArrayList<Integer> primesOnly = pd.onlyPrimes(newArray);
    printResults("prime", primesOnly);

// Print out the Fibonacci numbers from the array
   ArrayList<Integer> fibonacciNumbers = pd.onlyFibonacci(newArray);
   printResults("Fibonacci", fibonacciNumbers);
 
  }   
}