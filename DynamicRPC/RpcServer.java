package DynamicRPC;

import java.io.IOException;

/**
 * Created by wangyaowen01 on 2018/6/7.
 */
public class RpcServer {
	public static void main(String[] args) {
		try {
			//暴露服务
			HelloService service = new HelloServiceImpl();
			RpcFramework.export(service, 8989);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 服务端对接口的具体实现
	 */
	private static class HelloServiceImpl implements HelloService {
		@Override
		public String sayHello(String msg) {
			String result = "hello world " + msg;
			System.out.println(result);
			return result;
		}
	}

}
