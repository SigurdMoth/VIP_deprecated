package dk.vip.session.presentation;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpressionController {

    @PostMapping("/postExpression")
    public String postExpression(@RequestBody String request){
        System.out.println(request);
        return "Test";
    }
}
