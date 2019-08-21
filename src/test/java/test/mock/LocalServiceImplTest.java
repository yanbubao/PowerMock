package test.mock;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LocalServiceImplTest {

    /**
     * @InjectMocks 表示这个对象需要注入mock对象
     */
    @InjectMocks
    private LocalServiceImpl localService;

    /**
     * @Mock 表示会自动创建一个mock对象并注入到@InjectMocks标识的localService中
     */
    @Mock
    private RemoteServiceImpl remoteService;

    /**
     * 如果不使用上述注解，可以使用@Before方法来手动进行mock对象的创建和注入，但会几行很多代码
     */
    /*
    private LocalServiceImpl localService;
    private RemoteServiceImpl remoteService;

    @Before
    public void setUp() throws Exception {
        localService = new LocalServiceImpl();
        remoteService = Mockito.mock(RemoteServiceImpl.class);  //创建Mock对象
        Whitebox.setInternalState(localService, "remoteService", remoteService); //注入依赖对象
    }
    */


    @Test
    public void testMock() {
        // 要mock的结果
        Player target = new Player("kobe", 24);

        // 指定remoteService.getPlayer方法传入参数"k"时返回target对象
        when(remoteService.getPlayer("k")).thenReturn(target);

        // 调用本地业务方法
        Player result = localService.getPlayer("k");


        assertEquals(target, result);
        assertEquals("kobe", result.getName());

        // 传入未指定参数"zz"时，无返回规则
        Player error = localService.getPlayer("zz");
        assertNull(error);

    }

    @Test
    public void testAny(){
        Player target1 = new Player("kobe", 24);
        Player target2 = new Player("james", 23);
        Player target3 = new Player("curry", 30);

        // 第一次调用返回target1、第二次返回target2、第三次返回target3
        when(remoteService.getPlayer(anyString())).thenReturn(target1).thenReturn(target2).thenReturn(target3);

        Player result1 = localService.getPlayer("1");
        Player result2 = localService.getPlayer("2");
        Player result3 = localService.getPlayer("3");

        assertEquals(target1,result1);
        assertEquals(target2,result2);
        assertEquals(target3,result3);

    }
}
