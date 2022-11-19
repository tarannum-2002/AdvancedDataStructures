import java.lang.*;
import java.io.*;
import java.util.*;


public class islands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("number of rows and coloums");
        int n= sc.nextInt();
        int m= sc.nextInt();
        int[][] a = new int[n][m];


        System.out.println("enter the matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Number of Islands is: " + countIslands(a));

    }

    private static int countIslands(int[][] a) {
        int n = a.length; //row
        int m = a[0].length; //col
        int result = 0;
        disjoint_sets set = new disjoint_sets(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    if (i + 1 < n && a[i + 1][j] == 1)
                        set.union(i * (m) + j, (i + 1) * (m) + j);
                    if (i - 1 >= 0 && a[i - 1][j] == 1)
                        set.union(i * (m) + j, (i - 1) * (m) + j);
                    if (j + 1 < m && a[i][j + 1] == 1)
                        set.union(i * (m) + j, (i) * (m) + j + 1);
                    if (j - 1 >= 0 && a[i][j - 1] == 1)
                        set.union(i * (m) + j, (i) * (m) + j - 1);
                    if (i + 1 < n && j + 1 < m && a[i + 1][j + 1] == 1)
                        set.union(i * (m) + j, (i + 1) * (m) + j + 1);
                    if (i + 1 < n && j - 1 >= 0 && a[i + 1][j - 1] == 1)
                        set.union(i * m + j, (i + 1) * (m) + j - 1);
                    if (i - 1 >= 0 && j + 1 < m && a[i - 1][j + 1] == 1)
                        set.union(i * m + j, (i - 1) * m + j + 1);
                    if (i - 1 >= 0 && j - 1 >= 0 && a[i - 1][j - 1] == 1)
                        set.union(i * m + j, (i - 1) * m + j - 1);
                }
                if (a[i][j] == 0)
                    continue;
            }

        }
        int[] frequency = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    int k = set.find(i*m+j); // didn't get this
                    if(frequency[k] == 0){
                        result++;
                        frequency[k]++;
                    }
                    else{
                        frequency[k]++;
                    }
            }
        }
    }

    return result;
    }

}


