import java.io.*;
import java.util.*;

public class Copy {

    public static void main(String[] args) {

        boolean replace = false;
        boolean append = false;

        Scanner in = new Scanner(System.in);

        System.out.println("What is the Input File Name?");
        String Input_fileName = in.nextLine();

        System.out.println("What is the Output File Name?");
        String Output_fileName = in.nextLine();

        System.out.println("Would you like to replace or append to it?");
        String r = in.next();

        File f = new File(Output_fileName+".txt");
        if (f.exists()) {
            System.out.println("Output File Already Exists");
            System.out.println();
            if(Objects.equals(r, "r")) {
                replace = true;
                //System.out.println("replace");
            } else if(Objects.equals(r, "a")){
                append = true;
                //System.out.println("append");
            }
        }

            try {
                File input = new File(Input_fileName + ".txt");
                FileReader fileReader = new FileReader(input);
                File output = new File(Output_fileName + ".txt");
                FileWriter fileWriter = new FileWriter(output);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String read;

                while ((read = bufferedReader.readLine()) != null) {
                    System.out.println(read);

                    if(replace){
                        fileWriter.write(read);
                        fileWriter.write(System.getProperty("line.separator"));
                    }else if(append){
                        fileWriter.append(read);
                        fileWriter.append(System.getProperty("line.separator"));
                    }else{
                        fileWriter.write(read);
                        fileWriter.write(System.getProperty("line.separator"));
                    }
                }

                fileReader.close();
                fileWriter.close();
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                System.out.println("'" + Input_fileName + "' not found");
            } catch (IOException ex) {
                System.out.println("Error reading file '" + Input_fileName + "'");
            }
        }

    }



