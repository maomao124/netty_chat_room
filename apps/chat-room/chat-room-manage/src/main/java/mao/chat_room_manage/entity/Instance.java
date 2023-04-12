package mao.chat_room_manage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.entity
 * Class(类名): Instance
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/12
 * Time(创建时间)： 13:55
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "Instance", description = "实例的统计信息")
public class Instance
{
    /**
     * 实例的地址
     */
    @ApiModelProperty(value = "实例的地址", notes = "实例的地址")
    private String host;

    /**
     * 统计计数
     */
    @ApiModelProperty(value = "统计计数", notes = "统计计数")
    private Long count;
}
