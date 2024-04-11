import java.io.File;
import java.nio.file.*;
import java.util.Scanner;
import java.awt.Color;

public class ByteDiggerJava
{
    public static void main(String[] args) throws Exception
    {
        final int MAIN_DIRECTORY_PATH_LENGTH=3;
        int input=-1;

        while(input!=3)
        {
            System.out.println("");
            String[] bigFont={
            " BBBBB     y   y    tttttt    eee      DDDDD    i    ggggg     ggggg     eee     RRRR ",
            " B    B     y y       t      e   e     D    D   i   g         g         e   e    R   R",
            " BBBBB       y        t      eeeee     D    D   i   g  gg     g  gg     eeeee    RRRR ",
            " B    B      y        t      e         D    D   i   g   g     g   e     e        R  R ",
            " BBBBB       y        t       eeee     DDDDD    i    ggggg     ggggg     eeee    R   R"};

            for (String line : bigFont)
                System.out.println(line);

            System.out.println("");
            System.out.println(" 1) Analyze the current mass storage.");
            System.out.println(" 2) Add a malicious file to your blacklist.");
            System.out.println(" 3) Exit.");
            System.out.println("");

            Scanner scanner=new Scanner(System.in);
            input=scanner.nextInt();

            if(input==1)
            {
                System.out.println("");
                System.out.println(" Please wait...");
                File rootDirectory=new File(Paths.get("").toAbsolutePath().toString().substring(0, MAIN_DIRECTORY_PATH_LENGTH));
                int finalMatchingHashes=0;
                finalMatchingHashes+=DirectoryExplorer.exploreDirectory(rootDirectory);
                System.out.println(" "+finalMatchingHashes+" malicious files has been found inside the current mass storage: "+rootDirectory.getAbsolutePath());
            }

            if(input==2)
            {
                System.out.println("");
                System.out.println(" Write the path of your malicious file: ");

                Scanner fileScanner=new Scanner(System.in);
                String path=fileScanner.nextLine();
                path=Paths.get(path).toAbsolutePath().toString();

                File reportedFile=new File(path);
                if(DirectoryExplorer.FileIsEXEFile(reportedFile))
                {
                    HashList.printLineInHashList(FileMD5.getMD5OfFile(path), (Paths.get("").toAbsolutePath().toString()+"\\hashLists\\MyHashList.txt"));
                    System.out.println(" Your malicious file has been successfully added to your blacklist.");
                }
                else
                    System.out.println(" It wasn't possible to add your malicious file to your blacklist because it does not exist, or it may correspond to a folder or to a non-executable file.");
            }
        }
        System.out.println("");
        System.out.println(" See you soon!");
    }
}
