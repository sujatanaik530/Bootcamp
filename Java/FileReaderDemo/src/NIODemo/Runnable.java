package NIODemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class Runnable {
    public static void main(String[] args) {
        //fnOne();
        fnTwo();
    }
    static void fnOne() {
        try {
            FileInputStream aFile = new FileInputStream("C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\file.txt");

            // or the below is also good
            //FileReader aFile = new FileReader("C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\file.txt");

            // or the below is also good
            //RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\file.txt")

            FileChannel inputChannel = aFile.getChannel();

            // since we are using fileinputstream, we use a bytebuffer

            // we create a 48 byte buffer
            //ByteBuffer buf = ByteBuffer.allocate(48);

            // or we find the size of the file, so that we can have a buffer of that size
            long fileSize = inputChannel.size();
            ByteBuffer buf = ByteBuffer.allocate((int) fileSize);

            // read data into our newly created buffer
            int bytesRead = inputChannel.read(buf);

            // buffer is ready to be read by program
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
        }
        catch (Exception e) {

        }
    }
    static void fnTwo() {
        // Here is an array of two filenames with full path. They already exist.
        String[] inputFiles = {"C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\file1.txt", "C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\file2.txt"};

        // Here is a file which will be created.
        String outFile = "C:\\Users\\naiks\\Documents\\Bootcamp\\testing\\file12.txt";

        try {
            FileOutputStream fOutput = new FileOutputStream(outFile);
            WritableByteChannel destinationChannel = fOutput.getChannel();

            FileInputStream fInput;

            for (int i = 0; i < inputFiles.length; i++) {
                // Open channel for input file
                fInput = new FileInputStream(inputFiles[i]);
                FileChannel sourceChannel = fInput.getChannel();

                // Transfer data from sourceChannel to destinationChannel
                sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
                sourceChannel.close();
            }

            destinationChannel.close();
        }
        catch (Exception e) {

        }
    }
}
