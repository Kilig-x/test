package cn.itrip.service.userlinkuser;

import cn.itrip.beans.pojo.ItripUserLinkUser;
import cn.itrip.common.Constants;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import cn.itrip.dao.userlinkuser.ItripUserLinkUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ItripUserLinkUserServiceImpl implements ItripUserLinkUserService {

    @Resource
    private ItripUserLinkUserMapper itripUserLinkUserMapper;

    public List<ItripUserLinkUser>	getItripUserLinkUserListByMap(Map<String,Object> param)throws Exception{
        List<ItripUserLinkUser> list = itripUserLinkUserMapper.getItripUserLinkUserListByMap(param);
        return list;
    }



}
