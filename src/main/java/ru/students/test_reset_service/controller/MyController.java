package ru.students.test_reset_service.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.students.test_reset_service.model.Request;
import ru.students.test_reset_service.model.Response;
import ru.students.test_reset_service.service.MyModifyService;
import jakarta.validation.Valid;

@Slf4j
@RestController
public class MyController
{
    public MyController(@Qualifier("ModifyErrorMessage") MyModifyService myModifyService){
        this.myModifyService = myModifyService;
    }
    private final MyModifyService myModifyService;
    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request)
    {
        log.info("Входящий request:" + String.valueOf(request));

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        Response responseAfterModify = myModifyService.modify(response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
