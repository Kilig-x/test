package cn.itrip.service;

import cn.itrip.ItripHotelVO;
import cn.itrip.beans.vo.hotel.SearchHotelVO;
import cn.itrip.common.Page;

import java.util.List;

public interface ItripHotelListService {
    public List getItripHotelList(String cityId, int count) throws Exception;

    public Page<ItripHotelVO> getItripHotelPage(SearchHotelVO vo) throws Exception;

    public Integer getCount(SearchHotelVO vo);

}
