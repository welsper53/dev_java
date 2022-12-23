package dev_java.weak4.d221221;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.Vector;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame implements ActionListener {
    // 선언부
    Vector<JButton> vBtn = new Vector<>(10);
    String num1 = "", num2 = "", num3 = "";
    String yeonSan;
    String pyoSi = "";
    double result;

    Font f = new Font("Paryrus", Font.BOLD, 40);

    JPanel jp_north = new JPanel();
    JTextField jtf_display = new JTextField(10);
    JTextField jtf_result = new JTextField(10);
    JPanel jp_center = new JPanel();

    // 산술연산자
    JButton jbtn_plus = new JButton("+");
    JButton jbtn_minus = new JButton("-");
    JButton jbtn_mult = new JButton("*");
    JButton jbtn_div = new JButton("/");
    JButton jbtn_clear = new JButton("C");
    JButton jbtn_equal = new JButton("=");

    // 숫자버튼 만들기
    public void makeNumButton() {
        for (int i = 0; i < 10; i++) {
            String num = Integer.toString(i);
            JButton jbtn = new JButton(num);
            jbtn.setFont(f);
            jbtn.addActionListener(this);
            vBtn.add(jbtn);
        }
    }

    // 숫자버튼 이벤트 처리
    public void evnetNumButton(int number) {
        if (num3 != "") {
            num3 = "";
            // pyoSi = "";
        }

        pyoSi += Integer.toString(number);
        jtf_display.setText(pyoSi);
        JButton jbtn = vBtn.get(number);
        System.out.println("숫자 : " + jbtn.getText());
        num1 += jbtn.getText();
        System.out.println("num1 = " + num1);
        System.out.println("num1 = " + num1 + ", num2 = " + num2 + ", yeonSan = " + yeonSan + ", result = " + result);
    }

    // 생성부
    public CalculatorApp() {
        makeNumButton();
        initDisplay();
    }

    // 이전 결과값 있는지 확인
    public void beforeResult() {
        if (num3 != "") {
            System.err.println("이전 결과 있음");
            pyoSi = num3;
            jtf_display.setText(String.valueOf(pyoSi));
            num1 = num3;
        } 
    }

    // 산술연산기
    double account(String oper) {
        double tot = 0;
        int n = Integer.parseInt(num1);

        if (num2.contains(".")) {
            double m = Double.parseDouble(num2);
            if (n != 0 && m != 0) {
                if ("+".equals(oper)) {
                    tot = m + n;
                } else if ("-".equals(oper)) {
                    tot = m - n;
                } else if ("*".equals(oper)) {
                    tot = m * n;
                } else if ("/".equals(oper)) {
                    tot = m / (double) n;
                }
            } else {
                JOptionPane.showMessageDialog(this, "입력한 숫자를 다시 하세요.", "WARN", JOptionPane.WARNING_MESSAGE);
                System.out.println("입력한 숫자를 다시 하세요.");
            }
        } else {
            int m = Integer.parseInt(num2);
            if (n != 0 && m != 0) {
                if ("+".equals(oper)) {
                    tot = m + n;
                } else if ("-".equals(oper)) {
                    tot = m - n;
                } else if ("*".equals(oper)) {
                    tot = m * n;
                } else if ("/".equals(oper)) {
                    tot = m / (double) n;
                }
            } else {
                JOptionPane.showMessageDialog(this, "입력한 숫자를 다시 하세요.", "WARN", JOptionPane.WARNING_MESSAGE);
                System.out.println("입력한 숫자를 다시 하세요.");
            }
        }

        return tot;
    }

    // 화면처리기
    public void initDisplay() {
        jtf_display.setEditable(false);
        jtf_result.setEditable(false);

        jtf_display.setHorizontalAlignment(JTextField.RIGHT);
        jtf_result.setHorizontalAlignment(JTextField.RIGHT);

        jp_north.setLayout(new GridLayout(2, 1));
        jp_north.add("North", jtf_display);
        jp_north.add("Center", jtf_result);

        jbtn_plus.setFont(f);
        jbtn_minus.setFont(f);
        jbtn_mult.setFont(f);
        jbtn_div.setFont(f);
        jbtn_equal.setFont(f);
        jbtn_clear.setFont(f);

        // ActionListener
        jbtn_plus.addActionListener(this);
        jbtn_minus.addActionListener(this);
        jbtn_mult.addActionListener(this);
        jbtn_div.addActionListener(this);
        jbtn_clear.addActionListener(this);
        jbtn_equal.addActionListener(this);

        jp_center.setBackground(Color.CYAN);
        jp_center.setLayout(new GridLayout(4, 4, 2, 2));
        jp_center.add(vBtn.get(7));
        jp_center.add(vBtn.get(8));
        jp_center.add(vBtn.get(9));
        jp_center.add(jbtn_div);
        jp_center.add(vBtn.get(4));
        jp_center.add(vBtn.get(5));
        jp_center.add(vBtn.get(6));
        jp_center.add(jbtn_mult);
        jp_center.add(vBtn.get(1));
        jp_center.add(vBtn.get(2));
        jp_center.add(vBtn.get(3));
        jp_center.add(jbtn_minus);
        jp_center.add(jbtn_clear);
        jp_center.add(vBtn.get(0));
        jp_center.add(jbtn_equal);
        jp_center.add(jbtn_plus);

        this.add("North", jp_north);
        this.add("Center", jp_center);

        this.setTitle("내가 만든 계산기");
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object obj = e.getSource();

        if (obj == jbtn_plus) {
            System.out.println("더하기 누름");
            // 이전 값이 있는지 확인
            beforeResult();

            pyoSi += " + ";
            jtf_display.setText(pyoSi);
            yeonSan = "+";
            num2 = num1;
            num1 = "";
        } else if (obj == jbtn_minus) {
            System.out.println("빼기 누름");
            // 이전 값이 있는지 확인
            beforeResult();
            
            pyoSi += " - ";
            jtf_display.setText(pyoSi);
            yeonSan = "-";
            num2 = num1;
            num1 = "";
        } else if (obj == jbtn_mult) {
            System.out.println("곱하기 누름");
            // 이전 값이 있는지 확인
            beforeResult();
            
            pyoSi += " * ";
            jtf_display.setText(pyoSi);
            yeonSan = "*";
            num2 = num1;
            num1 = "";
        } else if (obj == jbtn_div) {
            System.out.println("나누기 누름");
            // 이전 값이 있는지 확인
            beforeResult();
            
            pyoSi += " / ";
            jtf_display.setText(pyoSi);
            yeonSan = "/";
            num2 = num1;
            num1 = "";
        } else if (obj == jbtn_clear) {
            System.out.println("지우기 누름");
            num1 = "";
            num2 = "";
            yeonSan = "";
            pyoSi = "";
            result = 0;
            jtf_display.setText("");
            jtf_result.setText("");
            System.out
            .println("num1 = " + num1 + ", num2 = " + num2 + ", yeonSan = " + yeonSan + ", result = " + result);
        } else if (obj == jbtn_equal) {
            System.out.println("이퀄 누름");
            System.out.println("num1 = " + num1 + ", num2 = " + num2 + ", yeonSan = " + yeonSan);
            if (yeonSan != null) {
                result = account(yeonSan);
            } else {
                JOptionPane.showMessageDialog(this, "처음부터 다시 하세요.", "WARN", JOptionPane.WARNING_MESSAGE);
                System.out.println("처음부터 다시 하세요.");
            }
            jtf_result.setText(String.valueOf(result));
            System.out.println("결과는 " + result);
            // 초기화
            num1 = "";
            num2 = "";
            num3 = String.valueOf(result);
            result = 0;
        }
        
        // 숫자패드 클릭
        else if (obj == vBtn.get(0)) {
            evnetNumButton(0);
        } else if (obj == vBtn.get(1)) {
            evnetNumButton(1);
        } else if (obj == vBtn.get(2)) {
            evnetNumButton(2);
        } else if (obj == vBtn.get(3)) {
            evnetNumButton(3);
        } else if (obj == vBtn.get(4)) {
            evnetNumButton(4);
        } else if (obj == vBtn.get(5)) {
            evnetNumButton(5);
        } else if (obj == vBtn.get(6)) {
            evnetNumButton(6);
        } else if (obj == vBtn.get(7)) {
            evnetNumButton(7);
        } else if (obj == vBtn.get(8)) {
            evnetNumButton(8);
        } else if (obj == vBtn.get(9)) {
            evnetNumButton(9);
        }
    }
    
        public static void main(String[] args) {
            new CalculatorApp();
        }
}
