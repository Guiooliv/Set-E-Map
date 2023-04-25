package Ex1.Application;
import Ex1.Entity.LogEntry;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("enter file full path: ");
        String path = scan.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            Set<LogEntry> logs = new HashSet<>(); // hashset chosen because it's the fastest and the order doesn't matter.
            String line = br.readLine();

            while (line != null){
                String [] filds = line.split(" ");
                String username = filds[0];
                Date moment = Date.from(Instant.parse(filds[1]));
                logs.add(new LogEntry(username, moment));
                line = br.readLine();
            }
            System.out.println("Total users: " + logs.size());
        } catch (FileNotFoundException e) {
            System.out.println("File path does not exist");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
