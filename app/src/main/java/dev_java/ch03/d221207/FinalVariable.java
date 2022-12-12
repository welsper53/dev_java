package dev_java.ch03.d221207;

public class FinalVariable {
    
    static void methodA() {
        int i = 5;
        i = 7;
        final double PIE = 3.14;
        //PIE = 5.45;
    }

    public static void main(String[] args) {
        FinalVariable.methodA();
    }
}
