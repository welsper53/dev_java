package dev_java.weak4.d221221.test;
// 클래스 하나에 기능은 하나만
import java.util.Scanner;

public class Test {
    public void sum() {
        Scanner sc = new Scanner(System.in);

        System.out.print("1 이상의 숫자를 입력하세요 : ");
        int num = sc.nextInt();

        int sum =0;
        if(num > 0) {           // before : if(num >= 0)
            int i = 1;
            while (i <= num) {
                sum += i;
                i++;            // after : 증감연산자 추가
            }
            System.out.println("1부터 " + num + "까지의 합은 " + sum + "입니다.");
        }else {
            System.out.println("숫자가 1이상이 아닙니다.");
        }

    }

    public static void main(String[] args) {
        Test t = new Test();
        t.sum();
    }
}


/*
 * 1부터 사용자가 입력한 값까지의 합을 구하려고 한다. 
 * 0을 초과한 숫자를 입력해야하고 0이하의 숫자를 입력했을 시 
 * "1이상의 숫자를 입력해달라"는 안내문구를 출력한다. 
 * 아래의 코드를 보고 문제점이 있는 곳을 찾아 [원인](15점)에 기술하고, 
 * 해결 방안을 [조치내용](15점)에 작성하여 보고서를 완성하시오. 
 */

/*
 * while문 사용 시 무한루프 방지코드를 작성할 것
 * 증감연산자 있는지 파악할 것
 * overflow
 * : break문, 증감연산자,
 */