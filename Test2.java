import java.io.*;

public class Test2 {
    public static void main(String[] args) throws Exception {
        BitOutputStream output = new BitOutputStream(new File("testOutput2.dat"));
        output.writeBit("010000100100001001101");
        output.close();
        System.out.println("Done");
    }

    public static class BitOutputStream {
        private FileOutputStream output;
        private DataOutputStream dos;
        //  programs statements

        // Constructor
        public BitOutputStream(File file) throws IOException {
            output = new FileOutputStream(file);
            dos = new DataOutputStream(output);
        	// one statement will do the job
        }

        public void writeBit(String bitString) throws IOException {
          for (int i = 0; i < (bitString.length() %8); i++) {
        	  bitString = bitString.concat("0");
          }
          dos.writeBytes(bitString);
        }

        

        /** Write the last byte and close the stream.
         * If the last byte is not full, right-shift with zeros */
        public void close( ) throws IOException {
            // Program statements for this method
            output.close();  // This makes use of the close() method for a FileOutputStream object
        }
    }
}