import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class image {

  public static void main(String[] args) throws IOException {
    // Load the image file
    BufferedImage image = ImageIO.read(new File("GitHub.jpg"));
    FileWriter writer = new FileWriter("GitHub.txt");
    BufferedWriter buffer = new BufferedWriter(writer);

    // Get the image dimensions
    int width = image.getWidth();
    int height = image.getHeight();

    // Loop through each pixel in the image
    for (int y = 0; y < height; y+=20) {
      for (int x = 0; x < width; x+=20) {
        // Get the RGB value of the pixel
        int pixel = image.getRGB(x, y);

        // Convert the pixel value to grayscale
        int gray = (pixel >> 16) & 0xff;

        // Select an ASCII character based on the grayscale value
        char c;
        if (gray < 10) c = '#';
        else if (gray < 30) c = '&';
        else if (gray < 50) c = '$';
        else if (gray < 70) c = '*';
        else if (gray < 90) c = 'o';
        else if (gray < 110) c = '!';
        else if (gray < 130) c = ';';
        else if (gray < 150) c = ':';
        else if (gray < 170) c = '.';
        else c = ' ';

        // Print the ASCII character
        //System.out.print(c);
        // Write the ASCII character to the file
        buffer.write(c+" ");
      }
      // Start a new line after each row of pixels
      //System.out.println();
        buffer.newLine();
    }
    buffer.close();
  }

}
