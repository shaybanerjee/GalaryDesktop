import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class AppView extends JPanel implements Observer {

    List<ImageView> images;
    Model model;
    int currFilterVal = 0;
    boolean layoutSwitch;
    List<Observer> obs;

    public AppView(Model model)
    {
        obs = new ArrayList<>();

        this.setBackground(Color.WHITE);
        // init list of displayables
        images = new ArrayList<>();
        this.model = model;
        this.setLayout(new GridLayout(0, model.getColumns(this)));
        layoutSwitch = true;

    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //this.removeAll();
        if (model.getFilterVal() > 0)
        {
            //System.out.println("SHAYON HERE");
            for(int i = 0; i < images.size(); ++i)
            {
                //System.out.println(images.get(i).getRating());
                if(images.get(i).getRating() >= model.getFilterVal()) {
                    if (!images.get(i).isPainted) {
                        images.get(i).isPainted = true;
                        Thumbnail tb = new Thumbnail(model, images.get(i), this);
                        tb.addObserver(this);
                        this.add(tb);

                    }
                }
            }
        }
        else {
            for (int i = 0; i < images.size(); ++i)
            {
                if (!images.get(i).isPainted) {
                    images.get(i).isPainted = true;
                    Thumbnail tb = new Thumbnail(model, images.get(i), this);
                    tb.addObserver(this);
                    this.add(tb);
                }
            }
        }
        this.setLayout(new GridLayout(0, model.getColumns(this)));
        this.revalidate();
    }


    public void update(Object observable)
    {

        //System.out.println("ShayValVAl");
        if  (model.isThumb())
        {
            if (model.getFilterVal() > 0)
            {
                this.removeAll();
                for(int i = 0; i < images.size(); ++i)
                {
                    images.get(i).isPainted = false;
                }
                model.setThumbChanged(false);
            }
        }
        this.setLayout(new GridLayout(0, model.getColumns(this)));
        if (currFilterVal != model.getFilterVal())
        {
            this.removeAll();
            for(int i = 0; i < images.size(); ++i)
            {
                images.get(i).isPainted = false;
            }
            currFilterVal = model.getFilterVal();
        }

        if (layoutSwitch != model.isGridLayout())
        {
            this.removeAll();
            for(int i = 0; i < images.size(); ++i)
            {
                images.get(i).isPainted = false;
            }
            layoutSwitch = model.isGridLayout();
        }



        images = this.model.getListOfImages();
        this.revalidate();
        this.repaint();
    }
}
