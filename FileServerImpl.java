import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
public class FileServerImpl extends UnicastRemoteObject implements FileServerIntf  {
	public FileServerImpl() throws RemoteException {
	}

	public File[] listfiles(String inp) throws RemoteException
	 {
			File folder = new File("/home/chaitrali/Downloads/");

			File[] listOfFiles = folder.listFiles();
			return listOfFiles;
	 }

	 public byte[] download(String filename) throws RemoteException
	 {
		 byte [] mydata;

 	 	File pathfile = new File("/home/chaitrali/Downloads/"+filename);
		 mydata=new byte[(int) pathfile.length()];
		 FileInputStream in;
		 try {
			 in = new FileInputStream(pathfile);
			 try {
				 in.read(mydata, 0, mydata.length);
			 } catch (IOException e) {

				 e.printStackTrace();
			 }
			 try {
				 in.close();
			 } catch (IOException e) {

				 e.printStackTrace();
			 }

		 } catch (FileNotFoundException e) {

			 e.printStackTrace();
		 }

		 return mydata;
	 }
}
