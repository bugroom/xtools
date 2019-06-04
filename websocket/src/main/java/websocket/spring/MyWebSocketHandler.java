package websocket.spring;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * Socket处理器
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {
	
	public static final Map<String, WebSocketSession> SOCKET_SESSION_MAP =
			new ConcurrentHashMap<String, WebSocketSession>();

	/**
	 * 建立连接后
	 */
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		String id = session.getId();
		System.out.println("客户端-" + id + " 连接成功");
		if (SOCKET_SESSION_MAP.get(id) == null) {
			SOCKET_SESSION_MAP.put(id, session);
		}
	}

	/**
	 * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	 */
	public void handleMessage(WebSocketSession session,
			WebSocketMessage<?> message) throws Exception {
		String id = session.getId();
		System.out.println("收到客户端-" + id + "的消息：" + message.getPayload());
		sendMessageToUser(id, new TextMessage("服务端收到信息：" + message.getPayload()));
	}

	/**
	 * 消息传输错误处理
	 */
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		
	}

	/**
	 * 关闭连接后
	 */
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) throws Exception {
		String id = session.getId();
		System.out.println("Websocket:" + id + "已经关闭");
		SOCKET_SESSION_MAP.remove(id);
	}

	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 给所有在线用户发送消息
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void broadcast(TextMessage message) throws IOException {
		for (Map.Entry<String, WebSocketSession> entry : SOCKET_SESSION_MAP.entrySet()) {
			WebSocketSession session = entry.getValue();
			if (session.isOpen()) {
				session.sendMessage(message);
			}
		}
	}

	/**
	 * 给某个用户发送消息
	 * 
	 * @param userName
	 * @param message
	 * @throws IOException
	 */
	public void sendMessageToUser(String id, TextMessage message)
			throws IOException {
		WebSocketSession session = SOCKET_SESSION_MAP.get(id);
		if (session != null && session.isOpen()) {
			session.sendMessage(message);
		}
	}
}