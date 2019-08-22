package cn.itrip.dao.hotelroom;

import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.hotelroom.ItripHotelRoomVO;
import cn.itrip.beans.vo.hotelroom.SearchHotelRoomVO;

import java.util.List;

public interface ItripHotelRoomMapper {
    public List<ItripImageVO> getItripHotelImg(Integer integer) throws Exception;

    public List<ItripHotelRoomVO> getItripQueryHotelRoomByHotel(SearchHotelRoomVO searchHotelRoomVO);

    public List<ItripLabelDicVO> getHotelLabelDicVO() throws Exception;

}
