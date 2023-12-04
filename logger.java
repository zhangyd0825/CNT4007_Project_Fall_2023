package CNT4007_Project_Fall_2023;

import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class logger {
    private Date date;
    private DateFormat format;
    private BufferedWriter writer;

    public logger(BufferedWriter w) {
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