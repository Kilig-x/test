package service;

import cn.itrip.beans.vo.hotel.ItripHotelVO;
import cn.itrip.beans.vo.hotel.SearchHotelVO;
import cn.itrip.common.Page;
import cn.itrip.service.SearchHotelService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSearchHotelService {

    @Test
    public void TestSearchItripHotelListByHotCity() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        SearchHotelService searchHotelService = ctx.getBean(SearchHotelService.class);
        List<ItripHotelVO> list = searchHotelService.searchItripHotelListByHotCity(2, 6);
        System.out.println(list.size());
        for (ItripHotelVO itripHotelVO : list) {
            System.out.println(itripHotelVO.getId() + " " + itripHotelVO.getHotelName());
        }
    }


    @Test
    public void TestSearchItripHotelPage() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        SearchHotelService searchHotelService = ctx.getBean(SearchHotelService.class);
        SearchHotelVO searchHotelVO = new SearchHotelVO();
        searchHotelVO.setDestination("北京市");
        Page<ItripHotelVO> page = searchHotelService.searchItripHotelPage(searchHotelVO, 2, 5);
        System.out.println("page>>>" + page);
    }
}
