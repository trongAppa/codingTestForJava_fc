import java.util.Scanner;

public class boj2744 {
    public static void main(String[] args) {
        // ASCII CODE를 사용하여 해결
        System.out.print("입력하세요");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if('A' <= ch && ch <= 'Z') {
                System.out.print((char)('a' + ch - 'A' ));
            } else {
                System.out.print((char)('A' + ch - 'a'));
            }
        }        
    }
}