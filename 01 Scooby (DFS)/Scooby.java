import java.util.*;
import java.io.*;

public class Scooby
{
    public static void main(String[] args) 
    {   
      Scanner file = null;
      try 
      {
        file = new Scanner(new File("Scooby.dat"));                  
      } 
      catch( Exception e ) { System.out.println("File error " + e); }             
      int testCases = file.nextInt();    
      file.nextLine();     
      for (int i = 0; i < testCases; i++) {
         solveProblem(file);                  
      }            
   }
   
   public static void solveProblem(Scanner file) 
   {            
      HashMap<Character, HashSet<Character>> graph = new HashMap<>();
      String edges = file.nextLine();
      for (String edge : edges.split(" ")) 
      {
         char node1 = edge.charAt(0);
         char node2 = edge.charAt(1);
         
         if (! graph.containsKey(node1)) 
            graph.put(node1, new HashSet<Character>());
         graph.get(node1).add(node2);                                 
         if (! graph.containsKey(node2))
            graph.put(node2, new HashSet<Character>());
         graph.get(node2).add(node1); 
      }
      
      String s = file.nextLine();
      char start = s.charAt(0);
      char goal = s.charAt(1);
      
      if (! graph.containsKey(start) || ! graph.containsKey(goal)) {
         System.out.println("no");
         return;
      }                     
      
      
      Stack<Character> todo = new Stack<Character>();
      HashSet<Character> visited = new HashSet<Character>();
      todo.push(start);   
      visited.add(start);       
       
      boolean pathFound = false;
      while (! todo.isEmpty()) 
      {
         char currentLoc = todo.pop();
         if (currentLoc == goal) 
         {
            pathFound = true;
            break;
         }
         
         for (char spot : graph.get(currentLoc)) 
         { 
            if (! visited.contains(spot)) 
            { 
               todo.push(spot);
               visited.add(spot);
            }
         }          
      }
      if (pathFound)
         System.out.println("yes");
      else
         System.out.println("no");         
   }            

}