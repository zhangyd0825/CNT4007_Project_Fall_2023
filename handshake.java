package CNT4007_Project_Fall_2023;
import java.net.*;
import java.nio.ByteBuffer;
import java.io.*;

public class handshake {
    byte[] header;
    int size = 32;
    int peerID;
    byte[] hs = new byte[32];
    public byte[] handshake(int ID){
        header = new String("P2PFILESHARINGPROJ").getBytes();
        byte[] zeroes = new String("0000000000").getBytes();
        byte[] id = ByteBuffer.allocate(4).putInt(ID).array();
        int currentByte = 0;
        for(int i = 0; i < 18; i++){
            hs[i] = header[i];
            currentByte++;
        }
        for(int i = 0; i < 10; i++){
            hs[i+currentByte] = zeroes[i];
            currentByte++;
        }
        for(int i = 0; i < 4; i++){
            hs[i+currentByte] = id[i];
            currentByte++;
        }
        return hs;
    }
}
