package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping()
    public String user() {
        return "get user";
    }

    @PostMapping()
    public String addUser() {
        return "post user";
    }

    @PatchMapping("/{userId}")
    public String findUser(@PathVariable String userId){
        return "get user = " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "delete user = " + userId;
    }
}
