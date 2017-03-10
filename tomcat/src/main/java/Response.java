import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.util.Arrays;

/**
 * Created by admin on 2017/3/10.
 */
public class Response {

    private HttpExchange httpExchange;

    private OutputStream outputStream;
    private Request request;
    private long length;

    public Response() {

    }

    public Response(HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
        this.outputStream = httpExchange.getResponseBody();
    }

    public void sendStaticResource(){
        File file = new File(Bootstrap.WEB_ROOT+"tomcat/src/main/"+request.getUri());
        if (!file.exists()){
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            httpExchange.sendResponseHeaders(200,file.length());
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[4096];
            int index = 0;
            while ((index = bufferedInputStream.read(buffer))!=-1){
                length  =length+index;
                System.out.println("index:"+index);
                outputStream.write(Arrays.copyOf(buffer, index));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedInputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        length = file.length();

    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

}
