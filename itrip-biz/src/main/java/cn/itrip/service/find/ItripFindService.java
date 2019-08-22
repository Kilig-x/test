package cn.itrip.service.find;

import cn.itrip.beans.pojo.ItripHotelTradingArea;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.beans.vo.ItripAreaDicVO;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.hotel.ItripSearchFacilitiesHotelVO;
import cn.itrip.beans.vo.hotel.ItripSearchPolicyHotelVO;


import java.util.List;

public interface ItripFindService {

    //查询热门城市
    public List<ItripAreaDicVO> itripQueryHotcity(Integer cityId) throws Exception;

    //查询所有酒店特色
    public List<ItripLabelDicVO> itripQueryHotelFeatures() throws Exception;

    //查询城市商圈
    public List<ItripHotelTradingArea> itripQueryTradearea(Integer cityId) throws Exception;

    //获取酒店视频信息
    // 查询酒店名称
    public String getItripHotelName(Integer cityId) throws Exception;

    //酒店特色
    public List<String> getItripHotelFeatureList(Integer cityId) throws Exception;

    //酒店商圈
    public List<String> getItripTradingAreaNameList(Integer cityId) throws Exception;

    //查询酒店描述和特色
    public List<ItripLabelDic> itripQueryHotelDetails(Integer cityId) throws Exception;

    //查询酒店设施
    public List<ItripSearchFacilitiesHotelVO> itripQueryHotelFacilities(Integer cityId) throws Exception;

    //查询酒店设施
    public List<ItripSearchPolicyHotelVO> itripQueryHotelPolicy(Integer cityId) throws Exception;

    //查询酒店图片
    public List<ItripImageVO> itripQueryHotelImg(Integer integer) throws Exception;

}
