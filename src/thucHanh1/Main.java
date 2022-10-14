package thucHanh1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        readDataFromFile("D:\\Module 2\\bai-16-File\\bai-thuc-hanh\\src\\thucHanh1\\fileNumber.txt");
    }

    public static void readDataFromFile(String path) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            File file = new File(path);
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            System.out.println("Data in file is:");
            String line = bufferedReader.readLine();
            while (line!=null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (RuntimeException exception1) {
            exception1.printStackTrace();
        } catch (FileNotFoundException exception2){
            exception2.printStackTrace();
        } catch (IOException exception3) {
            exception3.printStackTrace();
        }
        finally {
            try {
                if (bufferedReader!=null) {
                    bufferedReader.close();
                }
                if (inputStreamReader!=null) {
                    inputStreamReader.close();
                }
                if (fileInputStream!=null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}