package boj20291;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/20291
public class Main {
    public static void main(String[] args) {
        // 입력
        input();
        // 동작부
        proc();
    }
    
    static StringBuilder sb = new StringBuilder();

    static int n;
    static String[] b;
    
    // 함수 구현
    static void proc() {
        Arrays.sort(b, 1, n+1);
        
        for(int i=1; i<=n; ) {
            int cnt = 1, j = i+1;

            for(; j<=n; j++) {
                if(b[i].compareTo(b[j]) == 0)
                {
                    cnt++;
                } else {
                    break;
                }
            }

            sb.append(b[i]).append(' ').append(cnt).append('\n');

            i = j;
        }

        System.out.println(sb.toString());
    }

    static void input() {
        fastSb sc = new fastSb();
        
        n = sc.nextInt();
        
        b = new String[n+1];

        for(int i=1; i<=n; i++) {
            b[i] = sc.nextLine().split("\\.")[1];
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