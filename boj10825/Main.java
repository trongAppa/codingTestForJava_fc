package boj10825;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10825
public class Main {
    public static void main(String[] args) {
        // 입력
        input();
        // 동작부
        proc();
    }
    
    static StringBuilder sb = new StringBuilder();

    static int n;
    static em[] a;
    
    static class em implements Comparable<em> {
        public String name;
        public int kor, eng, math; 

        @Override
        public int compareTo(em other) {
            if(kor != other.kor) return other.kor - kor;
            if(eng != other.eng) return eng - other.eng;
            if(math != other.math) return other.math - math;
            return name.compareTo(other.name);
        }
    }

    // 함수 구현
    static void proc() {
        Arrays.sort(a);
        for(int i=0; i<n; i++) {
            sb.append(a[i].name).append('\n');
        }
        System.out.println(sb.toString());
    }

    static void input() {
        fastSb sc = new fastSb();
        // 학생 수 입력
        n = sc.nextInt();
        a = new em[n];
        for(int i=0; i<n; i++) {
            a[i] = new em();
            a[i].name = sc.next();
            a[i].kor = sc.nextInt();
            a[i].eng = sc.nextInt();
            a[i].math = sc.nextInt();
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