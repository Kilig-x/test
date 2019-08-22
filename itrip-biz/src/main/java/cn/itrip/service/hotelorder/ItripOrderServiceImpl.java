package cn.itrip.service.hotelorder;

import cn.itrip.beans.vo.order.ItripListHotelOrderVO;
import cn.itrip.beans.vo.order.ItripPersonalHotelOrderVO;
import cn.itrip.beans.vo.order.ItripPersonalOrderRoomVO;
import cn.itrip.beans.vo.order.ItripSearchOrderVO;
import cn.itrip.common.Page;
import cn.itrip.dao.hotelorder.ItripHotelOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItripOrderServiceImpl implements ItripOrderService {

    @Resource
    private ItripHotelOrderMapper itripHotelOrderMapper;

    @Override
    public List<ItripPersonalOrderRoomVO> ItripPersonalOrderRoomInfo(Integer integer) throws Exception {
        return itripHotelOrderMapper.getPersonalOrderRoomInfo(integer);
    }

    @Override
    public ItripPersonalHotelOrderVO ItripPpersonalOrderInfo(Integer integer) throws Exception {
        return itripHotelOrderMapper.getPpersonalOrderInfo(integer);
    }

    @Override
    public List<ItripListHotelOrderVO> ItiprPersonalOrderList(ItripSearchOrderVO vo) {
        vo.setPageNo((vo.getPageNo() - 1) * vo.getPageSize() + 1);
        return itripHotelOrderMapper.getPersonalOrderList(vo);
    }

    @Override
    public int ItriporderCount() {
        return itripHotelOrderMapper.getOrderCount();
    }
}
