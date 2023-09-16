import java.util.*;
import java.io.*;

public class PrimePath
{ 
 
   public static void main(String[] args)
   {
      HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
      
      Scanner input = new Scanner(System.in);
      int s = input.nextInt();
      int e = input.nextInt();
      
      ArrayList<Integer> primeNums = new ArrayList<>();
      
      if (s < e)
      {
         for (int i = s; i <= e; i++) //beginning from start
         {
            if (isPrime(i) == true)
              {
               primeNums.add(i);
              }
         }
      }
      else
      {
         for (int i = e; i <= s; i++)//beginning from end
         {
            if (isPrime(i) == true)
            {
               primeNums.add(i);
            }
         }
      }
      
      for (int i = 0; i < primeNums.size(); i++)
      {
         for (int j = 0; j < primeNums.size(); j++)
         {
            if (isNextTo(primeNums.get(i), primeNums.get(j)))
            {
               if (g.get(primeNums.get(i)) == null)
               {
                  g.put(primeNums.get(i), new ArrayList<Integer>());
               }
               g.get(primeNums.get(i)).add(primeNums.get(j));
            }
         }
      }
      
      //data structures
      Queue<Integer> order = new LinkedList<>();
      HashMap<Integer, Boolean> v = new HashMap<Integer, Boolean>();
      HashMap<Integer, Integer> length = new HashMap<Integer, Integer>();
      
      order.offer(s);
      length.put(s, 0);
   
      boolean path = false;
      while(order.isEmpty() == false)
      {
         int current = order.poll();
         
         if (current == e)
         {
            path = true;
            System.out.println(length.get(current));
            break;
         } 
         else
         {
            for (int i : g.get(current)) 
            {
               if (!v.containsKey(i)) 
               {
                  order.offer(i);
                  length.put(i, length.get(current) + 1);
                  v.put(i, true);
               }
            }
         }
      }
      
      if (path == false)
      {
         System.out.println("-1");
      }
      
   }
   
   //extra methods
   private static boolean isPrime(int num)
   {
      for (int i = 2; i < num/2; i++)
      {
         if (num % i == 0)
         {
            return false;
         }
      }
      return true;
   }
   
   private static boolean isNextTo(int num1, int num2)
   {
      boolean isDiff = false;
      
      while (num1 != 0)
      {
         if (num1 % 10 != num2 % 10)
         {
            if (isDiff == true)
            {
               return false;
            }
            isDiff = true;
         }
         num1 /= 10;
         num2 /= 10;
      }
      return isDiff;
   }
   
}
