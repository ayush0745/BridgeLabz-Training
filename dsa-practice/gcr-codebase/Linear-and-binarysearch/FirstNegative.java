public class FirstNegative{
	public static void main(String[] args) {
		int [] arr = new int[] {1,2,4,-4,23,4};
		for( int val : arr) {
			if(val < 0) {
				System.out.println(val);
				break;
			}
		}
		
	}
}