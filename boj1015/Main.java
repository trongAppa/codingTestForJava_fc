package boj1015;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1015
public class Main {
    public static void main(String[] args) {
        // 입력
        input();
        // 동작부
        proc();
    }
    
    static StringBuilder sb = new StringBuilder();

    static int n;
    static em[] b;
    static int[] p;
    
    static class em implements Comparable<em> {
        public int num, idx; 

        @Override
        public int compareTo(em other) {
            return num - other.num;
        }
    }

    // 함수 구현
    static void proc() {
        Arrays.sort(b);
        
        for(int i=0; i<n; i++) {
            p[b[i].idx] = i; 
        }

        for(int i=0; i<n; i++) {
            sb.append(p[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    static void input() {
        fastSb sc = new fastSb();
        
        n = sc.nextInt();
        
        b = new em[n];
        p = new int[n];
        
        for(int i=0; i<n; i++) {
            b[i] = new em();
            b[i].num = sc.nextInt();
            b[i].idx = i;
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