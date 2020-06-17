package jun.service;

import jun.entity.TDept;
import java.util.List;

/**
 * (TDept)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 11:32:54
 */
public interface TDeptService extends Service<TDept> {

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<TDept> queryAll(TDept tDept);

    /**
     * 根据部门id查询该部门下是否有员工
     * @param ids
     * @return
     */
    int selectStaffNum(int[] ids);


}