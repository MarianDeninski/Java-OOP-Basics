package nfs.core;

import nfs.io.ConsoleInputReader;
import nfs.io.ConsoleWriteLine;

public class Engine {

    private ConsoleInputReader consoleInputReader;
    private ConsoleWriteLine consoleWriteLine;
    private CarManager carManager;

    public Engine() {

        this.consoleInputReader = new ConsoleInputReader();
        this.consoleWriteLine = new ConsoleWriteLine();
        this.carManager = new CarManager();

    }


    public void run() {



        String reader = this.consoleInputReader.readLine();

        while (!"Cops Are Here".equalsIgnoreCase(reader)) {

            String[] input = reader.split("\\s+");
            switch (input[0]) {

                case "register":

                    this.carManager.register(Integer.parseInt(input[1]), input[2], input[3], input[4]
                            , Integer.parseInt(input[5]), Integer.parseInt(input[6]), Integer.parseInt(input[7])
                            , Integer.parseInt(input[8]), Integer.parseInt(input[9]));

                    break;

                case "check":

                    this.consoleWriteLine.writeLine(this.carManager.check(Integer.parseInt(input[1])));
                    break;

                case "open":

                    this.carManager.open(Integer.parseInt(input[1]), input[2], Integer.parseInt(input[3]), input[4]
                            , Integer.parseInt(input[5]));
                    break;

                case "participate":

                    this.carManager.participate(Integer.parseInt(input[1]), Integer.parseInt(input[2]));

                    break;
                case "start":

                    this.consoleWriteLine.writeLine(this.carManager.start(Integer.parseInt(input[1])));
                    break;

                case "park":

                    this.carManager.park(Integer.parseInt(input[1]));
                    break;

                case "unpark":
                    this.carManager.unpark(Integer.parseInt(input[1]));
                    break;

                case "tune":
                    this.carManager.tune(Integer.parseInt(input[1]), input[2]);
                    break;

            }

            reader = this.consoleInputReader.readLine();
        }


    }
}
