package net.codejava;
import java.util.ArrayList;

public class SortedMatrixSearch {
	//just gonna switch the type from array to string cause you cant print an array without a pile of crazy tostring stuff
	static String MatrixSearch(int[][] arr, int key){
		
		ArrayList<Integer> realarray = new ArrayList<>();
		
		//throwing away the weird 2D array thing and yeeting the contents into
		//a normal arraylist that binary search can feasibly be used on
		for(int i = 0; i < arr.length; i++) {
			//System.out.println("bababooey");
			for(int j = 0; j < arr[i].length; j++) {
				realarray.add(arr[i][j]);
			}
		}

		//now for the sorting of the normal arraylist
		int lower = 0;
		int upper = realarray.size();
		int middle = (lower + upper) / 2;
		
		while(lower <= upper) {
			if(realarray.get(middle) > key) {
				upper = middle - 1;
				middle = (lower + upper) / 2;
			}
			else if(realarray.get(middle) < key) {
				lower = middle + 1;
				middle = (lower + upper) / 2;
			}
			else {
				//trying to find where the found key would be in arr with coords and such
				for(int k = 0; k < arr.length; k++) {
					for(int l = 0; l < arr[k].length; l++) {
						if(arr[k][l] == realarray.get(middle)) {
							//returning coords
							return "[" + k + "," + l + "]";
						}
					}
				}
			}
		}
		//System.out.println("bababooey");
		return null;
	}
	
	

	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		System.out.println(arr[1][0]); //arr[1][0] is 5
		//$ 5
		System.out.println(MatrixSearch(arr, 5));
		//$ [1,0]
	}

}
