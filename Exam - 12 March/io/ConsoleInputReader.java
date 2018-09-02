package nfs.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class ConsoleInputReader {
    private BufferedReader reader;

    public ConsoleInputReader() {
        this.reader =new BufferedReader(new InputStreamReader(in));
    }

    public String readLine(){

        String result = "";

        try {
          result = this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }
}
