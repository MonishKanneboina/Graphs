import java.util.*;
import java.io.*;

public class BinaryMaze
{
   
   public static void main (String[] args)
   {
      Scanner f = null;
      try{
            f = new Scanner(new File("maze.txt"));
         }
      catch (Exception e)
      {
         System.out.println("Cannot find file!");
      }
      
      int r = f.nextInt();
      int c = f.nextInt();
      f.nextLine();
      
      int[][] m = new int[r][c];
      
      for (int i = 0; i < r; i++)
      {
         for (int j = 0; j < c; j++)
         {
            m[i][j] = f.nextInt();
         }
      }
      
      PathNode s = new PathNode(f.nextInt(), f.nextInt(), 0);
      PathNode e = new PathNode(f.nextInt(), f.nextInt(), 0);
      Queue<PathNode> g = new LinkedList<>();
      
      g.offer(s);
      boolean[][] v= new boolean[r][c];
      boolean pathAvailable = false;
      
      while(g.isEmpty() == false)
      {
         PathNode t = g.poll();
         if (t.i < 0 || t.i >= r || t.j < 0 || t.j >= c)
            {
               continue;
            }
         if (m[t.i][t.j] == 0)
            {
               continue;
            }
         if (v[t.i][t.j] == true)
            {
               continue;
            }
         v[t.i][t.j] = true;
         
         if (t.i == e.i && t.j == e.j)
         {
            pathAvailable = true;
            System.out.println(t.distance);
            break;
         }
         else
         {
            g.offer(new PathNode(t.i-1, t.j, t.distance+1));
            g.offer(new PathNode(t.i, t.j-1, t.distance+1));
            g.offer(new PathNode(t.i, t.j+1, t.distance+1));
            g.offer(new PathNode(t.i+1, t.j, t.distance+1));
         }
      }
      if (pathAvailable == false)
      {
            System.out.println("-1");
      }
      
   }   
   
}

class PathNode {
   int i;
   int j;
   int distance;
   public PathNode(int i, int j, int distance)
   {
      this.i = i;
      this.j = j;
      this.distance = distance;
   }
}
