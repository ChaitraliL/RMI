import java.io.*;
import java.rmi.*;
import java.util.*;

public class FileClient {

  public static void main(String args[]) throws Exception
  {
          Scanner sc = new Scanner(System.in);
					String fileServerURL = "rmi://127.0.0.1/FileServer";
					FileServerIntf fileServerIntf = (FileServerIntf)Naming.lookup(fileServerURL);

          String operation;
          do{
            System.out.println("\n\n\n\nMENU:");
            System.out.println("Enter 'list' to list files.");;
            System.out.println("Enter 'download' to download file.");
            operation = sc.nextLine();
            if(operation.equals("list")){
              File[] listOfFiles = fileServerIntf.listfiles("ss");
              String filel = "";
        			for (int i = 0; i < listOfFiles.length; i++) {
        			  if (listOfFiles[i].isFile()) {
        				filel+= System.getProperty("line.separator") +"File: " + listOfFiles[i].getName();
        			  } else if (listOfFiles[i].isDirectory()) {
        				filel += System.getProperty("line.separator") +"Directory: " + listOfFiles[i].getName();
        			  }
        			}
              System.out.println(filel);
            }

            else if(operation.equals("download")){
              System.out.println("enter the file you wanna download: ");
              String filename = sc.nextLine();

              				byte [] mydata = fileServerIntf.download(filename);
              				System.out.println("downloading...");
              				File clientpathfile = new File("/home/chaitrali/Desktop/"+filename);
              				FileOutputStream out=new FileOutputStream(clientpathfile);
              	    		out.write(mydata);
              				out.flush();
              out.close();
            }
            else {
              System.exit(0);
            }
          }while(!operation.equals("exit"));



                /*Scanner sc = new Scanner(System.in);

                System.out.print(">>>>");
                String inp = sc.next();
                String location = "local";

                while(!inp.equals("exit"))
                {


                        if(inp.equals("ls"))
                        {
                                if(location.equals("local"))
                                {
                                        System.out.println("Movies\nVideos");
                                }
                                else
                                {
		                        try {
		                        String fileServerURL = "rmi://" + location + "/FileServer";
		                        FileServerIntf fileServerIntf = (FileServerIntf)Naming.lookup(fileServerURL);

		                         //System.out.println("The first number is: " + args[1]);
		                         		//double d1 = Double.valueOf(args[1]).doubleValue();
		                         		//System.out.println("The second number is: " + args[2]);
		                        //double d2 = Double.valueOf(args[2]).doubleValue();
		                        //System.out.println("The sum is: " + addServerIntf.add(d1, d2));


		                        System.out.println(fileServerIntf.listfiles(inp));

		                        }

                                  	 catch (Exception e){
			                        System.out.println("Exception: " + e);
                         		}
                         	}
                 	}
                 	else if(inp.contains("cd"))
                 	{

                 	        if(inp.contains("Movies"))
				{

					location = "10.11.3.17";
				}
				else if(inp.contains("Videos"))
				{

					location = "127.0.0.1";
				}
                 	}

                 	System.out.print(">>>>");
                 	inp = sc.nextLine();
				}*/

         	/*
                Scanner sc = new Scanner(System.in);
                System.out.print(">>>>");
                String inp = sc.next();

                while(!inp.equals("exit"))
                {
                        try {
                        String fileServerURL = "rmi://" + args[0] + "/FileServer";
                        FileServerIntf fileServerIntf = (FileServerIntf)Naming.lookup(fileServerURL);

                        System.out.println(fileServerIntf.listfiles(inp));

                        }

                  	 catch (Exception e){
                                System.out.println("Exception: " + e);
         		}

                 	System.out.print(">>>>");
                 	inp = sc.next();
         	}*/
   }

}
