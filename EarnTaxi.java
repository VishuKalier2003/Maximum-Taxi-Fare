/* There are n points on a road you are driving your taxi on... The n points on the road are labeled from 1 to n in the direction you are going, and you want to drive from point 1 to point n to make money by picking up passengers... You cannot change the direction of the taxi... The passengers are represented by a 0-indexed 2D integer array rides, where rides[i] = [starti, endi, tipi] denotes the ith passenger requesting a ride from point starti to point endi who is willing to give a tipi dollar tip... For each passenger i you pick up, you earn endi - starti + tipi dollars... You may only drive at most one passenger at a time... Given n and rides, return the maximum number of dollars you can earn by picking up the passengers optimally... Note: You may drop off a passenger and pick up a different passenger at the same point...
 * Eg 1: n = 5   rides = [[2,5,4],[1,5,1]]                                               Output = 7
 * Eg 2: n = 20  rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]       Output = 20
 */
import java.util.*;
public class EarnTaxi
{
    public long MaximumProfit(int A[][], int n)
    {
        Arrays.sort(A, (a, b) -> a[0] - b[0]);    // Sorting function taking the comparison as a parameter, a-b sorts them in ascending order...
        long[] dp = new long[n + 1];
        int j = 0;
        for(int i = 1; i <= n; ++i) {
            dp[i] = Math.max(dp[i], dp[i - 1]);     // Dynamic Programming Array...
            while (j < A.length && A[j][0] == i) {
                dp[A[j][1]] = Math.max(dp[A[j][1]], dp[i] + A[j][1] - A[j][0] + A[j][2]);
                ++j;     // Using the formula provided...
            }
        }
        return dp[n];
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x, passengers;
        System.out.print("Enter the length of the road : ");
        x = sc.nextInt();
        System.out.print("Enter the number of Passengers : ");
        passengers = sc.nextInt();
        int rides[][] = new int[3][passengers];
        for(int i = 0; i < passengers; i++)
        {
            System.out.print("Enter the start for the "+(i+1)+" Passenger : ");
            rides[0][i] = sc.nextInt();
            System.out.print("Enter the stop for the "+(i+1)+" Passenger : ");
            rides[1][i] = sc.nextInt();
            System.out.print("Enter the tip given by the "+(i+1)+" Passenger : ");
            rides[2][i] = sc.nextInt();
        }
        System.out.println("The Data tabulated below : ");
        for(int i = 0; i < rides[0].length; i++)
            System.out.print("["+rides[0][i]+", "+rides[1][i]+", "+rides[2][i]+"], ");
        System.out.println();
        EarnTaxi earntaxi = new EarnTaxi();
        earntaxi.MaximumProfit(rides, x);
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :- 
 * 1. We can sort the array on the basis of their comparisons of the distances...
 * 2. We can then dynamically keep the track of the distances...
*/