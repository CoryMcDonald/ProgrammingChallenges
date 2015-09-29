import java.util.*;
import java.math.*;


class Main {
   //Dynamic Programming yay
	private static BigInteger[] m = new BigInteger[100000000];
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String first = "";
		String second = "";
		while(true)
		{
			first = s.next();
			second = s.next();
			
			if(first.equals("0") && second.equals("0")) break;
			
			BigInteger a = new BigInteger(first);
			BigInteger b = new BigInteger(second);
			
			int count = 0;
			int n = 1;
			BigInteger fn = new BigInteger("1");
			
			//loop through each fibonnacci number starting from n = 1
			//once we reach or exceed a, start counting
			//and count until we reach b
			while(fn.compareTo(b) <= 0){
				if(fn.compareTo(a) >= 0){
					count++;
				}
				
				n++;
				fn = fib(n);
			}
			System.out.println(count);
	   }
	}
	

	private static BigInteger fib(int n)
	{
		if(m[n] != null)
		{
			return m[n];
		}
		if(n == 1){
			return BigInteger.ONE;
		}
		if(n == 2){
			return new BigInteger("2");
		}
		else{
		   if(m[n-1] == null)
		      m[n-1] = fib(n-1);
		   if(m[n-2] == null)
		      m[n-2] = fib(n-2);
		      
			BigInteger answer = m[n-1].add(m[n-2]);
			m[n] = answer;
			return answer;
		}
	}
}