package dev_java.week5.d221230.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Exam2 {
    public void output() {
        System.out.println("output 메소드 시작");
        FileWriter fw = null;
        File file = new File("D:\\app\\test.txt");
        try {
            if (file.exists() == false) {
                file.createNewFile();
            }
            fw = new FileWriter("file", true);
            fw.write(97);
            fw.write(65);
            fw.close();

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Exam2 ex = new Exam2();
        ex.output();
    }
}

/*
IO를 이용하여 기존 파일에 데이터를 이어쓸 수 있도록 구현하려 하는데 제대로 실행이 되지 않는다.
잘못된 부분을 [원인](20점)에 기술하고, 제대로 수정하여 [조치내용](20점)에 기술하시오. (40점)
 */
/*
try문 내 fw객체를 초기화 시 생성자의 파라미터가 파일주소만 되어있어 이어쓰는게 아닌 덮어쓰기가 되었다.
또한 fw객체로 텍스트를 작성을 하고 마지막에 close() 메소드를 실행하지 않아
write()메소드 내 파라미터 내용이 저장되지 않고 해당 파일은 빈파일로 저장된다

------

fw 초기화 시 생성자 파리미터에 append변수의 값을 true로 해야 해당 파일을 이어쓰기 가능하다
또한 write메소드 마지막에 close메소드를 실행시켜서 작성 종료를 한다
 */