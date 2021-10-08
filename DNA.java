public class DNA {
  /* This program determines whether there is a protein in a strand of DNA. A protein has the following qualities:

    It begins with a “start codon”: ATG.
    It ends with a “stop codon”: TGA.
    In between, each additional codon is a sequence of three nucleotides. 
    
It is adapted from the "DNA Sequencing" project in Codecademy's "Learn Java" course.
Created by E. Farrell on Sept. 16, 2021.*/

  public static void orf(String dna){
     int startCodon = dna.indexOf("ATG");
     int stopCodon = dna.indexOf("TGA");

     System.out.println("The DNA strand " + dna + " is " + dna.length() + " base pairs long.");

//Test for protein
  if (startCodon >= 0 && stopCodon >= 0 && (stopCodon - startCodon) % 3 == 0){
    String protein = dna.substring(startCodon, stopCodon + 3);
    System.out.println("This DNA sequence encodes a protein.");
    System.out.println("The open reading frame is " + protein + ".");
    System.out.println("The start codon is at position " + startCodon + ".");
    System.out.println("The stop codon is at position " + stopCodon + ".\n");
  } else{
    System.out.println("This DNA sequence does not encode a protein.\n");
  }
  }
 
  public static void main(String[] args) {
 
    String dna1 = "ATGCGATACGCTTGA";
    String dna2 = "ATGCGATACGTGA";
    String dna3 = "ATTAATATGTACTGA";

    orf(dna1);
    orf(dna2);
    orf(dna3);
  }
}