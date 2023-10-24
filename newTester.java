import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class reader
{
    //private String config = "";
    private int NumberOfPreferredNeighbors;
    private int UnchokingInterval;
    private int OptimisticUnchokingInterval;
    private String FileName;
    private int FileSize;
    private int PieceSize;

    public int getNumberOfPreferredNeighbors()
    {
        return NumberOfPreferredNeighbors;
    }

    public int getUnchokingInterval()
    {
        return UnchokingInterval;
    }

    public int getOptimisticUnchokingInterval()
    {
        return OptimisticUnchokingInterval;
    }

    public String getFileName()
    {
        return FileName;
    }

    public int getFileSize()
    {
        return FileSize;
    }

    public int getPieceSize()
    {
        return PieceSize;
    }

    public reader(String path)
    {
        try {
            Scanner scan = new Scanner(new File(path));
            scan.useDelimiter(" |\n");
            while(scan.hasNext()){
                //config += scan.next() + "\n";
                scan.next();
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
}
public class newTester
{

}
