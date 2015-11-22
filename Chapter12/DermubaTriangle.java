import java.io.File;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int start = sc.nextInt();
            int dest = sc.nextInt();
            double[] startCoordinate;
            double[] destCoordinate;
            startCoordinate = absLocationFinder(start);
            destCoordinate = absLocationFinder(dest);
            System.out.format("%.3f%n",Math.hypot(Math.abs(startCoordinate[0] - destCoordinate[0]),
                    Math.abs(startCoordinate[1] - destCoordinate[1])));
        }
    }

   	public static double[] absLocationFinder(int n)
   	{
   		long lastAddr = 0;
   		int cnt = 1;
   		int yPos = 1;
   		int xPos = 0;
   		while(n > lastAddr){
   			lastAddr += cnt +=2;
   			yPos++;
   		}
   		int middleAddr = (int)(lastAddr - ((cnt - 1) / 2));
   		if(middleAddr == n){
   			xPos = 0;
   		} else {
   			xPos = middleAddr - n;
		   }
   		final double commonHeight = Math.sqrt(3) / (double)2;
   		final double oddCenterHeight = (double)2 / (double)3 * commonHeight;
   		final double evenCenterHeight = (double)1 / (double)3 * commonHeight;
   		double absYPos = 0;
   		if(yPos > 1){
   			absYPos += evenCenterHeight;
   			absYPos += (double)(yPos-2) * commonHeight;
   			if((xPos + yPos)% 2 == 0){
   				absYPos += evenCenterHeight;
   			} else {
   				absYPos += oddCenterHeight;
   			}
   		}
   		double absXPos = ((double)xPos / (double)2);
   		return new double[] {absXPos,absYPos};
	}
}