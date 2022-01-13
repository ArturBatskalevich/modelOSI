import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        System.out.println("server started");
        int port = 3428;

        String adult = "Welcome to the adult zone, %s Have a good rest, or a good working day!";
        String child = "Welcome to the kids area, %s Let's play!";

        while (true) {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                out.println("Write your name");
                String nameClient = in.readLine();
                out.println("Are you child? (yes/no)");
                String childYesOrNo = in.readLine();

                switch (childYesOrNo){
                    case "yes":
                        out.println(String.format(child,nameClient));
                        break;
                    case "no" :
                        out.println(String.format(adult,nameClient));
                        break;
                    default:
                        out.println("Некорректные данные");
                }

                System.out.printf("New connection accepted. Port: %d%n",clientSocket.getPort());
                final String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d",name,clientSocket.getPort()));
                serverSocket.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
