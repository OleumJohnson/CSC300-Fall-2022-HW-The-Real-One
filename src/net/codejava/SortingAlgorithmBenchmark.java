package net.codejava;
import java.util.Random;   

public class SortingAlgorithmBenchmark {
	
	static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
 
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    
    
	
    //adding the rest of the algos cause that's what we're supposed to do I guess...?
    static void bubbleSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //I originally tried the video way, but got frustrated and did it my own way
                }
            }
        }
        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
    }
	
	static void selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++) {
            int temporary = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[temporary]) {
                    temporary = j;
                }
            }
            int temp = arr[temporary];
            arr[temporary] = arr[i];
            arr[i] = temp;
        }
        /*for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }*/
    }
	
	static void insertionSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            //System.out.print("bababooey");
            while (j >= 0 && arr[j] > key) {
                //System.out.println("bababooey");
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        /*for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
            //System.out.print("bababooey");
        }*/
    }
	
	static void shellSort(int[] arr) { 
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j = j - gap) {
                    //System.out.println("bababooey");
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
        /*for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        } */   
    }
	
	
	

	public static void main(String[] args) {
		int[] arr = new int[10000];
		long start;
	    Random random = new Random();
		
		for(int i = 0; i < 10000; i++) {
			int num = random.nextInt(1000);
			arr[i] = num;
			//System.out.println(arr);
		}
		
		/*for(int i = 0; i < 10000; i++) {
			System.out.println(arr[i]);
		}*/
		
		int[] renewArr = arr;
		
		start = System.currentTimeMillis();
		quickSort(arr, 0, 9999);
        System.out.println("Finished sorting quickSort in " + (System.currentTimeMillis() - start) + " milliseconds.");
        //to reset the original, now sorted arr to its unsorted origin state
        arr = renewArr;
        
        start = System.currentTimeMillis();
		bubbleSort(arr);
        System.out.println("Finished sorting bubbleSort in " + (System.currentTimeMillis() - start) + " milliseconds.");
        arr = renewArr;
        
        start = System.currentTimeMillis();
		selectionSort(arr);
        System.out.println("Finished sorting selectionSort in " + (System.currentTimeMillis() - start) + " milliseconds.");
        arr = renewArr;
        
        //I spent like 30-45 minutes just trying to figure out why this one consistently got 1/0 mills, but I guess at the end of the day insertionsort is just that powerful lol
        start = System.currentTimeMillis();
		insertionSort(arr);
        System.out.println("Finished sorting insertionSort in " + (System.currentTimeMillis() - start) + " milliseconds.");
        arr = renewArr;

        start = System.currentTimeMillis();
		shellSort(arr);
        System.out.println("Finished sorting shellSort in " + (System.currentTimeMillis() - start) + " milliseconds.");
        arr = renewArr;
	}
}
