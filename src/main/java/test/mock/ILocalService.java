package test.mock;

/**
 * @author: yanzx
 * @date: 2019/08/21 00:21
 */
public interface ILocalService {

    /**
     * 根据姓名获取球员
     *
     * @param name 球员姓名
     * @return
     */
    Player getPlayer(String name);
}
