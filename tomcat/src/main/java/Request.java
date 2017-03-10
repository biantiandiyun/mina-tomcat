import com.sun.net.httpserver.HttpExchange;

import javax.servlet.*;
import java.io.*;
import java.net.URI;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * Created by admin on 2017/3/10.
 */
public class Request implements ServletRequest {

    private ServletInputStream inputStream;
    private HttpExchange httpExchange;
    private URI uri;

    public void parse(){
        byte[] buffer = new byte[4096];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new MyServletInputStream(inputStream));
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
    public Request(HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
        this.inputStream = new MyServletInputStream(httpExchange.getRequestBody());
    }
    public Request() {

    }

    public Object getAttribute(String name) {
        return null;
    }

    public Enumeration<String> getAttributeNames() {
        return null;
    }

    public String getCharacterEncoding() {
        return null;
    }

    public void setCharacterEncoding(String env) throws UnsupportedEncodingException {

    }

    public int getContentLength() {
        return 0;
    }

    public long getContentLengthLong() {
        return 0;
    }

    public String getContentType() {
        return null;
    }

    public ServletInputStream getInputStream() {
        return inputStream;
    }

    public String getParameter(String name) {
        return null;
    }

    public Enumeration<String> getParameterNames() {
        return null;
    }

    public String[] getParameterValues(String name) {
        return new String[0];
    }

    public Map<String, String[]> getParameterMap() {
        return null;
    }

    public String getProtocol() {
        return null;
    }

    public String getScheme() {
        return null;
    }

    public String getServerName() {
        return null;
    }

    public int getServerPort() {
        return 0;
    }

    public BufferedReader getReader() throws IOException {
        return null;
    }

    public String getRemoteAddr() {
        return httpExchange.getRemoteAddress().toString();
    }

    public String getRemoteHost() {
        return httpExchange.getRemoteAddress().getHostName();
    }

    public void setAttribute(String name, Object o) {

    }

    public void removeAttribute(String name) {

    }

    public Locale getLocale() {
        return null;
    }

    public Enumeration<Locale> getLocales() {
        return null;
    }

    public boolean isSecure() {
        return false;
    }

    public RequestDispatcher getRequestDispatcher(String path) {
        return null;
    }

    public String getRealPath(String path) {
        return null;
    }

    public int getRemotePort() {
        return httpExchange.getRemoteAddress().getPort();
    }

    public String getLocalName() {
        return null;
    }

    public String getLocalAddr() {
        return null;
    }

    public int getLocalPort() {
        return 0;
    }

    public ServletContext getServletContext() {
        return null;
    }

    public AsyncContext startAsync() throws IllegalStateException {
        return null;
    }

    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return null;
    }

    public boolean isAsyncStarted() {
        return false;
    }

    public boolean isAsyncSupported() {
        return false;
    }

    public AsyncContext getAsyncContext() {
        return null;
    }

    public DispatcherType getDispatcherType() {
        return null;
    }

    public void setInputStream(ServletInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
