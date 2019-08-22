package cn.itrip.solrutils;

import cn.itrip.ItripHotelVO;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.IOException;
import java.util.List;

public class Utils {
    HttpSolrClient httpSolrClient;

    QueryResponse response = new QueryResponse();

    public static String url = "http://localhost:8083/solr/hotel";

    {
        httpSolrClient = new HttpSolrClient(url);
        // 设置响应解析器
        httpSolrClient.setParser(new XMLResponseParser());
        // 建立连接的最长时间
        httpSolrClient.setConnectionTimeout(500);
    }


    public List<ItripHotelVO> queryList(SolrQuery query, Class clazz) {
        List<ItripHotelVO> list = null;
        try {
            response = httpSolrClient.query(query);
            list = response.getBeans(clazz);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
