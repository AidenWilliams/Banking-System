import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;

public class Tree {
    //https://www.geeksforgeeks.org/find-whether-a-given-number-is-a-power-of-4-or-not/
    // Function to check if
    // x is power of 4
    static boolean isPowerOfFour(int n)
    {
        if(n == 0)
            return false;
        while(n != 1)
        {
            if(n % 4 != 0)
                return false;
            n = n / 4;
        }
        return true;
    }

    public static void main (String[] args){
        String currentDirectory = System.getProperty("user.dir");
        int NE = -1,SE = 1;
        boolean lineDone = false;
        try {
            FileReader reader = new FileReader(currentDirectory + args[0]);
            int character;

            while ((character = reader.read()) != -1) {
                if (character == '\n') {
                    SE++;
                    lineDone = true;
                } else if (!lineDone){
                    NE++;
                }
                System.out.print((char) character);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(SE != NE){
            System.out.println("Input must be a square");
            return;
        }

        if(!isPowerOfFour(SE) | !isPowerOfFour(NE)){
            System.out.println("Width AND Height must be to the power of 4");
            return;
        }

    }
}
