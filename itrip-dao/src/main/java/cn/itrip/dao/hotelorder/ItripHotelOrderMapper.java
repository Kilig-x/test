package cn.itrip.dao.hotelorder;

import cn.itrip.beans.vo.order.ItripListHotelOrderVO;
import cn.itrip.beans.vo.order.ItripPersonalHotelOrderVO;
import cn.itrip.beans.vo.order.ItripPersonalOrderRoomVO;
import cn.itrip.beans.vo.order.ItripSearchOrderVO;

import java.util.List;

public interface ItripHotelOrderMapper {

    public List<ItripPersonalOrderRoomVO> getPersonalOrderRoomInfo(Integer integer) throws Exception;

    public ItripPersonalHotelOrderVO getPpersonalOrderInfo(Integer integer) throws Exception;

    public List<ItripListHotelOrderVO> getPersonalOrderList(ItripSearchOrderVO vo);

    public int getOrderCount();
}
