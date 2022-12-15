package dev_java.weak3.d221215.Tables;

public class StringCopy {
    public static void main(String[] args) {
        String str = "Hello";
        String str1 = "Hello";
        System.out.println(str == str1);        // 주소번지가 같은지
        System.out.println(str.equals(str1));   // 주소번지가 가리키는 값이 같은지
        
        String str2 = new String("Hello");
        String str3 = new String("Hello");
        System.out.println(str2 == str3);        // 주소번지가 같은지
        System.out.println(str2.equals(str3));   // 주소번지가 가리키는 값이 같은지

    }
}
