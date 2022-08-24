import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileTest {
    private long count = 0;

    public static void main(String[] args) throws IOException {
        FileTest fileTest = new FileTest();
        fileTest.scanFilePath("E:\\github\\MovieCrawler\\src");
    }

    private void scanFilePath(String srcPath) throws IOException {
        LinkedList<String> dirList = new LinkedList<>();
        List<String> fileList = new ArrayList<>();

        File dir = new File(srcPath);
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()){
                fileList.add(file.getAbsolutePath());
            }else {
                dirList.add(file.getAbsolutePath());
            }
        }

        while(!dirList.isEmpty()){
            String dirName = dirList.removeFirst();
            File tempFile = new File(dirName);
            File[] tempFiles = tempFile.listFiles();
            for(File file : tempFiles){
                if(file.isFile()){
                    fileList.add(file.getAbsolutePath());
                }else {
                    dirList.add(file.getAbsolutePath());
                }
            }
        }

        for(String fileName : fileList){
            count = count + getFileLineCount(fileName);
        }
        System.out.println("总行数：" + count);
    }

    private int getFileLineCount(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
        int count = 0;
        while(null != lineNumberReader.readLine()){
            count++;
        }
        return count;
    }
}
