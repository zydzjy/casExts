package casExts;

import org.apereo.cas.authentication.AuthenticationEventExecutionPlan;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlanConfigurer;
import org.apereo.cas.authentication.AuthenticationHandler;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.services.ServicesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration("MyAuthenticationEventExecutionPlanConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class MyAuthenticationEventExecutionPlanConfiguration
                    implements AuthenticationEventExecutionPlanConfigurer {
    @Autowired
    private CasConfigurationProperties casProperties;

    @Bean
    public AuthenticationHandler myAuthenticationHandler() {
    	String name = "";
    	ServicesManager servicesManager = null; 
		PrincipalFactory principalFactory = null;
		Integer order = 1;
        final MyAuthenticationHandler handler = new MyAuthenticationHandler(
        		name, servicesManager,principalFactory,order);
        /*
            Configure the handler by invoking various setter methods.
            Note that you also have full access to the collection of resolved CAS settings.
            Note that each authentication handler may optionally qualify for an 'order`
            as well as a unique name.
        */
        return handler;
    }

	public void configureAuthenticationExecutionPlan(AuthenticationEventExecutionPlan plan) {
		//if (feelingGoodOnASundayMorning()) {
            plan.registerAuthenticationHandler(myAuthenticationHandler());
        //}
	}
}