package org.vwvm.store.mappers.adminMapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.vwvm.store.beans.adminBean.Member;

import java.util.List;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author vwvm
 * @since 2022-09-07
 */
@Component
public interface MemberMapper extends BaseMapper<Member> {


    Member loadByName(String name);


    Object countByName(String name);

    List<Member> pager(Long pageNum, Long pageSize);

    List<Member> pagerByName(String name, Long pageNum, Long pageSize);
}
