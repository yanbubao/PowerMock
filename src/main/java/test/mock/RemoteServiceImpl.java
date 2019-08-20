package test.mock;

/**
 * 外部依赖业务类，由其他人实现，可能我们的业务类写好了别人还没写好
 *
 * @author: yanzx
 * @date: 2019/08/21 00:25
 */
public class RemoteServiceImpl implements IRemoteService {

    /**
     * 外部类提供的一些业务方法
     *
     * @param playerName name
     * @return
     */
    public Player getPlayer(String playerName) {
        return new Player("wade", 3);
    }
}
