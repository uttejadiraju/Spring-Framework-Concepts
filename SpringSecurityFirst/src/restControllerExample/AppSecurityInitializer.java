package restControllerExample;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class AppSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public AppSecurityInitializer() {
        super(AppConfig.class);
    }
}