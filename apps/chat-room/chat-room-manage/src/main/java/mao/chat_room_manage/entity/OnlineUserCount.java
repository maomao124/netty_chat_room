package mao.chat_room_manage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Set;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_manage.entity
 * Class(类名): OnlineUserCount
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/12
 * Time(创建时间)： 13:54
 * Version(版本): 1.0
 * Description(描述)： 在线用户统计
 */

@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "OnlineUserCount", description = "在线用户统计信息")
public class OnlineUserCount
{
    /**
     * 实例列表
     */
    @ApiModelProperty(value = "实例列表", notes = "实例列表")
    private List<Instance> instanceList;

    /**
     * 当前在线人数总数
     */
    @ApiModelProperty(value = "当前在线人数总数", notes = "当前在线人数总数")
    private Long totalCount;
}
