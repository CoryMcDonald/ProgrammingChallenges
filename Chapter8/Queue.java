import java.util.*;

class Main
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      int cases = Integer.parseInt(scan.nextLine());
   	while(cases-- > 0)
   	{
   		int N = scan.nextInt();
   		int P = scan.nextInt();
   		int R = scan.nextInt();
   		System.out.println(permutations(N, P, R));
   	}
   }
   static int permutations(int N, int P, int R){
   	if(N < P || N < R || N <= 0 || P <= 0 || R <= 0)
   	   return 0;
   	if(N == 1)
   	   return (P == 1 && R == 1) ? 1 : 0;
   	return permutations(N-1, P, R)*(N-2) + permutations(N-1, P-1, R) + permutations(N-1, P, R-1);
   }
}