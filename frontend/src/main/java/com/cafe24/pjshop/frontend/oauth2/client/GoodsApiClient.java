//package com.cafe24.pjshop.frontend.oauth2.client;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class GoodsApiClient {
//	
//	@Autowired
//	private OAuth2RestTemplate oAuth2RestTemplate;

	
//	private final String API_URL = "http://localhost:8888/v1/hello";
//	
//	private String accessToken;
//	private RestTemplate apiRestTemplate;
//	
//	
//	// ���ʿ� AccessToken �߱��� �����ϰ�, SuccessHandler�� ���ؼ� �� �޼ҵ尡 ȣ�� �ȴ�.
//	public void init(OAuth2AccessToken accessToken) {
//		this.accessToken = accessToken.getValue();
//	}
//	
//	
//	// ���ϴ� Api�� ��ü�� ��� ���� �޼ҵ� �Ķ���ͷ� �Է��� class Ÿ������ Api��ü�� �����Ͽ� ��ȯ
//	public <T> T getOperation(Class<T> operation) 
//			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//
//		// �������� ���� restTemplate ����.
//		
//		apiRestTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
//		apiRestTemplate.setInterceptors(Arrays.asList( new ClientHttpRequestInterceptor() {
//			@Override
//			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
//					throws IOException {
//				HttpRequest protectedResourceRequest = new HttpRequestWrapper(request);
//				protectedResourceRequest.getHeaders().set("Authorization", "Bearer " + accessToken);
//				protectedResourceRequest.getHeaders().set("Content-Type", "application/json");
//				
//				return execution.execute(protectedResourceRequest, body);
//			}
//		}));
//		
//		Constructor<T> constructor = operation.getConstructor(RestTemplate.class, String.class);
//		T returnObject = constructor.newInstance(apiRestTemplate, API_URL);
//		
//		return returnObject;
//	}
//}
