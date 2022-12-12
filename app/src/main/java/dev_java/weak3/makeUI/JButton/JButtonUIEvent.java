package dev_java.weak3.makeUI.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JButtonUIEvent implements ActionListener{
    JButtonUI jbtnUI = null;

    public JButtonUIEvent(JButtonUI jButtonUI) {
        this.jbtnUI = jButtonUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object obj = e.getSource();

        if (obj == jbtnUI.jbtn_south) {
            System.out.println("JButtonUIEvent 입니다.");
        }

    }
    
}
