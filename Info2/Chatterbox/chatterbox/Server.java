package chatterbox;

import java.io.*;
import java.util.Scanner;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;

public class Server implements Runnable {

	private Socket socket;

	public Server (Socket s)
	{
		socket = s;
	}
	
	
	public void run() {
		
		try
		{
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			while(true)
			{
				if (in.hasNext())
				{
					String input = in.nextLine();
					System.out.println("Client sagt: " + input);
					out.println("Du sagst: " + input);
					out.flush();				
				}
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	
        public static void main (String[] args) throws IOException {
		
		try {
			
			
			ServerSocket server = new ServerSocket(5555);
			System.out.println("Server gestartet!");
			System.out.println("Warten auf Clients...");
			
			while (true)
			{
				Socket client = server.accept();
				System.out.println("Client verbunden: " + client.getLocalAddress().getHostName());
				
				OutputStream out = client.getOutputStream();
				PrintWriter writer = new PrintWriter(out);
				
				InputStream in = client.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				
				Server chat = new Server(client);
				Thread t = new Thread(chat);
				t.start();
			}
		}
		catch (Exception e) 
		{
			System.out.println("Fehler.");
			e.printStackTrace();
		}
    }
        
}
			
