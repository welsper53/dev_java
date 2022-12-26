package dev_java.week4.d221220;

class CarVO {
    private int speed;
    private String carColor;
    private int wheelNum;

    CarVO() {

    }

    CarVO(int speed) {
        this.speed = speed;
    }

    CarVO(int speed, String carColor) {
        this.speed = speed;
        this.carColor = carColor;
    }

    CarVO(int speed, String carColor, int wheelNum) {
        this.speed = speed;
        this.carColor = carColor;
        this.wheelNum = wheelNum;
    }

    @Override
    public String toString() {
        return "내 자동차는 " + carColor + "이고, 바퀴수는 "
                + wheelNum + "이고, 현재속도는 "
                + speed + "이다";
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getCarColor() {
        return this.carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getWheelNum() {
        return this.wheelNum;
    }

    public void setWheelNum(int wheelNum) {
        this.wheelNum = wheelNum;
    }

}

public class CarVOMain {
    public static void main(String[] args) {
        CarVO cVo1 = new CarVO();
        CarVO cVo2 = new CarVO(50, "검정색");
        CarVO cVo3 = new CarVO(120, "노랑색", 4);
        CarVOMain carVOMain = new CarVOMain();
        System.out.println(carVOMain);
        System.out.println(cVo1);
        System.out.println(cVo2);
        System.out.println(cVo3);
    }
}
