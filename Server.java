/*
Aditi Sodagar- S11194519
Karan Parmar- S11198967
 */

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//Server class
public class Server{
    //Declaration of 3 threads
    public static Thread thread1;
    public static Thread thread2;
    public static Thread thread3;

    //Declaration of game elements
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";
    private static final String LIZARD = "Lizard";
    private static final String SPOCK = "Spock";

    //Declaring the 3 players
    public static String p1Choice = null;
    public static String p2Choice = null;
    public static String p3Choice = null;



    public ServerSocket serverSocket;//Declaring server socket

    //Declaring the 3 sockets
    public static Socket socket1;
    public static Socket socket2;
    public static Socket socket3;
    public static boolean round2 = false;//Determines round 2 if 2 players win


    //Function for background music
    private static void backgroundMusic()
    {
        try{
            File sound = new File("C:\\Users\\Karan1\\Desktop\\CS218_A1\\src\\sound\\soundBackground.wav");
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(sound));
            c.start();
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Concstructor for server socket
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }


    //If player 1 wins
    public static void player1Win() throws IOException {

        System.out.println("Player 1 win");

        //Sending result to all socket
        Packet packet1 = new Packet("You win");
        ObjectOutputStream outputStream1 = new ObjectOutputStream(socket1.getOutputStream());
        outputStream1.writeObject(packet1);
        Packet packet2 = new Packet("You lose");
        ObjectOutputStream outputStream2 = new ObjectOutputStream(socket2.getOutputStream());
        outputStream2.writeObject(packet2);
        Packet packet3 = new Packet("You lose");
        ObjectOutputStream outputStream3 = new ObjectOutputStream(socket3.getOutputStream());
        outputStream3.writeObject(packet3);

        Packet choice2 = new Packet(p2Choice);
        Packet choice1 = new Packet(p1Choice);
        Packet choice3 = new Packet(p3Choice);

        //sending choices to socket1
        ObjectOutputStream choice1Socket1 = new ObjectOutputStream(socket1.getOutputStream());
        choice1Socket1.writeObject(choice2);
        ObjectOutputStream choice2Socket1 = new ObjectOutputStream(socket1.getOutputStream());
        choice2Socket1.writeObject(choice3);
        //sending choices to socket2
        ObjectOutputStream choice1Socket2 = new ObjectOutputStream(socket2.getOutputStream());
        choice1Socket2.writeObject(choice1);
        ObjectOutputStream choice2Socket2 = new ObjectOutputStream(socket2.getOutputStream());
        choice2Socket2.writeObject(choice3);

        //sending choices to socket3
        ObjectOutputStream choice1Socket3 = new ObjectOutputStream(socket3.getOutputStream());
        choice1Socket3.writeObject(choice1);
        ObjectOutputStream choice2Socket3 = new ObjectOutputStream(socket3.getOutputStream());
        choice2Socket3.writeObject(choice2);

        Server.p1Choice = null;
        Server.p2Choice = null;
        Server.p3Choice = null;
    }

    //Function for draw
    public static void draw() throws IOException {
        System.out.println("Draws");

        //Sending result to all socket
        Packet packet1 = new Packet("Draws");
        ObjectOutputStream outputStream1 = new ObjectOutputStream(socket1.getOutputStream());
        outputStream1.writeObject(packet1);
        Packet packet2 = new Packet("Draws");
        ObjectOutputStream outputStream2 = new ObjectOutputStream(socket2.getOutputStream());
        outputStream2.writeObject(packet2);
        Packet packet3 = new Packet("Draw");
        ObjectOutputStream outputStream3 = new ObjectOutputStream(socket3.getOutputStream());
        outputStream3.writeObject(packet3);

        Packet choice2 = new Packet(p2Choice);
        Packet choice1 = new Packet(p1Choice);
        Packet choice3 = new Packet(p3Choice);

        //sending choices to socket1
        ObjectOutputStream choice1Socket1 = new ObjectOutputStream(socket1.getOutputStream());
        choice1Socket1.writeObject(choice2);
        ObjectOutputStream choice2Socket1 = new ObjectOutputStream(socket1.getOutputStream());
        choice2Socket1.writeObject(choice3);
        //sending choices to socket2
        ObjectOutputStream choice1Socket2 = new ObjectOutputStream(socket2.getOutputStream());
        choice1Socket2.writeObject(choice1);
        ObjectOutputStream choice2Socket2 = new ObjectOutputStream(socket2.getOutputStream());
        choice2Socket2.writeObject(choice3);

        //sending choices to socket3
        ObjectOutputStream choice1Socket3 = new ObjectOutputStream(socket3.getOutputStream());
        choice1Socket3.writeObject(choice1);
        ObjectOutputStream choice2Socket3 = new ObjectOutputStream(socket3.getOutputStream());
        choice2Socket3.writeObject(choice2);
        Server.p1Choice = null;
        Server.p2Choice = null;
        Server.p3Choice = null;
    }

    //Function if player 2 wins
    public static void player2Win() throws IOException {
        System.out.println("Player 2 win");

        //Sending result to all socket
        Packet packet1 = new Packet("You lose");
        ObjectOutputStream outputStream1 = new ObjectOutputStream(socket1.getOutputStream());
        outputStream1.writeObject(packet1);
        Packet packet2 = new Packet("You win");
        ObjectOutputStream outputStream2 = new ObjectOutputStream(socket2.getOutputStream());
        outputStream2.writeObject(packet2);
        Packet packet3 = new Packet("You lose");
        ObjectOutputStream outputStream3 = new ObjectOutputStream(socket3.getOutputStream());
        outputStream3.writeObject(packet3);

        Packet choice2 = new Packet(p2Choice);
        Packet choice1 = new Packet(p1Choice);
        Packet choice3 = new Packet(p3Choice);

        //sending choices to socket1
        ObjectOutputStream choice1Socket1 = new ObjectOutputStream(socket1.getOutputStream());
        choice1Socket1.writeObject(choice2);
        ObjectOutputStream choice2Socket1 = new ObjectOutputStream(socket1.getOutputStream());
        choice2Socket1.writeObject(choice3);
        //sending choices to socket2
        ObjectOutputStream choice1Socket2 = new ObjectOutputStream(socket2.getOutputStream());
        choice1Socket2.writeObject(choice1);
        ObjectOutputStream choice2Socket2 = new ObjectOutputStream(socket2.getOutputStream());
        choice2Socket2.writeObject(choice3);

        //sending choices to socket3
        ObjectOutputStream choice1Socket3 = new ObjectOutputStream(socket3.getOutputStream());
        choice1Socket3.writeObject(choice1);
        ObjectOutputStream choice2Socket3 = new ObjectOutputStream(socket3.getOutputStream());
        choice2Socket3.writeObject(choice2);
        Server.p1Choice = null;
        Server.p2Choice = null;
        Server.p3Choice = null;

    }

    //Function if player 3 wins
    public static void player3Win() throws IOException {
        System.out.println("Player 3 win");

        //Sending result to all socket
        Packet packet1 = new Packet("You lose");
        ObjectOutputStream outputStream1 = new ObjectOutputStream(socket1.getOutputStream());
        outputStream1.writeObject(packet1);
        Packet packet2 = new Packet("You lose");
        ObjectOutputStream outputStream2 = new ObjectOutputStream(socket2.getOutputStream());
        outputStream2.writeObject(packet2);
       Packet packet3 = new Packet("You win");
       ObjectOutputStream outputStream3 = new ObjectOutputStream(socket3.getOutputStream());
       outputStream3.writeObject(packet3);

        Packet choice2 = new Packet(p2Choice);
        Packet choice1 = new Packet(p1Choice);
        Packet choice3 = new Packet(p3Choice);

        //sending choices to socket1
        ObjectOutputStream choice1Socket1 = new ObjectOutputStream(socket1.getOutputStream());
        choice1Socket1.writeObject(choice2);
        ObjectOutputStream choice2Socket1 = new ObjectOutputStream(socket1.getOutputStream());
        choice2Socket1.writeObject(choice3);
        //sending choices to socket2
        ObjectOutputStream choice1Socket2 = new ObjectOutputStream(socket2.getOutputStream());
        choice1Socket2.writeObject(choice1);
        ObjectOutputStream choice2Socket2 = new ObjectOutputStream(socket2.getOutputStream());
        choice2Socket2.writeObject(choice3);

        //sending choices to socket3
        ObjectOutputStream choice1Socket3 = new ObjectOutputStream(socket3.getOutputStream());
        choice1Socket3.writeObject(choice1);
        ObjectOutputStream choice2Socket3 = new ObjectOutputStream(socket3.getOutputStream());
        choice2Socket3.writeObject(choice2);
        Server.p1Choice = null;
        Server.p2Choice = null;
        Server.p3Choice = null;

    }

    //Function if there is a round 2
    public static void setRound2() throws IOException {
        System.out.println("Get ready for round 2");
        Packet getReady = new Packet("Get ready for round 2");

        //sending choices to socket1
        ObjectOutputStream choice1Socket1 = new ObjectOutputStream(socket1.getOutputStream());
        choice1Socket1.writeObject(getReady);

        //sending choices to socket2
        ObjectOutputStream choice1Socket2 = new ObjectOutputStream(socket2.getOutputStream());
        choice1Socket2.writeObject(getReady);

        //sending choices to socket3
        ObjectOutputStream choice1Socket3 = new ObjectOutputStream(socket3.getOutputStream());
        choice1Socket3.writeObject(getReady);
        Server.p1Choice = null;
        Server.p2Choice = null;
        Server.p3Choice = null;
    }

    //Function to determine the winner
    public static void win() throws IOException {//Function compensates for 3 players
        while (p2Choice != null && p1Choice != null && p3Choice != null)
        {
            if (p1Choice.equals(p2Choice) && p1Choice.equals(p3Choice) && p2Choice.equals(p3Choice)) {
                draw();
                return;
            }

            if (p1Choice.equals(ROCK))
            {
                if (p2Choice.equals(ROCK))
                {
                    if (p3Choice.equals(PAPER))
                    {
                        player3Win();
                        return;
                    }
                    else if (p3Choice.equals(SCISSORS))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(LIZARD))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(SPOCK))
                    {
                        player3Win();
                        return;
                    }
                }
                else if (p2Choice.equals(PAPER))
                {
                    if (p3Choice.equals(ROCK))
                    {
                        player2Win();
                        return;
                    }
                    else if (p3Choice.equals(PAPER))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(SCISSORS))
                {
                    if (p3Choice.equals(SCISSORS))
                    {
                        player1Win();
                        return;
                    }
                    else if (p3Choice.equals(ROCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(LIZARD))
                {
                    if (p3Choice.equals(LIZARD))
                    {
                        player1Win();
                        return;
                    }
                    else if (p3Choice.equals(ROCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(SPOCK))
                {
                    if (p3Choice.equals(ROCK))
                    {
                        player2Win();
                        return;
                    }
                    else if (p3Choice.equals(SPOCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
            }

            else if (p1Choice.equals(PAPER))
            {
                if (p2Choice.equals(PAPER))
                {
                    if (p3Choice.equals(ROCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(SCISSORS))
                    {
                        player3Win();
                        return;
                    }
                    else if (p3Choice.equals(LIZARD))
                    {
                        player3Win();
                        return;
                    }
                    else if (p3Choice.equals(SPOCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                }
                else if (p2Choice.equals(ROCK))
                {
                    if (p3Choice.equals(ROCK))
                    {
                        player1Win();
                        return;
                    }
                    else if (p3Choice.equals(PAPER))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(SCISSORS))
                {
                    if (p3Choice.equals(SCISSORS))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(PAPER))
                    {
                        player2Win();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(LIZARD))
                {
                    if (p3Choice.equals(LIZARD))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(PAPER))
                    {
                        player2Win();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(SPOCK))
                {
                    if (p3Choice.equals(PAPER))
                    {
                        player2Win();
                        return;
                    }
                    else if (p3Choice.equals(SPOCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
            }

            else if (p1Choice.equals(SCISSORS))
            {
                if (p2Choice.equals(SCISSORS))
                {
                    if (p3Choice.equals(ROCK))
                    {
                        player3Win();
                        return;
                    }
                    else if (p3Choice.equals(PAPER))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(LIZARD))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(SPOCK))
                    {
                        player3Win();
                        return;
                    }
                }
                else if (p2Choice.equals(ROCK))
                {
                    if (p3Choice.equals(ROCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(SCISSORS))
                    {
                        player2Win();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(PAPER))
                {
                    if (p3Choice.equals(SCISSORS))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(PAPER))
                    {
                        player1Win();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(LIZARD))
                {
                    if (p3Choice.equals(LIZARD))
                    {
                        player1Win();
                        return;
                    }
                    else if (p3Choice.equals(SCISSORS))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(SPOCK))
                {
                    if (p3Choice.equals(SCISSORS))
                    {
                        player2Win();
                        return;
                    }
                    else if (p3Choice.equals(SPOCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
            }

            else if (p1Choice.equals(LIZARD))
            {
                if (p2Choice.equals(LIZARD))
                {
                    if (p3Choice.equals(ROCK))
                    {
                        player3Win();
                        return;
                    }
                    else if (p3Choice.equals(PAPER))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(SCISSORS))
                    {
                        player3Win();
                        return;
                    }
                    else if (p3Choice.equals(SPOCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                }
                else if (p2Choice.equals(ROCK))
                {
                    if (p3Choice.equals(ROCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(LIZARD))
                    {
                        player2Win();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(PAPER))
                {
                    if (p3Choice.equals(LIZARD))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(PAPER))
                    {
                        player1Win();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(SCISSORS))
                {
                    if (p3Choice.equals(LIZARD))
                    {
                        player2Win();
                        return;
                    }
                    else if (p3Choice.equals(SCISSORS))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(SPOCK))
                {
                    if (p3Choice.equals(LIZARD))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(SPOCK))
                    {
                        player1Win();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
            }

            else if (p1Choice.equals(SPOCK))
            {
                if (p2Choice.equals(SPOCK))
                {
                    if (p3Choice.equals(ROCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(PAPER))
                    {
                        player3Win();
                        return;
                    }
                    else if (p3Choice.equals(SCISSORS))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(LIZARD))
                    {
                        player3Win();
                        return;
                    }
                }
                else if (p2Choice.equals(ROCK))
                {
                    if (p3Choice.equals(ROCK))
                    {
                        player1Win();
                        return;
                    }
                    else if (p3Choice.equals(SPOCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(PAPER))
                {
                    if (p3Choice.equals(SPOCK))
                    {
                        player2Win();
                        return;
                    }
                    else if (p3Choice.equals(PAPER))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(SCISSORS))
                {
                    if (p3Choice.equals(SPOCK))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(SCISSORS))
                    {
                        player1Win();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
                else if (p2Choice.equals(LIZARD))
                {
                    if (p3Choice.equals(LIZARD))
                    {
                        round2 = true;
                        setRound2();
                        return;
                    }
                    else if (p3Choice.equals(SPOCK))
                    {
                        player2Win();
                        return;
                    }
                    else
                    {
                        draw();
                        return;
                    }
                }
            }

        }
    }

    //Function for round 2
    public static void Round2() throws IOException {
        while (p2Choice != null && p1Choice != null)
        {
            if (p1Choice.equals(p2Choice)) {
                draw();
                return;
            }
            if (p1Choice.equals(ROCK))
            {
                if (p2Choice.equals(PAPER))
                {
                    player2Win();
                    return;
                }
                else if (p2Choice.equals(SCISSORS))
                {

                    player1Win();
                    return;
                }
                else if (p2Choice.equals(LIZARD))
                {

                    player1Win();
                    return;
                }
                else if (p2Choice.equals(SPOCK))
                {

                    player2Win();
                    return;
                }
            }
            else if (p1Choice.equals(PAPER))
            {
                if (p2Choice.equals(ROCK))
                {
                    player1Win();
                    return;
                }
                else if (p2Choice.equals(SCISSORS))
                {

                    player2Win();
                    return;
                }
                else if (p2Choice.equals(LIZARD))
                {
                    player2Win();
                    return;
                }
                else if (p2Choice.equals(SPOCK))
                {
                    player1Win();
                    return;
                }
            }
            else if (p1Choice.equals(SCISSORS))
            {
                if (p2Choice.equals(ROCK))
                {

                    player2Win();
                    return;
                }
                else if (p2Choice.equals(PAPER))
                {
                    player1Win();
                    return;
                }
                else if (p2Choice.equals(LIZARD))
                {
                    player1Win();
                    return;
                }
                else if (p2Choice.equals(SPOCK))
                {

                    player2Win();
                    return;
                }

            }
            else if (p1Choice.equals(LIZARD))
            {
                if (p2Choice.equals(ROCK))
                {
                    player2Win();
                    return;
                }
                else if (p2Choice.equals(PAPER))
                {
                    player1Win();
                    return;
                }
                else if (p2Choice.equals(SCISSORS))
                {
                    player2Win();
                    return;
                }
                else if (p2Choice.equals(SPOCK))
                {
                    player1Win();
                    return;
                }
            }
            else if (p1Choice.equals(SPOCK))
            {
                if (p2Choice.equals(ROCK))
                {
                    player1Win();
                    return;
                }
                else if (p2Choice.equals(PAPER))
                {
                    player2Win();
                    return;
                }
                else if (p2Choice.equals(SCISSORS))
                {
                    player1Win();
                    return;
                }
                else if (p2Choice.equals(LIZARD))
                {
                    player2Win();
                    return;
                }
            }
        }

    }

    //Starts server
    public void startServer() throws IOException, InterruptedException {
        System.out.println("Waiting for the client");
        while (!serverSocket.isClosed()) {
            socket1 = serverSocket.accept();
            thread1 = new Thread(new ClientHandler(socket1),"Player1");

            socket2 = serverSocket.accept();
            thread2 = new Thread(new ClientHandler(socket2),"Player2");

            socket3 = serverSocket.accept();
            thread3 = new Thread(new ClientHandler(socket3),"Player3");

            while(socket1.isConnected() && socket2.isConnected() && socket3.isConnected()) {
                thread1.start();
                thread2.start();
                thread3.start();
                thread1.join();
                thread2.join();
                thread3.join();
            }

        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(3000);
        Server server = new Server(serverSocket);
        backgroundMusic();//Call background music function
        server.startServer();//Call start server function
        serverSocket.close();
    }

}


