
class Stacks {
	
	int [] arr ;
	int size ;
	int index = 0;
	public Stacks() {
		this.arr = new int[10];
		this.size = 0 ;
	}
	
	public void resize() {
		int [] newArr = new int[(arr.length-1) * 2];
		for(int i = 0;i< arr.length;i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}
	
	public void push(int data) {
		if(index == size - 1) {
			resize();
		}
		arr[index] = data;
		index ++;
		size++;
	}
	public int pop() {
		
		int temp =  arr[index - 1];
		index--;
		
		return temp;
		
	}
	public int peek() {
		return arr[index - 1];
	}
	public int getSize() {
		return size;
	}
	
}

public class ImplementStackUsingArray{
	public static void main(String[] args) {
		Stacks s = new Stacks();
		s.push(2);
		s.push(5);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
	}
}
