package com.kamfu.test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.kamfu.Application;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.LoginParam;
import com.kamfu.model.UnbindParam;

/**
 * 测试任务
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTemplateTests {
	private static final Logger logger = LoggerFactory.getLogger(RestTemplateTests.class);
	/**
	 * @LocalServerPort 提供了 @Value("${local.server.port}") 的代替
	 */
	@LocalServerPort
	private int port;
	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void testRestTemplate() {

		logger.info("解绑成功后推送消息给对应的POS机");
		LoginParam param = new LoginParam();
		param.setUsername("admin");
		param.setPassword("111111");
		String loginUrl = String.format("http://localhost:8080/login", port);
		BaseResponse r = restTemplate.postForObject(loginUrl, param, BaseResponse.class);
		System.out.println(r.getMsg());

		logger.info("推送消息登录认证成功");
		String token = (String) r.getData();
		UnbindParam unbindParam = new UnbindParam();
		unbindParam.setImei("imei");
		unbindParam.setLocation("location");
		// 设置HTTP Header信息
		String unbindUrl = String.format("http://localhost:%d/api/v1/unbind", port);
		URI uri;
		try {
			uri = new URI(unbindUrl);
		} catch (URISyntaxException e) {
			logger.error("URI构建失败", e);
			throw new RuntimeException("URI构建失败");
		}
		RequestEntity<UnbindParam> requestEntity = RequestEntity.post(uri).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).header("Authorization", token).body(unbindParam);
		ResponseEntity<BaseResponse> responseEntity = restTemplate.exchange(requestEntity, BaseResponse.class);
		BaseResponse r2 = responseEntity.getBody();
//		assertThat(r2.isSuccess(), is(true));
//		assertThat(r2.getData(), is("unbind"));
	}
}
