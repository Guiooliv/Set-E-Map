package Ex3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> Votes = new TreeMap<>(); //treemap used, as it is placed in order (but it is slow).

        System.out.print("Enter File full path: ");
        String path = scan.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] filds = line.split(",");
                String name = filds[0];
                int vote = Integer.parseInt(filds[1]);
               if(Votes.containsKey(name)){
                   int votesSofar = Votes.get(name);
                   Votes.put(name, vote + votesSofar);
               }
               else {
                   Votes.put(name,vote);
               }
               line = br.readLine();
            }
           for (String key : Votes.keySet()){
               System.out.println(key + ": " + Votes.get(key));
           }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scan.close();
    }
}

