package client;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LocalHistory {
    private static PrintWriter out;

    public static void start(String login) {
        try {
            out = new PrintWriter(new FileOutputStream(".\\client\\history_" + login + ".txt", true), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void stop(){
        if(out != null) {
            out.close();
        }

    }
    public static void writeHistory(String msg){
        out.println(msg);
    }

    public static String getHistory(String login){
        StringBuilder sb = new StringBuilder();
        try {
            List<String> historyLines = Files.readAllLines(Paths.get(".\\client\\history_" + login + ".txt"));
            int startLines = 0;
            if (historyLines.size()>100){
                startLines = historyLines.size() - 100;}
            for (int i = startLines; i < historyLines.size(); i++){
                sb.append(historyLines.get(i)).append(System.lineSeparator());
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
