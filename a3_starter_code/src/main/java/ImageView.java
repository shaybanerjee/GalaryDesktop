import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;
public class ImageView implements java.io.Serializable {
    private int imageRating;
    private transient FileTime imageDate;
    private String imagePath;
    private String imageName;
    boolean isPainted;
    private transient BufferedImage imageData;

    public ImageView()
    { }

    public ImageView(File file)
    {
        imageRating = 0;
        try{
            imageDate = Files.readAttributes(file.toPath(), BasicFileAttributes.class).creationTime();
        }
        catch (Exception e)
        {

        }
        isPainted = false;
        imageName = file.getName();
        imagePath = file.getPath();
        try
        {
            imageData = ImageIO.read(file);
        }
        catch(Exception e)
        { }
    }

    public String getFilePath()
    {
        return imagePath;
    }

    public void setRating(int rate)
    {
        imageRating = rate;
    }
    public int getRating()
    {
        return imageRating;
    }

    public FileTime getImageDate()
    {
        return imageDate;
    }

    public BufferedImage getImageData()
    {
        return imageData;
    }

    public void setPainted(boolean painted)
    {
        isPainted = painted;
    }

    public String getImageName()
    {
        return imageName;
    }
}