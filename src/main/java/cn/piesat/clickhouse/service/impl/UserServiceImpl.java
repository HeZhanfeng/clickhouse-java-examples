package cn.piesat.clickhouse.service.impl;

import cn.piesat.clickhouse.commons.base.BaseServiceImpl;
import cn.piesat.clickhouse.entity.Logs1;
import cn.piesat.clickhouse.entity.User;
import cn.piesat.clickhouse.mapper.Logs1Mapper;
import cn.piesat.clickhouse.mapper.UserMapper;
import cn.piesat.clickhouse.service.ILogs1Service;
import cn.piesat.clickhouse.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hezhanfeng
 * @since 2022-10-20
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {

}
