package cn.itrip.service.hotelorder;

import cn.itrip.beans.vo.order.ItripListHotelOrderVO;
import cn.itrip.beans.vo.order.ItripPersonalHotelOrderVO;
import cn.itrip.beans.vo.order.ItripPersonalOrderRoomVO;
import cn.itrip.beans.vo.order.ItripSearchOrderVO;
import cn.itrip.common.Page;

import java.util.List;

public interface ItripOrderService {

    public List<ItripPersonalOrderRoomVO> ItripPersonalOrderRoomInfo(Integer integer) throws Exception;

    public ItripPersonalHotelOrderVO ItripPpersonalOrderInfo(Integer integer) throws Exception;

    public List<ItripListHotelOrderVO> ItiprPersonalOrderList(ItripSearchOrderVO vo);

    public int ItriporderCount();
}
