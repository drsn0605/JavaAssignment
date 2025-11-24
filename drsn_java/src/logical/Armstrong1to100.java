package logical;

public class Armstrong1to100 {
	public static void main(String[] args) {

		// 153 : 1 + 125 + 27 = 153
		for (int j = 100; j <= 999; j++) {

			int num = j;
			int temp = num; // bcoz at the end num value become zero, so we need to store num value in temp.
			int sum = 0;
			while (num != 0) {
				int rem = num % 10;
				sum += rem * rem * rem;
				num = num / 10;
			}
			if (temp == sum) {
				System.out.println(temp+" Armstrong");
			} else {
//				System.out.println(temp+" not Armstrong");
			}
		}
	}

}

