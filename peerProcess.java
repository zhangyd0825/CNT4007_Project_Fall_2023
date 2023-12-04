package CNT4007_Project_Fall_2023;
import java.net.*;
import java.nio.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

class Logger {
    private Date date;
    private DateFormat format;
    private BufferedWriter writer;

    public Logger(BufferedWriter w) {
        date = new Date();
        format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        this.writer = w;
    }
    public void infoSaved(int id){
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(id);
        buff.append(" has acquired Common and Peer info.");
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            System.out.println("Info saved log error");
            e.printStackTrace();
        }
    }

    public void connectionFrom(int from, int to){
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(from);
        buff.append(" is connected from Peer ");
        buff.append(to);
        buff.append('.');
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            System.out.println("Connection received log error");
            e.printStackTrace();
        }
    }

    public void connectionTo(int from, int to) {
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(from);
        buff.append("  makes a connection to Peer ");
        buff.append(to);
        buff.append('.');
        try {
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            System.out.println("Connection to log error");
            e.printStackTrace();
        }
    }

    public void optUN(int id, int n){
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(id);
        buff.append(" has the optimistically unchoked neighbor ");
        buff.append(n);
        buff.append('.');
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            System.out.println("OUN log error");
            e.printStackTrace();
        }
    }

    public void changePN(int id, int[] ids){
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(id);
        buff.append("  has the preferred neighbors ");
        for(int x : ids){
            buff.append("Peer ");
            buff.append(id);
            buff.append(", ");
        }
        buff.deleteCharAt(buff.length() - 1);
        buff.deleteCharAt(buff.length() - 1);
        buff.append('.');
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            System.out.println("Change PN log error");
            e.printStackTrace();
        }
    }

    public void interested(int to, int from){
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(to);
        buff.append("  received the ‘interested’ message from ");
        buff.append(from);
        buff.append("'s data.");
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            System.out.println("Interested log error");
            e.printStackTrace();
        }
    }

    public void notInterested(int to, int from){
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append(format.format(date));
        buff.append(':');
        buff.append(" Peer ");
        buff.append(to);
        buff.append(" received the ‘not interested’ message from ");
        buff.append(from);
        buff.append("'s data.");
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            System.out.println("Not interested log error");
            e.printStackTrace();
        }
    }

    public void choked(int from, int to){
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(to);
        buff.append("  is choked by ");
        buff.append(from);
        buff.append('.');
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            System.out.println("Choked log error");
            e.printStackTrace();
        }
    }

    public void unchoked(int to, int from){
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(to);
        buff.append("  is unchoked by ");
        buff.append(from);
        buff.append('.');
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            System.out.println("Unchoked log error");
            e.printStackTrace();
        }
    }

    public void done(int peerID){
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(peerID);
        buff.append(" has downloaded the complete file.");
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            System.out.println("Done log error");
            e.printStackTrace();
        }
    }

    public void have(int from, int to, int piece){
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(from);
        buff.append(" received the ‘have’ message from ");
        buff.append(to);
        buff.append(" for the piece ");
        buff.append(piece);
        buff.append('.');
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            System.out.println("Have piece log error");
//            e.printStackTrace();
        }
    }

    public void downloadingPiece(int to, int from, int piece, int num){
        date = new Date();
        StringBuilder buff = new StringBuilder();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(to);
        buff.append(" has downloaded the piece ");
        buff.append(piece);
        buff.append(" from ");
        buff.append(from);
        buff.append(". Now the number of pieces it has is ");
        buff.append(num);
        buff.append(".");
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            System.out.println("Download piece log error");
            e.printStackTrace();
        }
    }

}
class Handshake {
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

    public byte[] getMessage() {
        return message;
    }

    public Handshake(int ID) {
        header = new String("P2PFILESHARINGPROJ").getBytes();
        byte[] zeroes = new String("0000000000").getBytes();
        peerID = ByteBuffer.allocate(4).putInt(ID).array();
        int currentByte = 0;
        for (int i = 0; i < 18; i++) {
            message[i] = header[i];
            currentByte++;
        }
        int start_next = currentByte;
        for (int i = 0; i < 10; i++) {
            message[i + start_next] = zeroes[i];
            currentByte++;
        }
        start_next = currentByte;
        for (int i = 0; i < 4; i++) {
            message[i + start_next] = peerID[i];
            currentByte++;
        }
        System.out.println("PeerID: " + ByteBuffer.wrap(peerID).getInt());
    }
}

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
    private static int myID;
    private static int numComplete = 0;
    private static Map<Integer, Peer> peers;
    public static Logger log;
    private static BufferedReader peerInfo;
    private static reader commonConfig= new reader("CNT4007_Project_Fall_2023/Common.cfg");

public static void readPeerInfo() throws FileNotFoundException {
    try {
        File peerFile = new File("CNT4007_Project_Fall_2023/PeerInfo.cfg");
        peerInfo = new BufferedReader(new FileReader(peerFile));
        peers = new HashMap<>();
        for (Object fullLine : peerInfo.lines().toArray()) {
            String[] line = ((String) fullLine).split(" ");
            Peer peer = new Peer();
            int peerID = Integer.parseInt(line[0]);
            if (peers.isEmpty()){
                hostID = peerID;
            }
            peer.setID(peerID);
            peer.setHost(line[1]);
            peer.setPort(Integer.parseInt(line[2]));
            if (Integer.parseInt(line[3]) == 1) {
                peer.setHaveCompleteFile();
                numComplete++;
            }
            peers.put(peerID, peer);
        }
        System.out.println("PeerInfo file read and data saved");
        peerInfo.close();
    }
    catch(Exception e){
        System.out.println("PeerInfo error occurred");
        e.printStackTrace();
    }
}

public static class connectToPeers extends Thread{
    public void run(){
        try{
            for(Map.Entry<Integer,Peer> entry : peers.entrySet()){
                if (entry.getKey() != myID) {
                    Peer newPeer = peers.get(entry.getKey());
                    try {
                        byte[] buffer = new byte[32];
                        Handshake hs = new Handshake(myID);
                        Socket p2p = new Socket(newPeer.getHost(), newPeer.getPort());
                        DataOutputStream outputStream = new DataOutputStream(p2p.getOutputStream());
                        DataInputStream inputStream = new DataInputStream(p2p.getInputStream());
                        outputStream.flush();
                        outputStream.write(hs.getMessage());
                        //System.out.println(hs.getMessage());
                        outputStream.flush();

                        inputStream.readFully(buffer);
                        byte[] thatPeer = Arrays.copyOfRange(buffer, 28, 32);
                        ByteBuffer w = ByteBuffer.wrap(thatPeer);
                        int thatPeerID = w.getInt();
                        if(thatPeerID == entry.getKey()){
                            log.connectionTo(myID, thatPeerID);
                        }
                        else{
                            p2p.close();
                        }
                    }
                    catch(Exception e){
                        System.out.println("socket error");
                        e.printStackTrace();
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Connection to peer error");
            e.printStackTrace();
        }
    }
}

public static class connectFromPeers extends Thread{
    public void run(){
        try{
            int count = peers.size();
            ServerSocket listener = new ServerSocket();
            while(count >1 ){
                Socket requestSocket = listener.accept();
                byte[] buffer = new byte[32];
                Handshake hs = new Handshake(myID);
                DataOutputStream outputStream = new DataOutputStream(requestSocket.getOutputStream());
                DataInputStream inputStream = new DataInputStream(requestSocket.getInputStream());
                inputStream.readFully(buffer);
                byte[] thatPeer = Arrays.copyOfRange(buffer, 28, 32);
                ByteBuffer w = ByteBuffer.wrap(thatPeer);
                int thatPeerID = w.getInt();

                outputStream.flush();
                outputStream.write(hs.getMessage());
                outputStream.flush();
                log.connectionTo(myID, thatPeerID);

                count--;


            }
        }
        catch(Exception e){
            System.out.println("Connection from peer error");
            e.printStackTrace();
        }
    }
}

    public static void main(String[] args) {
        myID = Integer.parseInt(args[0]);
        try{
            //commonConfig = new readConfig("CNT4007_Project_Fall_2023/project_config_file_small/project_config_file_small/Common.cfg");
            //System.out.println("file name: "+ commonConfig.getFileName());
            commonConfig.display();
            readPeerInfo();

            File myDir = new File("peer_" + myID);
            if (!myDir.exists()) {
                myDir.mkdir();
            }
            File logFile = new File(System.getProperty("user.dir") + "/" + "peerLog_" + hostID + ".log");
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            BufferedWriter write = new BufferedWriter(new FileWriter(logFile.getAbsolutePath(), true));
            write.flush();
            log = new Logger(write);
            log.infoSaved(myID);


            System.out.println("My Peer Port: " + peers.get(hostID).getPort());
            new connectToPeers();
            new connectFromPeers();

            //System.out.println("this works");
            //RunServer serverThread = new RunServer();
            //serverThread.start();
            //TimeUnit.SECONDS.sleep(2);
//            Client client = new Client();
//            client.run();

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
        return Integer.parseInt(NumberOfPreferredNeighbors);
    }

    public int getUnchokingInterval() {
        return Integer.parseInt(UnchokingInterval);
    }

    public int getOptimisticUnchokingInterval() {
        return Integer.parseInt(OptimisticUnchokingInterval);
    }

    public int getFilesize() {
        return Integer.parseInt(FileSize);
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
    public boolean isFirstPeer = false;
    private boolean haveCompleteFile = false;
    private char[] bitfield;
    private int pieceNum = 0;

    public int getID() {
        return ID;
    }

    public void setID(int peerID) {
        this.ID = peerID;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean getHaveCompleteFile() {
        return haveCompleteFile;
    }

    public void setHaveCompleteFile() {
        this.haveCompleteFile = !this.haveCompleteFile;
    }

    public char[] getBitfield() {
        return bitfield;
    }

    public void setBitfield(char[] bitfield) {
        this.bitfield = bitfield;
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
//class RunServer extends Thread {
//    public void run() {
//        try {
//            ServerSocket listener = new ServerSocket(3636);
//            int clientNum = 1;
//            System.out.println("The server is running.");
//            try {
//                while (true) {
//                    new Server.Handler(listener.accept(), clientNum).start();
//                    System.out.println("Client " + clientNum + " is connected!");
//                    clientNum++;
//                }
//            } finally {
//                listener.close();
//            }
//        } catch (Exception e) {
//            System.out.println("Server error");
//        }
//    }
//}