import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by admin on 2017/3/10.
 */
public class Request {
    private InputStream inputStream;
    private URI uri;

    public void parse(){
        byte[] buffer = new byte[4096];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        StringBuffer stringBuffer = new StringBuffer();

        try {
            while (bufferedInputStream.read(buffer)!=-1){
                stringBuffer.append(new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("request:"+stringBuffer);
    }

//    private String parseUri(String requestUri){
//        return null;
//    }
    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    public Request() {

    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
