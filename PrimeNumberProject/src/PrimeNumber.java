import java.util.Scanner;


public class PrimeNumber 
{
	public static void main(String args[]) {
	      
	     //get input till which prime number to be printed
	      System.out.println("Enter the number till which prime number to be printed: ");
	      int limit = new Scanner(System.in).nextInt();
	    
	      //printing primer numbers till the limit ( 1 to 100)
	      System.out.println("Printing prime number from 1 to " + limit);
	      for(int number = 2; number<=limit; number++){
	          //print prime numbers only
	          if(isPrime(number)){
	              System.out.println(number);
	          }
	      }

	    }

	   
	    public static boolean isPrime(int number){
	        for(int i=2; i<number; i++){
	           if(number%i == 0){
	               return false; //number is divisible so its not prime
	           }
	        }
	        return true; //number is prime now
	    }

}
