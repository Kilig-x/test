package cn.itrip.dao.userlinkuser;

import cn.itrip.beans.pojo.ItripUserLinkUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItripUserLinkUserMapper {


	public List<ItripUserLinkUser>	getItripUserLinkUserListByMap(Map<String, Object> param)throws Exception;


}
