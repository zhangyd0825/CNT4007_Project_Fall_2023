package CNT4007_Project_Fall_2023;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.io.*;


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
    private static readConfig commonConfig;

    public static void main(String[] args) {
        hostID = Integer.parseInt(args[0]);
        try{
            commonConfig = new readConfig("CNT4007_Project_Fall_2023/project_config_file_small/project_config_file_small/Common.cfg");
        }
        catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}