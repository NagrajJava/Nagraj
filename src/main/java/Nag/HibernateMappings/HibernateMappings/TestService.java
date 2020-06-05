package Nag.HibernateMappings.HibernateMappings;

import java.util.List;

public interface TestService {

	List<TestDto> getUsers(int page, int limit);

}
