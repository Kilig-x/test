package cn.itrip.service.userlinkuser;

import cn.itrip.beans.pojo.ItripUserLinkUser;
import cn.itrip.common.Page;

import java.util.List;
import java.util.Map;

/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripUserLinkUserService {


    public List<ItripUserLinkUser>	getItripUserLinkUserListByMap(Map<String, Object> param)throws Exception;

}
