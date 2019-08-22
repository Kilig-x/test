package cn.itrip.service.hotelroom;

import cn.itrip.beans.pojo.ItripHotelRoom;
import cn.itrip.beans.vo.ItripImageVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.beans.vo.hotelroom.ItripHotelRoomVO;
import cn.itrip.beans.vo.hotelroom.SearchHotelRoomVO;
import cn.itrip.dao.hotelroom.ItripHotelRoomMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItripRoomServiceImpl implements ItripRoomService {
    @Resource
    private ItripHotelRoomMapper itripHotelRoomMapper;

    @Override
    public List<ItripImageVO> findItripHotelImg(Integer integer) throws Exception {
        return itripHotelRoomMapper.getItripHotelImg(integer);
    }

    @Override
    public List<ItripHotelRoomVO> findItripHotelRoomBy(SearchHotelRoomVO searchHotelRoomVO)  {
        return itripHotelRoomMapper.getItripQueryHotelRoomByHotel(searchHotelRoomVO);
    }

    @Override

    public List<ItripLabelDicVO> findHotelLabelDicVO() throws Exception {
        return itripHotelRoomMapper.getHotelLabelDicVO();
    }


}
