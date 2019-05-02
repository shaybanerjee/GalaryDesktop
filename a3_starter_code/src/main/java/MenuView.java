import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MenuView extends JMenuBar implements Observer {

    Model model;
    JButton starButton1;
    JButton starButton2;
    JButton starButton3;
    JButton starButton4;
    JButton starButton5;

    int currRating;
    MenuView(Model model, JFrame frame)
    {
        this.model = model;
        currRating = 0;
        //JMenuBar menuBar = new JMenuBar();
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(Color.BLACK));

        this.setLayout(new BorderLayout());
        JPanel pane = new JPanel();
        pane.setBackground(Color.WHITE);
        JPanel pane2 = new JPanel();
        pane2.setBackground(Color.WHITE);
        JPanel pane3 = new JPanel(new GridLayout(1,1));
        pane3.setBackground(Color.WHITE);

        //this.setLayout(new GridLayout(1, 4));
        //GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel("Fotag!");
        title.setLayout(new FlowLayout(FlowLayout.RIGHT));
        title.setFont(new Font("Serif", Font.BOLD, 40));
        JLabel gridTitle = new JLabel("Grid Layout:");
        JLabel listTitle = new JLabel("List Layout:");
        JLabel filerTitle = new JLabel("Filter by:");
        filerTitle.setFont(new Font("Serif", Font.PLAIN, 20));
        JButton loadFile = new JButton();
        Box VB = Box.createHorizontalBox();


        starButton1 = new JButton();
        starButton2 = new JButton();
        starButton3 = new JButton();
        starButton4 = new JButton();
        starButton5 = new JButton();
        JButton gridButton = new JButton();
        JButton listButton = new JButton();
        JButton sweepButton = new JButton();

        JPanel pn2 = new JPanel();
        pn2.setPreferredSize(new Dimension(15, 10));
        pn2.setBackground(Color.WHITE);

        VB.add(loadFile);
        VB.add(pn2);
        VB.add(filerTitle);
        VB.add(starButton1);
        VB.add(starButton2);
        VB.add(starButton3);
        VB.add(starButton4);
        VB.add(starButton5);
        VB.add(sweepButton);

        JButton none = new JButton();
        none.setText("NONE");



        loadFile.setBackground(Color.WHITE);
        loadFile.setPreferredSize(new Dimension(30, 30));
        loadFile.setBorder(BorderFactory.createEmptyBorder());
        starButton1.setBackground(Color.WHITE);
        starButton1.setPreferredSize(new Dimension(30, 30));
        starButton1.setBorder(BorderFactory.createEmptyBorder());
        starButton2.setBackground(Color.WHITE);
        starButton2.setPreferredSize(new Dimension(30, 30));
        starButton2.setBorder(BorderFactory.createEmptyBorder());
        starButton3.setBackground(Color.WHITE);
        starButton3.setPreferredSize(new Dimension(30, 30));
        starButton3.setBorder(BorderFactory.createEmptyBorder());
        starButton4.setBackground(Color.WHITE);
        starButton4.setPreferredSize(new Dimension(30, 30));
        starButton4.setBorder(BorderFactory.createEmptyBorder());
        starButton5.setBackground(Color.WHITE);
        starButton5.setPreferredSize(new Dimension(30, 30));
        starButton5.setBorder(BorderFactory.createEmptyBorder());
        gridButton.setPreferredSize(new Dimension(50, 50));
        gridButton.setBorder(BorderFactory.createEmptyBorder());
        listButton.setPreferredSize(new Dimension(50, 50));
        listButton.setBorder(BorderFactory.createEmptyBorder());
        sweepButton.setBackground(Color.WHITE);
        sweepButton.setPreferredSize(new Dimension(35, 35));
        sweepButton.setBorder(BorderFactory.createEmptyBorder());

        gridButton.setEnabled(false);
        listButton.setEnabled(true);


        try
        {
            Image img = ImageIO.read(new FileInputStream("images/loadfilers.png"));
            loadFile.setIcon(new ImageIcon(img));
            img = ImageIO.read(new FileInputStream("images/starblank.png"));
            starButton1.setIcon(new ImageIcon(img));
            img = ImageIO.read(new FileInputStream("images/starblank.png"));
            starButton2.setIcon(new ImageIcon(img));
            img = ImageIO.read(new FileInputStream("images/starblank.png"));
            starButton3.setIcon(new ImageIcon(img));
            img = ImageIO.read(new FileInputStream("images/starblank.png"));
            starButton4.setIcon(new ImageIcon(img));
            img = ImageIO.read(new FileInputStream("images/starblank.png"));
            starButton5.setIcon(new ImageIcon(img));
            img = ImageIO.read(new FileInputStream("images/grid.png"));
            gridButton.setIcon(new ImageIcon(img));
            img = ImageIO.read(new FileInputStream("images/list.png"));
            listButton.setIcon(new ImageIcon(img));
            img = ImageIO.read(new FileInputStream("images/sweep.png"));
            sweepButton.setIcon(new ImageIcon(img));

        }
        catch (Exception e)
        {
            System.out.println("ERROR: MenuView Image loading");
        }

        loadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        starButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton5.setIcon(new ImageIcon(img));
                    model.setFilterVal(1);
                }
                catch (Exception err)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
        });

        starButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton5.setIcon(new ImageIcon(img));
                    model.setFilterVal(2);
                }
                catch (Exception err)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
        });

        starButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton5.setIcon(new ImageIcon(img));
                    model.setFilterVal(3);
                }
                catch (Exception err)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
        });

        starButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton5.setIcon(new ImageIcon(img));
                    model.setFilterVal(4);
                }
                catch (Exception err)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
        });

        starButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton5.setIcon(new ImageIcon(img));
                    model.setFilterVal(5);
                }
                catch (Exception err)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
        });

        sweepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton5.setIcon(new ImageIcon(img));
                    model.setFilterVal(0);
                }
                catch (Exception err)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
        });

        loadFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setMultiSelectionEnabled(true);
                int result = jfc.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    try
                    {
                        File[] sFiles = jfc.getSelectedFiles();
                        for(int i = 0; i < sFiles.length; ++i)
                        {
                            ImageView imgview = new ImageView(sFiles[i]);
                            model.addImage(imgview);
                        }
                    }
                    catch (Exception err)
                    {
                        System.out.println("ERROR: could file not found being loaded.");
                    }
                }

            }
        });

        gridButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridButton.setEnabled(false);
                listButton.setEnabled(true);
                model.setGrid(true);

            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridButton.setEnabled(true);
                listButton.setEnabled(false);
                model.setGrid(false);
            }
        });


        JPanel pn = new JPanel();
        pn.setPreferredSize(new Dimension(35, 10));
        pn.setBackground(Color.WHITE);

        pane.add(gridButton);
        pane.add(listButton);
        pane.add(pn);

        pane2.add(VB);
        pane3.add(title);

        this.add(pane, BorderLayout.WEST);
        this.add(pane3, BorderLayout.CENTER);
        this.add(pane2, BorderLayout.EAST);
    }
    public void update(Object observable) {
        if (currRating != model.getFilterVal())
        {
            if (model.getFilterVal() == 0)
            {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton5.setIcon(new ImageIcon(img));
                }
                catch (Exception e)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
            else if (model.getFilterVal() == 1)
            {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton5.setIcon(new ImageIcon(img));
                }
                catch (Exception e)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
            else if (model.getFilterVal() == 2)
            {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton5.setIcon(new ImageIcon(img));
                }
                catch (Exception e)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
            else if (model.getFilterVal() == 3)
            {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton5.setIcon(new ImageIcon(img));
                }
                catch (Exception e)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
            else if(model.getFilterVal() == 4)
            {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starblank.png"));
                    starButton5.setIcon(new ImageIcon(img));
                }
                catch (Exception e)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
            else if (model.getFilterVal() == 5)
            {
                try
                {
                    Image img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton1.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton2.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton3.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton4.setIcon(new ImageIcon(img));
                    img = ImageIO.read(new FileInputStream("images/starcolor.png"));
                    starButton5.setIcon(new ImageIcon(img));
                }
                catch (Exception e)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }

        }
    }
}

