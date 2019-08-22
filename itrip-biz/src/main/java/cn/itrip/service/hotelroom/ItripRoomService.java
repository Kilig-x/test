package cn.itrip.service.hotelroom;

import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.hotelroom.ItripHotelRoomVO;
import cn.itrip.beans.vo.hotelroom.SearchHotelRoomVO;

import java.util.List;

public interface ItripRoomService {

    //查询酒店房型图片
    public List<ItripImageVO> findItripHotelImg(Integer integer) throws Exception;

    //查询酒店房型列表
    public List<ItripHotelRoomVO> findItripHotelRoomBy(SearchHotelRoomVO searchHotelRoomVO);

    //查询酒店床型
    public List<ItripLabelDicVO> findHotelLabelDicVO() throws Exception;


}
