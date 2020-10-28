import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPServer {
    public static void main(String args[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        Scanner in = new Scanner(System.in);
        ServerSocket welcomeSocket = new ServerSocket(in.nextInt());
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(
                            connectionSocket.getInputStream()));
            DataOutputStream outToClient =
                    new DataOutputStream(
                            connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);
            System.out.println("The number is: " + clientSentence + " from client "  + connectionSocket.getLocalAddress() + " on port " + connectionSocket.getPort() + "\n");
        }
    }
}
