package CNT4007_Project_Fall_2023;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;
import java.util.Vector;
public class fileWriter
{
    Vector<byte[]> toFile;
    public fileWriter(Vector<byte[]> origin)
    {
        toFile = origin;
    }
    public void displayPieces()
    {
        for(int i = 0; i < toFile.size(); i++)
        {
            String temp = "";
            for(int j = 0; j < toFile.get(i).length; j++)
            {
                temp += toFile.get(i)[j];
            }
            System.out.print(temp);
        }
    }
    public void writeToIndivicualFiles(String dir) throws IOException
    {

        for(int i = 0; i < toFile.size(); i++)
        {
            String temp = "";
            for(int j = 0; j < toFile.get(i).length; j++)
            {
                temp += toFile.get(i)[j];
            }
            FileOutputStream out = new FileOutputStream(dir, true);
            out.write(temp.getBytes());
            out.close();
        }
    }
    public void writeToFile(String dir) throws IOException
    {
        FileOutputStream out = new FileOutputStream(dir, true);
        for(int i = 0; i < toFile.size(); i++)
        {
            for(int j = 0; j < toFile.get(i).length; j++)
            {
                out.write(toFile.get(i)[j]);
            }
        }
        out.close();
    }
}
