package com.company;

import java.io.*;

public class _03_AllCapitals {
    public static void main(String[] args) {
        try {
            BufferedReader bfr = new BufferedReader( new FileReader("src/resources/inputLineNumbers.txt"));
            File file = new File("src/resources/output.txt");
            PrintWriter out;

            if (!file.exists())
                out = new PrintWriter(new FileOutputStream(new File("src/resources/output.txt")));
            else
                out = new PrintWriter (file);

            String temp;
            int index = 0;
            while ((temp = bfr.readLine()) != null)
                out.append(String.valueOf(++index)).append(". ").append(temp).append("\r\n");

            out.close ();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
