package chatterbox;

import java.io.*;
import java.util.Scanner;
import java.net.Socket;
import java.net.UnknownHostException;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.util.Scanner;
//import java.net.ServerSocket;
//import java.net.SocketAddress;

public class Client implements Runnable {
	
	private Socket socket;
	
	
	public Client (Socket s)
	{
		socket = s;
	}

      public void run() {
		
		try{
			
		  Scanner eingabe = new Scanner (System.in);
		  Scanner in = new Scanner (socket.getInputStream());
		  PrintWriter out = new PrintWriter(socket.getOutputStream());
		  
		  while (true)
		  {
			  String input = eingabe.nextLine();
			  out.println(input);	
			  out.flush();
			  
			  if(in.hasNext())
					System.out.println(in.nextLine());
			  
		  }
		}
		
		
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) throws IOException
	{
		try
		{
			Socket s = new Socket("localhost", 5555);
			System.out.println("Sie sind verbunden mit : " +  "localhost");
			
			OutputStream out = s.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			
			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			Client client = new Client (s);
			
			Thread t = new Thread(client);
			t.start();
		}
		
		catch (Exception noServer)
		{
			System.out.println("Konnte nicht mit Server verbunden werden.");
			System.out.println("Bitte versuchen Sie es später nocheinmal.");
		}
		
	}

}
