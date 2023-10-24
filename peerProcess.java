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
            System.out.println("file name: "+ commonConfig.getFileName());
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
    private int NumberOfPreferredNeighbors;
    private int UnchokingInterval;
    private int OptimisticUnchokingInterval;
    private String FileName;
    private int FileSize;
    private int PieceSize;

    public int getNumberOfPreferredNeighbors(){
        return NumberOfPreferredNeighbors;
    }

    public int getUnchokingInterval(){
        return UnchokingInterval;
    }

    public int getOptimisticUnchokingInterval(){
        return OptimisticUnchokingInterval;
    }

    public String getFileName(){
        return FileName;
    }

    public int getFileSize(){
        return FileSize;
    }

    public int getPieceSize(){
        return PieceSize;
    }

    public reader(String path){
        try {
            Scanner scan = new Scanner(new File(path));
            scan.useDelimiter(" |\n");
            while(scan.hasNext()){
                //config += scan.next() + "\n";
                scan.next();
                NumberOfPreferredNeighbors = Integer.parseInt(scan.next());
                scan.next();
                UnchokingInterval = scan.nextInt();
                scan.next();
                OptimisticUnchokingInterval = scan.nextInt();
                scan.next();
                FileName = scan.next();
                scan.next();
                FileSize = scan.nextInt();
                scan.next();
                PieceSize = scan.nextInt();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        //System.out.println(NumberOfPreferredNeighbors + " " + UnchokingInterval + " " + OptimisticUnchokingInterval + " "+ FileName +""+ FileSize + " "+ PieceSize + " "); //
    }
}
