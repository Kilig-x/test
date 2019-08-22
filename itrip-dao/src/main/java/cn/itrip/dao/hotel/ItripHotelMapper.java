package cn.itrip.dao.hotel;

import cn.itrip.beans.pojo.ItripHotelTradingArea;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.beans.vo.ItripAreaDicVO;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;

import cn.itrip.beans.vo.hotel.HotelVideoDescVO;
import cn.itrip.beans.vo.hotel.ItripSearchDetailsHotelVO;
import cn.itrip.beans.vo.hotel.ItripSearchFacilitiesHotelVO;
import cn.itrip.beans.vo.hotel.ItripSearchPolicyHotelVO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ItripHotelMapper {
    public List<ItripAreaDicVO> getQueryHotcity(@Param("cityId") Integer cityId) throws Exception;

    public List<ItripLabelDicVO> getItripQueryHotelFeatures() throws Exception;

    public List<ItripHotelTradingArea> getItripQueryTradearea(@Param("cityId") Integer cityId) throws Exception;

    public String getItripHotelName(@Param("cityId") Integer cityId) throws Exception;

    public List<String> getItripHotelFeatureList(@Param("cityId") Integer cityId) throws Exception;

    public List<String> getItripTradingAreaNameList(@Param("cityId") Integer cityId) throws Exception;

    public List<ItripLabelDic> getItripQueryHotelDetails(@Param("cityId") Integer cityId) throws Exception;

    public List<ItripSearchFacilitiesHotelVO> getItripQueryHotelFacilities(@Param("cityId") Integer cityId) throws Exception;

    public List<ItripSearchPolicyHotelVO> getItripQueryHotelPolicy(@Param("cityId") Integer cityId) throws Exception;

    public List<ItripImageVO> getItripHotelImg(@Param("roomId") Integer roomId) throws Exception;


}
