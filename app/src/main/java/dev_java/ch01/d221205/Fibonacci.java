package dev_java.ch01.d221205;
// 2022-12-05일 숙제
// 피보나치 수열의 규칙을 만족하는 프로그램을 작성하고
// a1에서 a10번째 항까지 출력되도록 해보시오.

public class Fibonacci {
    int arr[];

    // 배열로 실행
    public Fibonacci(int i) {
        this.arr = new int[i];

        arr[0] = 1;
        arr[1] = 1;   
    }
    void put() {
        System.out.println("\n피보나치 시작");

        for (int n=0; n<(arr.length-2); n++) {
            arr[n+2] = arr[n] + arr[n+1];
            
        }
        for (int m=0; m<arr.length; m++) {
            System.out.print(arr[m] + " ");
        }
    }

    // Swap으로 실행
    void SwapAction() {
        System.out.println("\nSwap으로 시작");

        int a1=1;
        int a2=1;
        int a3=0;
        System.out.print(a1+" "+a2+" ");
        for (int i=0;i<8;i++) {
            a3=a1+a2;
            System.out.print(a3+" ");
            a1=a2;      // 두번째 수를 세번째 수로
            a2=a3;      // 현재의 수를 첫번째 수로
        }
    }
    
    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci(10);
        // fibo.put();

        fibo.SwapAction();
    }
}
