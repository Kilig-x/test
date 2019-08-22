package cn.itrip.service;

import cn.itrip.ItripHotelVO;
import cn.itrip.beans.vo.hotel.SearchHotelVO;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import cn.itrip.solrutils.Utils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author MXY
 * @date 2019/8/1 - 16:33
 */


@Service
public class ItripHotelListServiceImp implements ItripHotelListService {

    public static String url = "http://localhost:8083/solr/hotel";

    Utils utils = new Utils();
    HttpSolrClient httpSolrClient;

    {
        httpSolrClient = new HttpSolrClient(url);
        // 设置响应解析器
        httpSolrClient.setParser(new XMLResponseParser());
        // 建立连接的最长时间
        httpSolrClient.setConnectionTimeout(500);
    }


    @Override
    public List getItripHotelList(String cityId, int count) throws Exception {
        //初始化SolrQuery 模糊查找(SolrQuery query = new SolrQuery("address:天安门");)
        String q = "cityId:" + cityId;
        ModifiableSolrParams params = new ModifiableSolrParams();
        params.set("q", q);//*.* 表示查询条件
        //params.set("defType", "edismax");
        params.set("start", "0");//查询开始的索引
        params.set("rows", count);//查询条数
        QueryResponse queryResponse = null;
        List list = null;
        try {
            queryResponse = httpSolrClient.query(params);
            list = queryResponse.getBeans(ItripHotelVO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Page<ItripHotelVO> getItripHotelPage(SearchHotelVO vo) throws Exception {
        if(vo.getPageNo()==null){
            vo.setPageNo(1);
            vo.setPageSize(6);
        }
        SolrQuery solrQuery = new SolrQuery();
        Page page = null;
        try {
            solrQuery.setQuery("*:*");
            solrQuery.setSort(EmptyUtils.isEmpty(vo.getAscSort()) ? "id" : vo.getAscSort(), SolrQuery.ORDER.desc);
            solrQuery.addFilterQuery("destination:" + (EmptyUtils.isEmpty(vo.getDestination()) ? "*" : vo.getDestination()));
            solrQuery.addFilterQuery("hotelLevel:" + (EmptyUtils.isEmpty(vo.getHotelLevel()) || vo.getHotelLevel() == 0 ? "*" : vo.getHotelLevel()));
            solrQuery.addFilterQuery("keyword:" + (EmptyUtils.isEmpty(vo.getKeywords()) ? "*" : vo.getKeywords()));
            solrQuery.addFilterQuery("minPrice:[" + ((EmptyUtils.isEmpty(vo.getMinPrice()) || vo.getMinPrice() == 0) ? 0 : vo.getMinPrice()) + " TO " + Double.POSITIVE_INFINITY + "]");
            solrQuery.addFilterQuery("maxPrice:[" + 0 + " TO " + ((EmptyUtils.isEmpty(vo.getMaxPrice()) || vo.getMaxPrice() == 0) ? Double.POSITIVE_INFINITY : vo.getMaxPrice()) + "]");
            solrQuery.setStart(vo.getPageNo());
            solrQuery.setRows(vo.getPageSize());
            List<ItripHotelVO> list = utils.queryList(solrQuery, ItripHotelVO.class);
            page = new Page(vo.getPageNo(), vo.getPageSize(), getCount(vo));
            page.setRows(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    public Integer getCount(SearchHotelVO vo) {
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");
        query.addFilterQuery("destination:" + (EmptyUtils.isEmpty(vo.getDestination()) ? "*" : vo.getDestination()));
        query.addFilterQuery("hotelLevel:" + (EmptyUtils.isEmpty(vo.getHotelLevel()) || vo.getHotelLevel() == 0 ? "*" : vo.getHotelLevel()));
        query.addFilterQuery("keyword:" + (EmptyUtils.isEmpty(vo.getKeywords()) ? "*" : vo.getKeywords()));
        query.addFilterQuery("minPrice:[" + ((EmptyUtils.isEmpty(vo.getMinPrice()) || vo.getMinPrice() == 0) ? 0 : vo.getMinPrice()) + " TO " + Double.POSITIVE_INFINITY + "]");
        query.addFilterQuery("maxPrice:[" + 0 + " TO " + ((EmptyUtils.isEmpty(vo.getMaxPrice()) || vo.getMaxPrice() == 0) ? Double.POSITIVE_INFINITY : vo.getMaxPrice()) + "]");
        List<ItripHotelVO> list = utils.queryList(query, ItripHotelVO.class);
        System.out.println(list.size());
        return list.size();
    }

    public static void main(String[] args) {
        ItripHotelListServiceImp itripHotelListServiceImp=new ItripHotelListServiceImp();
        System.out.println(itripHotelListServiceImp.getCount(null));
    }
}
