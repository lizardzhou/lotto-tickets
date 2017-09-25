
import java.util.*;

public class lottoTest {
	private static int[] outputBase = new int[5];
	private static int[] outputSuper = new int[2];
	
	public static void differentNums(int[] lottoPart, int n, int limit) {
		Random random = new Random();
		int currentNum = 0;
				
		while(currentNum < n) {
			boolean exist = false;
			int number = random.nextInt(limit) + 1;
						
			for(int j = 0; j < lottoPart.length; j++) {
				if(lottoPart[j] == number) {
					exist = true;
					break;
				}
			}

			if(!exist) {
				lottoPart[currentNum] = number;
				currentNum++;
			}
		}
	}
	
	public static int[] generateBase() {
		int trans;

		differentNums(outputBase,5,50);
		
		for(int count = 1; count < outputBase.length; count++) {	//arrange numbers from smallest to biggest
			for(int i = 0; i < outputBase.length-1; i++) {	
				if(outputBase[i] > outputBase[i+1]) {
					trans = outputBase[i];
					outputBase[i] = outputBase[i+1];
					outputBase[i+1] = trans;
				}
			}
		}		
		
		return outputBase;		
	}
	
	public static int[] generateSuper() {
		int trans;
	
		differentNums(outputSuper,2,10);
		
		for(int i = 0; i < outputSuper.length-1; i++) {	
			if(outputSuper[i] > outputSuper[i+1]) {
				trans = outputSuper[i];
				outputSuper[i] = outputSuper[i+1];
				outputSuper[i+1] = trans;
			}
			
		}
		
		return outputSuper;
	}
			
	public static void main(String[] args) {
		boolean programStillRun = true;	
		int countTickets = 0;
				
		while(programStillRun) {
			System.out.println("How many lottery tickets do you want ?");		
			int n = SimpleIO.readInt();
			countTickets += n;
						
			if(n <= 0) {
				System.out.println("Your input is invalid and please give me a positive number.");
				programStillRun = true;
				continue;
			} else if(n > 20 || countTickets > 20) {
				System.out.print("The program must be stopped to prevent you from being greedy.");
				programStillRun = false;
				break;
			} 
			
			for(int count = 1; count <= n; count++) {
				int[] arrBase = generateBase();
				int[] arrSuper = generateSuper();
				for (int i = 0; i < arrBase.length; i++) {	//若返回值是数组，则此数组不能直接输出，必须以元素形式输出
					System.out.print(arrBase[i] + " ");
				}
				System.out.print("|| ");
				for (int i = 0; i < arrSuper.length; i++) {
					System.out.print(arrSuper[i] + " ");
				}
				System.out.println();
			}
		}
	}
}
