package com.example.projectIot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app"); // Dòng này đặt tiền tố cho các địa chỉ đích (destination) mà máy khách sẽ sử dụng
        // để gửi các yêu cầu hoặc tin nhắn đến máy chủ thông qua WebSocket. Điều này có nghĩa rằng các máy khách sẽ sử dụng địa chỉ
        // bắt đầu bằng "/app" để gửi các yêu cầu của họ đến máy chủ WebSocket.


        registry.enableSimpleBroker("/topic", "/user"); // tạo Broker đơn giản này sẽ giúp máy chủ gửi tin nhắn đến các địa chỉ đích được định nghĩa (destination)
        // trong đó /topic để máy chủ gửi đến tất cả máy khách đang sub vào chủ đề này
        // còn /user để máy chủ gửi riêng đến 1 user nào đó

        registry.setUserDestinationPrefix("/user"); // đặt tiền tố ("/user") cho các địa chỉ đích của các tin nhắn riêng tư.(có nghiã là muốn gửi tin nhắn vào địa chỉ đích
        // thì thêm /user (Cụ thể, khi máy khách gửi một tin nhắn riêng tư, địa chỉ đích của tin nhắn sẽ được tạo ra
        // bắt đầu bằng "/user" và sau đó thêm các thông tin cụ thể về người dùng)

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}
