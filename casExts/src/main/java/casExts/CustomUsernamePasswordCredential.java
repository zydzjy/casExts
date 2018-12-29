package casExts;

import org.apache.commons.lang3.StringUtils;
import org.apereo.cas.authentication.credential.UsernamePasswordCredential;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;

@SuppressWarnings("serial")
public class CustomUsernamePasswordCredential extends UsernamePasswordCredential {
	private String captcha;
	 
	public String getCaptcha() {
		return captcha;
	}
 
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	public void validate(final ValidationContext context) {
		super.validate(context);
		MessageContext messages = context.getMessageContext();
        if (StringUtils.isBlank(this.captcha)) {
            messages.addMessage(new MessageBuilder()
                .error()
                .source("username")
                .code("username.required")
                .build());
        }
	}
}
