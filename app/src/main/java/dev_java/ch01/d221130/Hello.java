package dev_java.ch01.d221130;

public class Hello {

    /**
     * @param i
     * @param j
     * @return
     */
    int methodA(int i, int j) {
        int hap;
        hap = i + j;
        return hap;
    }

    public static void main(String[] args) {
        System.out.println("Hellooooo");

        Hello hello = new Hello();
        int a = hello.methodA(5, 6);

        System.out.println(a);
    }

}
