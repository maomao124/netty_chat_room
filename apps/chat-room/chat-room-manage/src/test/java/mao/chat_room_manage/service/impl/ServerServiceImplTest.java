package mao.chat_room_manage.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import mao.chat_room_server_api.utils.ClusterUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
class ServerServiceImplTest
{
    @Autowired
    private ServerServiceImpl serverServiceImpl;

    /**
     * Method under test: {@link ServerServiceImpl#getNettyServers()}
     */
    @Test
    void testGetNettyServers()
    {
        List<ServiceInstance> nettyServers = serverServiceImpl.getNettyServers();
        for (ServiceInstance nettyServer : nettyServers)
        {
            System.out.println(JSON.toJSONString(nettyServer, true));
            System.out.println();
        }
    }
}

