package com.qucheng.search;

import com.sun.org.apache.xpath.internal.operations.String;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestIndex {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Test
    public void  testCreateIndex() throws IOException {

        //1.获取连接
        IndicesClient indices = restHighLevelClient.indices();
        //2.创建请求对象
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("es_lao_user_12");
        //3.发起请求，获取相应对象
        CreateIndexResponse createIndexResponse = indices.create(createIndexRequest, RequestOptions.DEFAULT);
        //4.获取结果
        boolean acknowledged = createIndexResponse.isAcknowledged();
        //5.打印结果集
        System.out.println(acknowledged);


    }


}
