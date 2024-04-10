import java.io.File;
import java.nio.file.*;

public class DirectoryExplorer
{
    private static final int MAX_NUMBER_LISTS=14;

    public static int exploreDirectory(File directory) throws Exception
    {
        String fileHash="";
        int matchingHashes=0;

        if (directory.isDirectory())
        {
            File[] files=directory.listFiles();
            if (files!=null)
            {
                for (File file:files)
                {
                    if (file.isDirectory())
                        exploreDirectory(file);
                    else
                    {
                        if(FileIsEXEFile(file))
                        {
                            fileHash=FileMD5.getMD5OfFile(file.getAbsolutePath());
                            HashList list=new HashList();
                            for(int i=0; i<=MAX_NUMBER_LISTS; i++)
                            {
                                list.setListName(Paths.get("").toAbsolutePath().toString()+"\\hashLists\\VirusShareList"+i+".txt");
                                matchingHashes+=list.compareFileHashToHashList(fileHash, file.getAbsolutePath().toString());
                            }
                            list.setListName(Paths.get("").toAbsolutePath().toString()+"\\hashLists\\MyHashList.txt");
                            matchingHashes+=list.compareFileHashToHashList(fileHash, file.getAbsolutePath().toString());
                        }
                    }
                }
            }
        }
        return matchingHashes;
    }

    public static boolean FileIsEXEFile(File referenceFile)
    {
        if(referenceFile.exists() && referenceFile.isFile() && referenceFile.canExecute())
            return true;
        else
            return false;
    }
}
