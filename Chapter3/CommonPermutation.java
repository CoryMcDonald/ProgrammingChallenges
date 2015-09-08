import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine())
        {
            String word1 = scan.nextLine();
            String word2 = scan.nextLine();
            List<Character> A = new ArrayList<Character>();
            List<Character> B = new ArrayList<Character>();
            for (char c : word1.toCharArray())
                A.add(c);
            for (char c : word2.toCharArray())
                B.add(c);
            Object[] results = Intersect(A, B).toArray();
            Arrays.sort(results);
            //Regex to replace whitespace, brackets, and commas.
            String result = Arrays.toString(results).replaceAll("\\[|,|\\s|\\]", "");
            System.out.println(result);
        }
    }
    public static List<Character> Intersect(List<Character> A, List<Character> B)
    {
        List<Character> Return = new ArrayList<Character>();
        for(int i=0; i<A.size();i++)
        {
            if(B.contains(A.get(i)))
            {
                B.remove(A.get(i));
                Return.add(A.get(i));
            }
        }
        return Return;
    }
}