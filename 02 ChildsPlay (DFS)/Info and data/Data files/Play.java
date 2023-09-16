import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class Play 
{
   public static void main(String[] args) 
   {
        Scanner file = null;

        try 
        {
            file = new Scanner(new File("play.dat"));   
        }
        catch (Exception e) 
        {
             System.out.println("File error " + e);
        }
            int cases = file.nextInt();
            file.nextLine();
            for (int i = 0 ; i < cases; i++) 
            {
                System.out.println(play(file));
            }

            file.close();
    }

    public static int play(Scanner file) {
        
        HashMap<Integer, HashSet<Integer>> graphs = new HashMap<>();
        int dominoNum = file.nextInt();
        for (int i = 1; i <= dominoNum; i++)
        {
            graphs.put(i,new HashSet<>());
        }
        int numKnocked = file.nextInt();
        int count = file.nextInt();

        for (int i = 0; i < numKnocked; i++)
        {
            int key = file.nextInt();
            int val = file.nextInt();
            graphs.get(key).add(val);
        }
        int startingD = file.nextInt();

        Stack<Integer> knocked = new Stack<>();
        ArrayList<Integer> visited = new ArrayList<>();
        visited.add(startingD);
        knocked.push(startingD);
        while(!knocked.isEmpty()) 
        {
            int key = knocked.pop();
            for(Integer n:graphs.get(key)) 
            {
                if (!visited.contains(n))
                {
                    knocked.push(n);
                    visited.add(n);
                    count++;
                }
            }

        }
        return count;
    }
}