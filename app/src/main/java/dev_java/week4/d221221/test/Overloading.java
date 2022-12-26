package dev_java.week4.d221221.test;

public class Overloading {
    public void test() {}
    public void test(String str) {}
    public void test(int i) {}
    // public void test(String s) {}
    public void test(char ch) {}
    public void test(String str, int i) {}
    public void test(int i, String str) {}
    // private void test(int i) {}
    // public int test() {return 0;}
}


/*
 * 아래 코드 중 에러가 나는 코드 라인을 모두 찾아 [원인](10점)에 작성하고, 
 * 에러가 나는 이유를 [조치내용](10점)에 상세히 작성하시오.
 */

/*
 * 자바에서는 같은 이름의 메소드를 중복 선언 가능하다
 * 메소드 오버로딩 - 이것과 관계 - 생성자 컨셉
 * : 무조건 파라미터의 갯수나 타입이 달라야 한다
 * : 접근제한자가 있고 없고는 영향이 없다
 * : 리턴타입이 있고 없고는 영향이 없다
 * : 예외를 던지고 던지지않고는 영향이 없다
 * : 파라미터의 변수이름이 다른것은 영향이 없다
 * 메소드 오버라이딩 - 문제와 상과 없음
 */
// class Exam1 {
//     public void methodA() {}
//     public void methodA(int a){}
//     // throws : 나를 호출한 곳에서 예외처리를 받으세요
//     public void methodA(int a) throws Exception {}
//     public void methodA(double d, String name) {}
//     public void methodA(String name, double b) {}
// }