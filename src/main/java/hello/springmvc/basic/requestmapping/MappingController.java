package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    // 기본적인 매핑
    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("hellobasic");
        return "ok";
    }

    // Get만 받는 매핑
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    // 어노테이션을 이용해 Get만받기
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info(" mappingGetV2");
        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     */
    @GetMapping(value = "/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info(" mappingPath userId={}", data);
        return "ok";
    }

    /**
     * 다중 PathVariable사용 다중
     */
    @GetMapping(value = "/mapping/{userId}/order/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info(" mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가맵핑
     * 파라미터에 mode=debug가 있어야
     */
    @GetMapping(value= "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 헤더조건을 추가맵핑
     * header에 mode=debuf가 있어야함
     */
    @GetMapping(value= "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * HTTP 요청의 Content-Type 헤더를 기반으로 미디어타입으로 매핑
     */
    @GetMapping(value= "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept헤더 기반 Media type
     */
    @GetMapping(value="/mapping-produce",produces = MediaType.TEXT_PLAIN_VALUE)
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    }
}
