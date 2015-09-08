import java.util.*;
import java.io.*;
class Main
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      while(scan.hasNextLine())
      {
         String input = scan.nextLine();
         for(int i=0; i < input.length(); i++)
            System.out.print(decode(input.charAt(i)));
         System.out.println();
      }
   }
	private static char decode(char inputChar) {
		char outputChar = 0;
		switch (inputChar) {
		// first Row
		case '2':
			outputChar = '1';
			break;
		case '3':
			outputChar = '2';
			break;
		case '4':
			outputChar = '3';
			break;
		case '5':
			outputChar = '4';
			break;
		case '6':
			outputChar = '5';
			break;
		case '7':
			outputChar = '6';
			break;
		case '8':
			outputChar = '7';
			break;
		case '9':
			outputChar = '8';
			break;
		case '0':
			outputChar = '9';
			break;
		case '-':
			outputChar = '0';
			break;
		case '=':
			outputChar = '-';
			break;
		// second Row
		case 'W':
			outputChar = 'Q';
			break;
		case 'E':
			outputChar = 'W';
			break;
		case 'R':
			outputChar = 'E';
			break;
		case 'T':
			outputChar = 'R';
			break;
		case 'Y':
			outputChar = 'T';
			break;
		case 'U':
			outputChar = 'Y';
			break;
		case 'I':
			outputChar = 'U';
			break;
		case 'O':
			outputChar = 'I';
			break;
		case 'P':
			outputChar = 'O';
			break;
		case '[':
			outputChar = 'P';
			break;
		case ']':
			outputChar = '[';
			break;
		case '\\':
			outputChar = ']';
			break;
		// Third Row
		case 'S':
			outputChar = 'A';
			break;
		case 'D':
			outputChar = 'S';
			break;
		case 'F':
			outputChar = 'D';
			break;
		case 'G':
			outputChar = 'F';
			break;
		case 'H':
			outputChar = 'G';
			break;
		case 'J':
			outputChar = 'H';
			break;
		case 'K':
			outputChar = 'J';
			break;
		case 'L':
			outputChar = 'K';
			break;
		case ';':
			outputChar = 'L';
			break;
		case '\'':
			outputChar = ';';
			break;
		// Fourth Row
		case 'X':
			outputChar = 'Z';
			break;
		case 'C':
			outputChar = 'X';
			break;
		case 'V':
			outputChar = 'C';
			break;
		case 'B':
			outputChar = 'V';
			break;
		case 'N':
			outputChar = 'B';
			break;
		case 'M':
			outputChar = 'N';
			break;
		case ',':
			outputChar = 'M';
			break;
		case '.':
			outputChar = ',';
			break;
		case '/':
			outputChar = '.';
			break;
		default:
			outputChar = inputChar;
			break;
		}
		return outputChar;
	}
}