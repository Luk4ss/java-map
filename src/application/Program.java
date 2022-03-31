package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {

    public static void main(String[] args) {

        String path = "./in.txt";

        Map<String, Integer> votes = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();

            while(line != null){
                String[] fields = line.split(",");
                if(votes.containsKey(fields[0])){
                    votes.put(fields[0], Integer.parseInt(fields[1]) + votes.get(fields[0]));
                } else{
                    votes.put(fields[0], Integer.parseInt(fields[1]));
                }

                line = br.readLine();
            }

            for(String candidato : votes.keySet()){
                System.out.println("Candidato: " + candidato  + " | Total de votos: " + votes.get(candidato));
            }


        }catch (IOException e){
            System.out.println("Error + " + e.getMessage());
        }

    }
}
