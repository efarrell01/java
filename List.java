/* This program explores the basics of arrays and ArrayLists.
Created by E. Farrell August 28, 2021
*/

import java.util.ArrayList;

public class List {
  // set up array
    public static int[] array = {1, 2, 3, 4, 5};

  // method to loop through array
  public static void arrayLoop(){
    int arrayIndex = 0;
    while (arrayIndex < 5){
     System.out.println(array[arrayIndex]);
     arrayIndex ++;
    }
  }
  // method to loop through ArrayList
  public static void arrayListLoop(ArrayList<String> arrayList){
    int arrayListIndex = arrayList.size() - 1;
    int count = 0;
    while (count <= arrayListIndex){
      System.out.println(arrayList.get(count));
      count ++;
    }
    System.out.println("Finished looping through the ArrayList");
  }

// main method
  public static void main(String[] args) {
  
    // array part of the main method
    System.out.println("This is the array part.");
    
    // print out array the first time
    arrayLoop();
    System.out.println("Finished looping through first array");

    // change an element value in the array
    array[4] = 42;

    // print out array the second time
    arrayLoop();
    System.out.println("Finished looping through second array");

    // ArrayList part of the main method
    System.out.println("This is the ArrayList part now.");

    // create an ArrayList
    ArrayList<String> numbers = new ArrayList<String>();

    // add items to the ArrayList
    numbers.add("one");
    numbers.add("two");
    numbers.add("three");
    numbers.add("four");
    numbers.add("five");

    // access the size of the ArrayList
    System.out.println("The ArrayList numbers currently has " + numbers.size() + " items in it.");

    // print out the ArrayList
    arrayListLoop(numbers);

    // find an item by index
    System.out.println("The third item is " + numbers.get(2));

  // change the value of an item
  System.out.println("I am now changing the value of the third item.");
  numbers.set(2, "one");
  arrayListLoop(numbers);
  System.out.println("The third item is now " + numbers.get(2));

 // print the ArrayList after changing the value
    arrayListLoop(numbers);

  // remove an item with a specific value
  System.out.println("I am now going to remove a one from the ArrayList.");
  numbers.remove("one");
  System.out.println("The size of the ArrayList is now " + numbers.size());
System.out.println("The third item is now " + numbers.get(2));
System.out.println("The first item is now " + numbers.get(0));

 // print the ArrayList after removing the value
    arrayListLoop(numbers);

    // remove the second "one" from ArrayList
  System.out.println("I am now going to remove the second one from the ArrayList.");
  numbers.remove("one");
  System.out.println("The size of the ArrayList is now " + numbers.size());
System.out.println("The third item is now " + numbers.get(2));
System.out.println("The first item is now " + numbers.get(0));

// print the ArrayList after removing the value
    arrayListLoop(numbers);
  }
}