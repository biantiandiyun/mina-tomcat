import com.sun.net.httpserver.HttpExchange;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by admin on 2017/3/10.
 */
public class Response implements ServletResponse {

    private HttpExchange httpExchange;

    private ServletOutputStream outputStream;
    private Request request;
    private long length;
    private PrintWriter writer;

    public Response() {

    }

    public Response(HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
        this.outputStream = new MyServletOutputStream(httpExchange.getResponseBody());
    }

    public void sendResponseHeaders(){
        try {
            httpExchange.sendResponseHeaders(200,length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendStaticResource() {
        File file = new File(Bootstrap.WEB_ROOT + request.getUri());
        if (!file.exists()) {
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        try {

            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            BufferedReader br = new BufferedReader(new InputStreamReader(bufferedInputStream, "utf-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                stringBuffer.append(tmp);
            }
            this.length = file.length();
            sendResponseHeaders();
            getWriter().print(stringBuffer.toString());
            getWriter().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getCharacterEncoding() {
        return null;
    }

    public String getContentType() {
        return null;
    }

    public ServletOutputStream getOutputStream() {
        return null;
    }

    public PrintWriter getWriter() throws IOException {
        writer = new PrintWriter(outputStream, true);
        return writer;
    }

    public void setCharacterEncoding(String charset) {

    }

    public void setContentLength(int len) {

    }

    public void setContentLengthLong(long len) {

    }

    public void setContentType(String type) {

    }

    public void setBufferSize(int size) {

    }

    public int getBufferSize() {
        return 0;
    }

    public void flushBuffer() throws IOException {

    }

    public void resetBuffer() {

    }

    public boolean isCommitted() {
        return false;
    }

    public void reset() {

    }

    public void setLocale(Locale loc) {

    }

    public Locale getLocale() {
        return null;
    }

    public void setOutputStream(ServletOutputStream outputStream) {
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
