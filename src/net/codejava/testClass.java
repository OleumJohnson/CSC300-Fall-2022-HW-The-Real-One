package net.codejava;
import java.util.Random;

public class testClass {
	
	public static int[] BubbleSort(int[] array) 
	{
		int temp;
		int swaps = 0;
		int[] numbers1 = array;
		for (int i = 0; i < numbers1.length - 1; i++) 
		{
			for (int j = 0; j < numbers1.length - i - 1; j++) 
			{
		         if (numbers1[j] > numbers1[j+1]) 
		         {
		        	 temp = numbers1[j];
			         numbers1[j] = numbers1[j + 1];
			         numbers1[j + 1] = temp;
			         swaps++;
		         }
		      }
		   }
        System.out.println(" ");
		System.out.println("Swaps: " + swaps);
		return numbers1;
	}
	
		public static void main(String[] args) 
		{
			//long time = 0L;
			Random random = new Random();
			
			int[] og = new int[10];
			int[] copy = new int[10];
			for(int i =0; i < og.length; i++)
			{
				og[i] = random.nextInt(10000);
				copy[i] = og[i];
			}
			
			int[] real = og;

			System.out.println("Bubble Sort");
			System.out.println("PRE SORT");
			for(int k = 0; k < 10; k++)
	        {
	        	System.out.print(real[k] + ", ");
	        } 
			int answer[] = BubbleSort(real);
			System.out.println("POST SORT");

			for(int k = 0; k < 10; k++)
	        {
	        	System.out.print(answer[k] + ", ");
	        } 
			System.out.println(" ");
			
			System.out.println(" ");

			System.out.println("Copy:");
			for(int k = 0; k < 10; k++)
	        {
	        	System.out.print(copy[k] + ", ");
	        } 
			
			/*System.out.println(" ");
			System.out.println("Insertion Sort");
			System.out.println("PRE SORT");
			for(int i = 0; i < 10; i++)
			{
				System.out.print(og[i] + ", ");
			}
			InsertionSort(og);
			System.out.println("POST SORT");

			for(int i = 0; i < 10; i++)
			{
				System.out.print(og[i] + ", ");
			}
			System.out.println(" ");
			og = copy;
			
			
			System.out.println(" ");
			System.out.println("Selection Sort");
			System.out.println("PRE SORT");
			for(int i = 0; i < 10; i++)
			{
				System.out.print(og[i] + ", ");
			}
			System.out.println(" ");
			SelectionSort(og);
			System.out.println("POST SORT");
			for(int i = 0; i < 10; i++)
			{
				System.out.print(og[i] + ", ");
			}
			System.out.println(" ");
			og = copy;
			
			
			System.out.println(" ");
			System.out.println("Shell Sort");
			System.out.println("PRE SORT");
			for(int i = 0; i < 10; i++)
			{
				System.out.print(og[i] + ", ");
			}
			ShellSort(og);
			System.out.println("POST SORT");
			for(int i = 0; i < 10; i++)
			{
				System.out.print(og[i] + ", ");
			}
			System.out.println(" ");
			og = copy;
			
			
			System.out.println(" ");
			System.out.println("Quick Sort");
			System.out.println("PRE SORT");
			for(int i = 0; i < 10; i++)
			{
				System.out.print(og[i] + ", ");*/
				
		}
}
