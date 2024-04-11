import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HashList
{
    private String listName=new String();

    public HashList(String listName)
    {
        this.listName=listName;
    }

    public HashList()
    {}

    public int compareFileHashToHashList(String hash, String fileAbsolutePath)
    {
        try
        {
            List<String> allLines=Files.readAllLines(Paths.get(listName));
            int matchingHashes=0;

            int nLine=1;
            for (String line:allLines)
            {
                if(line.equals(hash))
                {
                    System.out.println(" The following file: "+fileAbsolutePath+" has been identified in the following list: "+listName+" at line "+nLine);
                    matchingHashes++;
                }
                nLine++;
            }
            return matchingHashes;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            e.getCause();
            return -1;
        }
    }

    public void setListName(String listName)
    {
        this.listName=listName;
    }

    public static void printLineInHashList(String line, String hashListPath)
    {
        try
        {
            BufferedWriter writer=new BufferedWriter(new FileWriter(hashListPath));
            writer.write(line);
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
