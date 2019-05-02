import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Model implements java.io.Serializable {
    /** The observers that are watching this model for changes. */
    private List<Observer> observers;
    private List<ImageView> images;
    // if isGrid is false we are in list mode
    // if isGrid is true we are in grid mode
    private boolean isGrid;
    private int filterVal;
    private int columns;
    private boolean isThumbChanged;

    /**
     * Create a new model.
     */
    public Model() {
        this.observers = new ArrayList();
        this.images = new ArrayList<>();
        isGrid = true;
        filterVal = 0;
        isThumbChanged = false;
    }

    public void setThumbChanged(boolean isT)
    {
        isThumbChanged = isT;
    }

    public boolean isThumb()
    {
        return isThumbChanged;
    }


    public void loadImages()
    {
        try {
            FileInputStream fis = new FileInputStream("SaveState.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Model result = (Model) ois.readObject();

            setFilterVal(result.getFilterVal());

            images = new ArrayList<>();

            for (int i = 0; i < result.getListOfImages().size(); ++i)
            {
                ImageView imgView = new ImageView(new File(result.getListOfImages().get(i).getFilePath()));
                imgView.setRating(result.getListOfImages().get(i).getRating());
                addImage(imgView);
            }
            ois.close();
            fis.close();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void saveImages()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("SaveState.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //.out.println(images.size());
            oos.writeObject(this);

            oos.close();
            fos.close();
        }
        catch (Exception e)
        {

        }
    }


    public List<ImageView> getListOfImages()
    {
        return images;
    }

    public void addImage(ImageView imgview)
    {
        this.images.add(imgview);
        this.notifyObservers();
    }

    public void setFilterVal(int val)
    {
        filterVal = val;
        this.notifyObservers();
    }

    public int getFilterVal()
    {
        return filterVal;
    }

    public void setGrid(Boolean val)
    {
        isGrid = val;
        this.notifyObservers();
    }
    public void setImageRating(ImageView imgview, int rate)
    {
        imgview.setRating(rate);
    }

    public boolean isGridLayout()
    {
        return isGrid;
    }

    /**
     * Add an observer to be notified when this model changes.
     */
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * Remove an observer from this model.
     */
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    /**
     * Notify all observers that the model has changed.
     */
    public void notifyObservers() {
        for (Observer observer: this.observers) {
            observer.update(this);
        }
    }

    public int getColumns(JPanel pane)
    {
        if (!isGrid)
        {
            return 1;
        }
        else
        {
            int filterCount = images.size();
            if (filterVal > 0)
            {
                filterCount = 0;
                for(int i = 0; i < images.size(); ++i) {
                    if (images.get(i).getRating() >= filterVal)
                    {
                        ++filterCount;
                    }
                }
            }

            int minVal = Math.min(pane.getWidth() / 230, filterCount);
            int maxVal = Math.max(minVal, 1);
            return maxVal;
        }

    }

}
