package DynamicRPC;

/**
 * Created by wangyaowen01 on 2018/6/7.
 */
public class RpcClient {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				rpcInvoke("client1");
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				rpcInvoke("client2");
			}
		}).start();

	}

	public static void rpcInvoke(String from) {
		try {
			int size = 20;
			//引用服务
			HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 8989);
			for (int i = 0; i < size; i++) {
				String hello = service.sayHello("rpc " + from + " " + i);
				System.out.println(hello);
				//Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
