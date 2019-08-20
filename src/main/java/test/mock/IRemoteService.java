package test.mock;

/**
 * @author: yanzx
 * @date: 2019/08/21 00:23
 */
public interface IRemoteService {

    /**
     * get by rpc
     *
     * @param playerName name
     * @return
     */
    Player getPlayer(String playerName);
}
