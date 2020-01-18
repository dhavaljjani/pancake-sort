import java.util.ArrayList;
import java.util.Random;


public class PancakeSort {
	
	public static void main(String[] args) {
		System.out.println("(Sorts descending from the left)");
		//random order
		ArrayList<Comparable> arr1 = new ArrayList<Comparable>();
		for(int i = 0 ; i < 10 ; i++) {
			arr1.add((int)(Math.random() * 100));
		}
		System.out.println("Random List order");
		System.out.println("Before: " + arr1.toString());
		arr1 = pancakeSort(arr1);
		System.out.println("After: " + arr1.toString());
		//opposite order
		ArrayList<Comparable> arr2 = new ArrayList<Comparable>();
		for(int i = 1 ; i <= 10 ; i++) {
			arr2.add(i);
		}
		System.out.println();
		System.out.println("Reverse, completely max unsorted list: ");
		System.out.println("Before: " + arr2.toString());
		arr2 = pancakeSort(arr2);
		System.out.println("After: " + arr2.toString());
		//almost sorted
		ArrayList<Comparable> arr3 = new ArrayList<Comparable>();
		arr3.add(10);
		arr3.add(9);
		arr3.add(8);
		arr3.add(7);
		arr3.add(6);
		arr3.add(5);
		arr3.add(3);
		arr3.add(4);
		arr3.add(2);
		arr3.add(1);
		System.out.println();
		System.out.println("Almost sorted list: ");
		System.out.println("Before: " + arr3.toString());
		arr3 = pancakeSort(arr3);
		System.out.println("After: " + arr3.toString());
		//maximum at start
		ArrayList<Comparable> arr4 = new ArrayList<Comparable>();
		arr4.add(100);
		arr4.add(2);
		arr4.add(3);
		arr4.add(4);
		arr4.add(5);
		arr4.add(7);
		arr4.add(6);
		arr4.add(8);
		arr4.add(9);
		arr4.add(10);
		System.out.println();
		System.out.println("Maximum value at start (index 0) list: ");
		System.out.println("Before: " + arr4.toString());
		arr4 = pancakeSort(arr4);
		System.out.println("After: " + arr4.toString());
	}
	
	public static ArrayList<Comparable> pancakeSort(ArrayList<Comparable> arr) {
		//sorts descending from left
		for(int i = 0 ; i < arr.size() ; i++) {
			int maximum = findMax(arr, i);
			if(arr.indexOf(maximum) != arr.size() - 1) {
				arr = flip(arr, arr.indexOf(maximum), arr.size() - 1);
				arr = flip(arr, i, arr.size() - 1);
			} else {
				arr = flip(arr, i, arr.size() - 1);
			}
			//System.out.println(arr.toString());
		}
		
		return arr;
	}
	
	
	private static ArrayList<Comparable> flip(ArrayList<Comparable> arr, int start, int end) {
		ArrayList<Comparable> arr2 = new ArrayList<Comparable>();
		for(int i = 0 ; i < start ; i++) {
			arr2.add(arr.get(i));
		}
		for(int i = end ; i >= start ; i--) {
			arr2.add(arr.get(i));
		}
		return arr2;
	}

	private static int findMax(ArrayList<Comparable> array, int i) {
		Integer max = 0;
		for(int f = i ; f < array.size(); f++) {
			if(max.compareTo((Integer)array.get(f)) < 0) {
				max = (Integer) array.get(f);
			}
		}
		return (int)(max);
	}
}
