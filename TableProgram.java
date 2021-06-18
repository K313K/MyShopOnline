public class TableProgram {
	public static void table(int N, int i) {
		if (i > 10)
			return;
		System.out.println( N * i);
		table(N, i + 1);
		
	}

	public static void main(String[] args) {

		int N = 2;

		table(N, 1);
		
	}
	
}
