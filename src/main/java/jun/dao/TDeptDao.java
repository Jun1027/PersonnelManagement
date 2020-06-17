package jun.dao;

import jun.entity.TDept;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TDept)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 11:32:54
 */
public interface TDeptDao extends Dao<TDept> {


    /**
     * 根据部门id查询该部门下是否有员工
     * @param ids
     * @return
     */
    int selectStaffNum(int[] ids);
}