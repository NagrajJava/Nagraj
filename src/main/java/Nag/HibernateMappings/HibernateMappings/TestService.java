package Nag.HibernateMappings.HibernateMappings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface TestService {

	List<TestDto> getUsers(int page, int limit) throws FileNotFoundException, IOException;

	public void convertingToExcelData() throws FileNotFoundException, IOException;

}
