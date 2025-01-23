
import java.io.*;
import java.net.*;

public class TCPServer {

    @SuppressWarnings({"CallToPrintStackTrace", "ConvertToTryWithResources"})
    public static void main(String[] args) {
        try {
           
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            int num1 = input.readInt();
            int num2 = input.readInt();

            int greatest = Math.max(num1, num2);

            output.writeInt(greatest);

            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
