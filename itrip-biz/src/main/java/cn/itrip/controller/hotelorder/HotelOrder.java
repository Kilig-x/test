package cn.itrip.controller.hotelorder;


import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.beans.vo.order.ItripListHotelOrderVO;
import cn.itrip.beans.vo.order.ItripPersonalHotelOrderVO;
import cn.itrip.beans.vo.order.ItripPersonalOrderRoomVO;
import cn.itrip.beans.vo.order.ItripSearchOrderVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.ErrorCode;
import cn.itrip.common.Page;
import cn.itrip.common.ValidationToken;
import cn.itrip.service.hotelorder.ItripOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "API", basePath = "/http://api.itrap.com/api")
@RequestMapping(value = "/api/hotelorder", produces = "application/json; charset=utf-8")
public class HotelOrder {
    private Logger logger = Logger.getLogger(HotelOrder.class);

    @Resource
    public ItripOrderService itripOrderService;

    @Resource
    private ValidationToken validationToken;

    /**
     * 查询个人订单房型信息
     *
     * @param hotelId
     * @return
     */
    //以该地址作为父路径
    @RequestMapping(value = "/getpersonalorderroominfo/{hotelId}", method = RequestMethod.GET)
    //将方法的返回值以特定的格式写入到response的body区域
    @ResponseBody
    public Dto<ItripPersonalOrderRoomVO> getPersonalOrderRoomInfo(@PathVariable("hotelId") Integer hotelId) {
        logger.info("getimg>>>>>>>>>>>>>");
        List<ItripPersonalOrderRoomVO> list = null;
        try {
            list = itripOrderService.ItripPersonalOrderRoomInfo(hotelId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            return DtoUtil.returnFail("查询个人订单房型信息失败", "100401");
        }
        return DtoUtil.returnSuccess("查询个人订单房型信息", list);
    }

    /**
     * 获取个人订单信息
     *
     * @return
     */
    @ResponseBody
    public Dto<ItripPersonalHotelOrderVO> getpersonalorderinfo(@PathVariable("orderId") Integer orderId) {
        logger.debug("getpersonalorderinfo>>>>");
        try {
            ItripPersonalHotelOrderVO itripPersonalHotelOrderVO = itripOrderService.ItripPpersonalOrderInfo(orderId);
            Map map = new HashMap();
            map.put("1", "订单提交");
            map.put("2", "订单支付");
            map.put("3", "支付成功");
            map.put("4", "入住");
            map.put("5", "订单点评");
            map.put("6", "订单完成");
            itripPersonalHotelOrderVO.setOrderProcess(map);
            itripPersonalHotelOrderVO.setProcessNode(map.size() + "");
            return DtoUtil.returnSuccess("获取个人订单信息成功", itripPersonalHotelOrderVO);
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("系统异常", ErrorCode.AUTH_UNKNOWN);
        }
    }

    /**
     * 查询个人酒店订单列表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getpersonalorderlist", method = RequestMethod.POST)
    @ResponseBody
    public Dto<Page<ItripListHotelOrderVO>> getPersonalOrderList(@RequestBody ItripSearchOrderVO vo, HttpServletRequest request) {
        String token = request.getHeader("token");
        ItripUser date = validationToken.getCurrentUser(token);
        vo.setUserId(date.getId());
        List<ItripListHotelOrderVO> list = itripOrderService.ItiprPersonalOrderList(vo);
        int count = itripOrderService.ItriporderCount();
        Page<ItripListHotelOrderVO> page = new Page<>(vo.getPageNo(), vo.getPageSize(), count);
        page.setRows(list);
        if (null != date) {
            if (page == null) {
                return DtoUtil.returnFail("获取个人订单信息失败", "100401");
            }
            return DtoUtil.returnSuccess("获取个人订单信息", page);
        } else {
            return DtoUtil.returnFail("token失效，请重新登录", "100000");
        }
    }

}
