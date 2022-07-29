package Gemini;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.LogManager;


public class Assignment {

    public static int frequency(String[] ar, String w)
    {
        int c=0;
        for(int i=0;i<ar.length;i++)
        {
            if(w.equals(ar[i]))
            {
                c++;
            }
        }
        return c;
    }

    public static HashMap<String,Integer> frequency(String[] arr)
    {
        HashMap<String, Boolean> processed= new HashMap<>();
        HashMap<String,Integer> pair=new HashMap<>();
        for(String a:arr)
        {
            int count=0;
            if(!processed.containsKey(a)) {
                for (int i = 0; i < arr.length; i++) {
                    if (a.equals(arr[i])) {
                        count++;
                    }
                }
                processed.put(a, true);
                pair.put(a, count);
            }
        }
        return pair;
    }

    public static void main(String[] args) throws IOException
    {
        try
        {   LogManager.getLogManager().reset();

            Log syslog =new Log("log.log");

            try(FileReader reader=new FileReader("config.properties"))
            {
                Properties pr =new Properties();
                syslog.logger.info("FileReader and Properties object created.");
                pr.load(reader);
                syslog.logger.info("Properties file loaded");
                String path=pr.getProperty("path");
                String word=pr.getProperty("word");


                File inp=new File(path);
                syslog.logger.info("File obj created.");
                try{
                    String str="";
                    Scanner sc= new Scanner(inp);
                    syslog.logger.info("Scanner object created.");
                    while(sc.hasNextLine())
                    {
                        String line =sc.nextLine();
                        str+=line+" ";
                    }
                    syslog.logger.info("Data converted to string successfully");
                    String[] arr=str.split(" ");
                    syslog.logger.info("String conversion to array successful");

                    for(int i=0;i< arr.length;i++)
                    {
                        if(word.equals(arr[i]))
                        {
                            System.out.println(word+":"+frequency(arr,word));
                            syslog.logger.info("Word found and method call completed.");
                            syslog.logger.info("done");
                            syslog.logger.info("____________________________");
                            return;
                        }
                        else
                        {
                            System.out.println(frequency(arr));
                            syslog.logger.info("Word not found and method call completed.");
                            syslog.logger.info("done");
                            syslog.logger.info("_____________________");
                            return;
                        }
                    }

                    sc.close();
                    syslog.logger.info("File closed");

                }
                catch(Exception e)
                {
                    System.out.println("File not found");
                    e.getStackTrace();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}