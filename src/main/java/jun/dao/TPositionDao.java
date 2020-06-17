package jun.dao;

import jun.entity.TPosition;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TPosition)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 11:32:24
 */
public interface TPositionDao extends Dao<TPosition> {


    /**
     * 根据职位id查询该职位下是否有员工
     * @param ids
     * @return
     */
    int selectStaffNum(int[] ids);
}