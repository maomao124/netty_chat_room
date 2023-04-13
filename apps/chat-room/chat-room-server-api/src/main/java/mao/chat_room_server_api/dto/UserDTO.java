package mao.chat_room_server_api.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_server_api.dto
 * Class(类名): UserDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/13
 * Time(创建时间)： 13:15
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
@ApiModel(value = "用户DTO")
@Accessors(chain = true)
public class UserDTO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @TableField("username")
    @ApiModelProperty(value = "用户名", notes = "用户名")
    private String username;


    /**
     * 启用状态 1启用 0禁用
     */
    @TableField("status")
    @ApiModelProperty(value = "启用状态 1启用 0禁用", notes = "启用状态 1启用 0禁用")
    private Boolean status;


    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    @ApiModelProperty(value = "最后登录时间", notes = "最后登录时间")
    private LocalDateTime lastLoginTime;

    /**
     * 注册时间
     */
    @TableField("register_time")
    @ApiModelProperty(value = "注册时间", notes = "注册时间")
    private LocalDateTime registerTime;

    /**
     * 最后一次输错密码时间
     */
    @TableField("password_error_last_time")
    @ApiModelProperty(value = "最后一次输错密码时间", notes = "最后一次输错密码时间")
    private LocalDateTime passwordErrorLastTime;

    /**
     * 密码错误次数
     */
    @TableField("password_error_num")
    @ApiModelProperty(value = "密码错误次数", notes = "密码错误次数")
    private Integer passwordErrorNum;
}
