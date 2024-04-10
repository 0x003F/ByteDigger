import java.io.FileInputStream;
import java.security.MessageDigest;

public class FileMD5
{
    public FileMD5()
    {}

    public static String fromBytesToHex(byte[] bytes)
    {
        int i;
        Integer[] decimals=new Integer[bytes.length];
        String Hex="";
        for(i=0; i<bytes.length; i++)
        {
            decimals[i]=bytes[i] & 0xff; //0xff is 255 in hexadecimal, so, calculating the 'and' operation between a signed int value and 255, we get the respective unsigned int value(is not possible to use the && operator on int variables, so, instead, we must use the & operator) 
            Hex+=Integer.toHexString(decimals[i]);
        }
        return Hex;
    }

    public static String getMD5OfFile(String filePath) throws Exception
    {
        FileInputStream fis = new FileInputStream(filePath);
        byte[] data = new byte[fis.available()];
        fis.read(data);
        fis.close();

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] checksum = md.digest(data);
        return fromBytesToHex(checksum);
    }
}
