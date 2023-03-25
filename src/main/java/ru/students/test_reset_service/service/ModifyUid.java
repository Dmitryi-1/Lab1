package ru.students.test_reset_service.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.students.test_reset_service.model.Response;

@Service
@Qualifier("ModifydUid")
public class ModifyUid implements MyModifyService {
    @Override
    public Response modify(Response response){

        response.setUid("New Uid");

        return response;
    }
}