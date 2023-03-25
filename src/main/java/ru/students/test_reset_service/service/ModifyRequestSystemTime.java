package ru.students.test_reset_service.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.students.test_reset_service.model.Request;
import java.util.*;
import java.text.*;

@Service
public class ModifyRequestSystemTime implements ModifyRequestService{
    Date date = new Date();

    @Override
    public void modifyRq(Request request){

        request.setSystemTime(new SimpleDateFormat("hh:mm:ss").format(date));

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost::8082/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
    }
}