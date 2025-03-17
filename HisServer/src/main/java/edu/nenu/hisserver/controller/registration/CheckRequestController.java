package edu.nenu.hisserver.controller.registration;

import edu.nenu.hisserver.pojo.Result;
import edu.nenu.hisserver.service.CheckRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/registration")
public class CheckRequestController {

    @Autowired
    private CheckRequestService checkRequestService;

    @GetMapping("/updateCheckremarkbyId")
    public Result update(@RequestParam Integer id,@RequestParam String checkState){
        checkRequestService.update(id, checkState);
        return  Result.success();
    }
}
