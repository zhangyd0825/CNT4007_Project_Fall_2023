package CNT4007_Project_Fall_2023;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
    private static reader commonConfig= new reader("CNT4007_Project_Fall_2023/project_config_file_small/project_config_file_small/Common.cfg");


    public static void main(String[] args) {
        //hostID = Integer.parseInt(args[0]);
        try{
            //commonConfig = new readConfig("CNT4007_Project_Fall_2023/project_config_file_small/project_config_file_small/Common.cfg");
            //System.out.println("file name: "+ commonConfig.getFileName());
            commonConfig.display();
            System.out.println("this works");
            RunServer serverThread = new RunServer();
            serverThread.start();
            TimeUnit.SECONDS.sleep(2);
            Client client = new Client();
            client.run();

        }
        catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
class reader {
    //private String config = "";
    private String NumberOfPreferredNeighbors;
    private String UnchokingInterval;
    private String OptimisticUnchokingInterval;
    private String FileName;
    private String FileSize;
    private String PieceSize;

    public void display() {
        System.out.println("Number of Preferred Neighbors: " + NumberOfPreferredNeighbors + "\n");
        System.out.println("Unchoking Interval: " + UnchokingInterval + "\n");
        System.out.println("Optimistic Unchoking Interval: " + OptimisticUnchokingInterval + "\n");
        System.out.println("File Name: " + FileName + "\n");
        System.out.println("File Size: " + FileSize + "\n");
        System.out.println("Piece Size: " + PieceSize + "\n");
    }

    public String getNumberOfPreferredNeighborsRaw() {
        return NumberOfPreferredNeighbors;
    }

    public String getUnchokingIntervalRaw() {
        return UnchokingInterval;
    }

    public String getOptimisticUnchokingIntervalRaw() {
        return OptimisticUnchokingInterval;
    }

    public String getFileName() {
        return FileName;
    }

    public String getFileSizeRaw() {
        return FileSize;
    }

    public String getPieceSizeRaw() {
        return PieceSize;
    }

    public int getgetNumberOfPreferredNeighbors() {
        return Integer.valueOf(NumberOfPreferredNeighbors);
    }

    public int getUnchokingInterval() {
        return Integer.valueOf(UnchokingInterval);
    }

    public int getOptimisticUnchokingInterval() {
        return Integer.valueOf(OptimisticUnchokingInterval);
    }

    public int getFilesize() {
        return Integer.valueOf(FileSize);
    }

    public reader(String path) {
        try {
            Scanner scan = new Scanner(new File(path));
            scan.useDelimiter(" |\n");
            while (scan.hasNext()) {
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
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        //System.out.println(NumberOfPreferredNeighbors + " " + UnchokingInterval + " " + OptimisticUnchokingInterval + " "+ FileName +""+ FileSize + " "+ PieceSize + " "); //
    }


}
class Peer extends Thread {
    private int ID;
    private String host;
    private int port;
    private boolean haveCompleteFile;
    private char[] bitfield;
    private int pieceNum;

    public int getID() {
        return ID;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public boolean getHaveCompleteFile() {
        return haveCompleteFile;
    }

    public char[] getBitfield() {
        return bitfield;
    }

    public boolean setHaveCompleteFile(boolean bool) {
        this.haveCompleteFile = bool;
        return haveCompleteFile;
    }

    public char[] changeBit(int i, char c) {
        this.bitfield[i] = c;
        return bitfield;
    }
}
class RunServer extends Thread {
    public void run() {
        try {
            ServerSocket listener = new ServerSocket(3636);
            int clientNum = 1;
            System.out.println("The server is running.");
            try {
                while (true) {
                    new Server.Handler(listener.accept(), clientNum).start();
                    System.out.println("Client " + clientNum + " is connected!");
                    clientNum++;
                }
            } finally {
                listener.close();
            }
        } catch (Exception e) {
            System.out.println("Server error");
        }
    }
}