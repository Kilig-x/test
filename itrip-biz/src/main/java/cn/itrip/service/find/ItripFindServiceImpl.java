package cn.itrip.service.find;

import cn.itrip.beans.pojo.ItripHotelTradingArea;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.beans.vo.ItripAreaDicVO;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.hotel.ItripSearchDetailsHotelVO;
import cn.itrip.beans.vo.hotel.ItripSearchFacilitiesHotelVO;
import cn.itrip.beans.vo.hotel.ItripSearchPolicyHotelVO;
import cn.itrip.dao.hotel.ItripHotelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItripFindServiceImpl implements ItripFindService {
    @Resource
    private ItripHotelMapper itripHotelMapper;


    public List<ItripAreaDicVO> itripQueryHotcity(Integer cityId) throws Exception {
        return itripHotelMapper.getQueryHotcity(cityId);
    }

    public List<ItripLabelDicVO> itripQueryHotelFeatures() throws Exception {

        return itripHotelMapper.getItripQueryHotelFeatures();
    }

    public List<ItripHotelTradingArea> itripQueryTradearea(Integer cityId) throws Exception {
        return itripHotelMapper.getItripQueryTradearea(cityId);
    }

    public String getItripHotelName(Integer cityId) throws Exception {
        return itripHotelMapper.getItripHotelName(cityId);
    }

    public List<String> getItripHotelFeatureList(Integer cityId) throws Exception {
        return itripHotelMapper.getItripHotelFeatureList(cityId);
    }

    public List<String> getItripTradingAreaNameList(Integer cityId) throws Exception {
        return itripHotelMapper.getItripTradingAreaNameList(cityId);
    }

    public List<ItripLabelDic> itripQueryHotelDetails(Integer cityId) throws Exception {
        return itripHotelMapper.getItripQueryHotelDetails(cityId);
    }

    public List<ItripSearchFacilitiesHotelVO> itripQueryHotelFacilities(Integer cityId) throws Exception {
        return itripHotelMapper.getItripQueryHotelFacilities(cityId);
    }

    public List<ItripSearchPolicyHotelVO> itripQueryHotelPolicy(Integer cityId) throws Exception {
        return itripHotelMapper.getItripQueryHotelPolicy(cityId);
    }

    @Override
    public List<ItripImageVO> itripQueryHotelImg(Integer integer) throws Exception {
        return itripHotelMapper.getItripHotelImg(integer);
    }

}
