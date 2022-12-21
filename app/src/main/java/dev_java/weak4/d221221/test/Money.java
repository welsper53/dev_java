package dev_java.weak4.d221221.test;

public class Money {
    public static final String UNIT = "원";
    private int money;          // before : public int money;

    public Money() {}           // after : 디폴트생성자 Money() 작성
    public Money (int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public static String getUnit() {
        return UNIT;
    }

    public void print() {
        System.out.println(money + UNIT + "이 있습니다.");
    }
}


/*
 * 제시된 클래스 다이어그램을 분석하여 코드를 작성하였다. 
 * 다음 중 잘못된 부분과 이유를 [원인](25점)에 기술하고, 
 * 알맞게 고친 코드를 [조치내용](25점)에 완성하여 제출하시오. 
 * (단 클래스다이어그램은 수정하지 않음)
 */