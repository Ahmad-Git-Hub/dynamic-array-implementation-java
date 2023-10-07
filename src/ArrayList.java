import java.util.Arrays;
import java.util.Scanner;

public class ArrayList {

	static Scanner in = new Scanner(System.in);
	private int[] arr;
	private int size;
	private int current;

	ArrayList() {
		size = 2;
		arr = new int[2];
		current = 0;
	}

	
	public void display() {
		System.out.print("cuurent list {");
		for (int i = 0; i < current; i++) {
			System.out.print(i < current-1 ? arr[i]+" " : arr[i]+"}");
		}
		System.out.println();
		
		System.out.print("full list {");
		for (int i = 0; i < size; i++) {
			System.out.print(  (i == size-1) ? arr[i]+"}" : arr[i]+" ," );
		}
	}
	void push(int value) {
		if(isFull()) {
			extend();
		}
		
		arr[current] = value;
		System.out.println(value +" insrted at index "+current);

		current++;
		
	}
	void pushAt(int value, int index) {
		
		if(isFull()) {
			extend();
			pushAt(value, index);
		}
		
		
		else if(arr[index] != 0) {
			
			for (int i = current; i > index; i--) {
				arr[i] = arr[i-1];
			}
			System.out.println(Arrays.toString(arr));
			
			arr[index] = value;
			System.out.println(value +" insrted at index "+index);
			current++;
		}
		else {
			arr[index] = value;
			System.out.println(value +" insrted at index "+current);
			current++;
		}
		
	}
	boolean isFull() {
		return current == size;
	}

	void resize() {

		int choice;

		do {
			System.out.println("1.shrink");
			System.out.println("2.extend");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				shrink();
				break;
			case 2:
				extend();
				break;
			default:
				System.out.println("unvalid choice");
			}
		} while (choice != 1 || choice != 2);
	}

	void extend() {

		int choice;
		do {
			System.out.println("chose size : ");
			System.out.println("1/double");
			System.out.println("2/size+10");
			System.out.println("3/coustom");

			System.out.print("choice : ");
			choice = in.nextInt();

			switch (choice) {
			case 1:
				size = size * 2;
				break;
			case 2:
				size += 10;
				break;
			case 3:
				size = in.nextInt();
				break;
			default:
				System.out.println("unvalid choice");
			}
		} while (choice > 3 || choice < 1);

		int[] temp = new int[size];
		for (int i = 0; i < current; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
		

	}

	void shrink() {

		int[] temp = new int[current];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
		size = current;
		
	}

}
