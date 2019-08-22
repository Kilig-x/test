package cn.itrip;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.util.List;

public class Test {
    public static String url = "http://localhost:8083/solr/hotel/";

    public static void main(String[] args) {
        //初始化HttpSolrClient
        HttpSolrClient httpSolrClient = new HttpSolrClient(url);
        // 设置响应解析器
        httpSolrClient.setParser(new XMLResponseParser());
        // 建立连接的最长时间
        httpSolrClient.setConnectionTimeout(500);


        //初始化SolrQuery 模糊查找(SolrQuery query = new SolrQuery("address:天安门");)
        SolrQuery query = new SolrQuery("*:*");

        QueryResponse queryResponse = null;
        try {
            queryResponse = httpSolrClient.query(query);
            List<ItripHotelVO> list = queryResponse.getBeans(ItripHotelVO.class);
            for (ItripHotelVO itripHotelVO : list) {
                System.out.println(itripHotelVO.getId() + itripHotelVO.getHotelName() + itripHotelVO.getAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
