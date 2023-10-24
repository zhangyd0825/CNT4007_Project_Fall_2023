package CNT4007_Project_Fall_2023;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class handshake {
    private byte[] header;
    private static int size = 32;
    private byte[] peerID;
    private byte[] message = new byte[size];

    public byte[] getPeerID() {
        return peerID;
    }

    public byte[] getHeader() {
        return header;
    }

    public byte[] getMessage(){
        return message;
    }

    public handshake(int ID){
        header = new String("P2PFILESHARINGPROJ").getBytes();
        byte[] zeroes = new String("0000000000").getBytes();
        peerID = ByteBuffer.allocate(4).putInt(ID).array();
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
        System.out.println("PeerID: " + ByteBuffer.wrap(peerID).getInt());
    }
    public static void main(String[] args){
        handshake s = new handshake(1001);
        String p = new String(s.message, StandardCharsets.UTF_8);
        System.out.println(p);
        String bytes = "";
        for (byte b : s.message){
            System.out.print(b + " ");
        }
        System.out.println(bytes);
    }
}
