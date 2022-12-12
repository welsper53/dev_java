package dev_java.weak3.makeUI.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JButtonUIEvent implements ActionListener{
    JButtonUI jUi = null;

    public JButtonUIEvent(JButtonUI jButtonUI) {
        this.jUi = jButtonUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == jUi.jbtn_south) {
            System.out.println("JButtonUIEvent 입니다.");
        }

    }
    
}
