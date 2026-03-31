public class FindIn2DMatrix{
	public static void main(String[] args) {
		int [] [] arr = new int [][] { {1,2,3},{4,5,6},{7,8,9} };
		
		int left = 0;
		int right = arr.length * arr[0].length - 1;
		int target = 5;
		while(left <= right ) {
			int mid = left + (right -left ) / 2;
			
			int row = mid / arr[0].length;
			int col = mid % arr[0].length;
			
			if( arr[row][col] == target) {
				System.out.println("found");
				return;
			}
			else if( arr[row][col] > target) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		 System.out.println("Not Found");
	}
}