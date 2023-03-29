package mao.chat_room_server_api.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_server_api.entity
 * Class(类名): User
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/28
 * Time(创建时间)： 21:43
 * Version(版本): 1.0
 * Description(描述)： 用户实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@Accessors(chain = true)
@TableName("auth_user")
public class User
{

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableField("id")
    private Long id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;


    /**
     * 启用状态 1启用 0禁用
     */
    @TableField("status")
    private Boolean status;


    /**
     * 密码
     */
    @TableField(value = "password", condition = LIKE)
    private String password;

    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    /**
     * 注册时间
     */
    @TableField("register_time")
    private LocalDateTime registerTime;
}
