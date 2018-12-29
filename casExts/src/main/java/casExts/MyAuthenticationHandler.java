package casExts;

import java.security.GeneralSecurityException;

import javax.security.auth.login.FailedLoginException;

import org.apereo.cas.authentication.AuthenticationHandlerExecutionResult;
import org.apereo.cas.authentication.PreventedException;
import org.apereo.cas.authentication.credential.UsernamePasswordCredential;
import org.apereo.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.services.ServicesManager;

public class MyAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

	public MyAuthenticationHandler(String name, ServicesManager servicesManager, PrincipalFactory principalFactory,
			Integer order) {
		super(name, servicesManager, principalFactory, order);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected AuthenticationHandlerExecutionResult authenticateUsernamePasswordInternal(
			UsernamePasswordCredential credential, String originalPassword)
			throws GeneralSecurityException, PreventedException {
		// TODO Auto-generated method stub
		System.out.println("authencation here........................");
		String username = credential.getUsername();
		String password = credential.getPassword();
		System.out.println("originalPassword:"+originalPassword);
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		if (_auth(username,password,originalPassword)) {
			return createHandlerResult(credential,
                    this.principalFactory.createPrincipal(username));
        }
        throw new FailedLoginException("Sorry, you have failed!");
	}

	private boolean _auth(String username, String password, String originalPassword) {
		return true;
	}

}
