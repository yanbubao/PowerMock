package test.mock;

/**
 * @author: yanzx
 * @date: 2019/08/21 00:21
 */
public class LocalServiceImpl implements ILocalService {

    IRemoteService iRemoteService;

    public Player getPlayer(String name) {
        return iRemoteService.getPlayer(name);
    }
}
