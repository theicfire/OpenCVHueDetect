package tracker;

import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;

import java.awt.Dimension;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
public class VideoObjectDetect implements Runnable {
    //final int INTERVAL=1000;///you may use interval
    IplImage image;
    CanvasFrame canvas = new CanvasFrame("Web Cam");
    public VideoObjectDetect() {
        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void run() {
    	System.out.println("grab");
        FrameGrabber grabber = new OpenCVFrameGrabber(0); // 1 for next camera
        int i=0;
        try {
            grabber.start();
            IplImage img;
            while (true) {
                img = grabber.grab();
                if (img != null) {
                	System.out.println("writing image");
//                    cvFlip(img, img, 1);// l-r = 90_degrees_steps_anti_clockwise
//                    cvSaveImage((i++)+"-aa.jpg", img);
                    
                    // convert image
                    IplImage thresholdImage = ObjectPositionDetect.hsvThreshold(img);
                    cvSaveImage("hsvthreshold.jpg", thresholdImage);
                    Dimension position = ObjectPositionDetect.getCoordinates(thresholdImage);
                    System.out.println("Dimension of original Image : " + thresholdImage.width() + " , " + thresholdImage.height());
                    System.out.println("Position of red spot    : x : " + position.width + " , y : " + position.height);
                    canvas.showImage(thresholdImage);
                }
                 //Thread.sleep(INTERVAL);
            }
        } catch (Exception e) {
        }
    }



  public static void main(String[] args) {
        VideoObjectDetect gs = new VideoObjectDetect();
        Thread th = new Thread(gs);
        th.start();
    }
}
