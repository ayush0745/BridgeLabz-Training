public class FindWord{
	public static void main(String[] args) {
		String [] arr = new String[] {"i am ayush","hello i am rathour"};
		boolean flag = true;
		for(String str : arr) {
			for(String s: str.split("\\s+")) {
				
				if(s.equals("hello")) {
					System.out.println(str);
					flag = false;
				}
			}
		}
		
		if(flag) {
		System.out.println("Not Found");}
	}
}