package CNT4007_Project_Fall_2023;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class handshake {
    byte[] header;
    int size = 32;
    byte[] peerID;
    byte[] message = new byte[32];
    
    public handshake(int ID){
        header = new String("P2PFILESHARINGPROJ").getBytes();
        byte[] zeroes = new String("0000000000").getBytes();
        peerID = ByteBuffer.allocate(4).putInt(ID).array();
        System.out.println("PeerID: " + ByteBuffer.wrap(peerID).getInt());
        int currentByte = 0;
        for(int i = 0; i < 18; i++){
            message[i] = header[i];
            currentByte++;
        }
        int start_next = currentByte;
        for(int i = 0; i < 10; i++){
            message[i+start_next] = zeroes[i];
            currentByte++;
        }
        start_next = currentByte;
        for(int i = 0; i < 4; i++){
            message[i+start_next] = peerID[i];
            currentByte++;
        }
    }
    public static void main(String[] args){
        handshake s = new handshake(1001);
        String p = new String(s.message, StandardCharsets.UTF_8);
        System.out.println(p);
    
    }
}
