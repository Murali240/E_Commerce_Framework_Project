package com.ecommerce.utilities;

import java.io.File;

public class FileDownloadUtils {
	
	/** Verifies if expected file is downloaded in the given path
     * @param downloadPath directory where files are downloaded
     * @param expectedFileName part of the filename expected (ex: "invoice")
     * @return true if file exists, false otherwise  */
    public static boolean isFileDownloaded(String downloadPath, String expectedFileName) {
        File folder = new File(downloadPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().contains(expectedFileName)) {
                    return true;
                }
            }
        }
        return false;
    }

}
