/*
Aditi Sodagar- S11194519
Karan Parmar- S11198967
 */

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    public String choice;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(),true);;
    }


    //thread strarts
    @Override
    public synchronized void run() {
        try {
            while(socket.isConnected()) {

                if(in.readLine() != null) {

                    choice = in.readLine();//read button input from client


                    //if thread is player 1
                    if(Thread.currentThread().getName()=="Player1")
                    {
                        Server.p1Choice = choice;
                        System.out.println("Client handler p1: " + Server.p1Choice);

                    }

                    //if thread is player 2
                    else if(Thread.currentThread().getName()=="Player2")
                    {
                        Server.p2Choice = choice;
                        System.out.println("Client handler p2: " + Server.p2Choice);
                        if(Server.round2 == true)
                        {
                            Server.Round2();
                            Server.round2 = false;
                        }
                    }

                    //if thread is player 3
                    else if(Thread.currentThread().getName()=="Player3" && Server.round2 == false)
                    {
                        Server.p3Choice = choice;
                        System.out.println("Client handler p3: " + Server.p3Choice);

                    }

                    //win function
                    Server.win();


                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

