import java.io.*;
//Programmer: Kiet Quan
/* Program Description:
 * The program takes in bits from a string of bits to store in "testOutput.dat". When a byte is full, it gets written and reset to empty.
 * If the last byte is not full, concatenate 0s on the right to fill out the byte.     
 */
//Date: 02/12/2022

public class Program2 {
	public static void main(String[] args) throws Exception {
        BitOutputStream output = new BitOutputStream(new File("testOutput.dat"));	//create new BitOutputStream object
        output.writeBit("010000100100001001101"); 									//bits to be written
        output.close();
        System.out.println("Done");
    }
	
	public static class BitOutputStream implements AutoCloseable 
	{
		private java.io.FileOutputStream output;
		int bits; 																	//declare bit buffer and position
		int bitPosition; 
		
		public BitOutputStream(File file) throws IOException{			
			output = new FileOutputStream(file);									//create new FileOutputStream object
		}
		
		public void writeBit (String bitString) throws IOException{
			for (int i = 0; i< bitString.length(); i++) {							//invoke writeBit(char) for every character in bitString
				writeBit(bitString.charAt(i));
			}
		}
		
		public void writeBit(char bit) throws IOException{
			bits = bits << 1;														//shift bit buffer to left by one.
			
			if (bit == '1') {														//if bit equals one, bit buffer equals bitwise OR of bit buffer and one.
				bits = bits | 1;
			}
			if (++bitPosition == 8) {												//when a byte is full, write to output stream and reset bitPosition.
				output.write(bits);
				bitPosition = 0;
			}
		}
		public void close() throws IOException {
			if (bitPosition > 0) {													//if last byte is not full, add 0s at the end to reach 8 bits, write to ouput stream. 
				bits = bits << 8-bitPosition;
				output.write(bits);
				System.out.println(bits);
			}
			output.close();
		}
	}
}
