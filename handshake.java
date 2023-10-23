package CNT4007_Project_Fall_2023;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class handshake {
    byte[] header;
    int size = 32;
    int peerID= 69;
    byte[] hs = new byte[32];
    
    public handshake(int ID){
        header = new String("P2PFILESHARINGPROJ").getBytes();
        byte[] zeroes = new String("0000000000").getBytes();
        byte[] id = ByteBuffer.allocate(4).putInt(ID).array();
        int currentByte = 0;
        for(int i = 0; i < 18; i++){
            hs[i] = header[i];
            currentByte++;
        }
        int start_next = currentByte;
        for(int i = 0; i < 10; i++){
            hs[i+start_next] = zeroes[i];
            currentByte++;
        }
        start_next = currentByte;
        for(int i = 0; i < 4; i++){
            hs[i+start_next] = id[i];
            currentByte++;
        }
    }
    public static void main(String[] args){
        handshake s = new handshake(69);
        String p = new String(s.hs, StandardCharsets.UTF_8);
        System.out.println(p); //
    
    }
}
