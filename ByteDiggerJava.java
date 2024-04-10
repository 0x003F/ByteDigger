import java.io.File;
import java.nio.file.*;
import java.util.Scanner;

public class ByteDiggerJava
{
    public static void main(String[] args) throws Exception
    {
        final int MAIN_DIRECTORY_PATH_LENGTH=3;
        int input=-1;

        System.out.println("1) Analyze the current mass storage.");
        System.out.println("2) Add a malicious file to your blacklist.");
        System.out.println("3) Exit.");

        while(input!=3)
        {
            Scanner scanner=new Scanner(System.in);
            input=scanner.nextInt();

            if(input==1)
            {
                System.out.println("Please wait...");
                File rootDirectory=new File(Paths.get("").toAbsolutePath().toString().substring(0, MAIN_DIRECTORY_PATH_LENGTH));
                int finalMatchingHashes=0;
                finalMatchingHashes+=DirectoryExplorer.exploreDirectory(rootDirectory);
                System.out.println(finalMatchingHashes+" malicious files has been found inside the current mass storage: "+rootDirectory.getAbsolutePath());
            }

            if(input==2)
            {
                System.out.println("Write the path of your malicious file: ");

                Scanner fileScanner=new Scanner(System.in);
                String path=fileScanner.nextLine();
                path=Paths.get(path).toAbsolutePath().toString();

                File reportedFile=new File(path);
                if(DirectoryExplorer.FileIsEXEFile(reportedFile))
                {
                    HashList.printLineInHashList(FileMD5.getMD5OfFile(path), (Paths.get("").toAbsolutePath().toString()+"\\hashLists\\MyHashList.txt"));
                    System.out.println("Your malicious file has been successfully added to your blacklist.");
                }
                else
                    System.out.println("It wasn't possible to add your malicious file to your blacklist because it does not exist, or it may correspond to a folder or to a non-executable file.");
            }
        }
        System.out.println("See you soon!");
    }
}
