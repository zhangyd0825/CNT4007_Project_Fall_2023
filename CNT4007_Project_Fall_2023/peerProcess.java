package CNT4007_Project_Fall_2023;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.util.Scanner;

public class peerProcess {
    private static final char CHOKE = '0';
    private static final char UNCHOKE = '1';
    private static final char INTERESTED = '2';
    private static final char NOT_INTERESTED = '3';
    private static final char HAVE = '4';
    private static final char BITFIELD = '5';
    private static final char REQUEST = '6';
    private static final char PIECE = '7';
    private static int hostID;
    private static reader commonConfig= new reader("project_config_file_small/project_config_file_small/Common.cfg");


    public static void main(String[] args) {
        //hostID = Integer.parseInt(args[0]);
        try{
            //commonConfig = new readConfig("CNT4007_Project_Fall_2023/project_config_file_small/project_config_file_small/Common.cfg");
            //System.out.println("file name: "+ commonConfig.getFileName());
            commonConfig.display();
            System.out.println("this works");
        }
        catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
class reader{
    //private String config = "";
    private String NumberOfPreferredNeighbors;
    private String UnchokingInterval;
    private String OptimisticUnchokingInterval;
    private String FileName;
    private String FileSize;
    private String PieceSize;

    public void display()
    {
        System.out.println("Number of Preferred Neighbors: " + NumberOfPreferredNeighbors + "\n");
        System.out.println("Unchoking Interval: " + UnchokingInterval + "\n");
        System.out.println("Optimistic Unchoking Interval: " + OptimisticUnchokingInterval + "\n");
        System.out.println("File Name: " + FileName + "\n");
        System.out.println("File Size: " + FileSize + "\n");
        System.out.println("Piece Size: " + PieceSize + "\n");
    }
    public String getNumberOfPreferredNeighborsRaw(){
        return NumberOfPreferredNeighbors;
    }

    public String getUnchokingIntervalRaw(){
        return UnchokingInterval;
    }

    public String getOptimisticUnchokingIntervalRaw(){
        return OptimisticUnchokingInterval;
    }

    public String getFileName(){
        return FileName;
    }

    public String getFileSizeRaw(){
        return FileSize;
    }

    public String getPieceSizeRaw(){
        return PieceSize;
    }

    public int getgetNumberOfPreferredNeighbors()
    {
        return Integer.valueOf(NumberOfPreferredNeighbors);
    }
    public int getUnchokingInterval()
    {
        return Integer.valueOf(UnchokingInterval);
    }
    public int getOptimisticUnchokingInterval()
    {
        return Integer.valueOf(OptimisticUnchokingInterval);
    }
    public int getOptimisticUnchokingInterval()
    {
        return Integer.valueOf(OptimisticUnchokingInterval);
    }

    public reader(String path){
        try {
            Scanner scan = new Scanner(new File(path));
            scan.useDelimiter(" |\n");
            while(scan.hasNext()){
                //config += scan.next() + "\n";
                scan.next();
                NumberOfPreferredNeighbors = scan.next();
                scan.next();
                UnchokingInterval = scan.next();
                scan.next();
                OptimisticUnchokingInterval = scan.next();
                scan.next();
                FileName = scan.next();
                scan.next();
                FileSize = scan.next();
                scan.next();
                PieceSize = scan.next();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        //System.out.println(NumberOfPreferredNeighbors + " " + UnchokingInterval + " " + OptimisticUnchokingInterval + " "+ FileName +""+ FileSize + " "+ PieceSize + " "); //
    }
}
