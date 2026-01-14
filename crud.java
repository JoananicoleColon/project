package colon2;

import java.awt.EventQueue;

public class crud {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                crud2 window = new crud2();
                window.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
