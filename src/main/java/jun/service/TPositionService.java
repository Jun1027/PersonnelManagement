package jun.service;

import jun.entity.TPosition;
import java.util.List;

/**
 * (TPosition)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 11:32:24
 */
public interface TPositionService extends Service<TPosition>{

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<TPosition> queryAll(TPosition tPosition);

    /**
     * 根据职位id查询该职位下是否有员工
     * @param ids
     * @return
     */
    int selectStaffNum(int[] ids);


}