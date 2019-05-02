import org.omg.CORBA.SystemException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Thumbnail extends JPanel implements Observer {
    transient BufferedImage image;
    String imageName;
    String imagePath;
    Dimension scalingDimension;
    JButton imageButton;
    Dimension scaledDimension;
    public int ratingVal;
    ArrayList<Observer> obs;
    public Thumbnail()
    {}

    public Thumbnail(Model model, ImageView imgVal, JPanel pane)
    {
        obs = new ArrayList<Observer>();
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(Color.BLACK));
        if (model.isGridLayout()) {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }
        else
        {
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        }
        image = imgVal.getImageData();
        imageName = imgVal.getImageName();
        imagePath = imgVal.getFilePath();
        scalingDimension = new Dimension(230, 230);
        scaledDimension = resizeComponent(scalingDimension);
        ImageIcon imgIcon = resizeIcon(image, scaledDimension);
        imageButton = new JButton();
        imageButton.setMaximumSize(scaledDimension);
        imageButton.setMinimumSize(scaledDimension);
        imageButton.setPreferredSize(scaledDimension);
        imageButton.setIcon(imgIcon);
        ratingVal = 0;


        JLabel fName = new JLabel(imageName);
        Box hb = Box.createVerticalBox();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        JLabel dateLabel = new JLabel(df.format(imgVal.getImageDate().toMillis()));
        fName.setFont(new Font("Serif", Font.PLAIN, 15));
        dateLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        hb.add(fName);
        hb.add(dateLabel);

        JButton starButton1 = new JButton();
        JButton starButton2 = new JButton();
        JButton starButton3 = new JButton();
        JButton starButton4 = new JButton();
        JButton starButton5 = new JButton();
        JButton clearButton = new JButton("Clear");

        Box VB = Box.createHorizontalBox();
        VB.add(starButton1);
        VB.add(starButton2);
        VB.add(starButton3);
        VB.add(starButton4);
        VB.add(starButton5);
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

        hb.add(VB);

        if (imgVal.getRating() == 0)
        {
            try
            {
                Image imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton1.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton2.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton3.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton4.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton5.setIcon(new ImageIcon(imgRes));

            }
            catch (Exception e)
            {

            }

        }
        else if (imgVal.getRating() == 1)
        {
            try
            {
                Image imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton1.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton2.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton3.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton4.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton5.setIcon(new ImageIcon(imgRes));

            }
            catch (Exception e)
            {

            }
        }
        else if (imgVal.getRating() == 2)
        {
            try
            {
                Image imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton1.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton2.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton3.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton4.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton5.setIcon(new ImageIcon(imgRes));

            }
            catch (Exception e)
            {

            }
        }
        else if (imgVal.getRating() == 3)
        {
            try
            {
                Image imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton1.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton2.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton3.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton4.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton5.setIcon(new ImageIcon(imgRes));

            }
            catch (Exception e)
            {

            }
        }
        else if (imgVal.getRating() == 4)
        {
            try
            {
                Image imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton1.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton2.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton3.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton4.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starblank.png"));
                starButton5.setIcon(new ImageIcon(imgRes));

            }
            catch (Exception e)
            {

            }
        }
        else if (imgVal.getRating() == 5)
        {
            try
            {
                Image imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton1.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton2.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton3.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton4.setIcon(new ImageIcon(imgRes));
                imgRes = ImageIO.read(new FileInputStream("images/starcolor.png"));
                starButton5.setIcon(new ImageIcon(imgRes));

            }
            catch (Exception e)
            {

            }
        }



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
                    imgVal.setRating(1);
                    model.setThumbChanged(true);
                    notifyObservers();
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
                    imgVal.setRating(2);
                    model.setThumbChanged(true);
                    notifyObservers();
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
                    imgVal.setRating(3);
                    model.setThumbChanged(true);
                    notifyObservers();
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
                    imgVal.setRating(4);
                    model.setThumbChanged(true);
                    notifyObservers();
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
                    imgVal.setRating(5);
                    model.setThumbChanged(true);
                    notifyObservers();

                }
                catch (Exception err)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
        });


        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension d = resizeComponent(new Dimension(800, 600));
                ImageIcon imgIcon2 = resizeIcon(image, d);
                System.out.println(d.width);
                System.out.println(d.height);
                JOptionPane.showMessageDialog(
                        pane,
                        "",
                        "", JOptionPane.INFORMATION_MESSAGE,
                        imgIcon2);

            }
        });

        clearButton.addActionListener(new ActionListener() {
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
                    imgVal.setRating(0);
                    model.setThumbChanged(true);
                    notifyObservers();

                }
                catch (Exception err)
                {
                    System.out.println("ERROR: MenuView Image loading");
                }
            }
        });

        this.add(Box.createVerticalGlue());
        this.add(Box.createHorizontalGlue());
        imageButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        fName.setAlignmentX(Component.CENTER_ALIGNMENT);
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        VB.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(imageButton);


        if (model.isGridLayout()) {
            this.add(fName);
            this.add(dateLabel);
            this.add(VB);
            this.add(clearButton);
        }
        else
        {
            Box verticalBox = Box.createVerticalBox();
            verticalBox.add(fName);
            verticalBox.add(dateLabel);
            verticalBox.add(VB);
            verticalBox.add(clearButton);
            this.add(verticalBox);
        }


        this.add(Box.createHorizontalGlue());
        this.add(Box.createVerticalGlue());

        this.setVisible(true);
    }

    public ImageIcon resizeIcon(BufferedImage img, Dimension d)
    {
        Image img2 = img.getScaledInstance(d.width, d.height, Image.SCALE_SMOOTH);
        return new ImageIcon(img2);
    }

    public void addObserver(Observer observer) {
        this.obs.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.obs.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer: this.obs) {
            //System.out.println("ShayShayo");
            observer.update(this);
        }
    }

    public Dimension resizeComponent(Dimension d)
    {
        double scale = Math.min(d.getHeight()/image.getHeight(), d.getWidth()/image.getWidth());

        return new Dimension( (int)(scale * image.getWidth()), (int)(scale * image.getHeight()));
    }

    public void update(Object observable) {
        // XXX Fill this in with the logic for updating the view when the model
        // changes.
        //System.out.println("Model changed!");
    }
}
