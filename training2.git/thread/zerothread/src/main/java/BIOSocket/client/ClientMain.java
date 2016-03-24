package BIOSocket.client;

/**
 * Created by gongxijun on 16-3-24.
 */
public class ClientMain {


    public static  void main(String [] args){

        int clients =12;
        ClientSocket[]  cs = new ClientSocket[12];
        while (clients > 0) {

            cs[--clients] = new ClientSocket("127.0.0.1",9999);
            cs[clients].sendMessage(clients);
        }
    }
}
