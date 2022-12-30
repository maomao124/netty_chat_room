[TOC]

---































# 项目地址

## 学习笔记

### 整合

https://github.com/maomao124/authority_study_notes.git/



### 自定义Spring_Boot_starter

https://github.com/maomao124/custom_Spring_Boot_starter_notes



### lombok学习笔记

https://github.com/maomao124/lombok_study_notes



### swagger学习笔记

https://github.com/maomao124/swagger_study_notes



### dozer学习笔记

https://github.com/maomao124/dozer_study_notes



### hibernate validator学习笔记

https://github.com/maomao124/hibernate_validator_study_notes



### AntiSamy学习笔记

https://github.com/maomao124/AntiSamy_study_notes



### logback学习笔记

https://github.com/maomao124/logback_study_notes



### jwt学习笔记

https://github.com/maomao124/jwt_study_notes



### j2cache学习笔记

https://github.com/maomao124/j2cache_study_notes





## 后端项目

### 通用权限项目

https://github.com/maomao124/authority.git/



### 其它

https://github.com/maomao124/spring_boot_starter_demo

https://github.com/maomao124/spring_boot_starter_demo2

https://github.com/maomao124/spring_boot_starter_demo3

https://github.com/maomao124/lombok_use_demo

https://github.com/maomao124/swagger_demo

https://github.com/maomao124/swagger_knife4j_demo

https://github.com/maomao124/swagger_starter_demo

https://github.com/maomao124/dozer_demo

https://github.com/maomao124/dozer_starter_demo

https://github.com/maomao124/hibernate_validator_demo

https://github.com/maomao124/hibernate_validator_demo2

https://github.com/maomao124/antiSamy_demo

https://github.com/maomao124/AntiSamy_spring_boot_starter_demo

https://github.com/maomao124/logback_demo

https://github.com/maomao124/springboot_logback_demo

https://github.com/maomao124/spring_event_demo

https://github.com/maomao124/logback_spring_boot_starter_demo

https://github.com/maomao124/jwt_demo

https://github.com/maomao124/jwt_spring_boot_starter

https://github.com/maomao124/j2cache_demo

https://github.com/maomao124/j2cache_spring_boot_starter_demo

https://github.com/maomao124/spring_argumentResolver_demo











# 学习笔记

## 自定义spring boot starter

[自定义Spring Boot starter.md](自定义Spring Boot starter.md)



## lombok

[lombok学习笔记.md](lombok学习笔记.md)



## swagger

[swagger学习笔记.md](swagger学习笔记.md)



## dozer

[dozer学习笔记.md](dozer学习笔记.md)



## hibernate validator

[hibernate validator学习笔记.md](hibernate validator学习笔记.md)



## AntiSamy

[AntiSamy学习笔记.md](AntiSamy学习笔记.md)



## logback

[logback学习笔记.md](logback学习笔记.md)



## jwt

[jwt学习笔记.md](jwt学习笔记.md)



## j2cache

[j2cache学习笔记.md](j2cache学习笔记.md)













# 项目概述

## 项目介绍

对于企业中的项目绝大多数都需要进行用户权限管理、认证、鉴权、加密、解密、XSS防跨站攻击等。这些功能整体实现思路基本一致，但是大部分项目都需要实现一次，这无形中就形成了巨大的资源浪费。本项目就是针对这个问题，提供了一套通用的权限解决方案



具备通用的用户管理、资源权限管理、网关统一鉴权、XSS防跨站攻击等多个模块，支持多业务系统并行开发，支持多服务并行开发，可以作为后端服务的开发脚手架。核心技术采用SpringBoot、Zuul、Nacos、Fegin、Ribbon、Hystrix、JWT Token、Mybatis Plus等主要框架和中间件。



特性：

- 用户权限管理

  具有用户、部门、岗位、角色、菜单管理，并通过网关进行统一的权限认证

- 微服务开发框架

  本项目同时也是一个微服务开发框架，集成了基础的公共组件，包括数据库、缓存、日志、表单验证、对象转换、防注入和接口文档管理等工具。





## 业务架构



![image-20221106211301973](img/通用权限系统实战学习笔记/image-20221106211301973.png)







## 技术架构



![image-20221106211351412](img/通用权限系统实战学习笔记/image-20221106211351412.png)





## 服务注册和配置中心

本项目使用Nacos来作为服务的注册和配置中心。











# 项目模块介绍



```sh
authority                    #聚合工程，用于聚合parent、apps、tools等模块
├── parent				     # 父工程，nacos配置及依赖包管理
├── apps					 # 应用目录
	├── auth				 # 权限服务父工程
		├── auth-entity      # 权限实体
		├── auth-server      # 权限服务
	├── gateway			     # 网关服务
└── tools				     # 工具工程
	├── tools-common		 # 基础组件：基础配置类、函数、常量、统一异常处理、undertow服务器
	├── tools-core		     # 核心组件：基础实体、返回对象、上下文、异常处理、分布式锁、函数、树
	├── tools-databases	     # 数据源组件：数据源配置、数据权限、查询条件等
	├── tools-dozer		     # 对象转换：dozer配置、工具
	├── tools-redis-cache    # redis分布式缓存工具类和分布式锁服务，缓存工具类解决著名的3个缓存问题
	├── tools-j2cache	     # 缓存组件：j2cache、redis缓存
	├── tools-jwt            # JWT组件：配置、属性、工具
	├── tools-log	         # 日志组件：日志实体、事件、拦截器、工具
	
	├── tools-swagger2	     # 文档组件：knife4j文档
	├── tools-user           # 用户上下文：用户注解、模型和工具，当前登录用户信息注入模块
	├── tools-validator	     # 表单验证： 后台表单规则验证
	├── tools-xss		     # xss防注入组件
```





项目服务只有两个：网关服务和权限服务





## tools-swagger2

相信无论是前端还是后端开发，都或多或少地被接口文档折磨过。前端经常抱怨后端给的接口文档与实际情况不一致。后端又觉得编写及维护接口文档会耗费不少精力，经常来不及更新。其实无论是前端调用后端，还是后端调用后端，都期望有一个好的接口文档。但是这个接口文档对于程序员来说，就跟注释一样，经常会抱怨别人写的代码没有写注释，然而自己写起代码起来，最讨厌的，也是写注释。所以仅仅只通过强制来规范大家是不够的，随着时间推移，版本迭代，接口文档往往很容易就跟不上代码了。

使用Swagger你只需要按照它的规范去定义接口及接口相关的信息。再通过Swagger衍生出来的一系列项目和工具，就可以做到生成各种格式的接口文档，生成多种语言的客户端和服务端的代码，以及在线接口调试页面等等。这样，如果按照新的开发模式，在开发新版本或者迭代版本的时候，只需要更新Swagger描述文件，就可以自动生成接口文档和客户端服务端代码，做到调用端代码、服务端代码以及接口文档的一致性。

为了简化swagger的使用，Spring框架对swagger进行了整合，建立了Spring-swagger项目，后面改成了现在的Springfox。通过在项目中引入Springfox，可以扫描相关的代码，生成描述文件，进而生成与代码一致的接口文档和客户端代码。



![image-20221113191941824](img/通用权限系统实战学习笔记/image-20221113191941824.png)









## tools-dozer

tools-dozer模块定位为对象转换，其本质就是一个Spring Boot starter，其他模块可以直接导入此模块就可以直接完成对象转换了。



Dozer是Java Bean到Java Bean映射器，它以递归方式将数据从一个对象复制到另一个对象。 dozer是用来对两个对象之间属性转换的工具，有了这个工具之后，我们将一个对象的所有属性值转给另一个对象时，就不需要再去写重复的调用set和get方法了。dozer其实是对我们熟知的beanutils的封装。



![image-20221113192012278](img/通用权限系统实战学习笔记/image-20221113192012278.png)











## tools-validator

tools-validator模块定位为后端表单数据校验，其他模块可以直接引入tools-validator的maven坐标就可以使用其提供的表单校验功能。tools-validator底层基于hibernate-validator实现。



早期的网站，用户输入一个邮箱地址，需要将邮箱地址发送到服务端，服务端进行校验，校验成功后，给前端一个响应。

有了JavaScript后，校验工作可以放在前端去执行。那么为什么还需要服务端校验呢？ 因为前端传来的数据不可信。前端很容易获取到后端的接口，如果有人直接调用接口，就可能会出现非法数据，所以服务端也要数据校验。

总的来说：

-  前端校验：主要是提高用户体验
-  后端校验：主要是保证数据安全可靠

校验参数基本上是一个体力活，而且冗余代码繁多，也影响代码的可读性，我们需要一个比较优雅的方式来解决这个问题。Hibernate Validator 框架刚好解决了这个问题，可以以很优雅的方式实现参数的校验，让业务代码和校验逻辑分开,不再编写重复的校验逻辑。

hibernate-validator优势：

-  验证逻辑与业务逻辑之间进行了分离，降低了程序耦合度
-  统一且规范的验证方式，无需你再次编写重复的验证代码
-  你将更专注于你的业务，将这些繁琐的事情统统丢在一边



![image-20221113192042263](img/通用权限系统实战学习笔记/image-20221113192042263.png)













## tools-xss

tools-xss模块定位为防跨站脚本攻击（XSS），通过对用户在页面输入的 HTML / CSS / JavaScript 等内容进行检验和清理，确保输入内容符合应用规范，保障系统的安全。



XSS：跨站脚本攻击(Cross Site Scripting)，为不和 CSS混淆，故将跨站脚本攻击缩写为XSS。XSS是指恶意攻击者往Web页面里插入恶意Script代码，当用户浏览该页时，嵌入其中Web里面的Script代码会被执行，从而达到恶意攻击用户的目的。有点类似于sql注入。



XSS攻击原理：

HTML是一种超文本标记语言，通过将一些字符特殊地对待来区别文本和标记，例如，小于符号（<）被看作是HTML标签的开始，\<title>与\</title>之间的字符是页面的标题等等。当动态页面中插入的内容含有这些特殊字符时，用户浏览器会将其误认为是插入了HTML标签，当这些HTML标签引入了一段JavaScript脚本时，这些脚本程序就将会在用户浏览器中执行。所以，当这些特殊字符不能被动态页面检查或检查出现失误时，就将会产生XSS漏洞。



模块使用AntiSamy进行过滤



AntiSamy是OWASP的一个开源项目，通过对用户输入的 HTML / CSS / JavaScript 等内容进行检验和清理，确保输入符合应用规范。AntiSamy被广泛应用于Web服务对存储型和反射型XSS的防御中。



![image-20221113192130648](img/通用权限系统实战学习笔记/image-20221113192130648.png)













## tools-log

tools-log模块定位为日志模块，本质也是一个starter。提供的日志功能主要有两个方面：

1、通过logback框架可以在控制台或者日志文件记录日志信息

2、拦截用户请求，将操作日志保存到数据库

tools-log涉及到的技术点：

* 切面Aspect、切点PointCut、通知Advice
* Spring Event 异步监听事件
* 3、logback日志组件
* 4、函数式接口
* 5、ThreadLocal



![image-20221113192448921](img/通用权限系统实战学习笔记/image-20221113192448921.png)















## tools-jwt

tools-jwt模块的定位是对于jwt令牌相关操作进行封装，为认证、鉴权提供支撑。

提供的功能：生成jwt token、解析jwt token



JWT全称为JSON Web Token，是目前最流行的跨域身份验证解决方案。JWT是为了在网络应用环境间传递声明而制定的一种基于JSON的开放标准。

JWT特别适用于分布式站点的单点登录（SSO）场景。JWT的声明一般被用来在身份提供者和服务提供者间传递被认证的用户身份信息，以便于从资源服务器获取资源，也可被加密。



tools-jwt底层是基于jjwt进行jwt令牌的生成和解析的。为了方便使用，在tools-jwt模块中封装了两个工具类：JwtTokenServerUtils和JwtTokenClientUtils。

JwtTokenServerUtils主要是提供给权限服务的，类中包含生成jwt和解析jwt两个方法

JwtTokenClientUtils主要是提供给网关服务的，类中只有一个解析jwt的方法

需要注意的是tools-jwt并不是starter，所以如果只是在项目中引入他的maven坐标并不能直接使用其提供的工具类。需要在启动类上加入tools-jwt模块中定义的注解@EnableAuthServer或者@EnableAuthClient。

tools-jwt使用的签名算法为RS256，需要我们自己的应用来提供一对公钥和私钥，然后在application.yml中进行配置即可。



![image-20221113192528307](img/通用权限系统实战学习笔记/image-20221113192528307.png)















## tools-user

tools-user模块的主要功能是自动注入登录人信息。其他应用可以通过本模块提供的@LoginUser注解来注入当前系统登录用户。要实现此功能需要使用到Spring提供的参数解析器组件。



本模块涉及到的技术点：

* 参数解析器

* 拦截器



![image-20221113192559994](img/通用权限系统实战学习笔记/image-20221113192559994.png)











## tools-core

tools-core是所有模块的基础，定义了一些基础父类供其他模块继承。



![image-20221113192858096](img/通用权限系统实战学习笔记/image-20221113192858096.png)











## tools-common

tools-common模块中定义了一些公共类，例如BaseConfig基础配置类、DefaultGlobalExceptionHandler全局异常处理类、各种类型转换器等。



![image-20221113192945293](img/通用权限系统实战学习笔记/image-20221113192945293.png)











## tools-databases

tools-databases模块中提供的都是跟数据库操作相关的类。其他模块可以直接引入maven坐标并继承相关父类就可以复用其提供的基础配置。



![image-20221113193017178](img/通用权限系统实战学习笔记/image-20221113193017178.png)













## tools-j2cache

tools-j2cache模块提供的功能为缓存功能，其本质是一个starter，其他模块如果需要使用缓存功能直接引入maven坐标并提供相应配置文件即可使用。



j2cache是OSChina目前正在使用的两级缓存框架。

j2cache的两级缓存结构：

- L1： 进程内缓存 caffeine/ehcache
- L2： 集中式缓存 Redis/Memcached

j2cache其实并不是在重复造轮子，而是作资源整合，即将Ehcache、Caffeine、redis、Spring Cache等进行整合。

由于大量的缓存读取会导致L2的网络成为整个系统的瓶颈，因此L1的目标是降低对L2的读取次数。该缓存框架主要用于集群环境中。单机也可使用，用于避免应用重启导致的ehcache缓存数据丢失。



![image-20221113193054800](img/通用权限系统实战学习笔记/image-20221113193054800.png)







## tools-redis-cache

tools-redis-cache模块是2022年12月30日新加上去的，将tools-j2cache模块的的redis缓存工具类移动到此模块中，添加redis分布式锁服务











## auth-entity

权限实体类模块，模块里只有和权限相关的实体类



![image-20221113193426478](img/通用权限系统实战学习笔记/image-20221113193426478.png)





## auth-server

权限服务



![image-20221113193700956](img/通用权限系统实战学习笔记/image-20221113193700956.png)







## gateway

网关服务



![image-20221113193821381](img/通用权限系统实战学习笔记/image-20221113193821381.png)















# tools-user

## 参数解析器介绍

参数解析器属于spring-web包中提供的组件，springmvc框架中对应提供了很多参数解析器。例如我们开发的Controller代码如下：

~~~java
@RestController
@RequestMapping("/user")
public class UserController{
    @PostMapping("/save")
    //此处request对象就是通过Springmvc提供的参数解析器帮我们注入的
    public String saveUser(HttpServletRequest request){
        return "success";
    }
}
~~~



在上面的saveUser方法中，我们声明了一个类型为`HttpServletRequest`的参数，这个对象就是通过springmvc提供的`ServletRequestMethodArgumentResolver`这个参数解析器帮我们注入的。同样如果我们需要使用HttpServletResponse对象，也可以直接在方法上加入这个参数即可，此时springmvc会通过ServletResponseMethodArgumentResolver这个参数解析器帮我们注入。





在项目开发中我们也可以根据需要自定义参数解析器，需要实现`HandlerMethodArgumentResolver`接口：

~~~java
public interface HandlerMethodArgumentResolver {
    boolean supportsParameter(MethodParameter var1);

    @Nullable
    Object resolveArgument(MethodParameter var1, 
                            @Nullable ModelAndViewContainer var2, 
                            NativeWebRequest var3, 
                            @Nullable WebDataBinderFactory var4) throws Exception;
}
~~~



可以看到此接口包含两个接口方法：`supportsParameter`和`resolveArgument`。

当`supportsParameter`方法返回true时，才会调用`resolveArgument`方法。







## 参数解析器入门案例

本案例要实现的功能为：通过在Controller的方法参数上加入@CurrentUser注解来注入当前登录用户对象。



### 第一步：创建项目spring_argumentResolver_demo



![image-20221107210628549](img/通用权限系统实战学习笔记/image-20221107210628549.png)





### 第二步：创建实体类User



```java
package mao.spring_argumentresolver_demo.entity;

/**
 * Project name(项目名称)：spring_argumentResolver_demo
 * Package(包名): mao.spring_argumentresolver_demo.entity
 * Class(类名): User
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/7
 * Time(创建时间)： 21:07
 * Version(版本): 1.0
 * Description(描述)： 无
 */
public class User
{
    
    private Long id;
    private String username;

    /**
     * Instantiates a new User.
     */
    public User()
    {
        
    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param username the username
     */
    public User(Long id, String username)
    {
        this.id = id;
        this.username = username;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        String sb = "User{" + "id=" + id +
                ", username='" + username + '\'' +
                '}';
        return sb;
    }
}
```





### 第三步：创建UserController



```java
package mao.spring_argumentresolver_demo.controller;

import mao.spring_argumentresolver_demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project name(项目名称)：spring_argumentResolver_demo
 * Package(包名): mao.spring_argumentresolver_demo.controller
 * Class(类名): UserController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/7
 * Time(创建时间)： 21:09
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@RestController
@RequestMapping(value = "/user")
public class UserController
{
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    //获取当前系统登录用户
    @GetMapping("/getCurrentUser")
    public String getCurrentUser(User user)
    {
        log.info(user.toString());
        return user.toString();
    }
}
```







### 第四步：创建创建CurrentUser注解



```java
package mao.spring_argumentresolver_demo;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser
{
    
}
```





### 第五步：创建参数解析器类



需要实现HandlerMethodArgumentResolver接口



```java
package mao.spring_argumentresolver_demo.resolver;

import mao.spring_argumentresolver_demo.CurrentUser;
import mao.spring_argumentresolver_demo.entity.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Project name(项目名称)：spring_argumentResolver_demo
 * Package(包名): mao.spring_argumentresolver_demo.resolver
 * Class(类名): CurrentUserMethodArgumentResolver
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/7
 * Time(创建时间)： 21:18
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver
{
    @Override
    public boolean supportsParameter(MethodParameter parameter)
    {
        //如果Controller的方法参数类型为User同时还加入了CurrentUser注解，则返回true
        if (parameter.getParameterType().equals(User.class) &&
                parameter.hasParameterAnnotation(CurrentUser.class))
        {
            return true;
        }
        return false;
    }

    //当supportsParameter方法返回true时执行此方法
    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception
    {
        //此处直接模拟了一个User对象，实际项目中可能需要从请求头中获取登录用户的令牌然后进行解析，
        //最终封装成User对象返回即可，这样在Controller的方法形参就可以直接引用到User对象了
        User user = new User(1L, "张三");
        return user;
    }
}

```





### 第六步：修改UserController



在User参数前加入@CurrentUser注解



```java
package mao.spring_argumentresolver_demo.controller;

import mao.spring_argumentresolver_demo.CurrentUser;
import mao.spring_argumentresolver_demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project name(项目名称)：spring_argumentResolver_demo
 * Package(包名): mao.spring_argumentresolver_demo.controller
 * Class(类名): UserController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/7
 * Time(创建时间)： 21:09
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@RestController
@RequestMapping(value = "/user")
public class UserController
{
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    //获取当前系统登录用户
    @GetMapping("/getCurrentUser")
    public String getCurrentUser(@CurrentUser User user)
    {
        log.info(user.toString());
        return user.toString();
    }
}
```





### 第七步：创建配置类，用于注册自定义参数解析器



```java
package mao.spring_argumentresolver_demo.config;

import mao.spring_argumentresolver_demo.resolver.CurrentUserMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Project name(项目名称)：spring_argumentResolver_demo
 * Package(包名): mao.spring_argumentresolver_demo.config
 * Class(类名): ArgumentResolverConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/7
 * Time(创建时间)： 21:28
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Configuration
public class ArgumentResolverConfiguration implements WebMvcConfigurer
{
    @Override
    //注册自定义参数解析器
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers)
    {
        resolvers.add(new CurrentUserMethodArgumentResolver());
    }
}
```





### 第八步：启动程序



```sh
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.1)

2022-11-07 21:25:19.126  INFO 19544 --- [           main] .s.SpringArgumentResolverDemoApplication : Starting SpringArgumentResolverDemoApplication using Java 16.0.2 on mao with PID 19544 (H:\程序\大四上期\spring_argumentResolver_demo\target\classes started by mao in H:\程序\大四上期\spring_argumentResolver_demo)
2022-11-07 21:25:19.128  INFO 19544 --- [           main] .s.SpringArgumentResolverDemoApplication : No active profile set, falling back to 1 default profile: "default"
2022-11-07 21:25:19.846  INFO 19544 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-11-07 21:25:19.855  INFO 19544 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-11-07 21:25:19.855  INFO 19544 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.64]
2022-11-07 21:25:19.938  INFO 19544 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-11-07 21:25:19.938  INFO 19544 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 774 ms
2022-11-07 21:25:20.190  INFO 19544 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-11-07 21:25:20.200  INFO 19544 --- [           main] .s.SpringArgumentResolverDemoApplication : Started SpringArgumentResolverDemoApplication in 1.406 seconds (JVM running for 2.019)
```





### 第九步：访问



http://localhost:8080/user/getCurrentUser



![image-20221107213003840](img/通用权限系统实战学习笔记/image-20221107213003840.png)



















## 开发



### 第一步：创建子工程tools-user



![image-20221108122203286](img/通用权限系统实战学习笔记/image-20221108122203286.png)





### 第二步：修改pom文件



```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <artifactId>tools</artifactId>
        <groupId>mao</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>tools-user</artifactId>
    <name>tools-user</name>
    <description>tools-user</description>
    <properties>

    </properties>

    <dependencies>

        <dependency>
            <groupId>mao</groupId>
            <artifactId>tools-core</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>com.google.guava</groupId>
                    <artifactId>guava</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
        </dependency>

    </dependencies>


</project>
```





### 第三步：创建实体类SysOrg



```java
package mao.tools_user.entity;

import lombok.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.entity
 * Class(类名): SysOrg
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:28
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class SysOrg
{
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 简称
     */
    private String abbreviation;

    /**
     * 父ID
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sortValue;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 描述
     */
    private String describe;

}
```





### 第四步：创建实体类SysRole



```java
package mao.tools_user.entity;

import lombok.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.entity
 * Class(类名): SysRole
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class SysRole
{
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 功能描述
     */
    private String describe;

    /**
     * 是否启用
     */
    private Boolean isEnable;

    /**
     * 是否只读角色
     */
    private Boolean isReadonly;
}
```





### 第五步：创建实体类SysStation



```java
package mao.tools_user.entity;

import lombok.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.entity
 * Class(类名): SysStation
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class SysStation
{
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 组织ID
     * #pd_core_org
     */
    private Long orgId;

    /**
     * 排序
     */
    private Integer sortValue;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 描述
     */
    private String describe;
}
```





### 第六步：创建实体类SysUser



```java
package mao.tools_user.entity;

import lombok.*;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.entity
 * Class(类名): SysUser
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:30
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@Builder
public class SysUser
{
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 组织ID
     * #pd_core_org
     */
    private Long orgId;

    /**
     * 岗位ID
     * #pd_core_station
     */
    private Long stationId;


    /**
     * 手机
     * 启用条件： LoginUser.isFull = true || LoginUser.isUser = true
     */
    private String mobile;

    /**
     * 照片
     * 启用条件： LoginUser.isFull = true || LoginUser.isUser = true
     */
    private String photo;

    /**
     * 工作描述
     * 比如：  市长、管理员、局长等等   用于登陆展示
     * 启用条件： LoginUser.isFull = true || LoginUser.isUser = true
     */
    private String workDescribe;

    /**
     * 登录次数
     * 一直累计，记录了此账号总共登录次数
     * 启用条件： LoginUser.isFull = true || LoginUser.isUser = true
     */
    private Integer loginCount;

    /**
     * 当前登录用户的角色编码
     * 启用条件： LoginUser.isFull = true || LoginUser.isRole = true
     */
    private List<SysRole> roles;
    /**
     * 当前登录用户的组织架构
     * 启用条件： LoginUser.isFull = true || LoginUser.isOrg = true
     */
    private SysOrg org;
    /**
     * 当前登录用户的 岗位
     * 启用条件： LoginUser.isFull = true || LoginUser.isStation = true
     */
    private SysStation station;
}
```





### 第七步：创建类UserQuery



```java
package mao.tools_user.feign;

import lombok.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.feign
 * Class(类名): UserQuery
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:34
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserQuery
{
    /**
     * 是否查询SysUser对象所有信息，true则通过rpc接口查询
     */
    private Boolean full;

    /**
     * 是否只查询角色信息，true则通过rpc接口查询
     */
    private Boolean roles;

    /**
     * 是否只查询组织信息，true则通过rpc接口查询
     */
    private Boolean org;

    /**
     * 是否只查询岗位信息，true则通过rpc接口查询
     */
    private Boolean station;
}
```





### 第八步：创建类UserResolveApi



```java
package mao.tools_user.feign;

import mao.tools_core.base.R;
import mao.tools_user.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.feign
 * Interface(接口名): UserResolveApi
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:36
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@FeignClient(name = "${feign.authority-server:auth-server}", fallbackFactory = UserResolveApiFallback.class)
public interface UserResolveApi
{
    /**
     * 根据id 查询用户详情
     */
    @PostMapping(value = "/user/anno/id/{id}")
    R<SysUser> getById(@PathVariable("id") Long id, @RequestBody UserQuery userQuery);
}
```





### 第九步：创建类UserResolveApiFallback



```java
package mao.tools_user.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import mao.tools_core.base.R;
import mao.tools_user.entity.SysUser;
import org.springframework.stereotype.Component;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.feign
 * Class(类名): UserResolveApiFallback
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:35
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Component
public class UserResolveApiFallback implements FallbackFactory<UserResolveApi>
{

    @Override
    public UserResolveApi create(Throwable throwable)
    {
        return new UserResolveApi()
        {
            /**
             * 根据id 查询用户详情
             *
             * @param id 用户的id
             * @param userQuery UserQuery
             * @return R<SysUser>
             */
            @Override
            public R<SysUser> getById(Long id, UserQuery userQuery)
            {
                log.error("通过用户名查询用户异常:{}", id, throwable);
                return R.timeout();
            }
        };
    }
}
```





### 第十步：创建注解EnableLoginArgResolver



```java
package mao.tools_user.annotation;

import mao.tools_user.config.LoginArgResolverConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在启动类上添加该注解来----开启自动登录用户对象注入
 * Token转化SysUser
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LoginArgResolverConfig.class)
public @interface EnableLoginArgResolver
{

}
```





### 第十一步：创建注解LoginUser



```java
package mao.tools_user.annotation;


import java.lang.annotation.*;

/**
 * 请求的方法参数SysUser上添加该注解，则注入当前登录人信息
 * 例1：public void test(@LoginUser SysUser user) // 取BaseContextHandler中的 用户id、账号、姓名、组织id、岗位id等信息
 * 例2：public void test(@LoginUser(isRoles = true) SysUser user) //能获取SysUser对象的实时的用户信息和角色信息
 * 例3：public void test(@LoginUser(isOrg = true) SysUser user) //能获取SysUser对象的实时的用户信息和组织信息
 * 例4：public void test(@LoginUser(isStation = true) SysUser user) //能获取SysUser对象的实时的用户信息和岗位信息
 * 例5：public void test(@LoginUser(isFull = true) SysUser user) //能获取SysUser对象的所有信息
 *
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginUser
{
    /**
     * 是否查询SysUser对象所有信息，true则通过rpc接口查询
     */
    boolean isFull() default false;

    /**
     * 是否只查询角色信息，true则通过rpc接口查询
     */
    boolean isRoles() default false;

    /**
     * 是否只查询组织信息，true则通过rpc接口查询
     */
    boolean isOrg() default false;

    /**
     * 是否只查询岗位信息，true则通过rpc接口查询
     */
    boolean isStation() default false;
}
```





### 第十二步：创建类ContextHandlerInterceptor



```java
package mao.tools_user.interceptor;

import lombok.extern.slf4j.Slf4j;
import mao.tools_core.constants.BaseContextConstants;
import mao.tools_core.context.BaseContextHandler;
import mao.tools_core.utils.StrHelper;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.interceptor
 * Class(类名): ContextHandlerInterceptor
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:43
 * Version(版本): 1.0
 * Description(描述)：
 * <p>
 * 网关：
 * 获取token，并解析，然后将所有的用户、应用信息封装到请求头
 * <p>
 * 拦截器：
 * 解析请求头数据， 将用户信息、应用信息封装到BaseContextHandler
 * 考虑请求来源是否网关（ip等）
 */

@Slf4j
public class ContextHandlerInterceptor extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        try
        {
            if (!(handler instanceof HandlerMethod))
            {
                log.info("not exec!!! url={}", request.getRequestURL());
                return super.preHandle(request, response, handler);
            }
            String userId = getHeader(request, BaseContextConstants.JWT_KEY_USER_ID);
            String account = getHeader(request, BaseContextConstants.JWT_KEY_ACCOUNT);
            String name = getHeader(request, BaseContextConstants.JWT_KEY_NAME);
            String orgId = getHeader(request, BaseContextConstants.JWT_KEY_ORG_ID);
            String stationId = getHeader(request, BaseContextConstants.JWT_KEY_STATION_ID);
            BaseContextHandler.setUserId(userId);
            BaseContextHandler.setAccount(account);
            BaseContextHandler.setName(name);
            BaseContextHandler.setOrgId(orgId);
            BaseContextHandler.setStationId(stationId);
        }
        catch (Exception e)
        {
            log.warn("解析token信息时，发生异常. ", e);
        }
        return super.preHandle(request, response, handler);
    }

    private String getHeader(HttpServletRequest request, String name)
    {
        String value = request.getHeader(name);
        if (StringUtils.isEmpty(value))
        {
            return null;
        }
        return StrHelper.decode(value);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception
    {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
```





### 第十三步：创建类ContextArgumentResolver



```java
package mao.tools_user.resolver;

import lombok.extern.slf4j.Slf4j;
import mao.tools_core.base.R;
import mao.tools_core.context.BaseContextHandler;
import mao.tools_core.utils.NumberHelper;
import mao.tools_user.annotation.LoginUser;
import mao.tools_user.entity.SysUser;
import mao.tools_user.feign.UserQuery;
import mao.tools_user.feign.UserResolveApi;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.resolver
 * Class(类名): ContextArgumentResolver
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:33
 * Version(版本): 1.0
 * Description(描述)： Token转化SysUser
 */

@Slf4j
public class ContextArgumentResolver implements HandlerMethodArgumentResolver
{
    private final UserResolveApi userResolveApi;

    public ContextArgumentResolver(UserResolveApi userResolveApi)
    {
        this.userResolveApi = userResolveApi;
    }

    /**
     * 入参筛选
     *
     * @param mp 参数集合
     * @return 格式化后的参数
     */
    @Override
    public boolean supportsParameter(MethodParameter mp)
    {
        return mp.hasParameterAnnotation(LoginUser.class) && mp.getParameterType().equals(SysUser.class);
    }

    /**
     * @param methodParameter       入参集合
     * @param modelAndViewContainer model 和 view
     * @param nativeWebRequest      web相关
     * @param webDataBinderFactory  入参解析
     * @return 包装对象
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory)
    {
        Long userId = BaseContextHandler.getUserId();
        String account = BaseContextHandler.getAccount();
        String name = BaseContextHandler.getName();
        Long orgId = BaseContextHandler.getOrgId();
        Long stationId = BaseContextHandler.getStationId();

        //以下代码为 根据 @LoginUser 注解来注入 SysUser 对象
        SysUser user = SysUser.builder()
                .id(userId)
                .account(account)
                .name(name)
                .orgId(orgId)
                .stationId(stationId)
                .build();

        try
        {
            LoginUser loginUser = methodParameter.getParameterAnnotation(LoginUser.class);
            boolean isFull = loginUser.isFull();

            if (isFull || loginUser.isStation() || loginUser.isOrg() || loginUser.isRoles())
            {
                R<SysUser> result = userResolveApi.getById(NumberHelper.longValueOf0(userId),
                        UserQuery.builder()
                                .full(isFull)
                                .org(loginUser.isOrg())
                                .station(loginUser.isStation())
                                .roles(loginUser.isRoles())
                                .build());
                if (result.getIsSuccess() && result.getData() != null)
                {
                    return result.getData();
                }
            }
        }
        catch (Exception e)
        {
            log.warn("注入登录人信息时，发生异常. --> {}", user, e);
        }
        return user;
    }
}
```





### 第十四步：创建类LoginArgResolverConfig



```java
package mao.tools_user.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_user.feign.UserResolveApi;
import mao.tools_user.interceptor.ContextHandlerInterceptor;
import mao.tools_user.resolver.ContextArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.config
 * Class(类名): LoginArgResolverConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:40
 * Version(版本): 1.0
 * Description(描述)： 公共配置类, 一些公共工具配置
 */

@Slf4j
@Configuration
public class LoginArgResolverConfig implements WebMvcConfigurer
{
    @Lazy
    @Autowired
    private UserResolveApi userResolveApi;

    /**
     * Token参数解析
     *
     * @param argumentResolvers 解析类
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers)
    {
        argumentResolvers.add(new ContextArgumentResolver(userResolveApi));
    }

    /**
     * 注册 拦截器
     *
     * @param registry InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        if (getHandlerInterceptor() != null)
        {
            String[] commonPathPatterns = getExcludeCommonPathPatterns();
            registry.addInterceptor(getHandlerInterceptor())
                    .addPathPatterns("/**")
                    .order(10)
                    .excludePathPatterns(commonPathPatterns);
            WebMvcConfigurer.super.addInterceptors(registry);
        }
    }

    protected HandlerInterceptor getHandlerInterceptor()
    {
        return new ContextHandlerInterceptor();
    }

    /**
     * auth-client 中的拦截器需要排除拦截的地址
     */
    protected String[] getExcludeCommonPathPatterns()
    {
        String[] urls =
                {
                        "/error",
                        "/login",
                        "/v2/api-docs",
                        "/v2/api-docs-ext",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/",
                        "/csrf",
                        "/META-INF/resources/**",
                        "/resources/**",
                        "/static/**",
                        "/public/**",
                        "classpath:/META-INF/resources/**",
                        "classpath:/resources/**",
                        "classpath:/static/**",
                        "classpath:/public/**",
                        "/cache/**",
                        "/swagger-ui.html**",
                        "/doc.html**"
                };
        return urls;
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 LoginArgResolverConfig");
    }
}
```

















# tools-databases

## 开发



第一步：创建子工程tools-databases



![image-20221108133335075](img/通用权限系统实战学习笔记/image-20221108133335075.png)





第二步：修改pom文件



```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <artifactId>tools</artifactId>
        <groupId>mao</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>

    <artifactId>tools-databases</artifactId>
    <name>tools-databases</name>
    <description>数据库配置模块</description>

    <properties>

    </properties>

    <dependencies>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
        </dependency>

        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>p6spy</groupId>
            <artifactId>p6spy</artifactId>
        </dependency>

        <!-- 解决mybatis 和 LocalDateTime 的问题 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-typehandlers-jsr310</artifactId>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.datatype</groupId>
            <artifactId>jackson-datatype-jsr310</artifactId>
            <scope>compile</scope>
        </dependency>


    </dependencies>



</project>
```





第三步：创建类BaseLikeTypeHandler



```java
package mao.tools_databases.mybatis.typehandler;

import cn.hutool.core.util.StrUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.mybatis.typehandler
 * Class(类名): BaseLikeTypeHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:45
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class BaseLikeTypeHandler extends BaseTypeHandler<CharSequence>
{
    private static final String LIKE = "%";
    private final boolean leftLike;
    private final boolean rightLike;

    public BaseLikeTypeHandler(boolean leftLike, boolean rightLike)
    {
        this.leftLike = leftLike;
        this.rightLike = rightLike;
    }

    /**
     * mybatis plus like查询转换
     */
    public static String likeConvert(String value)
    {
        if (StrUtil.isNotBlank(value))
        {
            value = value.replaceAll("%", "\\\\%");
            value = value.replaceAll("_", "\\\\_");
            return value;
        }
        else
        {
            return "";
        }
    }

    public static String likeConvertProcess(String value)
    {
        if (StrUtil.isNotBlank(value))
        {
            value = value.replaceAll("%", "\\\\%");
            value = value.replaceAll("_", "\\\\_");
            return "%" + value + "%";
        }
        else
        {
            return "";
        }
    }

    public static String likeConvert(Object value)
    {
        if (value instanceof String)
        {
            return likeConvert(String.valueOf(value));
        }
        return "";
    }

    private String convert(String value)
    {
        value = value.replaceAll("\\%", "\\\\%");
        value = value.replaceAll("\\_", "\\\\_");
        return value;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, CharSequence parameter, JdbcType jdbcType)
            throws SQLException
    {
        if (parameter == null)
        {
            ps.setString(i, null);
        }
        else
        {
            ps.setString(i, like(parameter.toString()));
        }
    }

    private String like(String parameter)
    {
        String result = convert(parameter);
        if (this.leftLike)
        {
            result = LIKE + result;
        }
        if (this.rightLike)
        {
            result += LIKE;
        }
        return result;
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException
    {
        return rs.getString(columnName);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException
    {
        return rs.getString(columnIndex);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException
    {
        return cs.getString(columnIndex);
    }
}
```





第四步：创建类FullLikeTypeHandler



```java
package mao.tools_databases.mybatis.typehandler;

import org.apache.ibatis.type.Alias;

/**
 * 全像式处理程序
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.mybatis.typehandler
 * Class(类名): FullLikeTypeHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:45
 * Version(版本): 1.0
 * Description(描述)： 无
 *
 */

@Alias("fullLike")
public class FullLikeTypeHandler extends BaseLikeTypeHandler
{
    public FullLikeTypeHandler()
    {
        super(true, true);
    }
}
```





第五步：创建类LeftLikeTypeHandler



```java
package mao.tools_databases.mybatis.typehandler;

import org.apache.ibatis.type.Alias;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.mybatis.typehandler
 * Class(类名): LeftLikeTypeHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:46
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Alias("leftLike")
public class LeftLikeTypeHandler extends BaseLikeTypeHandler
{
    public LeftLikeTypeHandler()
    {
        super(true, false);
    }
}
```





第六步：创建类RightLikeTypeHandler



```java
package mao.tools_databases.mybatis.typehandler;

import org.apache.ibatis.type.Alias;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.mybatis.typehandler
 * Class(类名): RightLikeTypeHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:46
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Alias("rightLike")
public class RightLikeTypeHandler extends BaseLikeTypeHandler
{
    public RightLikeTypeHandler()
    {
        super(false, true);
    }
}
```





第七步：创建类LbqWrapper



```java
package mao.tools_databases.mybatis.conditions.query;

import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.SharedString;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import mao.tools_core.base.entity.SuperEntity;
import mao.tools_core.utils.StrPool;
import mao.tools_databases.mybatis.typehandler.BaseLikeTypeHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.mybatis.conditions.query
 * Class(类名): LbqWrapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:40
 * Version(版本): 1.0
 * Description(描述)： 查询构造器
 */

public class LbqWrapper<T> extends AbstractLambdaWrapper<T, LbqWrapper<T>> implements Query<LbqWrapper<T>, T, SFunction<T, ?>>
{
    /**
     * 查询字段
     */
    private SharedString sqlSelect = new SharedString();

    /**
     * 是否跳过空值（项目扩展）
     */
    private boolean skipEmpty = true;

    /**
     * 不建议直接 new 该实例，使用 Wrappers.lambdaQuery(entity)
     */
    public LbqWrapper()
    {
        this(null);
    }

    /**
     * 不建议直接 new 该实例，使用 Wrappers.lambdaQuery(entity)
     */
    public LbqWrapper(T entity)
    {
        if (entity instanceof SuperEntity)
        {
            T cloneT = (T) ((SuperEntity) entity).clone();
            super.setEntity(cloneT);
            super.initNeed();
            this.entity = (T) replace(cloneT);
        }
        else
        {
            super.setEntity(entity);
            super.initNeed();
            this.entity = (T) replace(entity);
        }
    }

    /**
     * 不建议直接 new 该实例，使用 Wrappers.lambdaQuery(...)
     */
    private LbqWrapper(T entity, Class<T> entityClass, SharedString sqlSelect, AtomicInteger paramNameSeq,
                       Map<String, Object> paramNameValuePairs, MergeSegments mergeSegments,
                       SharedString lastSql, SharedString sqlComment)
    {
        super.setEntity(entity);
        this.paramNameSeq = paramNameSeq;
        this.paramNameValuePairs = paramNameValuePairs;
        this.expression = mergeSegments;
        this.sqlSelect = sqlSelect;
        this.entityClass = entityClass;
        this.lastSql = lastSql;
        this.sqlComment = sqlComment;
    }

    /**
     * 根据字段名称取值
     *
     * @param obj       指定对象
     * @param fieldName 字段名称
     * @return 指定对象
     */
    private static Object getClassValue(Object obj, String fieldName)
    {
        if (obj == null)
        {
            return null;
        }
        Class beanClass = obj.getClass();
        Method[] ms = beanClass.getMethods();
        for (int i = 0; i < ms.length; i++)
        {
            // 非get方法不取
            if (!ms[i].getName().startsWith("get"))
            {
                continue;
            }
            if (!ms[i].getName().equalsIgnoreCase("get" + fieldName))
            {
                continue;
            }
            Object objValue = null;
            try
            {
                objValue = ms[i].invoke(obj, new Object[]{});
            }
            catch (Exception e)
            {
                continue;
            }
            if (objValue == null)
            {
                continue;
            }
            if (ms[i].getName().toUpperCase().equals(fieldName.toUpperCase())
                    || ms[i].getName().substring(3).toUpperCase().equals(fieldName.toUpperCase()))
            {
                return objValue;
            }
        }
        return null;
    }

    /**
     * 给对象的字段赋指定的值
     *
     * @param obj       指定对象
     * @param fieldName 属性
     * @param value     值
     * @return
     * @see
     */
    private static Object setClassValue(Object obj, String fieldName, Object value)
    {
        if (obj == null)
        {
            return null;
        }
        if (StrPool.NULL.equals(value))
        {
            value = null;
        }
        Class beanClass = obj.getClass();
        Method[] ms = beanClass.getMethods();
        for (int i = 0; i < ms.length; i++)
        {
            try
            {
                if (ms[i].getName().startsWith("set"))
                {
                    if (ms[i].getName().toUpperCase().equals(fieldName.toUpperCase())
                            || ms[i].getName().substring(3).toUpperCase().equals(fieldName.toUpperCase()))
                    {
                        String pt = ms[i].getParameterTypes()[0].toString();
                        if (value != null)
                        {
                            ms[i].invoke(obj, transVal(value.toString(), pt.substring(pt.lastIndexOf(".") + 1)));
                        }
                        else
                        {
                            ms[i].invoke(obj, new Object[]{null});
                        }
                        break;
                    }
                }
            }
            catch (Exception e)
            {
                continue;
            }
        }
        return obj;
    }

    /**
     * 根据属性类型赋值
     *
     * @param value      值
     * @param paramsType 属性类型
     * @return
     * @see
     */
    private static Object transVal(String value, String paramsType)
    {
        if (ColumnType.String.toString().equals(paramsType))
        {
            return value;
        }
        if (ColumnType.Double.toString().equals(paramsType))
        {
            return Double.parseDouble(value);
        }
        if (ColumnType.Integer.toString().equals(paramsType))
        {
            return Integer.parseInt(value);
        }
        if (ColumnType.Long.toString().equals(paramsType))
        {
            return Long.parseLong(value);
        }
        if (ColumnType.BigDecimal.toString().equals(paramsType))
        {
            return new BigDecimal(value);
        }
        return value;
    }

    /**
     * 比较用目标对象替换源对象的值
     *
     * @param source 源对象
     * @return 最新源对象
     * @see
     */
    public static Object replace(Object source)
    {
        if (source == null)
        {
            return null;
        }
        Object target = source;

        Class<?> srcClass = source.getClass();
        Field[] fields = srcClass.getDeclaredFields();
        for (Field field : fields)
        {
            String nameKey = field.getName();
            //获取源对象中的属性值
            Object classValue = getClassValue(source, nameKey);
            if (classValue == null)
            {
                continue;
            }
            String srcValue = classValue.toString();
            //比较两个属性值，不相等的时候进行赋值
            if (srcValue.contains("%") || srcValue.contains("_"))
            {
                String tarValue = srcValue.replaceAll("\\%", "\\\\%");
                tarValue = tarValue.replaceAll("\\_", "\\\\_");
                setClassValue(target, nameKey, tarValue);
            }
        }
        return target;
    }

    /**
     * SELECT 部分 SQL 设置
     *
     * @param columns 查询字段
     */
    @SafeVarargs
    @Override
    public final LbqWrapper<T> select(SFunction<T, ?>... columns)
    {
        if (ArrayUtils.isNotEmpty(columns))
        {
            this.sqlSelect.setStringValue(this.columnsToString(false, columns));
        }
        return this.typedThis;
    }

    @Override
    public LbqWrapper<T> select(Predicate<TableFieldInfo> predicate)
    {
        return this.select(this.entityClass, predicate);
    }

    /**
     * 过滤查询的字段信息(主键除外!)
     * <p>例1: 只要 java 字段名以 "test" 开头的             -> select(i -&gt; i.getProperty().startsWith("test"))</p>
     * <p>例2: 只要 java 字段属性是 CharSequence 类型的     -> select(TableFieldInfo::isCharSequence)</p>
     * <p>例3: 只要 java 字段没有填充策略的                 -> select(i -&gt; i.getFieldFill() == FieldFill.DEFAULT)</p>
     * <p>例4: 要全部字段                                   -> select(i -&gt; true)</p>
     * <p>例5: 只要主键字段                                 -> select(i -&gt; false)</p>
     *
     * @param predicate 过滤方式
     * @return this
     */
    @Override
    public LbqWrapper<T> select(Class<T> entityClass, Predicate<TableFieldInfo> predicate)
    {
        this.entityClass = entityClass;
        this.sqlSelect.setStringValue(TableInfoHelper.getTableInfo(this.getCheckEntityClass()).chooseSelect(predicate));
        return this.typedThis;
    }

    @Override
    public String getSqlSelect()
    {
        return this.sqlSelect.getStringValue();
    }

    /**
     * 用于生成嵌套 sql
     * <p>故 sqlSelect 不向下传递</p>
     */
    @Override
    protected LbqWrapper<T> instance()
    {
        return new LbqWrapper<>(this.entity, this.entityClass, null, this.paramNameSeq, this.paramNameValuePairs,
                new MergeSegments(), SharedString.emptyString(), SharedString.emptyString());
    }

    @Override
    public LbqWrapper<T> eq(SFunction<T, ?> column, Object val)
    {
        return super.eq(this.checkCondition(val), column, val);
    }

    @Override
    public LbqWrapper<T> ne(SFunction<T, ?> column, Object val)
    {
        return super.ne(this.checkCondition(val), column, val);
    }

    @Override
    public LbqWrapper<T> gt(SFunction<T, ?> column, Object val)
    {
        return super.gt(this.checkCondition(val), column, val);
    }

    @Override
    public LbqWrapper<T> ge(SFunction<T, ?> column, Object val)
    {
        return super.ge(this.checkCondition(val), column, val);
    }

    public LbqWrapper<T> geHeader(SFunction<T, ?> column, LocalDateTime val)
    {
        if (val != null)
        {
            val = LocalDateTime.of(val.toLocalDate(), LocalTime.MIN);
        }
        return super.ge(this.checkCondition(val), column, val);
    }

    public LbqWrapper<T> geHeader(SFunction<T, ?> column, LocalDate val)
    {
        LocalDateTime dateTime = null;
        if (val != null)
        {
            dateTime = LocalDateTime.of(val, LocalTime.MIN);
        }
        return super.ge(this.checkCondition(val), column, val);
    }

    @Override
    public LbqWrapper<T> lt(SFunction<T, ?> column, Object val)
    {
        return super.lt(this.checkCondition(val), column, val);
    }

    @Override
    public LbqWrapper<T> le(SFunction<T, ?> column, Object val)
    {
        return super.le(this.checkCondition(val), column, val);
    }

    public LbqWrapper<T> leFooter(SFunction<T, ?> column, LocalDateTime val)
    {
        if (val != null)
        {
            val = LocalDateTime.of(val.toLocalDate(), LocalTime.MAX);
        }
        return super.le(this.checkCondition(val), column, val);
    }

    public LbqWrapper<T> leFooter(SFunction<T, ?> column, LocalDate val)
    {
        LocalDateTime dateTime = null;
        if (val != null)
        {
            dateTime = LocalDateTime.of(val, LocalTime.MAX);
        }
        return super.le(this.checkCondition(val), column, dateTime);
    }

    @Override
    public LbqWrapper<T> in(SFunction<T, ?> column, Collection<?> coll)
    {
        return super.in(coll != null && !coll.isEmpty(), column, coll);
    }

    @Override
    public LbqWrapper<T> in(SFunction<T, ?> column, Object... values)
    {
        return super.in(values != null && values.length > 0, column, values);
    }

    //----------------以下为自定义方法---------

    @Override
    public LbqWrapper<T> like(SFunction<T, ?> column, Object val)
    {
        return super.like(this.checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }


    @Override
    public LbqWrapper<T> notLike(SFunction<T, ?> column, Object val)
    {
        return super.notLike(this.checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }

    /**
     * 取消跳过空的字符串  不允许跳过空的字符串
     *
     * @return
     */
    public LbqWrapper<T> cancelSkipEmpty()
    {
        this.skipEmpty = false;
        return this;
    }

    @Override
    public LbqWrapper<T> likeLeft(SFunction<T, ?> column, Object val)
    {
        return super.likeLeft(this.checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }

    @Override
    public LbqWrapper<T> likeRight(SFunction<T, ?> column, Object val)
    {
        return super.likeRight(this.checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }

    /**
     * 空值校验
     * 传入空字符串("")时， 视为： 字段名 = ""
     *
     * @param val 参数值
     */
    private boolean checkCondition(Object val)
    {
        if (val instanceof String && this.skipEmpty)
        {
            return StringUtils.isNotEmpty((String) val);
        }
        if (val instanceof Collection && this.skipEmpty)
        {
            return !((Collection) val).isEmpty();
        }
        return val != null;
    }

    /**
     * 忽略实体中的某些字段，实体中的字段默认是会除了null以外的全部进行等值匹配
     * 再次可以进行忽略
     *
     * @param <A>       这个是传入的待忽略字段的set方法
     * @param setColumn
     * @return
     */
    public <A extends Object> LbqWrapper<T> ignore(BiFunction<T, A, ?> setColumn)
    {
        setColumn.apply(this.entity, null);
        return this;
    }


    /**
     * 字段类型
     */
    enum ColumnType
    {
        /**
         * 类型
         */
        String,
        /**
         * 类型
         */
        Double,
        /**
         * 类型
         */
        Integer,
        /**
         * 类型
         */
        Long,
        /**
         * 类型
         */
        BigDecimal
    }

}
```





第八步：创建类LbuWrapper



```java
package mao.tools_databases.mybatis.conditions.update;

import com.baomidou.mybatisplus.core.conditions.AbstractLambdaWrapper;
import com.baomidou.mybatisplus.core.conditions.SharedString;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import mao.tools_databases.mybatis.typehandler.BaseLikeTypeHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.mybatis.conditions.update
 * Class(类名): LbuWrapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:43
 * Version(版本): 1.0
 * Description(描述)： 修改构造器
 */

public class LbuWrapper<T> extends AbstractLambdaWrapper<T, LbuWrapper<T>> implements Update<LbuWrapper<T>, SFunction<T, ?>>
{
    /**
     * SQL 更新字段内容，例如：name='1', age=2
     */
    private final List<String> sqlSet;

    /**
     * 不建议直接 new 该实例，使用 Wrappers.lambdaUpdate()
     */
    public LbuWrapper()
    {
        // 如果无参构造函数，请注意实体 NULL 情况 SET 必须有否则 SQL 异常
        this(null);
    }

    /**
     * 不建议直接 new 该实例，使用 Wrappers.lambdaUpdate(entity)
     */
    public LbuWrapper(T entity)
    {
        super.setEntity(entity);
        super.initNeed();
        this.sqlSet = new ArrayList<>();
    }

    /**
     * 不建议直接 new 该实例，使用 Wrappers.lambdaUpdate(...)
     */
    private LbuWrapper(T entity, List<String> sqlSet, AtomicInteger paramNameSeq,
                       Map<String, Object> paramNameValuePairs, MergeSegments mergeSegments,
                       SharedString lastSql, SharedString sqlComment)
    {
        super.setEntity(entity);
        this.sqlSet = sqlSet;
        this.paramNameSeq = paramNameSeq;
        this.paramNameValuePairs = paramNameValuePairs;
        this.expression = mergeSegments;
        this.lastSql = lastSql;
        this.sqlComment = sqlComment;
    }

    @Override
    public LbuWrapper<T> set(boolean condition, SFunction<T, ?> column, Object val)
    {
        if (condition)
        {
            this.sqlSet.add(String.format("%s=%s", this.columnToString(column), this.formatSql("{0}", val)));
        }
        return this.typedThis;
    }

    @Override
    public LbuWrapper<T> setSql(boolean condition, String sql)
    {
        if (condition && StringUtils.isNotEmpty(sql))
        {
            this.sqlSet.add(sql);
        }
        return this.typedThis;
    }

    @Override
    public String getSqlSet()
    {
        if (CollectionUtils.isEmpty(this.sqlSet))
        {
            return null;
        }
        return String.join(StringPool.COMMA, this.sqlSet);
    }

    @Override
    protected LbuWrapper<T> instance()
    {
        return new LbuWrapper<>(this.entity, this.sqlSet, this.paramNameSeq, this.paramNameValuePairs, new MergeSegments(),
                SharedString.emptyString(), SharedString.emptyString());
    }

    /**
     * 空值校验
     * 传入空字符串("")时， 视为： 字段名 = ""
     *
     * @param val 参数值
     */
    private static boolean checkCondition(Object val)
    {
        return val != null;
    }

    @Override
    public LbuWrapper<T> eq(SFunction<T, ?> column, Object val)
    {
        return super.eq(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> ne(SFunction<T, ?> column, Object val)
    {
        return super.ne(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> gt(SFunction<T, ?> column, Object val)
    {
        return super.gt(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> ge(SFunction<T, ?> column, Object val)
    {
        return super.ge(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> lt(SFunction<T, ?> column, Object val)
    {
        return super.lt(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> le(SFunction<T, ?> column, Object val)
    {
        return super.le(checkCondition(val), column, val);
    }

    @Override
    public LbuWrapper<T> like(SFunction<T, ?> column, Object val)
    {
        return super.like(checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }

    @Override
    public LbuWrapper<T> notLike(SFunction<T, ?> column, Object val)
    {
        return super.notLike(checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }

    @Override
    public LbuWrapper<T> likeLeft(SFunction<T, ?> column, Object val)
    {
        return super.likeLeft(checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }

    @Override
    public LbuWrapper<T> likeRight(SFunction<T, ?> column, Object val)
    {
        return super.likeRight(checkCondition(val), column, BaseLikeTypeHandler.likeConvert(val));
    }

    @Override
    public LbuWrapper<T> in(SFunction<T, ?> column, Collection<?> coll)
    {
        return super.in(coll != null && !coll.isEmpty(), column, coll);
    }

    @Override
    public LbuWrapper<T> in(SFunction<T, ?> column, Object... values)
    {
        return super.in(values != null && values.length > 0, column, values);
    }

}
```





第九步：创建类Wraps



```java
package mao.tools_databases.mybatis.conditions;

import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import mao.tools_databases.mybatis.conditions.update.LbuWrapper;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.mybatis.conditions
 * Class(类名): Wraps
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:40
 * Version(版本): 1.0
 * Description(描述)： Wrappers 工具类， 该方法的主要目的是为了 缩短代码长度
 */

public class Wraps
{
    private Wraps()
    {
        // ignore
    }

    /**
     * 获取 HyLambdaQueryWrapper&lt;T&gt;
     *
     * @param <T> 实体类泛型
     * @return LambdaQueryWrapper&lt;T&gt;
     */
    public static <T> LbqWrapper<T> lbQ()
    {
        return new LbqWrapper<>();
    }

    /**
     * 获取 HyLambdaQueryWrapper&lt;T&gt;
     *
     * @param entity 实体类
     * @param <T>    实体类泛型
     * @return LambdaQueryWrapper&lt;T&gt;
     */
    public static <T> LbqWrapper<T> lbQ(T entity)
    {
        return new LbqWrapper<>(entity);
    }

    /**
     * 获取 HyLambdaQueryWrapper&lt;T&gt;
     *
     * @param <T> 实体类泛型
     * @return LambdaUpdateWrapper&lt;T&gt;
     */
    public static <T> LbuWrapper<T> lbU()
    {
        return new LbuWrapper<>();
    }

    /**
     * 获取 HyLambdaQueryWrapper&lt;T&gt;
     *
     * @param entity 实体类
     * @param <T>    实体类泛型
     * @return LambdaUpdateWrapper&lt;T&gt;
     */
    public static <T> LbuWrapper<T> lbU(T entity)
    {
        return new LbuWrapper<>(entity);
    }
}
```





第十步：创建类DatabaseProperties



```java
package mao.tools_databases.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static mao.tools_databases.properties.DatabaseProperties.PREFIX;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.properties
 * Class(类名): DatabaseProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 14:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */
@ConfigurationProperties(prefix = PREFIX)
@Data
@NoArgsConstructor
public class DatabaseProperties
{
    public static final String PREFIX = "database";
    /**
     * 攻击 SQL 阻断解析器
     */
    public Boolean isBlockAttack = false;

    /**
     * 是否启用数据权限
     */
    //private Boolean isDataScope = true;
    /**
     * 事务超时时间
     */
    private int txTimeout = 60 * 60;
    /**
     * 统一管理事务的方法名
     */
    private List<String> transactionAttributeList = new ArrayList<>(Arrays.asList("add*", "save*", "insert*",
            "create*", "update*", "edit*", "upload*", "delete*", "remove*",
            "clean*", "recycle*", "batch*", "mark*", "disable*", "enable*", "handle*", "syn*",
            "reg*", "gen*", "*Tx"
    ));
    /**
     * 事务扫描基础包
     */
    private String transactionScanPackage = "mao";
}
```





第十一步：创建类TenantContextHandlerInterceptor



```java
package mao.tools_databases.parsers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mao.tools_core.context.BaseContextHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.parsers
 * Class(类名): TenantContextHandlerInterceptor
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:55
 * Version(版本): 1.0
 * Description(描述)：
 * <p>
 * 对来自浏览器的请求的拦截，一般是利用Filter实现的。
 * 1、在Spring中，基于Filter这种方式可以实现Bean预处理、后处理。
 * 比如注入FilterRegistrationBean，然后在这个Bean上传递自己继承Filter实现的自定义Filter进入即可。
 * <p>
 * 2、Spring MVC也有拦截器，不仅可实现Filter的所有功能，还可以更精确的控制拦截精度。
 * Spring MVC提供的org.springframework.web.servlet.handler.HandlerInterceptorAdapter这个适配器，
 * 继承此类，可以非常方便的实现自己的拦截器。
 */

@Slf4j
@AllArgsConstructor
public class TenantContextHandlerInterceptor extends HandlerInterceptorAdapter
{
    private String databaseName;

    /**
     *
     * 在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制等处理；
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理程序
     * @return boolean
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        if (!(handler instanceof HandlerMethod))
        {
            log.info("not exec!!! url={}", request.getRequestURL());
            return super.preHandle(request, response, handler);
        }
        BaseContextHandler.setDatabase(this.databaseName);
        return super.preHandle(request, response, handler);
    }

    /**
     *
     * 在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。
     * 返回处理（已经渲染了页面），可以根据ex是否为null判断是否发生了异常，进行日志记录；
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理程序
     * @param ex       异常
     * @throws Exception Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception
    {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
```





第十二步：创建类TenantWebMvcConfigurer



```java
package mao.tools_databases.parsers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.parsers
 * Class(类名): TenantWebMvcConfigurer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:59
 * Version(版本): 1.0
 * Description(描述)： Web Mvc配置
 */

public class TenantWebMvcConfigurer implements WebMvcConfigurer
{
    @Value("${mysql.database:auth}")
    private String databaseName;

    /**
     * 注册 拦截器
     *
     * @param registry InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        if (getHandlerInterceptor() != null)
        {
            String[] commonPathPatterns = getExcludeCommonPathPatterns();
            registry.addInterceptor(getHandlerInterceptor())
                    .addPathPatterns("/**")
                    .order(9)
                    .excludePathPatterns(commonPathPatterns);
            WebMvcConfigurer.super.addInterceptors(registry);
        }
    }

    protected HandlerInterceptor getHandlerInterceptor()
    {
        return new TenantContextHandlerInterceptor(databaseName);
    }

    /**
     * auth-client 中的拦截器需要排除拦截的地址
     *
     * @return {@link String[]}
     */
    protected String[] getExcludeCommonPathPatterns()
    {
        String[] urls = {
                "/error",
                "/login",
                "/v2/api-docs",
                "/v2/api-docs-ext",
                "/swagger-resources/**",
                "/webjars/**",

                "/",
                "/csrf",

                "/META-INF/resources/**",
                "/resources/**",
                "/static/**",
                "/public/**",
                "classpath:/META-INF/resources/**",
                "classpath:/resources/**",
                "classpath:/static/**",
                "classpath:/public/**",

                "/cache/**",
                "/swagger-ui.html**",
                "/doc.html**"
        };
        return urls;
    }
}
```





第十三步：创建类MyMetaObjectHandler



```java
package mao.tools_databases.datasource;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import lombok.extern.slf4j.Slf4j;
import mao.tools_core.base.entity.Entity;
import mao.tools_core.base.entity.SuperEntity;
import mao.tools_core.base.id.IdGenerate;
import mao.tools_core.context.BaseContextHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.datasource
 * Class(类名): MyMetaObjectHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 14:06
 * Version(版本): 1.0
 * Description(描述)：
 * <p>
 * MyBatis Plus 元数据处理类
 * 用于自动 注入 id, createTime, updateTime, createUser, updateUser 等字段
 */

@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler
{
    /**
     * id类型判断符
     */
    private final static String ID_TYPE = "java.lang.String";
    /**
     * 实体类型判断符
     */
    private final IdGenerate<Long> idGenerator;

    public MyMetaObjectHandler(IdGenerate<Long> idGenerator)
    {
        super();
        this.idGenerator = idGenerator;
    }

    /**
     * 所有的继承了Entity、SuperEntity的实体，在insert时，
     * id： 会通过IdGenerate生成唯一ID
     * createUser, updateUser: 自动赋予 当前线程上的登录人id
     * createTime, updateTime: 自动赋予 服务器的当前时间
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject)
    {
        boolean flag = true;
        if (metaObject.getOriginalObject() instanceof SuperEntity)
        {
            Object oldId = ((SuperEntity) metaObject.getOriginalObject()).getId();
            if (oldId != null)
            {
                flag = false;
            }

            SuperEntity entity = (SuperEntity) metaObject.getOriginalObject();
            if (entity.getCreateTime() == null)
            {
                this.setFieldValByName(Entity.CREATE_TIME, LocalDateTime.now(), metaObject);
            }
            if (entity.getCreateUser() == null || entity.getCreateUser().equals(0))
            {
                if (ID_TYPE.equals(metaObject.getGetterType(SuperEntity.CREATE_USER).getName()))
                {
                    this.setFieldValByName(Entity.CREATE_USER, String.valueOf(BaseContextHandler.getUserId()), metaObject);
                }
                else
                {
                    this.setFieldValByName(Entity.CREATE_USER, BaseContextHandler.getUserId(), metaObject);
                }
            }
        }

        if (flag)
        {
            Long id = idGenerator.generate();
            if (ID_TYPE.equals(metaObject.getGetterType(SuperEntity.FIELD_ID).getName()))
            {
                this.setFieldValByName(SuperEntity.FIELD_ID, String.valueOf(id), metaObject);
            }
            else
            {
                this.setFieldValByName(SuperEntity.FIELD_ID, id, metaObject);
            }
        }

        if (metaObject.getOriginalObject() instanceof Entity)
        {
            Entity entity = (Entity) metaObject.getOriginalObject();
            update(metaObject, entity);
        }
    }

    /**
     * 更新
     *
     * @param metaObject 元对象
     * @param entity     实体
     * @param et         等
     */
    private void update(MetaObject metaObject, Entity entity, String et)
    {
        if (entity.getUpdateUser() == null || entity.getUpdateUser().equals(0))
        {
            if (ID_TYPE.equals(metaObject.getGetterType(et + Entity.UPDATE_USER).getName()))
            {
                this.setFieldValByName(Entity.UPDATE_USER, String.valueOf(BaseContextHandler.getUserId()), metaObject);
            }
            else
            {
                this.setFieldValByName(Entity.UPDATE_USER, BaseContextHandler.getUserId(), metaObject);
            }
        }
        if (entity.getUpdateTime() == null)
        {
            this.setFieldValByName(Entity.UPDATE_TIME, LocalDateTime.now(), metaObject);
        }
    }

    /**
     * 更新
     *
     * @param metaObject 元对象
     * @param entity     实体
     */
    private void update(MetaObject metaObject, Entity entity)
    {
        update(metaObject, entity, "");
    }

    /**
     * 所有的继承了Entity、SuperEntity的实体，在update时，
     * updateUser: 自动赋予 当前线程上的登录人id
     * updateTime: 自动赋予 服务器的当前时间
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject)
    {
        log.debug("start update fill ....");
        if (metaObject.getOriginalObject() instanceof Entity)
        {
            Entity entity = (Entity) metaObject.getOriginalObject();
            update(metaObject, entity);
        }
        else
        {
            //updateById updateBatchById update(T entity, Wrapper<T> updateWrapper);
            Object et = metaObject.getValue(Constants.ENTITY);
            if (et instanceof Entity)
            {
                Entity entity = (Entity) et;
                update(metaObject, entity, Constants.ENTITY + ".");
            }
        }
    }
}
```





第十四步：创建类BaseMybatisConfiguration



```java
package mao.tools_databases.datasource;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import mao.tools_core.base.id.IdGenerate;
import mao.tools_core.base.id.SnowflakeIdGenerate;
import mao.tools_databases.mybatis.typehandler.FullLikeTypeHandler;
import mao.tools_databases.mybatis.typehandler.LeftLikeTypeHandler;
import mao.tools_databases.mybatis.typehandler.RightLikeTypeHandler;
import mao.tools_databases.parsers.TenantWebMvcConfigurer;
import mao.tools_databases.properties.DatabaseProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.datasource
 * Class(类名): BaseMybatisConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 14:03
 * Version(版本): 1.0
 * Description(描述)： Mybatis 常用重用拦截器
 */

public abstract class BaseMybatisConfiguration
{
    private final DatabaseProperties databaseProperties;

    public BaseMybatisConfiguration(DatabaseProperties databaseProperties)
    {
        this.databaseProperties = databaseProperties;
    }

    /**
     * 分页插件，自动识别数据库类型
     */
    @Bean
    public PaginationInterceptor paginationInterceptor()
    {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> sqlParserList = new ArrayList<>();

        if (this.databaseProperties.getIsBlockAttack())
        {
            // 攻击 SQL 阻断解析器 加入解析链
            sqlParserList.add(new BlockAttackSqlParser());
        }

        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }


    /**
     * Mybatis Plus 注入器
     *
     * @param idGenerate id生成
     * @return {@link MetaObjectHandler}
     */
    @Bean("myMetaObjectHandler")
    public MetaObjectHandler getMyMetaObjectHandler(@Qualifier("snowflakeIdGenerate") IdGenerate<Long> idGenerate)
    {
        return new MyMetaObjectHandler(idGenerate);
    }

    /**
     * id生成 机器码， 单机配置1即可。 集群部署，每个实例自增1即可。
     *
     * @param machineCode 机器代码
     * @return {@link IdGenerate}
     */
    @Bean("snowflakeIdGenerate")
    public IdGenerate getIdGenerate(@Value("${id-generator.machine-code:1}") Long machineCode)
    {
        return new SnowflakeIdGenerate(machineCode);
    }

    /**
     * 租户信息拦截器
     *
     * @return {@link TenantWebMvcConfigurer}
     */
    @Bean
    @ConditionalOnProperty(name = "database.isMultiTenant", havingValue = "true", matchIfMissing = true)
    public TenantWebMvcConfigurer getTenantWebMvcConfigurer()
    {
        return new TenantWebMvcConfigurer();
    }

    /**
     * Mybatis 自定义的类型处理器
     * 用于左模糊查询时使用
     * <p>
     * eg：
     * and name like #{name,typeHandler=leftLike}
     *
     * @return {@link LeftLikeTypeHandler}
     */
    @Bean
    public LeftLikeTypeHandler getLeftLikeTypeHandler()
    {
        return new LeftLikeTypeHandler();
    }

    /**
     * Mybatis 自定义的类型处理器
     * 用于右模糊查询时使用
     * <p>
     * eg：
     * and name like #{name,typeHandler=rightLike}
     *
     * @return {@link RightLikeTypeHandler}
     */
    @Bean
    public RightLikeTypeHandler getRightLikeTypeHandler()
    {
        return new RightLikeTypeHandler();
    }

    /**
     * Mybatis 自定义的类型处理器
     * 用于全模糊查询时使用
     * <p>
     * eg：
     * and name like #{name,typeHandler=fullLike}
     *
     * @return {@link FullLikeTypeHandler}
     */
    @Bean
    public FullLikeTypeHandler getFullLikeTypeHandler()
    {
        return new FullLikeTypeHandler();
    }
}
```





第十五步：创建类BaseDatabaseConfiguration



```java
package mao.tools_databases.datasource;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import mao.tools_databases.properties.DatabaseProperties;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.datasource
 * Class(类名): BaseDatabaseConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 14:10
 * Version(版本): 1.0
 * Description(描述)： 数据库& 事务& MyBatis & Mp 配置
 */

@Slf4j
public abstract class BaseDatabaseConfiguration implements InitializingBean
{
    /**
     * 测试环境
     */
    protected static final String[] DEV_PROFILES = new String[]{"dev"};
    private static final List<Class<? extends Annotation>> AOP_POINTCUT_ANNOTATIONS = new ArrayList<>(2);

    static
    {
        //事务在controller层开启。
        AOP_POINTCUT_ANNOTATIONS.add(RestController.class);
        AOP_POINTCUT_ANNOTATIONS.add(Controller.class);
    }

    protected final MybatisPlusProperties properties;

    private final DatabaseProperties databaseProperties;
    private final Interceptor[] interceptors;
    private final TypeHandler[] typeHandlers;
    private final LanguageDriver[] languageDrivers;
    private final ResourceLoader resourceLoader;
    private final DatabaseIdProvider databaseIdProvider;
    private final List<ConfigurationCustomizer> configurationCustomizers;
    private final List<MybatisPlusPropertiesCustomizer> mybatisPlusPropertiesCustomizers;
    private final ApplicationContext applicationContext;
    @Value("${spring.profiles.active:dev}")
    protected String profiles;

    public BaseDatabaseConfiguration(MybatisPlusProperties properties,
                                     DatabaseProperties databaseProperties,
                                     ObjectProvider<Interceptor[]> interceptorsProvider,
                                     ObjectProvider<TypeHandler[]> typeHandlersProvider,
                                     ObjectProvider<LanguageDriver[]> languageDriversProvider,
                                     ResourceLoader resourceLoader,
                                     ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                                     ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
                                     ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider,
                                     ApplicationContext applicationContext)
    {
        this.properties = properties;
        this.databaseProperties = databaseProperties;
        this.interceptors = interceptorsProvider.getIfAvailable();
        this.typeHandlers = typeHandlersProvider.getIfAvailable();
        this.languageDrivers = languageDriversProvider.getIfAvailable();
        this.resourceLoader = resourceLoader;
        this.databaseIdProvider = databaseIdProvider.getIfAvailable();
        this.configurationCustomizers = configurationCustomizersProvider.getIfAvailable();
        this.mybatisPlusPropertiesCustomizers = mybatisPlusPropertiesCustomizerProvider.getIfAvailable();
        this.applicationContext = applicationContext;
    }

    protected TransactionAttributeSource transactionAttributeSource()
    {
        /*当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务*/
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Throwable.class)));
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredTx.setTimeout(this.databaseProperties.getTxTimeout());
        Map<String, TransactionAttribute> txMap = new HashMap<>(this.databaseProperties.getTransactionAttributeList().size() + 5);
        this.databaseProperties.getTransactionAttributeList().forEach((key) -> txMap.put(key, requiredTx));
        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);
        //除了上面的事物以外，都走只读事物
        txMap.put("*", readOnlyTx);
        NameMatchTransactionAttributeSource txTransactionAttributeSource = new NameMatchTransactionAttributeSource();
        txTransactionAttributeSource.setNameMap(txMap);
        return txTransactionAttributeSource;
    }

    protected Advisor txAdviceAdvisor(TransactionInterceptor ti)
    {
        return new DefaultPointcutAdvisor(new Pointcut()
        {
            @Override
            public MethodMatcher getMethodMatcher()
            {
                return MethodMatcher.TRUE;
            }

            @Override
            public ClassFilter getClassFilter()
            {
                return (clazz) ->
                {
                    if (!clazz.getName().startsWith(BaseDatabaseConfiguration.this.databaseProperties.getTransactionScanPackage()))
                    {
                        return false;
                    }
                    for (Class<? extends Annotation> aop : AOP_POINTCUT_ANNOTATIONS)
                    {
                        if (clazz.getAnnotation(aop) == null)
                        {
                            continue;
                        }
                        log.debug("允许带事务的类为：{}", clazz);
                        return true;
                    }
                    return false;
                };
            }
        }, ti);
    }

    @Override
    public void afterPropertiesSet()
    {
        if (!CollectionUtils.isEmpty(this.mybatisPlusPropertiesCustomizers))
        {
            this.mybatisPlusPropertiesCustomizers.forEach(i -> i.customize(this.properties));
        }
        this.checkConfigFileExists();
    }

    private void checkConfigFileExists()
    {
        if (this.properties.isCheckConfigLocation() && StringUtils.hasText(this.properties.getConfigLocation()))
        {
            Resource resource = this.resourceLoader.getResource(this.properties.getConfigLocation());
            Assert.state(resource.exists(),
                    "Cannot find config location: " + resource + " (please add config file or check your Mybatis configuration)");
        }
    }

    protected SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception
    {
        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        if (StringUtils.hasText(this.properties.getConfigLocation()))
        {
            factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
        }
        this.applyConfiguration(factory);
        if (this.properties.getConfigurationProperties() != null)
        {
            factory.setConfigurationProperties(this.properties.getConfigurationProperties());
        }
        if (!ObjectUtils.isEmpty(this.interceptors))
        {
            factory.setPlugins(this.interceptors);
        }
        if (this.databaseIdProvider != null)
        {
            factory.setDatabaseIdProvider(this.databaseIdProvider);
        }
        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage()))
        {
            factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }
        if (this.properties.getTypeAliasesSuperType() != null)
        {
            factory.setTypeAliasesSuperType(this.properties.getTypeAliasesSuperType());
        }
        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage()))
        {
            factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
        if (!ObjectUtils.isEmpty(this.typeHandlers))
        {
            factory.setTypeHandlers(this.typeHandlers);
        }

        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations()))
        {
            factory.setMapperLocations(this.properties.resolveMapperLocations());
        }

        // TODO 对源码做了一定的修改(因为源码适配了老旧的mybatis版本,但我们不需要适配)
        Class<? extends LanguageDriver> defaultLanguageDriver = this.properties.getDefaultScriptingLanguageDriver();
        if (!ObjectUtils.isEmpty(this.languageDrivers))
        {
            factory.setScriptingLanguageDrivers(this.languageDrivers);
        }
        Optional.ofNullable(defaultLanguageDriver).ifPresent(factory::setDefaultScriptingLanguageDriver);

        // TODO 自定义枚举包
        if (StringUtils.hasLength(this.properties.getTypeEnumsPackage()))
        {
            factory.setTypeEnumsPackage(this.properties.getTypeEnumsPackage());
        }
        // TODO 此处必为非 NULL
        GlobalConfig globalConfig = this.properties.getGlobalConfig();
        // TODO 注入填充器
        if (this.applicationContext.getBeanNamesForType(MetaObjectHandler.class, false, false).length > 0)
        {
            MetaObjectHandler metaObjectHandler = this.applicationContext.getBean(MetaObjectHandler.class);
            globalConfig.setMetaObjectHandler(metaObjectHandler);
        }
        // TODO 注入主键生成器
        if (this.applicationContext.getBeanNamesForType(IKeyGenerator.class, false, false).length > 0)
        {
            IKeyGenerator keyGenerator = this.applicationContext.getBean(IKeyGenerator.class);
            globalConfig.getDbConfig().setKeyGenerator(keyGenerator);
        }
        // TODO 注入sql注入器
        if (this.applicationContext.getBeanNamesForType(ISqlInjector.class, false, false).length > 0)
        {
            ISqlInjector iSqlInjector = this.applicationContext.getBean(ISqlInjector.class);
            globalConfig.setSqlInjector(iSqlInjector);
        }
        // TODO 设置 GlobalConfig 到 MybatisSqlSessionFactoryBean
        factory.setGlobalConfig(globalConfig);
        return factory.getObject();
    }

    private void applyConfiguration(MybatisSqlSessionFactoryBean factory)
    {
        // 这里一定要复制一次， 否则多数据源时，会导致拦截器等执行多次
        MybatisConfiguration newConfiguration = this.properties.getConfiguration();
        MybatisConfiguration configuration = new MybatisConfiguration();
        BeanUtil.copyProperties(newConfiguration, configuration);

        if (!CollectionUtils.isEmpty(this.configurationCustomizers))
        {
            for (ConfigurationCustomizer customizer : this.configurationCustomizers)
            {
                customizer.customize(configuration);
            }
        }
        factory.setConfiguration(configuration);
    }
}
```















# 数据模型

## 权限数据模型介绍

在项目中要进行权限控制，需要有一套权限相关的数据表来提供支持，这是整个权限控制的基础。本系统采用的权限数据模型是在经典的RBAC权限数据模型的基础之上进行的改进，共涉及到如下9张表：



```sh
core_org----------------组织表
core_station------------岗位表
auth_user---------------用户表
auth_role---------------角色表
auth_resource-----------资源表
auth_menu---------------菜单表
auth_user_role----------用户角色关系表
auth_role_authority-----角色权限关系表
auth_role_org-----------角色组织关系表
```



菜单和资源其实都属于权限，是两种不同类型的权限，即菜单权限和资源权限。具体说明如下：

-  菜单权限：对应的是系统的菜单，不同的用户可能拥有不同的菜单权限，这样登录系统后看到的菜单也不同
-  资源权限：对应的是某个功能的访问接口，拥有权限则可以访问此接口，没有权限则禁止访问此接口





### 表结构



```sh
PS C:\Users\mao\Desktop> mysql -u root -p
Enter password: ********
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 28
Server version: 8.0.27 MySQL Community Server - GPL

Copyright (c) 2000, 2021, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show databases
    -> ;
+-----------------------+
| Database              |
+-----------------------+
| authority             |
| cloud_order           |
| cloud_user            |
| hotel                 |
| information_schema    |
| mysql                 |
| nacos                 |
| performance_schema    |
| sakila                |
| seata                 |
| seata_demo            |
| shop                  |
| spring_cloud_security |
| student               |
| student1              |
| student_test          |
| sys                   |
| test                  |
| tx                    |
| world                 |
+-----------------------+
20 rows in set (0.00 sec)

mysql> use authority
Database changed
mysql> show tables;
+---------------------+
| Tables_in_authority |
+---------------------+
| auth_menu           |
| auth_resource       |
| auth_role           |
| auth_role_authority |
| auth_role_org       |
| auth_user           |
| auth_user_role      |
| common_login_log    |
| common_opt_log      |
| core_org            |
| core_station        |
+---------------------+
11 rows in set (0.00 sec)

mysql>
```







#### common_opt_log表

common_opt_log为用户操作日志表



|     字段名     |   类型    |                             说明                             |
| :------------: | :-------: | :----------------------------------------------------------: |
|       id       |  bigint   |                             主键                             |
|   request_ip   |  varchar  |                            操作IP                            |
|      type      |  varchar  |              日志类型 OPT:操作类型 EX:异常类型               |
|   user_name    |  varchar  |                            操作人                            |
|  description   |  varchar  |                           操作描述                           |
|   class_path   |  varchar  |                            类路径                            |
| action_method  |  varchar  |                           请求方法                           |
|  request_uri   |  varchar  |                           请求地址                           |
|  http_method   |  varchar  | 请求类型  GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求 |
|     params     | longtext  |                           请求参数                           |
|     result     | longtext  |                            返回值                            |
|    ex_desc     | longtext  |                         异常详情信息                         |
|   ex_detail    | longtext  |                           异常描述                           |
|   start_time   | timestamp |                           开始时间                           |
|  finish_time   | timestamp |                           完成时间                           |
| consuming_time |  bigint   |                           消耗时间                           |
|       ua       |  varchar  |                         浏览器请求头                         |
|  create_time   | datetime  |                           创建时间                           |
|  create_user   |  bigint   |                           创建人ID                           |





#### auth_menu表

auth_menu为菜单表



|   字段名    |   类型   |         说明          |
| :---------: | :------: | :-------------------: |
|     id      |  bigint  |         主键          |
|    name     | varchar  |       菜单名称        |
|  describe_  | varchar  |       功能描述        |
|  is_public  |   bit    |    是否是公开菜单     |
|    path     | varchar  |     对应路由path      |
|  component  | varchar  | 对应路由组件component |
|  is_enable  |   bit    |       是否启用        |
| sort_value  |   int    |         排序          |
|    icon     | varchar  |       菜单图标        |
|   group_    | varchar  |       菜单分组        |
|  parent_id  |  bigint  |      父级菜单id       |
| create_user |  bigint  |       创建人id        |
| create_time | datetime |       创建时间        |
| update_user |  bigint  |       更新人id        |
| update_time | datetime |       更新时间        |







#### auth_resource表

auth_resource为资源表



|   字段名    |   类型   |     说明     |
| :---------: | :------: | :----------: |
|     id      |  bigint  |     主键     |
|    code     | varchar  |   资源编码   |
|    name     | varchar  |   接口名称   |
|   menu_id   |  bigint  |    菜单ID    |
|   method    | varchar  | HTTP请求方式 |
|     url     | varchar  | 接口请求url  |
|  describe_  | varchar  |   接口描述   |
| create_user |  bigint  |   创建人id   |
| create_time | datetime |   创建时间   |
| update_user |  bigint  |   更新人id   |
| update_time | datetime |   更新时间   |







#### auth_role表

auth_role为角色表



|  字段名称   |   类型   |     说明     |
| :---------: | :------: | :----------: |
|     id      |  bigint  |     主键     |
|    name     | varchar  |   角色名称   |
|    code     | varchar  |   角色编码   |
|  describe_  | varchar  |   角色描述   |
|   status    |   bit    | 是否启用状态 |
|  readonly   |   bit    | 是否内置角色 |
| create_user |  bigint  |   创建人id   |
| create_time | datetime |   创建时间   |
| update_user |  bigint  |   更新人id   |
| update_time | datetime |   更新时间   |







#### auth_user表

auth_user表为用户表



|          字段名          |   类型   |         说明         |
| :----------------------: | :------: | :------------------: |
|            id            |  bigint  |         主键         |
|         account          | varchar  |         账号         |
|           name           | varchar  |         姓名         |
|          org_id          |  bigint  |        组织ID        |
|        station_id        |  bigint  |        岗位ID        |
|          email           | varchar  |         邮箱         |
|          mobile          | varchar  |        手机号        |
|           sex            | varchar  |         性别         |
|          status          |   bit    |       启用状态       |
|          avatar          | varchar  |         头像         |
|      work_describe       | varchar  |       工作描述       |
| password_error_last_time | datetime | 最后一次输错密码时间 |
|    password_error_num    |   int    |     密码错误次数     |
|   password_expire_time   | datetime |     密码过期时间     |
|         password         | varchar  |         密码         |
|     last_login_time      | datetime |     最后登录时间     |
|       create_user        |  bigint  |       创建人id       |
|       create_time        | datetime |       创建时间       |
|       update_user        |  bigint  |       更新人id       |
|       update_time        | datetime |       更新时间       |







#### core_station表

core_station表为岗位表



|  字段名称   |   类型   |     说明     |
| :---------: | :------: | :----------: |
|     id      |  bigint  |     主键     |
|    name     | varchar  |   岗位名称   |
|   org_id    |  bigint  |    组织ID    |
|   status    |   bit    | 是否启用状态 |
|  describe_  | varchar  |     描述     |
| create_time | datetime |   创建时间   |
| create_user |  bigint  |   创建人ID   |
| update_time | datetime |   更新时间   |
| update_user |  bigint  |   更新人ID   |







#### core_org表

core_org表为组织表



|   字段名称   |   类型   |   说明   |
| :----------: | :------: | :------: |
|      id      |  bigint  |   主键   |
|     name     | varchar  | 组织名称 |
| abbreviation | varchar  |   简称   |
|  parent_id   |  bigint  |   父ID   |
|  tree_path   | varchar  |  树结构  |
|  sort_value  |   int    |   排序   |
|    status    |   bit    |   状态   |
|  describe_   | varchar  |   描述   |
| create_time  | datetime | 创建时间 |
| create_user  |  bigint  | 创建人ID |
| update_time  | datetime | 更新时间 |
| update_user  |  bigint  | 更新人ID |







#### auth_user_role表

auth_user_role为用户角色关系表



|  字段名称   |   类型   |   说明   |
| :---------: | :------: | :------: |
|     id      |  bigint  |   主键   |
|   role_id   |  bigint  |  角色ID  |
|   user_id   |  bigint  |  用户ID  |
| create_user |  bigint  | 创建人ID |
| create_time | datetime | 创建时间 |







#### auth_role_org表

auth_role_org为角色组织关系表



|  字段名称   |   类型   |   说明   |
| :---------: | :------: | :------: |
|     id      |  bigint  |   主键   |
|   role_id   |  bigint  |  角色ID  |
|   org_id    |  bigint  |  组织ID  |
| create_time | datetime | 创建时间 |
| create_user |  bigint  | 创建人ID |





#### auth_role_authority表

auth_role_authority为角色权限关系表



|    字段名称    |   类型   |               说明               |
| :------------: | :------: | :------------------------------: |
|       id       |  bigint  |               主键               |
|  authority_id  |  bigint  |              权限ID              |
| authority_type | varchar  | 权限类型 MENU:菜单 RESOURCE:资源 |
|    role_id     |  bigint  |              角色ID              |
|  create_time   | datetime |             创建时间             |
|  create_user   |  bigint  |             创建人ID             |







### 表

```sql
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for `auth_menu`
-- ----------------------------
DROP TABLE IF EXISTS `auth_menu`;
CREATE TABLE `auth_menu`
(
    `id`          bigint(20)  NOT NULL COMMENT '主键',
    `name`        varchar(20) NOT NULL DEFAULT '' COMMENT '菜单名称',
    `describe_`   varchar(200)         DEFAULT '' COMMENT '功能描述',
    `is_public`   bit(1)               DEFAULT b'0' COMMENT '是否公开菜单\r\n就是无需分配就可以访问的。所有人可见',
    `path`        varchar(255)         DEFAULT '' COMMENT '对应路由path',
    `component`   varchar(255)         DEFAULT NULL COMMENT '对应路由组件component',
    `is_enable`   bit(1)               DEFAULT b'1' COMMENT '状态',
    `sort_value`  int(11)              DEFAULT '1' COMMENT '排序',
    `icon`        varchar(255)         DEFAULT '' COMMENT '菜单图标',
    `group_`      varchar(20)          DEFAULT '' COMMENT '菜单分组',
    `parent_id`   bigint(20)           DEFAULT '0' COMMENT '父级菜单id',
    `create_user` bigint(20)           DEFAULT NULL COMMENT '创建人id',
    `create_time` datetime             DEFAULT NULL COMMENT '创建时间',
    `update_user` bigint(20)           DEFAULT NULL COMMENT '更新人id',
    `update_time` datetime             DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `INX_STATUS` (`is_enable`, `is_public`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='菜单';

-- ----------------------------
-- Records of auth_menu
-- ----------------------------
INSERT INTO `auth_menu`
VALUES ('101', '系统管理', '系统管理', '\0', '/user', '/user/Index', '', '0', 'el-icon-user-solid', '', '0', '1',
        '2019-07-25 15:35:12', '3', '2020-01-09 19:23:12');
INSERT INTO `auth_menu`
VALUES ('104', '监控管理', '开发者', '\0', '/developer', '/developer/Index', '', '3', 'el-icon-user-solid', '', '0', '1',
        '2019-11-11 14:38:34', '3', '2020-01-09 19:22:52');
INSERT INTO `auth_menu`
VALUES ('603976297063910529', '菜单配置', '', '\0', '/auth/menu', '/auth/menu/Index', '', '3', '', '', '101', '1',
        '2019-07-25 15:46:11', '3', '2019-11-11 14:31:52');
INSERT INTO `auth_menu`
VALUES ('603981723864141121', '角色管理', '', '\0', '/auth/role', '/auth/role/Index', '', '4', '', '', '101', '1',
        '2019-07-25 16:07:45', '3', '2019-11-11 14:31:57');
INSERT INTO `auth_menu`
VALUES ('603982542332235201', '组织管理', '', '\0', '/user/org', '/user/org/Index', '', '0', '', '', '101', '1',
        '2019-07-25 16:11:00', '3', '2020-01-11 08:51:22');
INSERT INTO `auth_menu`
VALUES ('603982713849908801', '岗位管理', '', '\0', '/user/station', '/user/station/Index', '', '1', '', '', '101', '1',
        '2019-07-25 16:11:41', '3', '2019-11-11 14:28:43');
INSERT INTO `auth_menu`
VALUES ('603983082961243905', '用户管理', '', '\0', '/user/user', '/user/user/Index', '', '2', '', '', '101', '1',
        '2019-07-25 16:13:09', '3', '2020-01-09 19:27:02');
INSERT INTO `auth_menu`
VALUES ('605078672772170209', '操作日志', '', '\0', '/developer/optLog', '/developer/optLog/Index', '', '3', '', '', '104',
        '1', '2019-07-28 16:46:38', '3', '2019-11-11 14:35:14');
INSERT INTO `auth_menu`
VALUES ('605078979149300257', '数据库监控', '', '\0', '/developer/db', '/developer/db/Index', '\0', '2', '', '', '104', '1',
        '2019-07-28 16:47:51', '3', '2020-01-10 10:40:42');
INSERT INTO `auth_menu`
VALUES ('605079239015793249', '接口文档', '', '\0', 'http://39.100.244.120:8760/api/gate/doc.html', 'Layout', '', '5', '',
        '', '104', '1', '2019-07-28 16:48:53', '3', '2020-01-10 10:33:23');
INSERT INTO `auth_menu`
VALUES ('605079411338773153', '注册配置中心', '', '\0', 'http://localhost:8848/nacos', 'Layout', '\0', '6', '', '', '104',
        '1', '2019-07-28 16:49:34', '3', '2020-01-10 10:40:47');
INSERT INTO `auth_menu`
VALUES ('645215230518909025', '登录日志', '', '\0', '/developer/loginLog', '/developer/loginLog/Index', '', '4', '', '',
        '104', '3', '2019-11-16 10:54:59', '3', '2019-11-16 10:54:59');
INSERT INTO `auth_menu`
VALUES ('667033750256747169', '文件管理', '', '\0', '/file/attachment', '/file/attachment/Index', '\0', '5', '', '', '101',
        '3', '2020-01-15 15:53:59', '3', '2020-02-05 08:47:15');
INSERT INTO `auth_menu`
VALUES ('676762150244450433', '接口路由', '', '\0', '/ofpay', '/ofpay/Index', '', '10', 'el-icon-guide', '', '0', '3',
        '2020-02-11 12:11:10', '3', '2020-02-11 12:11:10');
INSERT INTO `auth_menu`
VALUES ('676762509503365569', '调用记录', '', '\0', '/ofpay/receive', '/ofpay/receive/Index', '', '0', '', '',
        '676762150244450433', '3', '2020-02-11 12:12:36', '3', '2020-02-11 12:14:24');
INSERT INTO `auth_menu`
VALUES ('676762719185011233', '请求记录', '', '\0', '/ofpay/send', '/ofpay/send/Index', '', '1', '', '',
        '676762150244450433', '3', '2020-02-11 12:13:26', '3', '2020-02-11 12:13:26');
INSERT INTO `auth_menu`
VALUES ('680085395794296897', '平台管理', '', '\0', '/ofpay/platform', '/ofpay/platform/Index', '', '2', '', '',
        '676762150244450433', '3', '2020-02-20 16:16:34', '3', '2020-02-20 18:24:30');
INSERT INTO `auth_menu`
VALUES ('681133179561574689', '客户管理', '1', '\0', '/ofpay/customer', '/ofpay/customer/Index', '', '3', '', '',
        '676762150244450433', '3', '2020-02-23 13:40:05', '3', '2020-03-01 18:31:12');

-- ----------------------------
-- Table structure for `auth_resource`
-- ----------------------------
DROP TABLE IF EXISTS `auth_resource`;
CREATE TABLE `auth_resource`
(
    `id`          bigint(20)   NOT NULL COMMENT 'ID',
    `code`        varchar(150)          DEFAULT '' COMMENT '资源编码\n规则：\n链接：\n数据列：\n按钮：',
    `name`        varchar(150) NOT NULL DEFAULT '' COMMENT '接口名称',
    `menu_id`     bigint(20)            DEFAULT NULL COMMENT '菜单ID\n#c_auth_menu',
    `method`      varchar(10)           DEFAULT NULL,
    `url`         varchar(255)          DEFAULT NULL,
    `describe_`   varchar(255)          DEFAULT '' COMMENT '接口描述',
    `create_user` bigint(20)            DEFAULT NULL COMMENT '创建人id',
    `create_time` datetime              DEFAULT NULL COMMENT '创建时间',
    `update_user` bigint(20)            DEFAULT NULL COMMENT '更新人id',
    `update_time` datetime              DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `UN_CODE` (`code`) USING BTREE COMMENT '编码唯一'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='资源';

-- ----------------------------
-- Records of auth_resource
-- ----------------------------
INSERT INTO `auth_resource`
VALUES ('643444685339100193', 'org:add', '添加', '603982542332235201', 'POST', '/org', '', '3', '2019-11-11 13:39:28',
        '3', '2019-11-11 13:39:50');
INSERT INTO `auth_resource`
VALUES ('643444685339100194', 'role:config', '配置', '603981723864141121', 'POST', '/role/authority', '', '3',
        '2019-11-11 13:39:28', '3', '2020-03-03 19:57:51');
INSERT INTO `auth_resource`
VALUES ('643444685339100195', 'resource:add', '添加', '603976297063910529', 'POST', '/resource', '', '3',
        '2019-11-11 13:39:28', '3', '2019-11-11 13:39:50');
INSERT INTO `auth_resource`
VALUES ('643444685339100196', 'resource:update', '修改', '603976297063910529', 'PUT', '/resource', '', '3',
        '2019-11-11 13:39:28', '3', '2019-11-11 13:39:50');
INSERT INTO `auth_resource`
VALUES ('643444685339100197', 'resource:delete', '删除', '603976297063910529', 'DELETE', '/resource', '', '3',
        '2019-11-11 13:39:28', '3', '2019-11-11 13:39:50');
INSERT INTO `auth_resource`
VALUES ('643444819758154945', 'org:update', '修改', '603982542332235201', 'PUT', '/org', '', '3', '2019-11-11 13:40:00',
        '3', '2019-11-11 13:40:00');
INSERT INTO `auth_resource`
VALUES ('643444858974897441', 'org:delete', '删除', '603982542332235201', 'DELETE', '/org', '', '3',
        '2019-11-11 13:40:09', '3', '2019-11-11 13:40:09');
INSERT INTO `auth_resource`
VALUES ('643444897201784193', 'org:view', '查询', '603982542332235201', 'GET', '/org/tree', '', '3',
        '2019-11-11 13:40:18', '3', '2020-03-03 19:53:41');
INSERT INTO `auth_resource`
VALUES ('643444992357959137', 'org:import', '导入', '603982542332235201', 'POST', '/org', '', '3', '2019-11-11 13:40:41',
        '3', '2019-11-11 13:40:41');
INSERT INTO `auth_resource`
VALUES ('643445016773002817', 'org:export', '导出', '603982542332235201', 'GET', '/org', '', '3', '2019-11-11 13:40:47',
        '3', '2019-11-11 13:40:47');
INSERT INTO `auth_resource`
VALUES ('643445116756821697', 'station:add', '添加', '603982713849908801', 'POST', '/station', '', '3',
        '2019-11-11 13:41:11', '3', '2019-11-11 13:41:11');
INSERT INTO `auth_resource`
VALUES ('643445162915137313', 'station:update', '修改', '603982713849908801', 'PUT', '/station', '', '3',
        '2019-11-11 13:41:22', '3', '2019-11-11 13:41:22');
INSERT INTO `auth_resource`
VALUES ('643445197954353025', 'station:delete', '删除', '603982713849908801', 'DELETE', '/station', '', '3',
        '2019-11-11 13:41:30', '3', '2019-11-11 13:41:30');
INSERT INTO `auth_resource`
VALUES ('643445229575210977', 'station:view', '查看', '603982713849908801', 'GET', '/station/page', '', '3',
        '2019-11-11 13:41:38', '3', '2020-03-03 19:54:12');
INSERT INTO `auth_resource`
VALUES ('643445262110427201', 'station:export', '导出', '603982713849908801', 'GET', '/station', '', '3',
        '2019-11-11 13:41:45', '3', '2019-11-11 13:41:45');
INSERT INTO `auth_resource`
VALUES ('643445283996305569', 'station:import', '导入', '603982713849908801', 'POST', '/station', '', '3',
        '2019-11-11 13:41:51', '3', '2019-11-11 13:41:51');
INSERT INTO `auth_resource`
VALUES ('643445352703199521', 'user:add', '添加', '603983082961243905', 'POST', '/user', '', '3', '2019-11-11 13:42:07',
        '3', '2019-11-11 13:42:07');
INSERT INTO `auth_resource`
VALUES ('643445412774021505', 'user:update', '修改', '603983082961243905', 'PUT', '/user', '', '3', '2019-11-11 13:42:21',
        '3', '2019-11-11 13:42:21');
INSERT INTO `auth_resource`
VALUES ('643445448081672673', 'user:delete', '删除', '603983082961243905', 'DELETE', '/user', '', '3',
        '2019-11-11 13:42:30', '3', '2019-11-11 13:42:30');
INSERT INTO `auth_resource`
VALUES ('643445477274028609', 'user:view', '查看', '603983082961243905', 'GET', '/user/page', '', '3',
        '2019-11-11 13:42:37', '3', '2020-03-03 19:54:41');
INSERT INTO `auth_resource`
VALUES ('643445514607528609', 'user:import', '导入', '603983082961243905', 'POST', '/user', '', '3',
        '2019-11-11 13:42:46', '3', '2019-11-11 13:42:46');
INSERT INTO `auth_resource`
VALUES ('643445542076025601', 'user:export', '导出', '603983082961243905', 'GET', '/user', '', '3', '2019-11-11 13:42:52',
        '3', '2019-11-11 13:42:52');
INSERT INTO `auth_resource`
VALUES ('643445641149680705', 'menu:add', '添加', '603976297063910529', 'POST', '/menu', '', '3', '2019-11-11 13:43:16',
        '3', '2019-11-11 13:43:16');
INSERT INTO `auth_resource`
VALUES ('643445674330819745', 'menu:update', '修改', '603976297063910529', 'PUT', '/menu', '', '3', '2019-11-11 13:43:24',
        '3', '2019-11-11 13:43:24');
INSERT INTO `auth_resource`
VALUES ('643445704177487105', 'menu:delete', '删除', '603976297063910529', 'DELETE', '/menu', '', '3',
        '2019-11-11 13:43:31', '3', '2019-11-11 13:43:31');
INSERT INTO `auth_resource`
VALUES ('643445747320098145', 'menu:view', '查看', '603976297063910529', 'GET', '/menu/tree', '', '3',
        '2019-11-11 13:43:41', '3', '2020-03-03 19:55:10');
INSERT INTO `auth_resource`
VALUES ('643445774687931841', 'menu:export', '导出', '603976297063910529', 'GET', '/menu', '', '3', '2019-11-11 13:43:48',
        '3', '2019-11-11 13:43:48');
INSERT INTO `auth_resource`
VALUES ('643445802106097185', 'menu:import', '导入', '603976297063910529', 'POST', '/menu', '', '3',
        '2019-11-11 13:43:54', '3', '2019-11-11 13:43:54');
INSERT INTO `auth_resource`
VALUES ('643448338154263521', 'role:add', '添加', '603981723864141121', 'POST', '/role', '', '3', '2019-11-11 13:53:59',
        '3', '2019-11-11 13:53:59');
INSERT INTO `auth_resource`
VALUES ('643448369779315777', 'role:update', '修改', '603981723864141121', 'PUT', '/role', '', '3', '2019-11-11 13:54:06',
        '3', '2019-11-11 13:54:06');
INSERT INTO `auth_resource`
VALUES ('643448507767723169', 'role:delete', '删除', '603981723864141121', 'DELETE', '/role', '', '3',
        '2019-11-11 13:54:39', '3', '2019-11-11 13:54:39');
INSERT INTO `auth_resource`
VALUES ('643448611161511169', 'role:view', '查看', '603981723864141121', 'GET', '/role/page', '', '3',
        '2019-11-11 13:55:04', '3', '2020-03-03 19:55:44');
INSERT INTO `auth_resource`
VALUES ('643448656451605857', 'role:export', '导出', '603981723864141121', 'GET', '/role', '', '3', '2019-11-11 13:55:15',
        '3', '2019-11-11 13:55:15');
INSERT INTO `auth_resource`
VALUES ('643448730950833601', 'role:import', '导入', '603981723864141121', 'POST', '/role', '', '3',
        '2019-11-11 13:55:32', '3', '2019-11-11 13:55:32');
INSERT INTO `auth_resource`
VALUES ('643448826945869409', 'role:auth', '授权', '603981723864141121', 'POST', '/role/user', '', '3',
        '2019-11-11 13:55:55', '3', '2020-03-03 19:57:57');
INSERT INTO `auth_resource`
VALUES ('643450770317909249', 'optLog:view', '查看', '605078672772170209', 'GET', '/optLog', '', '3',
        '2019-11-11 14:03:39', '3', '2019-11-11 14:03:39');
INSERT INTO `auth_resource`
VALUES ('643450853134441825', 'optLog:export', '导出', '605078672772170209', 'GET', '/optLog', '', '3',
        '2019-11-11 14:03:58', '3', '2019-11-11 14:03:58');
INSERT INTO `auth_resource`
VALUES ('645288214990422241', 'optLog:delete', '删除', '605078672772170209', 'DELETE', '/optLog', '', '3',
        '2019-11-16 15:45:00', '3', '2019-11-16 15:45:00');
INSERT INTO `auth_resource`
VALUES ('645288283693121889', 'loginLog:delete', '删除', '645215230518909025', 'DELETE', '/loginLog', '', '3',
        '2019-11-16 15:45:16', '3', '2019-11-16 15:45:16');
INSERT INTO `auth_resource`
VALUES ('645288375300915649', 'loginLog:export', '导出', '645215230518909025', 'GET', '/loginLog', '', '3',
        '2019-11-16 15:45:38', '3', '2019-11-16 15:45:38');
INSERT INTO `auth_resource`
VALUES ('667033832750318369', 'file:add', '添加', '667033750256747169', 'POST', '/file', '', '3', '2020-01-15 15:54:19',
        '3', '2020-01-15 15:54:19');
INSERT INTO `auth_resource`
VALUES ('667033888949797761', 'file:update', '修改', '667033750256747169', 'PUT', '/file', '', '3', '2020-01-15 15:54:32',
        '3', '2020-01-15 15:54:32');
INSERT INTO `auth_resource`
VALUES ('667033951713362913', 'file:delete', '删除', '667033750256747169', 'DELETE', '/file', '', '3',
        '2020-01-15 15:54:47', '3', '2020-01-15 15:54:47');
INSERT INTO `auth_resource`
VALUES ('667034024379679809', 'file:view', '查看', '667033750256747169', 'GET', '/file', '', '3', '2020-01-15 15:55:05',
        '3', '2020-01-15 15:55:05');
INSERT INTO `auth_resource`
VALUES ('676763119808152449', 'receive:view', '查看', '676762509503365569', 'GET', '/receiveRecord/page', '', '3',
        '2020-02-11 12:15:02', '3', '2020-03-03 23:29:14');
INSERT INTO `auth_resource`
VALUES ('676763196182234113', 'send:view', '查看', '676762719185011233', 'GET', '/sendRecord/page', '', '3',
        '2020-02-11 12:15:20', '3', '2020-03-03 23:29:03');
INSERT INTO `auth_resource`
VALUES ('684536767625301441', 'rule:config-view', '配置-查看', '603981723864141121', 'GET', '/role/authority/*', '', '3',
        '2020-03-03 23:04:44', '3', '2020-03-03 23:26:26');
INSERT INTO `auth_resource`
VALUES ('684539815017848257', 'resource:view', '查看', '603976297063910529', 'GET', '/resource/page', '', '3',
        '2020-03-03 23:16:50', '3', '2020-03-03 23:16:50');

-- ----------------------------
-- Table structure for `auth_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`
(
    `id`          bigint(20)  NOT NULL,
    `name`        varchar(30) NOT NULL DEFAULT '' COMMENT '角色名称',
    `code`        varchar(20)          DEFAULT '' COMMENT '角色编码',
    `describe_`   varchar(100)         DEFAULT '' COMMENT '功能描述',
    `status`      bit(1)               DEFAULT b'1' COMMENT '状态',
    `readonly`    bit(1)               DEFAULT b'0' COMMENT '是否内置角色',
    `create_user` bigint(20)           DEFAULT '0' COMMENT '创建人id',
    `create_time` datetime             DEFAULT NULL COMMENT '创建时间',
    `update_user` bigint(20)           DEFAULT '0' COMMENT '更新人id',
    `update_time` datetime             DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `UN_CODE` (`code`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='角色';

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role`
VALUES ('100', '平台管理员', 'PT_ADMIN', '平台内置管理员', '', '', '1', '2019-10-25 13:46:00', '3', '2020-03-03 21:19:27');
INSERT INTO `auth_role`
VALUES ('643779012732130273', '普通员工', 'BASE_USER', '只有最基本的权限', '', '\0', '3', '2019-11-12 11:47:58', '3',
        '2019-11-16 09:47:11');
INSERT INTO `auth_role`
VALUES ('645198153556958497', '部门经理', 'DEPT_MANAGER', '管理本级以及子级用户', '', '\0', '3', '2019-11-16 09:47:07', '3',
        '2020-03-19 13:30:25');

-- ----------------------------
-- Table structure for `auth_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_authority`;
CREATE TABLE `auth_role_authority`
(
    `id`             bigint(20)  NOT NULL COMMENT '主键',
    `authority_id`   bigint(20)  NOT NULL COMMENT '权限id\n#c_auth_resource\n#c_auth_menu',
    `authority_type` varchar(10) NOT NULL DEFAULT 'MENU' COMMENT '权限类型\n#AuthorizeType{MENU:菜单;RESOURCE:资源;}',
    `role_id`        bigint(20)  NOT NULL COMMENT '角色id\n#c_auth_role',
    `create_time`    datetime             DEFAULT NULL COMMENT '创建时间',
    `create_user`    bigint(20)           DEFAULT '0' COMMENT '创建人',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `IDX_KEY` (`role_id`, `authority_type`, `authority_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='角色的资源';

-- ----------------------------
-- Records of auth_role_authority
-- ----------------------------
INSERT INTO `auth_role_authority`
VALUES ('646807586212951009', '643444685339100193', 'RESOURCE', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('646807586229728257', '101', 'MENU', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('646807586229728289', '643464272629728001', 'MENU', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('646807586229728321', '643464953478514081', 'MENU', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('646807586229728353', '643464392888812545', 'MENU', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('646807586233922689', '603982542332235201', 'MENU', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524161089921', '605080648767505601', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524186255777', '605080107379327969', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524190450113', '101', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524190450145', '605080359394083937', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524190450177', '102', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524194644513', '103', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524198838849', '603983082961243905', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524198838881', '105', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524203033217', '106', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524203033249', '107', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524203033281', '605078463069552993', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524207227617', '603981723864141121', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524207227649', '605078371293987105', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524207227681', '605079751035454305', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524207227713', '605080023753294753', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524211422049', '603976297063910529', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625204871937', '643445116756821697', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625213260577', '643444685339100197', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625217454913', '643445802106097185', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625217454945', '643448826945869409', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625221649281', '643444685339100196', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625225843617', '643444685339100193', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625225843649', '643445514607528609', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625225843681', '643444685339100195', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625225843713', '643444685339100194', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625230038049', '667033888949797761', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625230038081', '643448507767723169', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625230038113', '643445197954353025', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625230038145', '645288283693121889', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625234232481', '643444897201784193', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625234232513', '667034094479082657', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625234232545', '643448730950833601', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625238426881', '667033832750318369', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625238426913', '643445412774021505', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625242621249', '643445262110427201', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625242621281', '643448656451605857', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625246815617', '643450853134441825', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625246815649', '643445774687931841', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625246815681', '667034024379679809', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625246815713', '684539815017848257', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625251010049', '643445477274028609', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625251010081', '684536767625301441', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625255204417', '643445352703199521', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625255204449', '643445747320098145', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625259398785', '643445016773002817', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625259398817', '643445162915137313', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625259398849', '643444858974897441', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625263593185', '643450770317909249', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625263593217', '643444992357959137', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625263593249', '643445229575210977', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625263593281', '643445641149680705', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625263593313', '643444819758154945', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625267787649', '643448369779315777', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625267787681', '643448338154263521', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625267787713', '643445704177487105', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625267787745', '676763119808152449', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625267787777', '643445283996305569', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625271982113', '643445674330819745', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625271982145', '643445542076025601', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625271982177', '645288214990422241', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625271982209', '645288375300915649', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625276176545', '676763196182234113', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625276176577', '643445448081672673', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625276176609', '643448611161511169', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625276176641', '667033951713362913', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625280370977', '645215230518909025', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625280371009', '605079411338773153', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625280371041', '603983082961243905', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625280371073', '667033750256747169', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625280371105', '603982542332235201', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625284565441', '603981723864141121', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625284565473', '676762509503365569', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625284565505', '681133179561574689', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625284565537', '605079239015793249', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625288759873', '605078672772170209', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625288759905', '603976297063910529', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625288759937', '676762719185011233', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625288759969', '680085395794296897', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625288760001', '605078979149300257', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625292954337', '101', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625292954369', '104', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625292954401', '676762150244450433', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625292954433', '603982713849908801', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420521966817', '643445116756821697', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420526161153', '643445262110427201', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420526161185', '643444992357959137', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420530355521', '643444685339100193', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420530355553', '643444897201784193', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420530355585', '643445016773002817', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420534549921', '643445229575210977', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420534549953', '643444819758154945', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420534549985', '643445162915137313', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420534550017', '643445283996305569', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420534550049', '603982713849908801', 'MENU', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420538744385', '101', 'MENU', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420538744417', '603982542332235201', 'MENU', '643779012732130273', '2020-03-20 17:15:17', '3');

-- ----------------------------
-- Table structure for `auth_role_org`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_org`;
CREATE TABLE `auth_role_org`
(
    `id`          bigint(20) NOT NULL COMMENT 'ID',
    `role_id`     bigint(20) DEFAULT NULL COMMENT '角色ID\n#c_auth_role',
    `org_id`      bigint(20) DEFAULT NULL COMMENT '部门ID\n#c_core_org',
    `create_time` datetime   DEFAULT NULL,
    `create_user` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='角色组织关系';

-- ----------------------------
-- Records of auth_role_org
-- ----------------------------
INSERT INTO `auth_role_org`
VALUES ('684510274555769057', '100', '100', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157697', '100', '101', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157729', '100', '102', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157761', '100', '643775612976106881', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157793', '100', '643775664683486689', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157825', '100', '643775904077582049', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157857', '100', '643776324342648929', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157889', '100', '643776407691858113', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157921', '100', '643776508795556193', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352257', '100', '643776594376135105', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352289', '100', '643776633823564321', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352321', '100', '643776668917305985', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352353', '100', '643776713909605089', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352385', '100', '643776757199016769', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352417', '100', '684470048693160353', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442947420673', '645198153556958497', '100', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442951615009', '645198153556958497', '101', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442951615041', '645198153556958497', '643775612976106881', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442951615073', '645198153556958497', '643776594376135105', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442951615105', '645198153556958497', '643776633823564321', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442951615137', '645198153556958497', '102', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809473', '645198153556958497', '643776668917305985', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809505', '645198153556958497', '643776713909605089', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809537', '645198153556958497', '643776757199016769', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809569', '645198153556958497', '643775904077582049', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809601', '645198153556958497', '643775664683486689', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809633', '645198153556958497', '643776324342648929', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809665', '645198153556958497', '643776407691858113', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809697', '645198153556958497', '643776508795556193', '2020-03-19 13:30:25', '3');

-- ----------------------------
-- Table structure for `auth_user`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`
(
    `id`                       bigint(20)  NOT NULL COMMENT 'ID',
    `account`                  varchar(30) NOT NULL COMMENT '账号',
    `name`                     varchar(50) NOT NULL COMMENT '姓名',
    `org_id`                   bigint(20)           DEFAULT NULL COMMENT '组织ID\n#c_core_org',
    `station_id`               bigint(20)           DEFAULT NULL COMMENT '岗位ID\n#c_core_station',
    `email`                    varchar(255)         DEFAULT NULL COMMENT '邮箱',
    `mobile`                   varchar(20)          DEFAULT '' COMMENT '手机',
    `sex`                      varchar(1)           DEFAULT 'N' COMMENT '性别\n#Sex{W:女;M:男;N:未知}',
    `status`                   bit(1)               DEFAULT b'0' COMMENT '启用状态 1启用 0禁用',
    `avatar`                   varchar(255)         DEFAULT '' COMMENT '头像',
    `work_describe`            varchar(255)         DEFAULT '' COMMENT '工作描述\r\n比如：  市长、管理员、局长等等   用于登陆展示',
    `password_error_last_time` datetime             DEFAULT NULL COMMENT '最后一次输错密码时间',
    `password_error_num`       int(11)              DEFAULT '0' COMMENT '密码错误次数',
    `password_expire_time`     datetime             DEFAULT NULL COMMENT '密码过期时间',
    `password`                 varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
    `last_login_time`          datetime             DEFAULT NULL COMMENT '最后登录时间',
    `create_user`              bigint(20)           DEFAULT '0' COMMENT '创建人id',
    `create_time`              datetime             DEFAULT NULL COMMENT '创建时间',
    `update_user`              bigint(20)           DEFAULT '0' COMMENT '更新人id',
    `update_time`              datetime             DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `UN_ACCOUNT` (`account`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='用户';

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user`
VALUES ('3', '123', '平台管理员', '100', '100', '', '', 'M', '', 'BiazfanxmamNRoxxVxka.png', '超级管理员', '2020-03-21 18:48:51',
        '0', null, 'cea87ef1cb2e47570020bf7c014e1074', '2020-03-21 18:48:53', '1', '2019-09-02 11:32:02', '3',
        '2020-01-15 15:39:59');
INSERT INTO `auth_user`
VALUES ('641577229343523041', 'test', '赵六', '102', '100', '', '', 'M', '', 'BiazfanxmamNRoxxVxka.png', '',
        '2020-03-18 13:55:15', '0', null, 'cea87ef1cb2e47570020bf7c014e1074', '2020-03-18 13:55:26', '3',
        '2019-11-06 09:58:56', '3', '2020-01-10 16:32:11');
INSERT INTO `auth_user`
VALUES ('641590096981656001', 'manong', '李四', '101', '645199319300842081', '', '', 'M', '', 'BiazfanxmamNRoxxVxka.png',
        '122', '2020-03-21 18:49:20', '0', null, 'cea87ef1cb2e47570020bf7c014e1074', '2020-03-21 18:49:21', '3',
        '2019-11-06 10:50:01', '3', '2020-03-01 13:22:08');
INSERT INTO `auth_user`
VALUES ('648841103860041025', '11111', '王五', '643776668917305985', '645200885772724545', '', '', 'M', '',
        'BiazfanxmamNRoxxVxka.png', '', null, '0', null, 'cea87ef1cb2e47570020bf7c014e1074', null, '3',
        '2019-11-26 11:02:54', '3', '2020-02-06 13:20:46');
INSERT INTO `auth_user`
VALUES ('683356335357559137', 'test1', '测试', null, null, '', '', 'W', '', 'BiazfanxmamNRoxxVxka.png', '',
        '2020-02-29 16:55:10', '0', null, 'cea87ef1cb2e47570020bf7c014e1074', '2020-02-29 16:55:10', '3',
        '2020-02-29 16:54:07', '3', '2020-03-01 19:12:06');

-- ----------------------------
-- Table structure for `auth_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role`
(
    `id`          bigint(20) NOT NULL,
    `role_id`     bigint(20) NOT NULL DEFAULT '0' COMMENT '角色ID\n#c_auth_role',
    `user_id`     bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID\n#c_core_accou',
    `create_user` bigint(20)          DEFAULT NULL COMMENT '创建人ID',
    `create_time` datetime            DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `IDX_KEY` (`role_id`, `user_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='角色分配\r\n账号角色绑定';

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------
INSERT INTO `auth_user_role`
VALUES ('646807547461776193', '646807483838377697', '641590096981656001', '3', '2019-11-20 20:22:17');
INSERT INTO `auth_user_role`
VALUES ('647449120218284897', '647449059488957153', '641577229343523041', '641577229343523041', '2019-11-22 14:51:39');
INSERT INTO `auth_user_role`
VALUES ('683356538315735681', '645198153556958497', '641577229343523041', '3', '2020-02-29 16:54:55');
INSERT INTO `auth_user_role`
VALUES ('683356538332512929', '645198153556958497', '683356335357559137', '3', '2020-02-29 16:54:55');
INSERT INTO `auth_user_role`
VALUES ('689124069395663201', '100', '3', '3', '2020-03-16 14:53:02');
INSERT INTO `auth_user_role`
VALUES ('690652179203096993', '643779012732130273', '641590096981656001', '3', '2020-03-20 20:05:11');
INSERT INTO `auth_user_role`
VALUES ('690652179211485633', '643779012732130273', '641577229343523041', '3', '2020-03-20 20:05:11');

-- ----------------------------
-- Table structure for `common_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `common_login_log`;
CREATE TABLE `common_login_log`
(
    `id`               bigint(20) NOT NULL COMMENT '主键',
    `request_ip`       varchar(50)  DEFAULT '' COMMENT '操作IP',
    `user_id`          bigint(20)   DEFAULT NULL COMMENT '登录人ID',
    `user_name`        varchar(50)  DEFAULT NULL COMMENT '登录人姓名',
    `account`          varchar(30)  DEFAULT '' COMMENT '登录人账号',
    `description`      varchar(255) DEFAULT '' COMMENT '登录描述',
    `login_date`       date         DEFAULT NULL COMMENT '登录时间',
    `ua`               varchar(500) DEFAULT '0' COMMENT '浏览器请求头',
    `browser`          varchar(100) DEFAULT NULL COMMENT '浏览器名称',
    `browser_version`  varchar(255) DEFAULT NULL COMMENT '浏览器版本',
    `operating_system` varchar(100) DEFAULT NULL COMMENT '操作系统',
    `location`         varchar(50)  DEFAULT '' COMMENT '登录地点',
    `create_time`      datetime     DEFAULT NULL,
    `create_user`      bigint(20)   DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY `IDX_BROWSER` (`browser`) USING BTREE,
    KEY `IDX_OPERATING` (`operating_system`) USING BTREE,
    KEY `IDX_LOGIN_DATE` (`login_date`, `account`) USING BTREE,
    KEY `IDX_ACCOUNT_IP` (`account`, `request_ip`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='登录日志';

-- ----------------------------
-- Records of common_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for `common_opt_log`
-- ----------------------------
DROP TABLE IF EXISTS `common_opt_log`;
CREATE TABLE `common_opt_log`
(
    `id`             bigint(20) NOT NULL COMMENT '主键',
    `request_ip`     varchar(50)     DEFAULT '' COMMENT '操作IP',
    `type`           varchar(5)      DEFAULT 'OPT' COMMENT '日志类型\n#LogType{OPT:操作类型;EX:异常类型}',
    `user_name`      varchar(50)     DEFAULT '' COMMENT '操作人',
    `description`    varchar(255)    DEFAULT '' COMMENT '操作描述',
    `class_path`     varchar(255)    DEFAULT '' COMMENT '类路径',
    `action_method`  varchar(50)     DEFAULT '' COMMENT '请求方法',
    `request_uri`    varchar(50)     DEFAULT '' COMMENT '请求地址',
    `http_method`    varchar(10)     DEFAULT 'GET' COMMENT '请求类型\n#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}',
    `params`         longtext COMMENT '请求参数',
    `result`         longtext COMMENT '返回值',
    `ex_desc`        longtext COMMENT '异常详情信息',
    `ex_detail`      longtext COMMENT '异常描述',
    `start_time`     timestamp  NULL DEFAULT NULL COMMENT '开始时间',
    `finish_time`    timestamp  NULL DEFAULT NULL COMMENT '完成时间',
    `consuming_time` bigint(20)      DEFAULT '0' COMMENT '消耗时间',
    `ua`             varchar(500)    DEFAULT '' COMMENT '浏览器',
    `create_time`    datetime        DEFAULT NULL,
    `create_user`    bigint(20)      DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY `index_type` (`type`) USING BTREE COMMENT '日志类型'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='系统日志';

-- ----------------------------
-- Records of common_opt_log
-- ----------------------------

-- ----------------------------
-- Table structure for `core_org`
-- ----------------------------
DROP TABLE IF EXISTS `core_org`;
CREATE TABLE `core_org`
(
    `id`           bigint(20)   NOT NULL COMMENT 'ID',
    `name`         varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
    `abbreviation` varchar(255)          DEFAULT '' COMMENT '简称',
    `parent_id`    bigint(20)            DEFAULT '0' COMMENT '父ID',
    `tree_path`    varchar(255)          DEFAULT ',' COMMENT '树结构',
    `sort_value`   int(11)               DEFAULT '1' COMMENT '排序',
    `status`       bit(1)                DEFAULT b'1' COMMENT '状态',
    `describe_`    varchar(255)          DEFAULT '' COMMENT '描述',
    `create_time`  datetime              DEFAULT NULL,
    `create_user`  bigint(20)            DEFAULT NULL,
    `update_time`  datetime              DEFAULT NULL,
    `update_user`  bigint(20)            DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    FULLTEXT KEY `FU_PATH` (`tree_path`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='组织';

-- ----------------------------
-- Records of core_org
-- ----------------------------
INSERT INTO `core_org`
VALUES ('100', '品达物流集团有限公司', '品达集团', '0', ',', '1', '', '总公司', '2019-07-10 17:02:18', '1', '2020-02-20 20:57:11', '3');
INSERT INTO `core_org`
VALUES ('101', '品达上海分公司', '上海品达', '100', ',100,', '0', '', '上海分公司', '2019-08-06 09:10:53', '1', '2020-01-10 06:23:32',
        '3');
INSERT INTO `core_org`
VALUES ('102', '品达北京分公司', '品达北京', '100', ',100,', '1', '', '北京分公司', '2019-11-07 16:13:09', '1', '2020-01-10 06:23:48',
        '3');
INSERT INTO `core_org`
VALUES ('643775612976106881', '综合部', '综合部', '101', ',100,101,', '0', '', '前台&HR', '2019-11-12 11:34:27', '3',
        '2020-03-01 18:25:34', '3');
INSERT INTO `core_org`
VALUES ('643775664683486689', '管理层', '', '100', ',100,', '3', '', '', '2019-11-12 11:34:39', '3',
        '2019-11-12 11:36:16', '3');
INSERT INTO `core_org`
VALUES ('643775904077582049', '总经办', '', '100', ',100,', '2', '', '', '2019-11-12 11:35:37', '3',
        '2019-11-12 11:36:52', '3');
INSERT INTO `core_org`
VALUES ('643776324342648929', '财务部', '', '100', ',100,', '4', '', '', '2019-11-12 11:37:17', '3',
        '2019-11-12 11:37:40', '3');
INSERT INTO `core_org`
VALUES ('643776407691858113', '市场部', '', '100', ',100,', '5', '', '', '2019-11-12 11:37:37', '3',
        '2019-11-12 11:37:37', '3');
INSERT INTO `core_org`
VALUES ('643776508795556193', '销售部', '', '100', ',100,', '6', '', '', '2019-11-12 11:38:01', '3',
        '2019-11-12 11:38:01', '3');
INSERT INTO `core_org`
VALUES ('643776594376135105', '研发部', '', '101', ',100,101,', '1', '', 'java/html', '2019-11-12 11:38:21', '3',
        '2020-03-01 18:25:57', '3');
INSERT INTO `core_org`
VALUES ('643776633823564321', '产品部', '', '101', ',100,101,', '2', '', '', '2019-11-12 11:38:31', '3',
        '2019-11-12 11:38:31', '3');
INSERT INTO `core_org`
VALUES ('643776668917305985', '综合部', '', '102', ',100,102,', '0', '', '', '2019-11-12 11:38:39', '3',
        '2019-11-12 11:38:39', '3');
INSERT INTO `core_org`
VALUES ('643776713909605089', '研发部', '', '102', ',100,102,', '0', '', '', '2019-11-12 11:38:50', '3',
        '2019-11-12 11:38:50', '3');
INSERT INTO `core_org`
VALUES ('643776757199016769', '销售部', '', '102', ',100,102,', '2', '', '', '2019-11-12 11:39:00', '3',
        '2019-11-12 11:39:00', '3');

-- ----------------------------
-- Table structure for `core_station`
-- ----------------------------
DROP TABLE IF EXISTS `core_station`;
CREATE TABLE `core_station`
(
    `id`          bigint(20)   NOT NULL COMMENT 'ID',
    `name`        varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
    `org_id`      bigint(20)            DEFAULT '0' COMMENT '组织ID\n#c_core_org',
    `status`      bit(1)                DEFAULT b'1' COMMENT '状态',
    `describe_`   varchar(255)          DEFAULT '' COMMENT '描述',
    `create_time` datetime              DEFAULT NULL,
    `create_user` bigint(20)            DEFAULT NULL,
    `update_time` datetime              DEFAULT NULL,
    `update_user` bigint(20)            DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='岗位';

-- ----------------------------
-- Records of core_station
-- ----------------------------
INSERT INTO `core_station`
VALUES ('100', '总经理', '643775904077582049', '', '总部-1把手', '2019-07-10 17:03:03', '1', '2019-11-16 09:59:17', '3');
INSERT INTO `core_station`
VALUES ('101', '副总经理', '643775904077582049', '', '总部-2把手', '2019-07-22 17:07:55', '1', '2019-11-16 09:59:21', '3');
INSERT INTO `core_station`
VALUES ('642032719487828225', '研发经理', '643776594376135105', '', '子公司-研发部老大', '2019-11-07 16:08:49', '3',
        '2019-11-16 09:53:42', '3');
INSERT INTO `core_station`
VALUES ('645199319300842081', '副总经理', '101', '', '子公司-老大', '2019-11-16 09:51:45', '3', '2019-11-16 09:53:50', '3');
INSERT INTO `core_station`
VALUES ('645199745026892801', '产品经理', '643776633823564321', '', '子公司-产品部老大', '2019-11-16 09:53:27', '3',
        '2019-11-16 09:54:01', '3');
INSERT INTO `core_station`
VALUES ('645200064280536545', '人事经理', '643775612976106881', '', '子公司-综合老大', '2019-11-16 09:54:43', '3',
        '2019-11-16 09:54:43', '3');
INSERT INTO `core_station`
VALUES ('645200151886964289', 'Java工程师', '643776594376135105', '', '普通员工', '2019-11-16 09:55:04', '3',
        '2019-11-16 09:55:04', '3');
INSERT INTO `core_station`
VALUES ('645200250243393185', '需求工程师', '643776633823564321', '', '普通员工', '2019-11-16 09:55:27', '3',
        '2019-11-16 09:55:27', '3');
INSERT INTO `core_station`
VALUES ('645200304014370561', 'UI工程师', '643776633823564321', '', '普通员工', '2019-11-16 09:55:40', '3',
        '2019-11-16 09:55:40', '3');
INSERT INTO `core_station`
VALUES ('645200358959753057', '运维工程师', '643776594376135105', '', '普通员工', '2019-11-16 09:55:53', '3',
        '2019-11-16 09:55:53', '3');
INSERT INTO `core_station`
VALUES ('645200405453612993', '前台小姐姐', '643775612976106881', '', '普通员工', '2019-11-16 09:56:04', '3',
        '2019-11-16 09:56:04', '3');
INSERT INTO `core_station`
VALUES ('645200545698555937', '人事经理', '643776668917305985', '', '北京分公司-综合部老大', '2019-11-16 09:56:38', '3',
        '2019-11-16 09:56:38', '3');
INSERT INTO `core_station`
VALUES ('645200670781089921', '研发经理', '643776713909605089', '', '北京分公司-研发部老大', '2019-11-16 09:57:07', '3',
        '2019-11-16 09:57:07', '3');
INSERT INTO `core_station`
VALUES ('645200806559099105', '销售经理', '643776757199016769', '', '北京销售部老大', '2019-11-16 09:57:40', '3',
        '2019-11-16 09:57:40', '3');
INSERT INTO `core_station`
VALUES ('645200885772724545', '行政', '643776668917305985', '', '普通员工', '2019-11-16 09:57:59', '3',
        '2019-11-16 09:57:59', '3');
INSERT INTO `core_station`
VALUES ('645200938289605025', '大前端工程师', '643776713909605089', '', '普通员工', '2019-11-16 09:58:11', '3',
        '2019-11-16 09:58:11', '3');
INSERT INTO `core_station`
VALUES ('645201064705927681', '销售员工', '643776757199016769', '', '普通员工', '2019-11-16 09:58:41', '3',
        '2019-11-16 09:58:41', '3');
INSERT INTO `core_station`
VALUES ('645201184268757601', '销售总监', '643775664683486689', '', '总部2把手', '2019-11-16 09:59:10', '3',
        '2019-11-16 09:59:10', '3');
INSERT INTO `core_station`
VALUES ('645201307765844833', '财务总监', '643776324342648929', '', '总部2把手', '2019-11-16 09:59:39', '3',
        '2019-11-16 09:59:39', '3');
INSERT INTO `core_station`
VALUES ('645201405757369281', '市场经理', '643776407691858113', '', '总部市场部老大', '2019-11-16 10:00:03', '3',
        '2019-11-16 10:00:03', '3');
INSERT INTO `core_station`
VALUES ('645201481133206561', '销售总监', '643776508795556193', '', '总部销售部老大', '2019-11-16 10:00:21', '3',
        '2019-11-16 10:00:21', '3');
INSERT INTO `core_station`
VALUES ('645201573391117441', '前端工程师', '643776594376135105', '', '普通员工', '2019-11-16 10:00:43', '3',
        '2020-03-01 19:11:58', '3');
```















# 认证和鉴权流程

## 认证流程

1、用户通过前端系统发送登录请求，请求中携带账号、密码、验证码等信息。

2、前端登录请求首先请求到网关服务，网关服务将请求路由到权限微服务。

3、权限微服务进行认证操作，如果认证通过则生成jwt token返回给前端，同时将用户拥有的资源权限使用userId作为key保存到缓存中。



缓存中保存的用户资源权限是由auth_resource资源表中的method和url两个字段的值拼接成的。例如，某个用户拥有删除日志的权限，在表中删除日志权限对应一条数据，其中method的值为DELETE，url的值为/optLog，那么缓存中保存的用户拥有的资源权限为：DELETE/optLog。





## 鉴权流程

1、用户认证后访问其他功能时将jwt token放在请求头中，首先经过网关服务处理。

2、在网关服务的过滤器中获取请求头中的token并进行解析，将解析出的用户相关数据放在zuul的header中。

3、在网关服务的过滤器中进行鉴权相关处理。



之所以要将用户相关数据放在zuul的header中，是因为在后续的网关AccessFilter过滤器和权限服务中都会使用到这些数据。















# 权限服务开发

## 基础环境搭建

在开发权限服务的业务功能之前，我们需要进行基础环境的搭建，这是权限服务的基础。这些基础环境包括：配置文件、配置类、启动类等。



### 配置文件

#### bootstrap.yml

由于我们当前使用的是Nacos作为整个项目的配置中心，所以Spring Boot的大部分配置文件都在Nacos中进行统一配置，我们的项目中只需要按照Spring Boot的要求在resources目录下提供bootstrap.yml配置文件即可



```yaml
# @xxx@ 从pom.xml中取值, 所以 @xx@ 标注的值，都不能从nacos中获取
def:
  nacos:
    ip: ${NACOS_IP:@pom.nacos.ip@}
    port: ${NACOS_PORT:@pom.nacos.port@}
    namespace: ${NACOS_ID:@pom.nacos.namespace@}

spring:
  main:
    allow-bean-definition-overriding: true
  application:
    name: @project.artifactId@
  profiles:
    active: @pom.profile.name@
  cloud:
    nacos:
      config: #配置中心相关
        server-addr: ${def.nacos.ip}:${def.nacos.port}
        file-extension: yml
        namespace: ${def.nacos.namespace}
        shared-dataids: common.yml,redis.yml,mysql.yml
        refreshable-dataids: common.yml
        enabled: true
      discovery: #服务注册中心相关
        server-addr: ${def.nacos.ip}:${def.nacos.port}
        namespace: ${def.nacos.namespace}
        metadata: # 元数据，用于权限服务实时获取各个服务的所有接口
          management.context-path: ${server.servlet.context-path:}${spring.mvc.servlet.path:}${management.endpoints.web.base-path:}
  aop:
    proxy-target-class: true
    auto: true

# 只能配置在bootstrap.yml ，否则会生成 log.path_IS_UNDEFINED 文件夹
# window会自动在 代码所在盘 根目录下自动创建文件夹，  如： D:/data/projects/logs
logging:
  file:
    path: ./logs
    name: ${logging.file.path}/${spring.application.name}/root.log

# 用于/actuator/info
info:
  name: '@project.name@'
  description: '@project.description@'
  version: '@project.version@'
  spring-boot-version: '@spring.boot.version@'
  spring-cloud-version: '@spring.cloud.version@'
```







#### caffeine.properties



```properties
#########################################
# Caffeine configuration
# \u6682\u65F6\u6CA1\u7528
# [name] = size, xxxx[s|m|h|d]
#########################################
default=2000, 2h
captcha=1000, 5m
resource=2000, 2h
user_resource=3000, 2h
```





#### 密钥文件

本项目中使用RS256非对称加密算法进行签名，这就需要使用RSA生成一对公钥和私钥。



![image-20221110123249530](img/通用权限系统实战学习笔记/image-20221110123249530.png)







#### dozer

在resources下创建dozer目录并提供biz.dozer.xml和global.dozer.xml文件



biz.dozer.xml：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<mappings xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns="http://dozermapper.github.io/schema/bean-mapping"
          xsi:schemaLocation="http://dozermapper.github.io/schema/bean-mapping
                             http://dozermapper.github.io/schema/bean-mapping.xsd">
    <mapping date-format="yyyy-MM-dd HH:mm:ss">
        <class-a>mao.auth_entity.entity.auth.Menu</class-a>
        <class-b>mao.auth_entity.dto.auth.VueRouter</class-b>
        <field>
            <a>name</a>
            <b>meta.title</b>
        </field>
        <field>
            <a>name</a>
            <b>name</b>
        </field>
        <field>
            <a>icon</a>
            <b>meta.icon</b>
        </field>
    </mapping>
</mappings>
```



global.dozer.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<mappings xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns="http://dozermapper.github.io/schema/bean-mapping"
          xsi:schemaLocation="http://dozermapper.github.io/schema/bean-mapping http://dozermapper.github.io/schema/bean-mapping.xsd">
    <!--
    @see: http://www.jianshu.com/p/bf8f0e8aee23
    @see: http://blog.csdn.net/whhahyy/article/details/48594657
    全局配置:
    <date-format>表示日期格式
    <stop-on-errors>错误处理开关
    <wildcard>通配符
    <trim-strings>裁剪字符串开关
     -->
    <configuration>
        <date-format>yyyy-MM-dd HH:mm:ss</date-format>
    </configuration>
</mappings>
```







#### spy.properties

spy.properties是p6spy所需的属性文件。p6spy是一个开源项目，通常使用它来跟踪数据库操作，查看程序运行过程中执行的sql语句，还可以输出执行sql语句消耗的时间。



```properties
module.log=com.p6spy.engine.logging.P6LogFactory,com.p6spy.engine.outage.P6OutageFactory
logMessageFormat=com.baomidou.mybatisplus.extension.p6spy.P6SpyLogger
appender=com.baomidou.mybatisplus.extension.p6spy.StdoutLogger
deregisterdrivers=true
useprefix=true
excludecategories=info,debug,result,commit,resultset
dateformat=yyyy-MM-dd HH:mm:ss
driverlist=com.mysql.cj.jdbc.Driver
outagedetection=true
outagedetectioninterval=2
```







![image-20221110123531616](img/通用权限系统实战学习笔记/image-20221110123531616.png)











### 配置类

#### ExceptionConfiguration

全局异常处理的配置类：

```java
package mao.auth_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_common.handler.DefaultGlobalExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.config
 * Class(类名): ExceptionConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 12:45
 * Version(版本): 1.0
 * Description(描述)： 权限服务中使用的全局异常处理配置类
 */

@Slf4j
@Configuration
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExceptionConfiguration extends DefaultGlobalExceptionHandler
{
    @PostConstruct
    public void init()
    {
        log.info("初始化 ExceptionConfiguration");
    }
}
```







#### WebConfiguration

公共基础的配置类：

```java
package mao.auth_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_common.config.BaseConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.config
 * Class(类名): WebConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 12:44
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class WebConfiguration extends BaseConfig
{
    @PostConstruct
    public void init()
    {
        log.info("初始化 WebConfiguration");
    }
}
```







#### DatabaseConfiguration

数据库相关的配置类：

```java
package mao.auth_server.config;

import cn.hutool.core.util.ArrayUtil;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.p6spy.engine.spy.P6DataSource;
import lombok.extern.slf4j.Slf4j;
import mao.tools_databases.datasource.BaseDatabaseConfiguration;
import mao.tools_databases.properties.DatabaseProperties;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.config
 * Class(类名): DatabaseConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 12:50
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
@MapperScan(basePackages = {"mao.auth_server.dao",},
        sqlSessionFactoryRef = DatabaseConfiguration.DATABASE_PREFIX + "SqlSessionFactory")
public class DatabaseConfiguration extends BaseDatabaseConfiguration
{
    /**
     * 每个数据源配置不同即可
     */
    final static String DATABASE_PREFIX = "master";

    public DatabaseConfiguration(MybatisPlusProperties properties,
                                 DatabaseProperties databaseProperties,
                                 ObjectProvider<Interceptor[]> interceptorsProvider,
                                 ObjectProvider<TypeHandler[]> typeHandlersProvider,
                                 ObjectProvider<LanguageDriver[]> languageDriversProvider,
                                 ResourceLoader resourceLoader,
                                 ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                                 ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
                                 ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider,
                                 ApplicationContext applicationContext)
    {
        super(properties, databaseProperties, interceptorsProvider, typeHandlersProvider,
                languageDriversProvider, resourceLoader, databaseIdProvider,
                configurationCustomizersProvider, mybatisPlusPropertiesCustomizerProvider, applicationContext);
    }

    @Bean(DATABASE_PREFIX + "SqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier(DATABASE_PREFIX + "SqlSessionFactory") SqlSessionFactory sqlSessionFactory)
    {
        ExecutorType executorType = this.properties.getExecutorType();
        if (executorType != null)
        {
            return new SqlSessionTemplate(sqlSessionFactory, executorType);
        }
        else
        {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

    /**
     * 数据源信息
     *
     * @return {@link DataSource}
     */
    @Bean(name = DATABASE_PREFIX + "DruidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource()
    {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 数据源
     *
     * @param dataSource 数据源
     * @return {@link DataSource}
     */
    @Bean(name = DATABASE_PREFIX + "DataSource")
    public DataSource dataSource(@Qualifier(DATABASE_PREFIX + "DruidDataSource") DataSource dataSource)
    {
        if (ArrayUtil.contains(DEV_PROFILES, this.profiles))
        {
            return new P6DataSource(dataSource);
        }
        else
        {
            return dataSource;
        }
    }

    /**
     * mybatis Sql Session 工厂
     *
     * @param dataSource 数据源
     * @return {@link SqlSessionFactory}
     * @throws Exception 异常
     */
    @Bean(DATABASE_PREFIX + "SqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier(DATABASE_PREFIX + "DataSource") DataSource dataSource)
            throws Exception
    {
        return super.sqlSessionFactory(dataSource);
    }

    /**
     * 数据源事务管理器
     *
     * @param dataSource 数据源
     * @return {@link DataSourceTransactionManager}
     */
    @Bean(name = DATABASE_PREFIX + "TransactionManager")
    public DataSourceTransactionManager dsTransactionManager(@Qualifier(DATABASE_PREFIX + "DataSource") DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 事务拦截器
     *
     * @param transactionManager 事务管理器
     * @return {@link TransactionInterceptor}
     */
    @Bean(DATABASE_PREFIX + "TransactionInterceptor")
    public TransactionInterceptor transactionInterceptor(@Qualifier(DATABASE_PREFIX + "TransactionManager") PlatformTransactionManager transactionManager)
    {
        return new TransactionInterceptor(transactionManager, this.transactionAttributeSource());
    }

    /**
     * 事务 Advisor
     *
     * @param transactionManager 事务管理器
     * @param ti                 TransactionInterceptor
     * @return {@link Advisor}
     */
    @Bean(DATABASE_PREFIX + "Advisor")
    public Advisor getAdvisor(@Qualifier(DATABASE_PREFIX + "TransactionManager") PlatformTransactionManager transactionManager, @Qualifier(DATABASE_PREFIX + "TransactionInterceptor") TransactionInterceptor ti)
    {
        return super.txAdviceAdvisor(ti);
    }


    @PostConstruct
    public void init()
    {
        log.info("初始化 DatabaseConfiguration");
    }
}
```





#### MybatisConfiguration

mybatis框架相关的配置类：

```java
package mao.auth_server.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import lombok.extern.slf4j.Slf4j;
import mao.tools_databases.datasource.BaseMybatisConfiguration;
import mao.tools_databases.properties.DatabaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.config
 * Class(类名): MybatisConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 12:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
@EnableConfigurationProperties({DatabaseProperties.class, MybatisPlusProperties.class})
public class MybatisConfiguration extends BaseMybatisConfiguration
{

    public MybatisConfiguration(@Autowired DatabaseProperties databaseProperties)
    {
        super(databaseProperties);
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 MybatisConfiguration");
    }
}
```











### 启动类



```java
package mao.auth_server;

import lombok.extern.slf4j.Slf4j;
import mao.tools_jwt.server.EnableAuthServer;
import mao.tools_user.annotation.EnableLoginArgResolver;
import mao.tools_validator.config.EnableFormValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@EnableDiscoveryClient
@EnableAuthServer
@EnableFeignClients(value = {"mao"})
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableLoginArgResolver
@EnableFormValidator
@SpringBootApplication
public class AuthServerApplication
{

    public static void main(String[] args) throws UnknownHostException
    {
        long start = System.currentTimeMillis();
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AuthServerApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String appName = environment.getProperty("spring.application.name");
        String port = environment.getProperty("server.port");
        String hostAddress = InetAddress.getLocalHost().getHostAddress();

        //启动完成后在控制台提示项目启动成功，并且输出当前服务对应的swagger接口文档访问地址
        //http://localhost:8080/doc.html
        log.info("应用{}启动成功!swagger地址：http://{}:{}/doc.html", appName, hostAddress, port);
        log.info("启动耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

}
```













## 开发认证功能

### easy-captcha

easy-captcha是生成图形验证码的Java类库，支持gif、中文、算术等类型，可用于Java Web、JavaSE等项目。

maven坐标：

~~~xml
<dependency>
    <groupId>com.github.whvcse</groupId>
    <artifactId>easy-captcha</artifactId>
    <version>1.6.2</version>
</dependency>
~~~





![image-20221110131741006](img/通用权限系统实战学习笔记/image-20221110131741006.png)





![image-20221110133202555](img/通用权限系统实战学习笔记/image-20221110133202555.png)





使用方式



```java
package mao.auth_server.Captcha;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.Captcha
 * Class(类名): EasyCaptchaArithmeticCaptchaTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 13:19
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class EasyCaptchaArithmeticCaptchaTest
{
    /**
     * 算术类型图片验证码,字母数字混合
     */
    @Test
    void test1() throws FileNotFoundException
    {
        Captcha captcha = new ArithmeticCaptcha(120, 50);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(1);
        captcha.out(new FileOutputStream("./captcha/test1.png"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 算术类型图片验证码,纯数字
     */
    @Test
    void test2() throws FileNotFoundException
    {
        Captcha captcha = new ArithmeticCaptcha(120, 50);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(2);
        captcha.out(new FileOutputStream("./captcha/test2.png"));
        String text = captcha.text();
        System.out.println(text);
    }

}

```





![image-20221110132531850](img/通用权限系统实战学习笔记/image-20221110132531850.png)



![image-20221110132544151](img/通用权限系统实战学习笔记/image-20221110132544151.png)





![image-20221110132617356](img/通用权限系统实战学习笔记/image-20221110132617356.png)



![image-20221110132625355](img/通用权限系统实战学习笔记/image-20221110132625355.png)





gif



```java
package mao.auth_server.Captcha;

import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.Captcha
 * Class(类名): EasyCaptchaGifCaptchaTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 13:30
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class EasyCaptchaGifCaptchaTest
{
    /**
     * gif类型图片验证码
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test3() throws IOException, FontFormatException
    {
        Captcha captcha = new GifCaptcha(120, 50);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(1);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        //captcha.setFont(1);
        captcha.out(new FileOutputStream("./captcha/test3.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * gif类型图片验证码,纯数字
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test4() throws IOException, FontFormatException
    {
        Captcha captcha = new GifCaptcha(300, 150);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(2);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        captcha.setFont(2);
        captcha.out(new FileOutputStream("./captcha/test4.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * gif类型图片验证码,纯字母
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test5() throws IOException, FontFormatException
    {
        Captcha captcha = new GifCaptcha(300, 150);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(3);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        captcha.setFont(2);
        captcha.out(new FileOutputStream("./captcha/test5.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * gif类型图片验证码,纯大写字母
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test6() throws IOException, FontFormatException
    {
        Captcha captcha = new GifCaptcha(300, 150);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(4);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        captcha.setFont(2);
        captcha.out(new FileOutputStream("./captcha/test6.gif"));
        String text = captcha.text();
        System.out.println(text);
    }
    
    
}

```





![image-20221110133732327](img/通用权限系统实战学习笔记/image-20221110133732327.png)





![test3](img/通用权限系统实战学习笔记/test3.gif)



![image-20221110133853902](img/通用权限系统实战学习笔记/image-20221110133853902.png)





![test4](img/通用权限系统实战学习笔记/test4.gif)





![image-20221110134007714](img/通用权限系统实战学习笔记/image-20221110134007714.png)





![test5](img/通用权限系统实战学习笔记/test5.gif)





![image-20221110134106478](img/通用权限系统实战学习笔记/image-20221110134106478.png)



![test6](img/通用权限系统实战学习笔记/test6.gif)









```java
package mao.auth_server.Captcha;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.Captcha
 * Class(类名): EasyCaptchaSpecCaptchaTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 13:43
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class EasyCaptchaSpecCaptchaTest
{
    /**
     * 图片验证码,字母数字混合
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test7() throws IOException, FontFormatException
    {
        Captcha captcha = new SpecCaptcha(200, 100);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(1);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        captcha.setFont(2);
        captcha.out(new FileOutputStream("./captcha/test7.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 图片验证码,纯数字
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test8() throws IOException, FontFormatException
    {
        Captcha captcha = new SpecCaptcha(200, 100);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(2);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        captcha.setFont(2);
        captcha.out(new FileOutputStream("./captcha/test8.gif"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 图片验证码,纯字母
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test9() throws IOException, FontFormatException
    {
        Captcha captcha = new SpecCaptcha(200, 100);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(3);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        captcha.setFont(2);
        captcha.out(new FileOutputStream("./captcha/test9.png"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 图片验证码,纯小写字母,7位
     *
     * @throws FileNotFoundException 文件未发现异常
     */
    @Test
    void test10() throws IOException, FontFormatException
    {
        Captcha captcha = new SpecCaptcha(200, 100,7);
        //public static final int TYPE_DEFAULT = 1;  // 字母数字混合
        //public static final int TYPE_ONLY_NUMBER = 2;  // 纯数字
        //public static final int TYPE_ONLY_CHAR = 3;  // 纯字母
        //public static final int TYPE_ONLY_UPPER = 4;  // 纯大写字母
        //public static final int TYPE_ONLY_LOWER = 5;  // 纯小写字母
        //public static final int TYPE_NUM_AND_UPPER = 6;  // 数字大写字母
        captcha.setCharType(5);
        //public static final int FONT_1 = 0;
        //public static final int FONT_2 = 1;
        //public static final int FONT_3 = 2;
        //public static final int FONT_4 = 3;
        //public static final int FONT_5 = 4;
        //public static final int FONT_6 = 5;
        //public static final int FONT_7 = 6;
        //public static final int FONT_8 = 7;
        //public static final int FONT_9 = 8;
        //public static final int FONT_10 = 9;
        captcha.setFont(2);
        captcha.out(new FileOutputStream("./captcha/test10.png"));
        String text = captcha.text();
        System.out.println(text);
    }
}

```





![image-20221110134558621](img/通用权限系统实战学习笔记/image-20221110134558621.png)



![image-20221110134548931](img/通用权限系统实战学习笔记/image-20221110134548931.png)







![image-20221110134710560](img/通用权限系统实战学习笔记/image-20221110134710560.png)



![image-20221110134724826](img/通用权限系统实战学习笔记/image-20221110134724826.png)



![image-20221110192218765](img/通用权限系统实战学习笔记/image-20221110192218765.png)



![image-20221110192232325](img/通用权限系统实战学习笔记/image-20221110192232325.png)





![image-20221110192356480](img/通用权限系统实战学习笔记/image-20221110192356480.png)



![image-20221110192408078](img/通用权限系统实战学习笔记/image-20221110192408078.png)









```java
package mao.auth_server.Captcha;

import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.Captcha
 * Class(类名): EasyCaptchaChineseCaptchaTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:25
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class EasyCaptchaChineseCaptchaTest
{
    /**
     * 中文类型图片验证码
     *
     * @throws IOException         IOException
     * @throws FontFormatException 字体格式异常
     */
    @Test
    void test11() throws IOException, FontFormatException
    {
        Captcha captcha = new ChineseCaptcha(250, 100);
        captcha.out(new FileOutputStream("./captcha/test11.png"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 中文类型图片验证码,6位
     *
     * @throws IOException         IOException
     * @throws FontFormatException 字体格式异常
     */
    @Test
    void test12() throws IOException, FontFormatException
    {
        Captcha captcha = new ChineseCaptcha(250, 100, 6);
        captcha.out(new FileOutputStream("./captcha/test12.png"));
        String text = captcha.text();
        System.out.println(text);
    }

    /**
     * 中文类型图片验证码,8位
     *
     * @throws IOException         IOException
     * @throws FontFormatException 字体格式异常
     */
    @Test
    void test13() throws IOException, FontFormatException
    {
        Captcha captcha = new ChineseCaptcha(250, 100, 8);
        captcha.out(new FileOutputStream("./captcha/test13.png"));
        String text = captcha.text();
        System.out.println(text);
    }
}
```





![image-20221110193023042](img/通用权限系统实战学习笔记/image-20221110193023042.png)



![image-20221110193032177](img/通用权限系统实战学习笔记/image-20221110193032177.png)





![image-20221110193141477](img/通用权限系统实战学习笔记/image-20221110193141477.png)



![image-20221110193149950](img/通用权限系统实战学习笔记/image-20221110193149950.png)





![image-20221110193244846](img/通用权限系统实战学习笔记/image-20221110193244846.png)



![image-20221110193253666](img/通用权限系统实战学习笔记/image-20221110193253666.png)





![image-20221110193743743](img/通用权限系统实战学习笔记/image-20221110193743743.png)





![image-20221110193756851](img/通用权限系统实战学习笔记/image-20221110193756851.png)





![test14](img/通用权限系统实战学习笔记/test14.gif)







![image-20221110193858763](img/通用权限系统实战学习笔记/image-20221110193858763.png)



![test15](img/通用权限系统实战学习笔记/test15.gif)







![image-20221110194047323](img/通用权限系统实战学习笔记/image-20221110194047323.png)





![test16](img/通用权限系统实战学习笔记/test16.gif)

















### 开发验证码接口



第一步：创建LoginController并提供生成验证码的方法



```java
package mao.auth_server.controller.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mao.auth_server.service.auth.ValidateCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.auth
 * Class(类名): LoginController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:50
 * Version(版本): 1.0
 * Description(描述)： 登录Controller
 */

@RestController
@RequestMapping("/anno")
@Api(value = "LoginController", tags = "登录控制器")
public class LoginController
{
    @Resource
    private ValidateCodeService validateCodeService;

    @ApiOperation(value = "验证码", notes = "验证码")
    @GetMapping(value = "/captcha", produces = "image/png")
    public void captcha(@RequestParam(value = "key") String key,
                        HttpServletResponse response) throws IOException
    {
        this.validateCodeService.create(key, response);
    }
}
```





第二步：创建ValidateCodeService接口



```java
package mao.auth_server.service.auth;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): ValidateCodeService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:53
 * Version(版本): 1.0
 * Description(描述)： 验证码Service接口
 */

public interface ValidateCodeService
{
    /**
     * 生成验证码
     *
     * @param key      这个key为缓存的key
     * @param response HttpServletResponse
     * @throws IOException IOException
     */
    void create(String key, HttpServletResponse response) throws IOException;
}
```





第三步：创建ValidateCodeServiceImpl



```java
package mao.auth_server.service.auth.impl;

import com.wf.captcha.ChineseGifCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.extern.slf4j.Slf4j;
import mao.auth_server.service.auth.ValidateCodeService;
import mao.tools_common.constant.CacheKey;
import mao.tools_core.exception.BizException;
import net.oschina.j2cache.CacheChannel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): ValidateCodeServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:54
 * Version(版本): 1.0
 * Description(描述)： 验证码服务实现类
 */

@Slf4j
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService
{

    @Resource
    private CacheChannel cache;

    @Override
    public void create(String key, HttpServletResponse response) throws IOException
    {
        //判断key是否为空
        if (StringUtils.isBlank(key))
        {
            throw BizException.validFail("验证码key不能为空");
        }
        //可以不为空
        //生成验证码，中文gif验证码，6位
        Captcha captcha = new ChineseGifCaptcha(160, 80, 6);
        //设置响应类型为图片
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        //设置响应头
        response.setHeader(HttpHeaders.PRAGMA, "No-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "No-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0L);
        //获取验证码字符串
        String text = captcha.text();
        log.debug("key：" + key + "  的验证码：" + text);
        //放入缓存里
        cache.set(CacheKey.CAPTCHA, key, text);
        //输出
        captcha.out(response.getOutputStream());
    }
}
```





第四步：启动服务



```sh
.   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.9.RELEASE)

2022-11-10 20:24:48.238  WARN 10636 --- [           main] c.a.c.n.c.NacosPropertySourceBuilder     : Ignore the empty nacos configuration and get it based on dataId[auth-server] & group[DEFAULT_GROUP]
2022-11-10 20:24:48.247  INFO 10636 --- [           main] b.c.PropertySourceBootstrapConfiguration : Located property source: [BootstrapPropertySource {name='bootstrapProperties-auth-server-dev.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-auth-server.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-auth-server,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-mysql.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-redis.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-common.yml,DEFAULT_GROUP'}]
2022-11-10 20:24:48.290  INFO 10636 --- [           main] mao.auth_server.AuthServerApplication    : The following profiles are active: dev
2022-11-10 20:24:48.885  INFO 10636 --- [           main] o.s.c.a.ConfigurationClassParser         : Properties location [${j2cache.config-location}] not resolvable: Could not resolve placeholder 'j2cache.config-location' in value "${j2cache.config-location}"
2022-11-10 20:24:49.729  INFO 10636 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
2022-11-10 20:24:49.732  INFO 10636 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.
2022-11-10 20:24:49.760  INFO 10636 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 13ms. Found 0 Redis repository interfaces.
2022-11-10 20:24:49.832  WARN 10636 --- [           main] o.s.boot.actuate.endpoint.EndpointId     : Endpoint ID 'service-registry' contains invalid characters, please migrate to a valid format.
2022-11-10 20:24:50.111  INFO 10636 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=fe6362b9-7d8b-3c28-a82f-465d23cdd54a
2022-11-10 20:24:50.175  INFO 10636 --- [           main] m.t.config.ValidatorConfig               : 开启hibernate-validator快速返回
2022-11-10 20:24:50.175  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mao.tools_validator.config.ValidatorConfig' of type [mao.tools_validator.config.ValidatorConfig] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.401  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.551  INFO 10636 --- [           main] mao.tools_j2cache.config.CacheConfig     : 初始化 CacheConfig
2022-11-10 20:24:50.551  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mao.tools_j2cache.config.CacheConfig' of type [mao.tools_j2cache.config.CacheConfig] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.677  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mybatis-plus-com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties' of type [com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.687  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'database-mao.tools_databases.properties.DatabaseProperties' of type [mao.tools_databases.properties.DatabaseProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.694  INFO 10636 --- [           main] m.a.config.MybatisConfiguration          : 初始化 MybatisConfiguration
2022-11-10 20:24:50.694  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mybatisConfiguration' of type [mao.auth_server.config.MybatisConfiguration$$EnhancerBySpringCGLIB$$8d42f3ad] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.700  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'paginationInterceptor' of type [com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.707  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'getLeftLikeTypeHandler' of type [mao.tools_databases.mybatis.typehandler.LeftLikeTypeHandler] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.711  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'getRightLikeTypeHandler' of type [mao.tools_databases.mybatis.typehandler.RightLikeTypeHandler] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.713  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'getFullLikeTypeHandler' of type [mao.tools_databases.mybatis.typehandler.FullLikeTypeHandler] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.722  INFO 10636 --- [           main] m.a.config.DatabaseConfiguration         : 初始化 DatabaseConfiguration
2022-11-10 20:24:50.722  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'databaseConfiguration' of type [mao.auth_server.config.DatabaseConfiguration$$EnhancerBySpringCGLIB$$a5156a5b] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.786  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'spring.datasource-org.springframework.boot.autoconfigure.jdbc.DataSourceProperties' of type [org.springframework.boot.autoconfigure.jdbc.DataSourceProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.791  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'com.alibaba.druid.spring.boot.autoconfigure.stat.DruidFilterConfiguration' of type [com.alibaba.druid.spring.boot.autoconfigure.stat.DruidFilterConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.803  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'wallConfig' of type [com.alibaba.druid.wall.WallConfig] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.833  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'wallFilter' of type [com.alibaba.druid.wall.WallFilter] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.924  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterDruidDataSource' of type [com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.961  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.boot.autoconfigure.jdbc.DataSourceInitializerInvoker' of type [org.springframework.boot.autoconfigure.jdbc.DataSourceInitializerInvoker] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.978  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterDataSource' of type [com.p6spy.engine.spy.P6DataSource] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.984  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterTransactionManager' of type [org.springframework.jdbc.datasource.DataSourceTransactionManager] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.991  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterTransactionInterceptor' of type [org.springframework.transaction.interceptor.TransactionInterceptor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:50.992  INFO 10636 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterAdvisor' of type [org.springframework.aop.support.DefaultPointcutAdvisor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-10 20:24:51.049  INFO 10636 --- [           main] mao.auth_server.config.WebConfiguration  : 初始化 WebConfiguration
2022-11-10 20:24:51.332  INFO 10636 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8764 (http)
2022-11-10 20:24:51.346  INFO 10636 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-11-10 20:24:51.347  INFO 10636 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.37]
2022-11-10 20:24:51.528  INFO 10636 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-11-10 20:24:51.528  INFO 10636 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3215 ms
2022-11-10 20:24:51.551  INFO 10636 --- [           main] m.tools_xss.config.XssAuthConfiguration  : 初始化 XssAuthConfiguration xss攻击配置
2022-11-10 20:24:51.692  WARN 10636 --- [           main] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
2022-11-10 20:24:51.692  INFO 10636 --- [           main] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
2022-11-10 20:24:51.709  INFO 10636 --- [           main] c.netflix.config.DynamicPropertyFactory  : DynamicPropertyFactory is initialized with configuration sources: com.netflix.config.ConcurrentCompositeConfiguration@440ef8d
2022-11-10 20:24:51.840 DEBUG 10636 --- [           main] mao.tools_xss.filter.XssFilter           : XSS fiter [XSSFilter] init start ...
2022-11-10 20:24:51.902 DEBUG 10636 --- [           main] mao.tools_xss.filter.XssFilter           : ignorePathList=null
2022-11-10 20:24:51.905 DEBUG 10636 --- [           main] mao.tools_xss.filter.XssFilter           : ignoreParamValueList=["samlp:LogoutRequest"]
2022-11-10 20:24:51.906 DEBUG 10636 --- [           main] mao.tools_xss.filter.XssFilter           : XSS fiter [XSSFilter] init end
2022-11-10 20:24:51.930  INFO 10636 --- [           main] m.a.config.ExceptionConfiguration        : 初始化 ExceptionConfiguration
2022-11-10 20:24:51.933  INFO 10636 --- [           main] m.a.config.SysLogConfiguration           : 初始化 SysLogConfiguration
2022-11-10 20:24:51.942  INFO 10636 --- [           main] n.o.j.a.J2CacheAutoConfiguration         : 初始化 J2CacheAutoConfiguration
2022-11-10 20:24:52.007  INFO 10636 --- [           main] n.o.j2cache.util.SerializationUtils      : Using Serializer -> [fst:net.oschina.j2cache.util.FSTSerializer]
2022-11-10 20:24:52.010  INFO 10636 --- [           main] net.oschina.j2cache.CacheProviderHolder  : Using L1 CacheProvider : net.oschina.j2cache.caffeine.CaffeineProvider
2022-11-10 20:24:52.014  INFO 10636 --- [           main] .j.a.J2CacheSpringRedisAutoConfiguration : 初始化 J2CacheSpringRedisAutoConfiguration
2022-11-10 20:24:52.304  INFO 10636 --- [           main] net.oschina.j2cache.CacheProviderHolder  : Using L2 CacheProvider : net.oschina.j2cache.cache.support.redis.SpringRedisProvider
2022-11-10 20:24:52.316  INFO 10636 --- [           main] net.oschina.j2cache.J2CacheBuilder       : Using cluster policy : net.oschina.j2cache.cache.support.redis.SpringRedisPubSubPolicy
2022-11-10 20:24:52.320 DEBUG 10636 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-10 20:24:52.335 DEBUG 10636 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-10 20:24:52.335 DEBUG 10636 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-10 20:24:52.336 DEBUG 10636 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-10 20:24:52.575  INFO 10636 --- [           main] m.t.config.LoginArgResolverConfig        : 初始化 LoginArgResolverConfig
2022-11-10 20:24:52.740  INFO 10636 --- [           main] .j.a.J2CacheSpringCacheAutoConfiguration : 初始化 J2CacheSpringCacheAutoConfiguration
2022-11-10 20:24:54.052  INFO 10636 --- [           main] o.s.cloud.commons.util.InetUtils         : Cannot determine local hostname
2022-11-10 20:24:54.059  INFO 10636 --- [           main] com.alibaba.nacos.client.naming          : initializer namespace from System Property :null
2022-11-10 20:24:54.060  INFO 10636 --- [           main] com.alibaba.nacos.client.naming          : initializer namespace from System Environment :null
2022-11-10 20:24:54.060  INFO 10636 --- [           main] com.alibaba.nacos.client.naming          : initializer namespace from System Property :null
2022-11-10 20:24:54.140  INFO 10636 --- [           main] mao.tools_j2cache.config.RedissonConfig  : 初始化 RedissonConfig
2022-11-10 20:24:54.142  INFO 10636 --- [           main] mao.tools_j2cache.config.RedissonConfig  : 单机模式redis:127.0.0.1:6379
2022-11-10 20:24:54.294  INFO 10636 --- [           main] org.redisson.Version                     : Redisson 3.17.0
2022-11-10 20:24:55.060  INFO 10636 --- [sson-netty-4-14] o.r.c.pool.MasterPubSubConnectionPool    : 1 connections initialized for 127.0.0.1/127.0.0.1:6379
2022-11-10 20:24:55.076  INFO 10636 --- [sson-netty-4-19] o.r.c.pool.MasterConnectionPool          : 24 connections initialized for 127.0.0.1/127.0.0.1:6379
2022-11-10 20:24:55.339  INFO 10636 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 20 endpoint(s) beneath base path '/actuator'
2022-11-10 20:24:56.188  INFO 10636 --- [           main] mao.tools_log.utils.AddressUtil          : bean [org.lionsoul.ip2region.DbConfig@52efb338]
2022-11-10 20:24:56.188  INFO 10636 --- [           main] mao.tools_log.utils.AddressUtil          : bean [org.lionsoul.ip2region.DbSearcher@64508788]
2022-11-10 20:24:56.269 DEBUG 10636 --- [           main] mao.tools_xss.utils.XssUtils             :  start read XSS configfile [antisamy-slashdot-1.4.4.xml]
2022-11-10 20:24:56.276 DEBUG 10636 --- [           main] mao.tools_xss.utils.XssUtils             : read XSS configfile [antisamy-slashdot-1.4.4.xml] success
 _ _   |_  _ _|_. ___ _ |    _ 
| | |\/|_)(_| | |_\  |_)||_|_\ 
     /               |         
                        3.2.0 
2022-11-10 20:24:56.995  INFO 10636 --- [           main] m.t.s.config.AuthServerConfiguration     : 初始化 AuthServerConfiguration
2022-11-10 20:24:57.028  WARN 10636 --- [           main] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
2022-11-10 20:24:57.029  INFO 10636 --- [           main] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
2022-11-10 20:24:57.120  INFO 10636 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2022-11-10 20:24:57.322  INFO 10636 --- [           main] o.s.s.c.ThreadPoolTaskScheduler          : Initializing ExecutorService 'Nacos-Watch-Task-Scheduler'
2022-11-10 20:24:57.364  INFO 10636 --- [           main] c.g.d.core.DozerBeanMapperBuilder        : Initializing Dozer. Version: 6.5.0, Thread Name: main
2022-11-10 20:24:57.366  INFO 10636 --- [           main] c.g.dozermapper.core.util.RuntimeUtils   : OSGi support is false
2022-11-10 20:24:57.371  INFO 10636 --- [           main] d.c.c.r.LegacyPropertiesSettingsResolver : Trying to find Dozer configuration file: dozer.properties
2022-11-10 20:24:57.375  INFO 10636 --- [           main] d.c.c.r.LegacyPropertiesSettingsResolver : Failed to find dozer.properties via com.github.dozermapper.core.config.resolvers.LegacyPropertiesSettingsResolver.
2022-11-10 20:24:57.380  INFO 10636 --- [           main] c.g.d.core.el.ELExpressionFactory        : javax.el support is true
2022-11-10 20:24:57.407  INFO 10636 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Using URL [file:/H:/%e7%a8%8b%e5%ba%8f/%e5%a4%a7%e5%9b%9b%e4%b8%8a%e6%9c%9f/authority/apps/auth/auth-server/target/classes/dozer/global.dozer.xml] to load custom xml mappings
2022-11-10 20:24:57.695  INFO 10636 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Trying to resolve XML entity with public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-10 20:24:57.696  INFO 10636 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Resolved public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-10 20:24:57.743  INFO 10636 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Successfully loaded custom xml mapping.
2022-11-10 20:24:57.744  INFO 10636 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Using URL [file:/H:/%e7%a8%8b%e5%ba%8f/%e5%a4%a7%e5%9b%9b%e4%b8%8a%e6%9c%9f/authority/apps/auth/auth-server/target/classes/dozer/biz.dozer.xml] to load custom xml mappings
2022-11-10 20:24:57.746  INFO 10636 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Trying to resolve XML entity with public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-10 20:24:57.747  INFO 10636 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Resolved public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-10 20:24:57.755  INFO 10636 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Successfully loaded custom xml mapping.
2022-11-10 20:24:57.840  INFO 10636 --- [           main] m.tools_j2cache.config.RedisUtilsConfig  : 初始化 RedisUtilsConfig
2022-11-10 20:24:57.841  INFO 10636 --- [           main] m.tools_log.config.LogAutoConfiguration  : 初始化 LogAutoConfiguration
2022-11-10 20:24:57.846  INFO 10636 --- [           main] m.t.config.DozerAutoConfiguration        : 初始化 DozerAutoConfiguration
2022-11-10 20:24:57.865  INFO 10636 --- [           main] pertySourcedRequestMappingHandlerMapping : Mapped URL path [/v2/api-docs] onto method [springfox.documentation.swagger2.web.Swagger2Controller#getDocumentation(String, HttpServletRequest)]
2022-11-10 20:24:57.879  INFO 10636 --- [           main] m.t.config.SwaggerAutoConfiguration      : 初始化swagger接口文档
2022-11-10 20:24:57.880  INFO 10636 --- [           main] m.t.config.SwaggerAutoConfiguration      : 
title：在线文档
group：
description：在线文档
version：1.0
contact：Contact{name='mao', url='https://github.com/maomao124/', email='1234@qq.com'}
basePackage：
basePath：[]
excludePath：[]
docket：{auth=DocketInfo{title='权限模块', group='', description='在线文档', version='1.0', contact=Contact{name='', url='', email=''}, basePackage='mao.auth_server.controller.auth', basePath=[], excludePath=[]}, common=DocketInfo{title='公共模块', group='', description='在线文档', version='1.0', contact=Contact{name='', url='', email=''}, basePackage='mao.auth_server.controller.common', basePath=[], excludePath=[]}, core=DocketInfo{title='组织岗位模块', group='', description='在线文档', version='1.0', contact=Contact{name='', url='', email=''}, basePackage='mao.auth_server.controller.core', basePath=[], excludePath=[]}}

2022-11-10 20:24:59.417  INFO 10636 --- [           main] o.s.cloud.commons.util.InetUtils         : Cannot determine local hostname
2022-11-10 20:24:59.696  INFO 10636 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2022-11-10 20:24:59.726  INFO 10636 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 3 custom documentation plugin(s)
2022-11-10 20:24:59.786  INFO 10636 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2022-11-10 20:24:59.811  INFO 10636 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2022-11-10 20:24:59.899  INFO 10636 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2022-11-10 20:25:00.006  INFO 10636 --- [enerContainer-1] io.lettuce.core.EpollProvider            : Starting without optional epoll library
2022-11-10 20:25:00.008  INFO 10636 --- [enerContainer-1] io.lettuce.core.KqueueProvider           : Starting without optional kqueue library
2022-11-10 20:25:00.172  INFO 10636 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8764 (http) with context path ''
2022-11-10 20:25:00.178  INFO 10636 --- [           main] com.alibaba.nacos.client.naming          : [BEAT] adding beat: BeatInfo{port=8764, ip='192.168.202.1', weight=1.0, serviceName='DEFAULT_GROUP@@auth-server', cluster='DEFAULT', metadata={preserved.register.source=SPRING_CLOUD, management.endpoints.web.base-path=/actuator, management.context-path=/actuator}, scheduled=false, period=5000, stopped=false} to beat map.
2022-11-10 20:25:00.179  INFO 10636 --- [           main] com.alibaba.nacos.client.naming          : [REGISTER-SERVICE] 27ce69b0-bff1-4c03-8f3e-0ea5559a5732 registering service DEFAULT_GROUP@@auth-server with instance: Instance{instanceId='null', ip='192.168.202.1', port=8764, weight=1.0, healthy=true, enabled=true, ephemeral=true, clusterName='DEFAULT', serviceName='null', metadata={preserved.register.source=SPRING_CLOUD, management.endpoints.web.base-path=/actuator, management.context-path=/actuator}}
2022-11-10 20:25:00.183  INFO 10636 --- [           main] c.a.c.n.registry.NacosServiceRegistry    : nacos registry, DEFAULT_GROUP auth-server 192.168.202.1:8764 register finished
2022-11-10 20:25:00.718  INFO 10636 --- [.naming.updater] com.alibaba.nacos.client.naming          : new ips(1) service: DEFAULT_GROUP@@auth-server@@DEFAULT -> [{"instanceId":"192.168.202.1#8764#DEFAULT#DEFAULT_GROUP@@auth-server","ip":"192.168.202.1","port":8764,"weight":1.0,"healthy":true,"enabled":true,"ephemeral":true,"clusterName":"DEFAULT","serviceName":"DEFAULT_GROUP@@auth-server","metadata":{"preserved.register.source":"SPRING_CLOUD","management.endpoints.web.base-path":"/actuator","management.context-path":"/actuator"},"ipDeleteTimeout":30000,"instanceHeartBeatInterval":5000,"instanceHeartBeatTimeOut":15000}]
2022-11-10 20:25:00.730  INFO 10636 --- [.naming.updater] com.alibaba.nacos.client.naming          : current ips:(1) service: DEFAULT_GROUP@@auth-server@@DEFAULT -> [{"instanceId":"192.168.202.1#8764#DEFAULT#DEFAULT_GROUP@@auth-server","ip":"192.168.202.1","port":8764,"weight":1.0,"healthy":true,"enabled":true,"ephemeral":true,"clusterName":"DEFAULT","serviceName":"DEFAULT_GROUP@@auth-server","metadata":{"preserved.register.source":"SPRING_CLOUD","management.endpoints.web.base-path":"/actuator","management.context-path":"/actuator"},"ipDeleteTimeout":30000,"instanceHeartBeatInterval":5000,"instanceHeartBeatTimeOut":15000}]
2022-11-10 20:25:01.184  INFO 10636 --- [g.push.receiver] com.alibaba.nacos.client.naming          : received push data: {"type":"dom","data":"{\"hosts\":[{\"ip\":\"192.168.202.1\",\"port\":8764,\"valid\":true,\"healthy\":true,\"marked\":false,\"instanceId\":\"192.168.202.1#8764#DEFAULT#DEFAULT_GROUP@@auth-server\",\"metadata\":{\"preserved.register.source\":\"SPRING_CLOUD\",\"management.endpoints.web.base-path\":\"/actuator\",\"management.context-path\":\"/actuator\"},\"enabled\":true,\"weight\":1.0,\"clusterName\":\"DEFAULT\",\"serviceName\":\"DEFAULT_GROUP@@auth-server\",\"ephemeral\":true}],\"dom\":\"DEFAULT_GROUP@@auth-server\",\"name\":\"DEFAULT_GROUP@@auth-server\",\"cacheMillis\":10000,\"lastRefTime\":1668083101184,\"checksum\":\"d706e8bc2779a32044465e588c1a9d58\",\"useSpecifiedURL\":false,\"clusters\":\"DEFAULT\",\"env\":\"\",\"metadata\":{}}","lastRefTime":4108972626000} from /192.168.202.1
2022-11-10 20:25:01.432  INFO 10636 --- [           main] o.s.cloud.commons.util.InetUtils         : Cannot determine local hostname
2022-11-10 20:25:01.434  INFO 10636 --- [           main] mao.auth_server.AuthServerApplication    : Started AuthServerApplication in 16.943 seconds (JVM running for 17.993)
2022-11-10 20:25:01.442  INFO 10636 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] auth-server-dev.yml+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-10 20:25:01.444  INFO 10636 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=auth-server-dev.yml, group=DEFAULT_GROUP, cnt=1
2022-11-10 20:25:01.445  INFO 10636 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] auth-server+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-10 20:25:01.445  INFO 10636 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=auth-server, group=DEFAULT_GROUP, cnt=1
2022-11-10 20:25:01.455  INFO 10636 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] auth-server.yml+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-10 20:25:01.456  INFO 10636 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=auth-server.yml, group=DEFAULT_GROUP, cnt=1
2022-11-10 20:25:01.458  INFO 10636 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] common.yml+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-10 20:25:01.459  INFO 10636 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=common.yml, group=DEFAULT_GROUP, cnt=1
2022-11-10 20:25:01.460  INFO 10636 --- [           main] mao.auth_server.AuthServerApplication    : 应用auth-server启动成功!swagger地址：http://192.168.202.1:8764/doc.html
2022-11-10 20:25:01.460  INFO 10636 --- [           main] mao.auth_server.AuthServerApplication    : 启动耗时：17108ms
2022-11-10 20:25:01.830  INFO 10636 --- [)-192.168.202.1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-11-10 20:25:01.830  INFO 10636 --- [)-192.168.202.1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-11-10 20:25:01.846  INFO 10636 --- [)-192.168.202.1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 16 ms
2022-11-10 20:25:02.365  INFO 10636 --- [)-192.168.202.1] com.alibaba.druid.pool.DruidDataSource   : {dataSource-1} inited
 Consume Time：2 ms 2022-11-10 20:25:02
 Execute SQL：/* ping */ SELECT 1
```







第五步：访问接口文档



http://127.0.0.1:8764/doc.html



![image-20221110202705902](img/通用权限系统实战学习笔记/image-20221110202705902.png)





![image-20221110202735412](img/通用权限系统实战学习笔记/image-20221110202735412.png)





![image-20221110202751008](img/通用权限系统实战学习笔记/image-20221110202751008.png)





```sh
2022-11-10 20:27:15.903 DEBUG 10636 --- [nio-8764-exec-3] mao.tools_xss.utils.XssUtils             : raw value before xssClean: captcha:10001
2022-11-10 20:27:15.903 DEBUG 10636 --- [nio-8764-exec-3] mao.tools_xss.utils.XssUtils             : xssfilter value after xssClean: captcha:10001
2022-11-10 20:27:15.928 DEBUG 10636 --- [nio-8764-exec-3] m.a.s.auth.impl.ValidateCodeServiceImpl  : key：captcha:10001  的验证码：造动代工成建
2022-11-10 20:27:16.277 DEBUG 10636 --- [nio-8764-exec-3] mao.tools_xss.filter.XssFilter           : XSS fiter [XSSFilter] stop
2022-11-10 20:27:18.262 DEBUG 10636 --- [nio-8764-exec-4] mao.tools_xss.filter.XssFilter           : XSS fiter [XSSFilter] starting
2022-11-10 20:27:18.262 DEBUG 10636 --- [nio-8764-exec-4] mao.tools_xss.filter.XssFilter           : has xssfiter path[/anno/captcha] need XssFilter, go to XssRequestWrapper
2022-11-10 20:27:18.263 DEBUG 10636 --- [nio-8764-exec-4] mao.tools_xss.utils.XssUtils             : raw value before xssClean: captcha:10001
2022-11-10 20:27:18.263 DEBUG 10636 --- [nio-8764-exec-4] mao.tools_xss.utils.XssUtils             : xssfilter value after xssClean: captcha:10001
2022-11-10 20:27:18.264 DEBUG 10636 --- [nio-8764-exec-4] m.a.s.auth.impl.ValidateCodeServiceImpl  : key：captcha:10001  的验证码：水帮晚呀雪五
2022-11-10 20:27:18.288 DEBUG 10636 --- [nio-8764-exec-4] mao.tools_xss.filter.XssFilter           : XSS fiter [XSSFilter] stop
```















### 开发认证接口

dao层的增删改查略



第一步：创建工具类BCrypt



```java
package mao.auth_server.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.utils
 * Class(类名): BCrypt
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class BCrypt
{
    // BCrypt parameters
    private static final int GENSALT_DEFAULT_LOG2_ROUNDS = 10;

    private static final int BCRYPT_SALT_LEN = 16;

    // Blowfish parameters
    private static final int BLOWFISH_NUM_ROUNDS = 16;

    // Initial contents of key schedule
    private static final int[] P_orig = {0x243f6a88, 0x85a308d3, 0x13198a2e, 0x03707344, 0xa4093822, 0x299f31d0,
            0x082efa98, 0xec4e6c89, 0x452821e6, 0x38d01377, 0xbe5466cf, 0x34e90c6c, 0xc0ac29b7, 0xc97c50dd, 0x3f84d5b5,
            0xb5470917, 0x9216d5d9, 0x8979fb1b};

    private static final int[] S_orig = {0xd1310ba6, 0x98dfb5ac, 0x2ffd72db, 0xd01adfb7, 0xb8e1afed, 0x6a267e96,
            0xba7c9045, 0xf12c7f99, 0x24a19947, 0xb3916cf7, 0x0801f2e2, 0x858efc16, 0x636920d8, 0x71574e69, 0xa458fea3,
            0xf4933d7e, 0x0d95748f, 0x728eb658, 0x718bcd58, 0x82154aee, 0x7b54a41d, 0xc25a59b5, 0x9c30d539, 0x2af26013,
            0xc5d1b023, 0x286085f0, 0xca417918, 0xb8db38ef, 0x8e79dcb0, 0x603a180e, 0x6c9e0e8b, 0xb01e8a3e, 0xd71577c1,
            0xbd314b27, 0x78af2fda, 0x55605c60, 0xe65525f3, 0xaa55ab94, 0x57489862, 0x63e81440, 0x55ca396a, 0x2aab10b6,
            0xb4cc5c34, 0x1141e8ce, 0xa15486af, 0x7c72e993, 0xb3ee1411, 0x636fbc2a, 0x2ba9c55d, 0x741831f6, 0xce5c3e16,
            0x9b87931e, 0xafd6ba33, 0x6c24cf5c, 0x7a325381, 0x28958677, 0x3b8f4898, 0x6b4bb9af, 0xc4bfe81b, 0x66282193,
            0x61d809cc, 0xfb21a991, 0x487cac60, 0x5dec8032, 0xef845d5d, 0xe98575b1, 0xdc262302, 0xeb651b88, 0x23893e81,
            0xd396acc5, 0x0f6d6ff3, 0x83f44239, 0x2e0b4482, 0xa4842004, 0x69c8f04a, 0x9e1f9b5e, 0x21c66842, 0xf6e96c9a,
            0x670c9c61, 0xabd388f0, 0x6a51a0d2, 0xd8542f68, 0x960fa728, 0xab5133a3, 0x6eef0b6c, 0x137a3be4, 0xba3bf050,
            0x7efb2a98, 0xa1f1651d, 0x39af0176, 0x66ca593e, 0x82430e88, 0x8cee8619, 0x456f9fb4, 0x7d84a5c3, 0x3b8b5ebe,
            0xe06f75d8, 0x85c12073, 0x401a449f, 0x56c16aa6, 0x4ed3aa62, 0x363f7706, 0x1bfedf72, 0x429b023d, 0x37d0d724,
            0xd00a1248, 0xdb0fead3, 0x49f1c09b, 0x075372c9, 0x80991b7b, 0x25d479d8, 0xf6e8def7, 0xe3fe501a, 0xb6794c3b,
            0x976ce0bd, 0x04c006ba, 0xc1a94fb6, 0x409f60c4, 0x5e5c9ec2, 0x196a2463, 0x68fb6faf, 0x3e6c53b5, 0x1339b2eb,
            0x3b52ec6f, 0x6dfc511f, 0x9b30952c, 0xcc814544, 0xaf5ebd09, 0xbee3d004, 0xde334afd, 0x660f2807, 0x192e4bb3,
            0xc0cba857, 0x45c8740f, 0xd20b5f39, 0xb9d3fbdb, 0x5579c0bd, 0x1a60320a, 0xd6a100c6, 0x402c7279, 0x679f25fe,
            0xfb1fa3cc, 0x8ea5e9f8, 0xdb3222f8, 0x3c7516df, 0xfd616b15, 0x2f501ec8, 0xad0552ab, 0x323db5fa, 0xfd238760,
            0x53317b48, 0x3e00df82, 0x9e5c57bb, 0xca6f8ca0, 0x1a87562e, 0xdf1769db, 0xd542a8f6, 0x287effc3, 0xac6732c6,
            0x8c4f5573, 0x695b27b0, 0xbbca58c8, 0xe1ffa35d, 0xb8f011a0, 0x10fa3d98, 0xfd2183b8, 0x4afcb56c, 0x2dd1d35b,
            0x9a53e479, 0xb6f84565, 0xd28e49bc, 0x4bfb9790, 0xe1ddf2da, 0xa4cb7e33, 0x62fb1341, 0xcee4c6e8, 0xef20cada,
            0x36774c01, 0xd07e9efe, 0x2bf11fb4, 0x95dbda4d, 0xae909198, 0xeaad8e71, 0x6b93d5a0, 0xd08ed1d0, 0xafc725e0,
            0x8e3c5b2f, 0x8e7594b7, 0x8ff6e2fb, 0xf2122b64, 0x8888b812, 0x900df01c, 0x4fad5ea0, 0x688fc31c, 0xd1cff191,
            0xb3a8c1ad, 0x2f2f2218, 0xbe0e1777, 0xea752dfe, 0x8b021fa1, 0xe5a0cc0f, 0xb56f74e8, 0x18acf3d6, 0xce89e299,
            0xb4a84fe0, 0xfd13e0b7, 0x7cc43b81, 0xd2ada8d9, 0x165fa266, 0x80957705, 0x93cc7314, 0x211a1477, 0xe6ad2065,
            0x77b5fa86, 0xc75442f5, 0xfb9d35cf, 0xebcdaf0c, 0x7b3e89a0, 0xd6411bd3, 0xae1e7e49, 0x00250e2d, 0x2071b35e,
            0x226800bb, 0x57b8e0af, 0x2464369b, 0xf009b91e, 0x5563911d, 0x59dfa6aa, 0x78c14389, 0xd95a537f, 0x207d5ba2,
            0x02e5b9c5, 0x83260376, 0x6295cfa9, 0x11c81968, 0x4e734a41, 0xb3472dca, 0x7b14a94a, 0x1b510052, 0x9a532915,
            0xd60f573f, 0xbc9bc6e4, 0x2b60a476, 0x81e67400, 0x08ba6fb5, 0x571be91f, 0xf296ec6b, 0x2a0dd915, 0xb6636521,
            0xe7b9f9b6, 0xff34052e, 0xc5855664, 0x53b02d5d, 0xa99f8fa1, 0x08ba4799, 0x6e85076a, 0x4b7a70e9, 0xb5b32944,
            0xdb75092e, 0xc4192623, 0xad6ea6b0, 0x49a7df7d, 0x9cee60b8, 0x8fedb266, 0xecaa8c71, 0x699a17ff, 0x5664526c,
            0xc2b19ee1, 0x193602a5, 0x75094c29, 0xa0591340, 0xe4183a3e, 0x3f54989a, 0x5b429d65, 0x6b8fe4d6, 0x99f73fd6,
            0xa1d29c07, 0xefe830f5, 0x4d2d38e6, 0xf0255dc1, 0x4cdd2086, 0x8470eb26, 0x6382e9c6, 0x021ecc5e, 0x09686b3f,
            0x3ebaefc9, 0x3c971814, 0x6b6a70a1, 0x687f3584, 0x52a0e286, 0xb79c5305, 0xaa500737, 0x3e07841c, 0x7fdeae5c,
            0x8e7d44ec, 0x5716f2b8, 0xb03ada37, 0xf0500c0d, 0xf01c1f04, 0x0200b3ff, 0xae0cf51a, 0x3cb574b2, 0x25837a58,
            0xdc0921bd, 0xd19113f9, 0x7ca92ff6, 0x94324773, 0x22f54701, 0x3ae5e581, 0x37c2dadc, 0xc8b57634, 0x9af3dda7,
            0xa9446146, 0x0fd0030e, 0xecc8c73e, 0xa4751e41, 0xe238cd99, 0x3bea0e2f, 0x3280bba1, 0x183eb331, 0x4e548b38,
            0x4f6db908, 0x6f420d03, 0xf60a04bf, 0x2cb81290, 0x24977c79, 0x5679b072, 0xbcaf89af, 0xde9a771f, 0xd9930810,
            0xb38bae12, 0xdccf3f2e, 0x5512721f, 0x2e6b7124, 0x501adde6, 0x9f84cd87, 0x7a584718, 0x7408da17, 0xbc9f9abc,
            0xe94b7d8c, 0xec7aec3a, 0xdb851dfa, 0x63094366, 0xc464c3d2, 0xef1c1847, 0x3215d908, 0xdd433b37, 0x24c2ba16,
            0x12a14d43, 0x2a65c451, 0x50940002, 0x133ae4dd, 0x71dff89e, 0x10314e55, 0x81ac77d6, 0x5f11199b, 0x043556f1,
            0xd7a3c76b, 0x3c11183b, 0x5924a509, 0xf28fe6ed, 0x97f1fbfa, 0x9ebabf2c, 0x1e153c6e, 0x86e34570, 0xeae96fb1,
            0x860e5e0a, 0x5a3e2ab3, 0x771fe71c, 0x4e3d06fa, 0x2965dcb9, 0x99e71d0f, 0x803e89d6, 0x5266c825, 0x2e4cc978,
            0x9c10b36a, 0xc6150eba, 0x94e2ea78, 0xa5fc3c53, 0x1e0a2df4, 0xf2f74ea7, 0x361d2b3d, 0x1939260f, 0x19c27960,
            0x5223a708, 0xf71312b6, 0xebadfe6e, 0xeac31f66, 0xe3bc4595, 0xa67bc883, 0xb17f37d1, 0x018cff28, 0xc332ddef,
            0xbe6c5aa5, 0x65582185, 0x68ab9802, 0xeecea50f, 0xdb2f953b, 0x2aef7dad, 0x5b6e2f84, 0x1521b628, 0x29076170,
            0xecdd4775, 0x619f1510, 0x13cca830, 0xeb61bd96, 0x0334fe1e, 0xaa0363cf, 0xb5735c90, 0x4c70a239, 0xd59e9e0b,
            0xcbaade14, 0xeecc86bc, 0x60622ca7, 0x9cab5cab, 0xb2f3846e, 0x648b1eaf, 0x19bdf0ca, 0xa02369b9, 0x655abb50,
            0x40685a32, 0x3c2ab4b3, 0x319ee9d5, 0xc021b8f7, 0x9b540b19, 0x875fa099, 0x95f7997e, 0x623d7da8, 0xf837889a,
            0x97e32d77, 0x11ed935f, 0x16681281, 0x0e358829, 0xc7e61fd6, 0x96dedfa1, 0x7858ba99, 0x57f584a5, 0x1b227263,
            0x9b83c3ff, 0x1ac24696, 0xcdb30aeb, 0x532e3054, 0x8fd948e4, 0x6dbc3128, 0x58ebf2ef, 0x34c6ffea, 0xfe28ed61,
            0xee7c3c73, 0x5d4a14d9, 0xe864b7e3, 0x42105d14, 0x203e13e0, 0x45eee2b6, 0xa3aaabea, 0xdb6c4f15, 0xfacb4fd0,
            0xc742f442, 0xef6abbb5, 0x654f3b1d, 0x41cd2105, 0xd81e799e, 0x86854dc7, 0xe44b476a, 0x3d816250, 0xcf62a1f2,
            0x5b8d2646, 0xfc8883a0, 0xc1c7b6a3, 0x7f1524c3, 0x69cb7492, 0x47848a0b, 0x5692b285, 0x095bbf00, 0xad19489d,
            0x1462b174, 0x23820e00, 0x58428d2a, 0x0c55f5ea, 0x1dadf43e, 0x233f7061, 0x3372f092, 0x8d937e41, 0xd65fecf1,
            0x6c223bdb, 0x7cde3759, 0xcbee7460, 0x4085f2a7, 0xce77326e, 0xa6078084, 0x19f8509e, 0xe8efd855, 0x61d99735,
            0xa969a7aa, 0xc50c06c2, 0x5a04abfc, 0x800bcadc, 0x9e447a2e, 0xc3453484, 0xfdd56705, 0x0e1e9ec9, 0xdb73dbd3,
            0x105588cd, 0x675fda79, 0xe3674340, 0xc5c43465, 0x713e38d8, 0x3d28f89e, 0xf16dff20, 0x153e21e7, 0x8fb03d4a,
            0xe6e39f2b, 0xdb83adf7, 0xe93d5a68, 0x948140f7, 0xf64c261c, 0x94692934, 0x411520f7, 0x7602d4f7, 0xbcf46b2e,
            0xd4a20068, 0xd4082471, 0x3320f46a, 0x43b7d4b7, 0x500061af, 0x1e39f62e, 0x97244546, 0x14214f74, 0xbf8b8840,
            0x4d95fc1d, 0x96b591af, 0x70f4ddd3, 0x66a02f45, 0xbfbc09ec, 0x03bd9785, 0x7fac6dd0, 0x31cb8504, 0x96eb27b3,
            0x55fd3941, 0xda2547e6, 0xabca0a9a, 0x28507825, 0x530429f4, 0x0a2c86da, 0xe9b66dfb, 0x68dc1462, 0xd7486900,
            0x680ec0a4, 0x27a18dee, 0x4f3ffea2, 0xe887ad8c, 0xb58ce006, 0x7af4d6b6, 0xaace1e7c, 0xd3375fec, 0xce78a399,
            0x406b2a42, 0x20fe9e35, 0xd9f385b9, 0xee39d7ab, 0x3b124e8b, 0x1dc9faf7, 0x4b6d1856, 0x26a36631, 0xeae397b2,
            0x3a6efa74, 0xdd5b4332, 0x6841e7f7, 0xca7820fb, 0xfb0af54e, 0xd8feb397, 0x454056ac, 0xba489527, 0x55533a3a,
            0x20838d87, 0xfe6ba9b7, 0xd096954b, 0x55a867bc, 0xa1159a58, 0xcca92963, 0x99e1db33, 0xa62a4a56, 0x3f3125f9,
            0x5ef47e1c, 0x9029317c, 0xfdf8e802, 0x04272f70, 0x80bb155c, 0x05282ce3, 0x95c11548, 0xe4c66d22, 0x48c1133f,
            0xc70f86dc, 0x07f9c9ee, 0x41041f0f, 0x404779a4, 0x5d886e17, 0x325f51eb, 0xd59bc0d1, 0xf2bcc18f, 0x41113564,
            0x257b7834, 0x602a9c60, 0xdff8e8a3, 0x1f636c1b, 0x0e12b4c2, 0x02e1329e, 0xaf664fd1, 0xcad18115, 0x6b2395e0,
            0x333e92e1, 0x3b240b62, 0xeebeb922, 0x85b2a20e, 0xe6ba0d99, 0xde720c8c, 0x2da2f728, 0xd0127845, 0x95b794fd,
            0x647d0862, 0xe7ccf5f0, 0x5449a36f, 0x877d48fa, 0xc39dfd27, 0xf33e8d1e, 0x0a476341, 0x992eff74, 0x3a6f6eab,
            0xf4f8fd37, 0xa812dc60, 0xa1ebddf8, 0x991be14c, 0xdb6e6b0d, 0xc67b5510, 0x6d672c37, 0x2765d43b, 0xdcd0e804,
            0xf1290dc7, 0xcc00ffa3, 0xb5390f92, 0x690fed0b, 0x667b9ffb, 0xcedb7d9c, 0xa091cf0b, 0xd9155ea3, 0xbb132f88,
            0x515bad24, 0x7b9479bf, 0x763bd6eb, 0x37392eb3, 0xcc115979, 0x8026e297, 0xf42e312d, 0x6842ada7, 0xc66a2b3b,
            0x12754ccc, 0x782ef11c, 0x6a124237, 0xb79251e7, 0x06a1bbe6, 0x4bfb6350, 0x1a6b1018, 0x11caedfa, 0x3d25bdd8,
            0xe2e1c3c9, 0x44421659, 0x0a121386, 0xd90cec6e, 0xd5abea2a, 0x64af674e, 0xda86a85f, 0xbebfe988, 0x64e4c3fe,
            0x9dbc8057, 0xf0f7c086, 0x60787bf8, 0x6003604d, 0xd1fd8346, 0xf6381fb0, 0x7745ae04, 0xd736fccc, 0x83426b33,
            0xf01eab71, 0xb0804187, 0x3c005e5f, 0x77a057be, 0xbde8ae24, 0x55464299, 0xbf582e61, 0x4e58f48f, 0xf2ddfda2,
            0xf474ef38, 0x8789bdc2, 0x5366f9c3, 0xc8b38e74, 0xb475f255, 0x46fcd9b9, 0x7aeb2661, 0x8b1ddf84, 0x846a0e79,
            0x915f95e2, 0x466e598e, 0x20b45770, 0x8cd55591, 0xc902de4c, 0xb90bace1, 0xbb8205d0, 0x11a86248, 0x7574a99e,
            0xb77f19b6, 0xe0a9dc09, 0x662d09a1, 0xc4324633, 0xe85a1f02, 0x09f0be8c, 0x4a99a025, 0x1d6efe10, 0x1ab93d1d,
            0x0ba5a4df, 0xa186f20f, 0x2868f169, 0xdcb7da83, 0x573906fe, 0xa1e2ce9b, 0x4fcd7f52, 0x50115e01, 0xa70683fa,
            0xa002b5c4, 0x0de6d027, 0x9af88c27, 0x773f8641, 0xc3604c06, 0x61a806b5, 0xf0177a28, 0xc0f586e0, 0x006058aa,
            0x30dc7d62, 0x11e69ed7, 0x2338ea63, 0x53c2dd94, 0xc2c21634, 0xbbcbee56, 0x90bcb6de, 0xebfc7da1, 0xce591d76,
            0x6f05e409, 0x4b7c0188, 0x39720a3d, 0x7c927c24, 0x86e3725f, 0x724d9db9, 0x1ac15bb4, 0xd39eb8fc, 0xed545578,
            0x08fca5b5, 0xd83d7cd3, 0x4dad0fc4, 0x1e50ef5e, 0xb161e6f8, 0xa28514d9, 0x6c51133c, 0x6fd5c7e7, 0x56e14ec4,
            0x362abfce, 0xddc6c837, 0xd79a3234, 0x92638212, 0x670efa8e, 0x406000e0, 0x3a39ce37, 0xd3faf5cf, 0xabc27737,
            0x5ac52d1b, 0x5cb0679e, 0x4fa33742, 0xd3822740, 0x99bc9bbe, 0xd5118e9d, 0xbf0f7315, 0xd62d1c7e, 0xc700c47b,
            0xb78c1b6b, 0x21a19045, 0xb26eb1be, 0x6a366eb4, 0x5748ab2f, 0xbc946e79, 0xc6a376d2, 0x6549c2c8, 0x530ff8ee,
            0x468dde7d, 0xd5730a1d, 0x4cd04dc6, 0x2939bbdb, 0xa9ba4650, 0xac9526e8, 0xbe5ee304, 0xa1fad5f0, 0x6a2d519a,
            0x63ef8ce2, 0x9a86ee22, 0xc089c2b8, 0x43242ef6, 0xa51e03aa, 0x9cf2d0a4, 0x83c061ba, 0x9be96a4d, 0x8fe51550,
            0xba645bd6, 0x2826a2f9, 0xa73a3ae1, 0x4ba99586, 0xef5562e9, 0xc72fefd3, 0xf752f7da, 0x3f046f69, 0x77fa0a59,
            0x80e4a915, 0x87b08601, 0x9b09e6ad, 0x3b3ee593, 0xe990fd5a, 0x9e34d797, 0x2cf0b7d9, 0x022b8b51, 0x96d5ac3a,
            0x017da67d, 0xd1cf3ed6, 0x7c7d2d28, 0x1f9f25cf, 0xadf2b89b, 0x5ad6b472, 0x5a88f54c, 0xe029ac71, 0xe019a5e6,
            0x47b0acfd, 0xed93fa9b, 0xe8d3c48d, 0x283b57cc, 0xf8d56629, 0x79132e28, 0x785f0191, 0xed756055, 0xf7960e44,
            0xe3d35e8c, 0x15056dd4, 0x88f46dba, 0x03a16125, 0x0564f0bd, 0xc3eb9e15, 0x3c9057a2, 0x97271aec, 0xa93a072a,
            0x1b3f6d9b, 0x1e6321f5, 0xf59c66fb, 0x26dcf319, 0x7533d928, 0xb155fdf5, 0x03563482, 0x8aba3cbb, 0x28517711,
            0xc20ad9f8, 0xabcc5167, 0xccad925f, 0x4de81751, 0x3830dc8e, 0x379d5862, 0x9320f991, 0xea7a90c2, 0xfb3e7bce,
            0x5121ce64, 0x774fbe32, 0xa8b6e37e, 0xc3293d46, 0x48de5369, 0x6413e680, 0xa2ae0810, 0xdd6db224, 0x69852dfd,
            0x09072166, 0xb39a460a, 0x6445c0dd, 0x586cdecf, 0x1c20c8ae, 0x5bbef7dd, 0x1b588d40, 0xccd2017f, 0x6bb4e3bb,
            0xdda26a7e, 0x3a59ff45, 0x3e350a44, 0xbcb4cdd5, 0x72eacea8, 0xfa6484bb, 0x8d6612ae, 0xbf3c6f47, 0xd29be463,
            0x542f5d9e, 0xaec2771b, 0xf64e6370, 0x740e0d8d, 0xe75b1357, 0xf8721671, 0xaf537d5d, 0x4040cb08, 0x4eb4e2cc,
            0x34d2466a, 0x0115af84, 0xe1b00428, 0x95983a1d, 0x06b89fb4, 0xce6ea048, 0x6f3f3b82, 0x3520ab82, 0x011a1d4b,
            0x277227f8, 0x611560b1, 0xe7933fdc, 0xbb3a792b, 0x344525bd, 0xa08839e1, 0x51ce794b, 0x2f32c9b7, 0xa01fbac9,
            0xe01cc87e, 0xbcc7d1f6, 0xcf0111c3, 0xa1e8aac7, 0x1a908749, 0xd44fbd9a, 0xd0dadecb, 0xd50ada38, 0x0339c32a,
            0xc6913667, 0x8df9317c, 0xe0b12b4f, 0xf79e59b7, 0x43f5bb3a, 0xf2d519ff, 0x27d9459c, 0xbf97222c, 0x15e6fc2a,
            0x0f91fc71, 0x9b941525, 0xfae59361, 0xceb69ceb, 0xc2a86459, 0x12baa8d1, 0xb6c1075e, 0xe3056a0c, 0x10d25065,
            0xcb03a442, 0xe0ec6e0e, 0x1698db3b, 0x4c98a0be, 0x3278e964, 0x9f1f9532, 0xe0d392df, 0xd3a0342b, 0x8971f21e,
            0x1b0a7441, 0x4ba3348c, 0xc5be7120, 0xc37632d8, 0xdf359f8d, 0x9b992f2e, 0xe60b6f47, 0x0fe3f11d, 0xe54cda54,
            0x1edad891, 0xce6279cf, 0xcd3e7e6f, 0x1618b166, 0xfd2c1d05, 0x848fd2c5, 0xf6fb2299, 0xf523f357, 0xa6327623,
            0x93a83531, 0x56cccd02, 0xacf08162, 0x5a75ebb5, 0x6e163697, 0x88d273cc, 0xde966292, 0x81b949d0, 0x4c50901b,
            0x71c65614, 0xe6c6c7bd, 0x327a140a, 0x45e1d006, 0xc3f27b9a, 0xc9aa53fd, 0x62a80f00, 0xbb25bfe2, 0x35bdd2f6,
            0x71126905, 0xb2040222, 0xb6cbcf7c, 0xcd769c2b, 0x53113ec0, 0x1640e3d3, 0x38abbd60, 0x2547adf0, 0xba38209c,
            0xf746ce76, 0x77afa1c5, 0x20756060, 0x85cbfe4e, 0x8ae88dd8, 0x7aaaf9b0, 0x4cf9aa7e, 0x1948c25c, 0x02fb8a8c,
            0x01c36ae4, 0xd6ebe1f9, 0x90d4f869, 0xa65cdea0, 0x3f09252d, 0xc208e69f, 0xb74e6132, 0xce77e25b, 0x578fdfe3,
            0x3ac372e6};

    // bcrypt IV: "OrpheanBeholderScryDoubt"
    static private final int[] bf_crypt_ciphertext = {0x4f727068, 0x65616e42, 0x65686f6c, 0x64657253, 0x63727944,
            0x6f756274};

    // Table for Base64 encoding
    static private final char[] base64_code = {'.', '/', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1',
            '2', '3', '4', '5', '6', '7', '8', '9'};

    // Table for Base64 decoding
    static private final byte[] index_64 = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            0, 1, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -1, -1, -1, -1, -1, -1, -1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
            12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, -1, -1, -1, -1, -1, -1, 28, 29, 30, 31, 32,
            33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, -1, -1, -1, -1, -1};
    /**
     * The Min log rounds.
     */
    static final int MIN_LOG_ROUNDS = 4;
    /**
     * The Max log rounds.
     */
    static final int MAX_LOG_ROUNDS = 31;

    // Expanded Blowfish key
    private int[] P;

    private int[] S;

    /**
     * Encode a byte array using bcrypt's slightly-modified base64 encoding scheme. Note
     * that this is <strong>not</strong> compatible with the standard MIME-base64
     * encoding.
     *
     * @param d   the byte array to encode
     * @param len the number of bytes to encode
     * @param rs  the destination buffer for the base64-encoded string
     * @throws IllegalArgumentException if the length is invalid
     */
    static void encode_base64(byte[] d, int len, StringBuilder rs) throws IllegalArgumentException
    {
        int off = 0;
        int c1, c2;

        if (len <= 0 || len > d.length)
        {
            throw new IllegalArgumentException("Invalid len");
        }

        while (off < len)
        {
            c1 = d[off++] & 0xff;
            rs.append(base64_code[(c1 >> 2) & 0x3f]);
            c1 = (c1 & 0x03) << 4;
            if (off >= len)
            {
                rs.append(base64_code[c1 & 0x3f]);
                break;
            }
            c2 = d[off++] & 0xff;
            c1 |= (c2 >> 4) & 0x0f;
            rs.append(base64_code[c1 & 0x3f]);
            c1 = (c2 & 0x0f) << 2;
            if (off >= len)
            {
                rs.append(base64_code[c1 & 0x3f]);
                break;
            }
            c2 = d[off++] & 0xff;
            c1 |= (c2 >> 6) & 0x03;
            rs.append(base64_code[c1 & 0x3f]);
            rs.append(base64_code[c2 & 0x3f]);
        }
    }

    /**
     * Look up the 3 bits base64-encoded by the specified character, range-checking againt
     * conversion table
     *
     * @param x the base64-encoded value
     * @return the decoded value of x
     */
    private static byte char64(char x)
    {
        if (x < 0 || x >= index_64.length)
        {
            return -1;
        }
        return index_64[x];
    }

    /**
     * Decode a string encoded using bcrypt's base64 scheme to a byte array. Note that
     * this is *not* compatible with the standard MIME-base64 encoding.
     *
     * @param s       the string to decode
     * @param maxolen the maximum number of bytes to decode
     * @return an array containing the decoded bytes
     * @throws IllegalArgumentException if maxolen is invalid
     */
    static byte[] decode_base64(String s, int maxolen) throws IllegalArgumentException
    {
        StringBuilder rs = new StringBuilder();
        int off = 0, slen = s.length(), olen = 0;
        byte[] ret;
        byte c1, c2, c3, c4, o;

        if (maxolen <= 0)
        {
            throw new IllegalArgumentException("Invalid maxolen");
        }

        while (off < slen - 1 && olen < maxolen)
        {
            c1 = char64(s.charAt(off++));
            c2 = char64(s.charAt(off++));
            if (c1 == -1 || c2 == -1)
            {
                break;
            }
            o = (byte) (c1 << 2);
            o |= (c2 & 0x30) >> 4;
            rs.append((char) o);
            if (++olen >= maxolen || off >= slen)
            {
                break;
            }
            c3 = char64(s.charAt(off++));
            if (c3 == -1)
            {
                break;
            }
            o = (byte) ((c2 & 0x0f) << 4);
            o |= (c3 & 0x3c) >> 2;
            rs.append((char) o);
            if (++olen >= maxolen || off >= slen)
            {
                break;
            }
            c4 = char64(s.charAt(off++));
            o = (byte) ((c3 & 0x03) << 6);
            o |= c4;
            rs.append((char) o);
            ++olen;
        }

        ret = new byte[olen];
        for (off = 0; off < olen; off++)
        {
            ret[off] = (byte) rs.charAt(off);
        }
        return ret;
    }

    /**
     * Blowfish encipher a single 64-bit block encoded as two 32-bit halves
     *
     * @param lr  an array containing the two 32-bit half blocks
     * @param off the position in the array of the blocks
     */
    private void encipher(int[] lr, int off)
    {
        int i, n, l = lr[off], r = lr[off + 1];

        l ^= this.P[0];
        for (i = 0; i <= BLOWFISH_NUM_ROUNDS - 2; )
        {
            // Feistel substitution on left word
            n = this.S[(l >> 24) & 0xff];
            n += this.S[0x100 | ((l >> 16) & 0xff)];
            n ^= this.S[0x200 | ((l >> 8) & 0xff)];
            n += this.S[0x300 | (l & 0xff)];
            r ^= n ^ this.P[++i];

            // Feistel substitution on right word
            n = this.S[(r >> 24) & 0xff];
            n += this.S[0x100 | ((r >> 16) & 0xff)];
            n ^= this.S[0x200 | ((r >> 8) & 0xff)];
            n += this.S[0x300 | (r & 0xff)];
            l ^= n ^ this.P[++i];
        }
        lr[off] = r ^ this.P[BLOWFISH_NUM_ROUNDS + 1];
        lr[off + 1] = l;
    }

    /**
     * Cycically extract a word of key material
     *
     * @param data  the string to extract the data from
     * @param offp  a "pointer" (as a one-entry array) to the current offset into data
     * @param signp a "pointer" (as a one-entry array) to the cumulative flag for
     *              non-benign sign extension
     * @return correct and buggy next word of material from data as int[2]
     */
    private static int[] streamtowords(byte[] data, int[] offp, int[] signp)
    {
        int i;
        int[] words = {0, 0};
        int off = offp[0];
        int sign = signp[0];

        for (i = 0; i < 4; i++)
        {
            words[0] = (words[0] << 8) | (data[off] & 0xff);
            words[1] = (words[1] << 8) | data[off]; // sign extension bug
            if (i > 0)
            {
                sign |= words[1] & 0x80;
            }
            off = (off + 1) % data.length;
        }

        offp[0] = off;
        signp[0] = sign;
        return words;
    }

    /**
     * Cycically extract a word of key material
     *
     * @param data the string to extract the data from
     * @param offp a "pointer" (as a one-entry array) to the current offset into data
     * @return the next word of material from data
     */
    private static int streamtoword(byte[] data, int[] offp)
    {
        int[] signp = {0};
        return streamtowords(data, offp, signp)[0];
    }

    /**
     * Cycically extract a word of key material, with sign-extension bug
     *
     * @param data the string to extract the data from
     * @param offp a "pointer" (as a one-entry array) to the current offset into data
     * @return the next word of material from data
     */
    private static int streamtoword_bug(byte[] data, int[] offp)
    {
        int[] signp = {0};
        return streamtowords(data, offp, signp)[1];
    }

    /**
     * Initialise the Blowfish key schedule
     */
    private void init_key()
    {
        this.P = P_orig.clone();
        this.S = S_orig.clone();
    }

    /**
     * Key the Blowfish cipher
     *
     * @param key          an array containing the key
     * @param sign_ext_bug true to implement the 2x bug
     * @param safety       bit 16 is set when the safety measure is requested
     */
    private void key(byte[] key, boolean sign_ext_bug, int safety)
    {
        int i;
        int[] koffp = {0};
        int[] lr = {0, 0};
        int plen = this.P.length, slen = this.S.length;

        for (i = 0; i < plen; i++)
        {
            if (!sign_ext_bug)
            {
                this.P[i] = this.P[i] ^ streamtoword(key, koffp);
            }
            else
            {
                this.P[i] = this.P[i] ^ streamtoword_bug(key, koffp);
            }
        }

        for (i = 0; i < plen; i += 2)
        {
            encipher(lr, 0);
            this.P[i] = lr[0];
            this.P[i + 1] = lr[1];
        }

        for (i = 0; i < slen; i += 2)
        {
            encipher(lr, 0);
            this.S[i] = lr[0];
            this.S[i + 1] = lr[1];
        }
    }

    /**
     * Perform the "enhanced key schedule" step described by Provos and Mazieres in "A
     * Future-Adaptable Password Scheme" https://www.openbsd.org/papers/bcrypt-paper.ps
     *
     * @param data         salt information
     * @param key          password information
     * @param sign_ext_bug true to implement the 2x bug
     * @param safety       bit 16 is set when the safety measure is requested
     */
    private void ekskey(byte[] data, byte[] key, boolean sign_ext_bug, int safety)
    {
        int i;
        int[] koffp = {0}, doffp = {0};
        int[] lr = {0, 0};
        int plen = this.P.length, slen = this.S.length;
        int[] signp = {0}; // non-benign sign-extension flag
        int diff = 0; // zero iff correct and buggy are same

        for (i = 0; i < plen; i++)
        {
            int[] words = streamtowords(key, koffp, signp);
            diff |= words[0] ^ words[1];
            this.P[i] = this.P[i] ^ words[sign_ext_bug ? 1 : 0];
        }

        int sign = signp[0];

        /*
         * At this point, "diff" is zero iff the correct and buggy algorithms produced
         * exactly the same result. If so and if "sign" is non-zero, which indicates that
         * there was a non-benign sign extension, this means that we have a collision
         * between the correctly computed hash for this password and a set of passwords
         * that could be supplied to the buggy algorithm. Our safety measure is meant to
         * protect from such many-buggy to one-correct collisions, by deviating from the
         * correct algorithm in such cases. Let's check for this.
         */
        diff |= diff >> 16; /* still zero iff exact match */
        diff &= 0xffff; /* ditto */
        diff += 0xffff; /* bit 16 set iff "diff" was non-zero (on non-match) */
        sign <<= 9; /* move the non-benign sign extension flag to bit 16 */
        sign &= ~diff & safety; /* action needed? */

        /*
         * If we have determined that we need to deviate from the correct algorithm, flip
         * bit 16 in initial expanded key. (The choice of 16 is arbitrary, but let's stick
         * to it now. It came out of the approach we used above, and it's not any worse
         * than any other choice we could make.)
         *
         * It is crucial that we don't do the same to the expanded key used in the main
         * Eksblowfish loop. By doing it to only one of these two, we deviate from a state
         * that could be directly specified by a password to the buggy algorithm (and to
         * the fully correct one as well, but that's a side-effect).
         */
        this.P[0] ^= sign;

        for (i = 0; i < plen; i += 2)
        {
            lr[0] ^= streamtoword(data, doffp);
            lr[1] ^= streamtoword(data, doffp);
            encipher(lr, 0);
            this.P[i] = lr[0];
            this.P[i + 1] = lr[1];
        }

        for (i = 0; i < slen; i += 2)
        {
            lr[0] ^= streamtoword(data, doffp);
            lr[1] ^= streamtoword(data, doffp);
            encipher(lr, 0);
            this.S[i] = lr[0];
            this.S[i + 1] = lr[1];
        }
    }

    /**
     * Rounds for log rounds long.
     *
     * @param log_rounds the log rounds
     * @return the long
     */
    static long roundsForLogRounds(int log_rounds)
    {
        if (log_rounds < 4 || log_rounds > 31)
        {
            throw new IllegalArgumentException("Bad number of rounds");
        }
        return 1L << log_rounds;
    }

    /**
     * Perform the central password hashing step in the bcrypt scheme
     *
     * @param password     the password to hash
     * @param salt         the binary salt to hash with the password
     * @param log_rounds   the binary logarithm of the number of rounds of hashing to apply
     * @param sign_ext_bug true to implement the 2x bug
     * @param safety       bit 16 is set when the safety measure is requested
     * @return an array containing the binary hashed password
     */
    private byte[] crypt_raw(byte[] password, byte[] salt, int log_rounds, boolean sign_ext_bug, int safety,
                             boolean for_check)
    {
        int[] cdata = bf_crypt_ciphertext.clone();
        int clen = cdata.length;

        long rounds;
        if (log_rounds < 4 || log_rounds > 31)
        {
            if (!for_check)
            {
                throw new IllegalArgumentException("Bad number of rounds");
            }
            if (log_rounds != 0)
            {
                throw new IllegalArgumentException("Bad number of rounds");
            }
            rounds = 0;
        }
        else
        {
            rounds = roundsForLogRounds(log_rounds);
            if (rounds < 16 || rounds > Integer.MAX_VALUE)
            {
                throw new IllegalArgumentException("Bad number of rounds");
            }
        }

        if (salt.length != BCRYPT_SALT_LEN)
        {
            throw new IllegalArgumentException("Bad salt length");
        }

        init_key();
        ekskey(salt, password, sign_ext_bug, safety);
        for (int i = 0; i < rounds; i++)
        {
            key(password, sign_ext_bug, safety);
            key(salt, false, safety);
        }

        for (int i = 0; i < 64; i++)
        {
            for (int j = 0; j < (clen >> 1); j++)
            {
                encipher(cdata, j << 1);
            }
        }

        byte[] ret = new byte[clen * 4];
        for (int i = 0, j = 0; i < clen; i++)
        {
            ret[j++] = (byte) ((cdata[i] >> 24) & 0xff);
            ret[j++] = (byte) ((cdata[i] >> 16) & 0xff);
            ret[j++] = (byte) ((cdata[i] >> 8) & 0xff);
            ret[j++] = (byte) (cdata[i] & 0xff);
        }
        return ret;
    }

    private static String hashpwforcheck(byte[] passwordb, String salt)
    {
        return hashpw(passwordb, salt, true);
    }

    /**
     * Hash a password using the OpenBSD bcrypt scheme
     *
     * @param password the password to hash
     * @param salt     the salt to hash with (perhaps generated using BCrypt.gensalt)
     * @return the hashed password
     */
    public static String hashpw(String password, String salt)
    {
        byte[] passwordb;

        passwordb = password.getBytes(StandardCharsets.UTF_8);

        return hashpw(passwordb, salt);
    }

    /**
     * Hash a password using the OpenBSD bcrypt scheme
     *
     * @param passwordb the password to hash, as a byte array
     * @param salt      the salt to hash with (perhaps generated using BCrypt.gensalt)
     * @return the hashed password
     */
    public static String hashpw(byte[] passwordb, String salt)
    {
        return hashpw(passwordb, salt, false);
    }

    private static String hashpw(byte[] passwordb, String salt, boolean for_check)
    {
        BCrypt B;
        String real_salt;
        byte[] saltb, hashed;
        char minor = (char) 0;
        int rounds, off;
        StringBuilder rs = new StringBuilder();

        if (salt == null)
        {
            throw new IllegalArgumentException("salt cannot be null");
        }

        int saltLength = salt.length();

        if (saltLength < 28)
        {
            throw new IllegalArgumentException("Invalid salt");
        }

        if (salt.charAt(0) != '$' || salt.charAt(1) != '2')
        {
            throw new IllegalArgumentException("Invalid salt version");
        }
        if (salt.charAt(2) == '$')
        {
            off = 3;
        }
        else
        {
            minor = salt.charAt(2);
            if ((minor != 'a' && minor != 'x' && minor != 'y' && minor != 'b') || salt.charAt(3) != '$')
            {
                throw new IllegalArgumentException("Invalid salt revision");
            }
            off = 4;
        }

        // Extract number of rounds
        if (salt.charAt(off + 2) > '$')
        {
            throw new IllegalArgumentException("Missing salt rounds");
        }

        if (off == 4 && saltLength < 29)
        {
            throw new IllegalArgumentException("Invalid salt");
        }
        rounds = Integer.parseInt(salt.substring(off, off + 2));

        real_salt = salt.substring(off + 3, off + 25);
        saltb = decode_base64(real_salt, BCRYPT_SALT_LEN);

        if (minor >= 'a')
        {
            passwordb = Arrays.copyOf(passwordb, passwordb.length + 1);
        }

        B = new BCrypt();
        hashed = B.crypt_raw(passwordb, saltb, rounds, minor == 'x', minor == 'a' ? 0x10000 : 0, for_check);

        rs.append("$2");
        if (minor >= 'a')
        {
            rs.append(minor);
        }
        rs.append("$");
        if (rounds < 10)
        {
            rs.append("0");
        }
        rs.append(rounds);
        rs.append("$");
        encode_base64(saltb, saltb.length, rs);
        encode_base64(hashed, bf_crypt_ciphertext.length * 4 - 1, rs);
        return rs.toString();
    }

    /**
     * Generate a salt for use with the BCrypt.hashpw() method
     *
     * @param prefix     the prefix value (default $2a)
     * @param log_rounds the log2 of the number of rounds of hashing to apply - the work                   factor therefore increases as 2**log_rounds.
     * @param random     an instance of SecureRandom to use
     * @return an encoded salt value
     * @throws IllegalArgumentException if prefix or log_rounds is invalid
     */
    public static String gensalt(String prefix, int log_rounds, SecureRandom random) throws IllegalArgumentException
    {
        StringBuilder rs = new StringBuilder();
        byte[] rnd = new byte[BCRYPT_SALT_LEN];

        if (!prefix.startsWith("$2")
                || (prefix.charAt(2) != 'a' && prefix.charAt(2) != 'y' && prefix.charAt(2) != 'b'))
        {
            throw new IllegalArgumentException("Invalid prefix");
        }
        if (log_rounds < 4 || log_rounds > 31)
        {
            throw new IllegalArgumentException("Invalid log_rounds");
        }

        random.nextBytes(rnd);

        rs.append("$2");
        rs.append(prefix.charAt(2));
        rs.append("$");
        if (log_rounds < 10)
        {
            rs.append("0");
        }
        rs.append(log_rounds);
        rs.append("$");
        encode_base64(rnd, rnd.length, rs);
        return rs.toString();
    }

    /**
     * Generate a salt for use with the BCrypt.hashpw() method
     *
     * @param prefix     the prefix value (default $2a)
     * @param log_rounds the log2 of the number of rounds of hashing to apply - the work                   factor therefore increases as 2**log_rounds.
     * @return an encoded salt value
     * @throws IllegalArgumentException if prefix or log_rounds is invalid
     */
    public static String gensalt(String prefix, int log_rounds) throws IllegalArgumentException
    {
        return gensalt(prefix, log_rounds, new SecureRandom());
    }

    /**
     * Generate a salt for use with the BCrypt.hashpw() method
     *
     * @param log_rounds the log2 of the number of rounds of hashing to apply - the work                   factor therefore increases as 2**log_rounds.
     * @param random     an instance of SecureRandom to use
     * @return an encoded salt value
     * @throws IllegalArgumentException if log_rounds is invalid
     */
    public static String gensalt(int log_rounds, SecureRandom random) throws IllegalArgumentException
    {
        return gensalt("$2a", log_rounds, random);
    }

    /**
     * Generate a salt for use with the BCrypt.hashpw() method
     *
     * @param log_rounds the log2 of the number of rounds of hashing to apply - the work                   factor therefore increases as 2**log_rounds.
     * @return an encoded salt value
     * @throws IllegalArgumentException if log_rounds is invalid
     */
    public static String gensalt(int log_rounds) throws IllegalArgumentException
    {
        return gensalt(log_rounds, new SecureRandom());
    }

    /**
     * Gensalt string.
     *
     * @param prefix the prefix
     * @return the string
     */
    public static String gensalt(String prefix)
    {
        return gensalt(prefix, GENSALT_DEFAULT_LOG2_ROUNDS);
    }

    /**
     * Generate a salt for use with the BCrypt.hashpw() method, selecting a reasonable
     * default for the number of hashing rounds to apply
     *
     * @return an encoded salt value
     */
    public static String gensalt()
    {
        return gensalt(GENSALT_DEFAULT_LOG2_ROUNDS);
    }

    /**
     * Check that a plaintext password matches a previously hashed one
     *
     * @param plaintext the plaintext password to verify
     * @param hashed    the previously-hashed password
     * @return true if the passwords match, false otherwise
     */
    public static boolean checkpw(String plaintext, String hashed)
    {
        byte[] passwordb = plaintext.getBytes(StandardCharsets.UTF_8);
        return equalsNoEarlyReturn(hashed, hashpwforcheck(passwordb, hashed));
    }

    /**
     * Check that a password (as a byte array) matches a previously hashed one
     *
     * @param passwordb the password to verify, as a byte array
     * @param hashed    the previously-hashed password
     * @return true if the passwords match, false otherwise
     * @since 5.3
     */
    public static boolean checkpw(byte[] passwordb, String hashed)
    {
        return equalsNoEarlyReturn(hashed, hashpwforcheck(passwordb, hashed));
    }

    /**
     * Equals no early return boolean.
     *
     * @param a the a
     * @param b the b
     * @return the boolean
     */
    static boolean equalsNoEarlyReturn(String a, String b)
    {
        return MessageDigest.isEqual(a.getBytes(StandardCharsets.UTF_8), b.getBytes(StandardCharsets.UTF_8));
    }
}
```







第二步：创建工具类BCryptPasswordEncoder



```java
package mao.auth_server.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.utils
 * Class(类名): BCryptPasswordEncoder
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:40
 * Version(版本): 1.0
 * Description(描述)： BCrypt
 */


public class BCryptPasswordEncoder
{
    private final Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2(a|y|b)?\\$(\\d\\d)\\$[./0-9A-Za-z]{53}");

    private final Log logger = LogFactory.getLog(getClass());

    private final int strength;

    private final BCryptVersion version;

    private final SecureRandom random;

    /**
     * Instantiates a new B crypt password encoder.
     */
    public BCryptPasswordEncoder()
    {
        this(-1);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param strength the log rounds to use, between 4 and 31
     */
    public BCryptPasswordEncoder(int strength)
    {
        this(strength, null);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param version the version of bcrypt, can be 2a,2b,2y
     */
    public BCryptPasswordEncoder(BCryptVersion version)
    {
        this(version, null);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param version the version of bcrypt, can be 2a,2b,2y
     * @param random  the secure random instance to use
     */
    public BCryptPasswordEncoder(BCryptVersion version, SecureRandom random)
    {
        this(version, -1, random);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param strength the log rounds to use, between 4 and 31
     * @param random   the secure random instance to use
     */
    public BCryptPasswordEncoder(int strength, SecureRandom random)
    {
        this(BCryptVersion.$2A, strength, random);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param version  the version of bcrypt, can be 2a,2b,2y
     * @param strength the log rounds to use, between 4 and 31
     */
    public BCryptPasswordEncoder(BCryptVersion version, int strength)
    {
        this(version, strength, null);
    }

    /**
     * Instantiates a new B crypt password encoder.
     *
     * @param version  the version of bcrypt, can be 2a,2b,2y
     * @param strength the log rounds to use, between 4 and 31
     * @param random   the secure random instance to use
     */
    public BCryptPasswordEncoder(BCryptVersion version, int strength, SecureRandom random)
    {
        if (strength != -1 && (strength < BCrypt.MIN_LOG_ROUNDS || strength > BCrypt.MAX_LOG_ROUNDS))
        {
            throw new IllegalArgumentException("Bad strength");
        }
        this.version = version;
        this.strength = (strength == -1) ? 10 : strength;
        this.random = random;
    }


    /**
     * Encode string.
     *
     * @param rawPassword the raw password
     * @return the string
     */
    public String encode(CharSequence rawPassword)
    {
        if (rawPassword == null)
        {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        String salt = getSalt();
        return BCrypt.hashpw(rawPassword.toString(), salt);
    }

    private String getSalt()
    {
        if (this.random != null)
        {
            return BCrypt.gensalt(this.version.getVersion(), this.strength, this.random);
        }
        return BCrypt.gensalt(this.version.getVersion(), this.strength);
    }


    /**
     * Matches boolean.
     *
     * @param rawPassword     the raw password
     * @param encodedPassword the encoded password
     * @return the boolean
     */
    public boolean matches(CharSequence rawPassword, String encodedPassword)
    {
        if (rawPassword == null)
        {
            throw new IllegalArgumentException("rawPassword cannot be null");
        }
        if (encodedPassword == null || encodedPassword.length() == 0)
        {
            this.logger.warn("Empty encoded password");
            return false;
        }
        if (!this.BCRYPT_PATTERN.matcher(encodedPassword).matches())
        {
            this.logger.warn("Encoded password does not look like BCrypt");
            return false;
        }
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }


    /**
     * Upgrade encoding boolean.
     *
     * @param encodedPassword the encoded password
     * @return the boolean
     */
    public boolean upgradeEncoding(String encodedPassword)
    {
        if (encodedPassword == null || encodedPassword.length() == 0)
        {
            this.logger.warn("Empty encoded password");
            return false;
        }
        Matcher matcher = this.BCRYPT_PATTERN.matcher(encodedPassword);
        if (!matcher.matches())
        {
            throw new IllegalArgumentException("Encoded password does not look like BCrypt: " + encodedPassword);
        }
        int strength = Integer.parseInt(matcher.group(2));
        return strength < this.strength;
    }

    /**
     * Stores the default bcrypt version for use in configuration.
     *
     * @author Lin Feng
     */
    public enum BCryptVersion
    {

        /**
         * 2 a b crypt version.
         */
        $2A("$2a"),

        /**
         * 2 y b crypt version.
         */
        $2Y("$2y"),

        /**
         * 2 b b crypt version.
         */
        $2B("$2b");

        private final String version;

        BCryptVersion(String version)
        {
            this.version = version;
        }

        /**
         * Gets version.
         *
         * @return the version
         */
        public String getVersion()
        {
            return this.version;
        }

    }

}
```







第三步：创建AuthService接口



```java
package mao.auth_server.service.auth;

import mao.auth_entity.dto.auth.LoginDTO;
import mao.auth_entity.entity.auth.User;
import mao.tools_core.base.R;
import mao.tools_jwt.entity.Token;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): AuthService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:36
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface AuthService
{
    /**
     * 登录
     *
     * @param account  账户
     * @param password 密码
     * @param key      验证码的key
     * @param value    用户输入的验证码
     * @return {@link R}<{@link LoginDTO}>
     */
    R<LoginDTO> login(String account, String password, String key, String value);

}
```





第四步：创建PasswordEncoderService接口



```java
package mao.auth_server.service.auth;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): PasswordEncoderService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface PasswordEncoderService
{
    /**
     * 将原始密码加密
     *
     * @param rawPassword 未进行加密的原始密码
     * @return {@link String} 加密后的密码
     */
    String encoder(String rawPassword);

    /**
     * 验证密码是否正确
     *
     * @param rawPassword    原始密码，未经加密的密码
     * @param encodePassword 加密后的密码
     * @return boolean
     */
    boolean verification(String rawPassword, String encodePassword);
}
```





第五步：创建ResourceService接口



```java
package mao.auth_server.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): ResourceService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 22:21
 * Version(版本): 1.0
 * Description(描述)： 资源Service
 */

public interface ResourceService extends IService<Resource>
{
    /**
     * 查询 拥有的资源
     *
     * @param resource 资源
     * @return {@link List}<{@link Resource}>
     */
    List<Resource> findVisibleResource(ResourceQueryDTO resource);

    /**
     * 根据菜单id删除资源
     *
     * @param menuIds 菜单id
     */
    void removeByMenuId(List<Long> menuIds);

    /**
     * 根据资源id 查询菜单id
     *
     * @param resourceIdList 资源id列表
     * @return {@link List}<{@link Long}>
     */
    List<Long> findMenuIdByResourceId(List<Long> resourceIdList);
}
```







第六步：创建UserRoleService接口



```java
package mao.auth_server.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.entity.auth.UserRole;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): UserRoleService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 21:06
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public interface UserRoleService extends IService<UserRole>
{

}
```







第七步：创建UserService接口



```java
package mao.auth_server.service.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.dto.auth.UserUpdatePasswordDTO;
import mao.auth_entity.entity.auth.User;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): UserService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 21:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public interface UserService extends IService<User>
{
    /**
     * 根据角色id 和 账号或名称 查询角色关联的用户
     * 注意，该接口只返回 id，账号，姓名，手机，性别
     *
     * @param roleId  角色id
     * @param keyword 账号或名称
     */
    List<User> findUserByRoleId(Long roleId, String keyword);

    /**
     * 修改输错密码的次数
     *
     * @param id id
     */
    void updatePasswordErrorNumById(Long id);

    /**
     * 根据账号查询用户
     *
     * @param account 账户
     * @return {@link User}
     */
    User getByAccount(String account);

    /**
     * 修改用户最后一次登录 时间
     *
     * @param account 账户
     */
    void updateLoginTime(String account);

    /**
     * 保存用户
     *
     * @param user 用户
     * @return {@link User}
     */
    User saveUser(User user);

    /**
     * 重置密码
     *
     * @param ids id
     * @return boolean
     */
    boolean reset(List<Long> ids);

    /**
     * 更新用户
     *
     * @param user 用户
     * @return {@link User}
     */
    User updateUser(User user);

    /**
     * 删除，删除的是用户角色表的数据
     *
     * @param ids id
     * @return boolean
     */
    boolean removeUser(List<Long> ids);

    /**
     * 分页
     *
     * @param page    页面
     * @param wrapper 包装器
     * @return {@link IPage}<{@link User}>
     */
    IPage<User> findPage(IPage<User> page, LbqWrapper<User> wrapper);

    /**
     * 更新密码
     *
     * @param data UserUpdatePasswordDTO
     * @return {@link Boolean}
     */
    Boolean updatePassword(UserUpdatePasswordDTO data);

    /**
     * 重置密码错误次数
     */
    int resetPassErrorNum(Long id);
}
```







第八步：创建ValidateCodeService接口



```java
package mao.auth_server.service.auth;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): ValidateCodeService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:53
 * Version(版本): 1.0
 * Description(描述)： 验证码Service接口
 */

public interface ValidateCodeService
{
    /**
     * 生成验证码
     *
     * @param key      这个key为缓存的key
     * @param response HttpServletResponse
     * @throws IOException IOException
     */
    void create(String key, HttpServletResponse response) throws IOException;


    /**
     * 校验验证码是否正确
     *
     * @param key   这个key为缓存的key
     * @param value 前端传过来的值
     * @return boolean
     */
    boolean check(String key, String value);
}
```







第九步：创建实现类BCryptPasswordEncoderService



```java
package mao.auth_server.service.auth.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_server.service.auth.PasswordEncoderService;
import mao.auth_server.utils.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): BCryptPasswordEncoderService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:50
 * Version(版本): 1.0
 * Description(描述)： 密码加密和验证服务
 */

@Slf4j
@Service
public class BCryptPasswordEncoderService implements PasswordEncoderService
{

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public BCryptPasswordEncoderService()
    {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
        log.info("密码加密和验证使用的是: BCrypt 算法");
    }

    @Override
    public String encoder(String rawPassword)
    {
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    @Override
    public boolean verification(String rawPassword, String encodePassword)
    {
        return bCryptPasswordEncoder.matches(rawPassword, encodePassword);
    }
}
```







第十步：创建实现类UserRoleServiceImpl



```java
package mao.auth_server.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.auth.UserRole;
import mao.auth_server.dao.auth.UserRoleMapper;
import mao.auth_server.service.auth.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): UserRoleServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 21:06
 * Version(版本): 1.0
 * Description(描述)： 用户角色实现类
 */

@Slf4j
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService
{

}
```







第十一步：创建实现类ValidateCodeServiceImpl



```java
package mao.auth_server.service.auth.impl;

import com.wf.captcha.ChineseGifCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.extern.slf4j.Slf4j;
import mao.auth_server.service.auth.ValidateCodeService;
import mao.tools_common.constant.CacheKey;
import mao.tools_core.exception.BizException;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): ValidateCodeServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:54
 * Version(版本): 1.0
 * Description(描述)： 验证码服务实现类
 */

@Slf4j
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService
{

    @Resource
    private CacheChannel cache;

    @Override
    public void create(String key, HttpServletResponse response) throws IOException
    {
        //判断key是否为空
        if (StringUtils.isBlank(key))
        {
            throw BizException.validFail("验证码key不能为空");
        }
        //可以不为空
        //生成验证码，中文gif验证码，6位
        Captcha captcha = new ChineseGifCaptcha(160, 80, 6);
        //设置响应类型为图片
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        //设置响应头
        response.setHeader(HttpHeaders.PRAGMA, "No-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "No-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0L);
        //获取验证码字符串
        String text = captcha.text();
        log.debug("key：" + key + "  的验证码：" + text);
        //放入缓存里
        cache.set(CacheKey.CAPTCHA, key, text);
        //输出
        captcha.out(response.getOutputStream());
    }

    @Override
    public boolean check(String key, String value)
    {
        //判断用户是否输入了验证码
        if (value.isEmpty())
        {
            //没有输入
            throw BizException.validFail("请输入验证码");
        }
        //判断key是否为空
        if (key.isEmpty())
        {
            throw BizException.validFail("验证码key为空");
        }
        //从缓存获取
        CacheObject cacheObject = cache.get(CacheKey.CAPTCHA, key);
        //判断是否为空
        if (cacheObject.getValue() == null)
        {
            //为空，未获取验证码或者验证码已过期
            throw BizException.validFail("未获取验证码或者验证码已过期");
        }
        //不为空
        //验证验证码输入是否正确
        String cacheObjectValue = (String) cacheObject.getValue();
        log.debug("缓存里的验证码：" + cacheObjectValue + ",用户输入的验证码：" + value);
        if (!value.equals(cacheObjectValue))
        {
            //验证码输入不正确
            throw BizException.validFail("验证码不正确");
        }
        //验证码正确，验证通过
        //清除缓存
        cache.evict(CacheKey.CAPTCHA, key);
        return true;
    }
}
```







第十二步：创建实现类ResourceServiceImpl



```java
package mao.auth_server.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;
import mao.auth_server.dao.auth.ResourceMapper;
import mao.auth_server.service.auth.ResourceService;
import mao.tools_core.base.id.CodeGenerate;
import mao.tools_core.exception.BizException;
import mao.tools_core.utils.StrHelper;
import mao.tools_databases.mybatis.conditions.Wraps;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): ResourceServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 22:22
 * Version(版本): 1.0
 * Description(描述)： 资源服务实现类
 */

@Slf4j
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService
{

    //@Autowired
    //private CacheChannel cacheChannel;

    @Autowired
    private CodeGenerate codeGenerate;


    @Override
    public List<Resource> findVisibleResource(ResourceQueryDTO resource)
    {
        return baseMapper.findVisibleResource(resource);
    }

    @Override
    public void removeByMenuId(List<Long> menuIds)
    {
        //查询这些资源，根据菜单id
        List<Resource> resourceList = this.list(Wraps.<Resource>lbQ().in(Resource::getMenuId, menuIds));
        //判断是否为空
        if (resourceList.isEmpty())
        {
            //为空，没必要移除，返回
            return;
        }
        //不为空
        //获得id列表
        List<Long> idList = resourceList.stream().mapToLong(Resource::getId).boxed().collect(Collectors.toList());
        //移除
        this.removeByIds(idList);
    }

    @Override
    public List<Long> findMenuIdByResourceId(List<Long> resourceIdList)
    {
        return baseMapper.findMenuIdByResourceId(resourceIdList);
    }

    /**
     * 保存
     * 覆盖框架里的save方法
     *
     * @param resource 资源
     * @return boolean
     */
    @Override
    public boolean save(Resource resource)
    {
        resource.setCode(StrHelper.getOrDef(resource.getCode(), codeGenerate.next()));
        if (super.count(Wraps.<Resource>lbQ().eq(Resource::getCode, resource.getCode())) > 0)
        {
            throw BizException.validFail("[%s]重复", resource.getCode());
        }
        super.save(resource);
        return true;
    }
}
```







第十三步：创建实现类UserServiceImpl



```java
package mao.auth_server.service.auth.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.UserUpdatePasswordDTO;
import mao.auth_entity.entity.auth.User;
import mao.auth_entity.entity.auth.UserRole;
import mao.auth_server.dao.auth.UserMapper;
import mao.auth_server.service.auth.PasswordEncoderService;
import mao.auth_server.service.auth.UserRoleService;
import mao.auth_server.service.auth.UserService;
import mao.tools_core.exception.BizException;
import mao.tools_core.utils.BizAssert;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): UserServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 21:05
 * Version(版本): 1.0
 * Description(描述)： 用户Service实现类
 */

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private PasswordEncoderService passwordEncoderService;

    @Override
    public List<User> findUserByRoleId(Long roleId, String keyword)
    {
        return baseMapper.findUserByRoleId(roleId, keyword);
    }

    @Override
    public void updatePasswordErrorNumById(Long id)
    {
        baseMapper.incrPasswordErrorNumById(id);
    }

    @Override
    public User getByAccount(String account)
    {
        return getOne(Wraps.<User>lbQ().eq(User::getAccount, account));
    }

    @Override
    public void updateLoginTime(String account)
    {
        baseMapper.updateLastLoginTime(account, LocalDateTime.now());
    }

    @Override
    public User saveUser(User user)
    {
        //设置密码过期时间
        user.setPasswordExpireTime(null);
        //加密密码
        user.setPassword(passwordEncoderService.encoder(user.getPassword()));
        //设置密码的错误计数为0
        user.setPasswordErrorNum(0);
        //保存
        boolean b = this.save(user);
        if (b)
        {
            return user;
        }
        throw BizException.wrap("用户添加失败！");
    }

    @Override
    public boolean reset(List<Long> ids)
    {
        String password = passwordEncoderService.encoder("123456");
        return super.update(Wraps.<User>lbU()
                .set(User::getPassword, password)
                .set(User::getPasswordErrorNum, 0L)
                .set(User::getPasswordErrorLastTime, null)
                .set(User::getPasswordExpireTime, null)
                .in(User::getId, ids)
        );
    }

    @Override
    public User updateUser(User user)
    {
        //填充密码
        if (StrUtil.isNotEmpty(user.getPassword()))
        {
            user.setPassword(passwordEncoderService.encoder(user.getPassword()));
        }
        //更新
        boolean b = this.updateById(user);
        if (b)
        {
            return user;
        }
        throw BizException.wrap("用户更新失败");
    }

    @Override
    public boolean removeUser(List<Long> ids)
    {
        return userRoleService.remove(Wraps.<UserRole>lbQ().in(UserRole::getUserId, ids));
    }

    @Override
    public IPage<User> findPage(IPage<User> page, LbqWrapper<User> wrapper)
    {
        return baseMapper.findPage(page, wrapper);
    }

    @Override
    public Boolean updatePassword(UserUpdatePasswordDTO data)
    {
        //校验两次输入的密码是否一致
        BizAssert.equals(data.getConfirmPassword(), data.getPassword(), "密码与确认密码不一致");
        //获取用户信息
        User user = this.getById(data.getId());
        //判断用户是否存在
        BizAssert.notNull(user, "用户不存在");
        //验证老密码是否正确
        boolean verification = passwordEncoderService.verification(data.getOldPassword(), user.getPassword());
        if (!verification)
        {
            //旧密码错误
            throw BizException.wrap("旧密码错误");
        }
        //旧密码正确
        //加密新密码
        String newPassword = passwordEncoderService.encoder(data.getPassword());
        //更新
        return this.update(Wraps.<User>lbU().eq(User::getId, data.getId()).set(User::getPassword, newPassword));
    }

    @Override
    public int resetPassErrorNum(Long id)
    {
        return baseMapper.resetPassErrorNum(id);
    }
}
```





第十四步：创建实现类AuthServiceImpl



```java
package mao.auth_server.service.auth.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.LoginDTO;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.dto.auth.UserDTO;
import mao.auth_entity.entity.auth.User;
import mao.auth_server.service.auth.*;
import mao.tools_common.constant.CacheKey;
import mao.tools_core.base.R;
import mao.tools_core.utils.BizAssert;
import mao.tools_jwt.entity.JwtUserInfo;
import mao.tools_jwt.entity.Token;
import mao.tools_jwt.server.utils.JwtTokenServerUtils;
import mao.toolsdozer.utils.DozerUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): AuthServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:37
 * Version(版本): 1.0
 * Description(描述)： 用户登录校验
 */

@Slf4j
@Service
public class AuthServiceImpl implements AuthService
{

    @Resource
    private JwtTokenServerUtils jwtTokenServerUtils;

    @Resource
    private UserService userService;

    @Resource
    private ResourceService resourceService;

    @Resource
    private DozerUtils dozer;

    @Resource
    private PasswordEncoderService passwordEncoderService;

    @Resource
    private CacheChannel cacheChannel;

    @Resource
    private ValidateCodeService validateCodeService;

    @Override
    public R<LoginDTO> login(String account, String password, String key, String value)
    {
        //校验验证码
        validateCodeService.check(key, value);
        //校验用户
        R<User> userR = this.check(account, password);
        //判断是否校验成功
        if (userR.getIsError())
        {
            //校验失败
            return R.fail(userR.getMsg());
        }
        //校验成功
        //生成token
        User user = userR.getData();
        Token token = this.generateUserToken(user);

        //查询用户可以访问的资源
        List<mao.auth_entity.entity.auth.Resource> visibleResource =
                resourceService.findVisibleResource(ResourceQueryDTO.builder().userId(user.getId()).build());
        log.debug("用户 " + user.getId() + "拥有的权限：" + visibleResource);
        //权限列表
        List<String> permissionList = null;
        if (visibleResource != null && visibleResource.size() > 0)
        {
            //用户有至少任何一个权限
            //前端使用
            permissionList = visibleResource.stream().
                    map(mao.auth_entity.entity.auth.Resource::getCode).collect(Collectors.toList());

            //给后端使用
            List<String> list = visibleResource.stream()
                    .map(resource -> resource.getMethod() + resource.getUrl())
                    .collect(Collectors.toList());

            //缓存，key为用户的id
            cacheChannel.set(CacheKey.USER_RESOURCE, user.getId().toString(), list);
        }

        //封装结果
        LoginDTO loginDTO = LoginDTO.builder()
                //用户数据
                .user(dozer.map(userR.getData(), UserDTO.class))
                //token
                .token(token)
                //权限列表
                .permissionsList(permissionList)
                .build();
        //返回
        return R.success(loginDTO);
    }


    /**
     * 校验用户
     *
     * @param account  账户
     * @param password 密码
     * @return {@link R}<{@link User}>
     */
    private R<User> check(String account, String password)
    {
        //查询用户信息
        User user = userService.getByAccount(account);
        //判断用户是否存在
        if (user == null)
        {
            return R.fail("用户不存在");
        }
        //用户存在
        //校验密码
        boolean verification = passwordEncoderService.verification(password, user.getPassword());
        if (!verification)
        {
            //密码不正确
            //将密码错误次数+1
            userService.updatePasswordErrorNumById(user.getId());
            //返回
            return R.fail("密码不正确");
        }
        else
        {
            //密码正确
            if (user.getPasswordErrorNum() != 0)
            {
                //重置密码错误次数
                userService.resetPassErrorNum(user.getId());
            }
            //返回
            R.success(user);
        }
        return R.success(user);
    }

    /**
     * 生成用户的token令牌
     *
     * @param user 用户
     * @return {@link Token}
     */
    private Token generateUserToken(User user)
    {
        JwtUserInfo jwtUserInfo = new JwtUserInfo(user.getId(),
                user.getAccount(), user.getName(), user.getOrgId(), user.getStationId());
        return jwtTokenServerUtils.generateUserToken(jwtUserInfo, null);
    }

}
```







第十五步：创建LoginController



```java
package mao.auth_server.controller.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.auth_entity.dto.auth.LoginDTO;
import mao.auth_entity.dto.auth.LoginParamDTO;
import mao.auth_server.service.auth.AuthService;
import mao.auth_server.service.auth.ValidateCodeService;
import mao.tools_core.base.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.auth
 * Class(类名): LoginController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:50
 * Version(版本): 1.0
 * Description(描述)： 登录Controller
 */


@RestController
@RequestMapping("/anno")
@Api(value = "LoginController", tags = "登录控制器")
public class LoginController
{
    @Resource
    private ValidateCodeService validateCodeService;

    @Resource
    private AuthService authService;


    @ApiOperation(value = "验证码", notes = "验证码")
    @GetMapping(value = "/captcha", produces = "image/png")
    public void captcha(@RequestParam(value = "key") String key,
                        HttpServletResponse response) throws IOException
    {
        this.validateCodeService.create(key, response);
    }


    /**
     * 登录认证
     *
     * @param loginParamDTO 登录参数dto
     * @return {@link R}<{@link LoginDTO}>
     */
    @PostMapping("login")
    @ApiOperation(notes = "登录", value = "登录")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "LoginParamDTO", value = "LoginParamDTO")
            }
    )
    public R<LoginDTO> login(@Validated @RequestBody LoginParamDTO loginParamDTO)
    {
        //登录认证
        return authService.login(loginParamDTO.getAccount(), loginParamDTO.getPassword(),
                loginParamDTO.getKey(), loginParamDTO.getCode());
    }

    /**
     * 校验验证码是否正确
     *
     * @param loginParamDTO 登录参数dto
     * @return boolean
     */
    @PostMapping("/check")
    @ApiOperation(notes = "校验验证码", value = "校验验证码")
    public boolean check(@RequestBody LoginParamDTO loginParamDTO)
    {
        //校验验证码是否正确
        return validateCodeService.check(loginParamDTO.getKey(), loginParamDTO.getCode());
    }
}
```





第十六步：启动服务



```sh
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.9.RELEASE)

2022-11-11 14:09:41.519  WARN 3924 --- [           main] c.a.c.n.c.NacosPropertySourceBuilder     : Ignore the empty nacos configuration and get it based on dataId[auth-server] & group[DEFAULT_GROUP]
2022-11-11 14:09:41.528  INFO 3924 --- [           main] b.c.PropertySourceBootstrapConfiguration : Located property source: [BootstrapPropertySource {name='bootstrapProperties-auth-server-dev.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-auth-server.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-auth-server,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-mysql.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-redis.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-common.yml,DEFAULT_GROUP'}]
2022-11-11 14:09:41.571  INFO 3924 --- [           main] mao.auth_server.AuthServerApplication    : The following profiles are active: dev
2022-11-11 14:09:42.188  INFO 3924 --- [           main] o.s.c.a.ConfigurationClassParser         : Properties location [${j2cache.config-location}] not resolvable: Could not resolve placeholder 'j2cache.config-location' in value "${j2cache.config-location}"
2022-11-11 14:09:43.060  INFO 3924 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
2022-11-11 14:09:43.063  INFO 3924 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.
2022-11-11 14:09:43.095  INFO 3924 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 16ms. Found 0 Redis repository interfaces.
2022-11-11 14:09:43.173  WARN 3924 --- [           main] o.s.boot.actuate.endpoint.EndpointId     : Endpoint ID 'service-registry' contains invalid characters, please migrate to a valid format.
2022-11-11 14:09:43.454  INFO 3924 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=5220e951-9b91-3e2b-b9e6-68a2207ddf93
2022-11-11 14:09:43.513  INFO 3924 --- [           main] m.t.config.ValidatorConfig               : 开启hibernate-validator快速返回
2022-11-11 14:09:43.513  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mao.tools_validator.config.ValidatorConfig' of type [mao.tools_validator.config.ValidatorConfig] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:43.688  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:43.845  INFO 3924 --- [           main] mao.tools_j2cache.config.CacheConfig     : 初始化 CacheConfig
2022-11-11 14:09:43.845  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mao.tools_j2cache.config.CacheConfig' of type [mao.tools_j2cache.config.CacheConfig] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:43.967  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mybatis-plus-com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties' of type [com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:43.981  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'database-mao.tools_databases.properties.DatabaseProperties' of type [mao.tools_databases.properties.DatabaseProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:43.989  INFO 3924 --- [           main] m.a.config.MybatisConfiguration          : 初始化 MybatisConfiguration
2022-11-11 14:09:43.989  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mybatisConfiguration' of type [mao.auth_server.config.MybatisConfiguration$$EnhancerBySpringCGLIB$$ac89fe04] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:43.996  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'paginationInterceptor' of type [com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.002  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'getLeftLikeTypeHandler' of type [mao.tools_databases.mybatis.typehandler.LeftLikeTypeHandler] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.006  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'getRightLikeTypeHandler' of type [mao.tools_databases.mybatis.typehandler.RightLikeTypeHandler] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.008  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'getFullLikeTypeHandler' of type [mao.tools_databases.mybatis.typehandler.FullLikeTypeHandler] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.017  INFO 3924 --- [           main] m.a.config.DatabaseConfiguration         : 初始化 DatabaseConfiguration
2022-11-11 14:09:44.017  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'databaseConfiguration' of type [mao.auth_server.config.DatabaseConfiguration$$EnhancerBySpringCGLIB$$c45c74b2] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.079  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'spring.datasource-org.springframework.boot.autoconfigure.jdbc.DataSourceProperties' of type [org.springframework.boot.autoconfigure.jdbc.DataSourceProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.084  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'com.alibaba.druid.spring.boot.autoconfigure.stat.DruidFilterConfiguration' of type [com.alibaba.druid.spring.boot.autoconfigure.stat.DruidFilterConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.096  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'wallConfig' of type [com.alibaba.druid.wall.WallConfig] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.128  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'wallFilter' of type [com.alibaba.druid.wall.WallFilter] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.217  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterDruidDataSource' of type [com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.253  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.boot.autoconfigure.jdbc.DataSourceInitializerInvoker' of type [org.springframework.boot.autoconfigure.jdbc.DataSourceInitializerInvoker] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.270  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterDataSource' of type [com.p6spy.engine.spy.P6DataSource] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.276  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterTransactionManager' of type [org.springframework.jdbc.datasource.DataSourceTransactionManager] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.284  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterTransactionInterceptor' of type [org.springframework.transaction.interceptor.TransactionInterceptor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.285  INFO 3924 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterAdvisor' of type [org.springframework.aop.support.DefaultPointcutAdvisor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 14:09:44.343  INFO 3924 --- [           main] mao.auth_server.config.WebConfiguration  : 初始化 WebConfiguration
2022-11-11 14:09:44.636  INFO 3924 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8764 (http)
2022-11-11 14:09:44.650  INFO 3924 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-11-11 14:09:44.650  INFO 3924 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.37]
2022-11-11 14:09:44.845  INFO 3924 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-11-11 14:09:44.845  INFO 3924 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3243 ms
2022-11-11 14:09:44.871  INFO 3924 --- [           main] m.tools_xss.config.XssAuthConfiguration  : 初始化 XssAuthConfiguration xss攻击配置
2022-11-11 14:09:45.008  WARN 3924 --- [           main] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
2022-11-11 14:09:45.008  INFO 3924 --- [           main] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
2022-11-11 14:09:45.022  INFO 3924 --- [           main] c.netflix.config.DynamicPropertyFactory  : DynamicPropertyFactory is initialized with configuration sources: com.netflix.config.ConcurrentCompositeConfiguration@9263c54
2022-11-11 14:09:45.143 DEBUG 3924 --- [           main] mao.tools_xss.filter.XssFilter           : XSS fiter [XSSFilter] init start ...
2022-11-11 14:09:45.211 DEBUG 3924 --- [           main] mao.tools_xss.filter.XssFilter           : ignorePathList=null
2022-11-11 14:09:45.214 DEBUG 3924 --- [           main] mao.tools_xss.filter.XssFilter           : ignoreParamValueList=["samlp:LogoutRequest"]
2022-11-11 14:09:45.214 DEBUG 3924 --- [           main] mao.tools_xss.filter.XssFilter           : XSS fiter [XSSFilter] init end
2022-11-11 14:09:45.239  INFO 3924 --- [           main] m.a.config.ExceptionConfiguration        : 初始化 ExceptionConfiguration
2022-11-11 14:09:45.243  INFO 3924 --- [           main] m.a.config.SysLogConfiguration           : 初始化 SysLogConfiguration
2022-11-11 14:09:45.253  INFO 3924 --- [           main] n.o.j.a.J2CacheAutoConfiguration         : 初始化 J2CacheAutoConfiguration
2022-11-11 14:09:45.319  INFO 3924 --- [           main] n.o.j2cache.util.SerializationUtils      : Using Serializer -> [fst:net.oschina.j2cache.util.FSTSerializer]
2022-11-11 14:09:45.322  INFO 3924 --- [           main] net.oschina.j2cache.CacheProviderHolder  : Using L1 CacheProvider : net.oschina.j2cache.caffeine.CaffeineProvider
2022-11-11 14:09:45.327  INFO 3924 --- [           main] .j.a.J2CacheSpringRedisAutoConfiguration : 初始化 J2CacheSpringRedisAutoConfiguration
2022-11-11 14:09:45.654  INFO 3924 --- [           main] net.oschina.j2cache.CacheProviderHolder  : Using L2 CacheProvider : net.oschina.j2cache.cache.support.redis.SpringRedisProvider
2022-11-11 14:09:45.667  INFO 3924 --- [           main] net.oschina.j2cache.J2CacheBuilder       : Using cluster policy : net.oschina.j2cache.cache.support.redis.SpringRedisPubSubPolicy
2022-11-11 14:09:45.675  INFO 3924 --- [           main] m.t.s.config.AuthServerConfiguration     : 初始化 AuthServerConfiguration
2022-11-11 14:09:46.273  INFO 3924 --- [           main] mao.tools_log.utils.AddressUtil          : bean [org.lionsoul.ip2region.DbConfig@23321be7]
2022-11-11 14:09:46.274  INFO 3924 --- [           main] mao.tools_log.utils.AddressUtil          : bean [org.lionsoul.ip2region.DbSearcher@61ad30f6]
2022-11-11 14:09:46.351 DEBUG 3924 --- [           main] mao.tools_xss.utils.XssUtils             :  start read XSS configfile [antisamy-slashdot-1.4.4.xml]
2022-11-11 14:09:46.357 DEBUG 3924 --- [           main] mao.tools_xss.utils.XssUtils             : read XSS configfile [antisamy-slashdot-1.4.4.xml] success
 _ _   |_  _ _|_. ___ _ |    _ 
| | |\/|_)(_| | |_\  |_)||_|_\ 
     /               |         
                        3.2.0 
2022-11-11 14:09:47.006  INFO 3924 --- [           main] m.a.s.a.i.BCryptPasswordEncoderService   : 密码加密和验证使用的是: BCrypt 算法
2022-11-11 14:09:47.069  INFO 3924 --- [           main] c.g.d.core.DozerBeanMapperBuilder        : Initializing Dozer. Version: 6.5.0, Thread Name: main
2022-11-11 14:09:47.070  INFO 3924 --- [           main] c.g.dozermapper.core.util.RuntimeUtils   : OSGi support is false
2022-11-11 14:09:47.075  INFO 3924 --- [           main] d.c.c.r.LegacyPropertiesSettingsResolver : Trying to find Dozer configuration file: dozer.properties
2022-11-11 14:09:47.079  INFO 3924 --- [           main] d.c.c.r.LegacyPropertiesSettingsResolver : Failed to find dozer.properties via com.github.dozermapper.core.config.resolvers.LegacyPropertiesSettingsResolver.
2022-11-11 14:09:47.085  INFO 3924 --- [           main] c.g.d.core.el.ELExpressionFactory        : javax.el support is true
2022-11-11 14:09:47.109  INFO 3924 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Using URL [file:/H:/%e7%a8%8b%e5%ba%8f/%e5%a4%a7%e5%9b%9b%e4%b8%8a%e6%9c%9f/authority/apps/auth/auth-server/target/classes/dozer/global.dozer.xml] to load custom xml mappings
2022-11-11 14:09:47.372  INFO 3924 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Trying to resolve XML entity with public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-11 14:09:47.375  INFO 3924 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Resolved public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-11 14:09:47.425  INFO 3924 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Successfully loaded custom xml mapping.
2022-11-11 14:09:47.426  INFO 3924 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Using URL [file:/H:/%e7%a8%8b%e5%ba%8f/%e5%a4%a7%e5%9b%9b%e4%b8%8a%e6%9c%9f/authority/apps/auth/auth-server/target/classes/dozer/biz.dozer.xml] to load custom xml mappings
2022-11-11 14:09:47.430  INFO 3924 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Trying to resolve XML entity with public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-11 14:09:47.430  INFO 3924 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Resolved public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-11 14:09:47.439  INFO 3924 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Successfully loaded custom xml mapping.
2022-11-11 14:09:47.619  INFO 3924 --- [           main] m.t.config.DozerAutoConfiguration        : 初始化 DozerAutoConfiguration
2022-11-11 14:09:47.622 DEBUG 3924 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 14:09:47.624 DEBUG 3924 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 14:09:47.624 DEBUG 3924 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 14:09:47.624 DEBUG 3924 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 14:09:47.624 DEBUG 3924 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 14:09:47.624 DEBUG 3924 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 14:09:47.856  INFO 3924 --- [           main] m.t.config.LoginArgResolverConfig        : 初始化 LoginArgResolverConfig
2022-11-11 14:09:48.015  INFO 3924 --- [           main] .j.a.J2CacheSpringCacheAutoConfiguration : 初始化 J2CacheSpringCacheAutoConfiguration
2022-11-11 14:09:49.320  INFO 3924 --- [           main] o.s.cloud.commons.util.InetUtils         : Cannot determine local hostname
2022-11-11 14:09:49.328  INFO 3924 --- [           main] com.alibaba.nacos.client.naming          : initializer namespace from System Property :null
2022-11-11 14:09:49.328  INFO 3924 --- [           main] com.alibaba.nacos.client.naming          : initializer namespace from System Environment :null
2022-11-11 14:09:49.329  INFO 3924 --- [           main] com.alibaba.nacos.client.naming          : initializer namespace from System Property :null
2022-11-11 14:09:49.408  INFO 3924 --- [           main] mao.tools_j2cache.config.RedissonConfig  : 初始化 RedissonConfig
2022-11-11 14:09:49.410  INFO 3924 --- [           main] mao.tools_j2cache.config.RedissonConfig  : 单机模式redis:127.0.0.1:6379
2022-11-11 14:09:49.550  INFO 3924 --- [           main] org.redisson.Version                     : Redisson 3.17.0
2022-11-11 14:09:50.296  INFO 3924 --- [sson-netty-4-13] o.r.c.pool.MasterPubSubConnectionPool    : 1 connections initialized for 127.0.0.1/127.0.0.1:6379
2022-11-11 14:09:50.314  INFO 3924 --- [sson-netty-4-19] o.r.c.pool.MasterConnectionPool          : 24 connections initialized for 127.0.0.1/127.0.0.1:6379
2022-11-11 14:09:50.577  INFO 3924 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 20 endpoint(s) beneath base path '/actuator'
2022-11-11 14:09:50.783  WARN 3924 --- [           main] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
2022-11-11 14:09:50.784  INFO 3924 --- [           main] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
2022-11-11 14:09:50.876  INFO 3924 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2022-11-11 14:09:51.067  INFO 3924 --- [           main] o.s.s.c.ThreadPoolTaskScheduler          : Initializing ExecutorService 'Nacos-Watch-Task-Scheduler'
2022-11-11 14:09:51.105  INFO 3924 --- [           main] m.tools_j2cache.config.RedisUtilsConfig  : 初始化 RedisUtilsConfig
2022-11-11 14:09:51.106  INFO 3924 --- [           main] m.tools_log.config.LogAutoConfiguration  : 初始化 LogAutoConfiguration
2022-11-11 14:09:51.125  INFO 3924 --- [           main] pertySourcedRequestMappingHandlerMapping : Mapped URL path [/v2/api-docs] onto method [springfox.documentation.swagger2.web.Swagger2Controller#getDocumentation(String, HttpServletRequest)]
2022-11-11 14:09:51.139  INFO 3924 --- [           main] m.t.config.SwaggerAutoConfiguration      : 初始化swagger接口文档
2022-11-11 14:09:51.139  INFO 3924 --- [           main] m.t.config.SwaggerAutoConfiguration      : 
title：在线文档
group：
description：在线文档
version：1.0
contact：Contact{name='mao', url='https://github.com/maomao124/', email='1234@qq.com'}
basePackage：
basePath：[]
excludePath：[]
docket：{auth=DocketInfo{title='权限模块', group='', description='在线文档', version='1.0', contact=Contact{name='', url='', email=''}, basePackage='mao.auth_server.controller.auth', basePath=[], excludePath=[]}, common=DocketInfo{title='公共模块', group='', description='在线文档', version='1.0', contact=Contact{name='', url='', email=''}, basePackage='mao.auth_server.controller.common', basePath=[], excludePath=[]}, core=DocketInfo{title='组织岗位模块', group='', description='在线文档', version='1.0', contact=Contact{name='', url='', email=''}, basePackage='mao.auth_server.controller.core', basePath=[], excludePath=[]}}

2022-11-11 14:09:52.681  INFO 3924 --- [           main] o.s.cloud.commons.util.InetUtils         : Cannot determine local hostname
2022-11-11 14:09:52.985  INFO 3924 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2022-11-11 14:09:53.015  INFO 3924 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 3 custom documentation plugin(s)
2022-11-11 14:09:53.079  INFO 3924 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2022-11-11 14:09:53.112  INFO 3924 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2022-11-11 14:09:53.279  INFO 3924 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2022-11-11 14:09:53.386  INFO 3924 --- [enerContainer-1] io.lettuce.core.EpollProvider            : Starting without optional epoll library
2022-11-11 14:09:53.388  INFO 3924 --- [enerContainer-1] io.lettuce.core.KqueueProvider           : Starting without optional kqueue library
2022-11-11 14:09:53.569  INFO 3924 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8764 (http) with context path ''
2022-11-11 14:09:53.575  INFO 3924 --- [           main] com.alibaba.nacos.client.naming          : [BEAT] adding beat: BeatInfo{port=8764, ip='192.168.202.1', weight=1.0, serviceName='DEFAULT_GROUP@@auth-server', cluster='DEFAULT', metadata={preserved.register.source=SPRING_CLOUD, management.endpoints.web.base-path=/actuator, management.context-path=/actuator}, scheduled=false, period=5000, stopped=false} to beat map.
2022-11-11 14:09:53.576  INFO 3924 --- [           main] com.alibaba.nacos.client.naming          : [REGISTER-SERVICE] 27ce69b0-bff1-4c03-8f3e-0ea5559a5732 registering service DEFAULT_GROUP@@auth-server with instance: Instance{instanceId='null', ip='192.168.202.1', port=8764, weight=1.0, healthy=true, enabled=true, ephemeral=true, clusterName='DEFAULT', serviceName='null', metadata={preserved.register.source=SPRING_CLOUD, management.endpoints.web.base-path=/actuator, management.context-path=/actuator}}
2022-11-11 14:09:53.585  INFO 3924 --- [           main] c.a.c.n.registry.NacosServiceRegistry    : nacos registry, DEFAULT_GROUP auth-server 192.168.202.1:8764 register finished
2022-11-11 14:09:54.006  INFO 3924 --- [.naming.updater] com.alibaba.nacos.client.naming          : new ips(1) service: DEFAULT_GROUP@@auth-server@@DEFAULT -> [{"instanceId":"192.168.202.1#8764#DEFAULT#DEFAULT_GROUP@@auth-server","ip":"192.168.202.1","port":8764,"weight":1.0,"healthy":true,"enabled":true,"ephemeral":true,"clusterName":"DEFAULT","serviceName":"DEFAULT_GROUP@@auth-server","metadata":{"preserved.register.source":"SPRING_CLOUD","management.endpoints.web.base-path":"/actuator","management.context-path":"/actuator"},"ipDeleteTimeout":30000,"instanceHeartBeatInterval":5000,"instanceHeartBeatTimeOut":15000}]
2022-11-11 14:09:54.014  INFO 3924 --- [.naming.updater] com.alibaba.nacos.client.naming          : current ips:(1) service: DEFAULT_GROUP@@auth-server@@DEFAULT -> [{"instanceId":"192.168.202.1#8764#DEFAULT#DEFAULT_GROUP@@auth-server","ip":"192.168.202.1","port":8764,"weight":1.0,"healthy":true,"enabled":true,"ephemeral":true,"clusterName":"DEFAULT","serviceName":"DEFAULT_GROUP@@auth-server","metadata":{"preserved.register.source":"SPRING_CLOUD","management.endpoints.web.base-path":"/actuator","management.context-path":"/actuator"},"ipDeleteTimeout":30000,"instanceHeartBeatInterval":5000,"instanceHeartBeatTimeOut":15000}]
2022-11-11 14:09:54.599  INFO 3924 --- [g.push.receiver] com.alibaba.nacos.client.naming          : received push data: {"type":"dom","data":"{\"hosts\":[{\"ip\":\"192.168.202.1\",\"port\":8764,\"valid\":true,\"healthy\":true,\"marked\":false,\"instanceId\":\"192.168.202.1#8764#DEFAULT#DEFAULT_GROUP@@auth-server\",\"metadata\":{\"preserved.register.source\":\"SPRING_CLOUD\",\"management.endpoints.web.base-path\":\"/actuator\",\"management.context-path\":\"/actuator\"},\"enabled\":true,\"weight\":1.0,\"clusterName\":\"DEFAULT\",\"serviceName\":\"DEFAULT_GROUP@@auth-server\",\"ephemeral\":true}],\"dom\":\"DEFAULT_GROUP@@auth-server\",\"name\":\"DEFAULT_GROUP@@auth-server\",\"cacheMillis\":10000,\"lastRefTime\":1668146994598,\"checksum\":\"d706e8bc2779a32044465e588c1a9d58\",\"useSpecifiedURL\":false,\"clusters\":\"DEFAULT\",\"env\":\"\",\"metadata\":{}}","lastRefTime":68003426682499} from /172.28.64.1
2022-11-11 14:09:54.832  INFO 3924 --- [           main] o.s.cloud.commons.util.InetUtils         : Cannot determine local hostname
2022-11-11 14:09:54.834  INFO 3924 --- [           main] mao.auth_server.AuthServerApplication    : Started AuthServerApplication in 17.098 seconds (JVM running for 18.156)
2022-11-11 14:09:54.846  INFO 3924 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] auth-server-dev.yml+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-11 14:09:54.848  INFO 3924 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=auth-server-dev.yml, group=DEFAULT_GROUP, cnt=1
2022-11-11 14:09:54.849  INFO 3924 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] auth-server+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-11 14:09:54.849  INFO 3924 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=auth-server, group=DEFAULT_GROUP, cnt=1
2022-11-11 14:09:54.859  INFO 3924 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] auth-server.yml+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-11 14:09:54.859  INFO 3924 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=auth-server.yml, group=DEFAULT_GROUP, cnt=1
2022-11-11 14:09:54.864  INFO 3924 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] common.yml+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-11 14:09:54.864  INFO 3924 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=common.yml, group=DEFAULT_GROUP, cnt=1
2022-11-11 14:09:54.865  INFO 3924 --- [           main] mao.auth_server.AuthServerApplication    : 应用auth-server启动成功!swagger地址：http://172.28.64.1:8764/doc.html
2022-11-11 14:09:54.865  INFO 3924 --- [           main] mao.auth_server.AuthServerApplication    : 启动耗时：17263ms
2022-11-11 14:09:55.397  INFO 3924 --- [(2)-172.28.64.1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-11-11 14:09:55.398  INFO 3924 --- [(2)-172.28.64.1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-11-11 14:09:55.414  INFO 3924 --- [(2)-172.28.64.1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 16 ms
2022-11-11 14:09:55.938  INFO 3924 --- [(1)-172.28.64.1] com.alibaba.druid.pool.DruidDataSource   : {dataSource-1} inited
 Consume Time：2 ms 2022-11-11 14:09:56
 Execute SQL：/* ping */ SELECT 1
```







第十七步：访问



http://127.0.0.1:8764/doc.html



![image-20221111141245645](img/通用权限系统实战学习笔记/image-20221111141245645.png)





第十八步：获取验证码



![image-20221111141312508](img/通用权限系统实战学习笔记/image-20221111141312508.png)





![image-20221111141333793](img/通用权限系统实战学习笔记/image-20221111141333793.png)





第十九步：登录



![image-20221111141620202](img/通用权限系统实战学习笔记/image-20221111141620202.png)







![image-20221111141746094](img/通用权限系统实战学习笔记/image-20221111141746094.png)







![image-20221111141802152](img/通用权限系统实战学习笔记/image-20221111141802152.png)





```json
{
  "code": 0,
  "data": {
    "user": {
      "id": "3",
      "account": "123",
      "name": "平台管理员",
      "orgId": "100",
      "stationId": "100",
      "email": "",
      "mobile": "",
      "sex": {
        "desc": "男",
        "code": "M"
      },
      "status": true,
      "avatar": "BiazfanxmamNRoxxVxka.png",
      "workDescribe": "超级管理员",
      "lastLoginTime": "2022-11-10 21:56:55"
    },
    "token": {
      "token": "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzIiwiYWNjb3VudCI6IjEyMyIsIm5hbWUiOiLlubPlj7DnrqHnkIblkZgiLCJvcmdpZCI6MTAwLCJzdGF0aW9uaWQiOjEwMCwiZXhwIjoxNjY4MTkwNjcwfQ.IJH1FFuB_6OM0Nxa0dNmKxEh6FVCoyWTB_l6dSXB3GtetAtRSY8HoQbf38z7L2n1T9lwak1tbNFxeUsefrWjn4-WBT6W7n5J_cLHw_RlO6H4gkRV3ojlaeVzY4z0VRsBtbsHbl8YmQC8JRaDbWjzdlnYi4XXf1M888x6SPXiyNQ",
      "expire": 43200
    },
    "permissionsList": [
      "org:add",
      "role:config",
      "resource:add",
      "resource:update",
      "resource:delete",
      "org:update",
      "org:delete",
      "org:view",
      "org:import",
      "org:export",
      "station:add",
      "station:update",
      "station:delete",
      "station:view",
      "station:export",
      "station:import",
      "user:add",
      "user:update",
      "user:delete",
      "user:view",
      "user:import",
      "user:export",
      "menu:add",
      "menu:update",
      "menu:delete",
      "menu:view",
      "menu:export",
      "menu:import",
      "role:add",
      "role:update",
      "role:delete",
      "role:view",
      "role:export",
      "role:import",
      "role:auth",
      "optLog:view",
      "optLog:export",
      "optLog:delete",
      "loginLog:delete",
      "loginLog:export",
      "file:add",
      "file:update",
      "file:delete",
      "file:view",
      "receive:view",
      "send:view",
      "rule:config-view",
      "resource:view"
    ]
  },
  "msg": "ok",
  "path": null,
  "extra": null,
  "timestamp": "1668147470906",
  "isSuccess": true,
  "isError": false
}
```







不获取验证码的情况



![image-20221111143025758](img/通用权限系统实战学习笔记/image-20221111143025758.png)



```json
{
  "code": -9,
  "data": "",
  "msg": "未获取验证码或者验证码已过期",
  "path": "/anno/login",
  "extra": null,
  "timestamp": "1668148030768",
  "isError": true,
  "isSuccess": false
}
```





验证码错误的情况



![image-20221111143129416](img/通用权限系统实战学习笔记/image-20221111143129416.png)





```json
{
  "code": -9,
  "data": "",
  "msg": "验证码不正确",
  "path": "/anno/login",
  "extra": null,
  "timestamp": "1668148280771",
  "isError": true,
  "isSuccess": false
}
```





用户不存在的情况



![image-20221111143307452](img/通用权限系统实战学习笔记/image-20221111143307452.png)





```json
{
  "code": -10,
  "data": null,
  "msg": "用户不存在",
  "path": null,
  "extra": null,
  "timestamp": "1668148381026",
  "isError": true,
  "isSuccess": false
}
```





密码错误的情况



![image-20221111143409427](img/通用权限系统实战学习笔记/image-20221111143409427.png)





```json
{
  "code": -10,
  "data": null,
  "msg": "密码不正确",
  "path": null,
  "extra": null,
  "timestamp": "1668148443444",
  "isError": true,
  "isSuccess": false
}
```



















## 开发操作日志功能

当前的权限服务已经依赖了tools-log日志模块，此模块中已经定义好了SysLogAspect切面类用于拦截Controller中添加@SysLog注解的方法，在切面类中通过前置通知和后置通知方法收集操作日志相关信息并发布SysLogEvent日志事件，通过定义SysLogListener监听器来监听日志事件。

在权限服务中只需要定义配置类来创建SysLogListener，同时将SysLogListener所需的Consumer参数传递进行即可。



dao层的增删改查略



第一步：创建OptLogService接口



```java
package mao.auth_server.service.common;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.entity.common.OptLog;
import mao.tools_log.entity.OptLogDTO;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.common
 * Interface(接口名): OptLogService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 19:33
 * Version(版本): 1.0
 * Description(描述)： 操作日志服务
 */

public interface OptLogService extends IService<OptLog>
{
    /**
     * 保存日志
     *
     * @param optLogDTO 选择日志dto
     * @return boolean
     */
    boolean save(OptLogDTO optLogDTO);
}
```





第二步：创建OptLogServiceImpl实现类



```java
package mao.auth_server.service.common.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mao.auth_entity.entity.common.OptLog;
import mao.auth_server.dao.common.OptLogMapper;
import mao.auth_server.service.common.OptLogService;
import mao.tools_log.entity.OptLogDTO;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.common.impl
 * Class(类名): OptLogServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 19:34
 * Version(版本): 1.0
 * Description(描述)： 操作日志服务实现类
 */

@Service
public class OptLogServiceImpl extends ServiceImpl<OptLogMapper, OptLog> implements OptLogService
{
    @Resource
    private DozerUtils dozerUtils;

    @Override
    public boolean save(OptLogDTO optLogDTO)
    {
        return this.save(dozerUtils.map(optLogDTO, OptLog.class));
    }
}
```





第三步：创建SysLogConfiguration配置类

```java
package mao.auth_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.auth_server.service.common.OptLogService;
import mao.tools_log.entity.OptLogDTO;
import mao.tools_log.event.SysLogListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.function.Consumer;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.config
 * Class(类名): SysLogConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 12:47
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
@EnableAsync
public class SysLogConfiguration
{
    @Resource
    private OptLogService optLogService;

    @Bean
    public SysLogListener sysLogListener()
    {
        return new SysLogListener(new Consumer<OptLogDTO>()
        {
            @Override
            public void accept(OptLogDTO optLogDTO)
            {
                boolean save = optLogService.save(optLogDTO);
                if (!save)
                {
                    log.warn("日志保存失败：" + optLogDTO);
                }
            }
        });
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 SysLogConfiguration");
    }
}
```





第五步：添加@SysLog注解



```java
package mao.auth_server.controller.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.auth_entity.dto.auth.LoginDTO;
import mao.auth_entity.dto.auth.LoginParamDTO;
import mao.auth_server.service.auth.AuthService;
import mao.auth_server.service.auth.ValidateCodeService;
import mao.tools_core.base.R;
import mao.tools_log.annotation.SysLog;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.auth
 * Class(类名): LoginController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:50
 * Version(版本): 1.0
 * Description(描述)： 登录Controller
 */


@RestController
@RequestMapping("/anno")
@Api(value = "LoginController", tags = "登录控制器")
public class LoginController
{
    @Resource
    private ValidateCodeService validateCodeService;

    @Resource
    private AuthService authService;


    @ApiOperation(value = "验证码", notes = "验证码")
    @GetMapping(value = "/captcha", produces = "image/png")
    public void captcha(@RequestParam(value = "key") String key,
                        HttpServletResponse response) throws IOException
    {
        this.validateCodeService.create(key, response);
    }


    /**
     * 登录认证
     *
     * @param loginParamDTO 登录参数dto
     * @return {@link R}<{@link LoginDTO}>
     */
    @SysLog("登录")
    @PostMapping("/login")
    @ApiOperation(notes = "登录", value = "登录")
    public R<LoginDTO> login(@Validated @RequestBody LoginParamDTO loginParamDTO)
    {
        //登录认证
        return authService.login(loginParamDTO.getAccount(), loginParamDTO.getPassword(),
                loginParamDTO.getKey(), loginParamDTO.getCode());
    }

    /**
     * 校验验证码是否正确
     *
     * @param loginParamDTO 登录参数dto
     * @return boolean
     */
    @PostMapping("/check")
    @ApiOperation(notes = "校验验证码", value = "校验验证码")
    public boolean check(@RequestBody LoginParamDTO loginParamDTO)
    {
        //校验验证码是否正确
        return validateCodeService.check(loginParamDTO.getKey(), loginParamDTO.getCode());
    }
}
```





第六步：启动程序



```sh

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.9.RELEASE)

2022-11-11 19:52:17.990  WARN 11912 --- [           main] c.a.c.n.c.NacosPropertySourceBuilder     : Ignore the empty nacos configuration and get it based on dataId[auth-server] & group[DEFAULT_GROUP]
2022-11-11 19:52:18.008  INFO 11912 --- [           main] b.c.PropertySourceBootstrapConfiguration : Located property source: [BootstrapPropertySource {name='bootstrapProperties-auth-server-dev.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-auth-server.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-auth-server,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-mysql.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-redis.yml,DEFAULT_GROUP'}, BootstrapPropertySource {name='bootstrapProperties-common.yml,DEFAULT_GROUP'}]
2022-11-11 19:52:18.050  INFO 11912 --- [           main] mao.auth_server.AuthServerApplication    : The following profiles are active: dev
2022-11-11 19:52:18.676  INFO 11912 --- [           main] o.s.c.a.ConfigurationClassParser         : Properties location [${j2cache.config-location}] not resolvable: Could not resolve placeholder 'j2cache.config-location' in value "${j2cache.config-location}"
2022-11-11 19:52:19.551  INFO 11912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Multiple Spring Data modules found, entering strict repository configuration mode!
2022-11-11 19:52:19.554  INFO 11912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Redis repositories in DEFAULT mode.
2022-11-11 19:52:19.583  INFO 11912 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 15ms. Found 0 Redis repository interfaces.
2022-11-11 19:52:19.653  WARN 11912 --- [           main] o.s.boot.actuate.endpoint.EndpointId     : Endpoint ID 'service-registry' contains invalid characters, please migrate to a valid format.
2022-11-11 19:52:19.950  INFO 11912 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=d28408ff-ca55-34b5-ba3a-1e994f6a37f5
2022-11-11 19:52:20.016  INFO 11912 --- [           main] m.t.config.ValidatorConfig               : 开启hibernate-validator快速返回
2022-11-11 19:52:20.016  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mao.tools_validator.config.ValidatorConfig' of type [mao.tools_validator.config.ValidatorConfig] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.218  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.384  INFO 11912 --- [           main] mao.tools_j2cache.config.CacheConfig     : 初始化 CacheConfig
2022-11-11 19:52:20.385  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mao.tools_j2cache.config.CacheConfig' of type [mao.tools_j2cache.config.CacheConfig] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.501  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mybatis-plus-com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties' of type [com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.510  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'database-mao.tools_databases.properties.DatabaseProperties' of type [mao.tools_databases.properties.DatabaseProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.517  INFO 11912 --- [           main] m.a.config.MybatisConfiguration          : 初始化 MybatisConfiguration
2022-11-11 19:52:20.517  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'mybatisConfiguration' of type [mao.auth_server.config.MybatisConfiguration$$EnhancerBySpringCGLIB$$3bf5057b] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.523  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'paginationInterceptor' of type [com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.530  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'getLeftLikeTypeHandler' of type [mao.tools_databases.mybatis.typehandler.LeftLikeTypeHandler] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.534  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'getRightLikeTypeHandler' of type [mao.tools_databases.mybatis.typehandler.RightLikeTypeHandler] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.537  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'getFullLikeTypeHandler' of type [mao.tools_databases.mybatis.typehandler.FullLikeTypeHandler] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.545  INFO 11912 --- [           main] m.a.config.DatabaseConfiguration         : 初始化 DatabaseConfiguration
2022-11-11 19:52:20.545  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'databaseConfiguration' of type [mao.auth_server.config.DatabaseConfiguration$$EnhancerBySpringCGLIB$$53c77c29] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.607  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'spring.datasource-org.springframework.boot.autoconfigure.jdbc.DataSourceProperties' of type [org.springframework.boot.autoconfigure.jdbc.DataSourceProperties] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.612  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'com.alibaba.druid.spring.boot.autoconfigure.stat.DruidFilterConfiguration' of type [com.alibaba.druid.spring.boot.autoconfigure.stat.DruidFilterConfiguration] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.624  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'wallConfig' of type [com.alibaba.druid.wall.WallConfig] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.658  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'wallFilter' of type [com.alibaba.druid.wall.WallFilter] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.751  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterDruidDataSource' of type [com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.788  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.boot.autoconfigure.jdbc.DataSourceInitializerInvoker' of type [org.springframework.boot.autoconfigure.jdbc.DataSourceInitializerInvoker] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.804  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterDataSource' of type [com.p6spy.engine.spy.P6DataSource] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.810  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterTransactionManager' of type [org.springframework.jdbc.datasource.DataSourceTransactionManager] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.818  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterTransactionInterceptor' of type [org.springframework.transaction.interceptor.TransactionInterceptor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.820  INFO 11912 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'masterAdvisor' of type [org.springframework.aop.support.DefaultPointcutAdvisor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2022-11-11 19:52:20.884  INFO 11912 --- [           main] mao.auth_server.config.WebConfiguration  : 初始化 WebConfiguration
2022-11-11 19:52:21.192  INFO 11912 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8764 (http)
2022-11-11 19:52:21.212  INFO 11912 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-11-11 19:52:21.212  INFO 11912 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.37]
2022-11-11 19:52:21.414  INFO 11912 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-11-11 19:52:21.414  INFO 11912 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 3338 ms
2022-11-11 19:52:21.440  INFO 11912 --- [           main] m.tools_xss.config.XssAuthConfiguration  : 初始化 XssAuthConfiguration xss攻击配置
2022-11-11 19:52:21.575  WARN 11912 --- [           main] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
2022-11-11 19:52:21.575  INFO 11912 --- [           main] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
2022-11-11 19:52:21.591  INFO 11912 --- [           main] c.netflix.config.DynamicPropertyFactory  : DynamicPropertyFactory is initialized with configuration sources: com.netflix.config.ConcurrentCompositeConfiguration@21d9cd04
2022-11-11 19:52:21.727 DEBUG 11912 --- [           main] mao.tools_xss.filter.XssFilter           : XSS fiter [XSSFilter] init start ...
2022-11-11 19:52:21.783 DEBUG 11912 --- [           main] mao.tools_xss.filter.XssFilter           : ignorePathList=null
2022-11-11 19:52:21.786 DEBUG 11912 --- [           main] mao.tools_xss.filter.XssFilter           : ignoreParamValueList=["samlp:LogoutRequest"]
2022-11-11 19:52:21.786 DEBUG 11912 --- [           main] mao.tools_xss.filter.XssFilter           : XSS fiter [XSSFilter] init end
2022-11-11 19:52:21.811  INFO 11912 --- [           main] m.a.config.ExceptionConfiguration        : 初始化 ExceptionConfiguration
2022-11-11 19:52:21.841  INFO 11912 --- [           main] c.g.d.core.DozerBeanMapperBuilder        : Initializing Dozer. Version: 6.5.0, Thread Name: main
2022-11-11 19:52:21.842  INFO 11912 --- [           main] c.g.dozermapper.core.util.RuntimeUtils   : OSGi support is false
2022-11-11 19:52:21.849  INFO 11912 --- [           main] d.c.c.r.LegacyPropertiesSettingsResolver : Trying to find Dozer configuration file: dozer.properties
2022-11-11 19:52:21.853  INFO 11912 --- [           main] d.c.c.r.LegacyPropertiesSettingsResolver : Failed to find dozer.properties via com.github.dozermapper.core.config.resolvers.LegacyPropertiesSettingsResolver.
2022-11-11 19:52:21.859  INFO 11912 --- [           main] c.g.d.core.el.ELExpressionFactory        : javax.el support is true
2022-11-11 19:52:21.884  INFO 11912 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Using URL [file:/H:/%e7%a8%8b%e5%ba%8f/%e5%a4%a7%e5%9b%9b%e4%b8%8a%e6%9c%9f/authority/apps/auth/auth-server/target/classes/dozer/global.dozer.xml] to load custom xml mappings
2022-11-11 19:52:22.156  INFO 11912 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Trying to resolve XML entity with public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-11 19:52:22.157  INFO 11912 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Resolved public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-11 19:52:22.207  INFO 11912 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Successfully loaded custom xml mapping.
2022-11-11 19:52:22.208  INFO 11912 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Using URL [file:/H:/%e7%a8%8b%e5%ba%8f/%e5%a4%a7%e5%9b%9b%e4%b8%8a%e6%9c%9f/authority/apps/auth/auth-server/target/classes/dozer/biz.dozer.xml] to load custom xml mappings
2022-11-11 19:52:22.212  INFO 11912 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Trying to resolve XML entity with public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-11 19:52:22.212  INFO 11912 --- [           main] c.g.d.c.b.xml.SchemaLSResourceResolver   : Resolved public ID [null] and system ID [http://dozermapper.github.io/schema/bean-mapping.xsd]
2022-11-11 19:52:22.225  INFO 11912 --- [           main] c.g.d.c.b.xml.BeanMappingXMLBuilder      : Successfully loaded custom xml mapping.
2022-11-11 19:52:22.303  INFO 11912 --- [           main] m.t.config.DozerAutoConfiguration        : 初始化 DozerAutoConfiguration
2022-11-11 19:52:22.906  INFO 11912 --- [           main] mao.tools_log.utils.AddressUtil          : bean [org.lionsoul.ip2region.DbConfig@7856f41a]
2022-11-11 19:52:22.907  INFO 11912 --- [           main] mao.tools_log.utils.AddressUtil          : bean [org.lionsoul.ip2region.DbSearcher@5fbae40]
2022-11-11 19:52:22.993 DEBUG 11912 --- [           main] mao.tools_xss.utils.XssUtils             :  start read XSS configfile [antisamy-slashdot-1.4.4.xml]
2022-11-11 19:52:23.000 DEBUG 11912 --- [           main] mao.tools_xss.utils.XssUtils             : read XSS configfile [antisamy-slashdot-1.4.4.xml] success
 _ _   |_  _ _|_. ___ _ |    _ 
| | |\/|_)(_| | |_\  |_)||_|_\ 
     /               |         
                        3.2.0 
2022-11-11 19:52:23.624  INFO 11912 --- [           main] m.a.config.SysLogConfiguration           : 初始化 SysLogConfiguration
2022-11-11 19:52:23.631  INFO 11912 --- [           main] n.o.j.a.J2CacheAutoConfiguration         : 初始化 J2CacheAutoConfiguration
2022-11-11 19:52:23.696  INFO 11912 --- [           main] n.o.j2cache.util.SerializationUtils      : Using Serializer -> [fst:net.oschina.j2cache.util.FSTSerializer]
2022-11-11 19:52:23.699  INFO 11912 --- [           main] net.oschina.j2cache.CacheProviderHolder  : Using L1 CacheProvider : net.oschina.j2cache.caffeine.CaffeineProvider
2022-11-11 19:52:23.703  INFO 11912 --- [           main] .j.a.J2CacheSpringRedisAutoConfiguration : 初始化 J2CacheSpringRedisAutoConfiguration
2022-11-11 19:52:24.182  INFO 11912 --- [           main] net.oschina.j2cache.CacheProviderHolder  : Using L2 CacheProvider : net.oschina.j2cache.cache.support.redis.SpringRedisProvider
2022-11-11 19:52:24.196  INFO 11912 --- [           main] net.oschina.j2cache.J2CacheBuilder       : Using cluster policy : net.oschina.j2cache.cache.support.redis.SpringRedisPubSubPolicy
2022-11-11 19:52:24.202  INFO 11912 --- [           main] m.t.s.config.AuthServerConfiguration     : 初始化 AuthServerConfiguration
2022-11-11 19:52:24.226  INFO 11912 --- [           main] m.a.s.a.i.BCryptPasswordEncoderService   : 密码加密和验证使用的是: BCrypt 算法
2022-11-11 19:52:24.268 DEBUG 11912 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 19:52:24.274 DEBUG 11912 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 19:52:24.275 DEBUG 11912 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 19:52:24.278 DEBUG 11912 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 19:52:24.278 DEBUG 11912 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 19:52:24.279 DEBUG 11912 --- [           main] m.t.d.BaseDatabaseConfiguration          : 允许带事务的类为：class mao.auth_server.controller.auth.LoginController
2022-11-11 19:52:24.510  INFO 11912 --- [           main] m.t.config.LoginArgResolverConfig        : 初始化 LoginArgResolverConfig
2022-11-11 19:52:24.664  INFO 11912 --- [           main] .j.a.J2CacheSpringCacheAutoConfiguration : 初始化 J2CacheSpringCacheAutoConfiguration
2022-11-11 19:52:25.979  INFO 11912 --- [           main] o.s.cloud.commons.util.InetUtils         : Cannot determine local hostname
2022-11-11 19:52:25.986  INFO 11912 --- [           main] com.alibaba.nacos.client.naming          : initializer namespace from System Property :null
2022-11-11 19:52:25.987  INFO 11912 --- [           main] com.alibaba.nacos.client.naming          : initializer namespace from System Environment :null
2022-11-11 19:52:25.987  INFO 11912 --- [           main] com.alibaba.nacos.client.naming          : initializer namespace from System Property :null
2022-11-11 19:52:26.062  INFO 11912 --- [           main] mao.tools_j2cache.config.RedissonConfig  : 初始化 RedissonConfig
2022-11-11 19:52:26.065  INFO 11912 --- [           main] mao.tools_j2cache.config.RedissonConfig  : 单机模式redis:127.0.0.1:6379
2022-11-11 19:52:26.218  INFO 11912 --- [           main] org.redisson.Version                     : Redisson 3.17.0
2022-11-11 19:52:26.983  INFO 11912 --- [sson-netty-4-13] o.r.c.pool.MasterPubSubConnectionPool    : 1 connections initialized for 127.0.0.1/127.0.0.1:6379
2022-11-11 19:52:27.002  INFO 11912 --- [sson-netty-4-19] o.r.c.pool.MasterConnectionPool          : 24 connections initialized for 127.0.0.1/127.0.0.1:6379
2022-11-11 19:52:27.267  INFO 11912 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 20 endpoint(s) beneath base path '/actuator'
2022-11-11 19:52:27.472  WARN 11912 --- [           main] c.n.c.sources.URLConfigurationSource     : No URLs will be polled as dynamic configuration sources.
2022-11-11 19:52:27.472  INFO 11912 --- [           main] c.n.c.sources.URLConfigurationSource     : To enable URLs as dynamic configuration sources, define System property archaius.configurationSource.additionalUrls or make config.properties available on classpath.
2022-11-11 19:52:27.566  INFO 11912 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2022-11-11 19:52:27.774  INFO 11912 --- [           main] o.s.s.c.ThreadPoolTaskScheduler          : Initializing ExecutorService 'Nacos-Watch-Task-Scheduler'
2022-11-11 19:52:27.814  INFO 11912 --- [           main] m.tools_j2cache.config.RedisUtilsConfig  : 初始化 RedisUtilsConfig
2022-11-11 19:52:27.815  INFO 11912 --- [           main] m.tools_log.config.LogAutoConfiguration  : 初始化 LogAutoConfiguration
2022-11-11 19:52:27.840  INFO 11912 --- [           main] pertySourcedRequestMappingHandlerMapping : Mapped URL path [/v2/api-docs] onto method [springfox.documentation.swagger2.web.Swagger2Controller#getDocumentation(String, HttpServletRequest)]
2022-11-11 19:52:27.854  INFO 11912 --- [           main] m.t.config.SwaggerAutoConfiguration      : 初始化swagger接口文档
2022-11-11 19:52:27.855  INFO 11912 --- [           main] m.t.config.SwaggerAutoConfiguration      : 
title：在线文档
group：
description：在线文档
version：1.0
contact：Contact{name='mao', url='https://github.com/maomao124/', email='1234@qq.com'}
basePackage：
basePath：[]
excludePath：[]
docket：{auth=DocketInfo{title='权限模块', group='', description='在线文档', version='1.0', contact=Contact{name='', url='', email=''}, basePackage='mao.auth_server.controller.auth', basePath=[], excludePath=[]}, common=DocketInfo{title='公共模块', group='', description='在线文档', version='1.0', contact=Contact{name='', url='', email=''}, basePackage='mao.auth_server.controller.common', basePath=[], excludePath=[]}, core=DocketInfo{title='组织岗位模块', group='', description='在线文档', version='1.0', contact=Contact{name='', url='', email=''}, basePackage='mao.auth_server.controller.core', basePath=[], excludePath=[]}}

2022-11-11 19:52:29.401  INFO 11912 --- [           main] o.s.cloud.commons.util.InetUtils         : Cannot determine local hostname
2022-11-11 19:52:29.708  INFO 11912 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2022-11-11 19:52:29.735  INFO 11912 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 3 custom documentation plugin(s)
2022-11-11 19:52:29.795  INFO 11912 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2022-11-11 19:52:29.821  INFO 11912 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2022-11-11 19:52:29.965  INFO 11912 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2022-11-11 19:52:30.067  INFO 11912 --- [enerContainer-1] io.lettuce.core.EpollProvider            : Starting without optional epoll library
2022-11-11 19:52:30.069  INFO 11912 --- [enerContainer-1] io.lettuce.core.KqueueProvider           : Starting without optional kqueue library
2022-11-11 19:52:30.237  INFO 11912 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8764 (http) with context path ''
2022-11-11 19:52:30.243  INFO 11912 --- [           main] com.alibaba.nacos.client.naming          : [BEAT] adding beat: BeatInfo{port=8764, ip='192.168.202.1', weight=1.0, serviceName='DEFAULT_GROUP@@auth-server', cluster='DEFAULT', metadata={preserved.register.source=SPRING_CLOUD, management.endpoints.web.base-path=/actuator, management.context-path=/actuator}, scheduled=false, period=5000, stopped=false} to beat map.
2022-11-11 19:52:30.244  INFO 11912 --- [           main] com.alibaba.nacos.client.naming          : [REGISTER-SERVICE] 27ce69b0-bff1-4c03-8f3e-0ea5559a5732 registering service DEFAULT_GROUP@@auth-server with instance: Instance{instanceId='null', ip='192.168.202.1', port=8764, weight=1.0, healthy=true, enabled=true, ephemeral=true, clusterName='DEFAULT', serviceName='null', metadata={preserved.register.source=SPRING_CLOUD, management.endpoints.web.base-path=/actuator, management.context-path=/actuator}}
2022-11-11 19:52:30.347  INFO 11912 --- [           main] c.a.c.n.registry.NacosServiceRegistry    : nacos registry, DEFAULT_GROUP auth-server 192.168.202.1:8764 register finished
2022-11-11 19:52:30.735  INFO 11912 --- [.naming.updater] com.alibaba.nacos.client.naming          : new ips(1) service: DEFAULT_GROUP@@auth-server@@DEFAULT -> [{"instanceId":"192.168.202.1#8764#DEFAULT#DEFAULT_GROUP@@auth-server","ip":"192.168.202.1","port":8764,"weight":1.0,"healthy":true,"enabled":true,"ephemeral":true,"clusterName":"DEFAULT","serviceName":"DEFAULT_GROUP@@auth-server","metadata":{"preserved.register.source":"SPRING_CLOUD","management.endpoints.web.base-path":"/actuator","management.context-path":"/actuator"},"instanceHeartBeatTimeOut":15000,"instanceHeartBeatInterval":5000,"ipDeleteTimeout":30000}]
2022-11-11 19:52:30.746  INFO 11912 --- [.naming.updater] com.alibaba.nacos.client.naming          : current ips:(1) service: DEFAULT_GROUP@@auth-server@@DEFAULT -> [{"instanceId":"192.168.202.1#8764#DEFAULT#DEFAULT_GROUP@@auth-server","ip":"192.168.202.1","port":8764,"weight":1.0,"healthy":true,"enabled":true,"ephemeral":true,"clusterName":"DEFAULT","serviceName":"DEFAULT_GROUP@@auth-server","metadata":{"preserved.register.source":"SPRING_CLOUD","management.endpoints.web.base-path":"/actuator","management.context-path":"/actuator"},"instanceHeartBeatTimeOut":15000,"instanceHeartBeatInterval":5000,"ipDeleteTimeout":30000}]
2022-11-11 19:52:31.355  INFO 11912 --- [g.push.receiver] com.alibaba.nacos.client.naming          : received push data: {"type":"dom","data":"{\"hosts\":[{\"ip\":\"192.168.202.1\",\"port\":8764,\"valid\":true,\"healthy\":true,\"marked\":false,\"instanceId\":\"192.168.202.1#8764#DEFAULT#DEFAULT_GROUP@@auth-server\",\"metadata\":{\"preserved.register.source\":\"SPRING_CLOUD\",\"management.endpoints.web.base-path\":\"/actuator\",\"management.context-path\":\"/actuator\"},\"enabled\":true,\"weight\":1.0,\"clusterName\":\"DEFAULT\",\"serviceName\":\"DEFAULT_GROUP@@auth-server\",\"ephemeral\":true}],\"dom\":\"DEFAULT_GROUP@@auth-server\",\"name\":\"DEFAULT_GROUP@@auth-server\",\"cacheMillis\":10000,\"lastRefTime\":1668167551351,\"checksum\":\"d706e8bc2779a32044465e588c1a9d58\",\"useSpecifiedURL\":false,\"clusters\":\"DEFAULT\",\"env\":\"\",\"metadata\":{}}","lastRefTime":1865154234800} from /113.221.246.239
2022-11-11 19:52:31.617  INFO 11912 --- [           main] o.s.cloud.commons.util.InetUtils         : Cannot determine local hostname
2022-11-11 19:52:31.619  INFO 11912 --- [           main] mao.auth_server.AuthServerApplication    : Started AuthServerApplication in 17.445 seconds (JVM running for 18.488)
2022-11-11 19:52:31.628  INFO 11912 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] auth-server-dev.yml+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-11 19:52:31.630  INFO 11912 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=auth-server-dev.yml, group=DEFAULT_GROUP, cnt=1
2022-11-11 19:52:31.631  INFO 11912 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] auth-server+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-11 19:52:31.631  INFO 11912 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=auth-server, group=DEFAULT_GROUP, cnt=1
2022-11-11 19:52:31.632  INFO 11912 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] auth-server.yml+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-11 19:52:31.632  INFO 11912 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=auth-server.yml, group=DEFAULT_GROUP, cnt=1
2022-11-11 19:52:31.634  INFO 11912 --- [           main] c.a.n.client.config.impl.ClientWorker    : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [subscribe] common.yml+DEFAULT_GROUP+27ce69b0-bff1-4c03-8f3e-0ea5559a5732
2022-11-11 19:52:31.634  INFO 11912 --- [           main] c.a.nacos.client.config.impl.CacheData   : [fixed-127.0.0.1_8848-27ce69b0-bff1-4c03-8f3e-0ea5559a5732] [add-listener] ok, tenant=27ce69b0-bff1-4c03-8f3e-0ea5559a5732, dataId=common.yml, group=DEFAULT_GROUP, cnt=1
2022-11-11 19:52:31.635  INFO 11912 --- [           main] mao.auth_server.AuthServerApplication    : 应用auth-server启动成功!swagger地址：http://113.221.246.239:8764/doc.html
2022-11-11 19:52:31.635  INFO 11912 --- [           main] mao.auth_server.AuthServerApplication    : 启动耗时：17592ms
2022-11-11 19:52:31.973  INFO 11912 --- [113.221.246.239] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-11-11 19:52:31.973  INFO 11912 --- [113.221.246.239] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-11-11 19:52:31.993  INFO 11912 --- [113.221.246.239] o.s.web.servlet.DispatcherServlet        : Completed initialization in 20 ms
2022-11-11 19:52:33.593  INFO 11912 --- [113.221.246.239] com.alibaba.druid.pool.DruidDataSource   : {dataSource-1} inited
 Consume Time：2 ms 2022-11-11 19:52:33
 Execute SQL：/* ping */ SELECT 1

```





第七步：访问





![image-20221111195444841](img/通用权限系统实战学习笔记/image-20221111195444841.png)





![image-20221111195551656](img/通用权限系统实战学习笔记/image-20221111195551656.png)







```sh
2022-11-11 19:55:39.951 DEBUG 11912 --- [         task-1] m.a.dao.common.OptLogMapper.insert       : ==>  Preparing: INSERT INTO common_opt_log ( id, finish_time, action_method, description, request_ip, request_uri, ua, params, http_method, user_name, type, result, consuming_time, create_time, class_path, start_time, create_user ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) 
2022-11-11 19:55:39.963 DEBUG 11912 --- [         task-1] m.a.dao.common.OptLogMapper.insert       : ==> Parameters: 102841309777100833(Long), 2022-11-11T19:55:39.929(LocalDateTime), login(String), 登录控制器-登录(String), 113.221.246.239(String), /anno/login(String), Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36 Edg/107.0.1418.35(String), [{"account":"123","code":"前些提先敢变","key":"10001","password":"123456"}](String), POST(String), (String), OPT(String), {"code":0,"data":{"permissionsList":["org:add","role:config","resource:add","resource:update","resource:delete","org:update","org:delete","org:view","org:import","org:export","station:add","station:update","station:delete","station:view","station:export","station:import","user:add","user:update","user:delete","user:view","user:import","user:export","menu:add","menu:update","menu:delete","menu:view","menu:export","menu:import","role:add","role:update","role:delete","role:view","role:export","role:import","role:auth","optLog:view","optLog:export","optLog:delete","loginLog:delete","loginLog:export","file:add","file:update","file:delete","file:view","receive:view","send:view","rule:config-view","resource:view"],"token":{"expire":43200,"token":"eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzIiwiYWNjb3VudCI6IjEyMyIsIm5hbWUiOiLlubPlj7DnrqHnkIblkZgiLCJvcmdpZCI6MTAwLCJzdGF0aW9uaWQiOjEwMCwiZXhwIjoxNjY4MjEwOTM5fQ.nh4YCIw7H-2P6G-LvR0VLY4cgZKS7EQdZgxG2FfQl3aBXCV06ug5DT2z15mmEUdz94i9kg1PIoLJ7erlCIEjNhuEbDpQ0eij2Cx9wWyaIweTIshPcFZS40i4WiPrFzDpRAfjTmvW6B47PGGbYkO59vWBiMSewSV4nF4FHsh4MMA"},"user":{"account":"123","avatar":"BiazfanxmamNRoxxVxka.png","email":"","id":3,"lastLoginTime":"2022-11-10T21:56:55","mobile":"","name":"平台管理员","orgId":100,"sex":"M","stationId":100,"status":true,"workDescribe":"超级管理员"}},"isError":false,"isSuccess":true,"msg":"ok","timestamp":1668167739912}(String), 763(Long), 2022-11-11T19:55:39.950(LocalDateTime), mao.auth_server.controller.auth.LoginController(String), 2022-11-11T19:55:39.166(LocalDateTime), 0(Long)
2022-11-11 19:55:39.967 DEBUG 11912 --- [         task-1] m.a.dao.common.OptLogMapper.insert       : <==    Updates: 1
 Consume Time：3 ms 2022-11-11 19:55:39
 Execute SQL：INSERT INTO common_opt_log ( id, finish_time, action_method, description, request_ip, request_uri, ua, params, http_method, user_name, type, result, consuming_time, create_time, class_path, start_time, create_user ) VALUES ( 102841309777100833, '2022-11-11T19:55:39.929', 'login', '登录控制器-登录', '113.221.246.239', '/anno/login', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36 Edg/107.0.1418.35', '[{"account":"123","code":"前些提先敢变","key":"10001","password":"123456"}]', 'POST', '', 'OPT', '{"code":0,"data":{"permissionsList":["org:add","role:config","resource:add","resource:update","resource:delete","org:update","org:delete","org:view","org:import","org:export","station:add","station:update","station:delete","station:view","station:export","station:import","user:add","user:update","user:delete","user:view","user:import","user:export","menu:add","menu:update","menu:delete","menu:view","menu:export","menu:import","role:add","role:update","role:delete","role:view","role:export","role:import","role:auth","optLog:view","optLog:export","optLog:delete","loginLog:delete","loginLog:export","file:add","file:update","file:delete","file:view","receive:view","send:view","rule:config-view","resource:view"],"token":{"expire":43200,"token":"eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzIiwiYWNjb3VudCI6IjEyMyIsIm5hbWUiOiLlubPlj7DnrqHnkIblkZgiLCJvcmdpZCI6MTAwLCJzdGF0aW9uaWQiOjEwMCwiZXhwIjoxNjY4MjEwOTM5fQ.nh4YCIw7H-2P6G-LvR0VLY4cgZKS7EQdZgxG2FfQl3aBXCV06ug5DT2z15mmEUdz94i9kg1PIoLJ7erlCIEjNhuEbDpQ0eij2Cx9wWyaIweTIshPcFZS40i4WiPrFzDpRAfjTmvW6B47PGGbYkO59vWBiMSewSV4nF4FHsh4MMA"},"user":{"account":"123","avatar":"BiazfanxmamNRoxxVxka.png","email":"","id":3,"lastLoginTime":"2022-11-10T21:56:55","mobile":"","name":"平台管理员","orgId":100,"sex":"M","stationId":100,"status":true,"workDescribe":"超级管理员"}},"isError":false,"isSuccess":true,"msg":"ok","timestamp":1668167739912}', 763, '2022-11-11T19:55:39.950', 'mao.auth_server.controller.auth.LoginController', '2022-11-11T19:55:39.166', 0 )

```





```sh
PS C:\Users\mao\Desktop> mysql -u root -p
Enter password: ********
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 49
Server version: 8.0.27 MySQL Community Server - GPL

Copyright (c) 2000, 2021, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> use authority
Database changed
mysql> select * from common_opt_log\G;
*************************** 1. row ***************************
            id: 102841309777100833
    request_ip: 113.221.246.239
          type: OPT
     user_name:
   description: 登录控制器-登录
    class_path: mao.auth_server.controller.auth.LoginController
 action_method: login
   request_uri: /anno/login
   http_method: POST
        params: [{"account":"123","code":"前些提先敢变","key":"10001","password":"123456"}]
        result: {"code":0,"data":{"permissionsList":["org:add","role:config","resource:add","resource:update","resource:delete","org:update","org:delete","org:view","org:import","org:export","station:add","station:update","station:delete","station:view","station:export","station:import","user:add","user:update","user:delete","user:view","user:import","user:export","menu:add","menu:update","menu:delete","menu:view","menu:export","menu:import","role:add","role:update","role:delete","role:view","role:export","role:import","role:auth","optLog:view","optLog:export","optLog:delete","loginLog:delete","loginLog:export","file:add","file:update","file:delete","file:view","receive:view","send:view","rule:config-view","resource:view"],"token":{"expire":43200,"token":"eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIzIiwiYWNjb3VudCI6IjEyMyIsIm5hbWUiOiLlubPlj7DnrqHnkIblkZgiLCJvcmdpZCI6MTAwLCJzdGF0aW9uaWQiOjEwMCwiZXhwIjoxNjY4MjEwOTM5fQ.nh4YCIw7H-2P6G-LvR0VLY4cgZKS7EQdZgxG2FfQl3aBXCV06ug5DT2z15mmEUdz94i9kg1PIoLJ7erlCIEjNhuEbDpQ0eij2Cx9wWyaIweTIshPcFZS40i4WiPrFzDpRAfjTmvW6B47PGGbYkO59vWBiMSewSV4nF4FHsh4MMA"},"user":{"account":"123","avatar":"BiazfanxmamNRoxxVxka.png","email":"","id":3,"lastLoginTime":"2022-11-10T21:56:55","mobile":"","name":"平台管理员","orgId":100,"sex":"M","stationId":100,"status":true,"workDescribe":"超级管理员"}},"isError":false,"isSuccess":true,"msg":"ok","timestamp":1668167739912}
       ex_desc: NULL
     ex_detail: NULL
    start_time: 2022-11-11 19:55:39
   finish_time: 2022-11-11 19:55:40
consuming_time: 763
            ua: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36 Edg/107.0.1418.35
   create_time: 2022-11-11 19:55:40
   create_user: 0
1 row in set (0.00 sec)

ERROR:
No query specified


mysql>
```











代码很多，其它代码不展示









# 网关服务开发

## 配置文件

### bootstrap.yml



```yaml
def:
  # docker部署时，需要指定， 表示运行该服务的宿主机IP
  local-ip: ${LOCAL_IP:${spring.cloud.client.ip-address}}
  nacos:
    ip: ${NACOS_IP:@pom.nacos.ip@}
    port: ${NACOS_PORT:@pom.nacos.port@}
    namespace: ${NACOS_ID:@pom.nacos.namespace@}

spring:
  main:
    allow-bean-definition-overriding: true
  application:
    name: @project.artifactId@ #pd-gateway
  profiles:
    active: @pom.profile.name@ #dev
  cloud:
    nacos:
      config:
        server-addr: ${def.nacos.ip}:${def.nacos.port}
        file-extension: yml
        namespace: ${def.nacos.namespace}
        shared-dataids: common.yml,redis.yml,mysql.yml
        refreshable-dataids: common.yml
        enabled: true
      discovery:
        # 是否为临时实例
        ephemeral: false
        server-addr: ${def.nacos.ip}:${def.nacos.port}
        namespace: ${def.nacos.namespace}
        metadata:
          management.context-path: ${server.servlet.context-path:}${spring.mvc.servlet.path:}${management.endpoints.web.base-path:}

```





### j2cache配置文件



```properties
#########################################
# Caffeine configuration
# \u6682\u65F6\u6CA1\u7528
# [name] = size, xxxx[s|m|h|d]
#########################################
default=2000, 2h
resource=2000, 1h
```







### 密钥文件



![image-20221113191215186](img/通用权限系统实战学习笔记/image-20221113191215186.png)







## 启动类



```java
package mao.gateway;

import lombok.extern.slf4j.Slf4j;
import mao.tools_jwt.client.EnableAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@EnableZuulProxy
@EnableAuthClient
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients({"mao"})
public class GatewayApplication
{

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GatewayApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String appName = environment.getProperty("spring.application.name");
        log.info("应用{}启动成功!", appName);
        log.info("启动耗时：" + (System.currentTimeMillis() - start) + "ms");
    }

}
```





## 配置类



```java
package mao.gateway.config;

import mao.tools_common.config.BaseConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.config
 * Class(类名): ZuulConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 14:41
 * Version(版本): 1.0
 * Description(描述)： 配置类
 */

@Configuration
public class ZuulConfiguration extends BaseConfig
{
    @Bean
    public CorsFilter corsFilter()
    {
        final UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        final org.springframework.web.cors.CorsConfiguration config =
                new org.springframework.web.cors.CorsConfiguration();
        // 允许cookies跨域
        config.setAllowCredentials(true);
        // #允许向该服务器提交请求的URI，*表示全部允许
        config.addAllowedOrigin("*");
        // #允许访问的头信息,*表示全部
        config.addAllowedHeader("*");
        // 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.setMaxAge(18000L);
        // 允许提交请求的方法，*表示全部允许
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        // 允许Get的请求类型
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
```







## API接口和熔断器



```java
package mao.gateway.api;

import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.api
 * Interface(接口名): ResourceApi
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 13:42
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@FeignClient(name = "${feign.authority-server:auth-server}",
        fallback = ResourceApiFallback.class)
public interface ResourceApi
{
    /**
     * 查询所有资源
     *
     * @return {@link R}<{@link List}>
     */
    @GetMapping("/resource/list")
    R<List> list();

    /**
     * 查询用户可用的所有资源
     *
     * @param resource 资源
     * @return {@link R}<{@link List}<{@link Resource}>>
     */
    @GetMapping("/resource")
    R<List<Resource>> visible(ResourceQueryDTO resource);
}
```





```java
package mao.gateway.api;

import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;
import mao.tools_core.base.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.api
 * Class(类名): ResourceApiFallback
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 13:45
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Component
public class ResourceApiFallback implements ResourceApi
{

    @Override
    public R<List> list()
    {
        return null;
    }

    @Override
    public R<List<Resource>> visible(ResourceQueryDTO resource)
    {
        return null;
    }
}
```







## 过滤器

### AccessFilter



```java
package mao.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.gateway.api.ResourceApi;
import mao.tools_common.constant.CacheKey;
import mao.tools_core.constants.BaseContextConstants;
import mao.tools_core.exception.ExceptionCode;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.filter
 * Class(类名): AccessFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 14:10
 * Version(版本): 1.0
 * Description(描述)： 鉴权处理过滤器
 */


@Slf4j
@Component
public class AccessFilter extends BaseFilter
{
    @Resource
    private ResourceApi resourceApi;

    @Resource
    private CacheChannel cacheChannel;

    @Override
    public String filterType()
    {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder()
    {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 10;
    }

    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    @Override
    public Object run() throws ZuulException
    {
        //判断当前请求uri是否需要忽略
        boolean ignoreToken = this.isIgnoreToken();
        if (ignoreToken)
        {
            //忽略，直接放行
            return null;
        }
        //需要验证
        //获得HttpServletRequest
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        //获得请求方式
        String method = request.getMethod();
        //获得uri
        String requestURI = request.getRequestURI();
        requestURI = StrUtil.subSuf(requestURI, zuulPrefix.length());
        requestURI = StrUtil.subSuf(requestURI, requestURI.indexOf("/", 1));
        //拼接成GET/user/page这种形式
        String permission = method + requestURI;
        //从缓存里取需要进行鉴权的资源
        CacheObject cacheObject = cacheChannel.get(CacheKey.RESOURCE, CacheKey.RESOURCE_NEED_TO_CHECK);
        List<String> list = (List<String>) cacheObject.getValue();
        //判断是否为空，如果没有获取到则通过Feign调用权限服务获取并放入缓存中
        if (list == null)
        {
            //远程调用
            list = resourceApi.list().getData();
            if (list != null && list.size() > 0)
            {
                //放入缓存
                cacheChannel.set(CacheKey.RESOURCE, CacheKey.RESOURCE_NEED_TO_CHECK, list);
            }
        }

        //判断这些资源是否包含当前请求的权限标识符
        long count = list.stream().filter(permission::startsWith).count();
        //不包含
        if (count == 0)
        {
            //当前请求是一个未知请求，直接返回未授权异常信息
            errorResponse(ExceptionCode.UNAUTHORIZED.getMsg(), ExceptionCode.UNAUTHORIZED.getCode(), 200);
            return null;
        }

        //如果包含当前的权限标识符，则从zuul header中取出用户id，根据用户id取出缓存中的用户拥有的权限
        String userId = RequestContext.getCurrentContext().getZuulRequestHeaders().get(BaseContextConstants.JWT_KEY_USER_ID);
        //从缓存里取用户可用的资源
        List<String> visibleResource = (List<String>) cacheChannel.get(CacheKey.USER_RESOURCE, userId).getValue();

        //缓存里没有，如果没有取到则通过Feign调用权限服务获取并放入缓存，判断用户拥有的权限是否包含当前请求的权限标识符
        if (visibleResource == null)
        {
            //缓存中不存在，需要通过接口远程调用权限服务来获取
            ResourceQueryDTO resourceQueryDTO = ResourceQueryDTO.builder().userId(new Long(userId)).build();
            //获取resourceList
            List<mao.auth_entity.entity.auth.Resource> resourceList = resourceApi.visible(resourceQueryDTO).getData();
            if (resourceList != null && resourceList.size() > 0)
            {
                visibleResource = resourceList.stream().map((resource -> resource.getMethod() +
                        resource.getUrl())).collect(Collectors.toList());
                //缓存
                cacheChannel.set(CacheKey.USER_RESOURCE, userId, visibleResource);
            }
        }

        //如果用户拥有的权限包含当前请求的权限标识符则说明当前用户拥有权限，直接放行
        count = visibleResource.stream().filter(permission::startsWith).count();


        if (count > 0)
        {
            //大于0，当前用户拥有权限
            return null;
        }
        else
        {
            //等于0，没有权限，返回未授权
            errorResponse(ExceptionCode.UNAUTHORIZED.getMsg(), ExceptionCode.UNAUTHORIZED.getCode(), 200);
            return null;
        }
    }

}
```





### BaseFilter



```java
package mao.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import mao.tools_common.config.IgnoreTokenConfig;
import mao.tools_core.base.R;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.filter
 * Class(类名): BaseFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 14:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public abstract class BaseFilter extends ZuulFilter
{
    @Value("${server.servlet.context-path}")
    protected String zuulPrefix;// /api

    /**
     * 判断当前请求uri是否需要忽略（直接放行）
     *
     * @return boolean
     */
    protected boolean isIgnoreToken()
    {
        //动态获取当前请求的uri
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String uri = request.getRequestURI();
        uri = StrUtil.subSuf(uri, zuulPrefix.length());
        uri = StrUtil.subSuf(uri, uri.indexOf("/", 1));
        return IgnoreTokenConfig.isIgnoreToken(uri);
    }

    /**
     * 错误响应
     * 网关抛异常，不再进行路由，而是直接返回到前端
     *
     * @param errMsg         错误消息
     * @param errCode        错误代码
     * @param httpStatusCode http状态代码
     */
    protected void errorResponse(String errMsg, int errCode, int httpStatusCode)
    {
        RequestContext currentContext = RequestContext.getCurrentContext();
        //设置响应状态码
        currentContext.setResponseStatusCode(httpStatusCode);
        //设置响应头信息
        currentContext.addZuulResponseHeader("Content-Type", "application/json;charset=utf-8");
        if (currentContext.getResponseBody() == null)
        {
            //设置响应体
            currentContext.setResponseBody(R.fail(errCode, errMsg).toString());
            //不进行路由，直接返回
            currentContext.setSendZuulResponse(false);
        }
    }
}
```





### TokenContextFilter



```java
package mao.gateway.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import mao.tools_core.base.R;
import mao.tools_core.constants.BaseContextConstants;
import mao.tools_core.exception.BizException;
import mao.tools_core.utils.StrHelper;
import mao.tools_jwt.client.config.AuthClientConfigurationProperties;
import mao.tools_jwt.client.utils.JwtTokenClientUtils;
import mao.tools_jwt.entity.JwtUserInfo;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.filter
 * Class(类名): TokenContextFilter
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 14:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Component
public class TokenContextFilter extends BaseFilter
{

    @Resource
    private AuthClientConfigurationProperties authClientConfigurationProperties;

    @Resource
    private JwtTokenClientUtils jwtTokenClientUtils;

    /**
     * 前置过滤器
     *
     * @return {@link String}
     */
    @Override
    public String filterType()
    {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 设置过滤器执行顺序，数值越大优先级越低
     *
     * @return int
     */
    @Override
    public int filterOrder()
    {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    /**
     * 是否执行当前过滤器
     *
     * @return boolean
     */
    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    @Override
    public Object run() throws ZuulException
    {
        //判断是否需要直接放行
        boolean ignoreToken = this.isIgnoreToken();
        if (ignoreToken)
        {
            //直接放行
            return null;
        }
        //需要认证
        //获取HttpServletRequest
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        //获取RequestContext
        RequestContext requestContext = RequestContext.getCurrentContext();
        //从请求头中获取token
        String token = request.getHeader(authClientConfigurationProperties.getUser().getHeaderName());
        JwtUserInfo userInfo = null;
        try
        {
            //解析token令牌
            userInfo = jwtTokenClientUtils.getUserInfo(token);
        }
        catch (BizException e)
        {
            //业务异常
            errorResponse(e.getMessage(), e.getCode(), 200);
            return null;
        }
        catch (Exception e)
        {
            //其它异常
            errorResponse("解析jwt令牌出错", R.FAIL_CODE, 200);
            return null;
        }

        //将信息放入header
        if (userInfo != null)
        {
            addHeader(requestContext, BaseContextConstants.JWT_KEY_ACCOUNT,
                    userInfo.getAccount());
            addHeader(requestContext, BaseContextConstants.JWT_KEY_USER_ID,
                    userInfo.getUserId());
            addHeader(requestContext, BaseContextConstants.JWT_KEY_NAME,
                    userInfo.getName());
            addHeader(requestContext, BaseContextConstants.JWT_KEY_ORG_ID,
                    userInfo.getOrgId());
            addHeader(requestContext, BaseContextConstants.JWT_KEY_STATION_ID,
                    userInfo.getStationId());
        }
        return null;
    }

    /**
     * 将一个键值对添加到请求头中
     *
     * @param requestContext 请求上下文
     * @param key            key
     * @param value          value
     */
    private void addHeader(RequestContext requestContext, String key, Object value)
    {
        //空的就不添加
        if (StringUtils.isEmpty(key))
        {
            return;
        }
        if (StringUtils.isEmpty(value))
        {
            return;
        }
        requestContext.addZuulRequestHeader(key, StrHelper.encode(value.toString()));
    }


}
```





































---
end

---
by mao 
2022  11  13

---
