
import java.lang.Math;
import java.util.Scanner;

public class NumberGameOne 
{
  public static void main(String[] args) 
  {
    int answer = (int)(Math.random() * 100) + 1;
    int k = 10;
    Scanner input = new Scanner(System.in);
    System.out.println("Guess the 'Number', you have 10 chances!!!");
    while (k > 0) 
    {
      System.out.println("Enter your guess: ");
     int guess = input.nextInt();
      if (guess == answer) 
      {
        System.out.println("You guessed the number!\nYou win!");
        break;
      }
      else if (guess > answer) 
      {
        System.out.println("Your guess is too high.\nYou have " + (k - 1) + " tries left.");
        k--;
      }
      else 
      {
        System.out.println("Your guess is too low.\nYou have " + (k - 1) + " tries left.");
        k--;
      }
    }    
    if (k==0){
      System.out.println("You lose the game...");
    }
  }
}