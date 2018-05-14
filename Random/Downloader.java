package org.vpz.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loader")
public class Downloader extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final Logger logger =Logger.getLogger(Downloader.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.getWriter().append("Served at: ").append(request.getContextPath());
	String address = request.getParameter("resloc");

	Runnable r = new Runnable() {
	    @Override
	    public void run() {
		try {
		    download(address);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	};
	Thread t = new Thread(r);
	t.start();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

    public void download(String address) throws Exception {
	// trust SSL certs--vpz
	TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
	    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		return null;
	    }

	    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
	    }

	    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
	    }
	} };

	try {
	    SSLContext sc = SSLContext.getInstance("SSL");
	    sc.init(null, trustAllCerts, new java.security.SecureRandom());
	    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	} catch (Exception e) {
	}

	// downloadder
	URL url = new URL(address);
	InputStream is = null;
	FileOutputStream fos = null;

	String str = url.getFile();
	str = str.replaceAll("([a-z,A-Z])*(/)", "");
	str = "D:/" + str;

	fos = new FileOutputStream(str);// vpz

	try {
	    URLConnection urlConn = url.openConnection();
	    is = urlConn.getInputStream();
	    // fos = new FileOutputStream(""); // vpz
	    byte[] buffer = new byte[4096]; // declare 4KB buffer
	    int len;
	    while ((len = is.read(buffer)) > 0) {
		fos.write(buffer, 0, len);
	    }
	} finally {
	    try {
		if (is != null) {
		    is.close();
		    // System.out.println("Instream closed.");
		}
	    } finally {
		if (fos != null) {
			fos.flush();//later -- vpz
		    fos.close();
		    // System.out.println("Outstream closed.");
		}
	    }
	}
    }
}
