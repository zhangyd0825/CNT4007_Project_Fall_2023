package CNT4007_Project_Fall_2023;

import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Logger {
    private Date date;
    private DateFormat format;
    private BufferedWriter writer;

    public Logger(BufferedWriter w) {
        date = new Date();
        format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        this.writer = w;
    }

    public void connectionFrom(int from, int to){
        date = new Date();
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(from);
        buff.append(" received connection from Peer ");
        buff.append(to);
        buff.append('.');
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void connectionTo(int from, int to) {
        date = new Date();
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(from);
        buff.append(" has connected to Peer ");
        buff.append(to);
        buff.append('.');
        try {
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void optUN(int id, int n){
        date = new Date();
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(id);
        buff.append(" has optimistically unchoked ");
        buff.append(n);
        buff.append('.');
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void changePN(int id, int[] ids){
        date = new Date();
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(id);
        buff.append(" changed its preferred neighbors to ");
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
            e.printStackTrace();
        }
    }

    public void interested(int to, int from){
        date = new Date();
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(to);
        buff.append(" is interested in Peer ");
        buff.append(from);
        buff.append("'s data.");
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void notInterested(int to, int from){
        date = new Date();
        StringBuffer buff = new StringBuffer();
        buff.append(format.format(date));
        buff.append(':');
        buff.append(" Peer ");
        buff.append(to);
        buff.append(" is NOT interested in Peer ");
        buff.append(from);
        buff.append("'s data.");
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void choked(int from, int to){
        date = new Date();
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(from);
        buff.append(" has choked ");
        buff.append(to);
        buff.append('.');
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void unchoked(int to, int from){
        date = new Date();
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(to);
        buff.append(" has unchoked ");
        buff.append(from);
        buff.append('.');
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void done(int peerID){
        date = new Date();
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(peerID);
        buff.append(" has finished downloading the file ");
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void have(int from, int to, int piece){
        date = new Date();
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(from);
        buff.append(" tells ");
        buff.append(to);
        buff.append(" it has piece ");
        buff.append(piece);
        buff.append('.');
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
//            e.printStackTrace();
        }
    }

    public void downloadingPiece(int to, int from, int piece, int num){
        date = new Date();
        StringBuffer buff = new StringBuffer();
        buff.append('[');
        buff.append(format.format(date));
        buff.append("]: Peer ");
        buff.append(to);
        buff.append(" has finished downloading piece ");
        buff.append(piece);
        buff.append(" from ");
        buff.append(from);
        buff.append(". It now has ");
        buff.append(num);
        buff.append(" pieces.");
        try{
            writer.write(buff.toString());
            writer.newLine();
            writer.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}