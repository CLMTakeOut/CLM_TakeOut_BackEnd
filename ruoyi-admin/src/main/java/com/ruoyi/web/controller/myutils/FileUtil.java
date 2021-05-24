package com.ruoyi.web.controller.myutils;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * date: 2021/5/14 16:14
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public class FileUtil {
    // 获取文件的byte[]数据
    public static byte[] getFileBytes(String filePath) throws IOException {
        // 1.根据文件路径名创建文件对象
        File file = new File(filePath);
        long fileSize = file.length();
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int)fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length && (numRead = fi.read(buffer,offset,buffer.length-offset))>=0){
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file "
                    + file.getName());
        }
        fi.close();
        return buffer;
    }
    public static String uploadFile(String path,String id,MultipartFile file){
        // 1.获取上传图片的文件名以及后缀名
        String fileName = id+"_"+file.getOriginalFilename();
        // 2.获取jar包所在的目录
        ApplicationHome h = new ApplicationHome(FileUtil.class);
        File jarF = h.getSource();
        // 3.在jar包所在的目录下生成一个upload文件夹用来存储上传的图片
        String dirPath = jarF.getParentFile().toString()+path;
        String filePath = dirPath+fileName;
        // 4.创建文件夹
        File folder = new File(dirPath);
        if (!folder.exists()){
            boolean mkdirs = folder.mkdirs();
        }
        try {
            // 先删除id相同的文件
            deleteFiles(dirPath,id);
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("上传图片的所在路径"+filePath);
        return filePath;
    }
    // 按文件名字进行批量删除
    public static void deleteFiles(String folder,String id){
        //1.遍历指定目录下的所有文件
        File file = new File(folder);
        File[] files = file.listFiles();
        for (File f : files){
            // 如果不是目录(文件)
            if (!f.isDirectory()){
                String[] s = f.getName().split("_", 2);
                if (s[0].equals(id)){
                    boolean delete = f.delete();
                    System.out.println("删除:"+delete);
                }
            }
        }
    }
}
