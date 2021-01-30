package com.guan.service.impl;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.apache.commons.lang3.StringUtils;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhengkai.blog.csdn.net
 */
@ServerEndpoint("/imserver/{userId}")
@Component
public class WebSocketServer {


  @PostConstruct
  public void init() {
    System.out.println("websocket 加载");
  }
  private static Logger log = LoggerFactory.getLogger(WebSocketServer.class);
  private static final AtomicInteger OnlineCount = new AtomicInteger(0);
  // concurrent包的线程安全Set，用来存放每个客户端对应的Session对象。
  private static CopyOnWriteArraySet<Session> SessionSet = new CopyOnWriteArraySet<Session>();


  /**
   * 连接建立成功调用的方法
   */
  @OnOpen
  public void onOpen(Session session) {
    SessionSet.add(session);
    int cnt = OnlineCount.incrementAndGet(); // 在线数加1

    SendMessage(session, "连接成功");
  }

  /**
   * 连接关闭调用的方法
   */
  @OnClose
  public void onClose(Session session) {
    SessionSet.remove(session);
    int cnt = OnlineCount.decrementAndGet();
    System.out.println(cnt);
  }

  /**
   * 收到客户端消息后调用的方法
   *
   * @param message
   *            客户端发送过来的消息
   */
  @OnMessage
  public void onMessage(String message, Session session) {

    SendMessage(session, "收到消息，消息内容："+message);

  }

  /**
   * 出现错误
   * @param session
   * @param error
   */
  @OnError
  public void onError(Session session, Throwable error) {
    error.printStackTrace();
  }

  /**
   * 发送消息，实践表明，每次浏览器刷新，session会发生变化。
   * @param session
   * @param message
   */
  public static void SendMessage(Session session, String message) {
    try {
      session.getBasicRemote().sendText(String.format("%s (From Server，Session ID=%s)",message,session.getId()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 群发消息
   * @param message
   * @throws IOException
   */
  public static void BroadCastInfo(String message) throws IOException {
    for (Session session : SessionSet) {
      if(session.isOpen()){
        SendMessage(session, message);
      }
    }
  }

  /**
   * 指定Session发送消息
   * @param sessionId
   * @param message
   * @throws IOException
   */
  public static void SendMessage(String message,String sessionId) throws IOException {
    Session session = null;
    for (Session s : SessionSet) {
      if(s.getId().equals(sessionId)){
        session = s;
        break;
      }
    }
    if(session!=null){
      SendMessage(session, message);
    }
    else{
      System.out.println("没有找到你指定ID的会话");
    }
  }
}