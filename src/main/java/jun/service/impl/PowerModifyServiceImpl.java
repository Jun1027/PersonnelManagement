package jun.service.impl;

import jun.dao.PowerModifyDao;
import jun.entity.TPermission;
import jun.entity.TUser;
import jun.service.PowerModifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限修改服务实现类
 *Create by Jun on 2020-05-30
 */
@Service("powerModifyService")
public class PowerModifyServiceImpl implements PowerModifyService {

    @Resource
    private PowerModifyDao powerModifyDao;

    @Override
    public Integer selectByAccount(String account) {
        return powerModifyDao.selectByAccount(account);
    }

    @Override
    public List<TPermission> selectPermissions() {
        return powerModifyDao.selectPermissions();
    }

    @Override
    public List<Integer> selectMyselfPermission(int rid) {
        return powerModifyDao.selectMyselfPermission(rid);
    }

    @Override
    public int removePermission(int rid) {
        return powerModifyDao.removePermission(rid);
    }

    @Override
    public int addPermission(int rid, int pid) {
        return powerModifyDao.addPermission(rid,pid);
    }
}
