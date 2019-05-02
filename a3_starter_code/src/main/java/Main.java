import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        Model model = new Model();
        MenuView mv = new MenuView(model, jf);
        AppView iv = new AppView(model);
        JPanel pane = new JPanel();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.ipady = 0;
        pane.add(mv, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.CENTER;
        c.gridwidth = 3;
        c.gridheight = 3;
        pane.add(iv, c);



        model.addObserver(mv);
        model.addObserver(iv);
        model.loadImages();

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                // save current state
                model.saveImages();
            }
        });


        jf.add(pane);
        jf.setPreferredSize(new Dimension(800, 600));
        jf.setMinimumSize(new Dimension(362, 504));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}
