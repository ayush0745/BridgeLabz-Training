import java.util.Arrays;

public class CircularBuffer<T> {

	T buffer[];
	int front = 0;
	int end = 0;
	int size = 0;
	int capacity;

	CircularBuffer(int capacity) {
		this.capacity = capacity;
		buffer = (T[]) new Object[capacity];
	}

	public void add(T x) {
		buffer[end] = x;
		end = (end + 1) % capacity;
		if (size < capacity) {
			size++;
		} else {
			front = (front + 1) % capacity;
		}
	}

	public T[] getBuffer() {
		T ans[] = (T[]) new Object[size];
		for (int i = 0; i < size; i++) {
			ans[i] = buffer[(front + 1) % capacity];
		}
		return ans;
	}

	public T peek() {
		if (size == 0) {
			return null;
		}
		return buffer[front];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		
		CircularBuffer<Integer> cb = new CircularBuffer<Integer>(3);
		cb.add(1);
		cb.add(2);
		cb.add(3);
		System.out.println("Buffer " + Arrays.toString(cb.buffer));
		System.out.println();

		cb.add(4);
		System.out.println("Buffer " + Arrays.toString(cb.buffer));
		System.out.println();
	}

}