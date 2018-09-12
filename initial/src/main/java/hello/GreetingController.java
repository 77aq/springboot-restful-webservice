package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
//@RestController的作用是controller里面的方法都能以json格式输出，不用其他jackjson配置
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    //在类的级别上的注解requestmapping将会将一个特定的请求或请求模式映射到一个控制器上
    //上面一行是在方法上应用
 public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        //@RequestParam 注解配合 @RequestMapping 一起使用，可以将请求的参数同处理方法的参数绑定在一起
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));


    }


}