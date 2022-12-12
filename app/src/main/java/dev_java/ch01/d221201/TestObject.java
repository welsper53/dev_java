package dev_java.ch01.d221201;

class Object {
     int val;
}

public class TestObject {
     void methodObj(Object o) {
          o = new Object();
          o.val = 500;
    // o = new Object();
     System.out.println("sub o.val의 값: " + o.val);
     }

     public static void main(String[] args) {
          TestObject tobj = new TestObject();
          Object obj = new Object();
          obj.val = 100;
          tobj.methodObj(obj);
          System.out.println("main o.val의 값: " + obj.val);
     }
}

// 9,11번 모두 주석이면?      = 
// 9만 주석이면?
// 11만 주석이면?
// 19줄이 주석이면?