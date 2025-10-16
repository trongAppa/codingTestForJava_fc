package boj11652;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11652
public class Main {
    public static void main(String[] args) {
        // 입력
        input();
        // 동작부
        proc();
    }
    
    static int n;
    static long[] b;
    
    // 함수 구현
    static void proc() {
        Arrays.sort(b, 1, n+1);
        
        long m = b[1];
        int cc = 1, cm = 1;

        for(int i=2; i<=n; i++) {
            if(b[i] == b[i-1]) {
                cc++;
            } else {
                cc = 1;
            }

            if(cm < cc) {
                m = b[i];
                cm = cc;
            }
        }

        System.out.println(m);
    }

    static void input() {
        fastSb sc = new fastSb();
        
        n = sc.nextInt();
        
        b = new long[n+1];
        
        for(int i=1; i<=n; i++) {
            b[i] = sc.nextLong();
        }
    }

    static class fastSb {
        BufferedReader br;
        StringTokenizer st;

        public fastSb() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public fastSb(String s) throws FileNotFoundException{
            br = new BufferedReader(new FileReader(new File(s)));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}