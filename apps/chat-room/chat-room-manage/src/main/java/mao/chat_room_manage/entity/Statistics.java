package mao.chat_room_manage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.entity
 * Class(类名): Statistics
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/11
 * Time(创建时间)： 13:56
 * Version(版本): 1.0
 * Description(描述)： 统计信息
 */

@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "Statistics", description = "统计信息")
public class Statistics implements Serializable
{

    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
    private String time;

    /**
     * 统计结果
     */
    @ApiModelProperty(value = "统计结果")
    private Long count;
}
