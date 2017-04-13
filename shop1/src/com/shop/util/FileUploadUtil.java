package com.shop.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.shop.bean.FileImage;

//用来实现文件上传的业务逻辑
@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
	@Value("#{prop.basePath+prop.filePath}")
	private String filePath;
	@Value("#{prop.basePath+prop.bankPath}")
	private String bankPath;

//	public void setFilePath(String filePath) {
//		this.filePath = filePath;
//		System.out.println("路径" + filePath);
//	}

	public String[] getBankImage() {
		return new File(bankPath).list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// 通过后缀名来实现文件过滤效果
//				System.out.println("dir:"+dir+", name:"+name);
				return name.endsWith(".gif");
			}
		});
	}

	// 1.通过文件名获取扩展名
	private String getFileExt(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}

	// 2.生成UUID随机数，作为新的文件名
	private String newFileName(String fileName) {
		String ext = getFileExt(fileName);
		return UUID.randomUUID().toString() + "." + ext;
	}

	// 3.实现文件上传功能，返回上传后新的文件名称
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shop.util.FileUpload#uploadFile(com.shop.bean.FileImage)
	 */
	@Override
	public String uploadFile(FileImage fileImage) {
		// 获取新的文件名
		String pic = newFileName(fileImage.getFilename());
		try {
			FileUtil.copyFile(fileImage.getFile(), new File(filePath, pic));
			return pic;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			fileImage.getFile().delete();
		}
	}
	// public static void main(String[] args) {
	// String[] list=new File("C:\\bank").list(new FilenameFilter() {
	//
	// @Override
	// public boolean accept(File dir, String name) {
	// //通过后缀名来实现文件过滤效果
	// System.out.println("dir:"+dir+", name:"+name);
	// return name.endsWith(".gif");
	// }
	// });
	// System.out.println("----------");
	// for(String temp:list){
	// System.out.println(temp);
	// }
	// }
}
