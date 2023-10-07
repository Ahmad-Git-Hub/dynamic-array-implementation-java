import java.util.Arrays;

public class TestDynamicArray {
	
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.push(1); //0
		list.push(2); //1
		list.push(3); //2
		list.push(5); //3 
		list.push(6); // 4
		list.display();
		list.pushAt(4, 3);//5
		
		list.extend();
		list.display();
		list.shrink();
		list.display();
		
	}
}
