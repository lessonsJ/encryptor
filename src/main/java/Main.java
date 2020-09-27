import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;

public class Main {
    public static final String PASSWORD = "123456";

    public static void main(String[] args) {
        String path = "C:\\zipFolder\\";

        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_ULTRA);
        parameters.setEncryptFiles(true);
        parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
        parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        parameters.setPassword(PASSWORD);

        try
        {
            //Зашифровать
            net.lingala.zip4j.core.ZipFile zipFile = new ZipFile(path + "archive.zip");
            zipFile.addFolder(
                    new File(path + "input"),
                    parameters
            );
            //Расшифровать
            if (zipFile.isEncrypted()){
                zipFile.setPassword(PASSWORD);
            }
            zipFile.extractAll(path + "output");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
