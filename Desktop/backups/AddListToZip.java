package tw.gov.nca.gss.common.util;

import java.io.File;
import java.util.ArrayList;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import tw.gov.nca.gss.common.GssBusinessException;
import tw.gov.nca.gss.common.GssMessage;

public class AddListToZip{

	
	// 測試
	public AddListToZip() throws ZipException {
		try {
			ZipFile zipFile = new ZipFile("C:/Users/JamesHuang/Desktop/try.zip");
			String folderToAdd = "C:/Users/JamesHuang/Desktop/backups";
			// ZipFile zipFile = new ZipFile(path);
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			parameters.setPassword("123");
			zipFile.addFolder(folderToAdd, parameters);
		} catch (Exception e) {
			throw new GssBusinessException(GssMessage.G000AE, e);
		}
	}

	public AddListToZip(final String path, final String folderToAdd, final String pwd) throws ZipException {
		try {
			ZipFile zipFile = new ZipFile(path);
			ArrayList<File> list = new ArrayList<File>();
			list.add(new File("file1"));
			list.add(new File("file2"));
			list.add(new File("file3"));

			ZipParameters parameters = new ZipParameters();

			// 壓縮格式
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			// 壓縮等級
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

			// 加密以及加密格式
			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			parameters.setPassword(pwd);

			// zip檔案分割壓縮1MB
			zipFile.createZipFile(list, parameters, true, 1048576);
		} catch (Exception e) {
			throw new GssBusinessException(GssMessage.G000AE, e);
		}
	}

}