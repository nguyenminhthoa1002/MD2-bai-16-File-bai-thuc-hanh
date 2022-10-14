package thucHanh2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> listNumber = new ArrayList<>();
    static int max;

    public static void main(String[] args) {
        readDataFromFile("D:\\Module 2\\bai-16-File\\bai-thuc-hanh\\src\\thucHanh2\\fileNumber.txt");
        max = listNumber.get(0);
        for (int number : listNumber) {
            if (max<number) {
                max = number;
            }
        }
        Scanner scanner = new Scanner(System.in);
        writeDataToFile(scanner,"D:\\Module 2\\bai-16-File\\bai-thuc-hanh\\src\\thucHanh2\\maxNumber.txt");
    }

    public static void writeDataToFile(Scanner scanner, String path) {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(path);
            fileOutputStream = new FileOutputStream(path);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(max+"");
            bufferedWriter.flush();
        } catch (FileNotFoundException exception1) {
            exception1.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close();
                outputStreamWriter.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
            while (line != null) {
                System.out.println(line);
                listNumber.add(Integer.parseInt(line));
                line = bufferedReader.readLine();
            }
        } catch (RuntimeException exception1) {
            exception1.printStackTrace();
        } catch (FileNotFoundException exception2) {
            exception2.printStackTrace();
        } catch (IOException exception3) {
            exception3.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
