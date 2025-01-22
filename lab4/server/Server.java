
import java.io.*;
import java.net.*;

public class Server {

    @SuppressWarnings({"ConvertToTryWithResources", "CallToPrintStackTrace"})
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running and waiting for a client connection...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String input = in.readLine();
            int number = Integer.parseInt(input);

            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            out.println("The factorial of " + number + " is " + factorial);

            System.out.println("Processed factorial for number: " + number);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
