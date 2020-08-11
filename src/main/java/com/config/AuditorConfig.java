import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class AuditorConfig implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of(System.getProperty("user.name"));
	}
}
