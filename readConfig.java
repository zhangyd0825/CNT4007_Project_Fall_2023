package CNT4007_Project_Fall_2023;
import java.io.*;
import java.util.Scanner;

public class readConfig {
    private String config = "";
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

    public int getUnchokingInterval(){
        return UnchokingInterval;
    }

    public readConfig(String path){
        try {
            Scanner scan = new Scanner(new File(path));
            scan.useDelimiter(" |\n");
            while(scan.hasNext()){
                config += scan.next() + "\n";
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

    public static void main(String[] args){
        readConfig test = new readConfig("CNT4007_Project_Fall_2023/project_config_file_small/project_config_file_small/Common.cfg");
        System.out.println(test.NumberOfPreferredNeighbors + " " + test.UnchokingInterval + " " + test.OptimisticUnchokingInterval + " "+ test.FileName +" "+ test.FileSize + " "+ test.PieceSize + " "); //
        //System.out.println(test.config);
    }
}
