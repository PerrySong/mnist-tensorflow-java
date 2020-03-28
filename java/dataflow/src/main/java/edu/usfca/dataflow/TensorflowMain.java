package edu.usfca.dataflow;

import org.tensorflow.*;
import java.util.Arrays;
import java.nio.file.*;
import java.nio.*;
import java.util.*;

public class TensorflowMain
{
  public static void main( String[] args )
  {
    System.out.println( "Hello World! I'm using tensorflow version " + TensorFlow.version() );

    try {
      MnistReader mrTest = new MnistReader("./mnist/t10k-labels-idx1-ubyte", "./mnist/t10k-images-idx3-ubyte");

      SavedModelBundle smb = SavedModelBundle.load("model copy", "serve");
      Session s = smb.session();

      int correct_prediction = 0;
      for(int i=0; i<mrTest.size(); i++) {

        FloatBuffer fb = FloatBuffer.allocate(784); //28 * 28 pixel for the image
        byte[] imgData = mrTest.readNextImage(); // read the image
        for(byte b : imgData) {
          fb.put((float)(b & 0xFF)/255.0f); // convert to float buffer (0xFF: signed)
        }
        fb.rewind(); //

        float[] keep_prob_arr = new float[1024];
        Arrays.fill(keep_prob_arr, 1f);

        Tensor inputTensor = Tensor.create(new long[] {784}, fb);
        Tensor keep_prob = Tensor.create(new long[] {1, 1024}, FloatBuffer.wrap(keep_prob_arr));

        Tensor result = s.runner()
            .feed("input_tensor", inputTensor)
            .feed("dropout/keep_prob", keep_prob)
            .fetch("output_tensor")
            .run().get(0);

        float[][] m = new float[1][10];

        float[][] matrix = (float[][])result.copyTo(m);
        float maxVal = 0; // Probability of
        int inc = 0;
        int predict = -1;
        for(float val : matrix[0]) {
//          System.out.println("prob = " + val);
          if(val > maxVal) {
            predict = inc;
            maxVal = val;
          }
          inc++;
        }
        int actual = mrTest.readNextLabel();
        System.out.println("predicted: " + predict + "actual: " + actual);
        if(predict == actual) {
          correct_prediction++;
        }
      }
      System.out.println("We have "+correct_prediction+"/10000 which is "+((float)correct_prediction/100f)+"%");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
