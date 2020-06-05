package Nag.HibernateMappings.HibernateMappings;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository userRepository;
   
    @Override
    public List<TestDto> getUsers(int page, int limit) {
        List<TestDto> returnValue = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(page, limit);
        Page<Test> users = userRepository.findAll(pageableRequest);
        List<Test> userEntities = users.getContent();
        for (Test userEntity : userEntities) {
            TestDto userDto = new TestDto();
            BeanUtils.copyProperties(userEntity, userDto);
            returnValue.add(userDto);
        }
        return returnValue;
    }
}
