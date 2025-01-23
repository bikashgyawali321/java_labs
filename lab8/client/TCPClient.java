
import java.io.*;
import java.net.*;

public class TCPClient {

    @SuppressWarnings({"CallToPrintStackTrace", "ConvertToTryWithResources"})
    public static void main(String[] args) {
        try {

            Socket socket = new Socket("localhost", 12345);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            int num1 = 25;
            int num2 = 50;

            System.out.println("Sending numbers to the server: " + num1 + ", " + num2);

            output.writeInt(num1);
            output.writeInt(num2);

            int greatest = input.readInt();
            System.out.println("The greatest number received from the server: " + greatest);

            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
