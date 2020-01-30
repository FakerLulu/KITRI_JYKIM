package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            int n = Integer.parseInt(br.readLine());
            int[] price = new int[n+1];
            int[] dp = new int[n+1];
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int i = 1, max;
            while (stk.hasMoreTokens()){
                price[i++] = Integer.parseInt(stk.nextToken());
            }
            dp[1] = price[1];
            for (i=2;i<=n;i++){
                max = price[i];
                for (int p=1;p<=i/2;p++){

                    if(max<dp[p]+dp[i-p]){
                        max = dp[i-p]+dp[p];
                    }
                    if(i%p==0){
                        if(max < price[p]*i/p){
                            max =  price[p]*i/p;
                        }
                    }
                    if(p>1  && i%(i-p)==0){
                        if(max < dp[i-p]*i%(i-p)){
                            max =  dp[i-p]*i%(i-p);
                        }
                    }
                }//wowwowwow
                dp[i] = max;
            }
            System.out.println(dp[n]);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
