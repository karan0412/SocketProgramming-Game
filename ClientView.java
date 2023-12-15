/*
Aditi Sodagar- S11194519
Karan Parmar- S11198967
 */

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ClientView extends JFrame {
    private JPanel MainPane;
    private JButton rockBtn;
    private JButton paperBtn;
    private JButton scissorsBtn;
    private JButton lizardBtn;
    private JButton spockBtn;
    private JLabel player1Choice;
    private JLabel playerChoice;
    private JLabel player2Choice;
    private JButton exitBtn;
    private JLabel Result;
    // private JButton button1;
    private static Socket socket;
    private static String Pchoice = null;
    private static ObjectInputStream result;
    private static ObjectInputStream choice1;
    private static ObjectInputStream choice2;


    //Function for sound on click
    private void soundClick()
    {
        try
        {
            File sound = new File("C:\\Users\\Karan1\\Desktop\\CS218_A1\\src\\sound\\clickSound.wav");
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(sound));
            c.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public ClientView() {


        //On action for rockBtn
        rockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soundClick();
                Pchoice = "Rock";
                playerChoice.setText(Pchoice);
                try {
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                    printWriter.println(Pchoice);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //On action for paperBtn
        paperBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soundClick();
                Pchoice = "Paper";
                playerChoice.setText(Pchoice);
                try {
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                    printWriter.println(Pchoice);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //On action for scissorsBtn
        scissorsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soundClick();
                Pchoice = "Scissors";
                playerChoice.setText(Pchoice);
                try {
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                    printWriter.println(Pchoice);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //On action for lizardBtn
        lizardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soundClick();
                Pchoice = "Lizard";
                playerChoice.setText(Pchoice);
                try {
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                    printWriter.println(Pchoice);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //On action for spockBtn
        spockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soundClick();
                Pchoice = "Spock";
                playerChoice.setText(Pchoice);
                try {
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                    printWriter.println(Pchoice);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    //Function to print result
        public void setupRes(String choice) throws IOException {
            System.out.println(choice);

                Result.setText(choice);


    }

    //Function to print other player's choice
    public void setupC1(String choice) throws IOException {
        System.out.println(choice);

            player1Choice.setText(choice);

    }

    //Function to print other player's choice
    public void setupC2(String choice) throws IOException {
        System.out.println(choice);

            player2Choice.setText(choice);

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientView frame = new ClientView();
        frame.setTitle("Rock Paper Scissors Lizard Spock");
        frame.setVisible(true);
        frame.setSize(700, 400);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setContentPane(frame.MainPane);
        socket = new Socket("localhost", 3000);

        //Sends button choice to server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(Pchoice);
        while(socket.isConnected()) {

            //gets result from server
            result = new ObjectInputStream(socket.getInputStream());
            Packet recvResult = (Packet) result.readObject();
            frame.setupRes(recvResult.choice);
            if(!recvResult.choice.equals("Get ready for round 2")) {
                //Gets other players' choices from servers
                choice1 = new ObjectInputStream(socket.getInputStream());
                Packet c1 = (Packet) choice1.readObject();
                frame.setupC1(c1.choice);
                choice2 = new ObjectInputStream(socket.getInputStream());
                Packet c2 = (Packet) choice2.readObject();
                frame.setupC2(c2.choice);
            }
        }
    }
}







