package mao.chat_room_common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Project name(项目名称)：netty_chat_room
 * Package(包名): mao.chat_room_common.entity
 * Class(类名): Server
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/4/1
 * Time(创建时间)： 19:53
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
public class Server
{
    /**
     * 服务ip
     */
    private String ip;

    /**
     * 端口
     */
    private Integer port;
}
