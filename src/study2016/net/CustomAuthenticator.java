package study2016.net;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;

/**
 * 自定义认证
 * @author liaokangli
 *
 */
public class CustomAuthenticator extends Authenticator{
	
	protected PasswordAuthentication getPasswordAuthentication() {
		// Get information about the request
		String prompt = getRequestingPrompt();
		String hostname = getRequestingHost();
		InetAddress ipaddr = getRequestingSite();
		int port = getRequestingPort();

		String username = "username";
		String password = "password";

		// Return the information (a data holder that is used by Authenticator)
		return new PasswordAuthentication(username, password.toCharArray());
	}

}
