import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;
import java.util.Vector;

class fileReader
{
    Vector<byte[]> pieceVector;
    String fileDir;
    int pieceSize;
    int fileSizeInByte = 0;
    int pieceAmount = 0;
    public fileReader(String dir, int pieceSize)
    {
        this.fileDir = dir;
        this.pieceSize = pieceSize;
    }
    public void startReadFile()
    {
        File currentTask = new File(fileDir);
        if(currentTask.exists() && currentTask.canRead())
        {
            fileSizeInByte = (int)currentTask.length(); //since we are not working on massive file, I have just cast this in Int.
            pieceAmount =  fileSizeInByte / pieceSize;
            if(fileSizeInByte % pieceSize != 0)
            {
                pieceAmount += 1;
            }
        }
        else
        {
            System.out.println("The file does not exist.");
        }
    }
    public void pieceCreator() throws IOException
    {
        if(fileSizeInByte == 0 && pieceAmount == 0)
        {
            System.out.println("Run startReadFile first!");
        }
        else
        {
            File currentTask = new File(fileDir);
            int readIndex = 0;
            FileInputStream fins = new FileInputStream(currentTask);
            for(int i = 0; i < pieceAmount -1; i++)
            {
                byte[] temp = {};
                fins.read(temp, i * pieceSize, pieceSize);
            }
        }
    }
}
